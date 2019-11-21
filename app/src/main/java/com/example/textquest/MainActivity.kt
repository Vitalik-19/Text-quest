package com.example.textquest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

/*
    private var doubleBackToExitPressedOnce = false

    override fun onBackPressed() {

        if(doubleBackToExitPressedOnce){
        super.onBackPressed()}
        else {
        this.doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed( { doubleBackToExitPressedOnce = false }, 2000)}
    }
*/
}
