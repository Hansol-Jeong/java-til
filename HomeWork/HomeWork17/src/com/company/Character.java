package com.company;

public interface Character {
    void setName(String name);
    public String getName();
    public int getAttackSpeed();
    public void setAttackSpeed();
    public void remainHealth(int deal);
    public void setDamage();
    public void setHealth();
    public int getDamage();
    public int getHealth();









}

class Forest_Ghoul implements Character {
    String name;
    int health;
    int attackSpeed;
    int damage;

    public Forest_Ghoul() {
        setName();
        setHealth();
        setAttackSpeed();
        setDamage();
    }



    public void setName() {
        this.name ="Forest_Ghoul";
    }
    public void setHealth() {
        this.health=500;
    }
    public void setAttackSpeed() {
        this.attackSpeed=1;
    }
    public void setDamage() {
        this.damage=50;
    }
    public void setName(String name) {
    }
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getAttackSpeed() {
        return attackSpeed;
    }
    public int getDamage() {
        return damage;
    }
    public void remainHealth(int deal) {
        this.health-=deal;
    }
}