package loansandinterestrates;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;

/**
 * Chris de Leon
 * CIS 171
 * 3/3/2023
 */


/* Rewrite Programming Exercise 5.21 to create a GUI. Your program should let the user enter the loan
amount and load period in the number of years from text fields, and it should display the monthly and total
payments for each interest rate starting from 5% to 8%, with increments of one-eighth, in a text area. */

/* 5.21 Write a program that lets the user enter the loan amount and loan period in number of years,
and displays the monthly total payments for each interest... */
public class LoansAndInterestRates extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        Loan.LoanCalculate(250000, 15);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    // Loan class, where all loan calculations will take place
    class Loan {
    
    // method for calculating loan terms
    public static void LoanCalculate(double amount, int years){
        // for loop calculate loan rates from 5% to 8%
        for(double i = 5; i <= 8; i = i + 0.125){
            // obtains monthly interest rate
            double monthlyInterestRate = i / 1200;
            // math for calculating monthly rate, please note this code is "legacy" code
            double monthlyPayment = amount * monthlyInterestRate /(1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            // total amount paid, including interest
            double totalPayment = monthlyPayment * years * 12;
            
            // formats the variables into readable numbers for the user
            System.out.print("Monthly payment: " + (int)(monthlyPayment * 100) / 100.0);
            System.out.print(" Total payment: " + (int)(totalPayment * 100) / 100.0 + " at " + i + "% interest rate");
            System.out.println("");
        }
    }
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
