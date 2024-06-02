package com.aashraf.mainscreenmodule.data.dataModel

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class University(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val country: String
)