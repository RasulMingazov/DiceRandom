package com.jeanbernad.dicerandom

import android.app.Application

class DiceApp : Application() {

    lateinit var mainViewModel: MainViewModel

    override fun onCreate() {
        super.onCreate()

        mainViewModel =
            MainViewModel(Communication.Base(1 to R.drawable.dice_1), GenerateRandom.Base())
    }
}