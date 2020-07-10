package com.example.textquest.ui.newGame

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textquest.R
import com.example.textquest.databinding.NewGameFragmentBinding
import com.example.textquest.ui.Personage
import com.example.textquest.ui.PersonageData
import kotlinx.android.synthetic.main.new_game_fragment.*


class NewGameFragment : Fragment() {

    companion object {
        fun newInstance() = NewGameFragment()
    }

    private lateinit var binding: NewGameFragmentBinding
    private lateinit var viewModel: NewGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.new_game_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(NewGameViewModel::class.java)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val personageData: List<Personage> = PersonageData().personageData

        recycler_view_personage_list.layoutManager = LinearLayoutManager(Fragment().context)
        recycler_view_personage_list.adapter = PersonageAdapter(personageData)
    }
}