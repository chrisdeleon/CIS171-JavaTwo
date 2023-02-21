
package racingcar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * Chris de Leon
 * 2/20/23
 * Racing Car - Exercise 15.29
 */
public class RacingCar extends Application {
    
    // Car object must be instanciated outside of start in order for event handlers to function
    CarPane Car = new CarPane();
    
    @Override
    public void start(Stage primaryStage) {
        HBox hBox = new HBox(5); // creates a horizonal box with some spacing
        
        /* creates pause and resume buttons */
        Button btnPause = new Button("Pause");
        Button btnResume = new Button("Resume");
        
        /* centers the horizontal box and adds the buttons inside it */
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(btnPause, btnResume);
        
        BorderPane pane = new BorderPane(); // creates a new pane
        pane.setBottom(hBox); // puts the horizontal box at the bottom of the pane
        
        // adds a new car object and puts it in the center of the pane
        pane.setCenter(Car);
        
        // adds event handlers to both buttons for pausing and resuming
        btnPause.setOnAction(new pauseHandler());
        btnResume.setOnAction(new resumeHandler());
        
        // creates a new scene with the pane and height/width of 800
        Scene scene = new Scene(pane, 600, 200);
        primaryStage.setTitle("Racing Car");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        // event listener for speed adjusting
        // for some reason, my program would not register the up and down arrow keys 
        // so I used f for faster and s for slower as an alternative
        scene.setOnKeyPressed(new speedHandler());
    }
    
    class pauseHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e){
            Car.pause();
        }
    }
    
    class resumeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e){
            Car.resume();
        }
    }
    
    class speedHandler implements EventHandler<KeyEvent> {
        @Override
        public void handle(KeyEvent e){
            System.out.println(e);
            System.out.println("key pressed");
            switch (e.getCode()){
                case UP:
                case F: Car.faster();
                    break;
                case DOWN:
                case S: Car.slower();
                    break;
            }
        }
    }
    public static void main(String[] args) {
        launch(args);
    }
}

class CarPane extends Pane {
    // creats instance of image view and specifies which file to display
    private final ImageView RaceCar = new ImageView(new Image("image/car.png"));
    
    // this variable is used with the move method to determine how far the car can travel before it returns to 0
    private double currentPosition = 0;
    
    // variable for speed (x-coodinates to move each time)
    private double Speed = 10;
    
    // timeline is declared here so that it can be paused in the event handlers
    private final Timeline animation = new Timeline(
        new KeyFrame(Duration.millis(100), e -> move()));
        
    // default constructor that formats the image to a more managable size
    // and it starts the animation and runs it forever, until pauses, that is
    public CarPane() {
        RaceCar.setFitWidth(100);
        RaceCar.setPreserveRatio(true);
        getChildren().add(RaceCar);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }
    
    // moves the car across the x-axis, until it reaches the end of the x-axis which is set to 600
    public void move(){
        // ternary operator to determine if the car has exceeded the x-axis of the window
        this.currentPosition = this.currentPosition > 500 ? this.currentPosition = 0 : this.currentPosition + this.Speed;
        RaceCar.setX(this.currentPosition);
    }
    
    // pauses the animation
    public void pause(){
        this.animation.pause();
        System.out.println("Animation paused.");
    }
    
    // resumes the animation
    public void resume(){
        this.animation.play();
        System.out.println("Animation resumed.");
    }
    
    // this method increase speed without a limit
    public void faster(){
        this.Speed += 2;
        System.out.println("Speed increased. Your new speed is: " + this.Speed);
    }
    
    // this methods slows the car down unless it is already at the lowest speed, 2
    public void slower(){
        this.Speed = this.Speed <= 2 ? this.Speed = 2 : this.Speed - 2;
        if(this.Speed == 2){
            System.out.println("You are at the minimum speed: 2.0");
        } else {
            System.out.println("Speed decreased. Your new speed is: " + this.Speed);
        }
    }
}



