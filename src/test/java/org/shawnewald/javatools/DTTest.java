/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import static java.lang.System.out;
import java.util.Date;
import java.util.Set;
import junit.framework.TestCase;
import static org.shawnewald.javatools.DT.DateRange.DAY7;
import static org.shawnewald.javatools.DT.addDate;
import static org.shawnewald.javatools.DT.addDate;
import static org.shawnewald.javatools.DT.daysBetweenDates;
import static org.shawnewald.javatools.DT.daysBetweenDates;
import static org.shawnewald.javatools.DT.formatDate;
import static org.shawnewald.javatools.DT.formatDateTime;
import static org.shawnewald.javatools.DT.formatISOAltDate;
import static org.shawnewald.javatools.DT.formatISODate;
import static org.shawnewald.javatools.DT.formatRFC822Date;
import static org.shawnewald.javatools.DT.formatTextDate;
import static org.shawnewald.javatools.DT.formatTwitterDate;
import static org.shawnewald.javatools.DT.formatUnformattedDate;
import static org.shawnewald.javatools.DT.isoDateToTextDate;
import static org.shawnewald.javatools.DT.stringToDate;
import static org.shawnewald.javatools.DT.stringToDateISO;
import static org.shawnewald.javatools.DT.stringToDateISOAlt;
import static org.shawnewald.javatools.DT.stringToRFC822Date;
import static org.shawnewald.javatools.DT.stringToTwitterDate;
import static org.shawnewald.javatools.DT.stringToUnformattedDate;

/**
 *
 * @author s
 */
public class DTTest extends TestCase {
    
