package com.isuru.kotlinapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.isuru.kotlinapp.R
import com.isuru.kotlinapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var mBinding: ActivityMainBinding

    private lateinit var mNavController: NavController

    private lateinit var mBottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        init()
    }


    fun init(){
        mNavController = Navigation.findNavController(this,R.id.nav_host)
        mBottomNavigationView = findViewById(R.id.bottom_nav)
        NavigationUI.setupWithNavController(mBottomNavigationView,mNavController)
    }
}