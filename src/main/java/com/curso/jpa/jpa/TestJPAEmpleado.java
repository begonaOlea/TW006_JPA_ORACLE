package com.curso.jpa.jpa;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class TestJPAEmpleado {

	
	public static void main(String[] args) {
		
		
		//java util Date
		//2021 -1900   // 0 - 11 //
		Date fecha = new Date(121,10,1); // fecha contratacion
		
		//Calendar
		
		Calendar cal = Calendar.getInstance();
		
		cal.set(2021,Calendar.NOVEMBER, 1);
		
		Date fecha2= cal.getTime();
		
		//LocalDate, LocalTime, LocalDateTime //JAva 8
		
		
		
		
		
		
		
		
		
		
		
	}
}
