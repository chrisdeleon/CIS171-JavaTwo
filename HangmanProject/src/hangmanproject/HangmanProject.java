package hangmanproject;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;

/**
 * Chris de Leon
 * Hangman Unit 1 Project
 * 2/13/2023
 */
public class HangmanProject extends Application {
    @Override
    public void start(Stage primaryStage) {
        // creates circle
        Circle circle = new Circle(225, 100, 25);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        
        // creates eight different lines
        Line largestLine = new Line (100, 50, 100, 280);
        largestLine.setStroke(Color.BLACK);
        
        Line horizontalLine = new Line (100, 50, 225, 50);
        horizontalLine.setStroke(Color.BLACK);
        
        Line shortestLine = new Line (225, 50, 225, 75);
        shortestLine.setStroke(Color.BLACK);
        
        Line body = new Line (225, 125, 225, 200);
        body.setStroke(Color.BLACK);
        
        Line leftArm = new Line (160, 150, 210, 120);
        leftArm.setStroke(Color.BLACK);
        
        Line rightArm = new Line (240, 120, 280, 150);
        rightArm.setStroke(Color.BLACK);
        
        Line leftLeg = new Line (170, 250, 225, 200);
        leftLeg.setStroke(Color.BLACK);
        
        Line rightLeg = new Line (225, 200, 265, 250);
        rightLeg.setStroke(Color.BLACK);
        
       // creates the ellipse-base
       Arc base = new Arc(100, 280, 30, 25, 0, 180);
       base.setStroke(Color.BLACK);
       base.setType(ArcType.OPEN);
       base.setFill(Color.WHITE);
        
        // Pane to hold elements
        Pane pane = new Pane();
        pane.getChildren().add(circle);
        pane.getChildren().add(largestLine);
        pane.getChildren().add(horizontalLine);
        pane.getChildren().add(shortestLine);
        pane.getChildren().add(body);
        pane.getChildren().add(leftArm);
        pane.getChildren().add(rightArm);
        pane.getChildren().add(leftLeg);
        pane.getChildren().add(rightLeg);
        pane.getChildren().add(base);

        // creates scene, stores the pane, and renders to the screen using primary stage
        Scene scene = new Scene(pane, 350, 325);
        primaryStage.setTitle("Hangman");
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
