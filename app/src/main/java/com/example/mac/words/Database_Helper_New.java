package com.example.mac.words;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.widget.Toast;

public class Database_Helper_New extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "KanjiDatabase.db";
    public static final String TABLE_NAME = "kanji_database";
    public static final int VERSION_NUMBER = 2;
    public static final String NUMBER = "_number";

    public static final String KANJI = "Kanji";

    public static final String KANJI_ONE = "Kanjione";
    public static final String HIRAGANA_ONE = "Hiraganaone";

    public static final String KANJI_TWO = "Kanjitwo";
    public static final String HIRAGANA_TWO = "Hiraganatwo";

    public static final String KANJI_THREE = "Kanjithree";
    public static final String HIRAGANA_THREE = "Hiraganathree";

    public static final String KANJI_FOUR = "Kanjifour";
    public static final String HIRAGANA_FOUR = "Hiraganafour";

    public static final String THE_WORD = "Theword";
    public static final String THE_HIRAGANA = "Thehiragana";

    public static final String KANJI_OF = "Kanjiof";
    public static final String THE_MEANING = "Themeaning";

    public static final String CREATE_TABLE = "CREATE TABLE "+TABLE_NAME +" ("+NUMBER+" ,"+KANJI+" VARCHAR(255),"+KANJI_ONE+" VARCHAR(255),"+HIRAGANA_ONE+" VARCHAR(255),"+KANJI_TWO+" VARCHAR(255),"+HIRAGANA_TWO+" VARCHAR(255),"+KANJI_THREE+" VARCHAR(255),"+HIRAGANA_THREE+" VARCHAR(255),"+KANJI_FOUR+" VARCHAR(255),"+HIRAGANA_FOUR+" VARCHAR(255),"+THE_WORD+" VARCHAR(255),"+THE_HIRAGANA+" VARCHAR(255),"+KANJI_OF+" VARCHAR(255),"+THE_MEANING+" VARCHAR(255));";  //INTEGER PRIMARY  KEY AUTOINCREMENT
    public static final String DROP_TABLE= "DROP TABLE IF EXISTS "+TABLE_NAME;
    public static final String SELECT_ALL= "SELECT * FROM "+TABLE_NAME;

    public Context context;

    public Database_Helper_New(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        try {
            Toast.makeText(context,"OnCreate Is Called.", Toast.LENGTH_SHORT).show();
            db.execSQL(CREATE_TABLE);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_SHORT).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try {
            Toast.makeText(context,"OnUpgrade Is Called.", Toast.LENGTH_SHORT).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch (Exception e)
        {
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_SHORT).show();

        }
    }

    public long AddKanji(String kanji,String kanji_one,String hiragana_one,String kanji_two,String hiragana_two,String kanji_three,String hiragana_three,String kanji_four,String hiragana_four,String the_word,String the_hiragana,String kanji_of,String the_meaning)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KANJI,kanji);

        contentValues.put(KANJI_ONE,kanji_one);
        contentValues.put(HIRAGANA_ONE,hiragana_one);

        contentValues.put(KANJI_TWO,kanji_two);
        contentValues.put(HIRAGANA_TWO,hiragana_two);

        contentValues.put(KANJI_THREE,kanji_three);
        contentValues.put(HIRAGANA_THREE,hiragana_three);

        contentValues.put(KANJI_FOUR,kanji_four);
        contentValues.put(HIRAGANA_FOUR,hiragana_four);

        contentValues.put(THE_WORD,the_word);
        contentValues.put(THE_HIRAGANA,the_hiragana);

        contentValues.put(KANJI_OF,kanji_of);

        contentValues.put(THE_MEANING,the_meaning);

        long rowID = sqLiteDatabase.insert(TABLE_NAME,null ,contentValues);
        return rowID;
    }

    public Cursor ViewKanji() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }

    public boolean UpdateKanji(String kanji,String kanji_one,String hiragana_one,String kanji_two,String hiragana_two,String kanji_three,String hiragana_three,String kanji_four,String hiragana_four,String the_word,String the_hiragana,String kanji_of,String the_meaning) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KANJI,kanji);

        contentValues.put(KANJI_ONE,kanji_one);
        contentValues.put(HIRAGANA_ONE,hiragana_one);

        contentValues.put(KANJI_TWO,kanji_two);
        contentValues.put(HIRAGANA_TWO,hiragana_two);

        contentValues.put(KANJI_THREE,kanji_three);
        contentValues.put(HIRAGANA_THREE,hiragana_three);

        contentValues.put(KANJI_FOUR,kanji_four);
        contentValues.put(HIRAGANA_FOUR,hiragana_four);

        contentValues.put(THE_WORD,the_word);
        contentValues.put(THE_HIRAGANA,the_hiragana);

        contentValues.put(KANJI_OF,kanji_of);
        contentValues.put(THE_MEANING,the_meaning);

        sqLiteDatabase.update(TABLE_NAME, contentValues, KANJI +" = ?",new String[] { kanji });
        return true;
    }

    public Integer DeleteKanji(String kanji) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        return sqLiteDatabase.delete(TABLE_NAME,KANJI+ " = ?",new String[] { kanji });
    }

    public Cursor showAllKanji() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL,null);
        return cursor;
    }
}
