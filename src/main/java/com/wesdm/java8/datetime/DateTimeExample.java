package com.wesdm.java8.datetime;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.MonthDay;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class DateTimeExample {
	public static void main(String... args) {
		getTodaysDate();
		getDayMonthYear();
		getCertainDate();
		dateEquality();
		checkForEvent();
		getCurrentTime();
		addHours();
		dateAfter1Week();
		daysBetween();
		timeZones();
		parseDatePredefined();
		parseDateCustom();
		dateToString();
	}

	private static LocalDate getTodaysDate() {
		LocalDate today = LocalDate.now();
		System.out.println("Today's Local date : " + today);
		return today;
	}

	private static void getDayMonthYear() {
		LocalDate today = LocalDate.now();
		int year = today.getYear();
		int month = today.getMonthValue();
		int day = today.getDayOfMonth();
		System.out.printf("Year : %d Month : %d day : %d \t %n", year, month, day);
	}

	private static void getCertainDate() {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		System.out.println("Your Date of birth is : " + dateOfBirth);
	}

	private static void dateEquality() {
		LocalDate date1 = LocalDate.of(2014, 01, 14);
		LocalDate today = getTodaysDate();
		if (date1.equals(today)) {
			System.out.printf("Today %s and date1 %s are same date %n", today, date1);
		}
	}

	private static void checkForEvent() {
		LocalDate dateOfBirth = LocalDate.of(2010, 01, 14);
		LocalDate today = getTodaysDate();
		MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
		MonthDay currentMonthDay = MonthDay.from(today);
		if (currentMonthDay.equals(birthday)) {
			System.out.println("Many Many happy returns of the day !!");
		} else {
			System.out.println("Sorry, today is not your birthday");
		}

	}

	private static LocalTime getCurrentTime() {
		LocalTime time = LocalTime.now();
		System.out.println("local time now : " + time);
		return time;
	}

	private static void addHours() {
		LocalTime time = LocalTime.now();
		LocalTime newTime = time.plusHours(2); // adding two hours
		System.out.println("Time after 2 hours : " + newTime);
	}

	private static void dateAfter1Week() {
		LocalDate today = getTodaysDate();
		LocalDate nextWeek = today.plus(1, ChronoUnit.WEEKS);
		System.out.println("Today is : " + today);
		System.out.println("Date after 1 week : " + nextWeek);
	}

	private static void daysBetween() {
		LocalDate today = getTodaysDate();
		LocalDate java8Release = LocalDate.of(2014, Month.MARCH, 14);
		Period periodToNextJavaRelease = Period.between(today, java8Release);
		System.out.println("Months left between today and Java 8 release : " + periodToNextJavaRelease.getMonths());
	}

	private static void timeZones() {
		// Date and time with timezone in Java 8
		ZoneId america = ZoneId.of("America/New_York");
		LocalDateTime localtDateAndTime = LocalDateTime.now();
		ZonedDateTime dateAndTimeInNewYork = ZonedDateTime.of(localtDateAndTime, america);
		System.out.println("Current date and time in a particular timezone : " + dateAndTimeInNewYork);
	}

	private static void parseDatePredefined() {
		String dayAfterTommorrow = "20140116";
		LocalDate formatted = LocalDate.parse(dayAfterTommorrow, DateTimeFormatter.BASIC_ISO_DATE);
		System.out.printf("Date generated from String %s is %s %n", dayAfterTommorrow, formatted);
	}

	private static void parseDateCustom() {
		String goodFriday = "Apr 18 2014 01:01 PM";
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
			LocalDate holiday = LocalDate.parse(goodFriday, formatter);
			System.out.printf("Successfully parsed String %s, date is %s%n", goodFriday, holiday);
		} catch (DateTimeParseException ex) {
			System.out.printf("%s is not parsable!%n", goodFriday);
			ex.printStackTrace();
		}
	}

	private static void dateToString() {
		LocalDateTime arrivalDate = LocalDateTime.now();
		try {
			DateTimeFormatter format = DateTimeFormatter.ofPattern("MMM dd yyyy hh:mm a");
			String landing = arrivalDate.format(format);
			System.out.printf("Arriving at : %s %n", landing);
		} catch (DateTimeException ex) {
			System.out.printf("%s can't be formatted!%n", arrivalDate);
			ex.printStackTrace();
		}
	}
}
