package com.example.sembilan.dependeciesinjection

import android.content.Context
import com.example.sembilan.data.database.KrsDatabase
import com.example.sembilan.repository.LocalRepositoryMhs
import com.example.sembilan.repository.RepositoryMhs

interface InterfaceContainerApp {
    val repositoryMhs: RepositoryMhs //untuk memasukkan daftar repository jika repository yang di pakai banyak
}

class ContainerApp(private val context: Context) : InterfaceContainerApp {
   override val repositoryMhs: RepositoryMhs by lazy {
       LocalRepositoryMhs(KrsDatabase.getDatabase(context).mahasiswaDao())
   }
}