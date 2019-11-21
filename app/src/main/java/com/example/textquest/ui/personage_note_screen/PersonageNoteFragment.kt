package com.example.textquest.ui.personage_note_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.textquest.R


class PersonageNoteFragment : Fragment() {

    companion object {
        fun newInstance() = PersonageNoteFragment()
    }

    private lateinit var viewModel: PersonageNoteViewModel
    private lateinit var notePersonage: TextView
    private lateinit var avatarPersonage: ImageView
    private lateinit var notePersonageList: ArrayList<String>


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.personage_note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        notePersonage = view.findViewById(R.id.personage_note_fragment_note)
        avatarPersonage = view.findViewById(R.id.personage_note_fragment_avatar_personage)

        notePersonageList = arrayListOf(
                "Веста",
                "Шрам",
                "Стрелок"
        )

//        notePersonage.text = notePersonageList[]
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(PersonageNoteViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
