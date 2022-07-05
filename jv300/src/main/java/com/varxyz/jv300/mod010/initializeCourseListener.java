package com.varxyz.jv300.mod010;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class initializeCourseListener implements ServletContextListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event)  { 
		System.out.println("contextInitialized() method called");
		try {
			
			System.out.println("The course contents has been load");
		}catch(Exception e) {
			e.printStackTrace(); //IO와 관련된 예외가 발생한다.
		}
	}
	
	@Override
    public void contextDestroyed(ServletContextEvent event)  { 
		 System.out.println("contextDestroyed() method called");
    }
	
	
}
