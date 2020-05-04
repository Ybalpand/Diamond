package com.mycompany.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormate {
	
	public static Date getCurrentDate(){
		  DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
	       Date dateobj = new Date();
	       System.out.println(df.format(dateobj));
		return  dateobj; 
	}
}
