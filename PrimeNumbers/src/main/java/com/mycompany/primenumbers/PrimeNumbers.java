package com.mycompany.primenumbers;

/**
 * Chris de Leon
 * 04/04/2023
 * CIS171
 */
public class PrimeNumbers {

    public static void main(String[] args) {
        // amount of numbers the program will parse to find prime numbers
        int target = 1000000; 
        
        // initializes an array with all the numbers
        boolean[] primeNumbers = new boolean[target + 1];
        
        // sets all of the booleans to true in the array
        for(int i = 0; i < primeNumbers.length; i++){
            primeNumbers[i] = true;
        }
        
        
        /* There is quite a bit of information to unpack here.
        This algorithm is known as Sieve of Eratosthenes and it works in the following manner: */
        
        
        // First all the numbers in the array divisible by two are found.
        // The numbers returned are all divisible by two so it is set to false.
        // That takes places in the inner for-loop.
        // Once the inner loop has finished running, the outer loop goes through it's next iteration
        // which would be three and sets all the numbers that are divisible by three to false... it repeats this process until
        // the outer loop has terminated. 
        for (int k = 2; k <= target / k; k++){
            if (primeNumbers[k]){
                for (int i = k; i <= target / k; i++){
                    primeNumbers[k * i] = false;
                }
            }
        }
        
        // tracks the number of prime numbers found in the given array
        int primesFound = 0;
        
        // loops throught the array to find the indices that return true
        System.out.println("Prime numbers: ");
        for(int i = 2; i < primeNumbers.length; i++){
            if(primeNumbers[i]){
                // adds to prime number found count if the tested index is true
                primesFound++;
                // prints the prime number
                System.out.println(i);
            }
        }
        System.out.println("\n Total prime numbers less than or equal to " + target + ": " + primesFound);
    }
}
