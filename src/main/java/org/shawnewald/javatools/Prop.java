package org.shawnewald.javatools;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Properties Utilities
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
public final class Prop {
    private Prop() {}
    /**
     * Load a Properties File
     * @param file <code>String</code> the properties filename.
     * @param path <code>String</code> the system path to the properties file.
     * @return Properties
     */
    public static Properties getFromFile(final String file, final String path) {
        return getFromFile(new File(path+file));
    }
    /**
     * Load a Properties File
     * @param file <code>File</code> object that contains the properties file.
     * @return Properties
     */
    public static Properties getFromFile(final File file) {
        final Properties props = new Properties();
        try {
            if (file.exists()) {
                final FileInputStream fis = new FileInputStream(file);
                props.load(fis);
                fis.close();
            }
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
    /**
     * Load a properties file from the classpath
     * @param propsName
     * @return Properties
     */
    public static Properties getFromClasspath (final String propsName) {
        final Properties props = new Properties();
        final URL url = Prop.class.getClassLoader().getResource(propsName);
        try {
            props.load(url.openStream());
        }
        catch (final IOException e) {
            throw new RuntimeException(e);
        }
        return props;
    }
    /**
     * Converts a <code>Properties</code> object to a <code>Map</code>.
     * @param p <code>Properties</code> object.
     * @return <code>Map</code>
     */
    public static Map<String, String> getPropMap (final Properties p) {
        final Map<String, String> map = new HashMap<String, String>();
        final Enumeration en = p.propertyNames();
        while (en.hasMoreElements()) {
            final String key = (String)en.nextElement();
            map.put(key, p.getProperty(key));
        }
        return map;
    }
}