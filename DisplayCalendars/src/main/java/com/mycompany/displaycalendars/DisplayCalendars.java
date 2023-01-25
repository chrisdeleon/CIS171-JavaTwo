package com.mycompany.displaycalendars;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

/* Chris de Leon
*  1/24/2023
*  Exercise 13.4 Display Calendars
*/
public class DisplayCalendars{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter year: ");
        int year = input.nextInt();
        System.out.println("Enter month (0-11):");
        int month = input.nextInt();
        Calendar gregCal = new GregorianCalendar(year, month, 1); // no argument constructor
        
        // displays the name of the entered month and the year entered
        System.out.println("      " + gregCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
        
        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < gregCal.get(Calendar.DAY_OF_WEEK); i++)
            System.out.print(" ");
        
        for (i = 1; i <= gregCal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
            System.out.printf("%4d", i);
            
            if ((i + gregCal.get(Calendar.DAY_OF_WEEK)) % 7 == 0){
                System.out.println();
            }
        }

        
        
        // prints additional required input 
        System.out.println("\n" + gregCal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + ", " + year 
        + " contains " + gregCal.getActualMaximum(Calendar.DAY_OF_MONTH) + " days.");
        
        
        // specifies start day in int format
        // System.out.println(gregCal.get(Calendar.DAY_OF_WEEK));
    }
}