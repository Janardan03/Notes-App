package com.example.notes

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes_table")          // we can simply make a table using @entity and defining table name
class Note(@ColumnInfo(name = "text")val text: String) {  // we can change column name bu providing @columnInfo
                                                            // if auto generate is enabled then we have no need to specify id every time

    @PrimaryKey(autoGenerate = true) var id = 0
}