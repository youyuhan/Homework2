package com.example.administrator.weektest04;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class SecondActivity extends AppCompatActivity {

    TextView textView;
    BufferedReader buffer;
    StringBuilder stringBuilder;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView=(TextView)findViewById(R.id.textView);
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = openFileInput("data");
            buffer=new BufferedReader( new InputStreamReader(fileInputStream));
            String line;
            while((line=buffer.readLine())!=null){
                stringBuilder.append(line);
            }
            String string=stringBuilder.toString();
            textView.setText(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
