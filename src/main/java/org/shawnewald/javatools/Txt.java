package org.shawnewald.javatools;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Text manipulation and conversion methods.
 * @version 1.0
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
public final class Txt {
    private static final String empty = "";
    private static final String textEncoding = "UTF-8";
    private static String numbersCharacters = "0123456789";
    private static String capsCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static String standardCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
    private static String extendedCharacters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz~!@#$%^&*()_+=-{}][;:/?><,.";
    public static enum Chars {STANDARD,EXTENDED,CAPS,NUMBERS};
    
    private Txt () {}

    /**
     * Converts a string to UTF-8 encoding. Returns null on failure.
     * @param string  <code>String</code>
     * @return utf8String  <code>String</code> converted to UTF-8.
     */
    public static String toUTF8 (final String string) {
        final byte[] s = string.getBytes();
        final String utf8String;
        try {
            utf8String = new String(s, textEncoding);
        }
        catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        return utf8String;
    }
    /**
     * Escape single and double quotes in a string with backslashes.
     * @param string  <code>String</code>
     * @return changedString  <code>String</code>
     */
    public static String escapeQuote (final String s) {
        final StringBuilder sb = new StringBuilder();
        final int strlen = s.length();
        for (int i=0; i<strlen; i++) {
            final char c = s.charAt(i);
            if (c == '\'') {
                sb.append("\\\'");
            }
            else if (c == '"') {
                sb.append("\\\"");
            }
            else { sb.append(c); }
        }
        return sb.toString();
    }

    /**
     * Remove escape slashes from string.
     * @param s  <code>String</code>
     * @return string  <code>String</code>
     */
    public static String deEscapeQuote (final String s) {
        final StringBuilder sb = new StringBuilder();
        final int strlen = s.length();
        for (int i=0; i<strlen; i++) {
            final char c = s.charAt(i);
            if (c != '\\') { sb.append(c); }
        }
        return sb.toString();
    }

