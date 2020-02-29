package com.example.textquest.ui.home_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.textquest.R


class HomeFragment : Fragment() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    private lateinit var viewModel: HomeViewModel
    private lateinit var buttonNewGame: Button
    private lateinit var buttonContinue: Button
    private lateinit var buttonSettings: Button


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        buttonNewGame = view.findViewById(R.id.home_fragment_button_new_game)
        buttonSettings = view.findViewById(R.id.home_fragment_button_settings)

        buttonNewGame.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_newGameFragment)
        }
        buttonSettings.setOnClickListener {
            view.findNavController().navigate(R.id.action_homeFragment_to_settingsFragment)
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
