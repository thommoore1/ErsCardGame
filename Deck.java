import java.util.LinkedList;
import java.util.Random;
public class Deck {

    //member variable 
    private LinkedList<Card> m_cards;



//default constructor
public Deck(){
    m_cards = new LinkedList<>();
    makeDeck();
}

//copy constructor
public Deck(Deck x) {
    m_cards = new LinkedList<>();
    for (int i = 0; i<x.m_cards.size(); i++) {
m_cards.add(new Card(x.m_cards.get(i)));
    }
}

//toString 
public String toString() {
    return m_cards.toString();
}

//size method
public int size(){
    return m_cards.size();
}

//deal method
public Card deal() {
    //CHATGPT CODE PROMPT USED: how to check if an object is empty in java
    if (m_cards.isEmpty()) { //empties deck
        return null; 
        //CHATGPT CODE ENDS
    }
    //random card selection and removal from deck

    //code uses reference from "https://www.geeksforgeeks.org/generating-random-numbers-in-java/"
Random rndm= new Random();
int randomNumber = rndm.nextInt(m_cards.size());
//end of code written from example
return m_cards.remove(randomNumber);
}


//set up deck as having 52 cards total
private void makeDeck(){
        //i = suit 
    for (int i = 0; i<4; i++){
        //j = rank
        for (int j = 2; j <= 14; j++){
            m_cards.add(new Card(j,i));
            }
        }
    }
}