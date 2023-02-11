package com.bs23.automation.task.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	
	public ReadConfig(){
		File src = new File("./configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
		}catch (Exception e){
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url  = pro.getProperty("baseURL");
		return url;
	}
	
	public String getPassword() {
		String pass = pro.getProperty("password");
		return pass;
	}
	
	public String getEmail() {
		String email =  pro.getProperty("email");
		return email;
	}
	
	public String getFrom() {
		String from =  pro.getProperty("From");
		return from;
	}
	
	public String getTo() {
		String to =  pro.getProperty("To");
		return to;
	}
	
	public String getTitle() {
		String title = pro.getProperty("title");
		return title;	
	}
	
	public String getDepartureDate() {
		String DepartureDate = pro.getProperty("DepartureDate");
		return DepartureDate;
	}
	
	public String getDepartureTime() {
		String DepartureTime = pro.getProperty("DepartureTime");
		return DepartureTime;
	}
	
	public String getReturnDate() {
		String ReturnDate = pro.getProperty("ReturnDate");
		return ReturnDate;
	}
	
	public String getReturnTime() {
		String ReturnTime = pro.getProperty("ReturnTime");
		return ReturnTime;
	}
	
	public String getTripName() {
		String tripName = pro.getProperty("TripName");
		return tripName;
	}

}
