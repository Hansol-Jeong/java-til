package com.company.p05;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.*;

public class RomanConverterTest {
    RomanConverter converter;
    @Before
    public void setUp() throws Exception {
        converter = new RomanConverter();
    }
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void exceptionWhenRomanNotSet() {
        thrown.expect(ArithmeticException.class);
        int actualResult = converter.transform();
    }

    @Test
    public void convertI() {
        converter.setRoman("I");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(1)));
    }

    @Test
    public void convertX() {
        converter.setRoman("X");
        int actualResult = converter.transform();
        assertThat(actualResult, is(equalTo(10)));
    }
}