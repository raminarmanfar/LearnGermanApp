package com.raminarmanfar.learngermanapp.models

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

class DBHandler(context: Context?, name: String?, factory: SQLiteDatabase.CursorFactory?, version: Int) :
        SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    companion object {
        private val DATABASE_NAME = "LearnGerman.db"
        private val DATABASE_VERSION = 1

        val HP_TABLE_NAME = "HerrProfessor"
        val COL_HP_ID = "hpId"
        val COL_HP_COURSE_TITLE = "hpCourseTitle"
        val COL_HP_TRANSLATION = "hpTranslation"
        val COL_HP_YOUTUBE_LINK = "hpYoutubeLink"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_HP_TABLE: String = ("CREATE TABLE $HP_TABLE_NAME (" +
                "$COL_HP_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                "$COL_HP_COURSE_TITLE TEXT," +
                "$COL_HP_TRANSLATION TEXT," +
                "$COL_HP_YOUTUBE_LINK TEXT)")
        db?.execSQL(CREATE_HP_TABLE)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun getHps(mCtx: Context?): ArrayList<HerrProfessorModel> {
        val qry = "SELECT * FROM $HP_TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(qry, null)
        val hps = ArrayList<HerrProfessorModel>()

        if (cursor.count == 0)
            Toast.makeText(mCtx, "No Records Found!", Toast.LENGTH_LONG).show()
        else {
            while (cursor.moveToNext()) {
                val hp = HerrProfessorModel()
                hp.hpId = cursor.getInt(cursor.getColumnIndex(COL_HP_ID))
                hp.hpCourseTitle = cursor.getString(cursor.getColumnIndex(COL_HP_COURSE_TITLE))
                hp.hpTranslation = cursor.getString(cursor.getColumnIndex(COL_HP_TRANSLATION))
                hp.hpYoutubeLink = cursor.getString(cursor.getColumnIndex(COL_HP_YOUTUBE_LINK))
                hps.add(hp)
            }
            Toast.makeText(mCtx, "${cursor.count.toString()} Records found.", Toast.LENGTH_SHORT).show()
        }
        cursor.close()
        db.close()
        return hps
    }
}