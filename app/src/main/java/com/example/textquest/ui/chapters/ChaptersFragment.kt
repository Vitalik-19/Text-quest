package com.example.textquest.ui.chapters

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.textquest.R


class ChaptersFragment : Fragment() {

    companion object {
        fun newInstance() = ChaptersFragment()
    }

    private lateinit var viewModel: ChaptersViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.chapters_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(ChaptersViewModel::class.java)
        // TODO: Use the ViewModel
    }

}