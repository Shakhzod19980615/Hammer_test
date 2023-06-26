package com.example.hammer_test.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hammer_test.R
import com.example.hammer_test.databinding.FragmentAllMenuBinding
import com.example.hammer_test.databinding.FragmentMenuBinding
import com.example.hammer_test.di.AppComponent
import com.example.hammer_test.ui.adapters.MenuListAdapter
import com.example.restaurant_test.ui.viewmodels.CategoryViewModel
import javax.inject.Inject
import kotlin.properties.Delegates

class AllMenuFragment : Fragment(R.layout.fragment_all_menu) {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private var binding: FragmentAllMenuBinding by Delegates.notNull()
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
    ): View? {
        binding = FragmentAllMenuBinding.inflate(inflater)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel =ViewModelProvider(this,viewModelFactory).get(CategoryViewModel::class.java)

        val menuRv = view.findViewById<RecyclerView>(R.id.menu_rv)
        menuRv.apply {
            layoutManager = LinearLayoutManager(
                requireContext(), LinearLayoutManager.VERTICAL,false
            )
        }
        val menuAdapter = MenuListAdapter(layoutInflater){item ->
            fragmentManager?.let { ItemDialogFragment(item).show(it,"ItemDialogFormat",) }

        }
        menuRv.adapter = menuAdapter
        viewModel.getMenuList()
        viewModel.menuListLiveData.observe(viewLifecycleOwner){
            menuAdapter.setItems(it.menus)
        }
    }
}