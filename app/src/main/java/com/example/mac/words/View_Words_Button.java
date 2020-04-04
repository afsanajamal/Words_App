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

public class View_Words_Button extends AppCompatActivity {

    public ListView listView;
    public Database_Helper database_Helper;
    public SearchView searchView;
    public ToggleButton japanese_button;
    public ToggleButton english_button;
    public Button playButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view__words__button);

        listView = (ListView) findViewById(R.id.listView);
        database_Helper = new Database_Helper(this);
        searchView=(SearchView) findViewById(R.id.searchView);

        playButton = (Button) findViewById(R.id.playButton);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(View_Words_Button.this,View_Words_Play_Button.class);
                startActivity(intent);
            }
        });


        japanese_button = (ToggleButton) findViewById(R.id.japanese_button);
        japanese_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (japanese_button.isChecked())
                {
                    loadJapanese();
                }
                else
                {
                    loadData();
                }
            }
        });


        english_button = (ToggleButton) findViewById(R.id.english_button);
        english_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (english_button.isChecked())
                {
                    loadEnglish();
                }
                else
                {
                    loadData();
                }
            }
        });

        loadData();
    }

    ///Main Code To Load Data......
    public void loadData() {
        final ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_Helper.showAllData();
        if (cursor.getCount() == 0)
        {
            Toast.makeText(getApplicationContext(), "There Are No Words.", Toast.LENGTH_SHORT).show();
        }
        else
        {
            int i=0;
            while (cursor.moveToNext())
            {
                i++;
                listData.add(i +". "+cursor.getString(1)+" = "+cursor.getString(2));
            }
        }
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,R.layout.list_item,R.id.list_view_id,listData);
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

    public void loadJapanese() {

        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_Helper.showAllData();

        int i=0;
        while (cursor.moveToNext())
        {
            i++;
            listData.add(i +". "+cursor.getString(1));
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_view_id, listData);
        listView.setAdapter(adapter);
    }


    public void loadEnglish() {

        ArrayList<String> listData = new ArrayList<>();
        Cursor cursor = database_Helper.showAllData();

        int i=0;
        while (cursor.moveToNext())
        {
            i++;
            listData.add(i +". "+cursor.getString(2));
        }
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.list_item, R.id.list_view_id, listData);
        listView.setAdapter(adapter);
    }
}
