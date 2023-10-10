package com.keremkulac.contactsapp.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "contacts")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "person_id") @NotNull val id: Int,
    @ColumnInfo(name = "person_name") @NotNull val personName: String,
    @ColumnInfo(name = "person_phone_number") @NotNull val personPhoneNumber: String
) : java.io.Serializable