package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

enum Weapon {
    Bare_Hands(5), Dagger(40), LongSword(100), Dragon_Slayer(250);
    private final int damage;

    Weapon(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }
}

enum Item {
    MushRoom(value->value+20,0), Black_Potion(value->(int)(value*1.1),1), White_Potion(value->value+200,2);
    private IntUnaryOperator op;
    private int prioiry;

    Item(IntUnaryOperator op, int prioiry) {
        this.op = op;
        this.prioiry = prioiry;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getPrioiry() {
        return prioiry;
    }
}


class Player {
    Weapon currentWeapon= Weapon.Bare_Hands;
    List<Item> items= new ArrayList<>();

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public int getDamage() {
        items.sort(Comparator.comparing(Item::getPrioiry));
        IntUnaryOperator op = value->value;
        for(Item item: items) {
            op=op.andThen(item.getOp());
        }
        return op.applyAsInt(currentWeapon.getDamage());
    }

    // TODO: Player에 필요한 메소드 구현
    // 무기 교체, 아이템 사용, 아이템 효과 종료 메소드 구현
}

public class Main {
    public static void main(String[] args) {
        // 무기 및 아이템 장착/사용 시나리오 및 플레이어 공격력 출력
    }
}