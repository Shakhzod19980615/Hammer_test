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
import com.example.hammer_test.ui.adapters.CategoryListAdapter
import com.example.hammer_test.ui.adapters.MenuCategoryListAdapter
import com.example.hammer_test.ui.adapters.SubCategoryItemAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import uz.demo.dana.domain.model.subcategory.SubCategoryItemModel
import uz.demo.dana.domain.model.subcategory.SubCategoryListModel
import javax.inject.Inject
import kotlin.properties.Delegates


class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentMenuBinding by Delegates.notNull()
    private  var viewModel : CategoryViewModel by Delegates.notNull()
    private lateinit var adapter: FragmentPageAdapter
    private val subMenuItemList : MutableList<SubCategoryListModel> = mutableListOf()
    private var itemKeyword = ""
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
        val categoryRV = view.findViewById<RecyclerView>(R.id.main_category_rv)
        categoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )

        }
        val categoryAdapter = CategoryListAdapter(layoutInflater )
        categoryRV.adapter =categoryAdapter
        viewModel.getMainCategory()
        viewModel.mainCategoryLiveData.observe(viewLifecycleOwner){
            categoryAdapter.setItems(it)
        }
        val menuCategoryRV = view.findViewById<RecyclerView>(R.id.menu_rv)
        menuCategoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )
        }
        val menuCategoryListAdapter = MenuCategoryListAdapter(layoutInflater){
            keyword -> itemKeyword = keyword

        }
        menuCategoryRV.adapter =menuCategoryListAdapter
        viewModel.getSubCategoryList()
        viewModel.subCategoryListLiveData.observe(viewLifecycleOwner){
            menuCategoryListAdapter.setItems(it)
        }
        val subCategoryRV =  view.findViewById<RecyclerView>(R.id.menu_item_rv)
        subCategoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,false
            )
        }
        val subCategoryListAdapter = SubCategoryItemAdapter(layoutInflater)
        subCategoryRV.adapter = subCategoryListAdapter
       //
        viewModel.getSubCategoryList()
        viewModel.subCategoryItemLiveData.observe(viewLifecycleOwner){
            subCategoryListAdapter.setItems(subMenuItemList.firstOrNull { it.keyword == itemKeyword }!!.items)
        }

        /*val menuRv = view.findViewById<RecyclerView>(R.id.menu_rv)
        menuRv.apply {
            layoutManager = LinearLayoutManager(
                requireContext(),LinearLayoutManager.VERTICAL,false
            )
        }
        val menuAdapter = MenuListAdapter(layoutInflater)
        menuRv.adapter = menuAdapter
        viewModel.getMenuList()
        viewModel.menuListLiveData.observe(viewLifecycleOwner){
            menuAdapter.setItems(it.menus)
        }*/
        /*val mainMenuRV = view.findViewById<RecyclerView>(R.id.main_menu_rv)
        mainMenuRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )
        }
        val mainMenuAdapter = MainMenuAdapter(layoutInflater)
        mainMenuRV.adapter = mainMenuAdapter*/
/*
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Все меню"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("Салаты"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("С рисом"))
        binding.tabLayout.addTab(binding.tabLayout.newTab().setText("С рыбой"))
        adapter = fragmentManager?.let { FragmentPageAdapter(it,lifecycle) }!!
        binding.viewpagerMain.adapter = adapter
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    binding.viewpagerMain.currentItem = tab.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })
        binding.viewpagerMain.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                binding.tabLayout.selectTab(binding.tabLayout.getTabAt(position))
            }
        })*/

    }

}