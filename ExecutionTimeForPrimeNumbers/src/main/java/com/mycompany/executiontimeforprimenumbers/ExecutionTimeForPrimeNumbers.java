package com.mycompany.executiontimeforprimenumbers;

import java.util.Scanner;

/**
 * Chris de Leon 
 * 04/04/2023 
 * CIS171
 */
public class ExecutionTimeForPrimeNumbers {

    public static void main(String[] args) {
        
        // variables used to calculate duration
        long firstStart, firstEnd, secondStart, secondEnd, thirdStart, thirdEnd;
        

        // this for-loop ensure that the table is completely filled with data
        for (int counter = 0; counter < 6; counter++) {
            /* **************** */
            /* LiveExample 22.5 */
            /* **************** */

            Scanner input = new Scanner(System.in);
            System.out.print("Find all prime numbers <= n, enter n: ");
            int n = input.nextInt();
            
            firstStart = System.currentTimeMillis(); // live example 22.5 start time

            int count = 0; // Count the number of prime numbers
            int number = 2; // A number to be tested for primeness

            // Repeatedly find prime numbers
            while (number <= n) {
                // Assume the number is prime
                boolean isPrime = true; // Is the current number prime?

                // ClosestPair if number is prime
                for (int divisor = 2; divisor <= (int) (Math.sqrt(number));
                        divisor++) {
                    if (number % divisor == 0) { // If true, number is not prime
                        isPrime = false; // Set isPrime to false          
                        break; // Exit the for loop
                    }
                }
                // Print the prime number and increase the count
                if (isPrime) {
                    count++; // Increase the count
                }
                // Check if the next number is prime
                number++;
            }
            
            firstEnd = System.currentTimeMillis(); // live example 22.5 end time
            
            
            /* **************** */
            /* LiveExample 22.6 */
            /* **************** */
            
            secondStart = System.currentTimeMillis(); // live example 22.6 start time
            
            


            // A list to hold prime numbers
            java.util.List<Integer> list
                    = new java.util.ArrayList<>();

            count = 0; // Count the number of prime numbers
            number = 2; // A number to be tested for primeness
            int squareRoot = 1; // Check whether number <= squareRoot

            // Repeatedly find prime numbers
            while (number <= n) {
                // Assume the number is prime
                boolean isPrime = true; // Is the current number prime?

                if (squareRoot * squareRoot < number) {
                    squareRoot++;
                }

                // Test whether number is prime
                for (int k = 0; k < list.size()
                        && list.get(k) <= squareRoot; k++) {
                    if (number % list.get(k) == 0) { // If true, not prime
                        isPrime = false; // Set isPrime to false          
                        break; // Exit the for loop
                    }
                }

                // Print the prime number and increase the count
                if (isPrime) {
                    count++; // Increase the count
                    list.add(number); // Add a new prime to the list
                }
                // Check if the next number is prime
                number++;
            }
            secondEnd = System.currentTimeMillis(); // live example 22.6 end time

            /* **************** */
            /* LiveExample 22.7 */
            /* **************** */
            thirdStart = System.currentTimeMillis(); // live example 22.7 start time


            boolean[] primes = new boolean[n + 1]; // Prime number sieve

            // Initialize primes[i] to true
            for (int i = 0; i < primes.length; i++) {
                primes[i] = true;
            }

            for (int k = 2; k <= n / k; k++) {
                if (primes[k]) {
                    for (int i = k; i <= n / k; i++) {
                        primes[k * i] = false; // k * i is not prime
                    }
                }
            }

            count = 0; // Count the number of prime numbers found so far
            // Print prime numbers
            for (int i = 2; i < primes.length; i++) {
                if (primes[i]) {
                    count++;
                }
            }
            thirdEnd = System.currentTimeMillis(); // live example 22.7 end time
            /* ****************** */
            /* END OF LEGACY CODE */
            /* ****************** */
            
            
            // print statements calculate the runtime for each iteration
            System.out.println("Runtime for prime numbers within " + n);
            System.out.println("\nLive example 22.5: " + (firstEnd - firstStart) / 1000.0f + " seconds");
            System.out.println("Live example 22.6: " + (secondEnd - secondStart) / 1000.0f + " seconds");
            System.out.println("Live example 22.7: " + (thirdEnd - thirdStart) / 1000.0f + " seconds");
            
        } // end of counter for-loop
    }
}
