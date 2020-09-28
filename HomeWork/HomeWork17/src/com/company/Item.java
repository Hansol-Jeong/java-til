package com.company;

import java.util.function.UnaryOperator;

enum Item {
    Elders_Soul(value->value+5,value->value+5,value->value+5,value->value+5);
    UnaryOperator<Integer> op_STR;
    UnaryOperator<Integer> op_DEX;
    UnaryOperator<Integer> op_HP;
    UnaryOperator<Integer> op_MP;

    Item(UnaryOperator<Integer> op_STR, UnaryOperator<Integer> op_DEX, UnaryOperator<Integer> op_HP, UnaryOperator<Integer> op_MP) {
        this.op_STR = op_STR;
        this.op_DEX = op_DEX;
        this.op_HP = op_HP;
        this.op_MP = op_MP;
    }

    public UnaryOperator<Integer> getOp_STR() {
        return op_STR;
    }

    public UnaryOperator<Integer> getOp_DEX() {
        return op_DEX;
    }

    public UnaryOperator<Integer> getOp_HP() {
        return op_HP;
    }

    public UnaryOperator<Integer> getOp_MP() {
        return op_MP;
    }
}
