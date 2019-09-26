/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import static java.lang.System.out;
import junit.framework.TestCase;
import static org.shawnewald.javatools.Crypto.getDigest;
import static org.shawnewald.javatools.Crypto.getSignature;

/**
 *
 * @author s
 */
public class CryptoTest extends TestCase {
    
    public CryptoTest (String testName) {
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
     * Test of getDigest method, of class Crypto.
     */
    public void testGetDigest () {
        out.println("getDigest");
        String str = "test";
        String digest = "SHA1";
        String encoding = "UTF-8";
        int radix = 16;
        String expResult = "a94a8fe5ccb19ba61c4c0873d391e987982fbbd3";
        String result = getDigest(str, digest, encoding, radix);
        assertEquals(expResult, result);
    }

    /**
     * Test of getSignature method, of class Crypto.
     */
    public void testGetSignature () {
        out.println("getSignature");
        String str = "test";
        String key = "mykey";
        String algorithm = "HmacSha1";
        boolean asBase64 = false;
        String expResult = "2db01def20dadf857b3728c4a9268b5df00dcb8a";
        String result = getSignature(str, key, algorithm, asBase64);
        assertEquals(expResult, result);
    }
}