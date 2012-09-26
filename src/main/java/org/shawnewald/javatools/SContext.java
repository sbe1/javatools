package org.shawnewald.javatools;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.servlet.ServletContext;

/**
 * Servlet Context tools.
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
public final class SContext {
    private SContext () {}
    /**
     * Converts the <code>ServletContext</code> InitParameter <code>Enumeration</code>
     * to a <code>Map</code>.
     * @param context <code>ServletContext</code>
     * @return <code>Map</code>, parameter values.
     */
    public static Map<String, String> getInitParameterMap (final ServletContext context) {
        final Map<String, String> map = new HashMap<String, String>();
        final Enumeration names = context.getInitParameterNames();
        while (names.hasMoreElements()) {
            final String name = (String)names.nextElement();
            map.put(name, context.getInitParameter(name));
        }
        return map;
    }
    /**
     * Returns a <code>Map</code> of <code>ServletContext</code> attributes.
     * @param context <code>ServletContext</code>
     * @return <code>Map</code>
     */
    public static Map<String, Object> getAtrributeMap (final ServletContext context) {
        final Map<String, Object> map = new HashMap<String, Object>();
        final Enumeration names = context.getAttributeNames();
        while (names.hasMoreElements()) {
            final String name = (String)names.nextElement();
            map.put(name, context.getAttribute(name));
        }
        return map;
    }
    /**
     * Sets a <code>Map</code> of name->value pairs as <code>ServletContext</code> attributes.
     * @param context <code>ServletContext</code>
     * @param attr <code>Map</code>, items to be added as attributes.
     */
    public static void setTheseAttributes (final ServletContext context,
            final Map<String, Object> attr) {
        for (final Entry e : attr.entrySet()) {
            context.setAttribute((String)e.getKey(), e.getValue());
        }
    }
    /**
     * Removes the <code>ServletContext</code> attributes defined in the
     * @param context <code>ServletContext</code>
     * @param names <code>List</code>, list of attributes to be removed.
     */
    public static void removeTheseAttributes (final ServletContext context,
            final List<String> names) {
        for (final String name : names) {
            context.removeAttribute(name);
        }
    }
}
