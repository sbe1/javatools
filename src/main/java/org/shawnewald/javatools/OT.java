package org.shawnewald.javatools;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

/**
 * Object utility methods
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
 *
 */
public final class OT {
    private OT () {}
    /**
     * Checks if an <code>Object[]</code> array is null or empty.
     * @param input <code>Object[]</code> the object array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Object[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>Object[]</code> the object array to be tested.
     * @return <code>boolean</code>
     */
    public static Object[] emptyIfNull (final Object[] input) {
        return (input == null ? new Object[]{} : input);
    }
    /**
     * Checks if a <code>String</code> has a null value or has a string length of 0.
     * @param input <code>String</code> the string to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final String input) {
        return (input == null || input.length() == 0);
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>String</code> the object array to be tested.
     * @return <code>String</code>
     */
    public static String emptyIfNull (final String input) {
        return (input == null ? "" : input);
    }
    /**
     * Checks if a <code>String[]</code> has a null value or a length of 0.
     * @param input <code>String[]</code> the string array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final String[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>String[]</code> the object array to be tested.
     * @return <code>String[]</code>
     */
    public static String[] emptyIfNull (final String[] input) {
        return (input == null ? new String[]{} : input);
    }
     /**
     * Checks if a Map has a null value or is empty.
     * @param input <code>Map</code> the Map to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Map input) {
        return (input == null || input.isEmpty());
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>Map</code> the object array to be tested.
     * @return <code>Map</code>
     */
    public static Map emptyIfNull (final Map input) {
        return (input == null ? new HashMap() : input);
    }
    /**
     * Checks if a List has a null value or is empty.
     * @param input <code>List</code> the List to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final List input) {
        return (input == null || input.isEmpty());
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>List</code> the object array to be tested.
     * @return <code>List</code>
     */
    public static List emptyIfNull (final List input) {
        return (input == null ? new ArrayList() : input);
    }
     /**
     * Checks if a Set has a null value or is empty.
     * @param input <code>Set</code> the Set to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Set input) {
        return (input == null || input.isEmpty());
    }
    /**
     * Checks if for null and returns an empty value if null or the original input if not.
     * @param input <code>Set</code> the object array to be tested.
     * @return <code>Set</code>
     */
    public static Set emptyIfNull (final Set input) {
        return (input == null ? new HashSet() : input);
    }
    /**
     * Checks if an Integer has a null value or is equal to zero.
     * @param input <code>Integer</code> the Integer to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrZero (final Integer input) {
        return (input == null || input == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Integer</code> the object array to be tested.
     * @return <code>Integer</code>
     */
    public static Integer zeroIfNull (final Integer input) {
        return (input == null ? 0 : input);
    }
     /**
     * Checks if an Integer has a null value or is less than or equal to zero.
     * @param input <code>Integer</code> the Integer to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrLTETZero (final Integer input) {
        return (input == null || input <= 0);
    }
    /**
     * Checks if an <code>Integer[]</code> array is null or empty.
     * @param input <code>Integer[]</code> the Integer array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Integer[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Integer[]</code> the object array to be tested.
     * @return <code>Integer[]</code>
     */
    public static Integer[] zeroIfNull (final Integer[] input) {
        return (input == null ? new Integer[]{} : input);
    }
     /**
     * Checks if a Long has a null value or is equal to zero.
     * @param input <code>Long</code> the Long number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrZero (final Long input) {
        return (input == null || input == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Long</code> the object array to be tested.
     * @return <code>Long</code>
     */
    public static Long zeroIfNull (final Long input) {
        return (input == null ? 0L : input);
    }
     /**
     * Checks if a Long has a null value or is less than or equal to zero.
     * @param input <code>Long</code> the Long number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrLTETZero (final Long input) {
        return (input == null || input <= 0);
    }
    /**
     * Checks if a <code>Long[]</code> array is null or empty.
     * @param input <code>Long[]</code> the Long array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Long[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Long[]</code> the object array to be tested.
     * @return <code>Long[]</code>
     */
    public static Long[] emptyIfNull (final Long[] input) {
        return (input == null ? new Long[]{} : input);
    }
     /**
     * Checks if a Number has a null value or is equal to zero.
     * @param input <code>Number</code> the Number number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrZero (final Number input) {
        return (input == null || input.shortValue() == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Number</code> the object array to be tested.
     * @return <code>Number</code>
     */
    public static Number zeroIfNull (final Number input) {
        return (input == null ? 0 : input);
    }
     /**
     * Checks if a Long has a null value or is less than or equal to zero.
     * @param input <code>Long</code> the Long number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrLTETZero (final Number input) {
        return (input == null || input.shortValue() <= 0);
    }
    /**
     * Checks if a <code>Number[]</code> array is null or empty.
     * @param input <code>Number[]</code> the Number array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean nullOrEmpty (final Number[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if for null and returns a zero value if null or the original input if not.
     * @param input <code>Number[]</code> the object array to be tested.
     * @return <code>Number[]</code>
     */
    public static Number[] emptyIfNull (final Number[] input) {
        return (input == null ? new Number[]{} : input);
    }
}