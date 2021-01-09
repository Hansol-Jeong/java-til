package com.company.p01;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScoreCollectionTest {
    @Test
    public void arithmeticMeanOfFiveAndSevenResultsInSix() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);
        int actualResult = collection.arithmeticMean();
        assertEquals(6, actualResult); //assert 단언하다
    }

    @Test
    public void arithmeticMeanOfHenAndTwentyResultsInFifteen() {
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 10);
        collection.add(() -> 20);
        int actualResult = collection.arithmeticMean();
        assertEquals(15, actualResult); //assert 단언하다
    }
}