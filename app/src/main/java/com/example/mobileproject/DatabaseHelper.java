package com.example.mobileproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

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
    private static final Double COLUMN_COST = Double.valueOf(0);
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
                        COLUMN_COST + " TEXT," +
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


    void addData(String watchID, String Brand, String Model, String Gender, Double Cost, String Aspect1, String Aspect2, String Aspect3){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

                cv.put(COLUMN_ID, watchID);
                cv.put(COLUMN_BRAND, Brand);
                cv.put(COLUMN_MODEL, Model);
                cv.put(COLUMN_GENDER, Gender);
                cv.put(String.valueOf(COLUMN_COST), Cost);
                cv.put(COLUMN_ASPECT1, Aspect1);
                cv.put(COLUMN_ASPECT2, Aspect2);
                cv.put(COLUMN_ASPECT3, Aspect3);

                long result = db.insert(TABLE_NAME,null,cv);
                if (result == -1)
                    Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(context, "Successfully Added!", Toast.LENGTH_SHORT).show();


    }
}
