package com.company;

import java.util.function.IntUnaryOperator;

enum  Weapon {
    Bare_Hand(1), Short_Sword(5), Long_Sword(10), Great_Sword(100), Pigs_Wide_Leg(1234);
    private int damage;
    private int enchantLevel=0;
    private IntUnaryOperator op = value->(int)(value*(1+(double)enchantLevel/10));
    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public void enchantWeapon() {
        enchantLevel++;
        damage=op.applyAsInt(damage);
    }
}
