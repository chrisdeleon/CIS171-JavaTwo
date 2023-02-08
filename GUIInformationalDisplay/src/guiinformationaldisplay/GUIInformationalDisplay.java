package guiinformationaldisplay;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Chris de Leon
 * 2/7/2023
 * GUI Informational Display
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
        
        // heading text and styling
        Label heading = new Label("Adopt This Dog");
        heading.setFont(Font.font("Times New Roman", FontWeight.BOLD, 24));
        pane.add(heading, 0, 0);

        // subheading text and styling
        Label subHeading = new Label("Gerald");
        subHeading.setFont(Font.font("Times New Roman", FontWeight.BOLD, 20));
        pane.add(subHeading, 0, 1);
        
        // centering for heading and subheading
        GridPane.setHalignment(heading, HPos.CENTER);
        GridPane.setHalignment(subHeading, HPos.CENTER);
        
        // image add and positioning
        ImageView SadDog = new ImageView("image/SadDog.jpg");
        pane.add(SadDog, 0, 2);
        GridPane.setHalignment(SadDog, HPos.CENTER);
        
        // text box
        Text body = new Text("Gerald is one of the kindest dogs that is just down on his luck." 
        + "\nLike the majority of dogs, Gerald was once a part of an extremely loving family."
        + "\nUnfortunately for him though, his entire family passed in a horrific boating accident. He was the only survivor"
        + "\nHe went from being the happiest soul on earth, to the saddest dog known to man."
        + "\nAt Dog Fostering USA, we believe that you are the key to Gerald's joy and we'd love to bring you two together."
        + "\nPlease click the button at the bottom of Gerald's adopt-me page to give this pup the life he deserves.");
        body.setStyle("-fx-font: 16 'Times New Roman';");
        pane.add(body, 0, 3);
        body.setTextAlignment(TextAlignment.CENTER); // centers all body text
        
        // button
        Button adoptButton = new Button("Adopt Me!");
        pane.add(adoptButton, 0, 4);
        GridPane.setHalignment(adoptButton, HPos.CENTER);
        
        // create scene object, store the pane, and render to the screen using primary stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Dog Fostering USA - Making a Difference, One Dog at a Time. ");
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
