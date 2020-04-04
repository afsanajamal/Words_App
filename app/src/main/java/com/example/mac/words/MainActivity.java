package com.example.mac.words;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public Button about_button;
    public Button add_words_button;
    public Button add_kanji_button;
    public Button view_words_button;
    public Button view_kanji_button;
    public Button random_words_button;
    public Button random_kanji_button;
    public Button grammar_button;
    public Button exit_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        about_button=(Button)findViewById(R.id.about_button);
        about_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,About_Button.class);
                startActivity(intentLoadNewActivity);
            }
        });

        add_words_button=(Button)findViewById(R.id.add_words_button);
        add_words_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,Add_Words_Button.class);
                startActivity(intentLoadNewActivity);
            }
        });

        view_words_button=(Button)findViewById(R.id.view_words_button);
        view_words_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,View_Words_Button.class);
                startActivity(intentLoadNewActivity);
            }
        });

        grammar_button=(Button)findViewById(R.id.grammar_button);
        grammar_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity=new Intent(MainActivity.this,Grammar_Button.class);
                startActivity(intentLoadNewActivity);
            }
        });

        exit_button=(Button)findViewById(R.id.exit_button);
        exit_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });
    }
}
