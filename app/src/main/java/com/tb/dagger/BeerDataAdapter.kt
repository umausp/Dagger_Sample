package com.tb.dagger

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tb.dagger.databinding.AnotherBeerLayoutItemBinding
import com.tb.dagger.databinding.BeerItemLayoutBinding
import com.tb.dagger.model.BeerDataModelItem
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class BeerDataAdapter @Inject constructor(private val fragmentPosition : Int) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var data=  ArrayList<BeerDataModelItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if(fragmentPosition == 0) {
            ViewHolder(
                BeerItemLayoutBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        } else {
            AnotherViewHolder(
                AnotherBeerLayoutItemBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if(holder.itemViewType == 0){
            (holder as ViewHolder).bind(data[position])
        } else {
            (holder as AnotherViewHolder).bind(data[position])
        }
    }

    override fun getItemCount(): Int = data.size

    override fun getItemViewType(position: Int): Int {
        return fragmentPosition
    }

    inner class ViewHolder(private val binding: BeerItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: BeerDataModelItem) {
            binding.apply {
                itemData.also { (imageData, nameData) ->
                    name.text = nameData
                    Glide.with(binding.root.context).load(imageData).into(image)
                }
            }
        }
    }

    inner class AnotherViewHolder(private val binding: AnotherBeerLayoutItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(itemData: BeerDataModelItem) {
            binding.apply {
                itemData.also { (imageData, nameData) ->
                    name.text = nameData
                    Glide.with(binding.root.context).load(imageData).into(image)
                }
            }
        }
    }
}

