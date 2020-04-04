package com.example.mac.words;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Add_Kanji_Button extends AppCompatActivity  implements View.OnClickListener {

    public Database_Helper_New database_helper_new;

    public EditText theKanji;
    public EditText kanjiOne;
    public EditText hiraganaOne;

    public EditText kanjiTwo;
    public EditText hiraganaTwo;

    public EditText kanjiThree;
    public EditText hiraganaThree;

    public EditText kanjiFour;
    public EditText hiraganaFour;

    public EditText theWord;
    public EditText theHiragana;

    public EditText kanjiOf;
    public EditText theMeaning;

    public Button add_words;
    public Button update_words;
    public Button view_words;
    public Button delete_words;
    public Button clear_words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add__kanji__button);

        database_helper_new = new Database_Helper_New(this);
        SQLiteDatabase db = database_helper_new.getWritableDatabase();

        theKanji = (EditText)findViewById(R.id.theKanji);
        kanjiOne = (EditText)findViewById(R.id.kanjiOne);
        hiraganaOne = (EditText)findViewById(R.id.hiraganaOne);

        kanjiTwo = (EditText)findViewById(R.id.kanjiTwo);
        hiraganaTwo = (EditText)findViewById(R.id.hiraganaTwo);

        kanjiThree = (EditText)findViewById(R.id.kanjiThree);
        hiraganaThree = (EditText)findViewById(R.id.hiraganaThree);

        kanjiFour = (EditText)findViewById(R.id.kanjiFour);
        hiraganaFour = (EditText)findViewById(R.id.hiraganaFour);

        theWord = (EditText)findViewById(R.id.theWord);
        theHiragana = (EditText)findViewById(R.id.theHiragana);

        kanjiOf = (EditText)findViewById(R.id.kanjiOf);
        theMeaning = (EditText)findViewById(R.id.theMeaning);

        add_words = (Button)findViewById(R.id.add_words);
        update_words = (Button)findViewById(R.id.update_words);
        view_words= (Button)findViewById(R.id.view_words);
        delete_words= (Button)findViewById(R.id.delete_words);
        clear_words= (Button)findViewById(R.id.clear_words);

        add_words.setOnClickListener(this);
        update_words.setOnClickListener(this);
        view_words.setOnClickListener(this);
        delete_words.setOnClickListener(this);
        clear_words.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        String kanji = theKanji.getText().toString();

        String kanji_one = kanjiOne.getText().toString();
        String hiragana_one = hiraganaOne.getText().toString();

        String kanji_two = kanjiTwo.getText().toString();
        String hiragana_two = hiraganaTwo.getText().toString();

        String kanji_three = kanjiThree.getText().toString();
        String hiragana_three = hiraganaThree.getText().toString();

        String kanji_four = kanjiFour.getText().toString();
        String hiragana_four = hiraganaFour.getText().toString();

        String the_hiragana = theHiragana.getText().toString();
        String the_word = theWord.getText().toString();

        String kanji_of = kanjiOf.getText().toString();
        String the_meaning = theMeaning.getText().toString();

        if (v.getId()==R.id.add_words)
        {
            if (kanji.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Kanji.", Toast.LENGTH_SHORT).show();
            }
            else if (the_hiragana.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Hiragana.", Toast.LENGTH_SHORT).show();
            }
            else if (the_word.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Word.", Toast.LENGTH_SHORT).show();
            }
            else if (kanji_of.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Meaning Of Kanji.", Toast.LENGTH_SHORT).show();
            }
            else if (the_meaning.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Meaning Of Word.", Toast.LENGTH_SHORT).show();
            }

            else {
                long rowID = database_helper_new.AddKanji(kanji,kanji_one,hiragana_one,kanji_two,hiragana_two,kanji_three,hiragana_three,kanji_four,hiragana_four,the_word,the_hiragana,kanji_of,the_meaning);
                if (rowID > -1) {
                    Toast.makeText(getApplicationContext(), "Added.", Toast.LENGTH_SHORT).show();
                }

                else
                {
                    Toast.makeText(getApplicationContext(), "Not Added.", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if(v.getId()==R.id.view_words)
        {
            Intent intent = new Intent(Add_Kanji_Button.this,View_Kanji_Button.class);
            startActivity(intent);
        }

        else if(v.getId()==R.id.update_words)
        {
            Boolean isUpdated = database_helper_new.UpdateKanji(kanji,kanji_one,hiragana_one,kanji_two,hiragana_two,kanji_three,hiragana_three,kanji_four,hiragana_four,the_word,the_hiragana,kanji_of,the_meaning);

            if (theKanji.equals(""))
            {
                Toast.makeText(getApplicationContext(), "Please Enter Words.", Toast.LENGTH_SHORT).show();
            }
            else
            {
                if (isUpdated == true)
                {
                    Toast.makeText(getApplicationContext(), "Updated.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Not Updated.", Toast.LENGTH_SHORT).show();
                }
            }
        }

        else if (v.getId()==R.id.delete_words)
        {
            int value = database_helper_new.DeleteKanji(kanji);
            if (value>0)
            {
                Toast.makeText(getApplicationContext(),"Deleted.",Toast.LENGTH_SHORT).show();
                theKanji.setText("");
                kanjiOne.setText("");
                hiraganaOne.setText("");
                kanjiTwo.setText("");
                hiraganaTwo.setText("");
                kanjiThree.setText("");
                hiraganaThree.setText("");
                kanjiFour.setText("");
                hiraganaFour.setText("");
                theHiragana.setText("");
                theWord.setText("");
                kanjiOf.setText("");
                theMeaning.setText("");
            }

            else
            {
                Toast.makeText(getApplicationContext(),"Not Deleted.",Toast.LENGTH_SHORT).show();
            }
        }

        else if (v.getId()==R.id.clear_words)
        {
            theKanji.setText("");
            kanjiOne.setText("");
            hiraganaOne.setText("");
            kanjiTwo.setText("");
            hiraganaTwo.setText("");
            kanjiThree.setText("");
            hiraganaThree.setText("");
            kanjiFour.setText("");
            hiraganaFour.setText("");
            theHiragana.setText("");
            theWord.setText("");
            kanjiOf.setText("");
            theMeaning.setText("");
        }
    }
}

    //kanji,kanji_one,hiragana_one,kanji_two,hiragana_two,kanji_three,hiragana_three,kanji_four,hiragana_four,the_word,the_hiragana,kanji_of,the_meaning
