package com.example.sembilan

import android.app.Application
import com.example.sembilan.dependeciesinjection.ContainerApp

class KrsApp : Application() {
    lateinit var containerApp: ContainerApp //Fungsinya untuk menyimpan

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)// Membuat instance(pembuat object)
        //instance adalah object yang dibuat dari class
    }
}