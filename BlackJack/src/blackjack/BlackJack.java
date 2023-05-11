package blackjack;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

/**
 * Chris de Leon 5/9/2023 CIS171 Final Project - Black Jack
 */
public class BlackJack extends Application {

    // game instance
    Game game = new Game();

    @Override
    public void start(Stage primaryStage) {

        // deals the two initial cards on start
        game.dealInitialCards();

        // displays the each player's score on GUI 
        String playerOneScore = "Player one score (left): " + game.playerOne.getScore();
        String playerTwoScore = "Player two score (right): " + game.playerTwo.getScore();

        // informational display for gameplay, including buttons
        GridPane controlsDisplay = new GridPane();
        controlsDisplay.setHgap(10); // padding
        controlsDisplay.setVgap(10); // padding
        controlsDisplay.setAlignment(Pos.CENTER);
        Button btnHit = new Button("Hit");
        Button btnStand = new Button("Stand");
        Button btnExit = new Button("Exit");
        StackPane centerExitButton = new StackPane(); // stackpane is implemented here to get the exit button centered
        centerExitButton.getChildren().add(btnExit);
        centerExitButton.setAlignment(Pos.CENTER);
        Button btnShuffle = new Button("Shuffle"); // stackpane is also implemented here to get the shuffle button centered
        StackPane centerShuffleButton = new StackPane();
        centerShuffleButton.getChildren().add(btnShuffle);
        centerShuffleButton.setAlignment(Pos.CENTER);
        Label playerOneScoreDisplay = new Label(playerOneScore);
        Label playerTwoScoreDisplay = new Label(playerTwoScore);
        Label lastAction = new Label("Last action: "); // displays the last thing that occurred in the gameplay
        Label winnerDisplay = new Label("Winner:"); // dynamically updates to show the last winner

        // adds all the buttons and information to the display
        controlsDisplay.add(playerOneScoreDisplay, 0, 0, 2, 1);
        controlsDisplay.add(playerTwoScoreDisplay, 0, 1, 2, 1);
        controlsDisplay.add(btnStand, 0, 2);
        controlsDisplay.add(btnHit, 1, 2);
        controlsDisplay.add(centerShuffleButton, 0, 4, 2, 1);
        controlsDisplay.add(centerExitButton, 0, 5, 2, 1);
        controlsDisplay.add(lastAction, 0, 6, 2, 1);
        controlsDisplay.add(winnerDisplay, 0, 7, 2, 1);

        // player one's side of the screen
        HBox playerOneDisplay = new HBox(10); // spacing between each card
        playerOneDisplay.setPadding(new Insets(0, 0, 0, 150)); // padding on the left side of player one's display
        playerOneDisplay.setAlignment(Pos.CENTER_LEFT);

        // ImageView playerOneHolderCard = new ImageView(new Image(game.playerOne.getSpecificCardImagePath(0)));
        // player two's side of the screen
        HBox playerTwoDisplay = new HBox(10); // spacing between each card
        playerTwoDisplay.setPadding(new Insets(0, 150, 0, 0)); // padding on the right side of player two's display
        playerTwoDisplay.setAlignment(Pos.CENTER_RIGHT);

        // you will see these for-loops throughout the code
        // it is responsible for accessing the size of each player's hand and loading 
        // the proper images according to their rank and suit
        for (int i = 0; i < game.playerOne.hand.size(); i++) {
            ImageView newImage = new ImageView(game.playerOne.getSpecificCardImagePath(i));
            playerOneDisplay.getChildren().add(newImage);
        }
        for (int i = 0; i < game.playerTwo.hand.size(); i++) {
            ImageView newImage = new ImageView(game.playerTwo.getSpecificCardImagePath(i));
            playerTwoDisplay.getChildren().add(newImage);
        }

        // the three different components of the screen are contained within a border pane
        // player one is on the left
        // the informational display is in the center
        // player two is on the right
        BorderPane pane = new BorderPane();
        pane.setLeft(playerOneDisplay);
        pane.setRight(playerTwoDisplay);
        pane.setCenter(controlsDisplay);

        // note, if the width of the screen is adjusted, the padding for the player displays will have to be adjusted too
        Scene scene = new Scene(pane, 1200, 400);
        primaryStage.setTitle("Black Jack");
        primaryStage.setScene(scene);
        primaryStage.show();

        // stand button calls a few methods as well as refreshes cards on the display
        btnStand.setOnAction(e -> {
            game.playerStand();
            game.tracker();
            playerOneScoreDisplay.setText("Player one score (left): " + game.playerOne.getScore());
            playerTwoScoreDisplay.setText("Player two score (right): " + game.playerTwo.getScore());
            if (game.getTurnCounter() % 2 == 0) {
                lastAction.setText("Last action: player two stood");
            } else {
                lastAction.setText("Last action: player one stood");
            }
            if (game.getWinner() != null) {
                winnerDisplay.setText("Winner: " + game.getWinner());
            }

            playerOneDisplay.getChildren().clear();
            playerTwoDisplay.getChildren().clear();

            for (int i = 0; i < game.playerOne.hand.size(); i++) {
                ImageView newImage = new ImageView(game.playerOne.getSpecificCardImagePath(i));
                playerOneDisplay.getChildren().add(newImage);
            }

            for (int i = 0; i < game.playerTwo.hand.size(); i++) {
                ImageView newImage = new ImageView(game.playerTwo.getSpecificCardImagePath(i));
                playerTwoDisplay.getChildren().add(newImage);
            }
        });

        // hit button calls a few methods and also refreshes the cards on the display
        btnHit.setOnAction(e -> {
            game.playerHit();
            game.tracker();
            playerOneDisplay.getChildren().clear();
            playerTwoDisplay.getChildren().clear();

            for (int i = 0; i < game.playerOne.hand.size(); i++) {
                ImageView newImage = new ImageView(game.playerOne.getSpecificCardImagePath(i));
                playerOneDisplay.getChildren().add(newImage);
            }

            for (int i = 0; i < game.playerTwo.hand.size(); i++) {
                ImageView newImage = new ImageView(game.playerTwo.getSpecificCardImagePath(i));
                playerTwoDisplay.getChildren().add(newImage);
            }

            playerOneScoreDisplay.setText("Player one score (left): " + game.playerOne.getScore());
            playerTwoScoreDisplay.setText("Player two score (right): " + game.playerTwo.getScore());
            if (game.getTurnCounter() % 2 == 0) {
                lastAction.setText("Last action: player two hit");
            } else {
                lastAction.setText("Last action: player one hit");
            }
            if (game.getWinner() != null) {
                winnerDisplay.setText("Winner: " + game.getWinner());
            }

        });

        // exit button exits game
        btnExit.setOnAction(e -> {
            game.endGame();
        });

        // shuffles the deck if a player wants to shuffle the deck because they feel like they're being cheated
        btnShuffle.setOnAction(e -> {
            game.deck.shuffle();
            playerOneScoreDisplay.setText("Player one score (left): " + game.playerOne.getScore());
            playerTwoScoreDisplay.setText("Player two score (right): " + game.playerTwo.getScore());
            lastAction.setText("Last action: shuffle");
        });

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    // each card is its own object so that it can store its own micro-information
    public class Card {

        private String suit;
        private String rank;
        // image path has a method that grabs the suit and rank and matches the corresponding image
        private String imagePath;

        // constructor for cards
        public Card(String suit, String rank, String imagePath) {
            this.suit = suit;
            this.rank = rank;
            this.imagePath = imagePath;
        }

        public String getSuit() {
            return this.suit;
        }

        public void setSuit(String suit) {
            this.suit = suit;
        }

        public String getRank() {
            return this.rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        // is used to retrieve the cards according to their name
        // I named each image as suit + rank so that it would be easier to implement this
        public String getImagePath() {
            return "images/" + this.imagePath + ".png";
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }
    }

    // the deck class is an array list of Card objects
    public class Deck {

        private ArrayList<Card> cardDeck;

        public ArrayList<Card> getDeck() {
            return cardDeck;
        }

        // this method draws cards by removing the first card in the shuffled deck
        // if there is no card, it will return null and the game would end
        public Card drawCard() {
            if (cardDeck.isEmpty()) {
                System.out.println("Deck is empty. Game is over!");
                return null;
            }
            Card drawnCard = cardDeck.remove(0);
            return drawnCard;
        }

        // constructor for a new deck along with its own cards
        public Deck() {
            cardDeck = new ArrayList<Card>(); // array list that holds all the card objects
            String[] suits = {"Spades", "Hearts", "Diamonds", "Clubs"};
            String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

            // these nested for loops do the following:
            // the outer loop iterates through each suit
            // the inner loop iterates through each rank
            // within the inner loop, the cards constructor is called and a new card is created
            // and then the card object is added to the card deck
            for (int i = 0; i < suits.length; i++) {
                for (int j = 0; j < ranks.length; j++) {
                    String s = suits[i] + " " + ranks[j];
                    Card card = new Card(suits[i], ranks[j], s);
                    cardDeck.add(card);
                }
            }
            System.out.println("Card deck created");
        }

        // Fisher-Yates style shuffle
        public void shuffle() {
            for (int i = 0; i < cardDeck.size(); i++) {
                int index = (int) (Math.random() * cardDeck.size()); // generates a random number within the deck parameters
                Card temp = cardDeck.get(i); // creates a temporary card to hold the card at the for loops current iteration 
                // the current card and the random index swap places
                cardDeck.set(i, cardDeck.get(index));
                cardDeck.set(index, temp);
            }
            System.out.println("Card deck shuffled");
        }
    }

    // class for player name and corresponding hand
    public class Player {

        private String playerName;
        private ArrayList<Card> hand = new ArrayList<Card>(); // keeps track of the players' hands
        private int score = 0; // keeps track of the players' scores
        private boolean stand = false; // if a player stands one round, they aren't able to hit the following rounds 

        public boolean getStand() {
            return this.stand;
        }

        public void setStand(boolean stand) {
            this.stand = stand;
        }

        public int getScore() {
            return this.score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        // constructor
        public Player(String playerName) {
            this.playerName = playerName;
        }

        public String getPlayerName() {
            return playerName;
        }

        public void setPlayerName(String name) {
            this.playerName = name;
        }

        public ArrayList getHand() {
            return hand;
        }

        // prints the player's name and cards (rank only)
        public String toString() {
            String s = this.playerName + " card values: ";
            for (int i = 0; i < getHand().size(); i++) {
                s += " " + getSpecificCardValue(i);
            }
            return s;
        }

        public String getSpecificCardValue(int index) {
            return hand.get(index).getRank();
        }

        public String getSpecificCardImagePath(int index) {
            return hand.get(index).getImagePath();
        }

        // adds card to player's hand
        public void addCard(Card card) {
            hand.add(card);
        }

        // returns the player's hand value
        public int getHandValue() {
            int value = 0;
            int aces = 0;

            for (int i = 0; i < hand.size(); i++) {

                // this logic determines the number to add to the value of the players' hand. 
                // further on in the code, you will see logic that allows an ace to be a 1 or an 11
                // a card of jack, queen, or king rank will always have a value of 10.
                if (hand.get(i).getRank().equals("Ace")) {
                    aces++;
                } else if (hand.get(i).getRank().equals("Jack")
                        || hand.get(i).getRank().equals("Queen")
                        || hand.get(i).getRank().equals("King")) {
                    value += 10;
                } else {
                    value += Integer.parseInt(hand.get(i).getRank());
                }
            }

            // this for loop is used to determine if an ace will be a 1 or an 11. This always
            // works in favor of the player because it automatically detects whether or not the player busted.
            for (int i = 0; i < aces; i++) {
                if (value + 11 <= 21) {
                    value += 11;
                } else {
                    value += 1;
                }
            }
            return value;
        }
    }

    // the game class contains all the logic pertaining to the game
    // e.g turns, player-actions, comparisons for winners, etc.
    public class Game {

        Player playerOne = new Player("Player one");
        Player playerTwo = new Player("Player two");
        Deck deck = new Deck(); // instantiates a deck object
        private int turnCounter = 0;
        private String winner = null; // used for detection in a winner

        // constructor
        public Game() {
            deck.shuffle(); // note, the game by default gives the users a shuffled deck
            System.out.println("Game ready");
        }

        public String getWinner() {
            return winner;
        }

        public void setWinner(String winner) {
            this.winner = winner;
        }

        // this would be the "start game" button in the GUI which gives each player two starting cards
        public void dealInitialCards() {
            playerOne.addCard(deck.drawCard());
            playerTwo.addCard(deck.drawCard());
            playerOne.addCard(deck.drawCard());
            playerTwo.addCard(deck.drawCard());
            System.out.println(playerOne.toString()); // prints the first player's hand
            System.out.println(playerTwo.toString()); // prints the second player's hand
        }

        // this method tracks for if two players are standing
        // if they are, the check winner method is called
        public void tracker() {
            if (playerOne.stand && playerTwo.stand) {
                checkWinner();
            }
        }

        // method clears the hands of both players
        public void clearHands() {
            playerOne.hand.clear();
            playerTwo.hand.clear();
            playerOne.setStand(false);
            playerTwo.setStand(false);
        }

        // used for determining the turn
        public int getTurnCounter() {
            return turnCounter;
        }

        // each player's turn is determined by a counter
        // this method is for when a player wants to draw a card
        // it always detects whether or not a player has decided to stand
        // note, once a player stands, they are not allowed to hit again
        public void playerHit() {
            if (turnCounter % 2 == 0 && playerOne.getStand() != true) {
                System.out.println("Player one hits");
                playerOne.addCard(deck.drawCard());
                System.out.println(playerOne.toString());
            } else if (playerTwo.getStand() != true) {
                System.out.println("Player two hits");
                playerTwo.addCard(deck.drawCard());
                System.out.println(playerTwo.toString());
            }
            turnCounter++;
        }

        // this method is for when a player does not want to draw a car
        public void playerStand() {
            if (turnCounter % 2 == 0) {
                System.out.println("Player one stands");
                playerOne.setStand(true);
            } else {
                System.out.println("Player two stands");
                playerTwo.setStand(true);
            }
            turnCounter++;
        }

        // logic to check for a winner and give points to the winner
        // after the winner is determined, the players are dealt two new cards
        public void checkWinner() {
            int playerOneValue = playerOne.getHandValue();
            int playerTwoValue = playerTwo.getHandValue();

            if (playerOneValue > 21 && playerTwoValue > 21) {
                System.out.println("Both players busted!");
                setWinner("Both players busted");
            } else if (playerOneValue > 21) {
                System.out.println("Player One Busted!");
                playerTwo.setScore(playerTwo.getScore() + 1);
                setWinner(playerTwoWinner());
            } else if (playerTwoValue > 21) {
                System.out.println("Player Two busted!");
                playerOne.setScore(playerOne.getScore() + 1);
                setWinner(playerOneWinner());
            } else if (playerOneValue == playerTwoValue) {
                System.out.println("Draw!");
                setWinner("Draw");
            } else if (playerOneValue > playerTwoValue) {
                System.out.println("Player One wins!");
                playerOne.setScore(playerOne.getScore() + 1);
                setWinner(playerOneWinner());
            } else if (playerTwoValue > playerOneValue) {
                System.out.println("Player Two wins!");
                playerTwo.setScore(playerTwo.getScore() + 1);
                setWinner(playerTwoWinner());
            } else {
                System.out.println("Error in logic");
            }
            clearHands();
            dealInitialCards();
        }

        public String playerOneWinner() {
            return playerOne.getPlayerName();
        }

        public String playerTwoWinner() {
            return playerTwo.getPlayerName();
        }

        // end game logic
        public void endGame() {
            System.out.println("Game Over!");
            System.out.println("Player One Score: " + playerOne.getScore());
            System.out.println("Player Two Score: " + playerTwo.getScore());
            System.exit(0);
        }
    }
}
