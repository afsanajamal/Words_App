package com.example.mac.words;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class View_Kanji_Play_Button extends AppCompatActivity {

    public static List<String> myVal = new ArrayList<String>();
    public static List<String> mywords = new ArrayList<String>();
    public ListView listView;
    public ListView listViewMain;
    public Database_Helper_New database_helper_new;
    public TextView chosenWords;
    public TextView generateRandomWords;
    public TextView chosen_Words;
    public TextView choose_Words;
    public int size;

    public ToggleButton hideButton;
    public Button clearButton;

    public Button random_kanji_button;
    public Button random_japanese_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__kanji__play__button);


        listView = (ListView) findViewById(R.id.listView);
        listViewMain = (ListView) findViewById(R.id.listViewMain);
        database_helper_new = new Database_Helper_New(this);
        chosenWords = (TextView) findViewById(R.id.chosenWords);
        generateRandomWords = (TextView) findViewById(R.id.generateRandomWords);
        chosen_Words = (TextView) findViewById(R.id.chosen_Words);
        choose_Words = (TextView) findViewById(R.id.choose_Words);


        hideButton = (ToggleButton) findViewById(R.id.hideButton);
        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (hideButton.isChecked()) {
                    chosenWords.setVisibility(View.INVISIBLE);
                    listView.setVisibility(View.INVISIBLE);
                    chosen_Words.setVisibility(View.INVISIBLE);
                    ;
                    choose_Words.setVisibility(View.INVISIBLE);
                } else {
                    chosenWords.setVisibility(View.VISIBLE);
                    listView.setVisibility(View.VISIBLE);
                    chosen_Words.setVisibility(View.VISIBLE);
                    ;
                    choose_Words.setVisibility(View.VISIBLE);
                }
            }
        });


        clearButton = (Button) findViewById(R.id.clearButton);
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myVal.clear();
                chosenWords.setText("");
                size = 0;
                listViewMain.setAdapter(null);
            }
        });


        random_kanji_button = (Button) findViewById(R.id.random_kanji_button);
        random_kanji_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomKanji();
            }
        });


        random_japanese_button = (Button) findViewById(R.id.random_japanese_button);
        random_japanese_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                randomJapanese();
            }
        });
        loadData();
    }
    public void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_helper_new.showAllKanji();

        while (cursor.moveToNext()) {
            if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() == 0 && cursor.getString(4).length() == 0 && cursor.getString(6).length() == 0 && cursor.getString(8).length() == 0) {
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(6).length() != 0 && cursor.getString(2).length() != 0) {
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));
            } else if (cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(2).length() != 0) {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(4).length() != 0) {
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(6).length() != 0) {
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else if (cursor.getString(8).length() != 0) {
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));

            } else {
                listData.add(cursor.getString(2));
                listData.add(cursor.getString(3));
                listData.add(cursor.getString(4));
                listData.add(cursor.getString(5));
                listData.add(cursor.getString(6));
                listData.add(cursor.getString(7));
                listData.add(cursor.getString(8));
                listData.add(cursor.getString(9));
                listData.add(cursor.getString(10));
                listData.add(cursor.getString(11));
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_small, R.id.list_view_id, listData);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedValue = listView.getItemAtPosition(position).toString();
                myVal.add(selectedValue);
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(myVal.toString().replace("[", "").replace("]", "").replace(",", "\n"));
                chosenWords.setText(stringBuilder);
                chosenWords.setMovementMethod(new ScrollingMovementMethod());
            }
        });
    }

    public void randomKanji() {
        mywords.clear();
        size = myVal.size();
        if (size == 0) {
            Toast.makeText(getApplicationContext(), "Please Select Words To Get Info.", Toast.LENGTH_SHORT).show();
        } else if (size % 2 == 1) {
            Toast.makeText(getApplicationContext(), "Please Select Both Words And Word's Meanings.", Toast.LENGTH_SHORT).show();
        } else {
            for (int x = 0; x < size; x = x + 2) {
                mywords.add(myVal.get(x));
            }
            Collections.shuffle(mywords);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_big, R.id.list_view_id, mywords);
            listViewMain.setAdapter(adapter);
        }
    }

    public void randomJapanese() {
        mywords.clear();
        size = myVal.size();
        if (size == 0) {
            Toast.makeText(getApplicationContext(), "Please Select Words To Get Info.", Toast.LENGTH_SHORT).show();
        } else if (size % 2 == 1) {
            Toast.makeText(getApplicationContext(), "Please Select Both Words And Word's Meanings.", Toast.LENGTH_SHORT).show();
        } else {
            for (int x = 1; x < size; x = x + 2) {
                mywords.add(myVal.get(x));
            }
            Collections.shuffle(mywords);
            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_big, R.id.list_view_id, mywords);
            listViewMain.setAdapter(adapter);
        }
    }
}



