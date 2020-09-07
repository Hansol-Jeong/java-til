package com.company;

public class IsAllUsed {
    public boolean isAllUsed() {
        for(int i = 0; i < 3; i++)
            for(int j =1; j<4; j++) {
                if(Initialize.field[i][j]=='E')
                    return true;
            }
        return false;//E가 하나도 없으면 끝
    }
}
