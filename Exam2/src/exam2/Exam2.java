package exam2;

import java.text.DecimalFormat;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * Chris de Leon 
 * 3/9/2023 
 * CIS 171
 */

/* Write a program that converts US dollars into Canadian dollars, as shown in the following figure. The program lets the user
enter an amount in US dollars and display the equivalent value in Canadian dollars when the Convert button is clicked. 
One Canadian dollar is 0.73 US. All good coding styles, conventions, and standards must be used when completing this 
project in order to get full credit */

 /* Extra, as in, not required from this assignment, I added functionality to let the user choose which currency they want */
public class Exam2 extends Application {

    @Override
    public void start(Stage primaryStage) {

        // grid pane with horizontal alignment and vertical alignments
        GridPane pane = new GridPane();
        pane.setHgap(15);
        pane.setVgap(15);
        pane.setAlignment(Pos.CENTER);

        /* for debugging */
        // pane.setGridLinesVisible(true);
        /* for debugging */
        
        // text fields for user input, both come preloaded with 0
        TextField UStxtField = new TextField("0");
        TextField CANtxtField = new TextField("0");
        CANtxtField.setEditable(false); // editability set to false by default

        // aligns text inside text fields to the right
        UStxtField.setAlignment(Pos.CENTER_RIGHT);
        CANtxtField.setAlignment(Pos.CENTER_RIGHT);

        // labels to tell user which text field is for which currency
        Label UStxtFieldLabel = new Label("US dollars (US): ");
        Label CANtxtFieldLabel = new Label("Canadian dollars (CAN): ");
        Label Instructions = new Label("Select currency desired: ");

        // adds text fields and labels to the grid pane
        pane.add(UStxtFieldLabel, 0, 0);
        pane.add(UStxtField, 1, 0);
        pane.add(CANtxtFieldLabel, 0, 1);
        pane.add(CANtxtField, 1, 1);

        // adds the radio buttons and group to toggle between calculating CAN or US
        RadioButton ConvertCAN = new RadioButton("CAN");
        RadioButton ConvertUS = new RadioButton("US");
        ConvertCAN.setSelected(true); // selects US to CAN conversion by default

        // toggle group for the currency buttons
        ToggleGroup group = new ToggleGroup();
        ConvertCAN.setToggleGroup(group);
        ConvertUS.setToggleGroup(group);

        // adds radio buttons to the gride pane as well as their label
        pane.add(Instructions, 0, 2);
        pane.add(ConvertCAN, 1, 3);
        pane.add(ConvertUS, 0, 3);

        // creates button to clear items
        Button ClearBtn = new Button();
        ClearBtn.setText("Clear Data");

        // creates button to perform the calculation
        Button CalculateBtn = new Button();
        CalculateBtn.setText("Convert");

        // updates the program based of the user's selection of radio button
        ConvertUS.setOnAction(e -> {
            UStxtField.setEditable(false);
            CANtxtField.setEditable(true);
            UStxtField.setText("0");
            CANtxtField.setText("0");
        });

        // updates the program based of the user's selection of radio button
        ConvertCAN.setOnAction(e -> {
            CANtxtField.setEditable(false);
            UStxtField.setEditable(true);
            UStxtField.setText("0");
            CANtxtField.setText("0");
        });

        // runs the method according to what radio button is selected
        // try-catch integrated for those that don't use numbers :)
        CalculateBtn.setOnAction((ActionEvent event) -> {
            try {
                System.out.println("Convert clicked");
                // if US radio button is selected
                if (ConvertUS.isSelected()) {
                    UStxtField.setText(Operations.divide(Double.parseDouble(CANtxtField.getText())));
                }
                // if CAN radio button is selected
                if (ConvertCAN.isSelected()) {
                    // runs operations to convert US dollar input to CAN
                    CANtxtField.setText(Operations.multiply(Double.parseDouble(UStxtField.getText())));
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number");
                UStxtField.setText("0");
                CANtxtField.setText("0");
            }

        });

        // adds action listener to clear data when clicked
        ClearBtn.setOnAction((ActionEvent) -> {
            System.out.println("Clear button clicked");
            UStxtField.setText("0");
            CANtxtField.setText("0");
        });

        // adds buttons to grid pane
        pane.add(CalculateBtn, 1, 4);
        pane.add(ClearBtn, 0, 4);

        // aligns the two objects to the right of their box
        GridPane.setHalignment(CalculateBtn, HPos.RIGHT);
        GridPane.setHalignment(ConvertCAN, HPos.RIGHT);

        // sets the scene, adds the pane to the scene, displays the stage with all elements added
        Scene scene = new Scene(pane, 400, 250);
        primaryStage.setTitle("US and CAN Money Converted");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public class Operations {

        public static String multiply(double d) {
            // formatter for returning only two decimal places in result
            DecimalFormat twoDecimals = new DecimalFormat(".00");

            double result;
            result = d * 0.73;
            twoDecimals.format(result);
            return Double.toString(result);
        }

        public static String divide(double d) {
            // formatter for returning only two decimal places in result
            DecimalFormat twoDecimals = new DecimalFormat(".00");

            double result;
            result = d / 0.73;
            twoDecimals.format(result);
            return Double.toString(result);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
