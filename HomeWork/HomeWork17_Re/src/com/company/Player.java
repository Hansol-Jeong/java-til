package com.company;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class Player implements Character{
    ConsumerList consumerList = new ConsumerList();

    Weapon currentWeapon = Weapon.Bare_Hand;
    List<Potion> potions = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    List<Potion> usingPotionList = new ArrayList<>();
    List<Weapon> weaponCase = new ArrayList<>();

    private int HP;private int MP;private int STR;private int DEX;
    private int maxHealth;private int maxMana;private int totalDamage;private int missRate;
    private int remainHealth;private int remainMana;
    private int attackSpeed=3;
    private String name;


    public Player() {
        updateStaticValues();//처음 최대 피통, 마나, 회피율 업데이트 완료
        resetRemainHealth();//최대 피통에 따른 피통 마나 설정
        resetRemainMana();
        setName("용사");
    }

        public void setTotalDamage(int totalDamage) {
            IntUnaryOperator op_forSTR = value->value;
            IntUnaryOperator op_forWeapon = value->value;
            IntUnaryOperator op_forlastDamage = value ->value;
            int STR_Damage=0;
            int Weapon_Damage=0;
            int Last_Damage=0;
            List<Potion> Type0Potion = usingPotionList.stream().filter(s -> s.getApplyType() == 0).sorted(Comparator.comparing(Potion::getPriority)).collect(Collectors.toList());//tolist랑 toArray랑 뭐가다를까
            if(Type0Potion.size()!=0) {
                for (Potion potion : Type0Potion) {
                    op_forSTR = op_forSTR.andThen(potion.getOp());
                }
            }
            STR_Damage=op_forSTR.applyAsInt(getSTR())*10;

            List<Potion> Type1Potion = usingPotionList.stream().filter(s -> s.getApplyType() == 1).sorted(Comparator.comparing(Potion::getPriority)).collect(Collectors.toList());//타입 뽑아내고 중요도순으로 정렬
            if(Type1Potion.size()!=0) {
                for (Potion potion : Type1Potion) {
                    op_forWeapon = op_forWeapon.andThen(potion.getOp());
                }
            }
            Weapon_Damage = op_forWeapon.applyAsInt(currentWeapon.getDamage());
            List<Potion> Type2Potion = usingPotionList.stream().filter(s -> s.getApplyType() == 2).sorted(Comparator.comparing(Potion::getPriority)).collect(Collectors.toList());//tolist랑 toArray랑 뭐가다를까
            if(Type2Potion.size()!=0) {
                for (Potion potion : Type2Potion) {
                    op_forlastDamage = op_forlastDamage.andThen(potion.getOp());
                }
            }
            Last_Damage = op_forlastDamage.applyAsInt(0);
            System.out.println("근력 데미지: "+STR_Damage+" 무기 데미지: " +Weapon_Damage+" 추가 데미지: "+ Last_Damage);
            totalDamage= STR_Damage+Weapon_Damage+Last_Damage;
        }
        public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void addWeapon(Weapon weapon) {
        weaponCase.add(weapon);
        if(weapon!=Weapon.Bare_Hand) {
            consumerList.SYSTEM_Gain.accept(String.valueOf(weapon));
        }
    }
    public void removeWeapon(Weapon weapon) {
        weaponCase.remove(weapon);
        consumerList.SYSTEM_Abandon.accept(String.valueOf(weapon));
    }
    public void changeWeapon(Weapon weapon) {
            currentWeapon = weapon;
            consumerList.SYSTEM.accept("현재 무기: "+ currentWeapon);
        }
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
    public void beforeBattleWeaponchange() {
            Scanner scan = new Scanner(System.in);
            showWeapon();
            loop: while(true) {
                String tempWeapon = scan.nextLine();
                for (Weapon weapon : weaponCase) {
                    if (weapon.toString().equals(tempWeapon)) {
                        currentWeapon = weapon;
                        System.out.println(currentWeapon);
                        break loop;
                    }
                }
                if(tempWeapon.equals("Auto"))  {
                    ArrayList<Weapon> tempWeaponCase = (ArrayList<Weapon>) weaponCase.stream().sorted((o1, o2) -> o2.getDamage()-o1.getDamage()).collect(Collectors.toList());
                    currentWeapon = tempWeaponCase.get(0);
                    consumerList.SYSTEM.accept("현재무기: "+ currentWeapon);
                    break loop;
                }
                consumerList.SYSTEM.accept("무기를 다시 고르십시오.");
            }
        }

    public void addPotion(Potion potion) {
        potions.add(potion);
        consumerList.SYSTEM_Gain.accept(String.valueOf(potion));
    }
    public void removePotion(Potion potion) {
        potions.remove(potion);
        consumerList.SYSTEM_Abandon.accept(String.valueOf(potion));
    }
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

    public void addItem(Item item) {
            items.add(item);
            consumerList.SYSTEM_Gain.accept(String.valueOf(item));
        }
    public void removeItem(Item item) {
            items.remove(item);
        }
    public void showItem() {
            items.stream().forEach(System.out::println);
            if (items.size()==0) {
                Consumer<String> SYSTEM =s-> System.out.println("SYSTEM: " + s);
                SYSTEM.accept("아이템창이 비어있습니다.");
            }
        }
    public void useItem(Item item) {
            setSTR(item.getOp_STR());
            setDEX(item.getOp_DEX());
            setHP(item.getOp_HP());
            setMP(item.getOp_MP());

            showState();
        }
    public void setSTR(UnaryOperator<Integer> op) {
            STR=op.apply(STR);
        }
    public void setDEX(UnaryOperator<Integer> op) {
            DEX=op.apply(DEX);
        }
    public void setHP(UnaryOperator<Integer> op) {
            HP=op.apply(HP);
        }
    public void setMP(UnaryOperator<Integer> op) {
            MP=op.apply(MP);
        }
    public void showState() {
            System.out.println("--------------------------------------------");
            System.out.println("STR: "+getSTR());System.out.println("DEX: "+getDEX());System.out.println("HP: "+getHP());System.out.println("MP: "+getMP());
            System.out.println("--------------------------------------------");
        }


    public void setRemainHealth(int takeDamage) {
        remainHealth-=takeDamage;
    }//피통 마나파트
    public void setRemainMana(int usedMana) {
        remainMana-=usedMana;
    }

        @Override
        public int getRemainHealth() {
            return remainHealth;
        }

        public void resetRemainHealth() {
        remainHealth=getMaxHealth();
    }
    public void resetRemainMana() {
        remainMana=getMaxMana();
    }

    public void updateStaticValues() {
        maxHealth=500+10*HP;
        maxMana=100*5*MP;
        missRate=10+2*DEX;//피통,마나,회피율 업데이트 시킴, 데미지는 여기서 초기화 시킬 수 없어.
    }//+회피율

    public int getAttackSpeed() {
        return attackSpeed;
    }//공속
    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public int getHP() {
        return HP;
    }//스텟
    public int getMP() {
        return MP;
    }
    public int getSTR() {
        return STR;
    }
    public int getDEX() {
        return DEX;
    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public int getMaxMana() {
        return maxMana;
    }
    public int getTotalDamage() {
        return totalDamage;
    }
    public int getMissRate() {
        return missRate;
    }
}
