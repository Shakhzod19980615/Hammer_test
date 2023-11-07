package com.example.hammer_test.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammer_test.R
import com.example.hammer_test.databinding.MenuCategoryItemBinding
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel


class MenuCategoryListAdapter(
    private val layoutInflater: LayoutInflater,
    val onItemClick: (name : String) -> Unit,
):RecyclerView.Adapter<MenuCategoryListAdapter.ViewHolder>() {
    private  val categoryListItem : MutableList<SubCategoryListModel> = mutableListOf()
    private var selectedCategoryIndex = 0

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuCategoryListAdapter.ViewHolder {
        val binding = MenuCategoryItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onBindViewHolder(holder: MenuCategoryListAdapter.ViewHolder, position: Int) {

        holder.bindData(categoryListItem=categoryListItem[position])

        if (selectedCategoryIndex == position) {
            holder.itemView.setBackgroundResource(R.drawable.tab_selected_bg)

        } else {
            holder.itemView.setBackgroundResource(R.drawable.tab_unselected_bg)

        }
    }

    override fun getItemCount(): Int {
        return categoryListItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(categoryListItem : List<SubCategoryListModel>){
        this.categoryListItem.clear()
        this.categoryListItem.addAll(categoryListItem)
        notifyDataSetChanged()
    }

    @SuppressLint("NotifyDataSetChanged")
    inner class ViewHolder(
        private val binding: MenuCategoryItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        @SuppressLint("ResourceAsColor")
        fun bindData(categoryListItem: SubCategoryListModel){
            binding.categoryName.text = categoryListItem.title
            if(selectedCategoryIndex == bindingAdapterPosition){
                binding.categoryName.setTextColor(Color.parseColor("#FD3A69"))
            }else{
                binding.categoryName.setTextColor(Color.parseColor("#7B7B7B"))
            }
        }

        init {
            itemView.setOnClickListener {
                val item =categoryListItem[bindingAdapterPosition]
                onItemClick(item.keyword)
                selectedCategoryIndex = bindingAdapterPosition
                notifyDataSetChanged()
            }

        }

    }

}