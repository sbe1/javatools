/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import junit.framework.TestCase;

/**
 *
 * @author s
 */
public class IPConvTest extends TestCase {
    
    public IPConvTest (String testName) {
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
     * Test of ipToLong method, of class IPConv.
     */
    public void testIpToLong () {
        System.out.println("ipToLong");
        String addr = "127.0.0.1";
        long expResult = 2130706433L;
        long result = IPConv.ipToLong(addr);
        assertEquals(expResult, result);
    }

    /**
     * Test of intToIp method, of class IPConv.
     */
    public void testIntToIp () {
        System.out.println("intToIp");
        int ip = 2130706433;
        String expResult = "127.0.0.1";
        String result = IPConv.intToIp(ip);
        assertEquals(expResult, result);
    }

    /**
     * Test of invertIP method, of class IPConv.
     */
    public void testInvertIP () {
        System.out.println("invertIP");
        String originalIPAddress = "127.0.0.1";
        String expResult = "1.0.0.127";
        String result = IPConv.invertIP(originalIPAddress);
        assertEquals(expResult, result);
    }

    /**
     * Test of ipToArray method, of class IPConv.
     */
    public void testIpToArray () {
        System.out.println("ipToArray");
        String ip = "127.0.0.1";
        String[] expResult = new String[]{"127","0","0","1"};
        String[] result = IPConv.ipToArray(ip);
        assertEquals((expResult[0]+expResult[1]+expResult[2]+expResult[3]), (result[0]+result[1]+result[2]+result[3]));
    }

    /**
     * Test of ipToIntArray method, of class IPConv.
     */
    public void testIpToIntArray () {
        System.out.println("ipToIntArray");
        String ip = "127.0.0.1";
        int[] expResult = new int[]{127,0,0,1};
        int[] result = IPConv.ipToIntArray(ip);
        System.out.println("TEST=====> "+(""+expResult[0]+expResult[1]+expResult[2]+expResult[3])+" "+(""+result[0]+result[1]+result[2]+result[3]));
        assertEquals((""+expResult[0]+expResult[1]+expResult[2]+expResult[3]), (""+result[0]+result[1]+result[2]+result[3]));
    }
    
}
