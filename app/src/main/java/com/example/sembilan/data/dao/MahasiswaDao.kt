package com.example.sembilan.data.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.sembilan.data.entity.Mahasiswa

@Dao
interface MahasiswaDao {
    @Insert
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
}