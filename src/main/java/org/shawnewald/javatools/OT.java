package org.shawnewald.javatools;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Object utility methods. (originally from package us.lnkn.util.ObjectTools)
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
    public static boolean objectIsNullOrEmpty (final Object[] input) {
        return (input == null || input.length == 0);
    }
    /**
     * Checks if a <code>String</code> has a null value or has a string length of 0.
     * @param input <code>String</code> the string to be tested.
     * @return <code>boolean</code>
     */
    public static boolean stringIsNullOrEmpty (final String input) {
        return (input == null || input.length() == 0);
    }
    /**
     * Checks if a <code>String[]</code> has a null value or a length of 0.
     * @param input <code>String[]</code> the string array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean stringIsNullOrEmpty (final String[] input) {
        return (input == null || input.length == 0);
    }
     /**
     * Checks if a Map has a null value or is empty.
     * @param input <code>Map</code> the Map to be tested.
     * @return <code>boolean</code>
     */
    public static boolean mapIsNullOrEmpty (final Map input) {
        return (input == null || input.isEmpty());
    }
     /**
     * Checks if a List has a null value or is empty.
     * @param input <code>List</code> the List to be tested.
     * @return <code>boolean</code>
     */
    public static boolean listIsNullOrEmpty (final List input) {
        return (input == null || input.isEmpty());
    }
     /**
     * Checks if a Set has a null value or is empty.
     * @param input <code>Set</code> the Set to be tested.
     * @return <code>boolean</code>
     */
    public static boolean setIsNullOrEmpty (final Set input) {
        return (input == null || input.isEmpty());
    }
    /**
     * Checks if an Integer has a null value or is equal to zero.
     * @param input <code>Integer</code> the Integer to be tested.
     * @return <code>boolean</code>
     */
    public static boolean integerIsNullOrZero (final Integer input) {
        return (input == null || input == 0);
    }
     /**
     * Checks if an Integer has a null value or is less than or equal to zero.
     * @param input <code>Integer</code> the Integer to be tested.
     * @return <code>boolean</code>
     */
    public static boolean integerIsNullOrLTETZero (final Integer input) {
        return (input == null || input <= 0);
    }
    /**
     * Checks if an <code>Integer[]</code> array is null or empty.
     * @param input <code>Integer[]</code> the Integer array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean integerIsNullOrEmpty (final Integer[] input) {
        return (input == null || input.length == 0);
    }
     /**
     * Checks if a Long has a null value or is equal to zero.
     * @param input <code>Long</code> the Long number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean longIsNullOrZero (final Long input) {
        return (input == null || input == 0);
    }
     /**
     * Checks if a Long has a null value or is less than or equal to zero.
     * @param input <code>Long</code> the Long number to be tested.
     * @return <code>boolean</code>
     */
    public static boolean longIsNullOrLTETZero (final Long input) {
        return (input == null || input <= 0);
    }
    /**
     * Checks if a <code>Long[]</code> array is null or empty.
     * @param input <code>Long[]</code> the Long array to be tested.
     * @return <code>boolean</code>
     */
    public static boolean longIsNullOrEmpty (final Long[] input) {
        return (input == null || input.length == 0);
    }
}