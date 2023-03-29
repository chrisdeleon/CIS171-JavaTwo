package com.mycompany.sortarraylist;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Chris de Leon 
 * 3/28/2023 
 * CIS171
 */
public class SortArrayList {

    // in order for the sort method to function, Person must implement the Comparable interface
    public static class Person implements Comparable<Person> {

        // attributes of a person
        private String name;
        private String address;
        private String phoneNumber;
        private String email;

        // constructor
        Person(String name, String address, String phoneNumber, String email) {
            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
            this.email = email;
        }

        // this compareTo method specifies how the person object should be compared
        // in this case, it compares the names
        @Override
        public int compareTo(Person other) {
            return this.name.compareTo(other.name);
        }
        
        // getter for the name
        public String getName() {
            return this.name;
        }
    }

    // code provided from the textbook
    public static <E extends Comparable<E>> void sort(ArrayList<E> list) {
        Collections.sort(list);
    }

    // method to add persons to the array list
    public static void load(ArrayList<Person> o, String name, String address, String phoneNumber, String email) {
        // using the constructor, adds a new person with the information provided
        Person newPerson = new Person(name, address, phoneNumber, email);
        // uses the add method in ArrayList to add the object
        o.add(newPerson);
    }

    public static void main(String[] args) {
        // instantiates array list made up of person objects
        ArrayList<Person> list = new ArrayList<>();

        // loads data into list
        load(list, "Zebra", "Where zebras live", "555-555-5554", "zebra@animal.com");
        load(list, "Chris de Leon", "123 Main St.", "1800-777-7777", "myemail@email.com");
        load(list, "Kirsten Markley", "OTC NKM Building", "417-447-7500", "markleyk@otc.edu");
        load(list, "John Doe", "789 John Lane", "417-777-7777", "john@doe.com");
        load(list, "Jane Doe", "261 Craig Drive", "417-777-7778", "jane@doe.com");
        load(list, "Kent C. Straight", "1111 Blind Ave", "411-811-1211", "kentcyou@gmail.com");
        load(list, "Mario Mario", "1 Nintendo Blvd", "800-255-3700", "mario@nintendo.com");
        load(list, "Apple", "4 Tree Path", "123-456-7890", "the@pple.com");

        // prints array list in the order it was created
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        System.out.println("\nDone printing list\n");
        
        sort(list);
        
        // prints a shuffled array list
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getName());
        }
        System.out.println("\nDone printing list");
    }
}
