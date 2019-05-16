package com.example.administrator.weektest04;

import android.content.Context;
import android.content.Intent;
import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    Button button;
    EditText editText;
    String str;
    BufferedWriter bufferedWriter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    void init(){
        button=(Button)findViewById(R.id.button);
        editText=(EditText)findViewById(R.id.editText);
        str=editText.getText().toString();
        bufferedWriter=null;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    FileOutputStream fileOutputStream=openFileOutput("data",Context.MODE_PRIVATE);
                    bufferedWriter=new BufferedWriter(new OutputStreamWriter(fileOutputStream));
                    bufferedWriter.write(str);
                    Intent intent=new Intent(MainActivity.this,SecondActivity.class);
                    startActivity(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
