package com.example.notes

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NoteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)    // we can use this onConflict to assign what to do if we encounter same values
    suspend fun insert(note : Note)

    @Delete
    suspend fun delete(note : Note)       // we use suspend keyword so that these functions can only be called by background threads

    @Query("SELECT * FROM notes_table ORDER BY id ASC")
    fun getAllNotes() : LiveData<List<Note>>          // making it live data it notifies every time if there is a change in the data
}