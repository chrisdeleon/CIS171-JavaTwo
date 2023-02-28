package textfieldproperties;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/* 16.6 Write a program that sets the horizontal-alignment and column-size properties of a text field 
dynamically as shown in figure 16.38 */

/**
 * Chris de Leon 
 * 2/28/2023 
 * CIS 171
 */
public class TextFieldProperties extends Application {

    @Override
    public void start(Stage primaryStage) {
        // creates a grid pane and sets horizontal and vertical spacing/alignment
        GridPane pane = new GridPane();
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setAlignment(Pos.CENTER);

        /* FOR DEBUGGING */
        // pane.setGridLinesVisible(true);
        /* ************* */
        
        // creates the main text field
        TextField txtField = new TextField("Default text");
        // allows the text field text to be editable
        txtField.setEditable(true);
        // adds label to the text field
        Label TextFieldLabel = new Label("Text Field", txtField);
        // adds label and text field to the pane
        pane.add(TextFieldLabel, 2, 0, 2, 1);

        // changes based on the toggle button selected, the default is set to left align
        txtField.setAlignment(Pos.CENTER_LEFT);

        // changes based on the user's input for column size, the default is set to 8
        txtField.setPrefColumnCount(8);

        // radio buttons for alignments
        RadioButton alignLeft = new RadioButton("Left");
        alignLeft.setSelected(true); // makes the default button the align left button
        RadioButton alignCenter = new RadioButton("Center");
        RadioButton alignRight = new RadioButton("Right");
        // toggle group for the different alignment buttons
        ToggleGroup group = new ToggleGroup();
        alignLeft.setToggleGroup(group);
        alignCenter.setToggleGroup(group);
        alignRight.setToggleGroup(group);
        // adds radio buttons to pane in specified location
        pane.add(alignLeft, 0, 1);
        pane.add(alignCenter, 1, 1);
        pane.add(alignRight, 2, 1);

        // creates the secondary text field that changes column size
        TextField columnSizeTextField = new TextField("");
        // allows the text field text to be editable
        columnSizeTextField.setEditable(true);
        // adds label to the text field
        Label columnSizeLabel = new Label("Column Size", columnSizeTextField);
        // puts the content of the label on the right and the label text on the left
        columnSizeLabel.setContentDisplay(ContentDisplay.RIGHT);
        // adds label and text field to the pane
        pane.add(columnSizeLabel, 3, 1);

        // adds action events that dynamically changes the text alignment based on user selection
        alignLeft.setOnAction(e -> {
            if (alignLeft.isSelected()) {
                txtField.setAlignment(Pos.CENTER_LEFT);
            }
        });

        alignCenter.setOnAction(e -> {
            if (alignCenter.isSelected()) {
                txtField.setAlignment(Pos.CENTER);
            }
        });

        alignRight.setOnAction(e -> {
            if (alignRight.isSelected()) {
                txtField.setAlignment(Pos.CENTER_RIGHT);
            }
        });

        // adds action event that changes the text field size once the user hits enter
        // added try-catch for when a user doesn't know that words != numbers
        columnSizeTextField.setOnAction(e -> {
            try {
                // the enormous piece of code below does the following:
                // grabs the entered text, coverts that text to string, converts that string to integer
                // then sets the integer to the new setPrefColumnCount
                // if there is an error at any point, the try-catch method will grab the error
                txtField.setPrefColumnCount(Integer.parseInt(columnSizeTextField.getCharacters().toString()));
            } catch (Exception exception) {
                System.out.println("\"" + columnSizeTextField.getCharacters() + "\"" + " is not a number.");
                System.out.println("Please enter a valid whole-number.");
            }
        });

        // creates the scene, adds title for the stage, and displays the items
        Scene scene = new Scene(pane, 400, 150);
        primaryStage.setTitle("Exercise16_06 Text Field Properties");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
