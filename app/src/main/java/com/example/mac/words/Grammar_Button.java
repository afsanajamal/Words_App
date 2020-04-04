package com.example.mac.words;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Grammar_Button extends AppCompatActivity {

    public static final String File_Name = "New Text Document.txt";
    public Button viewButton;
    public Button updateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar__button);


        File file = new File(getFilesDir(), File_Name);
        if (file.exists())
        {

        }
        else
        {
        try {
            FileOutputStream fileOutputStream = openFileOutput("New Text Document.txt", MODE_PRIVATE);
            fileOutputStream.close();
            Toast.makeText(getApplicationContext(), "File Created.", Toast.LENGTH_SHORT).show();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }


        viewButton = (Button) findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Grammar_Button.this, Grammar_View_Button.class);
                File file = new File(getFilesDir(), File_Name);
                if (file.exists()) {
                    startActivity(intentLoadNewActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Create File First.", Toast.LENGTH_SHORT).show();
                }
            }
        });


        updateButton = (Button) findViewById(R.id.updateButton);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLoadNewActivity = new Intent(Grammar_Button.this, Grammar_Update_Button.class);
                File file = new File(getFilesDir(), File_Name);
                if (file.exists()) {
                    startActivity(intentLoadNewActivity);
                } else {
                    Toast.makeText(getApplicationContext(), "Please Create File First.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
