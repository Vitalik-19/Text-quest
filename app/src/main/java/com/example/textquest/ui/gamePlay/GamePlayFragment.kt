package com.example.textquest.ui.gamePlay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.textquest.R
import com.example.textquest.database.AppDatabase
import com.example.textquest.databinding.GamePlayFragmentBinding

class GamePlayFragment : Fragment() {

    private lateinit var binding: GamePlayFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val arguments = GamePlayFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = GamePlayViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(GamePlayViewModel::class.java)

        viewModel.initializeCreateGamePlay(arguments.chapterKey)

        binding = DataBindingUtil.inflate(inflater, R.layout.game_play_fragment, container, false)
        binding.gamePlayViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
