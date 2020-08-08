package com.example.textquest.ui.chapters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.AppDatabaseDao

class ChaptersViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    val chapters = database.getChapters()

    private val _navigationToGamePlay = MutableLiveData<Long>()
    val navigationToGamePlay: LiveData<Long>
        get() = _navigationToGamePlay

    fun onChapterClicked(chapterId: Long) {
        _navigationToGamePlay.value = chapterId
    }

    fun onGamePlayNavigated() {
        _navigationToGamePlay.value = null
    }
}
