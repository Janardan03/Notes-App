package com.example.notes

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Note::class), version = 1, exportSchema = false)
// database tells that this class is actually a database and if we have more than one table then we can add them in the array of entities.
abstract class NoteDatabase : RoomDatabase() {

    abstract fun getNoteDao() : NoteDao

    companion object{                     // here we are making singleton for our database

        @Volatile
        private var INSTANCE: NoteDatabase? = null

        fun getDatabase(context : Context): NoteDatabase {

            return INSTANCE ?: synchronized(this) {         // by applying this synchronized lock we can make our database to accessed at one time by one thread only
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    NoteDatabase::class.java,
                    "note_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}