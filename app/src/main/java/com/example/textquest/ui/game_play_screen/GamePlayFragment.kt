package com.example.textquest.ui.game_play_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.findNavController
import com.example.textquest.R
import com.example.textquest.ui.PersonageData
import com.example.textquest.ui.Question
import com.example.textquest.ui.idPersonage
import com.example.textquest.ui.idQuestion


class GamePlayFragment : Fragment() {

    companion object {
        fun newInstance() = GamePlayFragment()
    }

    private lateinit var viewModel: GamePlayViewModel
    var answerButtonList: ArrayList<Button> = arrayListOf()
    val question: Question = PersonageData().personageData[idPersonage].questionData[idQuestion]
    lateinit var answerButtonContainer: LinearLayout
    lateinit var questionText: TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.game_play_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        answerButtonContainer = view.findViewById(R.id.game_play_container_answer_button)
        questionText = view.findViewById(R.id.game_play_question_text)

        questionText.text = question.questionText

        for (numberAnswerButton in 0..question.answerButtonData.size - 1) {
            answerButtonList.add(Button(context))
            answerButtonList[numberAnswerButton].layoutParams = answerButtonContainer.layoutParams
            answerButtonList[numberAnswerButton].text = question.answerButtonData[numberAnswerButton].answerText
            answerButtonContainer.addView(answerButtonList[numberAnswerButton])
            answerButtonList[numberAnswerButton].setOnClickListener {
                idQuestion = question.answerButtonData[numberAnswerButton].questionId - 1
                answerButtonContainer.removeAllViews()
                
                view.findNavController().navigate(R.id.action_gamePlayFragment_self)
            }
        }
    }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GamePlayViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
