package com.example.textquest.ui.gamePlay

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.textquest.R
import com.example.textquest.databinding.GamePlayFragmentBinding

class GamePlayFragment : Fragment() {

    companion object {
        fun newInstance() = GamePlayFragment()
    }

    private lateinit var viewModel: GamePlayViewModel
    private lateinit var binding: GamePlayFragmentBinding

    var answerButtonList: ArrayList<Button> = arrayListOf()

    //    private val question: Question = PersonageData().personageData[idPersonage].questionData[idQuestion]
    lateinit var answerButtonContainer: LinearLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.game_play_fragment, container, false)
        viewModel = ViewModelProviders.of(this).get(GamePlayViewModel::class.java)
        binding.lifecycleOwner = this

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        answerButtonContainer = binding.gamePlayContainerAnswerButton
//        binding.gamePlayQuestionText.text = question.questionText

//        for (numberAnswerButton in 0..question.answerButtonData.size - 1) {
//            answerButtonList.add(Button(context))
//            answerButtonList[numberAnswerButton].layoutParams = answerButtonContainer.layoutParams
//            answerButtonList[numberAnswerButton].text = question.answerButtonData[numberAnswerButton].answerText
//            answerButtonContainer.addView(answerButtonList[numberAnswerButton])
//            answerButtonList[numberAnswerButton].setOnClickListener {
////                idQuestion = question.answerButtonData[numberAnswerButton].questionId - 1
//                answerButtonContainer.removeAllViews()
//
//                view.findNavController().navigate(R.id.action_gamePlayFragment_self)
//            }
//        }
    }
}
