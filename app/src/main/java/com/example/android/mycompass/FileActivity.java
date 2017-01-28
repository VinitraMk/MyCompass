package com.example.android.mycompass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by mikasa on 29/12/16.
 */

public class FileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_view);

        String title=getIntent().getStringExtra("Title");
        setTitle(title);

        InputStreamReader is=new InputStreamReader(getResources().openRawResource(R.raw.tortoise_hare));
        BufferedReader br=new BufferedReader(is);
        String line="";
        //DataInputStream dis=new DataInputStream(bis);
        StringBuilder sb=new StringBuilder();
        try
        {
            while((line=br.readLine())!=null)
            {
                sb.append(line).append("\n");
            }
        }
        catch (IOException e){}

        TextView textView=(TextView)findViewById(R.id.textfile);
        textView.setText(sb.toString().trim());
    }
}
