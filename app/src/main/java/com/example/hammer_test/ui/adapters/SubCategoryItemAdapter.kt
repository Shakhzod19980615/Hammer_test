package com.example.hammer_test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammer_test.databinding.MenuItemBinding
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel


class SubCategoryItemAdapter(
    private val layoutInflater: LayoutInflater,
    ) :RecyclerView.Adapter<SubCategoryItemAdapter.ViewHolder>() {

    private val subCategoryItemList : MutableList<SubCategoryItemModel> = mutableListOf()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): SubCategoryItemAdapter.ViewHolder {
        val binding = MenuItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SubCategoryItemAdapter.ViewHolder, position: Int) {
        holder.bindData(subCategoryItemModel = subCategoryItemList[position])

            /*holder.itemView.visibility = View.GONE
            holder.itemView.layoutParams = RecyclerView.LayoutParams(0,0)*/

    }

    override fun getItemCount(): Int {
        return subCategoryItemList.size
    }
    fun setItems(subCategoryItemList: List<SubCategoryItemModel>){
        this.subCategoryItemList.clear()
        this.subCategoryItemList.addAll(subCategoryItemList)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding : MenuItemBinding,
    ) : RecyclerView.ViewHolder(binding.root){
        fun bindData(subCategoryItemModel:SubCategoryItemModel) {
            binding.itemName.text = subCategoryItemModel.name
            binding.itemPrice.text = subCategoryItemModel.price
            Glide.with(binding.root).load(subCategoryItemModel.image).into(binding.itemImage)

        }

    }


}