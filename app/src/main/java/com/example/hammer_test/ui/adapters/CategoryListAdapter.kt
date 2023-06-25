package com.example.hammer_test.ui.adapters

import android.annotation.SuppressLint
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammer_test.databinding.CategoryItemBinding
import com.example.restaurant_test.domain.model.categoryModel.CategoryItemModel


class CategoryListAdapter(
    private val layoutInflater: LayoutInflater,
    //val onItemClick: (name : String) -> Unit,
    //private val context: Context
):RecyclerView.Adapter<CategoryListAdapter.ViewHolder>() {
    private  val categoryListItem : MutableList<CategoryItemModel> = mutableListOf()
    val displayMetrics = DisplayMetrics()
    private var screenWidth = 1000
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CategoryListAdapter.ViewHolder {
        val binding = CategoryItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryListAdapter.ViewHolder, position: Int) {
        /*val layoutParams: ViewGroup.LayoutParams = holder.itemView.getLayoutParams()
        layoutParams.width = (screenWidth/1.2).toInt()
        holder.itemView.layoutParams*/
        holder.bindData(categoryListItem=categoryListItem[position])
    }

    override fun getItemCount(): Int {
        return categoryListItem.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(categoryListItem : List<CategoryItemModel>){
        this.categoryListItem.clear()
        this.categoryListItem.addAll(categoryListItem)
        notifyDataSetChanged()
    }

    inner class ViewHolder(
        private val binding :CategoryItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(categoryListItem: CategoryItemModel){

            binding.categoryName.text = categoryListItem.name
            Glide.with(binding.root).load(categoryListItem.image).into(binding.categoryImage)
        }
       /* init {
            itemView.setOnClickListener {
                val item =categoryListItem[bindingAdapterPosition]
                onItemClick(item.name)
            }
            itemView.width =screenWidth
        }*/
    }

}