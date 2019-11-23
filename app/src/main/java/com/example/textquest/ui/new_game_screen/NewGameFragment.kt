package com.example.textquest.ui.new_game_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.textquest.R
import com.example.textquest.ui.Personage
import com.example.textquest.ui.PersonageData
import kotlinx.android.synthetic.main.new_game_fragment.*


class NewGameFragment : Fragment() {

    companion object {
        fun newInstance() = NewGameFragment()
    }

    private lateinit var viewModel: NewGameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.new_game_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val personageData: List<Personage> = PersonageData().personageData

        recycler_view_personage_list.layoutManager = LinearLayoutManager(Fragment().context)
        recycler_view_personage_list.adapter = PersonageAdapter(personageData)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProviders.of(this).get(NewGameViewModel::class.java)
        // TODO: Use the ViewModel
    }

}