package com.company;

import java.util.function.IntUnaryOperator;

enum  Potion {
    Low_Class_Stat_Amplification_Potion(value->value+2,0,0), High_Class_Stat_Amplification_Potion(value->value+10,0,0),//증폭, 타입, 순서
    Low_Class_Stat_Multiplication_Potion((value->(int)(value*1.2)),0,1), High_Class_Stat_Multiplication_Potion((value->(int)(value*1.7)),0,1),
    Weapon_Slush(value->value+20,1,0),Amplification_Final_Attack_Potion(value->value+200,2,0);

    IntUnaryOperator op;
    int applyeType;
    int priority;

    Potion(IntUnaryOperator op, int applyeType, int priority) {
        this.op = op;
        this.applyeType = applyeType;
        this.priority = priority;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getApplyType() {
        return applyeType;
    }

    public int getPriority() {
        return priority;
    }
}
