/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.shawnewald.javatools;

import java.util.Date;
import java.util.Set;
import junit.framework.TestCase;

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
        System.out.println("formatDateTime");
        Date date = new Date(19872000);
        String expResult = "1970-01-01 00:31:12";
        String result = DT.formatDateTime(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatTextDate method, of class DT.
     */
    public void testFormatTextDate () {
        System.out.println("formatTextDate");
        Date date = new Date(19872000);
        String expResult = "January 1, 1970";
        String result = DT.formatTextDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatRFC822Date method, of class DT.
     */
    public void testFormatRFC822Date () {
        System.out.println("formatRFC822Date");
        Date date = new Date(19872000);
        String expResult = "Thu, 01 Jan 1970 00:31:12 -0500";
        String result = DT.formatRFC822Date(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatISODate method, of class DT.
     */
    public void testFormatISODate () {
        System.out.println("formatISODate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01T00:31:12Z";
        String result = DT.formatISODate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatISOAltDate method, of class DT.
     */
    public void testFormatISOAltDate () {
        System.out.println("formatISOAltDate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01T00:31:12";
        String result = DT.formatISOAltDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatTwitterDate method, of class DT.
     */
    public void testFormatTwitterDate () {
        System.out.println("formatTwitterDate");
        Date date = new Date(19872000);
        String expResult = "Thu Jan 01 00:31:12 -0500 1970";
        String result = DT.formatTwitterDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of formatDate method, of class DT.
     */
    public void testFormatDate () {
        System.out.println("formatDate");
        Date date = new Date(19872000);
        String expResult = "1970-01-01";
        String result = DT.formatDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDate method, of class DT.
     */
    public void testStringToDate () {
        System.out.println("stringToDate");
        String date = "1970-01-01";
        Date expResult = new Date(18000000);
        Date result = DT.stringToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDateISO method, of class DT.
     */
    public void testStringToDateISO () {
        System.out.println("stringToDateISO");
        String date = "1970-01-01T00:31:12Z";
        Date expResult = new Date(19872000);
        Date result = DT.stringToDateISO(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToDateISOAlt method, of class DT.
     */
    public void testStringToDateISOAlt () {
        System.out.println("stringToDateISOAlt");
        String date = "1970-01-01T00:31:12";
        Date expResult = new Date(19872000);
        Date result = DT.stringToDateISOAlt(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isoDateToTextDate method, of class DT.
     */
    public void testIsoDateToTextDate () {
        System.out.println("isoDateToTextDate");
        String date = "1970-01-01T00:00:00Z";
        String expResult = "January 1, 1970";
        String result = DT.isoDateToTextDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isoAltDateToTextDate method, of class DT.
     */
    public void testIsoAltDateToTextDate () {
        System.out.println("isoAltDateToTextDate");
        String date = "1970-01-01T00:00:00";
        String expResult = "January 1, 1970";
        String result = DT.isoAltDateToTextDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isoDateToDate method, of class DT.
     */
    public void testIsoDateToDate () {
        System.out.println("isoDateToDate");
        String date = "1970-01-01T00:00:00Z";
        String expResult = "1970-01-01";
        String result = DT.isoDateToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of isoAltDateToDate method, of class DT.
     */
    public void testIsoAltDateToDate () {
        System.out.println("isoAltDateToDate");
        String date = "1970-01-01T00:00:00";
        String expResult = "1970-01-01";
        String result = DT.isoAltDateToDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToRFC822Date method, of class DT.
     */
    public void testStringToRFC822Date () {
        System.out.println("stringToRFC822Date");
        String date = "Thu, 01 Jan 1970 00:31:12 -0500";
        Date expResult = new Date(19872000);
        Date result = DT.stringToRFC822Date(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of stringToTwitterDate method, of class DT.
     */
    public void testStringToTwitterDate () {
        System.out.println("stringToTwitterDate");
        String date = "Thu Jan 01 00:31:12 -0500 1970";
        Date expResult = new Date(19872000);
        Date result = DT.stringToTwitterDate(date);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysBetweenDates method, of class DT.
     */
    public void testDaysBetweenDates_String_String () {
        System.out.println("daysBetweenDates");
        String start = "1970-01-01";
        String end = "1970-01-02";
        long expResult = 1L;
        long result = DT.daysBetweenDates(start, end);
        assertEquals(expResult, result);
    }

    /**
     * Test of daysBetweenDates method, of class DT.
     */
    public void testDaysBetweenDates_Date_Date () {
        System.out.println("daysBetweenDates");
        Date start = new Date(19872000);
        Date end = new Date(19872000);
        long expResult = 0L;
        long result = DT.daysBetweenDates(start, end);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDate method, of class DT.
     */
    public void testAddDate_String_int () {
        System.out.println("addDate");
        String date = "1970-01-01";
        int addBy = 1;
        String expResult = "1970-01-02";
        String result = DT.addDate(date, addBy);
        assertEquals(expResult, result);
    }

    /**
     * Test of addDate method, of class DT.
     */
    public void testAddDate_Date_int () {
        System.out.println("addDate");
        Date date = new Date(19872000);
        int addBy = 0;
        Date expResult = new Date(19872000);
        Date result = DT.addDate(date, addBy);
        assertEquals(expResult, result);
    }

    /**
     * Test of setDates method, of class DT.
     */
    public void testSetDates_3args () {
        System.out.println("setDates");
        Date startDate = new Date(18000000);
        Date endDate = new Date(18000000 + (86400 * 7));
        DT.DateRange timeInterval = DT.DateRange.DAY7;
        //Date[] expResult = new Date[]{startDate,new Date(startDate.getTime() + 86400),new Date(startDate.getTime() + (86400 * 2)),new Date(startDate.getTime() + (86400 * 3)),new Date(startDate.getTime() + (86400 * 4)),new Date(startDate.getTime() + (86400 * 5)),endDate};
        //Date[] result = DT.setDates(startDate, endDate, timeInterval);
        //assertEquals(expResult, result);
    }

    /**
     * Test of setDates method, of class DT.
     */
    public void testSetDates_Date_int () {
        System.out.println("setDates");
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
        System.out.println("setStringDates");
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
        System.out.println("setStringDates");
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
        System.out.println("setStringDates");
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
        System.out.println("setStringDates");
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
        System.out.println("getTimestampRangeArray");
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
        System.out.println("getTimestampRangeArray");
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
        System.out.println("getTimestampRangeArray");
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
        System.out.println("getDateRangeArray");
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
        System.out.println("getDateRangeArray");
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
        System.out.println("getNow");
        Long expResult = null;
        //Long result = DT.getNow();
        //assertEquals(expResult, result);
    }
    
}
