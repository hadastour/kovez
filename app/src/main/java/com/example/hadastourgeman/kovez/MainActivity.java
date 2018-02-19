package com.example.hadastourgeman.kovez;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.Buffer;

public class MainActivity extends AppCompatActivity {
    EditText e2;
    TextView t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e2 = (EditText) findViewById(R.id.e2);
        t=(TextView)findViewById(R.id.t);}
    public void e1(View view) {
        String in=e2.getText().toString();
        FileOutputStream fos=null;
        try {
            fos=openFileOutput("hadas", Context.MODE_PRIVATE);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        OutputStreamWriter osw=new OutputStreamWriter(fos);
        BufferedWriter bw=new BufferedWriter(osw);
        try {
            bw.write(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void b1(View view) {
        InputStream is=null;
        try {
            is=openFileInput("hadas");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        InputStreamReader tmp=new InputStreamReader(is);
        BufferedReader reader=new BufferedReader(tmp);
        String st="";
        StringBuffer buffer=new StringBuffer();
        try {
            while ((st=reader.readLine()) != null)
            {
                buffer.append(st+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        t.setText(buffer);
    }
}
