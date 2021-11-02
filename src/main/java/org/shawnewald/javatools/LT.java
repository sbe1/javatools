package org.shawnewald.javatools;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Log4J Logging Tools
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
public final class LT {
    private LT () {}
    /**
     * Log error with complete stack trace.
     * @param log <code>org.apache.log4j.Logger</code>
     * @param e <code>Throwable</code>
     */
    public static void logError(final org.apache.logging.log4j.Logger log, final Throwable e) {
        log.error(e);
        log.error(getStackTrace(e), e);
    }
    /**
     * Log error with complete stack trace.
     * @param log <code>java.util.logging.Logger</code>
     * @param e <code>Throwable</code>
     */
    public static void logError(final java.util.logging.Logger log, final Throwable e) {
        log.severe(e.getMessage());
        log.severe(getStackTrace(e));
    }
    /**
     * Return a stack trace as a string.
     * @param t <code>Throwable</code>
     * @return <code>String</code>
     */
    public static String getStackTrace(Throwable t) {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        t.printStackTrace(new PrintStream(baos));
        return baos.toString();
    }
}
