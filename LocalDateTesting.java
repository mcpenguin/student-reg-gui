package Classes;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class LocalDateTesting {
	
	static Scanner kbd = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		LocalDate today = LocalDate.of(2018, 1, 1);
		System.out.println(today);
		
		DateTimeFormatter f = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String todayF = today.format(f);
		System.out.println(todayF);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        String date = "16/08/2016";

        LocalDate localDate = LocalDate.parse(date, formatter);

        System.out.println(localDate);

        System.out.println(Utility.malaysianFormatter.format(localDate));
		
		System.out.print("Enter a date: (dd/MM/yyyy): ");
		String date1 = kbd.nextLine();
		LocalDate parsedDate = LocalDate.parse(date1, f);
		System.out.println(formatter.format(parsedDate));
		
		System.out.print("Enter another date w/ same format: ");
		String date2 = kbd.nextLine();
		LocalDate parsedDate2 = LocalDate.parse(date2, f);
		long daysBetween = ChronoUnit.DAYS.between(parsedDate, parsedDate2);
		System.out.println(daysBetween);
		
		
		
		
		
		

	}

}
