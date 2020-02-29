package com.example.textquest.ui.personage_note_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.textquest.R
import com.example.textquest.ui.Personage
import com.example.textquest.ui.PersonageData
import com.example.textquest.ui.idPersonage


class PersonageNoteFragment : Fragment() {

    companion object {
        fun newInstance() = PersonageNoteFragment()
    }

    private lateinit var viewModel: PersonageNoteViewModel
    private lateinit var notePersonage: TextView
    private lateinit var avatarPersonage: ImageView
    private lateinit var startButton: Button


    val personage: List<Personage> = PersonageData().personageData

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.personage_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notePersonage = view.findViewById(R.id.personage_note_fragment_note)
        avatarPersonage = view.findViewById(R.id.personage_note_fragment_avatar_personage)
        startButton = view.findViewById(R.id.personage_note_fragment_button_start)

        startButton.setOnClickListener {
            view.findNavController().navigate(R.id.action_personageNoteFragment_to_gamePlayFragment)
        }
        val item = personage[idPersonage]


        notePersonage.text = item.description
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PersonageNoteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
