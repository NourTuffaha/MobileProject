package com.example.mobileproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Shop.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME ="Watches";
    private static final String COLUMN_ID = "Watch_ID";
    private static final String COLUMN_BRAND = "Brand";
    private static final String COLUMN_MODEL = "Model";
    private static final String COLUMN_GENDER = "Gender";
    private static final String COLUMN_ASPECT1 = "Aspect1";
    private static final String COLUMN_ASPECT2 = "Aspect2";
    private static final String COLUMN_ASPECT3 = "Aspect3";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_BRAND + " TEXT," +
                        COLUMN_MODEL + " TEXT," +
                        COLUMN_GENDER + " TEXT," +
                        COLUMN_ASPECT1 + " TEXT," +
                        COLUMN_ASPECT2 + " TEXT," +
                        COLUMN_ASPECT3 + " TEXT);";

        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
