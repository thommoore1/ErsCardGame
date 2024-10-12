public class Card{

  //Constants for Suits
  
  public static final int HEARTS = 0;
  public static final int SPADES = 1;
  public static final int CLUBS = 2;
  public static final int DIAMONDS = 3;
  
  //Constants for Ranks for face cards
  public static final int JACK = 11;
  public static final int QUEEN = 12;
  public static final int KING = 13;
  public static final int ACE = 14;
  
  //member variables
  
  private int m_rank;
  private int m_suit;
  
  
  //default constructor for ace of spades
  
  public Card(){
  
     this.m_rank = ACE;
     this.m_suit = SPADES;
  
  
  }
  
  //overloaded constructor
  public Card(int m_rank, int m_suit) {
    setRank(m_rank);
    setSuit(m_suit);
  }
  
  //copy constructor
  
  public Card(Card x){
    this.m_rank = x.m_rank;
    this.m_rank= x.m_rank;
  }
  
  //accessors(getters)
  
  public int getRank() {
    return m_rank;
  }
  
  public int getSuit() {
  return m_suit;
  }
  
  //mutators(settors)
  
  public void setRank(int m_rank){
    this.m_rank=m_rank;
  }
  public void setSuit(int m_suit){
    this.m_suit=m_suit;
  }
  
  //toString method
  
  public String toString() {
    //System.out.println(m_rank + m_suit);
    //textually representing cards
    String[] suits = {"Hearts", "Spades", "Clubs", "Diamonds"};
    String rankString;
  
  //switch case for representing card rank of face cards textually
  if(m_rank >=2 && m_rank<=10) {
    rankString=String.valueOf(m_rank);
  } else {
    switch (m_rank) {
      case JACK:
      rankString="Jack";
      break;
      case QUEEN:
      rankString="Queen";
      break;
      case KING: 
      rankString = "King";
      break;
      case ACE:
      rankString = "Ace";
      break;
      default:
      rankString = "Invalid";
    }
  }
  //check suit is in valid range
  if (m_suit >= 0 && m_suit < suits.length) {
  
  return rankString + " of " + suits[m_suit];
  
  } else {
    return "invalid suit";
  }}
  
  
  //equals method for main
  
  public boolean equals(Card x) {
    //checks if argument is null
    if(x==null){
      return false;
    }
    return this.m_rank==x.m_rank;
    }
  }