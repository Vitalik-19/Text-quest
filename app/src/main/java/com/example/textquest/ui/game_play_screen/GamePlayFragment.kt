package com.example.textquest.ui.game_play_screen

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.textquest.R


class GamePlayFragment : Fragment() {

    companion object {
        fun newInstance() = GamePlayFragment()
    }

    private lateinit var viewModel: GamePlayViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.game_play_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GamePlayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
