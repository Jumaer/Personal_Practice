package com.example.projectmy_personal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database_Helper_Project extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "project.db";
    public static final int DATABASE_VERSION=1;
    public static final String PROJECT_TABLE = "project_table";
    public static final String COL_NAME = "name";
    public static final String COL_AGE = "age";
    public static final String COL_ID = "_id";
    public static final String COL_ADDRESS = "address";
    public static final String CREATE_TABLE= "create table "+PROJECT_TABLE+ " (" +COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +COL_NAME+" TEXT, "+COL_AGE+" INTEGER NOT NULL, "+ COL_ADDRESS+" TEXT "+ ")";


    public Database_Helper_Project(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
           db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists " + PROJECT_TABLE);
            this.onCreate(db);
    }
}
