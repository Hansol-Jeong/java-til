package com.company;

import java.util.function.UnaryOperator;

enum Weapon {
    Bare_Hand(1), Short_Sword(5), Long_Sword(10), Great_Sword(100), Pigs_Wide_Leg(1234);

    private int damage;
    int level = (int)(Math.random()*10%3)+1;
    UnaryOperator<Integer> op = value->(int)(value*(1+(double)level/10));

    Weapon(int damage) {
        this.damage = damage;
    }

    public void enchantWeapon(Weapon weapon) {
        damage = op.apply(damage);
    }

    public int getDamage() {
        return damage;
    }

}