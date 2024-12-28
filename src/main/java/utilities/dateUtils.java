package utilities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;

import testCases.BaseClass;

public class dateUtils extends testCases.BaseClass {

	Properties prop;
	public static class DateUtils {
	    public static String getDateAfter30Days() {
	        LocalDate currentDate = LocalDate.now();
	       	        
	        LocalDate futureDate = currentDate.plusDays(30);
	        
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yy EEE", Locale.ENGLISH);
	        return futureDate.format(formatter);
	    }
	}
}
