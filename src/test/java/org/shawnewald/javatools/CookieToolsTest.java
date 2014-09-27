/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import junit.framework.Assert;
import junit.framework.TestCase;

/**
 *
 * @author s
 */
public class CookieToolsTest extends TestCase {
    
    public CookieToolsTest (String testName) {
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
     * Test of createCookie method, of class CookieTools.
     */
    public void testCreateCookie_String_String () {
        System.out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        Cookie expResult = new Cookie(name, value);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000).intValue());
        Cookie result = CookieTools.createCookie(name, value);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of createCookie method, of class CookieTools.
     */
    public void testCreateCookie_3args () {
        System.out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        String domain = "example.org";
        Cookie expResult = new Cookie(name, value);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000).intValue());
        expResult.setDomain(domain);
        Cookie result = CookieTools.createCookie(name, value, domain);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of createCookie method, of class CookieTools.
     */
    public void testCreateCookie_5args () {
        System.out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        int age = 10000;
        String path = "/";
        String domain = "example.org";
        Cookie expResult = new Cookie(name, value);
        expResult.setMaxAge(age);
        expResult.setPath(path);
        expResult.setDomain(domain);
        Cookie result = CookieTools.createCookie(name, value, age, path, domain);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of getCookieValue method, of class CookieTools.
     */
    public void testGetCookieValue () {
        System.out.println("getCookieValue");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        String cookieName = "Foo";
        String expResult = "Bar";
        String result = CookieTools.getCookieValue(cookies, cookieName);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of getCookie method, of class CookieTools.
     */
    public void testGetCookie () {
        System.out.println("getCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        String cookieName = "Foo";
        Cookie expResult = cookies[0];
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000).intValue());
        Cookie result = CookieTools.getCookie(cookies, cookieName);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of cookieMap method, of class CookieTools.
     */
    public void testCookieMap () {
        System.out.println("cookieMap");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        Map<String, String> expResult = new HashMap<String,String>();
        expResult.put("Foo", "Bar");
        Map<String, String> result = CookieTools.cookieMap(cookies);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of updateCookie method, of class CookieToo:ls.
     */
    public void testUpdateCookie_3args () {
        System.out.println("updateCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        String cookieValue = "Bar";
        Cookie expResult = new Cookie("Foo", "Bar");
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000).intValue());
        Cookie result = CookieTools.updateCookie(cookies, cookieName, cookieValue);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of updateCookie method, of class CookieTools.
     */
    public void testUpdateCookie_4args () {
        System.out.println("updateCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        String cookieValue = "Bar";
        String cookieDomain = "example.org";
        Cookie expResult = new Cookie(cookieName, cookieValue);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000).intValue());
        expResult.setDomain(cookieDomain);
        Cookie result = CookieTools.updateCookie(cookies, cookieName, cookieValue, cookieDomain);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of updateCookie method, of class CookieTools.
     */
    public void testUpdateCookie_6args () {
        System.out.println("updateCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        String cookieValue = "Bar";
        int cookieAge = 10000;
        String cookiePath = "/";
        String cookieDomain = "example.org";
        Cookie expResult = new Cookie(cookieName, cookieValue);
        expResult.setMaxAge(cookieAge);
        expResult.setPath(cookiePath);
        expResult.setDomain(cookieDomain);
        Cookie result = CookieTools.updateCookie(cookies, cookieName, cookieValue, cookieAge, cookiePath, cookieDomain);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_String () {
        System.out.println("deleteCookie");
        String cookiename = "Foo";
        Cookie expResult = new Cookie("Foo", "");
        expResult.setPath("/");
        expResult.setMaxAge(0);
        Cookie result = CookieTools.deleteCookie(cookiename);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_String_String () {
        System.out.println("deleteCookie");
        String cookiename = "Foo";
        String cookieDomain = "example.org";
        Cookie expResult = new Cookie(cookiename, "");
        expResult.setDomain(cookieDomain);
        expResult.setPath("/");
        expResult.setMaxAge(0);
        Cookie result = CookieTools.deleteCookie(cookiename, cookieDomain);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_3args () {
        System.out.println("deleteCookie");
        String cookiename = "Foo";
        String cookieDomain = "example.org";
        String cpath = "/";
        Cookie expResult = new Cookie("Foo", "");
        expResult.setPath(cpath);
        expResult.setMaxAge(0);
        expResult.setDomain(cookieDomain);
        Cookie result = CookieTools.deleteCookie(cookiename, cookieDomain, cpath);
        Assert.assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of cookieExists method, of class CookieTools.
     */
    public void testCookieExists () {
        System.out.println("cookieExists");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        Boolean expResult = true;
        Boolean result = CookieTools.cookieExists(cookies, cookieName);
        Assert.assertEquals(expResult, result);
    }

    /**
     * Test of cookieIsNullOrEmpty method, of class CookieTools.
     */
    public void testCookieIsNullOrEmpty () {
        System.out.println("cookieIsNullOrEmpty");
        Cookie cookie = new Cookie("Foo", "");
        Boolean expResult = true;
        Boolean result = CookieTools.cookieIsNullOrEmpty(cookie);
        Assert.assertEquals(expResult, result);
    }
    
}
