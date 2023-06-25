package com.example.hammer_test.ui.fragments

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hammer_test.R
import com.example.hammer_test.di.AppComponent
import javax.inject.Inject

class ProfileFragment:Fragment(R.layout.fragment_profile) {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    override fun onAttach(context: Context) {
        super.onAttach(context)
        AppComponent.get().inject(this)

    }
}