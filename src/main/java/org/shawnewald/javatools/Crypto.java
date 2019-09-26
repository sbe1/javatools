package org.shawnewald.javatools;

import java.io.UnsupportedEncodingException;
import static java.lang.Character.MAX_RADIX;
import static java.lang.Character.MIN_RADIX;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import static java.util.UUID.randomUUID;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import static org.apache.commons.codec.binary.Base64.encodeBase64String;

/**
 * Crypto and Security Tools
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
public final class Crypto {
    private static final int defaultRadix = 16;

    private Crypto () {}
    /**
     * Generates a digest of a string using the user supplied algorithm and encoding.
     * @param str  the <code>String</code> to be converted
     * @param digest  a <code>String</code> representing the digest algorithm (e.g. "MD5", "SHA1")
     * @param encoding  a <code>String</code> represeting the text encoding of the digest (e.g. "UTF-8")
     * @param radix  an <code>int</code> value (0 = use default radix, -1 = no radix constraint).
     * @return digestedString  a digested <code>String</code>.
     */
    public static String getDigest (final String str, final String digest,
                                    final String encoding, final int radix) {
        int thisRadix = 0;
        String digestedString = null;
        try {
            final MessageDigest msgDgst = MessageDigest.getInstance(digest);
            msgDgst.update(str.getBytes(encoding), 0, str.length());
            final byte[] digestedBytes = msgDgst.digest();
            if (radix == -1) {
                digestedString = new BigInteger(1, digestedBytes).toString();
            }
            else {
                if (radix == 0 || (radix < MIN_RADIX
                        || radix > MAX_RADIX)) {
                    thisRadix = defaultRadix;
                }
                else {
                    thisRadix = radix;
                }
                digestedString =
                new BigInteger(1, digestedBytes).toString(thisRadix);
            }
        }
        catch (final NoSuchAlgorithmException | UnsupportedEncodingException e) { throw new RuntimeException(e); }
        return digestedString;
    }
    /**
     * Generates an HmacSHA1 text signature.
     * @param str <code>String</code> to sign.
     * @param key <code>String</code>, private key.
     * @param algorithm <code>String</code>
     * @param asBase64 <code>boolean</code>, should method return signature as a Base64 <code>String</code>?
     * @return <code>String</code>
     */
    public static String getSignature (final String str, final String key,
            final String algorithm, final boolean asBase64) {
        String sig = null;
        try {
            final byte[] keyBytes = key.getBytes("UTF-8");
            final byte[] strBytes = str.getBytes("UTF-8");
            final SecretKey secretKey = new SecretKeySpec(keyBytes, algorithm);
            final Mac mac = Mac.getInstance(algorithm);
            mac.init(secretKey);
            if (asBase64) {
                sig = encodeBase64String(mac.doFinal(strBytes));
            }
            else {
                sig = new BigInteger(1, mac.doFinal(strBytes)).toString(16);
            }
        }
        catch (final UnsupportedEncodingException | GeneralSecurityException e) { throw new RuntimeException(e); }
        return sig;
    }
    /**
     * Returns <code>UUID.randomUUID()</code> as a <code>String</code>.
     * @return <code>String</code>
     */
    public static String getUniqueID () {
        return randomUUID().toString();
    }
}
