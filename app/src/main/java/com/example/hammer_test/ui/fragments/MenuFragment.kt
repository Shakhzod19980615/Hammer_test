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
import com.example.hammer_test.databinding.FragmentMenuBinding
import com.example.hammer_test.di.AppComponent
import com.example.hammer_test.ui.adapters.BannerListAdapter
import com.example.hammer_test.ui.adapters.MenuCategoryListAdapter
import com.example.hammer_test.ui.adapters.ItemMenuCategoryListAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import javax.inject.Inject
import kotlin.properties.Delegates


class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentMenuBinding by Delegates.notNull()
    private  var viewModel : CategoryViewModel by Delegates.notNull()


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
    ): View {
        binding = FragmentMenuBinding.inflate(inflater)

        return binding.root

    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cities = resources.getStringArray(R.array.cities)
        val arrayAdapter = ArrayAdapter(requireContext(), R.layout.dropdown_item, cities)
        binding.spinner.setAdapter(arrayAdapter)
        viewModel =ViewModelProvider(this,viewModelFactory).get(CategoryViewModel::class.java)
        val bannerRV = view.findViewById<RecyclerView>(R.id.main_category_rv)
        bannerRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )

        }
        val bannerListAdapter = BannerListAdapter(layoutInflater )
        bannerRV.adapter =bannerListAdapter
        viewModel.getBannerList()
        viewModel.bannerLiveData.observe(viewLifecycleOwner){
            bannerListAdapter.setItems(it)
        }
        val menuCategoryRV = view.findViewById<RecyclerView>(R.id.menu_rv)
        menuCategoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )
        }
        val subCategoryRV =  view.findViewById<RecyclerView>(R.id.menu_item_rv)
        subCategoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,false
            )
        }


        val menuCategoryListAdapter = MenuCategoryListAdapter(layoutInflater, onItemClick = {keyword->
            viewModel.getSubItemList(keyword = keyword)

        })
        menuCategoryRV.adapter =menuCategoryListAdapter
        viewModel.getSubCategoryList()
        viewModel.subCategoryListLiveData.observe(viewLifecycleOwner){
            menuCategoryListAdapter.setItems(it)
        }
        val subCategoryListAdapter = ItemMenuCategoryListAdapter(layoutInflater)
        subCategoryRV.adapter = subCategoryListAdapter
        viewModel.subCategoryItemLiveData.observe(viewLifecycleOwner){
            subCategoryListAdapter.setItems(it.items)
        }

    }

}