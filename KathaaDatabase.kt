package com.example.mykathaacounts

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase


@Database(entities = [Kathaa:: class], version = 3)
abstract class KathaaDatabase: RoomDatabase() {
    abstract fun kathaaDao(): KathaaDao
}


