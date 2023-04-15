package gameOfWar;

public class Card {
  
  
  //------------FIELDS-----------------------------------------
  private String name;
  private String suit;
  private int value;
  
  
  //------------CONSTRUCTOR------------------------------------
  public Card(String name, String suit, int value) {
    this.setName(name);
    this.setSuit(suit);
    this.setValue(value); 
    }
  
  
  //------------METHODS----------------------------------------
  public String describe() {
    String cardDescript = this.name + " of " + this.suit + " = Value of " + this.value;
    return cardDescript;
  }
 
  
  
  // -----------GETTERS AND SETTERS----------------------------
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getValue() {
    return value;
  }
  
  public void setValue(int value) {
    this.value = value;
  }


  public String getSuit() {
    return suit;
  }


  public void setSuit(String suit) {
    this.suit = suit;
  }

}
