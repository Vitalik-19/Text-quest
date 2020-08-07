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

    private val _navigateToChapters = MutableLiveData<Long>()
    val navigateToChapters
        get() = _navigateToChapters

    fun onPersonageClicked(buttonId: Int, personageId: Long) {
        when (buttonId) {
            0 -> _navigateToChapters.value = personageId
            1 -> _navigateToInformationPersonage.value = personageId
        }
    }

    fun onInformationPersonageNavigated() {
        _navigateToInformationPersonage.value = null
    }

    fun onChaptersNavigated() {
        _navigateToChapters.value = null
    }
}
