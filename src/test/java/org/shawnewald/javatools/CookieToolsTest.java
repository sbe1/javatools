/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import static java.lang.System.out;
import java.util.Map;
import java.util.HashMap;
import javax.servlet.http.Cookie;
import junit.framework.Assert;
import junit.framework.TestCase;
import static org.shawnewald.javatools.CookieTools.cookieExists;
import static org.shawnewald.javatools.CookieTools.cookieIsNullOrEmpty;
import static org.shawnewald.javatools.CookieTools.cookieMap;
import static org.shawnewald.javatools.CookieTools.createCookie;
import static org.shawnewald.javatools.CookieTools.createCookie;
import static org.shawnewald.javatools.CookieTools.createCookie;
import static org.shawnewald.javatools.CookieTools.deleteCookie;
import static org.shawnewald.javatools.CookieTools.deleteCookie;
import static org.shawnewald.javatools.CookieTools.deleteCookie;
import static org.shawnewald.javatools.CookieTools.getCookie;
import static org.shawnewald.javatools.CookieTools.getCookieValue;
import static org.shawnewald.javatools.CookieTools.updateCookie;
import static org.shawnewald.javatools.CookieTools.updateCookie;
import static org.shawnewald.javatools.CookieTools.updateCookie;

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
        out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        Cookie expResult = new Cookie(name, value);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000));
        Cookie result = createCookie(name, value);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of createCookie method, of class CookieTools.
     */
    public void testCreateCookie_3args () {
        out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        String domain = "example.org";
        Cookie expResult = new Cookie(name, value);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000));
        expResult.setDomain(domain);
        Cookie result = createCookie(name, value, domain);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of createCookie method, of class CookieTools.
     */
    public void testCreateCookie_5args () {
        out.println("createCookie");
        String name = "Foo";
        String value = "Bar";
        int age = 10000;
        String path = "/";
        String domain = "example.org";
        Cookie expResult = new Cookie(name, value);
        expResult.setMaxAge(age);
        expResult.setPath(path);
        expResult.setDomain(domain);
        Cookie result = createCookie(name, value, age, path, domain);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of getCookieValue method, of class CookieTools.
     */
    public void testGetCookieValue () {
        out.println("getCookieValue");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        String cookieName = "Foo";
        String expResult = "Bar";
        String result = getCookieValue(cookies, cookieName);
        assertEquals(expResult, result);
    }

    /**
     * Test of getCookie method, of class CookieTools.
     */
    public void testGetCookie () {
        out.println("getCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        String cookieName = "Foo";
        Cookie expResult = cookies[0];
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000));
        Cookie result = getCookie(cookies, cookieName);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of cookieMap method, of class CookieTools.
     */
    public void testCookieMap () {
        out.println("cookieMap");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "Bar")};
        Map<String, String> expResult = new HashMap<>();
        expResult.put("Foo", "Bar");
        Map<String, String> result = cookieMap(cookies);
        assertEquals(expResult, result);
    }

    /**
     * Test of updateCookie method, of class CookieToo:ls.
     */
    public void testUpdateCookie_3args () {
        out.println("updateCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        String cookieValue = "Bar";
        Cookie expResult = new Cookie("Foo", "Bar");
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000));
        Cookie result = updateCookie(cookies, cookieName, cookieValue);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of updateCookie method, of class CookieTools.
     */
    public void testUpdateCookie_4args () {
        out.println("updateCookie");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        String cookieValue = "Bar";
        String cookieDomain = "example.org";
        Cookie expResult = new Cookie(cookieName, cookieValue);
        expResult.setPath("/");
        expResult.setMaxAge(((Integer)31536000));
        expResult.setDomain(cookieDomain);
        Cookie result = updateCookie(cookies, cookieName, cookieValue, cookieDomain);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of updateCookie method, of class CookieTools.
     */
    public void testUpdateCookie_6args () {
        out.println("updateCookie");
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
        Cookie result = updateCookie(cookies, cookieName, cookieValue, cookieAge, cookiePath, cookieDomain);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_String () {
        out.println("deleteCookie");
        String cookiename = "Foo";
        Cookie expResult = new Cookie("Foo", "");
        expResult.setPath("/");
        expResult.setMaxAge(0);
        Cookie result = deleteCookie(cookiename);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_String_String () {
        out.println("deleteCookie");
        String cookiename = "Foo";
        String cookieDomain = "example.org";
        Cookie expResult = new Cookie(cookiename, "");
        expResult.setDomain(cookieDomain);
        expResult.setPath("/");
        expResult.setMaxAge(0);
        Cookie result = deleteCookie(cookiename, cookieDomain);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of deleteCookie method, of class CookieTools.
     */
    public void testDeleteCookie_3args () {
        out.println("deleteCookie");
        String cookiename = "Foo";
        String cookieDomain = "example.org";
        String cpath = "/";
        Cookie expResult = new Cookie("Foo", "");
        expResult.setPath(cpath);
        expResult.setMaxAge(0);
        expResult.setDomain(cookieDomain);
        Cookie result = deleteCookie(cookiename, cookieDomain, cpath);
        assertTrue((expResult.getName().equals(result.getName()) && expResult.getValue().equals(result.getValue()) && (expResult.getMaxAge() == result.getMaxAge()) && expResult.getPath().equals(result.getPath()) && expResult.getDomain() == result.getDomain()));
    }

    /**
     * Test of cookieExists method, of class CookieTools.
     */
    public void testCookieExists () {
        out.println("cookieExists");
        Cookie[] cookies = new Cookie[]{new Cookie("Foo", "")};
        String cookieName = "Foo";
        Boolean expResult = true;
        Boolean result = cookieExists(cookies, cookieName);
        assertEquals(expResult, result);
    }

    /**
     * Test of cookieIsNullOrEmpty method, of class CookieTools.
     */
    public void testCookieIsNullOrEmpty () {
        out.println("cookieIsNullOrEmpty");
        Cookie cookie = new Cookie("Foo", "");
        Boolean expResult = true;
        Boolean result = cookieIsNullOrEmpty(cookie);
        assertEquals(expResult, result);
    }
    
}
