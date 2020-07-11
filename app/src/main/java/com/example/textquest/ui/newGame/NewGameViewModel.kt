package com.example.textquest.ui.newGame

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.textquest.database.AppDatabaseDao

class NewGameViewModel(val database: AppDatabaseDao, application: Application) : AndroidViewModel(application) {

//    private var viewModelJob = Job()
//
//    override fun onCleared() {
//        super.onCleared()
//        viewModelJob.cancel()
//    }
//
//    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
//
//    private fun initializePersonage() {
//        uiScope.launch {
//
//        }
//    }
//
//    private suspend fun getCreateAdvertFromDatabase(key: Long): Personage? {
//        return withContext(Dispatchers.IO) {
//            val personage = database.get(key)
//            personage
//        }
//    }
}
