package com.example.mykathaacounts

import androidx.room.*

@Dao
interface KathaaDao {
    @Query("SELECT * FROM kathaa WHERE UID = 1")
    fun getKathaa(): List<Kathaa>

    @Insert
    fun insertKathaa(kathaa: Kathaa)

    @Update
    fun updateKathaa(kathaa:Kathaa)

    @Delete
    fun deleteKathaa(kathaa: Kathaa)


}