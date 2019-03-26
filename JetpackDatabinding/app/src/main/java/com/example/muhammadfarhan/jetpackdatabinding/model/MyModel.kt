package com.example.muhammadfarhan.jetpackdatabinding.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class MyModel(@PrimaryKey @ColumnInfo(name = "value") var value: String)