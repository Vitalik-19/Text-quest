package com.example.textquest.ui.personageNote

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.example.textquest.R
import com.example.textquest.databinding.PersonageNoteFragmentBinding
import com.example.textquest.ui.Personage
import com.example.textquest.ui.PersonageData
import com.example.textquest.ui.idPersonage


class PersonageNoteFragment : Fragment() {

    companion object {
        fun newInstance() = PersonageNoteFragment()
    }

    private lateinit var viewModel: PersonageNoteViewModel
    private lateinit var binding: PersonageNoteFragmentBinding

    private val personage: List<Personage> = PersonageData().personageData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.personage_note_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(PersonageNoteViewModel::class.java)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.personageNoteFragmentButtonStart.setOnClickListener(
                Navigation.createNavigateOnClickListener(R.id.action_personageNoteFragment_to_gamePlayFragment))

        val item = personage[idPersonage]

        binding.personageNoteFragmentNote.text = item.description
    }
}
