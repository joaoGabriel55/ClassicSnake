package com.example.quaresma.classicsnake;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;

public class Tabuleiro extends AppCompatActivity  {

    int orientacao;
    int posX;
    int posY;
    boolean running = true;
    int tam;
    int cont;
    ImageView img[][];
    ArrayList<int []> cobra;
    ArrayList<int []> fruta;
    ImageButton up;
    ImageButton down;
    ImageButton left;
    ImageButton right;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabuleiro);

        GridLayout grid = (GridLayout) findViewById(R.id.grid);
        Bundle b = getIntent().getExtras();
        tam = b.getInt("tab");
        grid.setColumnCount(tam);
        grid.setRowCount(tam);

        img = new ImageView[tam][tam];

        for (int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){

                LayoutInflater inf = LayoutInflater.from(this);
                img[i][j] = (ImageView) inf.inflate(R.layout.image, grid, false);
                grid.addView(img[i][j]);
            }
        }

        up = (ImageButton) findViewById(R.id.up);
        down = (ImageButton) findViewById(R.id.down);
        left = (ImageButton) findViewById(R.id.left);
        right = (ImageButton) findViewById(R.id.right);

        cobra = new ArrayList<>();
        img[2][2].setImageResource(R.drawable.snake);
        startTimerThread();

        fruta = new ArrayList<>();
        img[3][3].setImageResource(R.drawable.fruta);
        startTimerThread();
    }

    private void startTimerThread() {

        final Handler handler = new Handler();

        new Thread (new Runnable() {
            public void run() {
                while (running) {
                    try {
                        Thread.sleep(250);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    handler.post(new Runnable(){
                        public void run() {

                            //Apagar
                            for (int i = 0; i < cobra.size(); i++){
                                img[cobra.get(i)[0]][cobra.get(i)[1]].setImageResource(R.drawable.square);
                            }

                            //Comer
                            for (int i = 0; i < cobra.size(); i++){
                                if(cobra.get(i)[0] == fruta.get(i)[0] && cobra.get(i)[1] == fruta.get(i)[1])
                                    cobra.add(new int[]{0,0});

                            }

                            //Mover
                            for (int i = cobra.size()-1; i >0; i--){
                                cobra.get(i)[0] = cobra.get(i-1)[0];
                                cobra.get(i)[1] = cobra.get(i-1)[1];
                            }

                            //Redesenhar
                            for (int i = 0; i < cobra.size(); i++){
                                img[cobra.get(i)[0]][cobra.get(i)[1]].setImageResource(R.drawable.snake);

                            }
                        }
                    });
                }
            }
        }).start();
    }

    public void mover(){
        if(up.isPressed()){

        }
    }

}
