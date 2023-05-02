package com.example.lutemonv10;

import android.content.Context;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage{

    private static Storage singleton = null;
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    private Storage(){
        lutemons.add(new WhiteLutemon());
        lutemons.add(new GreenLutemon());
        lutemons.add(new PinkLutemon());
        lutemons.add(new OrangeLutemon());
        lutemons.add(new BlackLutemon());
    }

    public static Storage getInstance() {
        if(singleton == null) {
            singleton = new Storage();
        }
        return singleton;
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void saveGame(Context context) {
        try {
            ObjectOutputStream gameWriter = new ObjectOutputStream(context.openFileOutput("game.data", Context.MODE_PRIVATE));
            gameWriter.writeObject(lutemons);
            gameWriter.close();
            Toast.makeText(context, "Peli tallennettu onnistuneesti", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            System.out.println("Pelin tallentaminen epäonnistui!");
            Toast.makeText(context, "Pelin tallentaminen epäonnistui.", Toast.LENGTH_SHORT).show();
        }
    }

    public void loadGame(Context context) {
        try {
            ObjectInputStream gameReader = new ObjectInputStream(context.openFileInput("game.data"));
            lutemons = (ArrayList<Lutemon>) gameReader.readObject();
            gameReader.close();
            Toast.makeText(context, "Peli ladattu edellisestä tallennuksesta!", Toast.LENGTH_SHORT).show();
        } catch (FileNotFoundException e) {
            System.out.println("Pelin lataaminen epäonnistui.");
            e.printStackTrace();
            Toast.makeText(context, "Pelin lataaminen epäonnistui.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            System.out.println("Pelin lataaminen epäonnistui.");
            e.printStackTrace();
            Toast.makeText(context, "Pelin lataaminen epäonnistui.", Toast.LENGTH_SHORT).show();
        } catch (ClassNotFoundException e) {
            System.out.println("Pelin lataaminen epäonnistui.");
            e.printStackTrace();
            Toast.makeText(context, "Pelin lataaminen epäonnistui.", Toast.LENGTH_SHORT).show();
        }
    }
}
