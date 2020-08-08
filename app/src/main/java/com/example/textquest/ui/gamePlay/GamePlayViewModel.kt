package com.example.textquest.ui.gamePlay

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.AppDatabaseDao
import com.example.textquest.database.ChapterWithGamePlays
import com.example.textquest.database.GamePlay
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

    fun initializeCreateGamePlay(chapterId: Long) {
        uiScope.launch {
            getCreateGamePlaysFromDatabase(chapterId)?.gamePlays.let {

                if (!it.isNullOrEmpty()) {
                    _gamePlays.value = it
                    _textStory.value = gamePlays.value?.get(0)?.textStory
                }
            }
        }
    }

    private suspend fun getCreateGamePlaysFromDatabase(key: Long): ChapterWithGamePlays? {
        return withContext(Dispatchers.IO) {
            val gamePlays = database.getChapterWithGamePlays(key)
            gamePlays
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
