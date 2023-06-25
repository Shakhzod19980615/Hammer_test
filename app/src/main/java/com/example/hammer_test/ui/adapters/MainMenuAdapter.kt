package com.example.hammer_test.ui.adapters

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View.OnTouchListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammer_test.databinding.MainMenuItemBinding


class MainMenuAdapter(
    private val layoutInflater: LayoutInflater
) : RecyclerView.Adapter<MainMenuAdapter.ViewHolder>(){
    private var titles = arrayOf(
        "Все меню", "Салаты",
        "С рисом", "С рыбой",
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainMenuAdapter.ViewHolder {
        val binding = MainMenuItemBinding.inflate(layoutInflater,parent,false)
        return ViewHolder(binding)
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onBindViewHolder(holder: MainMenuAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = titles[position]
        /*holder.cardView.setOnTouchListener(OnTouchListener { v, event ->
            if (event.action == MotionEvent.ACTION_DOWN) {
                holder.itemTitle.setTextColor(Color.RED)
                return@OnTouchListener true
            } else {
                holder.itemTitle.setTextColor(Color.BLUE)
            }
            false
        })*/
    }

    override fun getItemCount(): Int {
        return  titles.size
    }

    inner class ViewHolder(
         binding : MainMenuItemBinding)
        :RecyclerView.ViewHolder(binding.root){

        var itemTitle = binding.mainMenuItem
        //var cardView =  binding.cardView



    }
}