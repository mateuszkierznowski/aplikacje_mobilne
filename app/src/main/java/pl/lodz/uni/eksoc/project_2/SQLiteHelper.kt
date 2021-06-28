package pl.lodz.uni.eksoc.project_2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class SQLiteHelper(context:Context):
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION){

    companion object{
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "players.db"
        private const val TBL_PLAYERS = "tbl_players"
        private const val ID = "id"
        private const val NAME = "name"
        private const val WL1 = "wl1"
        private const val WL2 = "wl2"
        private const val WL3 = "wl3"
        private const val CHAMP1 = "champ1"
        private const val CHAMP2 = "champ2"
        private const val CHAMP3 = "champ3"
        private const val KDA1 = "kda1"
        private const val KDA2 = "kda2"
        private const val KDA3 = "kda3"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        println("on create")
        val createTblStudent = ("CREATE TABLE " + TBL_PLAYERS + "("
                + ID + " INTEGER PRIMARY KEY,"
                + NAME + " TEXT,"
                + WL1 + " TEXT,"
                + WL2 + " TEXT,"
                + WL3 + " TEXT,"
                + CHAMP1 + " TEXT,"
                + CHAMP2 + " TEXT,"
                + CHAMP3 + " TEXT,"
                + KDA1 + " TEXT,"
                + KDA2 + " TEXT,"
                + KDA3 + " TEXT" + ")")
        db?.execSQL(createTblStudent)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        println("on upgrade")
        db!!.execSQL("DROP TABLE IF EXISTS $TBL_PLAYERS")
        onCreate(db)
    }

    fun insertStudent(std: StudentModel): Long{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, std.id)
        contentValues.put(NAME, std.name)
        contentValues.put(WL1, std.wl1)
        contentValues.put(WL2, std.wl2)
        contentValues.put(WL3, std.wl3)
        contentValues.put(CHAMP1, std.champ1)
        contentValues.put(CHAMP2, std.champ2)
        contentValues.put(CHAMP3, std.champ3)
        contentValues.put(KDA1, std.kda1)
        contentValues.put(KDA2, std.kda2)
        contentValues.put(KDA3, std.kda3)

        val success = db.insert(TBL_PLAYERS, null, contentValues)
        db.close()
        return success
    }

    fun getAllStudent(): ArrayList<StudentModel>{
        val stdList: ArrayList<StudentModel> = ArrayList()
        val selectQuery = "Select * FROM $TBL_PLAYERS"
        val db = this.readableDatabase

        val cursor: Cursor?

        try{
            cursor = db.rawQuery(selectQuery, null)
        } catch (e: Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }

        var id:Int
        var name:String
        var wl1:String
        var wl2:String
        var wl3:String
        var champ1:String
        var champ2:String
        var champ3:String
        var kda1:String
        var kda2:String
        var kda3:String

        if(cursor.moveToFirst()){
            do{
                id = cursor.getInt(cursor.getColumnIndex("id"))
                name = cursor.getString(cursor.getColumnIndex("name"))
                wl1 = cursor.getString(cursor.getColumnIndex("wl1"))
                wl2 = cursor.getString(cursor.getColumnIndex("wl2"))
                wl3 = cursor.getString(cursor.getColumnIndex("wl3"))
                champ1 = cursor.getString(cursor.getColumnIndex("champ1"))
                champ2 = cursor.getString(cursor.getColumnIndex("champ2"))
                champ3 = cursor.getString(cursor.getColumnIndex("champ3"))
                kda1 = cursor.getString(cursor.getColumnIndex("kda1"))
                kda2 = cursor.getString(cursor.getColumnIndex("kda2"))
                kda3 = cursor.getString(cursor.getColumnIndex("kda3"))


                val std = StudentModel(id = id, name = name, wl1 = wl1, wl2 = wl2, wl3 = wl3, champ1 = champ1, champ2 = champ2, champ3 = champ3, kda1 = kda1, kda2 = kda2, kda3 = kda3)
                stdList.add(std)
            } while (cursor.moveToNext())

        }
        return stdList

    }

//    fun updateStudent(std: StudentModel): Int {
//        val db = this.writableDatabase
//        val contentValues = ContentValues()
//        contentValues.put(ID, std.id)
//        contentValues.put(NAME, std.name)
//        contentValues.put(EMAIL, std.email)
//
//        val sucess = db.update(TBL_STUDENT, contentValues, "id=" + std.id, null)
//        db.close()
//        return sucess
//        }

    fun deleteStudentById(id:Int): Int{
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(ID, id)
        val sucess = db.delete(TBL_PLAYERS, "id=$id", null)
        db.close()
        return sucess
    }
}
