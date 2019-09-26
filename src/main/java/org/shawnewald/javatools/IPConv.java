package org.shawnewald.javatools;

import static java.lang.Integer.parseInt;
import static java.lang.Math.pow;

/**
 * IP4 Address Conversion Tools
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
public final class IPConv {
    private IPConv () {}

    /**
     * Converts a <code>String</code> representation of an IP4 address to a <code>long</code> number.
     * @param addr <code>String</code>, an IP4 address string.
     * @return num <code>long</code>, the converted IP address.
     */
    public static long ipToLong(final String addr) {
        final String[] addrArray = addr.split("\\.");
        long num = 0;
        final int len = addrArray.length;
        for (int i=0;i<len;i++) {
            final int power = 3-i;
            num += (parseInt(addrArray[i])%256 * pow(256,power));
        }
        return num;
    }

    /**
     * Convert an IP4 address to a string from an int representation.
     * @param ip <code>int</code>, representation of an IP4 address.
     * @return <code>String</code> converted representation of an IP4 address.
     */
    public static String intToIp(final int ip) {
        return ((ip >> 24) & 0xFF) + "." +
            ((ip >> 16) & 0xFF) + "." +
            ((ip >>  8) & 0xFF) + "." +
            (ip & 0xFF);
    }
    /**
     * Inverts an IP address to match the requirements of most RBL DNS services.<br>
     * Example: <code>inverseIPAddress("127.0.0.2")</code> --&gt; <code>2.0.0.127</code>
     *
     * @param originalIPAddress <code>String</code>, the IP address to invert.
     * @return inverted <code>String</code>, the inverted form of the passed IP address.
     */
    public static String invertIP (final String originalIPAddress) {
        final String[] arr = ipToArray(originalIPAddress);
        final StringBuilder inverted = new StringBuilder();
        for (int i=(arr.length - 1);i>=0;i--) {
            inverted.append(arr[i]);
            if (i != 0) { inverted.append('.'); }
        }
        return inverted.toString();
    }
    /**
     * Returns the segments of an IP4 address stored in a <code>String[]</code> array.
     * Supports IP4 addresses only.
     * @param ip <code>String</code>, IP4 address.
     * @return array
     */
    public static String[] ipToArray (final String ip) {
        return ip.split("\\.", 4);
    }
    /**
     * Returns the segments of an IP4 address stored in an <code>int[]</code> array.
     * @param ip <code>String</code>, IP4 address.
     * @return <code>int[]</code>
     */
    public static int[] ipToIntArray (final String ip) {
        final String[] strArray = ipToArray(ip);
        final int[] intArray = new int[4];
        for (int i=0;i<4;i++) {
            intArray[i] = parseInt(strArray[i]);
        }
        return intArray;
    }
}
