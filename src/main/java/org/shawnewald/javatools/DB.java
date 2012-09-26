package org.shawnewald.javatools;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import org.apache.log4j.Logger;
/**
 * JDBC/JDNI Database class
 *
 * This is a specialized (and possibly somewhat idiosyncratic) database class
 * for connecting to JNDI datasources.
 *
 * It is designed to release the database connection back to the connection pool
 * as quickly as possible. All query results are disconnected, meaning an active
 * <code>ResultSet</code> is not returned on queries that return a result.
 *
 * Instead, a <code>List</code> of <code>Map</code>s is returned -- with the exception
 * of three utility methods which return a <code>List</code> of <code>String</code>s,
 * a <code>List</code> of <code>Object</code>s, and a <code>Set</code> of <code>Object</code>s,
 * respectively.
 *
 * Prepared queries are supported, but not named parameters. Batch queries,
 * including prepared batch queries are also supported.
 *
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
public final class DB {
    private DataSource datasource;
    private int resultLimit = 30;
    private int batchSize = 1000;
    private static final Logger LOG = Logger.getLogger(DB.class);

    /**
     * Class constructor, initializes connection to JNDI datasource.
     * @param datasourceContext  a <code>String</code> containing the JNDI datasource url.
     */
    public DB (final String datasourceContext) {
        createDatasource(datasourceContext);
    }
    /**
     * Class constructor, initializes connection to JNDI datasource and sets
     * the value of the default resultLimit to a user supplied value.
     * @param datasourceContext  a <code>String</code> containing the JNDI datasource.
     * @param limit  an <code>int</code> containing the result limit.
     */
    public DB (final String datasourceContext, final int limit) {
        resultLimit = limit;
        createDatasource(datasourceContext);
    }
    /**
     * Class constructor, initializes connection to JNDI datasource and sets
     * the value of the default resultLimit to a user supplied value and
     * sets the batch query limit to a user supplied value.
     * @param datasourceContext  a <code>String</code> containing the JNDI datasource.
     * @param limit  an <code>int</code> containing the result limit.
     */
    public DB (final String datasourceContext, final int limit,
            final int batchLimit) {
        resultLimit = limit;
        batchSize = batchLimit;
        createDatasource(datasourceContext);
    }
    private void createDatasource (final String datasourceContext) {
        try {
            final Context initialContext = new InitialContext();
            datasource = (DataSource)initialContext.lookup(datasourceContext);
        }
        catch (final NamingException e) {
            LOG.error(e);
            throw new RuntimeException(e);
        }
    }
    /**
     * Sets the database connection.
     * @return con  <code>java.sql.Connection</code>
     */
    private Connection setConnection () {
        final Connection con;
        try {
            con = datasource.getConnection();
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        return con;
    }
    /**
     * Closes the database connection.
     * @param con  <code>java.sql.Connection</code>
     */
    private void closeConnection (final Connection con) {
        try {
            if (con != null) {
                con.close();
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
    }
    /**
     * Close <code>Statement</code>
     * @param stmt
     */
    private void closeStatement (final Statement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        }
        catch (final SQLException ex) { LOG.error(ex); }
    }
    /**
     * Close <code>PreparedStatement</code>
     * @param stmt
     */
    private void closePreparedStatement (final PreparedStatement stmt) {
        try {
            if (stmt != null) {
                stmt.close();
            }
        }
        catch (final SQLException ex) { LOG.error(ex); }
    }
    /**
     * Close <code>ResultSet</code>
     * @param rs
     */
    private void closeResultSet (final ResultSet rs) {
        try {
            if (rs != null) {
                rs.close();
            }
        }
        catch (final SQLException ex) { LOG.error(ex); }
    }
    /**
     * Execute SQL query and return the result with no result limit.
     * @param query  a <code>String</code> containing an SQL query.
     * @return <code>java.util.List<Map></code>
     */
    public List<Map<String,Object>> getResultQuery (final String query) {
        return doQuery(query);
    }

    private static final String litLimit = "\nLIMIT ";
    private static final String litComma = ",";
    /**
     * Execute SQL query and return the result. If limit argument is true,
     * return only up to default result limit.
     * @param input  a <code>String</code> containing an SQL query.
     * @param limit  an <code>int</code>
     * @return <code>java.util.List<Map></code>
     */
    public List<Map<String,Object>> getResultQuery (final String input,
            final boolean limit) {
        String query = input;
        if (limit) {
            query += litLimit + resultLimit;
        }
        return doQuery(query);
    }
    /**
     * Execute SQL query and return the result starting at the row number
     * defined in the limit parameter or null if the query fails.
     * @param input  a <code>String</code> containing an SQL query.
     * @param limit  an <code>int</code>
     * @return <code>java.util.List<Map></code>
     */
    public List<Map<String,Object>> getResultQuery (final String input,
            final int limit) {
        final StringBuilder query = new StringBuilder().append(input);
        if (limit > 0) {
            query.append(litLimit).append(limit).append(litComma).append(resultLimit);
        }
        return doQuery(query.toString());
    }
    /**
     * Execute a prepared SQL query and return the result with no result limit.
     * @param query  a <code>String</code> containing a prepared SQL query.
     * @param values  a <code>java.util.List<Object></code> of prepared values.
     * @return <code>java.util.List<Map></code>
     */
    public List<Map<String,Object>> getPreparedResultQuery (final String query,
                                             final List<Object> values) {
        return doPreparedQuery(query, values);
    }
    /**
     * Execute a prepared SQL query and return the result starting at the
     * row number defined in the limit parameter or null if the query fails.
     * @param input  a <code>String</code> containing a prepared SQL query.
     * @param values  a <code>java.util.List<Object></code> of prepared values.
     * @param limit  an <code>int</code>
     * @return <code>java.util.List<Map></code>
     */
    public List<Map<String,Object>> getPreparedResultQuery (final String input,
                                             final List<Object> values,
                                             final int limit) {
        final StringBuilder query = new StringBuilder().append(input);
        if (limit > 0) {
            query.append(litLimit).append(limit).append(litComma).append(resultLimit);
        }
        return doPreparedQuery(query.toString(), values);
    }
    /**
     * Executes a query and returns a single value from the first row
     * and first column of the result.
     * @param query  a <code>String</code> containing an SQL query.
     * @return result  <code>Object</code>
     */
    public Object getOne (final String query) {
        final Connection con = setConnection();
        Statement stmt = null;
        ResultSet rs = null;
        Object result = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null && rs.next()) {
                result = rs.getObject(1);
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
        return result;
    }
    /**
     * Executes a prepared query and returns a single value from the first row
     * and first column of the result.
     * @param query  a <code>String</code> containing a prepared SQL query.
     * @param values  a <code>java.util.List<Object></code> of prepared values.
     * @return result  <code>java.lang.Object</code>
     */
    public Object getPreparedOne (final String query, final List<Object> values) {
        final Connection con = setConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Object result = null;
        try {
            stmt = con.prepareStatement(query);
            setStatementValues(stmt, values);
            rs = stmt.executeQuery();
            if (rs != null && rs.next()) {
                result = rs.getObject(1);
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closePreparedStatement(stmt);
            closeConnection(con);
        }
        return result;
    }
    /**
     * Returns all the values of one column in a query ResultSet as a <code>List</code>.
     * @param query  a <code>String</code> containing a SQL query.
     * @param column  a <code>String</code> describing the column to retrieve.
     * @return list  <code>List</code>
     */
    public List<Object> getColumnList (final String query,
                                       final String column) {
        final Connection con = setConnection();
        Statement stmt = null;
        ResultSet rs = null;
        final List<Object> list = new ArrayList<Object>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null && rs.isBeforeFirst()) {
                while (rs.next()) {
                    list.add(rs.getObject(column));
                }
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
        return list;
    }
    /**
     * Returns all the values of one column in a query ResultSet as a <code>Set</code>.
     * @param query  a <code>String</code> containing a SQL query.
     * @param column  a <code>String</code> describing the column to retrieve.
     * @return set  <code>Set</code>
     */
    public Set<Object> getColumnSet (final String query,
                                       final String column) {
        final Set<Object> set = new HashSet<Object>();
        set.addAll(getColumnList(query,column));
        return set;
    }
    /**
     * Returns all the values of one column in a query ResultSet as a <code>Set</code>.
     * Column must be a string type (e.g. VARCHAR).
     * @param query  a <code>String</code> containing a SQL query.
     * @param column  a <code>String</code> describing the column to retrieve.
     * @return set  <code>Set</code>
     */
    public Set<String> getColumnStringSet (final String query,
                                       final String column) {
        final Connection con = setConnection();
        Statement stmt = null;
        ResultSet rs = null;
        final Set<String> set = new HashSet<String>();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null && rs.isBeforeFirst()) {
                while (rs.next()) {
                    set.add(rs.getString(column));
                }
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
        return set;
    }
    private static final String enumQuery = "SELECT REPLACE ( (\n" + "  SELECT REPLACE( (\n"
                + "    SELECT REPLACE( (\n" + "      SELECT COLUMN_TYPE\n"
                + "       FROM INFORMATION_SCHEMA.COLUMNS\n"
                + "       WHERE TABLE_NAME = ?\n"
                + "       AND COLUMN_NAME = ?), 'enum(', '')\n"
                + "  ), ')', '')\n" + "), '\\'', '')";
    /**
     * Returns a <code>List</code> of an enum field's values.
     * WARNING: MySQL-specific. Works on MySQL, I have no idea if it works on anything else.
     * @param table  a <code>String</code> describing the table to query.
     * @param column  a <code>String</code> describing the column whose enum values are to be retrieved.
     * @return values  <code>List<String></code>
     */
    public List<String> getEnumValues (final String table,
                                       final String column) {
        final List<String> values = new ArrayList<String>();
        final List<Object> items = new ArrayList<Object>(2);
        items.add(table);
        items.add(column);
        final String r = (String)getPreparedOne(enumQuery, items);
        if (r != null) {
            final String[] v = r.split(litComma);
            values.addAll(Arrays.asList(v));
        }
        return values;
    }

    private static final String litDetails = " Details: ";

    /**
     * Execute a SQL query that will not return a result (e.g. INSERT, UPDATE).
     * @param query  a <code>String</code> containing an SQL query.
     */
    public void doVoidQuery (final String query) {
        final Connection con = setConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(query);
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeStatement(stmt);
            closeConnection(con);
        }
    }
    /**
     * Execute a prepared SQL query that will not return a result (e.g. INSERT, UPDATE).
     * @param query  a <code>String</code> containing a prepared SQL query.
     * @param values  a <code>java.util.List<Object></code> of prepared values.
     */
    public void doPreparedVoidQuery (final String query,
                                     final List<Object> values) {
        final Connection con = setConnection();
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(query);
            setStatementValues(stmt, values);
            stmt.executeUpdate();
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closePreparedStatement(stmt);
            closeConnection(con);
        }
    }
    /**
     * Executes a SQL query  and returns the <code>ResultSet</code> as a
     * <code>List</code> of <code>Map</code>s.
     * @param query  a <code>String</code> containing an SQL query.
     * @return result  <code>java.util.List<Map></code>
     */
    private List<Map<String,Object>> doQuery (final String query) {
        final Connection con = setConnection();
        Statement stmt = null;
        ResultSet rs = null;
        List<Map<String,Object>> result = null;
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            if (rs != null && rs.isBeforeFirst()) {
                result = convertResultSet(rs);
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex + litDetails + query);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closeStatement(stmt);
            closeConnection(con);
        }
        return result;
    }
    /**
     * Executes a SQL query as a prepared statement and returns
     * the ResultSet as a List of Maps.
     * @param query  a <code>String</code> containing a prepared SQL query.
     * @param values  a <code>List<Object></code> of parameter values.
     * @return result  <code>List<Map></code>
     */
    private List<Map<String,Object>> doPreparedQuery (final String query,
                                       final List<Object> values) {
        final Connection con = setConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Map<String,Object>> result = null;
        try {
            stmt = con.prepareStatement(query);
            setStatementValues(stmt, values);
            rs = stmt.executeQuery();
            if (rs != null && rs.isBeforeFirst()) {
                result = convertResultSet(rs);
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeResultSet(rs);
            closePreparedStatement(stmt);
            closeConnection(con);
        }
        return result;
    }
    /**
     * Execute a batch of queries stored in a String[] array.
     * @param batch  a <code>String[]</code> containing a batch of SQL queries.
     */
    public void doBatchQuery (final List<String> batch) {
        final Connection con = setConnection();
        Statement stmt = null;
        int count = 0;
        try {
            stmt = con.createStatement();
            // if the batch has only one query, just do a Statement.executeUpdate
            // on that single query.
            if (batch != null && batch.size() > 0) {
                for (final String query : batch) {
                    stmt.addBatch(query);
                    if (++count % batchSize == 0) {
                        stmt.executeBatch();
                    }
                }
                stmt.executeBatch();
            }
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closeStatement(stmt);
            closeConnection(con);
        }
    }
    /**
     * Execute a batch of prepared queries.
     * @param sql <code>String</code>, a SQL statement with '?' placeholders.
     * @param batch  a <code>List</code> of <code>List</code>s containing prepared values.
     */
    public void doBatchPreparedQuery (final String sql, final List<List<Object>> batch) {
        final Connection con = setConnection();
        PreparedStatement stmt = null;
        int count = 0;
        try {
            stmt = con.prepareStatement(sql);
            for (final List<Object> values : batch) {
                setStatementValues(stmt,values);
                stmt.addBatch();
                if(++count % batchSize == 0) {
                    stmt.executeBatch();
                }
            }
            stmt.executeBatch();
        }
        catch (final SQLException ex) {
            LOG.error(ex);
            throw new RuntimeException(ex);
        }
        finally {
            closePreparedStatement(stmt);
            closeConnection(con);
        }
    }
    /**
     * Convert a <code>ResultSet</code> to a <code>List</code> of <code>Map</code>s
     * @param rs  <code>ResultSet</code>
     * @return rows  <code>List</code>
     */
    private List<Map<String,Object>> convertResultSet (final ResultSet rs) {
        final List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
        try {
            final ResultSetMetaData meta = rs.getMetaData();
            final int numberOfColumns = meta.getColumnCount();
            while (rs.next()) {
                final Map<String, Object> map = new HashMap<String, Object>();
                for (int c = 1; c <= numberOfColumns; ++c) {
                    final String name = meta.getColumnName(c);
                    final Object value = rs.getObject(c);
                    // place into HashMap
                    map.put(name, value);
                }
                // add map to List
                rows.add(map);
            }
        }
        catch (final SQLException e) {
            LOG.error(e);
        }
        return rows;
    }
    /**
     * Sets the parameter values in a prepared statment object.
     * @param stmt  <code>java.sql.PreparedStatement</code>
     * @param values  <code>java.util.List</code>
     * @return stmt  <code>java.util.PreparedStatement</code>
     */
    private void setStatementValues (final PreparedStatement stmt,
                                     final List<Object> values) {
        try {
            int i = 1;
            for (final Object item : values) {
                String type = null;
                if (item == null) {
                    stmt.setNull(i, java.sql.Types.NULL);
                }
                else {
                    type = item.getClass().getName();
                    setItemValue(stmt, item, type, i);
                }
                ++i;
            }
        }
        catch (final Exception e) {
            LOG.error(e);
        }
    }

    private static final String litTypeString = "String";
    private static final String litTypeInt = "int";
    private static final String litTypeInteger = "Integer";
    private static final String litTypelong = "long";
    private static final String litTypeLong = "Long";
    private static final String litTypedouble = "double";
    private static final String litTypeDouble = "Double";
    private static final String litTypefloat = "float";
    private static final String litTypeFloat = "Float";
    private static final String litTypeBigInt = "BigInteger";
    private static final String litTypeboolean = "boolean";
    private static final String litTypeBoolean = "Boolean";
    private static final String litTypeDate = "Date";
    private static final String litTypeTime = "Time";
    private static final String litTypeTimestamp = "Timestamp";
    private static final String litJSONNull = "JSONNull";
    private static final String litStringNull = "null";
    private static final String litTypeObject = "Object";
    private static final String typeErrorStart = "Argument type not found: This statement "
                        + "will fail because not all statment arguments have been set. "
                        + "This database class only supports the most commonly used types. "
                        + "The argument of type '";
    private static final String typeErrorEnd = "' is not supported.";
    /**
     * Sets a value as a <code>PreparedStatement</code> parameter. Not all possible
     * Java object types are supported.
     * Supported types: <code>String</code>, <code>int</code>, <code>Integer</code>,
     * <code>long</code>, <code>Long</code>, <code>double</code>, <code>Double</code>,
     * <code>float</code>, <code>Float</code>, <code>BigInteger</code>, <code>Boolean</code>,
     * <code>Date</code>, <code>Time</code>, <code>Timestamp</code> and <code>Object</code>
     * @param stmt <code>PreparedStatement</code>
     * @param item <code>Object</code>, the value to be set
     * @param type <code>String</code>, item object type from <code>item.getClass().getName()</code>
     * @param i <code>int</code>, statement argument index.
     * @throws RuntimeException if the <code>item</code> method argument is not a supported object type.
     */
    private void setItemValue (final PreparedStatement stmt,
                               final Object item, final String type, final int i) {
        try {
            if (type.endsWith(litTypeString)) {
                if (litStringNull.equalsIgnoreCase((String)item)) {
                    stmt.setNull(i, java.sql.Types.NULL);
                }
                else { stmt.setString(i, (String) item); }
            }
            else if (type.endsWith(litTypeInt) || type.endsWith(litTypeInteger)) {
                stmt.setInt(i, (Integer) item);
            }
            else if (type.endsWith(litTypelong) || type.endsWith(litTypeLong)) {
                stmt.setLong(i, (Long) item);
            }
            else if (type.endsWith(litTypedouble) || type.endsWith(litTypeDouble)) {
                stmt.setDouble(i, (Double) item);
            }
            else if (type.endsWith(litTypefloat) || type.endsWith(litTypeFloat)) {
                stmt.setFloat(i, (Float) item);
            }
            else if (type.endsWith(litTypeBigInt)) {
                stmt.setLong(i, (Long) item);
            }
            else if (type.endsWith(litTypeboolean) || type.endsWith(litTypeBoolean)) {
                stmt.setBoolean(i, (Boolean) item);
            }
            else if (type.endsWith(litTypeDate)) {
                stmt.setDate(i, (Date) item);
            }
            else if (type.endsWith(litTypeTime)) {
                stmt.setTime(i, (Time) item);
            }
            else if (type.endsWith(litTypeTimestamp)) {
                stmt.setTimestamp(i, (Timestamp) item);
            }
            else if (type.endsWith(litJSONNull)) {
                stmt.setNull(i, java.sql.Types.NULL);
            }
            else if (type.endsWith(litTypeObject)) {
                stmt.setObject(i, item);
            }
            else {
                throw new RuntimeException(typeErrorStart + type + typeErrorEnd);
            }
        }
        catch (final SQLException e) {
            LOG.error(e);
            LOG.error("prepared stmt: " + stmt);
            LOG.error(LT.getStackTrace(e));
        }
    }
}