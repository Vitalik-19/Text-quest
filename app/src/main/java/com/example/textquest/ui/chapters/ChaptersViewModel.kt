package com.example.textquest.ui.chapters

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.textquest.database.AppDatabaseDao

class ChaptersViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    val chapters = database.getChapters()
}
