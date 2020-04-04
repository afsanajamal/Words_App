package com.example.mac.words;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Database_Helper extends SQLiteOpenHelper {  //Don't Touch

    public static final String DATABASE_NAME = "Word.db";
    public static final String TABLE_NAME = "word_table";
    public static final int VERSION_NUMBER = 1;
    public static final String NUMBER = "_number";
    public static final String WORDS = "Word";
    public static final String WORD_MEANINGS = "Meaning";
    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +" ("+NUMBER+" , "+WORDS+" VARCHAR(255),"+WORD_MEANINGS+" VARCHAR(255) );";  //INTEGER PRIMARY  KEY AUTOINCREMENT
    public static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;
    public static final String SELECT_ALL= "SELECT * FROM "+TABLE_NAME;
    public Context context;

    public Database_Helper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        try {
            Toast.makeText(context,"OnCREATE Is Called.", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"OnUpgrade Is Called.", Toast.LENGTH_SHORT).show();
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_SHORT).show();

        }
    }

    public long AddWords(String words,String word_meanings)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(WORDS,words);
        contentValues.put(WORD_MEANINGS,word_meanings);

        long rowID = sqLiteDatabase.insert(TABLE_NAME,null ,contentValues);
        return rowID;
    }

    public Cursor ViewWords() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }

   public boolean UpdateWords(String words,String word_meanings) {
       SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
       ContentValues contentValues = new ContentValues();
       contentValues.put(WORDS,words);
       contentValues.put(WORD_MEANINGS,word_meanings);
        sqLiteDatabase.update(TABLE_NAME, contentValues, WORDS +" = ?",new String[] { words });
        return true;
    }

    public Integer DeleteWords (String words) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,WORDS+ " = ?",new String[] { words });
    }


    public Cursor showAllData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
}
