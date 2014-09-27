package org.shawnewald.javatools;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;

/**
 * Cookie Tools - HTTP Cookie manipulation methods.
 * @author  Shawn Ewald <shawn.ewald@gmail.com>
  * Copyright (C) 2009,2010,2011,2012 Shawn Ewald
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
public final class CookieTools {

    private static final int cookieAge = 31536000; // one year in seconds
    private static final String cookiePath = "/";
    private static final String empty = "";

    private CookieTools() {}
    /**
     * Create a cookie.
     * @param name <code>String</code>
     * @param value <code>String</code>
     * @return cookie <code>Cookie</code>
     */
    public static Cookie createCookie (final String name, final String value) {
            final Cookie cookie = new Cookie(name, value);
            cookie.setPath(cookiePath);
            cookie.setMaxAge(cookieAge);
            return cookie;
    }
    /**
     * Create a cookie.
     * @param name <code>String</code>
     * @param value <code>String</code>
     * @param domain <code>String</code>
     * @return cookie <code>Cookie</code>
     */
    public static Cookie createCookie (final String name, final String value,
            final String domain) {
            final Cookie cookie = new Cookie(name, value);
            cookie.setPath(cookiePath);
            cookie.setMaxAge(cookieAge);
            cookie.setDomain(domain);
            return cookie;
    }
    /**
     * Create a cookie.
     * @param name <code>String</code>
     * @param value <code>String</code>
     * @param age <code>int</code>
     * @param path <code>String</code>
     * @param domain <code>String</code>
     * @return cookie <code>Cookie</code>
     */
    public static Cookie createCookie (final String name, final String value,
            final int age, final String path, final String domain) {
            final Cookie cookie = new Cookie(name, value);
            cookie.setMaxAge(age);
            cookie.setPath(path);
            cookie.setDomain(domain);
            return cookie;
    }
    /**
     * Checks for a cookie by name, if it exists it returns a UTF-8 encoded string
     * representation of the cookie's value. This method always attempts to URLDecode
     * the non-null string value before returning it.
     * @param cookies <code>Cookies[]</code>, a cookie array.
     * @param cookieName <code>String</code>, cookie name.
     * @return value <code>String</code>, cookie value.
     */
    public static String getCookieValue (final Cookie[] cookies,
            final String cookieName) {
        final Cookie cookie = cookieFindByName(cookies, cookieName);
        return (!cookieIsNullOrEmpty(cookie))
                ? Txt.urlDecode(cookie.getValue())
                : empty;
    }
    /**
     * Returns a cookie with the name supplied in the argument or <code>null</code>
     * if the cookie doesn't exist.
     * @param cookies <code>Cookie[]</code>, a cookie array.
     * @param cookieName <code>String</code>, cookie name.
     * @return <code>Cookie</code>
     */
    public static Cookie getCookie (final Cookie[] cookies,
            final String cookieName) {
        return cookieFindByName(cookies, cookieName);
    }
    /**
     * Return <code>Cookie[]</code> array as a <code>Map</code>.
     * @param cookies <code>Cookie[]</code>
     * @return map <code>Map</code>
     */
    public static Map<String, String> cookieMap (final Cookie[] cookies) {
        final Map<String, String> map = new HashMap<String, String>(cookies.length);
        for (final Cookie c : cookies) {
            map.put(c.getName(), c.getValue());
        }
        return map;
    }
    /**
     * Updates a cookie's value.
     * @param cookies <code>C1ookie[]</code>, cookie array.
     * @param cookieName <code>String</code>, cookie name.
     * @param cookieValue <code>String</code>, cookie value.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie updateCookie (final Cookie[] cookies,
            final String cookieName, final String cookieValue) {
        final Cookie cookie = cookieFindByName(cookies, cookieName);
        cookie.setPath(cookiePath);
        cookie.setMaxAge(cookieAge);
        cookie.setValue(cookieValue);
        return cookie;

    }
    /**
     * Updates a cookie's value.
     * @param cookies <code>Cookie[]</code>, cookie array.
     * @param cookieName <code>String</code>, cookie name.
     * @param cookieValue <code>String</code>, cookie value.
     * @param cookieDomain <code>String</code>, cookie domain.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie updateCookie (final Cookie[] cookies,
            final String cookieName, final String cookieValue,
            final String cookieDomain) {
        final Cookie cookie = cookieFindByName(cookies, cookieName);
        cookie.setPath(cookiePath);
        cookie.setMaxAge(cookieAge);
        cookie.setValue(cookieValue);
        cookie.setDomain(cookieDomain);
        return cookie;
    }
    /**
     * Updates a cookie's value.
     * @param cookies <code>Cookie[]</code>, cookie arrray.
     * @param cookieName <code>String</code>, cookie name.
     * @param cookieValue <code>String</code>, cookie value.
     * @param cookieAge <code>int</code>, age of cookie in seconds.
     * @param cookiePath <code>String</code>, cookie url path.
     * @param cookieDomain <code>String</code>, cookie domain.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie updateCookie (final Cookie[] cookies,
            final String cookieName, final String cookieValue,
            final int cookieAge, final String cookiePath,
            final String cookieDomain) {
        final Cookie cookie = cookieFindByName(cookies, cookieName);
        cookie.setValue(cookieValue);
        cookie.setMaxAge(cookieAge);
        cookie.setPath(cookiePath);
        cookie.setDomain(cookieDomain);
        return cookie;
    }
    /**
     * Deletes a cookie by name.
     * @param cookiename <code>String</code>, cookie name.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie deleteCookie (final String cookiename) {
        final Cookie cookie = new Cookie(cookiename, empty);
        cookie.setPath(cookiePath);
        cookie.setMaxAge(0);
        return cookie;
    }
    /**
     * Deletes a cookie by name.
     * @param cookiename <code>String</code>, cookie name.
     * @param cookieDomain <code>String</code>, cookie domain.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie deleteCookie (final String cookiename,
            final String cookieDomain) {
        final Cookie cookie = new Cookie(cookiename, empty);
        cookie.setDomain(cookieDomain);
        cookie.setPath(cookiePath);
        cookie.setMaxAge(0);
        return cookie;
    }
    /**
     * Deletes a cookie by name
     * @param cookiename <code>String</code>, cookie name.
     * @param cookieDomain <code>String</code>, cookie domain.
     * @param cpath <code>String</code>, cookie url path.
     * @return cookie <code>Cookie</code>
     */
    public static Cookie deleteCookie (final String cookiename,
            final String cookieDomain, final String cpath) {
        final Cookie cookie = new Cookie(cookiename, empty);
        cookie.setDomain(cookieDomain);
        cookie.setPath(cpath);
        cookie.setMaxAge(0);
        return cookie;
    }
    /**
     * Tests if a cookie by the given name exists
     * @param cookies <code>Cookie[]</code>
     * @param cookieName <code>String</code> the name of the cookie.
     * @return <code>boolean</code>
     */
    public static boolean cookieExists (final Cookie[] cookies,
            final String cookieName) {
        return (cookieFindByName(cookies, cookieName) != null);
    }
    /**
     * Tests if a <code>Cookie</code> is <code>null</code> or if it's value is empty.
     * @param cookie
     * @return <code>boolean</code>
     */
    public static boolean cookieIsNullOrEmpty (final Cookie cookie) {
        return (cookie == null || cookie.getValue().isEmpty());
    }
    /**
     * Returns a <code>Cookie</code> named after <code>String</code> name from
     * <code>Cookie[]</code> array
     * @param cookies <code>Cookie[]<code>, a cookie array.
     * @param name <code>String</code>, name of cookie.
     * @return cookie <code>Cookie</code>
     */
    private static Cookie cookieFindByName (final Cookie[] cookies,
            final String name) {
        if (cookies != null && cookies.length > 0) {
            for (final Cookie c : cookies) {
                if (c.getName().equals(name)) {
                    return c;
                }
            }
        }
        return null;
    }
}