package com.example.lutemonv10;

public class Battlefield {

    Integer result;
    Integer random;

    public Battlefield() {
    }

    public int fight(Lutemon a, Lutemon b) {
        random = (int)(Math.random() * 3) + 1;
        return result = (a.getAttack() + random) - b.getDefence();
    }


}
