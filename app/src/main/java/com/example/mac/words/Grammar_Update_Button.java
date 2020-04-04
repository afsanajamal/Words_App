package com.example.mac.words;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Grammar_Update_Button extends AppCompatActivity {

    public EditText updateGrammar;
    public Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grammar__update__button);

        updateGrammar = (EditText) findViewById(R.id.updateGrammar);

        try {
            FileInputStream fileInputStream = openFileInput("New Text Document.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer stringBuffer = new StringBuffer();
            String lines;
            while ((lines = bufferedReader.readLine()) != null) {
                stringBuffer.append(lines + "\n");
            }
            updateGrammar.setText(stringBuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        saveButton=(Button) findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textMessage = updateGrammar.getText().toString();
                try {
                    FileOutputStream fileOutputStream = openFileOutput("New Text Document.txt", MODE_PRIVATE);
                    fileOutputStream.write(textMessage.getBytes());
                    fileOutputStream.close();
                    Toast.makeText(getApplicationContext(), "File Saved.", Toast.LENGTH_LONG).show();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onBackPressed() {

        String textMessage = updateGrammar.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("New Text Document.txt", MODE_PRIVATE);
            fileOutputStream.write(textMessage.getBytes());
            fileOutputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        super.onBackPressed();
    }
}

