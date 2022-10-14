package com.example.foodmarket.presenter.menu.rcMarketing

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.foodmarket.databinding.ItemMarketingBinding
import com.example.foodmarket.databinding.ItemTypeFoodBinding
import com.example.foodmarket.entity.MarketingItem
import com.example.foodmarket.entity.TypeFoodItem
import com.example.foodmarket.presenter.menu.rcTypeFood.TypeFoodDiffutilCallBack
import com.example.foodmarket.presenter.menu.rcTypeFood.TypeFoodViewHolder

class AdapterMarketing : ListAdapter<MarketingItem, MarketingViewHolder>(MarketingDiffutilCallBack()){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarketingViewHolder {
        return MarketingViewHolder(ItemMarketingBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MarketingViewHolder, position: Int) {
        val item=getItem(position)
        with(holder.binding){
            imgMarketing.setImageResource(item.src)
        }
    }
}


class MarketingViewHolder(val binding: ItemMarketingBinding): RecyclerView.ViewHolder(binding.root)

class MarketingDiffutilCallBack: DiffUtil.ItemCallback<MarketingItem>(){
    override fun areItemsTheSame(oldItem: MarketingItem, newItem: MarketingItem): Boolean {
        return oldItem.id==newItem.id
    }

    override fun areContentsTheSame(oldItem: MarketingItem, newItem: MarketingItem): Boolean {
        return oldItem==newItem
    }

}