package loansandinterestrates;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * Chris de Leon 
 * CIS 171 
 * 3/3/2023
 */


/* Rewrite Programming Exercise 5.21 to create a GUI. Your program should let the user enter the loan
amount and load period in the number of years from text fields, and it should display the monthly and total
payments for each interest rate starting from 5% to 8%, with increments of one-eighth, in a text area. */

public class LoansAndInterestRates extends Application {

    // create instance of Loan object to use within the start method
    Loan FirstLoan = new Loan();

    @Override
    public void start(Stage primaryStage) {

        // creates a grid pane and adds spacing
        GridPane pane = new GridPane();
        pane.setHgap(5.5);
        pane.setVgap(5.5);
        pane.setAlignment(Pos.CENTER);

        // creates text area for calculation output
        TextArea calculationDisplay = new TextArea();
        calculationDisplay.setText("Interest\t\tMonthly Payment\t\tTotal Payment    \n");

        // text fields to grab data for calculation
        TextField amount = new TextField();
        TextField years = new TextField();

        // button that triggers calculation method
        Button btn = new Button();
        btn.setText("Show Table");
        btn.setOnAction((ActionEvent event) -> {
            // runs the calculation method, but changes the entered numbers to the required variable-type first
            // try-catch added for text entered that cannot be changed to double or integer
            try {
                // for loop calculates loan rates from 5% to 8%
                for (double i = 5; i <= 8; i = i + 0.125) {
                    FirstLoan.LoanCalculate(Double.parseDouble(amount.getText()),
                            Integer.parseInt(years.getText()), i);
                    calculationDisplay.appendText(FirstLoan.getData() + "\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter whole numbers");
            }
        });

        // adds elements to the grid
        pane.add(new Label("Loan Amount:"), 0, 0);
        pane.add(amount, 1, 0);
        pane.add(new Label("Number of Years:"), 2, 0);
        pane.add(years, 3, 0);
        pane.add(btn, 4, 0);
        pane.add(calculationDisplay, 0, 1, 5, 4);

        // adds grid to the scene, sets the stage, and displays it
        Scene scene = new Scene(pane, 600, 250);
        primaryStage.setTitle("Loan Calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Loan class, where all loan calculations will take place
    class Loan {

        private double monthlyPayment = 0;
        private double totalPayment = 0;
        private double interestRate = 0;

        // method for calculating loan terms
        public void LoanCalculate(double amount, int years, double interestRate) {
            // obtains monthly interest rate
            double monthlyInterestRate = interestRate / 1200;
            // math for calculating monthly rate, please note that the majority of this code is "legacy" code
            double monthlyPayment = amount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, years * 12));
            // assigns outcome to private variable
            this.monthlyPayment = (monthlyPayment * 100) / 100.0;
            // total amount paid, including interest
            double totalPayment = monthlyPayment * years * 12;
            // assigns outcome to private variable
            this.totalPayment = (totalPayment * 100) / 100.0;
            // sets interest rate to current loop iteration
            this.interestRate = interestRate;
        }

        // returns string with interest rate, monthly payment, and total payment
        public String getData() {
            // this took me longer to do than the rest of the project :(
            return String.format("%-5.3f %s $%.2f %s $%.2f", this.interestRate, "\t\t", this.monthlyPayment, "\t\t\t\t", this.totalPayment);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
