package com.example.textquest.ui.personage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.textquest.database.AppDatabaseDao

class PersonageViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    val personages = database.getPersonages()
}
