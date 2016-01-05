/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import junit.framework.TestCase;

/**
 *
 * @author s
 */
public class TxtTest extends TestCase {
    
    public TxtTest (String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp () throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown () throws Exception {
        super.tearDown();
    }

    /**
     * Test of toUTF8 method, of class Txt.
     */
    public void testToUTF8 () {
        System.out.println("toUTF8");
        String string = "Test";
        String expResult = "Test";
        String result = Txt.toUTF8(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of escapeQuote method, of class Txt.
     */
    public void testEscapeQuote () {
        System.out.println("escapeQuote");
        String s = "That's";
        boolean doubleQuoteOnly = false;
        String expResult = "That\\'s";
        String result = Txt.escapeQuote(s, doubleQuoteOnly);
        assertEquals(expResult, result);
    }

    /**
     * Test of deEscapeQuote method, of class Txt.
     */
    public void testDeEscapeQuote () {
        System.out.println("deEscapeQuote");
        String s = "That\\'s";
        String expResult = "That's";
        String result = Txt.deEscapeQuote(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of urlDecode method, of class Txt.
     */
    public void testUrlDecode () {
        System.out.println("urlDecode");
        String thisString = "+";
        String expResult = " ";
        String result = Txt.urlDecode(thisString);
        assertEquals(expResult, result);
    }

    /**
     * Test of urlEncode method, of class Txt.
     */
    public void testUrlEncode () {
        System.out.println("urlEncode");
        String thisString = " ";
        String expResult = "+";
        String result = Txt.urlEncode(thisString);
        assertEquals(expResult, result);
    }

    /**
     * Test of percentEncode method, of class Txt.
     */
    public void testPercentEncode () {
        System.out.println("percentEncode");
        String str = " ";
        String expResult = "%20";
        String result = Txt.percentEncode(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of charExists method, of class Txt.
     */
    public void testCharExists () {
        System.out.println("charExists");
        char needle = ' ';
        char[] haystack = " ".toCharArray();
        boolean expResult = true;
        boolean result = Txt.charExists(needle, haystack);
        assertEquals(expResult, result);
    }

    /**
     * Test of rejoin method, of class Txt.
     */
    public void testRejoin () {
        System.out.println("rejoin");
        String string = "t-e-s-t";
        String splitBy = "-";
        String glue = "+";
        String expResult = "t+e+s+t";
        String result = Txt.rejoin(string, splitBy, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_StringArr_String () {
        System.out.println("join");
        String[] string = new String[]{"t","e","s","t"};
        String glue = "-";
        String expResult = "t-e-s-t";
        String result = Txt.join(string, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_List_String () {
        System.out.println("join");
        List list = Arrays.asList(new String[]{"t","e","s","t"});
        String glue = "-";
        String expResult = "t-e-s-t";
        String result = Txt.join(list, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_Map_String () {
        System.out.println("join");
        Map map = new LinkedHashMap();
        map.put("a","b");
        map.put("c","d");
        String glue = "<->";
        String seperator = ":";
        String expResult = "a:b<->c:d";
        String result = Txt.join(map, glue, seperator);
        assertEquals(expResult, result);
    }

    /**
     * Test of countOccurrences method, of class Txt.
     */
    public void testCountOccurrences () {
        System.out.println("countOccurrences");
        char needle = ' ';
        String haystack = "t e s t";
        int expResult = 3;
        int result = Txt.countOccurrences(needle, haystack);
        assertEquals(expResult, result);
    }
}
