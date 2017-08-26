package com.example.quaresma.classicsnake;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "MinhasPreferencias";
    static final int CONFIG = 1;
    int tam = 35;
    int dif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View v){
        Intent i = new Intent(this, Tabuleiro.class);
        Bundle b = new Bundle();
        b.putInt("tab", tam);
        b.putInt("dif", dif);
        i.putExtras(b);
        startActivity(i);
    }

    public void config(View v){
        Intent i = new Intent(this, Settings.class);
        startActivityForResult(i, CONFIG);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == CONFIG){
            if(resultCode == RESULT_OK){
                tam = data.getIntExtra("tab", 0);
                dif = data.getIntExtra("dif", 0);
            }
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences settings = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt("tab", tam);
        editor.putInt("dif", dif);
        // Commit the edits!
        editor.commit();
    }
}
