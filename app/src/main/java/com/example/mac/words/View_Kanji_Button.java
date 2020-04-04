package com.example.mac.words;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class View_Kanji_Button extends AppCompatActivity {

    public ListView listView;
    public Database_Helper_New database_helper_new;
    public SearchView searchView;
    public ToggleButton kanji_button;
    public ToggleButton japanese_button;
    public Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__kanji__button);

        listView = (ListView) findViewById(R.id.listView);
        database_helper_new = new Database_Helper_New(this);
        searchView = (SearchView) findViewById(R.id.searchView);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(View_Kanji_Button.this, View_Kanji_Play_Button.class);
                startActivity(intent);
            }
        });

        kanji_button = (ToggleButton) findViewById(R.id.kanji_button);
        kanji_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (kanji_button.isChecked()) {
                    loadKanji();
                } else {
                    loadData();
                }
            }
        });

        japanese_button = (ToggleButton) findViewById(R.id.japanese_button);
        japanese_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (japanese_button.isChecked()) {
                    loadJapanese();
                } else {
                    loadData();
                }
            }
        });

        loadData();
    }

    public void loadData() {
        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_helper_new.showAllKanji();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "There Are No Words.", Toast.LENGTH_SHORT).show();
        } else {
            int i = 0;
            while (cursor.moveToNext()) {
                i++;
                if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() == 0 && cursor.getString(4).length() == 0 && cursor.getString(6).length() == 0 && cursor.getString(8).length() == 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(6).length() != 0 && cursor.getString(2).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(2).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(4).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + " = " + cursor.getString(5) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(6).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(6)) + " = " + cursor.getString(7) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else if (cursor.getString(8).length() != 0) {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(8)) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                } else {
                    listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + " = " + cursor.getString(3) + "\n" + cursor.getString(4) + " = " + cursor.getString(5) + "\n" + cursor.getString(6) + " = " + cursor.getString(7) + "\n" + cursor.getString(8) + " = " + cursor.getString(9) + "\n" + cursor.getString(11) + "\n" + cursor.getString(10) + "\nKanji Of: " + cursor.getString(12) + "\nMeaning: " + cursor.getString(13) + ".");
                }
            }
        }

        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_new, R.id.list_view, listData);
        listView.setAdapter(adapter);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String arg0) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });
    }


    public void loadKanji() {

        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_helper_new.showAllKanji();

        int i = 0;
        while (cursor.moveToNext()) {
            i++;

            if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(6)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() == 0 && cursor.getString(4).length() == 0 && cursor.getString(6).length() == 0 && cursor.getString(8).length() == 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(6)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(6)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(6)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(4)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(6)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(6).length() != 0 && cursor.getString(2).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(6)) + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(6)) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(2).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(4).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(4)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(6).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(6)) + "\n" + cursor.getString(10) + ".");
            } else if (cursor.getString(8).length() != 0) {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(8)) + "\n" + cursor.getString(10) + ".");
            } else {
                listData.add(i + ". " + cursor.getString(1) + "\n" + (cursor.getString(2)) + "\n" + cursor.getString(4) + "\n" + cursor.getString(6) + "\n" + cursor.getString(8) + "\n" + cursor.getString(10) + ".");
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_new, R.id.list_view, listData);
        listView.setAdapter(adapter);
    }


    public void loadJapanese() {

        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_helper_new.showAllKanji();
        int i = 0;
        while (cursor.moveToNext()) {
            i++;
            if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(5)) + "\n" + (cursor.getString(7)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() == 0 && cursor.getString(4).length() == 0 && cursor.getString(6).length() == 0 && cursor.getString(8).length() == 0) {
                listData.add(i + ". " + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(5)) + "\n" + (cursor.getString(7)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(5)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(7)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(5)) + "\n" + (cursor.getString(7)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(4).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(5)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(6).length() != 0) {
                listData.add(i + ". " + (cursor.getString(5)) + "\n" + (cursor.getString(7)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(6).length() != 0 && cursor.getString(2).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(7)) + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(4).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(5)) + "\n" + (cursor.getString(7)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(6).length() != 0 && cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(7)) + "\n" + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(2).length() != 0) {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(4).length() != 0) {
                listData.add(i + ". " + (cursor.getString(5)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(6).length() != 0) {
                listData.add(i + ". " + (cursor.getString(7)) + "\n" + cursor.getString(11) + ".");
            } else if (cursor.getString(8).length() != 0) {
                listData.add(i + ". " + (cursor.getString(9)) + "\n" + cursor.getString(11) + ".");
            } else {
                listData.add(i + ". " + (cursor.getString(3)) + "\n" + cursor.getString(5) + "\n" + cursor.getString(7) + "\n" + cursor.getString(9) + "\n" + cursor.getString(11) + ".");
            }
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item_new, R.id.list_view, listData);
        listView.setAdapter(adapter);
    }
}