    /**
     * Removes URL encoding characters from a string. String is converted to UTF-8
     * encoding in the process. Retuns null on failure.
     * @param thisString  <code>String</code>
     * @return result  <code>String</code>
     */
    public static String urlDecode (final String thisString) {
        try {
            return URLDecoder.decode(thisString, textEncoding);
        }
        catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * URL encodes string to www-form-urlencoded format. String is converted to UTF-8
     * encoding in the process. Retuns null on failure.
     * @param thisString  <code>String</code>
     * @return result  <code>String</code>
     */
    public static String urlEncode (final String thisString) {
        try {
            return URLEncoder.encode(thisString, textEncoding);
        }
        catch (final UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Reads a file and returns the contents as a <code>String</code>.
     * @param file <code>String</code>, a text filename.
     * @return <code>String</code>
     */
    public static String getFileAsString (final String file) {
        final String out;
        try {
            final FileInputStream fis = new FileInputStream(file);
            out = streamToString(fis,true);
            fis.close();
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return out;
    }
    /**
     * Converts the contents of an <code>InputStream</code> to a <code>String</code>
     * @param is <code>InputStream</code>
     * @return <code>String</code>
     * @throws IOException
     */
    public static String streamToString(final InputStream is, final boolean addNewlines)
            throws IOException {
        final StringBuilder sb = new StringBuilder();
        try {
            final BufferedReader reader =
                           new BufferedReader(new InputStreamReader(is, textEncoding));
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
                if (addNewlines) { sb.append('\n'); }
            }
        }
        finally {
            is.close();
        }
        return sb.toString();
    }
    private static final String HEXES = "0123456789ABCDEF";
    private static final String safeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789_-.~";
    /**
     * Percent encodes a string in a format that is suitable for OAuth Base Strings
     * and other uses not requiring a www-form-urlencoded string.
     * @param str <code>String</code>
     * @return <code>String</code>
     */
    public static String percentEncode (final String str) {
        final StringBuilder sb = new StringBuilder();
        final char[] chars = str.toCharArray();
        for (final char c : chars) {
            if (safeChars.indexOf(c) > -1) {
                sb.append(c);
                continue;
            }
            sb.append('%');
            if (c < 10) { sb.append('0'); }
            final byte b = (byte)(c & 0xFF);
            sb.append(HEXES.charAt((b & 0xF0) >> 4))
                    .append(HEXES.charAt((b & 0x0F)));
        }
        return sb.toString();
    }
    /**
     * Checks if the needle, <code>char</code>, is in the haystack, <code>char[]</code>,
     * returns <code>true</code> if <code>char</code> is found.
     * @param needle <code>char</code>
     * @param haystack <code>char[]</code>
     * @return <code>boolean</code>
     */
    public static boolean charExists (final char needle,
            final char[] haystack) {
        for (final char c : haystack) {
            if (c == needle) {
                return true;
            }
        }
        return false;
    }
    /**
     * Join all elements of a <code>String[]</code> into a <code>String</code>. 
     * @param string <code>String[]</code> - the array to join together.
     * @param glue <code>String</code> a string to append between <code>String[]</code> elements.
     * @return <code>String</code>
     */
    public static String join (final String[] string, final String glue) {
        final StringBuilder sb = new StringBuilder();
        final int strsz = string.length;
        if (strsz == 1) {
            return string[0];
        }
        else if (strsz > 1) {
            sb.append(string[0]);
            for (int i=1;i<strsz;i++) {
                sb.append(glue).append(string[i]);
            }
        }
        return sb.toString();
    }
    /**
     * Join all elements of a <code>List</code> into a <code>String</code>. 
     * @param list <code>List</code> - the list to join together.
     * @param glue <code>String</code> a string to append between <code>String[]</code> elements.
     * @return <code>String</code>
     */
    public static String join (final List<?> list, final String glue) {
        final int strsz = list.size();
        if (strsz == 1) {
            return ""+list.get(0);
        }
        final StringBuilder sb = new StringBuilder();
        if (strsz > 1) {
            sb.append(list.get(0));
            for (int i=1;i<strsz;i++) {
                sb.append(glue).append(list.get(i));
            }
        }
        return sb.toString();
    }
    /**
     * Join all elements of a <code>Map</code> into a <code>String</code>.
     * @param map
     * @return <code>String</code>
     */
    public static String join (Map<?, ?> map, final String glue, final String seperator) {
        final StringBuilder sb = new StringBuilder();
        Set<?> columns = map.keySet();
        boolean isFirstCol = true;
        for (Object col : columns) {
            if (isFirstCol) {
                sb.append(col).append(seperator).append(map.get(col));
                isFirstCol = false;
            } else {
                sb.append(glue).append(col).append(seperator).append(map.get(col));
            }
        }
        return sb.toString();
    }
    /**
     * Count the number of occurances of a <code>char</code> in a <code>String</code>.
     * @param needle <code>char</code>
     * @param haystack <code>String</code>
     * @return <code>int</code>
     */
    public static int countOccurrences(final char needle, final String haystack) {
        int count = 0;
        if (haystack != null && !haystack.isEmpty()) {
            final int hlen = haystack.length();
            for (int i = 0; i < hlen; i++) {
                if (haystack.charAt(i) == needle) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * Generate a random string
     * @param length <code>int</code> length of returned string.
     * @param chars <code>Txt.Chars</code> character set source.
     * @return <code>String</code>
     */
    public static String randomString (final int length, final Txt.Chars chars) {
        final String characters = (chars == Txt.Chars.STANDARD) ? standardCharacters
                                  : (chars == Txt.Chars.EXTENDED) ? extendedCharacters
                                    : (chars == Txt.Chars.CAPS) ? capsCharacters : numbersCharacters;
        final StringBuffer sb = new StringBuffer(length);
        if (length > 0) {
            final int clen = characters.length() - 1;
            final Random random = new Random();
            for (int i=0;i<length;i++) {
                sb.append(characters.charAt(random.nextInt(clen)));
            }
        }
        return sb.toString();
    }
}
