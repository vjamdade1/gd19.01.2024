package com.traval.qa.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateandStringConverters extends SearchHotels

   {
	public String outputStartDateString;
	public String outputEndDateString;
	
	public DateandStringConverters()
	{
		String inputDateRangeStr = HomePageDate;
	      String inputDateRangeString = removeOrdinalSuffix(inputDateRangeStr);
	        
	        // Define the input and output date formats
	        SimpleDateFormat inputDateFormat = new SimpleDateFormat("E, MMM dd");
	        SimpleDateFormat outputDateFormat = new SimpleDateFormat("MM/dd/yyyy");
	        
	        // Get the current year
	        Calendar calendar = Calendar.getInstance();
	        int currentYear = calendar.get(Calendar.YEAR);
	        
	        try {
	            // Split the input date range string into start and end date parts
	            String[] dateParts = inputDateRangeString.split(" - ");
	            String startDateString = dateParts[0];
	            String endDateString = dateParts[1];
	            
	            // Parse the start date string to a Date object
	            Date startDate = inputDateFormat.parse(startDateString);
	            
	            // Set the current year for both start and end dates
	            calendar.setTime(startDate);
	            calendar.set(Calendar.YEAR, currentYear);
	            startDate = calendar.getTime();
	            
	            // Parse the end date string to a Date object
	            Date endDate = inputDateFormat.parse(endDateString);
	            
	            // Set the current year for the end date
	            calendar.setTime(endDate);
	            calendar.set(Calendar.YEAR, currentYear);
	            endDate = calendar.getTime();
	            
	            // Format the start and end dates to the desired output format
	            String outputStartDateString = outputDateFormat.format(startDate);
	            String outputEndDateString = outputDateFormat.format(endDate);
	            
	            System.out.println(outputStartDateString);
	            System.out.println(outputEndDateString);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	        
	    }
	    
	    private static String removeOrdinalSuffix(String input) {
	        // Replace ordinal suffixes with an empty string
	        return input.replaceAll("(?<=\\d)(st|nd|rd|th)", "");
	    }

		
			
}


 