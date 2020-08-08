package com.example.textquest.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.textquest.R
import com.example.textquest.databinding.HomeFragmentBinding


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.lifecycleOwner = this

        binding.apply {
            homeFragmentButtonNewGame.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_newGameFragment))
            homeFragmentButtonSettings.setOnClickListener(
                    Navigation.createNavigateOnClickListener(R.id.action_homeFragment_to_settingsFragment))
            homeFragmentButtonInfo.setOnClickListener {
                Toast.makeText(context, "not implemented yet", Toast.LENGTH_LONG).show()
            }
        }

        return binding.root
    }
}
