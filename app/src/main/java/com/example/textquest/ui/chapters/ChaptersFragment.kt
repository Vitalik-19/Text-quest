package com.example.textquest.ui.chapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textquest.R
import com.example.textquest.database.AppDatabase
import com.example.textquest.databinding.ChaptersFragmentBinding
import com.example.textquest.ui.informationPersonage.InformationPersonageFragmentArgs


class ChaptersFragment : Fragment() {

    lateinit var binding: ChaptersFragmentBinding
    lateinit var adapter: ChaptersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val arguments = InformationPersonageFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = ChaptersViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(ChaptersViewModel::class.java)
        binding = DataBindingUtil.inflate(inflater, R.layout.chapters_fragment, container, false)

        viewModel.initializeCreateChapters(arguments.personageKey)
        adapter = ChaptersAdapter(ChapterListener { chapterId ->
            viewModel.onChapterClicked(chapterId)
        })

        viewModel.navigationToGamePlay.observe(viewLifecycleOwner, Observer {
            it?.let {
                this.findNavController().navigate(ChaptersFragmentDirections.actionChaptersFragmentToGamePlayFragment(it))
                viewModel.onGamePlayNavigated()
            }
        })
        viewModel.chapters.observe(viewLifecycleOwner, Observer {
            it?.let {
                adapter.submitList(it)
            }
        })

        binding.recyclerViewChapterList.adapter = adapter
        binding.recyclerViewChapterList.layoutManager = LinearLayoutManager(Fragment().context)
        binding.chaptersViewModel = viewModel
        binding.lifecycleOwner = this

        return binding.root
    }
}
