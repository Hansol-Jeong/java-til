package com.company.p04;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WebParserTest {
    @Test
    public void countImageFromGoogleDotCom() throws IOException {
        WebParser parser = new WebParser();
        int actualResult = parser.countImageFromWebPage("http://google.com");
    }
    @Before
    public void setUp() {

    }
    @Test
    public void countImageFrom() {
        
    }

}