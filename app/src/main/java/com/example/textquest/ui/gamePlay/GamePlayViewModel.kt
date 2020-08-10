package com.example.textquest.ui.gamePlay

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.*
import kotlinx.coroutines.*

class GamePlayViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _textStory = MutableLiveData<String>()
    val textStory: LiveData<String>
        get() = _textStory

    private val _gamePlays = MutableLiveData<List<GamePlay>>()
    val gamePlays: LiveData<List<GamePlay>>
        get() = _gamePlays

    private val _gamePlay = MutableLiveData<GamePlay>()
    val gamePlay: LiveData<GamePlay>
        get() = _gamePlay

    private val _answers = MutableLiveData<List<Answer>>()
    val answers: LiveData<List<Answer>>
        get() = _answers

    private val _navigationToNext = MutableLiveData<Long>()
    val navigationToNext: LiveData<Long>
        get() = _navigationToNext

    fun onAnswerClicked(answerId: Long) {
        _navigationToNext.value = answerId
    }

    fun onNextNavigated() {
        _navigationToNext.value = null
    }

    fun initializeCreateGamePlays(chapterId: Long) {
        uiScope.launch {
            getCreateGamePlaysFromDatabase(chapterId)?.gamePlays.let {

                if (!it.isNullOrEmpty()) {
                    _gamePlays.value = it
                    logic()
                }
            }
        }
    }

    fun logic() {
        when (gamePlay.value?.gamePlayId) {
            null -> {
                _gamePlay.value = gamePlays.value!![0]
            }
            else -> {
                _gamePlay.value = gamePlays.value!![answers.value!![navigationToNext.value!!.toInt() - 1].answerId.toInt()]
            }
        }
        _textStory.value = gamePlay.value!!.textStory
        initializeCreateAnswers(gamePlay.value!!.gamePlayId)
    }

    private suspend fun getCreateGamePlaysFromDatabase(key: Long): ChapterWithGamePlays? {
        return withContext(Dispatchers.IO) {
            val gamePlays = database.getChapterWithGamePlays(key)
            gamePlays
        }
    }

    fun initializeCreateAnswers(gamePlayId: Long) {
        uiScope.launch {
            getCreateAnswersFromDatabase(gamePlayId)?.answers.let {
                if (!it.isNullOrEmpty()) {
                    _answers.value = it
                } else {
                    _answers.value = listOf()
                }
            }
        }
    }

    private suspend fun getCreateAnswersFromDatabase(key: Long): GamePlayWithAnswers? {
        return withContext(Dispatchers.IO) {
            val answers = database.getGamePlayWithAnswers(key)
            answers
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}