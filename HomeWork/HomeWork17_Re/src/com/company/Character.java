package com.company;

public interface Character {
    public void setTotalDamage(int totalDamage);
    public void setName(String name);
    public String getName();
    public void addWeapon(Weapon weapon);
    public void removeWeapon(Weapon weapon);
    public void changeWeapon(Weapon weapon);
    public void showWeapon();
    public void addPotion(Potion potion);
    public void removePotion(Potion potion);
    public void showPotion();
    public void usePotion(Potion potion);
    public void setRemainHealth(int takeDamage);
    public void setRemainMana(int usedMana);
    public int getRemainHealth();
    public void resetRemainHealth();
    public void resetRemainMana();
    public void updateStaticValues();
    public int getAttackSpeed();
    public void setAttackSpeed(int attackSpeed);
    public int getHP();
    public int getMP();
    public int getSTR();
    public int getDEX();
    public int getMaxHealth();
    public int getMaxMana();
    public int getTotalDamage();
    public int getMissRate();
}
