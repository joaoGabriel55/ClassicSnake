package com.example.quaresma.classicsnake;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageView;

import java.util.ArrayList;

public class Tabuleiro extends AppCompatActivity  {

    int snakeTile;
    int orientacao;
    int cont;
    int posX;
    int posY;
    boolean running;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuleiro);

        GridLayout grid = (GridLayout) findViewById(R.id.grid);

        for (int i = 0; i < 50; i++){
            for(int j = 0; j < 50; j++){

                LayoutInflater inf = LayoutInflater.from(this);
                ImageView img = (ImageView) inf.inflate(R.layout.image, grid, false);
                grid.addView(img);
            }
        }
        ArrayList<int [][]> cobra = new ArrayList<>();


    }




}
