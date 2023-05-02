package com.example.lutemonv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = MainActivity.this;

    }

    public void switchToLutemon(View view) {
        Intent intent = new Intent(this, LutemonActivity.class);
        startActivity(intent);
    }

    public void switchToGym(View view) {
        Intent intent = new Intent(this, GymActivity.class);
        startActivity(intent);
    }

    public void switchToArena(View view) {
        Intent intent = new Intent(this, ArenaActivity.class);
        startActivity(intent);
    }

    public void loadGame(View view) {
        Storage.getInstance().loadGame(context);
    }

    public void saveGame(View view) {
        Storage.getInstance().saveGame(context);
    }

}