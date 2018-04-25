package com.heumehle.zeth.sciencequiz.model.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

private var DATABASE_VERSION = 1
private val DATABASE_NAME = "Question DB"
private val TABLE_NAME = "Questions"
private val COLUMN_QUESTION = "Question"
private val COLUMN_ANSWER_ONE = "Answer one"
private val COLUMN_ANSWER_TWO = "Answer two"
private val COLUMN_ANSWER_THREE = "Answer three"
private val COLUMN_ANSWER_FOUR = "Answer four"


class QuestionDB constructor(var context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "Created Table " + TABLE_NAME +" (" + "Column Question" + COLUMN_QUESTION +
         "Column Answer One" + COLUMN_ANSWER_ONE + "Column Answer Two" + COLUMN_ANSWER_TWO +
         "Column Answer Three" + COLUMN_ANSWER_THREE + "Column Answer Four" + COLUMN_ANSWER_FOUR + " )"

        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    fun insertData(question: Question) {
        val db = this.writableDatabase
        var cv = ContentValues()

        cv.put(COLUMN_QUESTION, question.question)
        cv.put(COLUMN_ANSWER_ONE, question.answerOne)
        cv.put(COLUMN_ANSWER_TWO, question.answerTwo)
        cv.put(COLUMN_ANSWER_THREE, question.answerThree)
        cv.put(COLUMN_ANSWER_FOUR, question.answerFour)

        var result = db.insert(TABLE_NAME, null, cv)

        if (result == -1.toLong()) {
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        }
    }

}


