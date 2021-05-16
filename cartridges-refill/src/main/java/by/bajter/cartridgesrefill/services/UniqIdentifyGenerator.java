package by.bajter.cartridgesrefill.services;

public class UniqIdentifyGenerator {
	private static final int START_COUNT = 2000;
	private static int count = START_COUNT;
	
	private UniqIdentifyGenerator() {
	
	}
	
	public static String generate() {
		return "B" + ++count;
	}
	
}
