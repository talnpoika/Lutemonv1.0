package com.example.lutemonv10;

import java.io.Serializable;

public class Lutemon implements Serializable {

    private String name;
    private String color;
    private Integer attack;
    private Integer defence;
    private Integer experience;
    private Integer health;
    private Integer maxHealth;
    private Integer iD;
    private Integer wins;
    private Integer losses;

    private Integer attackBasic;
    private Integer defenceBasic;
    private String nameBasic;

    protected Integer mainImage;
    protected Integer deadImage;

    protected Integer attackImage;
    protected Integer defenceImage;


    public Lutemon(String name, String color, Integer attack, Integer defence, Integer experience, Integer health, Integer maxHealth, Integer iD, Integer wins, Integer losses, Integer attackBasic, Integer defenceBasic) {

        this.name = name;
        this.color = color;
        this.attack = attack;
        this.defence = defence;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.iD = iD;
        this.wins = wins;
        this.losses = losses;
        this.attackBasic = attackBasic;
        this.defenceBasic = defenceBasic;
        this.nameBasic = name;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }

    public Integer getiD() {
        return iD;
    }

    public void setiD(Integer iD) {
        this.iD = iD;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }

    public void backToBasics() {
        this.attack = attackBasic;
        this.defence = defenceBasic;
        this.experience = 0;
        this.name = nameBasic;
    }

    public Integer getMainImage() {
        return mainImage;
    }

    public Integer getDeadImage() {
        return deadImage;
    }

    public Integer getAttackImage() {
        return attackImage;
    }

    public Integer getDefenceImage() {
        return defenceImage;
    }
}
