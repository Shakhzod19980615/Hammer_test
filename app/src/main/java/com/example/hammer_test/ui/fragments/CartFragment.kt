package com.example.hammer_test.ui.fragments

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hammer_test.R
import com.example.hammer_test.databinding.FragmentCartBinding
import com.example.hammer_test.di.AppComponent
import javax.inject.Inject
import kotlin.properties.Delegates

class CartFragment:Fragment(R.layout.fragment_cart) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentCartBinding by Delegates.notNull()

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

      }


}