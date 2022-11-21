package Services;


import java.util.Scanner;

import Constants.Constants;

public class Input {
	private static final Scanner INPUT = new Scanner(System.in);
	
	public static String askString(String message) {
		System.out.print(message);
		return INPUT.next();
	}
	
	public static Integer askInteger(String message) {
		System.out.print(message);
		return INPUT.nextInt();
	}
	
	public static Double askPositiveValue(String message) {
		Double value = askDouble(message);
		
		while (0 >= value) {
			value = askDouble(Constants.ASK_POSITIVE_VALUE);
		}
		return value;
		
	}
	
	public static Double askDouble(String message) {
		System.out.print(message);
		return INPUT.nextDouble();
	}
}
