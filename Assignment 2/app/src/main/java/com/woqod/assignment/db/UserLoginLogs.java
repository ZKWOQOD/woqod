package com.woqod.assignment.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.woqod.assignment.model.LogModel;

import java.util.ArrayList;

public class UserLoginLogs extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "errorlog.db";
    public static final String TABLE_NAME = "log_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "LOG_DETAILS";

    public UserLoginLogs(@Nullable Context context) {
        super(context, DATABASE_NAME, null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(" create table " + TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT,LOG_DETAILS)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertLogs(LogModel logModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, logModel.getLogs());
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }

    }

    public ArrayList<LogModel> logList(){
        String sql = "select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<LogModel> note = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql, null);
        if(cursor.moveToFirst()){
            do{
                int id = Integer.parseInt(cursor.getString(0));
                String detail = cursor.getString(1);
                note.add(new LogModel(detail));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return note;
    }


}
