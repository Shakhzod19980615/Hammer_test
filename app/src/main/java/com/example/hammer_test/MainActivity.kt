package com.example.hammer_test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.hammer_test.databinding.ActivityMainBinding
import com.example.hammer_test.ui.fragments.CartFragment
import com.example.hammer_test.ui.fragments.MenuFragment
import com.example.hammer_test.ui.fragments.ProfileFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        if (savedInstanceState == null) {
            replaceFragment(MenuFragment())
        }
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.menuFragment -> replaceFragment(MenuFragment())
                R.id.cartFragment -> replaceFragment(CartFragment())
                R.id.profileFragment -> replaceFragment(ProfileFragment())
                else -> Unit
            }
            true
        }
    }
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.commit {
            replace(R.id.fragment_container_view_tag,fragment)
        }
    }
}