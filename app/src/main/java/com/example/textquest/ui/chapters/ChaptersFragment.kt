package com.example.textquest.ui.chapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textquest.R
import com.example.textquest.database.AppDatabase
import com.example.textquest.databinding.ChaptersFragmentBinding


class ChaptersFragment : Fragment() {

    lateinit var binding: ChaptersFragmentBinding
    lateinit var adapter: ChaptersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = ChaptersViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ChaptersViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.chapters_fragment, container, false)

        adapter = ChaptersAdapter()

        binding.recyclerViewChapterList.adapter = adapter
        binding.recyclerViewChapterList.layoutManager = LinearLayoutManager(Fragment().context)
        binding.chaptersViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
