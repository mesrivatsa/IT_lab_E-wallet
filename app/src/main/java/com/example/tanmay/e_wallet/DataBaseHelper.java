package com.example.tanmay.e_wallet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


class DataBaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "ewallet.db";
    private static final String TABLE_NAME = "wallet_table";
    private static final String COL_ID = "id";
    private static final String COL_mNo = "mNo";
    private static final String COL_name = "name";
    private static final String COL_city = "city";
    private static final String COL_dob = "dob";
    private static final String COL_balance = "balance";

    DataBaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ("
                + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COL_mNo + " TEXT ,"
                + COL_name + " TEXT,"
                + COL_city + " TEXT,"
                + COL_dob + " TEXT,"
                + COL_balance + " TEXT)"
        );
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        switch (i1) {

            case 2:
                sqLiteDatabase.execSQL("alter table " + TABLE_NAME + " rename to old" + TABLE_NAME);
                sqLiteDatabase.execSQL("create table " + TABLE_NAME + " ("
                        + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                        + COL_mNo + " TEXT ,"
                        + COL_name + " TEXT,"
                        + COL_city + " TEXT,"
                        + COL_dob + " TEXT,"
                        + COL_balance + " TEXT)"
                );
                sqLiteDatabase.execSQL("insert or ignore into " + TABLE_NAME + " select  * from old" + TABLE_NAME);
                sqLiteDatabase.execSQL("drop table old" + TABLE_NAME);
                break;
            default:
                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
                onCreate(sqLiteDatabase);
        }


    }

    boolean insertData(String mNo, String name, String city, String dob, String balance) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_mNo, mNo);
        values.put(COL_name, name);
        values.put(COL_city, city);
        values.put(COL_dob, dob);

        values.put(COL_balance, balance);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, values);
        sqLiteDatabase.close();
        return result != -1;

    }

    Cursor getData() {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.rawQuery("select * from " + TABLE_NAME, null);

    }
}
