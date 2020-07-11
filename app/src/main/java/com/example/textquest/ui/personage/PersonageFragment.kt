package com.example.textquest.ui.personage

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
import com.example.textquest.databinding.PersonageFragmentBinding


class PersonageFragment : Fragment() {

    private lateinit var binding: PersonageFragmentBinding
    private lateinit var adapter: PersonageAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.personage_fragment, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = PersonageViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(PersonageViewModel::class.java)
        binding.newGameViewModel = viewModel
        adapter = PersonageAdapter()

        binding.recyclerViewPersonageList.adapter = adapter
        binding.recyclerViewPersonageList.layoutManager = LinearLayoutManager(Fragment().context)
        binding.lifecycleOwner = this

        viewModel.personages.observe(viewLifecycleOwner, Observer {
            adapter.data = it
        })
        return binding.root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//
//        val personageData: List<Personage> = PersonageData().personageData
//
//        recycler_view_personage_list.layoutManager = LinearLayoutManager(Fragment().context)
//        recycler_view_personage_list.adapter = PersonageAdapter(personageData)
//    }
}