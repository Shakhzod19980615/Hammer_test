package com.example.hammer_test.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hammer_test.R
import com.example.hammer_test.databinding.FragmentCartBinding
import com.example.hammer_test.di.AppComponent
import com.example.hammer_test.ui.adapters.CartListAdapter
import com.example.hammer_test.ui.viewmodels.CartViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class CartFragment:Fragment(R.layout.fragment_cart) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentCartBinding by Delegates.notNull()
    private  var viewModel : CartViewModel by Delegates.notNull()
    var num = 1
    var totalPrice = 0.0
    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCartBinding.inflate(inflater)
        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this,viewModelFactory)[CartViewModel::class.java]

        val cartRV = view.findViewById<RecyclerView>(R.id.cart_rv)
        cartRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,false
            )
        }

        val cartAdapter = CartListAdapter(layoutInflater,
            onMinusClicked = {
                // viewModel.deleteCartItem(item = it)
                if(it.itemCount>1){
                    it.itemCount = it.itemCount - 1
                }else{
                    viewModel.deleteCartItem(item = it)
                }
            },

            onAddClicked = {
                viewModel.insertCartItem(item = it)
                it.itemCount = it.itemCount + 1

            },

            )

        cartAdapter.notifyDataSetChanged()
        cartRV.adapter = cartAdapter
        viewModel.itemsLiveData.observe(viewLifecycleOwner){
            cartAdapter.setItems(it)
            for (item in it.indices){
                totalPrice += it[item].price * it[item].itemCount.toDouble()

            }
            binding.buyBtn.text = "Оплатить" + " "+ totalPrice.toString() + "₽"
        }

    }


}