package com.example.foodmarket.presenter.menu.rcFood

import android.R
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.foodmarket.databinding.PizzaItemBinding
import com.example.foodmarket.entity.pizza.PizzaItem


class AdapterFood : ListAdapter<PizzaItem, FoodViewHolder>(FoodDiffutilCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(PizzaItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val item=getItem(position)
       with(holder.binding){
           name.text=item.name
           info.text=item.description
           price.text="от ${item.price.toString()} р"
           Glide.with(imagePizza.context).load(item.img).error(com.example.foodmarket.R.drawable.pizza_error).centerInside().into(imagePizza)
       }
    }
}


class FoodViewHolder(val binding: PizzaItemBinding): RecyclerView.ViewHolder(binding.root)

class FoodDiffutilCallBack: DiffUtil.ItemCallback<PizzaItem>() {
    override fun areItemsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: PizzaItem, newItem: PizzaItem): Boolean {
        return oldItem == newItem
    }
}
