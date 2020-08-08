package com.example.textquest.ui.informationPersonage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.textquest.database.AppDatabaseDao
import com.example.textquest.database.Personage
import kotlinx.coroutines.*

class InformationPersonageViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

    private var viewModelJob = Job()

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    private val _personage = MutableLiveData<Personage>()
    val personage: LiveData<Personage>
        get() = _personage

    fun initializePersonage(key: Long) {
        uiScope.launch {
            _personage.value = getPersonageFromDatabase(key)
        }
    }

    private suspend fun getPersonageFromDatabase(key: Long): Personage? {
        return withContext(Dispatchers.IO) {
            val personage = database.getPersonage(key)
            personage
        }
    }
}
