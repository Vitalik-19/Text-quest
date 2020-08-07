package com.example.textquest.ui.informationPersonage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.textquest.R
import com.example.textquest.database.AppDatabase
import com.example.textquest.databinding.InformationPersonageFragmentBinding

class InformationPersonageFragment : Fragment() {

    companion object {
        fun newInstance() = InformationPersonageFragment()
    }

    private lateinit var binding: InformationPersonageFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.information_personage_fragment, container, false)

        val arguments = InformationPersonageFragmentArgs.fromBundle(requireArguments())
        val application = requireNotNull(this.activity).application
        val dataSource = AppDatabase.getInstance(application).appDatabaseDao
        val viewModelFactory = InformationPersonageViewModelFactory(dataSource, application)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(InformationPersonageViewModel::class.java)
        binding.informationPersonageViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.initializePersonage(arguments.personageKey)

        return binding.root
    }
}
