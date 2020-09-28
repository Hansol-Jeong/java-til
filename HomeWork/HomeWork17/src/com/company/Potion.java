package com.company;


import java.util.function.Function;
import java.util.function.IntUnaryOperator;
import java.util.function.UnaryOperator;

enum Potion {
    Red_Potion(value->value+2,0, 0), Blue_Potion(value->(int)(value*1.1),0,  1), Weapon_Slush(value->value+20,1,0), Black_Potion(value->value+200,2, 0);
    IntUnaryOperator op;
    int applyType;
    int priority;
    Potion(IntUnaryOperator op, int applyType, int priority ) {//스텟 0, 무기 1, 막타 2 덧셈 0, 곱셈 1
        this.op = op;
        this.applyType=applyType;
        this.priority = priority;
    }

    public IntUnaryOperator getOp() {
        return op;
    }

    public int getPriority() {
        return priority;
    }

    public int getApplyType() {
        return applyType;
    }
}