package com.example.sembilan.repository

import com.example.sembilan.data.entity.Mahasiswa

interface RepositoryMhs {
    suspend fun insertMhs(mahasiswa: Mahasiswa)
}