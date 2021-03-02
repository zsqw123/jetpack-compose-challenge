package com.example.androiddevchallenge

import android.app.Application

lateinit var app: Application

class App : Application() {
    init {
        app = this
    }
}