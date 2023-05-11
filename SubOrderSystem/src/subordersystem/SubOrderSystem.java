/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package subordersystem;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import java.util.ArrayList;
import javafx.scene.control.CheckBox;

/**
 * Chris de Leon
 * 5/6/2023
 * CIS171
 * 
 */
public class SubOrderSystem extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        sandwich newSandwich = new sandwich();
        /* -------------------------------------------------------- */
        /* this section contains all the items for the welcome view */
        /* -------------------------------------------------------- */
        GridPane welcomePane = new GridPane();
        
        // adds spacing between the image and the buttons
        welcomePane.setVgap(10);
        
        // centers the pane item
        welcomePane.setAlignment(Pos.CENTER);
        
        // creates the two initial buttons that the user sees 
        Button btnExit = new Button("Exit");
        Button btnStart = new Button("Start");

        // adds Subway Logo
        ImageView logo = new ImageView("images/subwayLogo.jpg");
        welcomePane.setColumnSpan(logo, 4);
        
        // resizes image to fit in screen
        logo.setFitHeight(400);
        logo.setFitWidth(800); 
        
        // adds logo to pane
        welcomePane.add(logo, 0,0,3,1);
        
        // Hbox creates container for buttons
        HBox buttonBox = new HBox(10, btnExit, btnStart);
        buttonBox.setAlignment(Pos.CENTER);
        
        // adds the HBox to the pane
        welcomePane.add(buttonBox,2, 1);
        
        
        /* ---------------------------------------------------------------- */
        /* this section contains all the items for the bread selection view */
        /* ---------------------------------------------------------------- */
        GridPane breadPane = new GridPane();
        breadPane.setAlignment(Pos.CENTER);
        breadPane.setVgap(10);
        breadPane.setHgap(10);
        Label sandwichSizeText = new Label("Select sandwich size: ");
        breadPane.add(sandwichSizeText, 0, 0, 3, 1);
        
        // creates a toggle group and creates 3 different size options
        ToggleGroup sandwichSize  = new ToggleGroup();
        RadioButton fourInch = new RadioButton("4 inch");
        RadioButton sixInch = new RadioButton("6 inch");
        RadioButton twelveInch = new RadioButton("12 inch");
        
        // adds size options to toggle group
        fourInch.setToggleGroup(sandwichSize);
        sixInch.setToggleGroup(sandwichSize);
        twelveInch.setToggleGroup(sandwichSize);
        
        // adds bread options to the gridpane
        breadPane.add(fourInch, 0, 1);
        breadPane.add(sixInch, 1, 1);
        breadPane.add(twelveInch, 2, 1);
        
        Label sandwichTypeText = new Label("Select sandwich type:");
        breadPane.add(sandwichTypeText, 0, 3, 3, 1);
        
        // creates a toggle group for bread type and bread type buttons with images (formatting for images included here as well)
        ToggleGroup sandwichType = new ToggleGroup();
        
        RadioButton plain = new RadioButton("Plain");
        ImageView plainImage = new ImageView("images/breads/plain.jpg");
        plain.setGraphic(plainImage);
        
        plainImage.setFitHeight(75);
        plainImage.setFitWidth(75);
        
        
        RadioButton flat = new RadioButton("Flat");
        ImageView flatImage = new ImageView("images/breads/flatbread.jpg");
        flat.setGraphic(flatImage);
        
        flatImage.setFitHeight(75);
        flatImage.setFitWidth(75);
        
        
        RadioButton italian = new RadioButton("Italian Herb and Cheese");
        ImageView italianImage = new ImageView("images/breads/italianHerb.jpg");
        italian.setGraphic(italianImage);
        
        italianImage.setFitHeight(75);
        italianImage.setFitWidth(75);
        
        
        RadioButton whole = new RadioButton("Whole Grain");
        ImageView wholeImage = new ImageView("images/breads/wholeGrain.jpg");
        whole.setGraphic(wholeImage);
        
        wholeImage.setFitHeight(75);
        wholeImage.setFitWidth(75);
        
        
        // adds all of the below to the toggle group
        
        plain.setToggleGroup(sandwichType);
        flat.setToggleGroup(sandwichType);
        italian.setToggleGroup(sandwichType);
        whole.setToggleGroup(sandwichType);
         
        
        // adds all of the below to the gridpane
        
        breadPane.add(plain, 0, 6);
        breadPane.add(flat, 1, 6);
        breadPane.add(italian, 2, 6);
        breadPane.add(whole, 3, 6);
        
        breadPane.setGridLinesVisible(true);
        
        Button btnNext = new Button("Proceed to cheese and protein");
        breadPane.add(btnNext, 2, 7, 3, 1);
        
        /* ------------------------ */
        /* Begin cheese and protein */
        /* ------------------------ */
        
        GridPane cheeseAndProteinPane = new GridPane();
        cheeseAndProteinPane.setAlignment(Pos.CENTER);
        cheeseAndProteinPane.setVgap(10);
        cheeseAndProteinPane.setHgap(10);
        
        Label cheeseType = new Label("Select cheese: ");
        cheeseAndProteinPane.add(cheeseType, 0, 0, 4, 1);
        
        ToggleGroup cheeseGroup = new ToggleGroup();
        
        RadioButton american = new RadioButton("American Cheese");
        ImageView americanImage = new ImageView("images/cheese/american.jpg");
        american.setGraphic(americanImage);
        
        americanImage.setFitHeight(75);
        americanImage.setFitWidth(75);
        
        RadioButton pepperJack = new RadioButton("Pepper Jack Cheese");
        ImageView pepperJackImage = new ImageView("images/cheese/pepperJack.jpg");
        pepperJack.setGraphic(pepperJackImage);
        
        pepperJackImage.setFitHeight(75);
        pepperJackImage.setFitWidth(75);
        
        RadioButton provolone = new RadioButton("Provolone Cheese");
        ImageView provoloneImage = new ImageView("images/cheese/provolone.jpg");
        provolone.setGraphic(provoloneImage);
        
        provoloneImage.setFitHeight(75);
        provoloneImage.setFitWidth(75);
        
        RadioButton montereyCheddar = new RadioButton("Monterey Cheddar Cheese");
        ImageView americanImontereyCheddarImage = new ImageView("images/cheese/montereyCheddar.jpg");
        montereyCheddar.setGraphic(americanImontereyCheddarImage);
        
        americanImontereyCheddarImage.setFitHeight(75);
        americanImontereyCheddarImage.setFitWidth(75);
        
        american.setToggleGroup(cheeseGroup);
        pepperJack.setToggleGroup(cheeseGroup);
        provolone.setToggleGroup(cheeseGroup);
        montereyCheddar.setToggleGroup(cheeseGroup);
        
        cheeseAndProteinPane.add(american, 0, 3);
        cheeseAndProteinPane.add(pepperJack, 1, 3);
        cheeseAndProteinPane.add(provolone, 2, 3);
        cheeseAndProteinPane.add(montereyCheddar, 3, 3);
        
        /*****************************************************************************************************************************************/
        
        Label proteinType = new Label("Select protein: ");
        cheeseAndProteinPane.add(proteinType, 0, 7, 4, 1);
        ToggleGroup proteins = new ToggleGroup();
        
        RadioButton blackForestHam = new RadioButton("Black Forest Ham");
        blackForestHam.setToggleGroup(proteins);
        RadioButton chickenAndBaconRanch = new RadioButton("Chicken and Bacon Ranch Melt");
        chickenAndBaconRanch.setToggleGroup(proteins);
        RadioButton coldCutCombo = new RadioButton("Cold Cut Combo");
        coldCutCombo.setToggleGroup(proteins);
        RadioButton roastBeef = new RadioButton("Roast Beef");
        roastBeef.setToggleGroup(proteins);
        RadioButton spicyItalian = new RadioButton("Spicy Italian");
        spicyItalian.setToggleGroup(proteins);
        RadioButton chickenTeriyaki = new RadioButton("Chicken Teriyaki");
        chickenTeriyaki.setToggleGroup(proteins);
        RadioButton tuna = new RadioButton("Tuna");
        tuna.setToggleGroup(proteins);
        RadioButton turkeyBreast = new RadioButton("Turkey Breast");
        turkeyBreast.setToggleGroup(proteins);
        
        
        
        cheeseAndProteinPane.add(blackForestHam, 0, 9);
        cheeseAndProteinPane.add(chickenAndBaconRanch, 1, 9);
        cheeseAndProteinPane.add(coldCutCombo, 2, 9);
        cheeseAndProteinPane.add(roastBeef, 3, 9);
        cheeseAndProteinPane.add(spicyItalian, 0, 10);
        cheeseAndProteinPane.add(chickenTeriyaki, 1, 10);
        cheeseAndProteinPane.add(tuna, 2, 10);
        cheeseAndProteinPane.add(turkeyBreast, 3, 10);
        
        Button btnNext2 = new Button("Proceed to veggies and condiments");
        cheeseAndProteinPane.add(btnNext2, 0, 11, 4, 1);
        
        
       /***************************************************************************************/
        
        
        GridPane veggiesAndCondiments = new GridPane();
        veggiesAndCondiments.setAlignment(Pos.CENTER);
        veggiesAndCondiments.setVgap(10);
        veggiesAndCondiments.setHgap(10);
        
        Label veggiesText = new Label("Select up to three veggies: ");
        Label condimentText = new Label("Select any amount of condiments:");
        Label saltText = new Label("Salt and Pepper?");
        
        
        
        
        CheckBox lettuce = new CheckBox("Lettuce");
        CheckBox tomatoes = new CheckBox("Tomatoes");
        CheckBox onions = new CheckBox("Onions");
        CheckBox spinach = new CheckBox("Spinach");
        CheckBox peppers = new CheckBox("Peppers");
        CheckBox pickles = new CheckBox("Pickles");
        CheckBox avocado = new CheckBox("Avocado");
        CheckBox olives = new CheckBox("Olives");
        
        veggiesAndCondiments.add(veggiesText, 0, 0, 4, 1);
        veggiesAndCondiments.add(lettuce, 0, 1);
        veggiesAndCondiments.add(tomatoes, 1, 1);
        veggiesAndCondiments.add(onions, 2, 1);
        veggiesAndCondiments.add(spinach, 3, 1);
        veggiesAndCondiments.add(peppers, 0, 2);
        veggiesAndCondiments.add(pickles, 1, 2);
        veggiesAndCondiments.add(avocado, 2, 2);
        veggiesAndCondiments.add(olives, 3, 2);
        
        
        CheckBox mayo = new CheckBox("Mayo");
        CheckBox ketchup = new CheckBox("Ketchup");
        CheckBox mustard = new CheckBox("Mustard");
        CheckBox ranch = new CheckBox("Ranch");
        CheckBox oilAndVinegar = new CheckBox("Oil and vinegar");
        CheckBox chipotle = new CheckBox("Chipotle Southwest");
        CheckBox sweetOnionSauce = new CheckBox("Sweet Onion Sauce");
        CheckBox BBQ = new CheckBox("BBQ Sauce");
        
        veggiesAndCondiments.add(condimentText, 0, 3, 4, 1);
        veggiesAndCondiments.add(mayo, 0, 4);
        veggiesAndCondiments.add(ketchup, 1, 4);
        veggiesAndCondiments.add(mustard, 2, 4);
        veggiesAndCondiments.add(ranch, 3, 4);
        veggiesAndCondiments.add(oilAndVinegar, 0, 5);
        veggiesAndCondiments.add(chipotle, 1, 5);
        veggiesAndCondiments.add(sweetOnionSauce, 2, 5);
        veggiesAndCondiments.add(BBQ, 3, 5);
        
        ToggleGroup saltAndPepper = new ToggleGroup();
        
        RadioButton yes = new RadioButton("Yes");
        yes.setToggleGroup(saltAndPepper);
        RadioButton no = new RadioButton("No");
        no.setToggleGroup(saltAndPepper);
        
        veggiesAndCondiments.add(saltText, 0, 6, 4, 1);
        veggiesAndCondiments.add(yes, 0, 7);
        veggiesAndCondiments.add(no, 1, 7);
        
        Button btnFinish = new Button("Finish");
        veggiesAndCondiments.add(btnFinish, 0, 8);
        
        
         /*****************************************************************************************************************************************/
        
         
        GridPane summary = new GridPane();
        summary.setAlignment(Pos.CENTER);
        summary.setVgap(10);
        summary.setHgap(10);
         
        /* THIS IS WHERE YOU LEFT OFF... THE WELCOME, BREAD SIZE AND TYPE, AND CHEESE AND PROTEIN SECTION ARE COMPLETE
        Just a matter of setting up the backend connectors as well as the limiter for the veggie types*/
        
        
        
        
        
        /* --------------------------------------------------------- */
        /* contains the scenes for each part of the sandwich process */
        /* --------------------------------------------------------- */
        Scene welcome = new Scene(welcomePane, 1200, 800);
        Scene breadSelection = new Scene(breadPane, 1200, 800);
        Scene cheeseAndProtein = new Scene(cheeseAndProteinPane, 1200, 800);
        Scene veggiePage = new Scene(veggiesAndCondiments, 1200, 800);
        Scene summaryPage = new Scene(summary, 1200, 800);
        
        
        primaryStage.setTitle("Subway Ordering System");
        primaryStage.setScene(welcome);
        primaryStage.show();
        
        /* different buttons for navigation in the GUI */
        btnStart.setOnAction(e -> {
            System.out.println("Entered the bread selection page");
            primaryStage.setScene(breadSelection);
        });
        
        btnExit.setOnAction(e -> {
            System.out.println("Goodbye");
            System.exit(0);
        });
        
        btnNext.setOnAction(e -> {
            System.out.println("Queue next page");
            primaryStage.setScene(cheeseAndProtein);
        });
        
        btnNext2.setOnAction(e -> {
            System.out.println("Queue veggies and condiments");
            primaryStage.setScene(veggiePage);
        });
        
        btnFinish.setOnAction(e -> {
            System.out.println("Queue final page"); 
        });
    }
    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    public class sandwich {
        // different components of the sandwich
        private String bread, cheese, toasted;
        private ArrayList<String> protein, veggies, condiments = new ArrayList<String>();
        private boolean salt = false;
        private int size;
        
        public boolean getSalt(){
            return salt;
        }
        
        public void setSalt(boolean salt){
            this.salt = salt;
        }
        
        public void setSize(int size){
            this.size = size;
        }
        
        public int getSize(){
            return this.size;
        }
        
        public void setBread(String bread){
            this.bread = bread;
        }
        
        public void setCheese(String cheese){
            this.cheese = cheese;
        }
        
        public void setToasted(String toasted){
            this.toasted = toasted;
        }
        
        public void addProtein(String protein){
            this.protein.add(protein);
        }
        
        public void addVeggies(String veggies){
            this.veggies.add(veggies);
        }
        
        public void addCondiments(String condiments){
            this.condiments.add(condiments);
        }
        
        public String getBread(){
            return "\nbread: " + this.bread;
        }
        
        public String getCheese(){
            return "\ncheese: " + this.cheese;
        }
        
        public String getToast(){
            return "\ntoasted: " + this.toasted;
        }
        
        public String getProtein(){
            String s = "Protein:\n";
            for (int i = 0; i < protein.size(); i++){
                s += protein.get(i) + " ";
            }
            return s;
        }
        
        public String getVeggies(){
            String s = "Veggies:\n";
            for (int i = 0; i < veggies.size(); i++){
                s += veggies.get(i) + " ";
            }
            return s;
        }
        
        public String getCondiments(){
            String s = "Condiments:\n";
            for (int i = 0; i < condiments.size(); i++){
                s += condiments.get(i) + " ";
            }
            return s;
        }
        
        public String displaySandwich(){
            String s = "Here is your summary\n****************\n Sandwich size: " + this.size + "\n";
            return s + getBread() + getCheese() + getToast() + getProtein() + getVeggies() + getCondiments();
        }
    }
    
}
