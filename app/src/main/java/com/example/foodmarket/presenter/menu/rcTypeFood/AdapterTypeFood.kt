package com.example.foodmarket.presenter.menu.rcTypeFood

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarket.R
import com.example.foodmarket.databinding.ItemTypeFoodBinding
import com.example.foodmarket.entity.Constance
import com.example.foodmarket.entity.TypeFoodItem

class AdapterTypeFood : ListAdapter<TypeFoodItem, TypeFoodViewHolder>(TypeFoodDiffutilCallBack()){
    private var selectType=0

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypeFoodViewHolder {
        return TypeFoodViewHolder(ItemTypeFoodBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: TypeFoodViewHolder, position: Int) {
        val item=getItem(position)
        with(holder.binding){
          txtType.text=item.type
        }
        if(position == selectType){
            holder.binding.root.setBackgroundResource(R.drawable.select_type)
            holder.binding.txtType.setTextColor(Color.parseColor(Constance.PINK_COLOR_TXT))
        }else{
            holder.binding.root.setBackgroundResource(R.drawable.shadow)
            holder.binding.txtType.setTextColor(Color.parseColor(Constance.GRAY_COLOR_TXT))
        }


        holder.binding.root.setOnClickListener {
            holder.binding.root.setBackgroundResource(R.drawable.select_type)
            holder.binding.txtType.setTextColor(Color.parseColor(Constance.PINK_COLOR_TXT))
            selectType=holder.layoutPosition
            notifyDataSetChanged()
        }
    }

}


class TypeFoodViewHolder(val binding: ItemTypeFoodBinding): RecyclerView.ViewHolder(binding.root)

class TypeFoodDiffutilCallBack: DiffUtil.ItemCallback<TypeFoodItem>(){
    override fun areItemsTheSame(oldItem: TypeFoodItem, newItem: TypeFoodItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: TypeFoodItem, newItem: TypeFoodItem): Boolean {
        return oldItem==newItem
    }

}