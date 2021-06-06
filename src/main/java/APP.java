/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Joshua Ashby
 */

import java.util.Calendar;
import java.util.Scanner;
import java.lang.Math;

public class APP {


    public static void main(String[] args) {
        final int legalDriveAge = 16;
        System.out.println("Enter a 1 is you are male or a 2 if you are female:");
        Scanner sc = new Scanner(System.in);
        String GenderString = sc.nextLine();

        if(!isNumeric(GenderString))
        {
            System.out.println("You answer is not parseable, please restart the program and try again");
            System.exit(-1);
        }
        System.out.println("How many ounces of alcohol did you have?");
        String OZString = sc.nextLine();
        if(!isNumeric(OZString))
        {
            System.out.println("You answer is not parseable, please restart the program and try again");
            System.exit(-1);
        }
        System.out.println("What is your weight, in pounds?");
        String WeightString = sc.nextLine();
        if(!isNumeric(WeightString))
        {
            System.out.println("You answer is not parseable, please restart the program and try again");
            System.exit(-1);
        }
        System.out.println("How many hours has it been since your last drink?");
        String HoursString = sc.nextLine();
        if(!isNumeric(HoursString))
        {
            System.out.println("You answer is not parseable, please restart the program and try again");
            System.exit(-1);
        }

        int Gender = Integer.parseInt(GenderString);
        double Oz = Double.parseDouble(OZString);
        double Weight = Double.parseDouble(WeightString);
        double Hours = Double.parseDouble(HoursString);
        double BAC = 0;
        if (Gender == 1)
        {
             BAC = (Oz * 5.14 / Weight * 0.73) - .015 * Hours;
        }
        else if (Gender == 2)
        {
             BAC = (Oz * 5.14 / Weight * 0.66) - .015 * Hours;
        }
        else
        {
            System.out.println("Gender not valid, please restart the program and try again");
            System.exit(-1);
        }

        System.out.printf("Your BAC is %.6f", BAC);

        if (BAC <= 0.08)
        {
            System.out.println("\nIt is legal for you to drive.");
        }
        else
        {
            System.out.println("\nIt is not legal for you to drive.");
        }

    }

    public static boolean isNumeric(String string) {
        int intValue;


        if(string == null || string.equals("")) {
            return false;
        }

        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }
}
