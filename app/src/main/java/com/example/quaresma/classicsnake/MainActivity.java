package com.example.quaresma.classicsnake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View v){
        Intent i = new Intent(this, Tabuleiro.class);
        startActivity(i);
    }

    public void config(View v){
        Intent i = new Intent(this, Settings.class);
        startActivity(i);
    }

}
