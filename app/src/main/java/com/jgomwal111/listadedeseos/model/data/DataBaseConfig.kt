package com.jgomwal111.listadedeseos.model.data

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.jgomwal111.listadedeseos.model.dataObject.User

class DataBaseConfig (context: Context):SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    private val db: SQLiteDatabase
    private val values: ContentValues

    companion object {
        private val DATABASE_VERSION = 1
        private val DATABASE_NAME = "Users"
    }

    init {
        db = this.writableDatabase
        values = ContentValues()
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL(
            "CREATE TABLE " + Tables.Users.TABLE_NAME + " (" +
                    Tables.Users._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    Tables.Users.COLUMN_NAME + " TEXT NOT NULL)"
        )
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insert(user: List<User>) {
        values.put(Tables.Users.COLUMN_NAME, user[0].getName())
        db.insert(Tables.Users.TABLE_NAME, null, values)
    }
}