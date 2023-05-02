package com.example.lutemonv10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

public class GymActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gym);

        Button zero = findViewById(R.id.rbIdZero);
        Button one = findViewById(R.id.rbIdOne);
        Button two = findViewById(R.id.rbIdTwo);
        Button three = findViewById(R.id.rbIdThree);
        Button four = findViewById(R.id.rbIdFour);

        zero.setText(Storage.getInstance().getLutemons().get(0).getName().toString());
        one.setText(Storage.getInstance().getLutemons().get(1).getName().toString());
        two.setText(Storage.getInstance().getLutemons().get(2).getName().toString());
        three.setText(Storage.getInstance().getLutemons().get(3).getName().toString());
        four.setText(Storage.getInstance().getLutemons().get(4).getName().toString());

    }

    public void train(View view) {

        RadioGroup rgLutemons = findViewById(R.id.rgLutemons);
        RadioGroup rgAttributes = findViewById(R.id.rgTrainAttribute);

        switch (rgLutemons.getCheckedRadioButtonId()) {
            case R.id.rbIdZero:
                if(rgAttributes.getCheckedRadioButtonId() == R.id.rbAttack) {
                    Storage.getInstance().getLutemons().get(0).setAttack(Storage.getInstance().getLutemons().get(0).getAttack() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(0).getName().toString() + " harjoitteli hyökkäystä!", Toast.LENGTH_SHORT).show();
                } else {
                    Storage.getInstance().getLutemons().get(0).setDefence(Storage.getInstance().getLutemons().get(0).getDefence() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(0).getName().toString() + " harjoitteli puolustusta!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbIdOne:
                if(rgAttributes.getCheckedRadioButtonId() == R.id.rbAttack) {
                    Storage.getInstance().getLutemons().get(1).setAttack(Storage.getInstance().getLutemons().get(0).getAttack() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(1).getName().toString() + " harjoitteli hyökkäystä!", Toast.LENGTH_SHORT).show();
                } else {
                    Storage.getInstance().getLutemons().get(1).setDefence(Storage.getInstance().getLutemons().get(0).getDefence() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(1).getName().toString() + " harjoitteli puolustusta!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbIdTwo:
                if(rgAttributes.getCheckedRadioButtonId() == R.id.rbAttack) {
                    Storage.getInstance().getLutemons().get(2).setAttack(Storage.getInstance().getLutemons().get(2).getAttack() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(2).getName().toString() + " harjoitteli hyökkäystä!", Toast.LENGTH_SHORT).show();
                } else {
                    Storage.getInstance().getLutemons().get(2).setDefence(Storage.getInstance().getLutemons().get(2).getDefence() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(2).getName().toString() + " harjoitteli puolustusta!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbIdThree:
                if(rgAttributes.getCheckedRadioButtonId() == R.id.rbAttack) {
                    Storage.getInstance().getLutemons().get(3).setAttack(Storage.getInstance().getLutemons().get(3).getAttack() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(3).getName().toString() + " harjoitteli hyökkäystä!", Toast.LENGTH_SHORT).show();
                } else {
                    Storage.getInstance().getLutemons().get(3).setDefence(Storage.getInstance().getLutemons().get(3).getDefence() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(3).getName().toString() + " harjoitteli puolustusta!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.rbIdFour:
                if(rgAttributes.getCheckedRadioButtonId() == R.id.rbAttack) {
                    Storage.getInstance().getLutemons().get(4).setAttack(Storage.getInstance().getLutemons().get(4).getAttack() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(4).getName().toString() + " harjoitteli hyökkäystä!", Toast.LENGTH_SHORT).show();
                } else {
                    Storage.getInstance().getLutemons().get(4).setDefence(Storage.getInstance().getLutemons().get(4).getDefence() + 1);
                    Toast.makeText(this, Storage.getInstance().getLutemons().get(4).getName().toString() + " harjoitteli puolustusta!", Toast.LENGTH_SHORT).show();
                }
                break;
        }

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);

    }
}