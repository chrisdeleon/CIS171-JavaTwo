/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package guiinformationaldisplay;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


/**
 *
 * @author cdeleon
 */
public class GUIInformationalDisplay extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // container that stores the image view
        GridPane pane = new GridPane();
        // adds padding to horizonal box
        pane.setPadding(new Insets(15, 15, 15, 15));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(6);
        pane.setVgap(6);
        
        // first image view object
        // note: in NetBeans, the image should be stored in "build/classes/"
        Image image = new Image("image/SadDog.jpg");
        // add image to window
        
        // heading text 
        Label heading = new Label("HEADING TEXT");
        heading.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        pane.add(heading, 0, 0);
        // heading styling
        
        // image
        pane.add(new ImageView("image/SadDog.jpg"), 0, 1);
        // text box
        pane.add(new Text("TEXT BOX"), 0, 2);
        
        // button
        Button adoptButton = new Button("Adopt Me!");
        pane.add(adoptButton, 0, 3);
        GridPane.setHalignment(adoptButton, HPos.CENTER);
        
        
        
        
        
        // create scene object, store the pane, and render to the screen using primary stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Dog Fostering - Making a Difference, One Dog at a Time. ");
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