    public DTTest (String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp () throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown () throws Exception {
        super.tearDown();
    }

    /**
     * Test of formatDateTime method, of class DT.
     */
    public void testFormatDateTime () {
        out.println("formatDateTime");
        Date date = new Date(19872000);
        String expResult = "1970-01-01 00:31:12";
        String result = formatDateTime(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatTextDate method, of class DT.
     */
    public void testFormatTextDate () {
        out.println("formatTextDate");
        Date date = new Date(19872000);
        String expResult = "January 1, 1970";
        String result = formatTextDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatRFC822Date method, of class DT.
     */
    public void testFormatRFC822Date () {
        out.println("formatRFC822Date");
        Date date = new Date(19872000);
        String expResult = "Thu, 01 Jan 1970 00:31:12 -0500";
        String result = formatRFC822Date(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatISODate method, of class DT.
     */
    public void testFormatISODate () {
        out.println("formatISODate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01T00:31:12Z";
        String result = formatISODate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatISOAltDate method, of class DT.
     */
    public void testFormatISOAltDate () {
        out.println("formatISOAltDate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01T00:31:12";
        String result = formatISOAltDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatTwitterDate method, of class DT.
     */
    public void testFormatTwitterDate () {
        out.println("formatTwitterDate");
        Date date = new Date(19872000);
        String expResult = "Thu Jan 01 00:31:12 -0500 1970";
        String result = formatTwitterDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatDate method, of class DT.
     */
    public void testFormatDate () {
        out.println("formatDate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01";
        String result = formatDate(date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of formatDate method, of class DT.
     */
    public void testFormatUnformattedDate () {
        out.println("formatUnformattedDate");
        Date date = new Date(19872000);
        String expResult = "19700101";
        String result = formatUnformattedDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDate method, of class DT.
     */
    public void testStringToUnformattedDate () {
        out.println("stringToDate");
        String date = "19700101";
        Date expResult = new Date(18000000);
        Date result = stringToUnformattedDate(date);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of stringToDate method, of class DT.
     */
    public void testStringToDate () {
        out.println("stringToDate");
        String date = "1970-01-01";
        Date expResult = new Date(18000000);
        Date result = stringToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDateISO method, of class DT.
     */
    public void testStringToDateISO () {
        out.println("stringToDateISO");
        String date = "1970-01-01T00:31:12Z";
        Date expResult = new Date(19872000);
        Date result = stringToDateISO(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDateISOAlt method, of class DT.
     */
    public void testStringToDateISOAlt () {
        out.println("stringToDateISOAlt");
        String date = "1970-01-01T00:31:12";
        Date expResult = new Date(19872000);
        Date result = stringToDateISOAlt(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isoDateToTextDate method, of class DT.
     */
    public void testIsoDateToTextDate () {
        out.println("isoDateToTextDate");
        String date = "1970-01-01T00:00:00Z";
        String expResult = "January 1, 1970";
        String result = isoDateToTextDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToRFC822Date method, of class DT.
     */
    public void testStringToRFC822Date () {
        out.println("stringToRFC822Date");
        String date = "Thu, 01 Jan 1970 00:31:12 -0500";
        Date expResult = new Date(19872000);
        Date result = stringToRFC822Date(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToTwitterDate method, of class DT.
     */
    public void testStringToTwitterDate () {
        out.println("stringToTwitterDate");
        String date = "Thu Jan 01 00:31:12 -0500 1970";
        Date expResult = new Date(19872000);
        Date result = stringToTwitterDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysBetweenDates method, of class DT.
     */
    public void testDaysBetweenDates_String_String () {
        out.println("daysBetweenDates");
        String start = "1970-01-01";
        String end = "1970-01-02";
        long expResult = 1L;
        long result = daysBetweenDates(start, end);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysBetweenDates method, of class DT.
     */
    public void testDaysBetweenDates_Date_Date () {
        out.println("daysBetweenDates");
        Date start = new Date(19872000);
        Date end = new Date(19872000);
        long expResult = 0L;
        long result = daysBetweenDates(start, end);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDate method, of class DT.
     */
    public void testAddDate_String_int () {
        out.println("addDate");
        String date = "1970-01-01";
        int addBy = 1;
        String expResult = "1970-01-02";
        String result = addDate(date, addBy);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDate method, of class DT.
     */
    public void testAddDate_Date_int () {
        out.println("addDate");
        Date date = new Date(19872000);
        int addBy = 0;
        Date expResult = new Date(19872000);
        Date result = addDate(date, addBy);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDates method, of class DT.
     */
    public void testSetDates_3args () {
        out.println("setDates");
        Date startDate = new Date(18000000);
        Date endDate = new Date(18000000 + (86400 * 7));
        DT.DateRange timeInterval = DAY7;
        //Date[] expResult = new Date[]{startDate,new Date(startDate.getTime() + 86400),new Date(startDate.getTime() + (86400 * 2)),new Date(startDate.getTime() + (86400 * 3)),new Date(startDate.getTime() + (86400 * 4)),new Date(startDate.getTime() + (86400 * 5)),endDate};
        //Date[] result = DT.setDates(startDate, endDate, timeInterval);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setDates method, of class DT.
     */
    public void testSetDates_Date_int () {
        out.println("setDates");
        Date startDate = new Date(18000000);
        int days = 0;
        String[] expResult = new String[]{"1970-01-01"};
        //String[] result = DT.setDates(startDate, days);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setStringDates method, of class DT.
     */
    public void testSetStringDates_Date_Date () {
        out.println("setStringDates");
        Date startDate = null;
        Date endDate = null;
        String[] expResult = null;
        //String[] result = DT.setStringDates(startDate, endDate);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setStringDates method, of class DT.
     */
    public void testSetStringDates_String_String () {
        out.println("setStringDates");
        String startDate = "";
        String endDate = "";
        String[] expResult = null;
        //String[] result = DT.setStringDates(startDate, endDate);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setStringDates method, of class DT.
     */
    public void testSetStringDates_3args_1 () {
        out.println("setStringDates");
        Date startDate = null;
        Date endDate = null;
        DT.DateRange timeInterval = null;
        String[] expResult = null;
        //String[] result = DT.setStringDates(startDate, endDate, timeInterval);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setStringDates method, of class DT.
     */
    public void testSetStringDates_3args_2 () {
        out.println("setStringDates");
        String startDate = "";
        String endDate = "";
        DT.DateRange timeInterval = null;
        String[] expResult = null;
        //String[] result = DT.setStringDates(startDate, endDate, timeInterval);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getTimestampRangeArray method, of class DT.
     */
    public void testGetTimestampRangeArray_long_long () {
        out.println("getTimestampRangeArray");
        long start = 0L;
        long end = 0L;
        Set<Long> expResult = null;
        //Set<Long> result = DT.getTimestampRangeArray(start, end);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getTimestampRangeArray method, of class DT.
     */
    public void testGetTimestampRangeArray_Date_int () {
        out.println("getTimestampRangeArray");
        Date start = null;
        int days = 0;
        Set<Long> expResult = null;
        //Set<Long> result = DT.getTimestampRangeArray(start, days);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getTimestampRangeArray method, of class DT.
     */
    public void testGetTimestampRangeArray_String_int () throws Exception {
        out.println("getTimestampRangeArray");
        String start = "";
        int days = 0;
        Set<Long> expResult = null;
        //Set<Long> result = DT.getTimestampRangeArray(start, days);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getDateRangeArray method, of class DT.
     */
    public void testGetDateRangeArray_Date_int () throws Exception {
        out.println("getDateRangeArray");
        Date start = null;
        int days = 0;
        Set<Date> expResult = null;
        //Set<Date> result = DT.getDateRangeArray(start, days);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getDateRangeArray method, of class DT.
     */
    public void testGetDateRangeArray_String_int () throws Exception {
        out.println("getDateRangeArray");
        String start = "";
        int days = 0;
        Set<Date> expResult = null;
        //Set<Date> result = DT.getDateRangeArray(start, days);
        //assertEquals(expResult, result);
    }

    /**
     * Test of getNow method, of class DT.
     */
    public void testGetNow () {
        out.println("getNow");
        Long expResult = null;
        //Long result = DT.getNow();
        //assertEquals(expResult, result);
    }
    
}
