package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Forest_Ghoul implements Character {
    ConsumerList consumerList = new ConsumerList();

    Weapon currentWeapon = Weapon.Bare_Hand;
    List<Potion> potions = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    List<Potion> usingPotionList = new ArrayList<>();
    List<Weapon> weaponCase = new ArrayList<>();

    private int HP;private int MP;private int STR;private int DEX;
    private int maxHealth;private int maxMana;private int totalDamage;private int missRate;
    private int remainHealth;private int remainMana;
    private int attackSpeed=1;

    public Forest_Ghoul() {
        maxHealth=500;
        remainHealth=maxHealth;
        setName("Forest_Ghoul");
    }

    private String name;

    @Override
    public void setTotalDamage(int totalDamage) {
        totalDamage=50;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }
    public void setName() {
        this.name="Forest_Ghoul";
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addWeapon(Weapon weapon) {
        weaponCase.add(weapon);
        if(weapon!=Weapon.Bare_Hand) {
            consumerList.SYSTEM_Gain.accept(String.valueOf(weapon));
        }
    }

    @Override
    public void removeWeapon(Weapon weapon) {
        weaponCase.remove(weapon);
        consumerList.SYSTEM_Abandon.accept(String.valueOf(weapon));
    }

    @Override
    public void changeWeapon(Weapon weapon) {
        currentWeapon = weapon;
        consumerList.SYSTEM.accept("현재 무기: "+ currentWeapon);
    }

    @Override
    public void showWeapon() {
        Stream<Weapon> stream = weaponCase.stream().sorted((o1, o2) -> o2.getDamage()-o1.getDamage());
        System.out.println("--------------------------------------------");
        consumerList.SYSTEM.accept("-웨폰케이스 오픈-");
        consumerList.SYSTEM.accept("현재 무기: " + currentWeapon);
        consumerList.SYSTEM.accept("[무기 목록] ");
        if(weaponCase.size()==0) {
            Consumer<String> SYSTEM = s -> System.out.println("SYSTEM: " + s);
            SYSTEM.accept("웨폰케이스가 비어있습니다.");
        }
        else{
            weaponCase.stream().forEach(System.out::println);
            System.out.println("Auto");
        }
        System.out.println("--------------------------------------------");
    }

    @Override
    public void addPotion(Potion potion) {
        potions.add(potion);
        consumerList.SYSTEM_Gain.accept(String.valueOf(potion));
    }

    @Override
    public void removePotion(Potion potion) {
        potions.remove(potion);
        consumerList.SYSTEM_Abandon.accept(String.valueOf(potion));
    }

    @Override
    public void showPotion() {
        Stream<Potion> stream = potions.stream();
        if(potions.size()==0) {
            System.out.println("--------------------------------------------");
            consumerList.SYSTEM.accept("포션백이 비어있습니다.");
            System.out.println("--------------------------------------------");
        }
        else {
            consumerList.Narration.accept("[포션목록]");
            System.out.println("--------------------------------------------");
            consumerList.Narration.accept("[스텟 증폭]");
            potions.stream().filter(s->s.getApplyType()==0).sorted(Comparator.comparing(Potion::getPriority)).forEach(System.out::println);
            consumerList.Narration.accept("[무기 증폭]");
            potions.stream().filter(s->s.getApplyType()==1).sorted(Comparator.comparing(Potion::getPriority)).forEach(System.out::println);
            consumerList.Narration.accept("[마지막 공격력 증폭]");
            potions.stream().filter(s->s.getApplyType()==2).sorted(Comparator.comparing(Potion::getPriority)).forEach(System.out::println);
        }
    }

    @Override
    public void usePotion(Potion potion) {
        if(!potions.contains(potion)) {
            consumerList.SYSTEM.accept("해당포션이 없습니다.");
        }
        else {
            usingPotionList.add(potion);
            removePotion(potion);
            consumerList.SYSTEM.accept(potion+"을(를)사용합니다.");
            if(usingPotionList.size()>1) {
                usingPotionList = usingPotionList.stream().sorted(Comparator.comparing(Potion::getPriority)).collect(Collectors.toList());//효과 적용을 위한 정렬
            }
        }
    }

    @Override
    public void setRemainHealth(int takeDamage) {
        remainHealth-=takeDamage;
    }//피통 마나파트

    @Override
    public void setRemainMana(int usedMana) {
        remainMana-=usedMana;
    }

    @Override
    public int getRemainHealth() {
        return remainHealth;
    }

    @Override
    public void resetRemainHealth() {
        remainHealth=getMaxHealth();
    }

    @Override
    public void resetRemainMana() {
        remainMana=getMaxMana();
    }

    @Override
    public void updateStaticValues() {
        maxHealth=500;
        maxMana=100;
        missRate=10;//피통,마나,회피율 업데이트 시킴, 데미지는 여기서 초기화 시킬 수 없어.
    }//+회피율

    @Override
    public int getAttackSpeed() {
        return attackSpeed;
    }//공속

    @Override
    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    @Override
    public int getHP() {
        return HP;
    }//스텟

    @Override
    public int getMP() {
        return MP;
    }

    @Override
    public int getSTR() {
        return STR;
    }

    @Override
    public int getDEX() {
        return DEX;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }

    @Override
    public int getMaxMana() {
        return maxMana;
    }

    @Override
    public int getTotalDamage() {
        return totalDamage;
    }

    @Override
    public int getMissRate() {
        return missRate;
    }
}
