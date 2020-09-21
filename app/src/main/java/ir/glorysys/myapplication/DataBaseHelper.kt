package ir.glorysys.myapplication

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.ContactsContract
import android.util.Log

class DataBaseHelper(
    context: Context?,
    name: String? = "Database_Test",
    factory: SQLiteDatabase.CursorFactory? = null,
    version: Int = 1
) : SQLiteOpenHelper(context, name, factory, version) {
    var TABLE_TEST = "table_test"
    var COLUMN_ID = "column_id"
    var COLUMN_Name = "column_name"
    var COLUMN_EMAIL = "column_email"
    val TAG = "Database_farid"
    override fun onCreate(p0: SQLiteDatabase?) {
        var createTable: String =
            "create table $TABLE_TEST ( $COLUMN_ID INTEGER PRIMARY KEY , $COLUMN_Name TEXT " +
                    ", $COLUMN_EMAIL TEXT  )"

        p0?.execSQL(createTable)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0?.execSQL("DROP TABLE IF EXISTS $TABLE_TEST")
    }


    fun write(name: String?, email: String?) {
        val database: SQLiteDatabase = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(COLUMN_Name, name)
        contentValues.put(COLUMN_EMAIL, email)
        var result: Long = database.insert(TABLE_TEST, null, contentValues)
        if (result.equals(-1)) {
            Log.d(TAG, "write:  error can not write on database")
        } else {
            Log.d(TAG, "write: successful $name -- $email")
        }
    }

    fun read(): Cursor {
        val sqLiteDatabase: SQLiteDatabase = this.readableDatabase
        var query = "select * FROM $TABLE_TEST"
        var cursor: Cursor ?=null
        if (sqLiteDatabase != null) {
            cursor = sqLiteDatabase.rawQuery(query, null)
        }
        return cursor!!
    }

}