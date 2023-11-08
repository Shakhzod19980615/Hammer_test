package com.example.hammer_test.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammer_test.databinding.BannerItemBinding
import com.example.hammer_test.domain.model.bannerModel.BannerModel


class BannerListAdapter(
    private val layoutInflater: LayoutInflater,

):RecyclerView.Adapter<BannerListAdapter.ViewHolder>() {
    private  val bannerListItem : MutableList<BannerModel> = mutableListOf()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val binding = BannerItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BannerListAdapter.ViewHolder, position: Int) {
        holder.bindData(bannerItem=bannerListItem[position])
    }

    override fun getItemCount(): Int {
        return bannerListItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(categoryListItem : List<BannerModel>){
        this.bannerListItem.clear()
        this.bannerListItem.addAll(categoryListItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding :BannerItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(bannerItem: BannerModel){

            Glide.with(binding.root).load(bannerItem.image).into(binding.bannerImage)
        }

    }

}