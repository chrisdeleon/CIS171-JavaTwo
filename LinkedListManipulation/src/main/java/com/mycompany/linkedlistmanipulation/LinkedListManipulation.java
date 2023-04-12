package com.mycompany.linkedlistmanipulation;
import java.util.Scanner;

/**
 * Chris de Leon 
 * CIS171 
 * 4/11/2023
 */
public class LinkedListManipulation {

    // defines the head of the linked list
    Node head;

    public static class Node {

        // data that the node will contain
        int data;

        // pointer for the next node
        Node next;

        // constructor for a node
        Node(int data) {
            // stores data
            this.data = data;
            // marks the new node as the last node
            next = null;
        }
    }
    
    // searches for a specific number in the linked list
    public static void search(LinkedListManipulation l, int x){
        // creates a current property and sets it equal to the head 
        Node current = l.head;
        
        // index to track location of the node if found
        int index = 0;
        
        // this while loop parses the linked list until it reaches the 
        // end or the data in a specific node that matches the x variable
        while (current != null && current.data != x){
            current = current.next;
            index++;
        }
        
        // print statement for node not found
        if (current == null){
            System.out.println(x + " not found in linked list");
        }
        
        // print statement for node found
        System.out.println(x + " was found in node " + index);
    }
    
    // appends node into the linked list
    public static void insertion(LinkedListManipulation l, int x){
        // creates a new node
        Node newNode = new Node(x);
        
        // if head is empty, the new node is the new head
        if (l.head == null){
            l.head = newNode;
        } 
        // else, a last property is created an set to equal the 
        // linked list head and a while-loop iterates through the linked
        // list until it arrives at the node with a null next which is 
        // then set to the new node
        else {
            Node last = l.head;
            
            while (last.next != null){
                last = last.next;
            }
            last.next = newNode;
        }
    }
    
    // deletes a specific number in the linked list
    public static void deletion(LinkedListManipulation l, int x){
        // creates a location to temporarily store the link, without this we'll lose the ability to parse the list
            Node holder = l.head;
            Node previousNode = null;
            
            // logic to delete the head node in the event that it is the one that the user wants to remove
            if (holder != null && holder.data == x){
                l.head = holder.next;
            }
            
            // runs while we're not at the end of the linked list and the key doesn't match
            while (holder != null && holder.data != x){
                // hangs on to the current node's location
                previousNode = holder;
                // moves on to the next node's location
                holder = holder.next;
            }
            
            // if the while loop terminates and there is no result from it, this logic tells the user there was no such node
            if(holder == null){
                System.out.println(x + " not found in linked list.");
            }
            
            // discards the node from the list
            previousNode.next = holder.next;
    }
    
    // method that prints the entire linked list
        public static void printLinkedList(LinkedListManipulation l) {
            // creates a new node and defines it as current and sets it to have the value of the list head
            Node current = l.head;

            System.out.println("Linked List:");

            // while-loop parses the entire linked list until it runs into the null node
            while (current != null) {
                System.out.println(current.data + " ");
                // goes to the next node
                current = current.next;
            }
        }
    

    public static void main(String[] args) {
        Boolean exit = true;
        Scanner input = new Scanner(System.in);
        int selection;

        // creates empty linked list
        LinkedListManipulation list = new LinkedListManipulation();
        
        // creates nodes
        for(int i = 0; i < 100; i++){
            insertion(list, i);
        }
        
        System.out.println("Hi there! The linked list has been created by default with 100 nodes. Please select from the following statements to interact with it... or not!");
        
        do {
        
            System.out.println("Enter 1 to add a node");
            System.out.println("Enter 2 to delete a node");
            System.out.println("Enter 3 to search for a node");
            System.out.println("Enter 4 to print the linked list");
            System.out.println("Enter 5 to exit");

            selection = input.nextInt();

            switch (selection) {
                case 1: 
                    System.out.println("Enter data for node: ");
                    int num = input.nextInt();
                    insertion(list, num);
                    System.out.println(num + " added to linked list");
                    break;
                case 2:
                    System.out.println("Enter node to delete: ");
                    num = input.nextInt();
                    deletion(list, num);
                    System.out.println(num + " deleted from linked list");
                    break;
                case 3:
                    System.out.println("Enter node to locate: ");
                    num = input.nextInt();
                    search(list, num);
                    break;
                case 4:
                    printLinkedList(list);
                    break;
                case 5:
                    exit = false;
                    break;
                default: System.out.println("Invalid input");
            }
        } while(exit);
        System.out.println("Goodbye");
    }
}
