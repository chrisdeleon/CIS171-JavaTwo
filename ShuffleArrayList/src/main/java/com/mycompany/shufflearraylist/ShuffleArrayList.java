package com.mycompany.shufflearraylist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Chris de Leon 
 * CIS 171 
 * 3/28/2023
 */
public class ShuffleArrayList {
    public static class Person<E> {

        // four properties of a person object
        private String name;
        private String address;
        private String phoneNumber;
        private String email;

        // constructor for a new person instance
        Person(String name, String address, String phoneNumber, String email) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        // getter for the person's name, it is later used with the printing of the array list
        public String getName() {
            return this.name;
        }
    }

    // method to add persons to the array list
    public static void load(ArrayList<Person> o, String name, String address, String phoneNumber, String email) {
        // using the constructor, adds a new person with the information provided
        Person newPerson = new Person(name, address, phoneNumber, email);
        // uses the add method in ArrayList to add the object
        o.add(newPerson);
    }

    // shuffles the items in the array list
    public static <E> void shuffle(ArrayList<E> list) {
        // determines array list size
        int size = list.size();

        // creates a random order to give a shuffle effect
        Random random = new Random();

        // for loop parses the list and randomizes it
        for (int i = 0; i < size; i++) {
            // determines the bounds of the random number
            int randomIndex = random.nextInt(size);

            // holds all the information of the array list at the randomIndex
            E holder = list.get(randomIndex);

            // sets the information at the object at index randomIndex 
            // the information it pulls is from the array list at the index at the current iteration
            list.set(randomIndex, list.get(i));
            // sets the holder information within the array list at index at the current iteration
            list.set(i, holder);
        }
    }

    public static void main(String[] args) {
        // defines the array list that we'll be working with
        ArrayList<Person> list = new ArrayList<>();

        // test data
        load(list, "Chris de Leon", "123 Main St.", "1800-777-7777", "myemail@email.com");
        load(list, "Kirsten Markley", "OTC NKM Building", "417-447-7500", "markleyk@otc.edu");
        load(list, "John Doe", "789 John Lane", "417-777-7777", "john@doe.com");
        load(list, "Jane Doe", "789 John Lane", "417-777-7778", "jane@doe.com");
        load(list, "Kent C. Straight", "1111 Blind Ave", "411-811-1211", "kentcyou@gmail.com");
        load(list, "Mario Mario", "1 Nintendo Blvd", "800-255-3700", "mario@nintendo.com");

        // prints array list in the order it was created
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        System.out.println("\nDone printing list\n");

        // calls the shuffle method for the ArrayList
        shuffle(list);

        // prints a shuffled array list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        System.out.println("\nDone printing list");
    }
}
