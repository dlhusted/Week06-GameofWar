package gameOfWar;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class App {

  public static void main(String[] args) {
    

    /*
     * Main method steps:
     *  - Instantiate a new Map<Player, List<Card> and call createGame() method to fill it
     *  - call printOutHands method on the newGame Map
     *  - call flip() method on the top card of each List<Card> hand which prints out the card describe() for each player
     *  - 
     *  
     */
    
    Map<Player, List<Card>> newGame = createGame();
  //  printOutHands(newGame); //uncomment out to show the two hands before they're played
    for(int i = 1; i <= 26; i++) {
    System.out.println("-----------");
    System.out.println("Round: " + i);
    System.out.println("-----------");
    flip(newGame);
    }
    compareScore(newGame);
    
    

  }
  


  
  /*
   * createGame method:
   *    - Instantiates a new map that has Player, and List<Card> as the key value pairs
   *    - instantiates a new Deck
   *    - instantiates 2 new Player
   *    - prints that the deck has 52 cards
   *    - calls the shuffles method on the new Deck
   *    - Instantiates 2 new List<Card> for each players hand
   *    - .puts() the new Player key and List<Card> value into the newGame
   *    
   *    - for 26 iterations
   *    - - for each player (aka key in the Map)
   *        - .add() a new card to each List<Card> hand, by calling the draw method on the newDeck
   *    - prints out "all cards dealt"
   *    - returns the newGame in the form of a Map<Player, List<Card>>  
   */
  public static Map<Player, List<Card>> createGame(){
    Map<Player, List<Card>> newGame = new HashMap<>();
    Deck newDeck = new Deck();
    Player p1 = new Player("Player 1", 0);
    Player p2 = new Player("Player 2", 0);
    System.out.println("The deck has 52 Cards!");
    newDeck.shuffle();
    List<Card> p1Hand = new ArrayList<Card>();
    List<Card> p2Hand = new ArrayList<Card>();
    newGame.put(p2, p2Hand);
    newGame.put(p1, p1Hand);
    for(int i = 0; i <= 25; i++) {
    for(Player key : newGame.keySet()) {
       newGame.get(key).add(newDeck.draw());
        }
      }
    System.out.println("All cards have been dealt!");
    System.out.println("---------------------------");  
    return newGame;
  }
  
  
  /*
   * printOutHands method:
   *    - prints divider for clarity
   *    - for each Player (key in the given Map)
   *        - print "Player name:" and "cards in hand: "
   *        - and print divider for clarity. the cards will be listed under the underline
   *       - - for each card in the List<Card> hand
   *            - call the describe() method on each card (print out info for each card)
   */
  public static void printOutHands(Map<Player, List<Card>> newGame) {
    System.out.println("-------------------------------------------");
    for(Player key : newGame.keySet()) {
      System.out.println();
      System.out.println(key.getName());
      List<Card> hand = newGame.get(key);
      System.out.println("Cards in hand: ");
      System.out.println("-------------------------------------------");
      for(Card card: hand) {
        System.out.println(card.describe());
      }
    }  
  }
  
  
  
  
  /*
   * flip method:
   *  - takes the map called newGame
   *  - declares Player 1 and Player 2 variables as null so we can add to them when the score increments
   *  --for each player (key) in the newGame keyset
   *    --if the key name is equal to the string "Player 1"  then p1 is equal to that key
   *        -- else if the key name is equal to the string "player 2" then p2 is equal to that key
   *        (this is so we can reference each key in this method, so we can get each of their respective
   *        values aka their hands of cards)
   *  -declare each List of Card as p1 or p2 hands
   *  -then get the top card of each of their decks and remove it
   *  - print out each players card using the describe method in the Card class
   *  - then compare and declare the winner of each round
   *  --if player 1 card value is greater than player 2, then player one wins and we call the
   *    increment score method (adding one to their score)
   *    -- else if vice versa for player 2
   */

  public static void flip(Map<Player, List<Card>> newGame) {
    Player p1 = null;
    Player p2 = null;
    for(Player key : newGame.keySet()) {
      if(key.getName().equals("Player 1")) {
        p1 = key;
      } else if(key.getName().equals("Player 2")) {
        p2 = key;
      }
    }
    List<Card> p1Hand = newGame.get(p1);
    List<Card> p2Hand = newGame.get(p2);
    Card topCard1 = p2Hand.remove(0);
    Card topCard2 = p1Hand.remove(0);
    System.out.println("Player 1");
    System.out.println("Top Card: " + topCard1.describe());
    System.out.println();
    System.out.println("Player 2");
    System.out.println("Top Card: " + topCard2.describe());
    System.out.println();
    if(topCard1.getValue() > topCard2.getValue()) {
      System.out.println("Player 1 wins round!");
      p1.incrementScore();
    } else if (topCard1.getValue() < topCard2.getValue()) {
      System.out.println("Player 2 wins round!");
      p2.incrementScore();
    } else {
      System.out.println("Card values are equal! No points this round!");
    }
  }
  
  
  
  
  /*
   * compareScore Method
   * - declares usable keys for the map to identify player 1 and player 2
   * - print out each players total score after game is played
   * - declares a winner variable as an empty string
   * - if p1 score is greater than p2 then winner equals p1
   * - if p2 score is greater, then vice versa
   * - if theyre equal, print out the winner is draw
   */

public static void compareScore(Map<Player, List<Card>> newGame) {
  Player p1 = null;
  Player p2 = null;
  for(Player key : newGame.keySet()) {
    if(key.getName().equals("Player 1")) {
      p1 = key;
    } else if(key.getName().equals("Player 2")) {
      p2 = key;
    }
  }
  System.out.println("------------------------------");
  System.out.println("------------------------------");
  System.out.println("Player 1 Score: " + p1.getScore());

  System.out.println("Player 2 Score: " + p2.getScore());
  String winner = "";
  if(p1.getScore() > p2.getScore()) {
    winner = "Player 1";
  } else if (p2.getScore() > p1.getScore()) {
    winner = "Player 2";
  } else {
    winner = "Draw!";
  }
  System.out.println("The Winner is: " + winner); 
}
  
  
  
  

  
  

}
