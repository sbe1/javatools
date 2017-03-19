package org.shawnewald.javatools;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp.BasicDataSource;


/**
 * DataSource class
 *
 * A simple Commons DBCP pool class.
 * 
 * connectionString format:
 * jdbc:mysql://my.mysql.host.com:3306/my_database_name?user=my_username&password=my_password
 * 
 * Sample connectionString with configuration arguments.
 * jdbc:mysql://my.mysql.host.com:3306/my_database_name?user=my_username&password=my_password&useServerPrepStmts=true&amp;&amp;relaxAutoCommit=true&amp;zeroDateTimeBehavior=round&amp;useUnicode=true&amp;characterEncoding=utf8mb4
 *
 * @author Shawn Ewald <shawn.ewald@gmail.com> Copyright (C) 2009,2010,2011,2012
 * Shawn Ewald
 *
 * This program is free software; you can redistribute it and/or modify it under
 * the terms of the GNU General Public License as published by the Free Software
 * Foundation; either version 2 of the License, or (at your option) any later
 * version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along with
 * this program; if not, write to the Free Software Foundation, Inc., 51
 * Franklin Street, Fifth Floor, Boston, MA 02110-1301, USA.
 *
 */
public class DataSource {
    private static String connectionString;
    private static DataSource datasource;
    private BasicDataSource ds;
    
    /**
     * 
     * @throws IOException
     * @throws SQLException
     * @throws PropertyVetoException 
     */
    private DataSource () throws IOException, SQLException, PropertyVetoException {
        ds = new BasicDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl(connectionString);

        // the settings below are optional -- dbcp can work with defaults
        ds.setTestOnBorrow(false);
        ds.setTestOnReturn(true);
        ds.setTestWhileIdle(true);
        ds.setLogAbandoned(true);
        ds.setValidationQuery("SELECT 1;");
        ds.setPoolPreparedStatements(true);
        ds.setMinIdle(6);
        ds.setMaxIdle(24);
        ds.setMaxOpenPreparedStatements(180);
        
    }
    
    /**
     * 
     * @param connectionString
     * @return
     * @throws IOException
     * @throws SQLException
     * @throws PropertyVetoException 
     */
    public static DataSource getInstance (final String connectionString) throws IOException, SQLException, PropertyVetoException {
        if (datasource == null) {
            DataSource.connectionString = connectionString;
            datasource = new DataSource();
            return datasource;
        }
        else {
            return datasource;
        }
    }
    
    /**
     * 
     * @return con Connection
     * @throws SQLException 
     */
    public Connection getConnection () throws SQLException {
        return this.ds.getConnection();
    }
    
}
