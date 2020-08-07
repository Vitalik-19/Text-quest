package com.example.textquest.ui.personage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.AppDatabaseDao

class PersonageViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    val personages = database.getPersonages()

    private val _navigateToInformationPersonage = MutableLiveData<Long>()
    val navigateToInformationPersonage
        get() = _navigateToInformationPersonage

    fun onPersonageClicked(id: Long) {
        _navigateToInformationPersonage.value = id
    }

    fun onInformationPersonageNavigated() {
        _navigateToInformationPersonage.value = null
    }
}
