package ru.croc.task8;

import java.util.Scanner;
import java.util.Locale;
import java.math.BigDecimal;
import java.text.NumberFormat;

public class Task8 {
	public static void main(String[] args) {
		Scanner progIn= new Scanner(System.in);
        Locale localeString=Locale.UK;
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(localeString);
        System.out.print("Enter a double: ");
		String priceNumber = progIn.nextLine();
        try {
            BigDecimal price = new BigDecimal(priceNumber);
            System.out.println("Result: " + numberFormat.format(price));
        } catch (NumberFormatException e) {
            System.out.println("Impossible to convert string " + priceNumber + " to double!");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            progIn.close();
        }
    }
}
