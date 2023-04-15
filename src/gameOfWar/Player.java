package gameOfWar;

import java.util.ArrayList;
import java.util.List;

public class Player {
  
  //------------FIELDS-----------------------------------------
  private List<Card> hand = new ArrayList<>();
  private int score;
  private String name;
  
  
  //------------CONTSTRUCTOR-----------------------------------------
  public Player(String name, int score) {
    this.name = name;
    this.score = 0; 



    
    
    }
  
  //------------METHODS-----------------------------------------
  
  public void describe() {
    System.out.println("Player: " + name + " has a score of: " + score + " and their hand is: "); 
  }
  
  /*
   * this will be the method used to add points to that players score who has the higher value card
   */
  
  public void incrementScore() {
    score++;
  }
  

  
  // -----------GETTERS AND SETTERS----------------------------

  public List<Card> getHand() {
    return hand;
  }

  public void setHand(List<Card> hand) {
    this.hand = hand;
  }
  
  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  
  
  
  
  

}
