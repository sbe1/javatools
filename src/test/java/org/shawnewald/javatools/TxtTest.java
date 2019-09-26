/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import static java.lang.System.out;
import java.util.Arrays;
import static java.util.Arrays.asList;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import junit.framework.TestCase;
import static org.shawnewald.javatools.Txt.charExists;
import static org.shawnewald.javatools.Txt.countOccurrences;
import static org.shawnewald.javatools.Txt.deEscapeQuote;
import static org.shawnewald.javatools.Txt.escapeQuote;
import static org.shawnewald.javatools.Txt.join;
import static org.shawnewald.javatools.Txt.join;
import static org.shawnewald.javatools.Txt.join;
import static org.shawnewald.javatools.Txt.percentEncode;
import static org.shawnewald.javatools.Txt.rejoin;
import static org.shawnewald.javatools.Txt.toUTF8;
import static org.shawnewald.javatools.Txt.urlDecode;
import static org.shawnewald.javatools.Txt.urlEncode;

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
        out.println("toUTF8");
        String string = "Test";
        String expResult = "Test";
        String result = toUTF8(string);
        assertEquals(expResult, result);
    }

    /**
     * Test of escapeQuote method, of class Txt.
     */
    public void testEscapeQuote () {
        out.println("escapeQuote");
        String s = "That's";
        boolean doubleQuoteOnly = false;
        String expResult = "That\\'s";
        String result = escapeQuote(s, doubleQuoteOnly);
        assertEquals(expResult, result);
    }

    /**
     * Test of deEscapeQuote method, of class Txt.
     */
    public void testDeEscapeQuote () {
        out.println("deEscapeQuote");
        String s = "That\\'s";
        String expResult = "That's";
        String result = deEscapeQuote(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of urlDecode method, of class Txt.
     */
    public void testUrlDecode () {
        out.println("urlDecode");
        String thisString = "+";
        String expResult = " ";
        String result = urlDecode(thisString);
        assertEquals(expResult, result);
    }

    /**
     * Test of urlEncode method, of class Txt.
     */
    public void testUrlEncode () {
        out.println("urlEncode");
        String thisString = " ";
        String expResult = "+";
        String result = urlEncode(thisString);
        assertEquals(expResult, result);
    }

    /**
     * Test of percentEncode method, of class Txt.
     */
    public void testPercentEncode () {
        out.println("percentEncode");
        String str = " ";
        String expResult = "%20";
        String result = percentEncode(str);
        assertEquals(expResult, result);
    }

    /**
     * Test of charExists method, of class Txt.
     */
    public void testCharExists () {
        out.println("charExists");
        char needle = ' ';
        char[] haystack = " ".toCharArray();
        boolean expResult = true;
        boolean result = charExists(needle, haystack);
        assertEquals(expResult, result);
    }

    /**
     * Test of rejoin method, of class Txt.
     */
    public void testRejoin () {
        out.println("rejoin");
        String string = "t-e-s-t";
        String splitBy = "-";
        String glue = "+";
        String expResult = "t+e+s+t";
        String result = rejoin(string, splitBy, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_StringArr_String () {
        out.println("join");
        String[] string = new String[]{"t","e","s","t"};
        String glue = "-";
        String expResult = "t-e-s-t";
        String result = join(string, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_List_String () {
        out.println("join");
        List list = asList(new String[]{"t","e","s","t"});
        String glue = "-";
        String expResult = "t-e-s-t";
        String result = join(list, glue);
        assertEquals(expResult, result);
    }

    /**
     * Test of join method, of class Txt.
     */
    public void testJoin_Map_String () {
        out.println("join");
        Map map = new LinkedHashMap();
        map.put("a","b");
        map.put("c","d");
        String glue = "<->";
        String seperator = ":";
        String expResult = "a:b<->c:d";
        String result = join(map, glue, seperator);
        assertEquals(expResult, result);
    }

    /**
     * Test of countOccurrences method, of class Txt.
     */
    public void testCountOccurrences () {
        out.println("countOccurrences");
        char needle = ' ';
        String haystack = "t e s t";
        int expResult = 3;
        int result = countOccurrences(needle, haystack);
        assertEquals(expResult, result);
    }
}
