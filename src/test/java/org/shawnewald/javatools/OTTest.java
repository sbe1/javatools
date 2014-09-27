/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import java.util.List;
import java.util.Map;
import java.util.Set;
import junit.framework.TestCase;

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
        System.out.println("objectIsNullOrEmpty");
        Object[] input = new Object[]{"Foo"};
        boolean expResult = false;
        boolean result = OT.objectIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringIsNullOrEmpty method, of class OT.
     */
    public void testStringIsNullOrEmpty_String () {
        System.out.println("stringIsNullOrEmpty");
        String input = "Foo";
        boolean expResult = false;
        boolean result = OT.stringIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringIsNullOrEmpty method, of class OT.
     */
    public void testStringIsNullOrEmpty_StringArr () {
        System.out.println("stringIsNullOrEmpty");
        String[] input = new String[]{"Foo"};
        boolean expResult = false;
        boolean result = OT.stringIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of mapIsNullOrEmpty method, of class OT.
     */
    public void testMapIsNullOrEmpty () {
        System.out.println("mapIsNullOrEmpty");
        Map input = null;
        boolean expResult = true;
        boolean result = OT.mapIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of listIsNullOrEmpty method, of class OT.
     */
    public void testListIsNullOrEmpty () {
        System.out.println("listIsNullOrEmpty");
        List input = null;
        boolean expResult = true;
        boolean result = OT.listIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of setIsNullOrEmpty method, of class OT.
     */
    public void testSetIsNullOrEmpty () {
        System.out.println("setIsNullOrEmpty");
        Set input = null;
        boolean expResult = true;
        boolean result = OT.setIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrZero method, of class OT.
     */
    public void testIntegerIsNullOrZero () {
        System.out.println("integerIsNullOrZero");
        Integer input = 0;
        boolean expResult = true;
        boolean result = OT.integerIsNullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrLTETZero method, of class OT.
     */
    public void testIntegerIsNullOrLTETZero () {
        System.out.println("integerIsNullOrLTETZero");
        Integer input = -1;
        boolean expResult = true;
        boolean result = OT.integerIsNullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of integerIsNullOrEmpty method, of class OT.
     */
    public void testIntegerIsNullOrEmpty () {
        System.out.println("integerIsNullOrEmpty");
        Integer[] input = new Integer[]{1};
        boolean expResult = false;
        boolean result = OT.integerIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrZero method, of class OT.
     */
    public void testLongIsNullOrZero () {
        System.out.println("longIsNullOrZero");
        Long input = 1L;
        boolean expResult = false;
        boolean result = OT.longIsNullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrLTETZero method, of class OT.
     */
    public void testLongIsNullOrLTETZero () {
        System.out.println("longIsNullOrLTETZero");
        Long input = null;
        boolean expResult = true;
        boolean result = OT.longIsNullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of longIsNullOrEmpty method, of class OT.
     */
    public void testLongIsNullOrEmpty () {
        System.out.println("longIsNullOrEmpty");
        Long[] input = null;
        boolean expResult = true;
        boolean result = OT.longIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrZero method, of class OT.
     */
    public void testNumberIsNullOrZero () {
        System.out.println("numberIsNullOrZero");
        Number input = null;
        boolean expResult = true;
        boolean result = OT.numberIsNullOrZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrLTETZero method, of class OT.
     */
    public void testNumberIsNullOrLTETZero () {
        System.out.println("numberIsNullOrLTETZero");
        Number input = null;
        boolean expResult = true;
        boolean result = OT.numberIsNullOrLTETZero(input);
        assertEquals(expResult, result);
    }

    /**
     * Test of numberIsNullOrEmpty method, of class OT.
     */
    public void testNumberIsNullOrEmpty () {
        System.out.println("numberIsNullOrEmpty");
        Number[] input = null;
        boolean expResult = true;
        boolean result = OT.numberIsNullOrEmpty(input);
        assertEquals(expResult, result);
    }
    
}
