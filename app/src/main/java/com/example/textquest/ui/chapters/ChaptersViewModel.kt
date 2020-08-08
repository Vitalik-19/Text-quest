package com.example.textquest.ui.chapters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.AppDatabaseDao
import com.example.textquest.database.Chapter
import com.example.textquest.database.PersonageWithChapters
import kotlinx.coroutines.*

class ChaptersViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _chapters = MutableLiveData<List<Chapter>>()
    val chapters: LiveData<List<Chapter>>
        get() = _chapters

    private val _navigationToGamePlay = MutableLiveData<Long>()
    val navigationToGamePlay: LiveData<Long>
        get() = _navigationToGamePlay

    fun onChapterClicked(chapterId: Long) {
        _navigationToGamePlay.value = chapterId
    }

    fun initializeCreateChapters(key: Long) {
        uiScope.launch {
            getCreateChaptersFromDatabase(key)?.chapters.let {
                _chapters.value = it
            }
        }
    }

    fun onGamePlayNavigated() {
        _navigationToGamePlay.value = null
    }

    private suspend fun getCreateChaptersFromDatabase(key: Long): PersonageWithChapters? {
        return withContext(Dispatchers.IO) {
            val chapters = database.getPersonageWithChapters(key)
            chapters
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}
