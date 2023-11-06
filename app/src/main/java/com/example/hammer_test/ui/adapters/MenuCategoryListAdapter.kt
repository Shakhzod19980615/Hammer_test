package com.example.hammer_test.ui.adapters

import android.annotation.SuppressLint
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.hammer_test.databinding.MenuCategoryItemBinding
import com.example.hammer_test.domain.model.mainCategoryModel.MainCategoryModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel


class MenuCategoryListAdapter(
    private val layoutInflater: LayoutInflater,
    val onItemClick: (name : String) -> Unit,
    //private val context: Context
):RecyclerView.Adapter<MenuCategoryListAdapter.ViewHolder>() {
    private  val categoryListItem : MutableList<SubCategoryListModel> = mutableListOf()
    val displayMetrics = DisplayMetrics()
    private var screenWidth = 1000
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MenuCategoryListAdapter.ViewHolder {
        val binding = MenuCategoryItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MenuCategoryListAdapter.ViewHolder, position: Int) {
        /*val layoutParams: ViewGroup.LayoutParams = holder.itemView.getLayoutParams()
        layoutParams.width = (screenWidth/1.2).toInt()
        holder.itemView.layoutParams*/
        holder.bindData(categoryListItem=categoryListItem[position])
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

    inner class ViewHolder(
        private val binding: MenuCategoryItemBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bindData(categoryListItem: SubCategoryListModel){
            binding.categoryName.text = categoryListItem.title

        }

        init {
            itemView.setOnClickListener {
                val item =categoryListItem[bindingAdapterPosition]
                onItemClick(item.keyword)
            }
        }
    }

}