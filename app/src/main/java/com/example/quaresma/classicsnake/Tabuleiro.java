package com.example.quaresma.classicsnake;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Tabuleiro extends AppCompatActivity  {

    int orientacao;
    int posX;
    int posY;
    boolean running = true;
    int tam;
    int cont;
    TextView pontosTxt;
    int pontos = 0;
    ImageView img[][];
    ArrayList<int []> cobra;
    ArrayList<int []> fruta;
    int directionActive=0 ;   //0-direita  1-esquerda   2-cima   3-baixo
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

        atualizacaoDePontos();

        img = new ImageView[tam][tam];

        for (int i = 0; i < tam; i++){
            for(int j = 0; j < tam; j++){

                LayoutInflater inf = LayoutInflater.from(this);
                img[i][j] = (ImageView) inf.inflate(R.layout.image, grid, false);
                grid.addView(img[i][j]);
            }
        }

        startInitialsParams();

       /* up = (ImageButton) findViewById(R.id.up);
        down = (ImageButton) findViewById(R.id.down);
        left = (ImageButton) findViewById(R.id.left);
        right = (ImageButton) findViewById(R.id.right);

        cobra = new ArrayList<>();
        img[2][2].setImageResource(R.drawable.snake);
        startTimerThread();

        fruta = new ArrayList<>();
        img[3][3].setImageResource(R.drawable.fruta);
        startTimerThread();*/
    }

    public void atualizacaoDePontos(){
        pontosTxt = (TextView) findViewById(R.id.score);
        pontosTxt.setText(""+this.pontos);
    }

    public void clickControl(View v){

        if (v.getId() == R.id.right && directionActive != 1) {
            directionActive = 0;
            left = (ImageButton) findViewById(R.id.left);
        } else if (v.getId() == R.id.left && directionActive != 0){
            directionActive = 1;
            right = (ImageButton) findViewById(R.id.right);
        } else if (v.getId() == R.id.upper && directionActive != 3){
            directionActive = 2;
            down = (ImageButton) findViewById(R.id.down);
        } else if (v.getId() == R.id.down && directionActive != 2) {
            directionActive = 3;
            up = (ImageButton) findViewById(R.id.upper);
        }

    }

    public void pause(){
        if(running){
            running = false;
            startGame();
            return;
        } else {
          running = true;
            startGame();
            return;
        }

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
}
