package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int count = 0;
    String num;
    public void buttonPress(View view){
        count++;
        num = "" + count;
        ((TextView)findViewById(R.id.textView)).setText(num);
    }

    public void reset(View view){
        count = 0;
        num = "" + count;
        ((TextView)findViewById(R.id.textView)).setText(num);
    }


}