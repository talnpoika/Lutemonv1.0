package com.example.lutemonv10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ArenaActivity extends AppCompatActivity {


    CheckBox zero, one, two, three, four, zeroB, oneB, twoB, threeB, fourB, fightReport;
    private ArrayList<String> texts = new ArrayList<>();
    RecyclerView rv;

    BattleTextAdapter btAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arena);

        rv = findViewById(R.id.rvText);

        rv.setLayoutManager(new LinearLayoutManager(this));
        btAdapter = new BattleTextAdapter(this, texts);

        rv.setAdapter(btAdapter);

        zero = findViewById(R.id.cbZero);
        one = findViewById(R.id.cbOne);
        two = findViewById(R.id.cbTwo);
        three = findViewById(R.id.cbThree);
        four = findViewById(R.id.cbFour);

        fightReport = findViewById(R.id.cbShowReport);

        fightReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(fightReport.isChecked()) {
                    rv.setVisibility(View.VISIBLE);
                } else {
                    rv.setVisibility(View.GONE);
                }
            }
        });


        zero.setText(Storage.getInstance().getLutemons().get(0).getName() + " ("  + Storage.getInstance().getLutemons().get(0).getColor() + ")");
        one.setText(Storage.getInstance().getLutemons().get(1).getName() + " ("  + Storage.getInstance().getLutemons().get(1).getColor() + ")");
        two.setText(Storage.getInstance().getLutemons().get(2).getName() + " ("  + Storage.getInstance().getLutemons().get(2).getColor() + ")");
        three.setText(Storage.getInstance().getLutemons().get(3).getName() + " ("  + Storage.getInstance().getLutemons().get(3).getColor() + ")");
        four.setText(Storage.getInstance().getLutemons().get(4).getName() + " ("  + Storage.getInstance().getLutemons().get(4).getColor() + ")");


        zeroB = findViewById(R.id.cbBZero);
        oneB = findViewById(R.id.cbBOne);
        twoB = findViewById(R.id.cbBTwo);
        threeB = findViewById(R.id.cbBThree);
        fourB = findViewById(R.id.cbBFour);

        zeroB.setText(Storage.getInstance().getLutemons().get(0).getName() + " ("  + Storage.getInstance().getLutemons().get(0).getColor() + ")");
        oneB.setText(Storage.getInstance().getLutemons().get(1).getName() + " ("  + Storage.getInstance().getLutemons().get(1).getColor() + ")");
        twoB.setText(Storage.getInstance().getLutemons().get(2).getName() + " ("  + Storage.getInstance().getLutemons().get(2).getColor() + ")");
        threeB.setText(Storage.getInstance().getLutemons().get(3).getName() + " ("  + Storage.getInstance().getLutemons().get(3).getColor() + ")");
        fourB.setText(Storage.getInstance().getLutemons().get(4).getName() + " ("  + Storage.getInstance().getLutemons().get(4).getColor() + ")");

    }

    public void battle(View view) {
        Battlefield bf = new Battlefield();


        Integer posA = 0;
        Integer posB = 1;

        if(zero.isChecked()) {
            posA = 0;
        } else if (one.isChecked()) {
            posA = 1;
        } else if (two.isChecked()) {
            posA = 2;
        } else if (three.isChecked()) {
            posA = 3;
        } else if (four.isChecked()) {
            posA = 4;
        }
        Lutemon a = Storage.getInstance().getLutemons().get(posA);

        if(zeroB.isChecked()) {
            posB = 0;
        } else if (oneB.isChecked()) {
            posB = 1;
        } else if (twoB.isChecked()) {
            posB = 2;
        } else if (threeB.isChecked()) {
            posB = 3;
        } else if (fourB.isChecked()) {
            posB = 4;
        }

        Lutemon b = Storage.getInstance().getLutemons().get(posB);
        boolean endFight = true;


        if(posA != posB) {
            while(endFight){
                btAdapter.addItem("Taistelija A: " + a.getName() + " (" + a.getColor() + ") energia: " + a.getHealth() + "/" + a.getMaxHealth());
                btAdapter.addItem("Taistelija B: " + b.getName() + " (" + b.getColor() + ") energia: " + b.getHealth() + "/" + b.getMaxHealth());

                Toast.makeText(this, "Taistelija A: " + a.getName() + " (" + a.getColor() + ") energia: " + a.getHealth() + "/" + a.getMaxHealth() + "\n" + "Taistelija B: " + b.getName() + " (" + b.getColor() + ") energia: " + b.getHealth() + "/" + b.getMaxHealth() , Toast.LENGTH_SHORT).show();

                b.setHealth(b.getHealth() - bf.fight(a,b));

                ImageView attackImage = new ImageView(getApplicationContext());
                Toast attackToast = new Toast(getApplicationContext());
                attackToast.setDuration(Toast.LENGTH_SHORT);
                attackImage.setImageResource(a.getAttackImage());
                attackToast.setView(attackImage);
                attackToast.show();

                ImageView defenceImage = new ImageView(getApplicationContext());
                Toast defenceToast = new Toast(getApplicationContext());
                defenceToast.setDuration(Toast.LENGTH_SHORT);
                defenceImage.setImageResource(b.getDefenceImage());
                defenceToast.setView(defenceImage);
                defenceToast.show();

                Toast.makeText(this, a.getName() + " hyökkää " + b.getName() + " puolustaa!", Toast.LENGTH_SHORT).show();


                if(b.getHealth() >= 1) {
                    btAdapter.addItem(b.getName() + " onnistui välttämään kuoleman taistelu jatkuu!");
                    Toast.makeText(this, b.getName() + " onnistui välttämään kuoleman taistelu jatkuu!", Toast.LENGTH_SHORT).show();

                } else if (b.getHealth() <= 0) {
                    btAdapter.addItem(b.getName() + " menehtyi taistelun tuoksinassa!");
                    Toast.makeText(this, b.getName() + " menehtyi kovan taistelun jälkeen saappaat jalassaan!", Toast.LENGTH_SHORT).show();
                    ImageView deadImage = new ImageView(getApplicationContext());

                    Toast deadToast = new Toast(getApplicationContext());
                    deadToast.setDuration(Toast.LENGTH_LONG);
                    deadImage.setImageResource(b.getDeadImage());
                    deadToast.setView(deadImage);
                    deadToast.show();

                    a.setWins(a.getWins() + 1);
                    a.setExperience(a.getExperience() + 1);
                    b.setLosses(b.getLosses() + 1);
                    b.backToBasics();
                    endFight = false;
                    continue;
                }
                a.setHealth(a.getHealth() - bf.fight(b,a));

                ImageView attackImageSecond = new ImageView(getApplicationContext());
                Toast attackToastSecond = new Toast(getApplicationContext());
                attackToastSecond.setDuration(Toast.LENGTH_SHORT);
                attackImageSecond.setImageResource(b.getAttackImage());
                attackToastSecond.setView(attackImageSecond);
                attackToastSecond.show();

                ImageView defenceImageSecond = new ImageView(getApplicationContext());
                Toast defenceToastSecond = new Toast(getApplicationContext());
                defenceToastSecond.setDuration(Toast.LENGTH_SHORT);
                defenceImageSecond.setImageResource(a.getDefenceImage());
                defenceToastSecond.setView(defenceImageSecond);
                defenceToastSecond.show();

                Toast.makeText(this, b.getName() + " hyökkää " + a.getName() + " puolustaa!", Toast.LENGTH_SHORT).show();


                if(a.getHealth() >= 1) {
                    btAdapter.addItem(a.getName() + " onnistui välttämään kuoleman taistelu jatkuu!");
                    Toast.makeText(this, a.getName() + " onnistui välttämään kuoleman taistelu jatkuu!", Toast.LENGTH_SHORT).show();

                } else if (a.getHealth() <= 0) {
                    btAdapter.addItem(a.getName() + " menehtyi taistelun tuoksinassa!");
                    Toast.makeText(this, a.getName() + " menehtyi kovan taistelun jälkeen saappaat jalassaan!", Toast.LENGTH_SHORT).show();

                    ImageView deadImage = new ImageView(getApplicationContext());
                    Toast deadToast = new Toast(getApplicationContext());
                    deadToast.setDuration(Toast.LENGTH_LONG);
                    deadImage.setImageResource(a.getDeadImage());
                    deadToast.setView(deadImage);
                    deadToast.show();

                    b.setWins(b.getWins() + 1);
                    b.setExperience(b.getExperience() + 1);
                    a.setLosses(a.getLosses() + 1);
                    a.backToBasics();
                    endFight = false;
                    continue;
                }

            }

        } else {
            Toast.makeText(this,"Valitsit samat taistelijat! Itseään vastaan kamppailu olisi vain julmaa!", Toast.LENGTH_SHORT).show();
        }


    }


    public void returnHome(View view) {
        for(int i = 0; i < Storage.getInstance().getLutemons().size(); i ++) {
            Storage.getInstance().getLutemons().get(i).setHealth(Storage.getInstance().getLutemons().get(i).getMaxHealth());
        }

        Toast.makeText(this, "Lutemonit palaavat kotia taistelun jälkeen!\nTaisteluissa kuolleet Lutemonit on herätetty henkiin jälleen!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }



}
