package com.example.textquest.ui.gamePlay

import android.app.Application
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

    private val _navigationToNextGamePlay = MutableLiveData<Long>()
    val navigationToNextGamePlay: LiveData<Long>
        get() = _navigationToNextGamePlay

    private val _navigationToGameOver = MutableLiveData<Long>()
    val navigationToGameOver: LiveData<Long>
        get() = _navigationToGameOver

    private val _navigationToChapter = MutableLiveData<Boolean>()
    val navigationToChapter: LiveData<Boolean>
        get() = _navigationToChapter

    private val _nextChapterId = MutableLiveData<Long>()
    val nextChapterId: LiveData<Long>
        get() = _nextChapterId

    fun onAnswerClicked(answerId: Long) {
        when (answerId) {
            0L -> {
                when (gamePlay.value!!.navigationToChapterId) {
                    0L -> {
                        //TODO GAME OVER
                    }
                    else -> {
                        //TODO navigation next chapter
                        initializeCreateGamePlays(gamePlay.value!!.navigationToChapterId)
                    }
                }
            }
            else -> {
                _navigationToNextGamePlay.value = answerId
            }
        }
    }

    fun onNavigationChapterClicked() {
        uiScope.launch {
            _nextChapterId.value = gamePlay.value!!.navigationToChapterId
        }
    }

    fun onGameOverNavigated() {
        _navigationToGameOver.value = null
    }

    fun onChapterNavigated() {
        //TODO
    }

    fun initializeCreateGamePlays(chapterId: Long) {
        uiScope.launch {
            getCreateGamePlaysFromDatabase(chapterId)?.gamePlays.let {

                //todo try catch

                if (!it.isNullOrEmpty()) {
                    _gamePlays.value = it
                    logicGamePlay(0)
                }
            }
        }
    }

    fun logicGamePlay(gamePlayIndex: Int) {
        uiScope.launch {
            _gamePlay.value = gamePlays.value!![gamePlayIndex]
            getCreateAnswersFromDatabase(gamePlay.value!!.gamePlayId)?.answers.let { answers ->
                if (answers.isNullOrEmpty()) {
                    if (gamePlay.value!!.navigationToChapterId != 0L)
                        _answers.value = listOf(Answer(0, "К следующей главе"))
                    else {
                        _answers.value = listOf()
                        _navigationToGameOver.value = gamePlay.value!!.gamePlayId
                    }
                } else
                    _answers.value = answers
            }
            _textStory.value = gamePlay.value!!.textStory
        }
    }


    private suspend fun getCreateGamePlaysFromDatabase(key: Long): ChapterWithGamePlays? {
        return withContext(Dispatchers.IO) {
            val gamePlays = database.getChapterWithGamePlays(key)
            gamePlays
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