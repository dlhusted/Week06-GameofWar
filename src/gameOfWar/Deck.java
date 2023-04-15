package gameOfWar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck {
  
//------------FIELDS----------------------------------------- 
//---New List of Card - named cards  
  private List<Card> cards = new ArrayList<Card>();
  
//------------CONTSTRUCTOR-----------------------------------
  /*
   * create an array for each suit
   * create an array of number strings for each suit
   *   each suit in the 4 suits 
   *    gets a number from the array
   *    counter start at 2 and equals the int value of each card as well
   *        Create a new card
   *            and add that card to the List of cards (the deck) with the (number, suit, and count (value)
   *                increment up one at a time from 2 for the value until reach 14 (Ace value) 
   *    repeat for each suit until the deck is a List of Card full of cards in each suit            
   *                
   */
  public Deck(){
    String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    String[] numbers = {"2", "3", "4", "5", "6", "7", "8", 
                        "9", "10", "Jack", "Queen", "King", "Ace"};
    for(String suit : suits) {
      int count = 2;
      for(String number : numbers) {
        Card card = new Card(number, suit, count);
        this.cards.add(card);
        count++;
      }
    }
  }
 
  
  
  
//-----------METHODS-----------------------------------------  
  public void describe() {
    for(Card card : this.cards) {
      card.describe();
    }
  }
  
  public void shuffle() {
    Collections.shuffle(this.cards);
  }
  
  public Card draw() {
    Card card = this.cards.remove(0);
    return card;
  }

}
