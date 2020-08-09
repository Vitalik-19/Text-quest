package com.example.textquest.ui.gamePlay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textquest.R
import com.example.textquest.database.AppDatabase
import com.example.textquest.databinding.GamePlayFragmentBinding

class GamePlayFragment : Fragment() {

    private lateinit var binding: GamePlayFragmentBinding
    private lateinit var adapter: GamePlayAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val arguments = GamePlayFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = GamePlayViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(GamePlayViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.game_play_fragment, container, false)
        adapter = GamePlayAdapter()

        viewModel.initializeCreateGamePlay(arguments.chapterKey)

        viewModel.answers.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.data = it
            }
        })

        binding.recyclerViewAnswerList.adapter = adapter
        binding.recyclerViewAnswerList.layoutManager = LinearLayoutManager(Fragment().context)
        binding.gamePlayViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
