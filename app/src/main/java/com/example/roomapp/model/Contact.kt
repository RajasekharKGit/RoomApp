package com.example.roomapp.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(
    tableName = "contact_table",
    indices = [Index(value = ["firstName", "lastName", "phoneNumber"], unique = true)]
)
data class Contact(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val firstName: String,
    val lastName: String,
    val phoneNumber: String
) : Parcelable