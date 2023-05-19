/*
 * Copyright (C) 2021 The Android Open Source Project.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.inventory.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

/**
 * Database class with a singleton INSTANCE object.
 * membuat class database dengan objek inisiasi tunggal.
 */
// setel entitas sebagai satu class dengan daftar entitas
// versi = 1, karena setiap mengubah skema tabel database, harus meningkatan nomor versinya
// exportSchema ubah ke false agar tidak menyimpang candangan histori versi skema
@Database(entities = [Item::class], version = 1, exportSchema = false)
// membuat class database dengan objek inisiasi tunggal.
abstract class ItemRoomDatabase : RoomDatabase() {

    // deklarasi fungsi abstark yang menampilkan ItemDao
    abstract fun itemDao(): ItemDao

    // companion object yang digunakan untuk memungkinkan akses ke metode untuk
    // membuat atau mendapatkan database dengan mengguankan nama class sebagai penentu
    companion object {
        @Volatile
        private var INSTANCE: ItemRoomDatabase? = null

        // memnetukan metode getDatabase() dengan parameter contxt yang diperlukan builder database.
        fun getDatabase(context: Context): ItemRoomDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    ItemRoomDatabase::class.java,
                    "item_database"
                )
                    // Wipes and rebuilds instead of migrating if no Migration object.
                    // Migration is not part of this codelab.
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}