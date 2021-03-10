package com.example;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class test {
	public static void main(String[] args) {

		String date = Calendar.getInstance().getTime().toString();
		System.out.println(date.substring(5,20));
		//String str[] = date.split("\\s+");
		//System.out.println(Arrays.toString(str).substring(1,2));
        System.out.println(date);

	}

}
