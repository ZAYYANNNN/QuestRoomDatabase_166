package com.example.sembilan.repository

import com.example.sembilan.data.dao.MahasiswaDao
import com.example.sembilan.data.entity.Mahasiswa

class LocalRepositoryMhs(
    private val mahasiswaDao: MahasiswaDao
) : RepositoryMhs {
    override suspend fun insertMhs(mahasiswa: Mahasiswa) {
        mahasiswaDao.insertMahasiswa(mahasiswa)
    }


}