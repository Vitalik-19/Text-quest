package com.example.textquest.ui.logic

import android.view.View
import android.widget.Button
import com.example.textquest.ui.PersonageData
import com.example.textquest.ui.Question
import com.example.textquest.ui.idPersonage
import com.example.textquest.ui.idQuestion

class TextQuestLogic {

    val question: Question = PersonageData().personageData[idPersonage].questionData[idQuestion]
    var arrayButton: ArrayList<Button> = arrayListOf()

    fun onClick(view: View) {
        view.setOnClickListener { this }
    }

    fun addButton(bottun: Button) {
        for (numberBottun in 0..question.answerButtonData.size - 1) {
            arrayButton.add(bottun)
            onClick(bottun)
        }
    }


}

