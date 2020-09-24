package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.function.Consumer;

/**
 * 열거형 타입과 함수형 프로그래밍을 이용하여 플레이어의 공격력을 계산하는 알고리즘을 구현하시오.
 *
 * 플레이어 공격력을 계산하는 과정은 아래와 같다.
 * 1. 플레이어의 무기에 따라 공격력이 변화한다. 무기는 최근에 장착한 무기의 공격력 만으로 계산된다.
 *   1-1. BARE_HANDS - 공격력 5
 *   1-2. DAGGER - 공격력 40
 *   1-3. LONG_SWORD - 공격력 100
 *   1-4. DRAGON_SLAYER -  공격력 250
 * 2. 플레이어의 공격력에 영향을 주는 아이템에 따라 공격력 증가 방식이 다르며, 아이템은 중복 적용된다.
 *   2-1. BLACK_POTION - 공격력 10% 증가
 *   2-2. WHITE_POTION - 모든 공격력 계산이 끝난 후에 공격력 + 200
 *   2-3. MUSHROOM - 무기 공격력 + 20
 *
 */

enum Weapon {
    BARE_HANDS(5), DAGGER(40), LONG_SWORD(100), DRAGON_SLAYER(250);
    int atk;
    Weapon(int atk) {
        this.atk = atk;
    }
    int getAtk() {
        return -atk;
    }
}

enum Item {
    BLACK_POTION(2), WHITE_POTION(3), MUSHROOM(1);
    int itemApplyPriority;
    Item(int itemApplyPriority) {
        this.itemApplyPriority=itemApplyPriority;
    }
    int getItemApplyPriority() {
        return itemApplyPriority;
    }

}

class Player {
    Weapon currentWeapon=Weapon.BARE_HANDS;
    PriorityQueue<Item> items = new PriorityQueue<Item>(Comparator.comparing(Item::getItemApplyPriority));
    PriorityQueue<Weapon> weaponCase = new PriorityQueue<Weapon>(Comparator.comparing(Weapon::getAtk));
    int totalAtk=0;
    public void weaponAutoChange() {
        currentWeapon=weaponCase.peek();
        setTotalAtk();
    }
    public Weapon getCurrentWeapon() {
        return currentWeapon;
    }

    public void setCurrentWeapon(Weapon currentWeapon) {
        this.currentWeapon = currentWeapon;
    }

    public PriorityQueue<Item> getItems() {
        return items;
    }

    public void setItems(PriorityQueue items) {
        this.items = items;
    }

    public int getTotalAtk() {
        return totalAtk;
    }

    public void setTotalAtk() {
        currentWeapon=weaponCase.peek();
        totalAtk=weaponCase.peek().atk;

        if (items.size()!=0) {
            if(items.contains(Item.MUSHROOM)) {
                currentWeapon.atk+=20;
                System.out.println(1);
            }
            if(items.contains(Item.BLACK_POTION)) {
                totalAtk = (int) (currentWeapon.atk * 1.1);
                System.out.println(2);
            }
            if(items.contains(Item.WHITE_POTION)) {
                totalAtk += 200;
                System.out.println(3);
            }
        }
        else totalAtk=currentWeapon.atk;
    }
}

public class DamageCalculation {
    public static void main(String[] args) {
        // 무기 및 아이템 장착/사용 시나리오 및 플레이어 공격력 출력
        Consumer<Weapon> showWeapon = s-> System.out.println(s);
        Consumer<String> cunsumer = (s) -> System.out.println(s);
        Player player = new Player();
        player.weaponCase.add(Weapon.BARE_HANDS);
        player.weaponCase.add(Weapon.LONG_SWORD);
        player.weaponCase.add(Weapon.DRAGON_SLAYER);
        for (Weapon s: player.weaponCase) {
            showWeapon.accept(s);
        }
        showWeapon.accept(player.currentWeapon);
        player.weaponAutoChange();
        showWeapon.accept(player.currentWeapon);
        cunsumer.accept("스텟");
        System.out.println(player.totalAtk);
        player.items.add(Item.BLACK_POTION);//공격력 10퍼증가 ->275
        player.setTotalAtk();
        System.out.println(player.totalAtk);
        player.items.add(Item.MUSHROOM);//무기공격력 20증가 따라서 무기공격력 270에 27증가하면 297
        player.setTotalAtk();
        System.out.println(player.totalAtk);
        player.items.add(Item.WHITE_POTION);//마지막데미지 200증가 따라서 497이 나오지않네? 어쨰서냐
        player.setTotalAtk();
        System.out.println(player.totalAtk);
        for (Item s:player.items) {
            System.out.println(s);
        }

    }
}