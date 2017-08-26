package com.example.quaresma.classicsnake;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioGroup;

public class Settings extends AppCompatActivity {

    private static final String PREFS_NAME = "PREFS";

    private RadioGroup radioGroup1;
    private RadioGroup radioGroup2;
    private int dificuldade;
    private int tabuleiro;

   /* private RadioButton easy;
    private RadioButton medium;
    private RadioButton hard;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.radioGroup1 = (RadioGroup) findViewById(R.id.radioGroup);
        this.radioGroup2 = (RadioGroup) findViewById(R.id.radioGroup2);

    }

    public void setDificuldade(View v){
        if(radioGroup1.getCheckedRadioButtonId() == R.id.easy){
            dificuldade = 1000;
        } else if (radioGroup1.getCheckedRadioButtonId() == R.id.medium){
            dificuldade = 500;
        } else if (radioGroup1.getCheckedRadioButtonId() == R.id.hard){
            dificuldade = 250;

        }
    }

    public void setTabuleiro(View v){
        if(radioGroup2.getCheckedRadioButtonId() == R.id.tab1){
            tabuleiro = 35;
        } else {
            tabuleiro = 20;
        }

    }

    public void setConfig(View v){
        Intent intent= new Intent();
        intent.putExtra("tab", tabuleiro);
        intent.putExtra("dif", dificuldade);
        setResult(RESULT_OK,intent);
        finish();
    }

}
