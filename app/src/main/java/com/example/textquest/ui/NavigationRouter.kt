package com.example.textquest.ui

import android.os.Bundle
import androidx.navigation.NavController
import com.example.textquest.R

class NavigationRouter(private var navController: NavController) {


    fun openFragmentHome(paramsBundle: Bundle) {
        navController.navigate(R.id.action_homeFragment_to_newGameFragment, paramsBundle)
    }



}