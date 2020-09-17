/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import static java.lang.System.out;
import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.TestCase;
import static org.shawnewald.javatools.OT.nullOrEmpty;
import static org.shawnewald.javatools.OT.nullOrLTETZero;
import static org.shawnewald.javatools.OT.nullOrZero;
import static org.shawnewald.javatools.OT.nullOrLTETZero;

/**
 *
 * @author s
 */
public class OTTest extends TestCase {
    
    public OTTest (String testName) {
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
     * Test of objectIsNullOrEmpty method, of class OT.
     */
    public void testObjectIsNullOrEmpty () {
        out.println("objectIsNullOrEmpty");
        Object[] input = new Object[]{"Foo"};
        boolean expResult = false;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringIsNullOrEmpty method, of class OT.
     */
    public void testStringIsNullOrEmpty_String () {
        out.println("stringIsNullOrEmpty");
        String input = "Foo";
        boolean expResult = false;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringIsNullOrEmpty method, of class OT.
     */
    public void testStringIsNullOrEmpty_StringArr () {
        out.println("stringIsNullOrEmpty");
        String[] input = new String[]{"Foo"};
        boolean expResult = false;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapIsNullOrEmpty method, of class OT.
     */
    public void testMapIsNullOrEmpty () {
        out.println("mapIsNullOrEmpty");
        Map input = null;
        boolean expResult = true;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of listIsNullOrEmpty method, of class OT.
     */
    public void testListIsNullOrEmpty () {
        out.println("listIsNullOrEmpty");
        List input = null;
        boolean expResult = true;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsNullOrEmpty method, of class OT.
     */
    public void testSetIsNullOrEmpty () {
        out.println("setIsNullOrEmpty");
        Set input = null;
        boolean expResult = true;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrZero method, of class OT.
     */
    public void testIntegerIsNullOrZero () {
        out.println("integerIsNullOrZero");
        Integer input = 0;
        boolean expResult = true;
        boolean result = nullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrLTETZero method, of class OT.
     */
    public void testIntegerIsNullOrLTETZero () {
        out.println("integerIsNullOrLTETZero");
        Integer input = -1;
        boolean expResult = true;
        boolean result = nullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrEmpty method, of class OT.
     */
    public void testIntegerIsNullOrEmpty () {
        out.println("integerIsNullOrEmpty");
        Integer[] input = new Integer[]{1};
        boolean expResult = false;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrZero method, of class OT.
     */
    public void testLongIsNullOrZero () {
        out.println("longIsNullOrZero");
        Long input = 1L;
        boolean expResult = false;
        boolean result = nullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrLTETZero method, of class OT.
     */
    public void testLongIsNullOrLTETZero () {
        out.println("longIsNullOrLTETZero");
        Long input = null;
        boolean expResult = true;
        boolean result = nullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrEmpty method, of class OT.
     */
    public void testLongIsNullOrEmpty () {
        out.println("longIsNullOrEmpty");
        Long[] input = null;
        boolean expResult = true;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrZero method, of class OT.
     */
    public void testNumberIsNullOrZero () {
        out.println("numberIsNullOrZero");
        Number input = null;
        boolean expResult = true;
        boolean result = nullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrLTETZero method, of class OT.
     */
    public void testNumberIsNullOrLTETZero () {
        out.println("numberIsNullOrLTETZero");
        Number input = null;
        boolean expResult = true;
        boolean result = nullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrEmpty method, of class OT.
     */
    public void testNumberIsNullOrEmpty () {
        out.println("numberIsNullOrEmpty");
        Number[] input = null;
        boolean expResult = true;
        boolean result = nullOrEmpty(input);
        assertEquals(expResult, result);
    }
    
}
