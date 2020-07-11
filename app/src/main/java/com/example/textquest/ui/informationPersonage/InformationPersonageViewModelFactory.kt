package com.example.textquest.ui.informationPersonage

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.textquest.database.AppDatabaseDao

class InformationPersonageViewModelFactory(
        private val dataSource: AppDatabaseDao,
        private val application: Application) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InformationPersonageViewModel::class.java)) {
            return InformationPersonageViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
