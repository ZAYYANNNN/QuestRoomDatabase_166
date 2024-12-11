package com.example.sembilan.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.sembilan.data.dao.MahasiswaDao
import com.example.sembilan.data.entity.Mahasiswa

@Database(entities = [Mahasiswa::class], version = 1, exportSchema = false)
abstract class KrsDatabase : RoomDatabase() {

    //Mendefinisikan fungsi untuk mengakses data Mahasiswa

    abstract fun mahasiswaDao(): MahasiswaDao

    companion object{
        @Volatile // Memastikan bahwa nilai variabel instance selalu sama di
        private var Instance: KrsDatabase? = null

        fun getDatabase(context: Context): KrsDatabase {
            return (Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    KrsDatabase::class.java, //Class Database
                    "KrsDatabase" //Nama Database
                )
                    .build().also { Instance = it }
            })
        }
    }
}