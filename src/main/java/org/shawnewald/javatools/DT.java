package org.shawnewald.javatools;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Various date manipulation and formatting methods.
 *
 * @author Shawn Ewald <shawn.ewald@gmail.com>
 * Copyright (C) 2009,2010,2011,2012 Shawn Ewald
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
public final class DT {
    public static enum DateFormats {
        UNFORMATTED, DATE, DATETIME, TEXTDATE, RFC822, ISO, ISOALT, TWITTER
    };
    public static enum DateRange {
        DAY7, DAY14, DAY28, DAY30, DAY60, DAY90
    };
    private static final List<String> STRING_FORMATS = new ArrayList<String>() {
        {
            add("yyyyMMdd");                     // Unformatted (big endian) date. Ex: 19690819
            add("yyyyMMddHHmm");                 // Unformated (big endian) date and time, minus seconds. Ex: 196908190100
            add("yyyyMMddHHmmss");               // Unformatted (big endian) date and time. Ex: 19690819010000
            add("yyyyMMdd HHmm");                // Unformated (big endian) date and time, minus seconds, time separated by space. Ex: 19690819 0100
            add("yyyyMMdd HHmmss");              // Unformated (big endian) date and time, time separated by space, with seconds. Ex: 19690819 010000
            add("dd.MM.yyyy");                   // Global Standard (little endian) date format, with dots. Ex: 19.08.1969
            add("yyyy");                         // 4 digit year. Ex: 1969
            add("dd/MM/yyyy");                   // Global Standard (little endian) date format, with slashes. Ex: 19/08/1969
            add("dd-MM-yyyy");                   // Global Standard (little endian) date format, with dashes. Ex: 19-08-1969
            add("yyyy/MM/dd");                   // Formatted China/Japan/Database (big endian) date with slashes. Ex: 1969/08/19
            add("yyyy-MM-dd");                   // Formatted China/Japan/Database (big endian) date with dashes. Ex: 1969-08-19
            add("dd MMM yyyy");                  // Formatted middle endian with text month. Ex: 19 Aug 1969
            add("dd MMMM yyyy");                 // Formatted middle endian with text month. Ex: 19 August 1969
            add("dd-MM-yyyy HH:mm");             // Little endian date and time. Ex: 19-08-1969 01:00
            add("yyyy-MM-dd HH:mm");             // Big endian date and time with dashes. Ex: 1969-08-19 01:00
            add("yyyy/MM/dd HH:mm");             // Big endian date and time with slashes. Ex: 1969/08/19 01:00
            add("MM/dd/yyyy HH:mm");             // Middle endian date and time with slashes. Ex: 19/08/1969 01:00
            add("dd MMM yyyy HH:mm");            // Little endian date and time with text month. Ex: 19 Aug 1969 01:00
            add("dd MMMM yyyy HH:mm");           // Little endian date and time with text month. Ex: 19 August 1969 01:00
            add("dd-MM-yyyy HH:mm:ss");          // Little endian date and time with seconds. Ex: 19-08-1969 01:00:00
            add("yyyy-MM-dd HH:mm:ss");          // Big endian date and time with seconds. Ex: 1969-08-19 01:00:00
            add("yyyy/MM/dd HH:mm:ss");          // Big endian date and time with seconds, with slashes. Ex: 1969/08/19 01:00:00
            add("MM/dd/yyyy HH:mm:ss");          // Middle endian date and time with seconds, with slashes. Ex: 08/19/1969 01:00:00
            add("dd MMM yyyy HH:mm:ss");         // Little endian date and time with text month and seconds. Ex: 19 Aug 1969 01:00:00
            add("dd MMMM yyyy HH:mm:ss");        // Little endian date and time with text month and seconds. Ex: 19 August 1969 01:00:00
            add("MMMM d, yyyy");                 // Middle endian date with text month. Ex: August 19, 1969
            add("EEE, dd MMM yyyy HH:mm:ss Z");  // RFC 822 date and time. Ex: Wed, 04 Mar 2015 07:46:00 -0500
            add("yyyy-MM-dd'T'HH:mm:ss'Z'");     // ISO date and time. Ex: 2015-03-04T07:46:00Z
            add("yyyy-MM-dd'T'HH:mm:ss");        // ISO alternate format date and time. Ex: 2015-03-04T07:46:00
            add("EEE MMM dd HH:mm:ss ZZZ yyyy"); // Twitter API date format. Ex: Wed Mar 04 07:46:00 EST 2015
        }
    };
    private static final Map<String, SimpleDateFormat> DATE_FORMATTERS = new HashMap<String, SimpleDateFormat>() {
        {
            put(STRING_FORMATS.get(0), new SimpleDateFormat(STRING_FORMATS.get(0)));
            put(STRING_FORMATS.get(1), new SimpleDateFormat(STRING_FORMATS.get(1)));
            put(STRING_FORMATS.get(2), new SimpleDateFormat(STRING_FORMATS.get(2)));
            put(STRING_FORMATS.get(3), new SimpleDateFormat(STRING_FORMATS.get(3)));
            put(STRING_FORMATS.get(4), new SimpleDateFormat(STRING_FORMATS.get(4)));
            put(STRING_FORMATS.get(5), new SimpleDateFormat(STRING_FORMATS.get(5)));
            put(STRING_FORMATS.get(6), new SimpleDateFormat(STRING_FORMATS.get(6)));
            put(STRING_FORMATS.get(7), new SimpleDateFormat(STRING_FORMATS.get(7)));
            put(STRING_FORMATS.get(8), new SimpleDateFormat(STRING_FORMATS.get(8)));
            put(STRING_FORMATS.get(9), new SimpleDateFormat(STRING_FORMATS.get(9)));
            put(STRING_FORMATS.get(10), new SimpleDateFormat(STRING_FORMATS.get(10)));
            put(STRING_FORMATS.get(11), new SimpleDateFormat(STRING_FORMATS.get(11)));
            put(STRING_FORMATS.get(12), new SimpleDateFormat(STRING_FORMATS.get(12)));
            put(STRING_FORMATS.get(13), new SimpleDateFormat(STRING_FORMATS.get(13)));
            put(STRING_FORMATS.get(14), new SimpleDateFormat(STRING_FORMATS.get(14)));
            put(STRING_FORMATS.get(15), new SimpleDateFormat(STRING_FORMATS.get(15)));
            put(STRING_FORMATS.get(16), new SimpleDateFormat(STRING_FORMATS.get(16)));
            put(STRING_FORMATS.get(17), new SimpleDateFormat(STRING_FORMATS.get(17)));
            put(STRING_FORMATS.get(18), new SimpleDateFormat(STRING_FORMATS.get(18)));
            put(STRING_FORMATS.get(19), new SimpleDateFormat(STRING_FORMATS.get(19)));
            put(STRING_FORMATS.get(20), new SimpleDateFormat(STRING_FORMATS.get(20)));
            put(STRING_FORMATS.get(21), new SimpleDateFormat(STRING_FORMATS.get(21)));
            put(STRING_FORMATS.get(22), new SimpleDateFormat(STRING_FORMATS.get(22)));
            put(STRING_FORMATS.get(23), new SimpleDateFormat(STRING_FORMATS.get(23)));
            put(STRING_FORMATS.get(24), new SimpleDateFormat(STRING_FORMATS.get(24)));
            put(STRING_FORMATS.get(25), new SimpleDateFormat(STRING_FORMATS.get(25), Locale.getDefault()));
            put(STRING_FORMATS.get(26), new SimpleDateFormat(STRING_FORMATS.get(26), Locale.getDefault()));
            put(STRING_FORMATS.get(27), new SimpleDateFormat(STRING_FORMATS.get(27), Locale.getDefault()));
            put(STRING_FORMATS.get(28), new SimpleDateFormat(STRING_FORMATS.get(28), Locale.getDefault()));
            put(STRING_FORMATS.get(29), new SimpleDateFormat(STRING_FORMATS.get(29), Locale.getDefault()));      
        }
    };
    private static final Map<String, String> DATE_FORMAT_REGEXPS = new HashMap<String, String>() {
        {
            put("^\\d{8}$", STRING_FORMATS.get(0));
            put("^\\d{12}$", STRING_FORMATS.get(1));
            put("^\\d{14}$", STRING_FORMATS.get(2));
            put("^\\d{8}\\s\\d{4}$", STRING_FORMATS.get(3));
            put("^\\d{8}\\s\\d{6}$", STRING_FORMATS.get(4));
            put("^\\d{1,2}.\\d{1,2}.\\d{4}$", STRING_FORMATS.get(5));
            put("^\\d{4}$", STRING_FORMATS.get(6));
            put("^\\d{1,2}/\\d{1,2}/\\d{4}$", STRING_FORMATS.get(7));
            put("^\\d{1,2}-\\d{1,2}-\\d{4}$", STRING_FORMATS.get(8));
            put("^\\d{4}/\\d{1,2}/\\d{1,2}$", STRING_FORMATS.get(9));
            put("^\\d{4}-\\d{1,2}-\\d{1,2}$", STRING_FORMATS.get(10));
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}$", STRING_FORMATS.get(11));
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}$", STRING_FORMATS.get(12));
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(13));
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(14));
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(15));
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(16));
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(17));
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}$", STRING_FORMATS.get(18));
            put("^\\d{1,2}-\\d{1,2}-\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(19));
            put("^\\d{4}-\\d{1,2}-\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(20));
            put("^\\d{4}/\\d{1,2}/\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(21));
            put("^\\d{1,2}/\\d{1,2}/\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(22));
            put("^\\d{1,2}\\s[a-z]{3}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(23));
            put("^\\d{1,2}\\s[a-z]{4,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}$", STRING_FORMATS.get(24));
            put("^[a-z]{3,}\\s\\d{1,2}\\,\\s\\d{4}$", STRING_FORMATS.get(25));
            put("^[a-z]{3,}\\,\\s\\d{2}\\s[a-z]{3,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}\\s-\\d{4}", STRING_FORMATS.get(26));
            put("^[a-z]{3,}\\,\\s\\d{2}\\s[a-z]{3,}\\s\\d{4}\\s\\d{1,2}:\\d{2}:\\d{2}\\s[a-z]{3,}", STRING_FORMATS.get(26));
            put("^\\d{4}-\\d{1,2}-\\d{1,2}T\\d{2}:\\d{2}:\\d{2}Z", STRING_FORMATS.get(27));
            put("^\\d{4}-\\d{1,2}-\\d{1,2}T\\d{2}:\\d{2}:\\d{2}", STRING_FORMATS.get(28));
            put("^[a-z]{3}\\s[a-z]{3}\\s\\d{1,2}\\s\\d{1,2}:\\d{2}:\\d{2}\\s[a-z]{3,}\\s\\d{4}", STRING_FORMATS.get(29));
            put("^[a-z]{3,}\\s[a-z]{3,}\\s\\d{2}\\s\\d{1,2}:\\d{2}:\\d{2}\\s[\\-\\+]{0,1}[0-9]{4}\\s\\d{4}", STRING_FORMATS.get(29));
        }
    };
    private static final SimpleDateFormat ufd = new SimpleDateFormat("yyyyMMdd");
    private static final SimpleDateFormat fdt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static final SimpleDateFormat fd = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat txtDate = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
    private static final SimpleDateFormat rfc822 = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH);
    private static final SimpleDateFormat iso = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.ENGLISH);
    private static final SimpleDateFormat isoAlt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
    private static final SimpleDateFormat twd = new SimpleDateFormat("EEE MMM dd HH:mm:ss ZZZZZ yyyy", Locale.ENGLISH);

    private DT() {
    }

        /**
     * Format <code>Date</code> to <code>yyyyMMdd</code> date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatUnformattedDate(final Date date) {
        return ufd.format(date);
    }
    
    /**
     * Format <code>Date</code> to <code>yyyy-MM-dd HH:mm:ss</code> format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatDateTime(final Date date) {
        return fdt.format(date);
    }

    /**
     * Format <code>Date</code> to <code>yyyy-MM-dd</code> date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatDate(final Date date) {
        return fd.format(date);
    }
    
    /**
     * Format <code>Date</code> to <code>MMMM d, yyyy</code> format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatTextDate(final Date date) {
        return txtDate.format(date);
    }

    /**
     * Format <code>Date</code> to RFC-822
     * (<code>EEE, dd MMM yyyy HH:mm:ss Z</code>) date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatRFC822Date(final Date date) {
        return rfc822.format(date);
    }

    /**
     * Format <code>Date</code> to ISO (<code>yyyy-MM-dd'T'HH:mm:ssz</code>)
     * date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatISODate(final Date date) {
        return iso.format(date);
    }

    /**
     * Format <code>Date</code> to ISO (<code>yyyy-MM-dd'T'HH:mm:ssz</code>)
     * date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatISOAltDate(final Date date) {
        return isoAlt.format(date);
    }

    /**
     * Format <code>Date</code> to Twitter API
     * (<code>yyyy-MM-dd'T'HH:mm:ssz</code>) date format.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static String formatTwitterDate(final Date date) {
        return twd.format(date);
    }

    public static String formatMiddleEndianDate (final Date date) {
        return med.format(date);
    }
    
     /**
     * Convert <code>String</code> (<code>yyyyMMdd</code>) representation of a date to a
     * <code>Date</code>.
     *
     * @param date <code>String</code>
     * @return <code>Date</code>
     */
    public static Date stringToUnformattedDate(final String date) {
        Date dateObj = null;
        try {
            dateObj = ufd.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }
    
    /**
     * Convert <code>String</code> (<code>yyyy-MM-dd</code>) representation of a date to a
     * <code>Date</code>.
     *
     * @param date <code>String</code>
     * @return <code>Date</code>
     */
    public static Date stringToDate(final String date) {
        Date dateObj = null;
        try {
            dateObj = fd.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }

    /**
     * Convert <code>String</code> (<code>yyyy-MM-dd HH:mm:ss</code>) representation of a date to a
     * <code>Date</code>.
     *
     * @param date <code>String</code>
     * @return <code>Date</code>
     */
    public static Date stringToDateTime(final String date) {
        Date dateObj = null;
        try {
            dateObj = fdt.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }
    
    /**
     * Convert <code>String</code> representation of an ISO date
     * (<code>yyyy-MM-dd'T'HH:mm:ss'Z'</code>) to a
     * <code>String</code> textual date representation (<code>MMMM d, yyyy</code>).
     *
     * @param date <code>String</code>
     * @return <code>String</code>
     */
    public static String isoDateToTextDate(final String date) {
        String textDate = null;
        try {
            final Date dateObj = iso.parse(date);
            textDate = formatTextDate(dateObj);
        }
        catch (final Exception ignore) {}
        return textDate;
    }

    /**
     * Convert <code>String</code> representation of a RFC-822
     * (<code>EEE, dd MMM yyyy HH:mm:ss Z</code>) date to a <code>Date</code>.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static Date stringToRFC822Date(final String date) {
        Date dateObj = null;
        try {
            dateObj = rfc822.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }
    
    /**
     * Convert <code>String</code> (<code>yyyy-MM-dd'T'HH:mm:ss'Z'</code>) representation of a date to a
     * <code>Date</code>.
     *
     * @param date <code>String</code>
     * @return <code>Date</code>
     */
    public static Date stringToDateISO(final String date) {
        Date dateObj = null;
        try {
            dateObj = iso.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }

    /**
     * Convert <code>String</code> (<code>yyyy-MM-dd'T'HH:mm:ss</code>) representation of a date to a
     * <code>Date</code>.
     *
     * @param date <code>String</code>
     * @return <code>Date</code>
     */
    public static Date stringToDateISOAlt(final String date) {
        Date dateObj = null;
        try {
            dateObj = isoAlt.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }

    /**
     * Convert <code>String</code> representation of a Twitter API
     * (<code>yyyy-MM-dd'T'HH:mm:ssz</code>) date to a <code>Date</code>.
     *
     * @param date <code>Date</code>
     * @return <code>String</code>
     */
    public static Date stringToTwitterDate(final String date) {
        Date dateObj = null;
        try {
            dateObj = twd.parse(date);
        }
        catch (final Exception ignore) {}
        return dateObj;
    }

    /**
     * Converts a date object to the string representation of a date, formatted
     * to the specified string format.
     * @param date <code>Date</doce>
     * @param format <code>DateFormat</code>
     * @return <code>String</code>
     */
    public static String dateToFormat (final Date date, final DT.DateFormats format) {
        if (format == DateFormats.DATE) { return fd.format(date); }
        else if (format == DateFormats.DATETIME) { return fdt.format(date); }
        else if (format == DateFormats.UNFORMATTED) { return ufd.format(date); }
        else if (format == DateFormats.TEXTDATE) { return txtDate.format(date); }
        else if (format == DateFormats.RFC822) { return rfc822.format(date); }
        else if (format == DateFormats.ISO) { return iso.format(date); }
        else if (format == DateFormats.ISOALT) { return isoAlt.format(date); }
        else if (format == DateFormats.TWITTER) { return twd.format(date); }
        else { return ""; }
    }
    
    /**
     * Calculate the number of days between two dates represented as
     * <code>String</code>s.
     *
     * @param start <code>String</code>
     * @param end <code>String</code>
     * @return <code>long</code>
     */
    public static long daysBetweenDates(final String start, final String end) {
        Date s = null;
        Date e = null;
        try {
            s = fd.parse(start);
            e = fd.parse(end);
        }
        catch (final Exception ignore) {}
        return daysBetweenDates(s, e);
    }

    /**
     * Calculate the number of days between two <code>Date</code>s.
     *
     * @param start <code>Date</code>
     * @param end <code>Date</code>
     * @return <code>long</code>
     */
    public static long daysBetweenDates(final Date start, final Date end) {
        long days = 0;
        if (start != null && end != null) {
            // Creates two calendars instances
            final Calendar cal1 = Calendar.getInstance();
            final Calendar cal2 = Calendar.getInstance();

            // Set the date for both of the calendar instance
            cal1.setTime(start);
            cal2.setTime(end);

            // Calculate difference in milliseconds
            final long diff = cal2.getTimeInMillis() - cal1.getTimeInMillis();

            // Calculate difference in days
            days = diff / (24 * 60 * 60 * 1000);
        }
        return days;
    }

    /**
     * Add the given date represented as a <code>String</code> by the given
     * number of days. Return date represented as a <code>String</code>.
     *
     * @param date <code>String</code>
     * @param addBy <code>int</code>
     * @return <code>String</code>
     */
    public static String addDate(final String date, final int addBy) {
        final Date d = stringToDate(date);
        final Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, addBy);
        return fd.format(cal.getTime());
    }

    /**
     * Add the given <code>Date</code> by the given number of days.
     *
     * @param date <code>Date</code>
     * @param addBy <code>int</code>
     * @return <code>Date</code>
     */
    public static Date addDate(final Date date, final int addBy) {
        final Date d = date;
        final Calendar cal = Calendar.getInstance();
        cal.setTime(d);
        cal.add(Calendar.DATE, addBy);
        return cal.getTime();
    }

    /**
     * Calculate a date range from <code>startDate</code> back to
     * <code>endDate</code> or <code>DT.DateRange</code> days past. If
     * <code>startDate</code> is null or greater than <code>endDate</code>,
     * <code>startDate</code> defaults to the present date. If
     * <code>timeInterval</code> is <code>null</code> and <code>endDate</code>
     * is null, <code>endDate</code> defaults to 28 days in the past from
     * <code>startDate</code> if <code>timeInterval</code> is not
     * <code>null</code>, <code>endDate</code> is ignored.
     *
     * @param startDate <code>Date</code>
     * @param endDate <code>Date</code>
     * @param timeInterval <code>String</code>
     * @return <code>Date[]</code>
     */
    public static Date[] setDates(final Date startDate, final Date endDate,
            final DT.DateRange timeInterval) {
        final Date[] dates = new Date[]{((startDate == null)
            ? new Date() : startDate), endDate};
        final Calendar theDate = Calendar.getInstance();
        if (timeInterval == null) {
            if (endDate == null
                    || dates[0].getTime() >= endDate.getTime()) {
                theDate.setTime(dates[0]);
                theDate.add(Calendar.DATE, -28);
                dates[1] = theDate.getTime();
            }
        }
        else {
            theDate.setTime(new Date());
            dates[1] = theDate.getTime();
            if (timeInterval == DT.DateRange.DAY7) {
                theDate.add(Calendar.DATE, -7);
                dates[0] = theDate.getTime();
            }
            else if (timeInterval == DT.DateRange.DAY14) {
                theDate.add(Calendar.DATE, -14);
                dates[0] = theDate.getTime();
            }
            else if (timeInterval == DT.DateRange.DAY28) {
                theDate.add(Calendar.DATE, -28);
                dates[0] = theDate.getTime();
            }
            else if (timeInterval == DT.DateRange.DAY30) {
                theDate.add(Calendar.DATE, -30);
                dates[0] = theDate.getTime();
            }
            else if (timeInterval == DT.DateRange.DAY60) {
                theDate.add(Calendar.DATE, -60);
                dates[0] = theDate.getTime();
            }
            else if (timeInterval == DT.DateRange.DAY90) {
                theDate.add(Calendar.DATE, -90);
                dates[0] = theDate.getTime();
            }
            else {
                theDate.add(Calendar.DATE, -28);
                dates[0] = theDate.getTime();
            }
        }
        return dates;
    }
    /**
     * Calculate a date range from <code>startDate</code> back to
     * <code>days</code> past.
     * @param startDate
     * @param days
     * @return 
     */
    public static String[] setDates(final Date startDate, final int days) {
        final String[] dates = new String[2];
        if (startDate != null && days > 0) {
            final Calendar theDate = Calendar.getInstance();
            theDate.add(Calendar.DATE, -days);
            dates[0] = formatDate(theDate.getTime());
            dates[1] = formatDate(startDate);
        }
        return dates;
    }

    /**
     * Calculate a date range from <code>startDate</code> back to <code>endDate</code>.
     *
     * @param startDate
     * @param endDate
     * @return <code>String[]</code>
     */
    public static String[] setStringDates(final Date startDate, final Date endDate) {
        final Date[] dates = setDates(startDate, endDate, null);
        return new String[]{formatDate(dates[0]), formatDate(dates[1])};
    }

    /**
     * Calculate a date range from <code>startDate</code> back to <code>endDate</code>.
     *
     * @param startDate
     * @param endDate
     * @return <code>String[]</code>
     */
    public static String[] setStringDates(final String startDate, final String endDate) {
        final Date[] dates = setDates(stringToDate(startDate),
                stringToDate(endDate), null);
        return new String[]{formatDate(dates[0]), formatDate(dates[1])};
    }

    /**
     * Calculate a date range from <code>startDate</code> back to <code>timeInterval</code>.
     *
     * @param startDate
     * @param endDate
     * @param timeInterval
     * @return <code></code>
     */
    public static String[] setStringDates(final Date startDate, final Date endDate,
            final DT.DateRange timeInterval) {
        final Date[] dates = setDates(startDate, endDate, timeInterval);
        return new String[]{formatDate(dates[0]), formatDate(dates[1])};
    }

    /**
     * Calculate a date range from <code>startDate</code> back to <code>timeInterval</code>.
     *
     * @param startDate
     * @param endDate
     * @param timeInterval
     * @return
     */
    public static String[] setStringDates(final String startDate, final String endDate,
            final DT.DateRange timeInterval) {
        final Date[] dates = setDates(stringToDate(startDate),
                stringToDate(endDate), timeInterval);
        return new String[]{formatDate(dates[0]), formatDate(dates[1])};
    }

    /**
     * Get a <code>Set</code> of timestamps.
     *
     * @param start <code>long</code>
     * @param end <code>long</code>
     * @return <code>Set</code>
     */
    public static Set<Long> getTimestampRange(final long start, final long end) {
        final Set<Long> dates = new HashSet<Long>();
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(start);
        long current = start;
        while (true) {
            if (current >= end) {
                break;
            }
            else {
                //dates.add((current / 1000));
                dates.add(current);
                cal.add(Calendar.DATE, 1);
                current = cal.getTimeInMillis();
            }
        }
        dates.add(end);
        return dates;
    }

    /**
     * Get a <code>Set</code> of timestamps.
     *
     * @param start <code>Date</code>
     * @param days <code>int</code>
     * @return <code>Set</code>
     */
    public static Set<Long> getTimestampRange(final Date start, final int days) {
        final Set<Long> dates = new HashSet<Long>();
        long current = start.getTime();
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current);
        for (int i = 0; i < days; i++) {
            //dates.add((current / 1000));
            dates.add(current);
            cal.add(Calendar.DATE, 1);
            current = cal.getTimeInMillis();
        }
        dates.add(current);
        cal.add(Calendar.DATE, 1);
        current = cal.getTimeInMillis();
        dates.add(current);
        return dates;
    }

    /**
     * Get a <code>Set</code> of timestamps.
     *
     * @param start <code>String</code>
     * @param days <code>int</code>
     * @return <code>Set</code>
     * @throws ParseException
     */
    public static Set<Long> getTimestampRange(final String start, final int days)
            throws ParseException {
        final Set<Long> dates = new HashSet<Long>();
        long current = fd.parse(start).getTime();
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current);
        for (int i = 0; i < days; i++) {
            dates.add(current);
            cal.add(Calendar.DATE, 1);
            current = cal.getTimeInMillis();
        }
        dates.add(current);
        cal.add(Calendar.DATE, 1);
        current = cal.getTimeInMillis();
        dates.add(current);
        return dates;
    }

    /**
     * Get a <code>Set</code> of <code>Date</code>s.
     *
     * @param start <code>Date</code>
     * @param days <code>int</code>
     * @return <code>Set</code>
     * @throws ParseException
     */
    public static Set<Date> getDateRange(final Date start, final int days)
            throws ParseException {
        final Set<Date> dates = new HashSet<Date>();
        Date current = start;
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current.getTime());
        for (int i = 0; i < days; i++) {
            dates.add(current);
            cal.add(Calendar.DATE, 1);
            current = cal.getTime();
        }
        dates.add(current);
        cal.add(Calendar.DATE, 1);
        current = cal.getTime();
        dates.add(current);
        return dates;
    }

    /**
     * Get a <code>Set</code> of <code>Date</code>s.
     *
     * @param start <code>String</code>
     * @param days <code>int</code>
     * @return <code>Set</code>
     * @throws ParseException
     */
    public static Set<Date> getDateRange(final String start, final int days)
            throws ParseException {
        final Set<Date> dates = new HashSet<Date>();
        Date current = fd.parse(start);
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(current.getTime());
        for (int i = 0; i < days; i++) {
            dates.add(current);
            cal.add(Calendar.DATE, 1);
            current = cal.getTime();
        }
        dates.add(current);
        cal.add(Calendar.DATE, 1);
        current = cal.getTime();
        dates.add(current);
        return dates;
    }

    /**
     * Get current timestamp.
     *
     * @return <code>Long</code>
     */
    public static Long getNow() {
        return new Date().getTime();
    }
}
