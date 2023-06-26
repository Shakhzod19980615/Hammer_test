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
import androidx.viewpager2.widget.ViewPager2
import com.example.hammer_test.R
import com.example.hammer_test.databinding.FragmentMenuBinding
import com.example.hammer_test.di.AppComponent
import com.example.hammer_test.ui.adapters.CategoryListAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import com.google.android.material.tabs.TabLayout
import javax.inject.Inject
import kotlin.properties.Delegates


class MenuFragment : Fragment(R.layout.fragment_menu) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentMenuBinding by Delegates.notNull()
    private  var viewModel : CategoryViewModel by Delegates.notNull()
    private lateinit var adapter: FragmentPageAdapter
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
        val categoryRV = view.findViewById<RecyclerView>(R.id.category_rv)
        categoryRV.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.HORIZONTAL,false
            )

        }
        val categoryAdapter = CategoryListAdapter(layoutInflater )
        categoryRV.adapter =categoryAdapter
        viewModel.getCategoryList()
        viewModel.categoryListLiveData.observe(viewLifecycleOwner){
            categoryAdapter.setItems(it.categories)
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
        })

    }

}