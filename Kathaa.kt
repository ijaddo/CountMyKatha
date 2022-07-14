package com.example.mykathaacounts

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Kathaa (
    @PrimaryKey(autoGenerate = true) var uid : Int = 0,
    var Subuh: String,
    var Thuhur: String,
    var Asir: String,
    var Magrib: String,
    var Ishaa: String
)