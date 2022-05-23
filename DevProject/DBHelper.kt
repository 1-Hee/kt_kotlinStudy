package co.kr.to_it

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper : SQLiteOpenHelper {
    constructor(context: Context) : super(context, "memo.db", null, 1)

    override fun onCreate(p0: SQLiteDatabase?) {

        val sql = """
            create table memotable
            (rec_idx integer primary key autoincrement,
            rec_subject text not null,
            rec_time date not null,
            rec_stars integer not null,
            rec_memo text)
        """.trimIndent()

        p0?.execSQL(sql)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}