import java.util.LinkedList;

public class Game {
  // sets up LinkedLists, member variables, dealer, and patterns.
  private LinkedList<Player> players;
  private LinkedList<Card> pile;
  private Dealer dealer;
  static String[] patterns = { "doubles", "top bottom", "sandwich" };

  // constructor for game class
  // i think everything up till play() method is good so far.

  public Game() {
    this.players = new LinkedList<>();
    this.pile = new LinkedList<>();
    this.dealer = new Dealer();
    initializeGame(2);
  }

  public Game(int numPlayers) {
    this.players = new LinkedList<>();
    this.pile = new LinkedList<>();
    this.dealer = new Dealer();
    initializeGame(numPlayers);
  }

  // sets up conditions for the beginning of the game.
  private void initializeGame(int numPlayers) {
    for (int i = 1; i <= numPlayers; i++) {
      // creates new players of type Player or every numPlayers
      players.add(new Player(i));
    }
    // goes through each player and based on how many players are in the game gives
    // each player a hand of equal size.
    for (Player player : players) {
      player.getHand().addAll(dealer.deal(52 / numPlayers));
      System.out.println("Player " + player.getPlayerNum() + ": " + player.getHand());
    }
  }

  public int play() {
    int currentPlayerIndex = 0;
    // while (players.size() > 1) {
    // while(!players.isEmpty()){
    // if(players.isEmpty()){
    // break;
    // }

    // while loop that keeps game going if there is >1 player left
    while (players.size() > 1) {
      // gets the current player based on what the currentPlayerIndex is
      if (currentPlayerIndex >= players.size()) {
        currentPlayerIndex = 0;
      }
      Player currentPlayer = players.get(currentPlayerIndex);

      // System.out.println("\nCurrent Player: " +
      // players.get(currentPlayerIndex).getPlayerNum());
      // if a player has an empty hand, they are removed from the game and continues
      // the loop

      if (currentPlayer.getHand().isEmpty()) {
        System.out.println(players + "\n");
        System.out.println("Player " + currentPlayer.getPlayerNum() + " has no cards left. Get 'em outta here!\n");
        players.remove(currentPlayer);

        continue;
      }
      // calls playCard-removes card from players hand and adds it to pile and is
      // stored at playedCard
      Card playedCard = currentPlayer.playCard();

      if (playedCard == null) {
        System.out
            .println("Player " + currentPlayer.getPlayerNum() + " has no more cards and is removed from the game!");
        players.remove(currentPlayer);
        continue;
      }

      // if a card was played, it is added to the pile.
      if (playedCard != null) {
        pile.add(playedCard);

        System.out.println("\nPlayer " + currentPlayer.getPlayerNum() + " played the " + playedCard);
        // System.out.println("Played Card: " + playedCard);
        System.out.println("Current Pile: " + pile);

        // Check for face card
        if (playedCard.getRank() >= 11 && playedCard.getRank() <= 14) {

          currentPlayerIndex = handleFaceCard(currentPlayerIndex, playedCard);
        }
        // int result = handleFaceCard(currentPlayerIndex, playedCard);
        // if(result != 0){
        // System.out.println("\n\nFAILED\n\n");
        // }
        // Check for special pattern
        if (doubles(pile) || topBottom(pile) || sandwich(pile)) {
          handlePattern(currentPlayerIndex);
        }

      }

      // Print the state of the game after each iteration
      System.out.println("End of iteration");
      System.out.println("--------------");

      // DEBUG CHECK
      // System.out.println(players);
      // System.out.println("currentPlayerIndex: " + currentPlayerIndex);
      // System.out.println("currentPlayer: " + currentPlayer);

      currentPlayerIndex = (currentPlayerIndex + 1);
      if(currentPlayerIndex >= players.size()){
        currentPlayerIndex = 0;
      }
    }

    if (players.size() == 1) {
      System.out.println("Game Over!");
      if (!players.isEmpty()) {
        System.out.println("Player " + players.get(0).getPlayerNum() + " is the winner!!!");
      }
      // players.remove(0);
      // return players.get(0).getPlayerNum();

      if (players.isEmpty()) {

        System.out.println("No winner. All players are gone :(");
        return -1;
      }
      // Move the return statement outside of the while loop
      // }

      // return players.get(0).getPlayerNum();
    }
    return players.get(0).getPlayerNum();

  }

  private int nextPlayer(int currentPlayerIndex) {
    int nextPlayerIndex = (currentPlayerIndex + 1) % players.size();
    return nextPlayerIndex;
  }

  private int handleFaceCard(int currentPlayerIndex, Card playedCard) {
    int updatedIndex = currentPlayerIndex + 1;
    int chances;
    System.out.println("handlefacecard");
    switch (playedCard.getRank()) {
      case Card.JACK:
        chances = 1;
        break;
      case Card.QUEEN:
        chances = 2;
        break;
      case Card.KING:
        chances = 3;
        break;
      case Card.ACE:
        chances = 4;
        break;
      default:
        chances = 0;
    }

    // updatedIndex++;
    if (updatedIndex >= players.size()) {
      updatedIndex = 0;
    }
    //if (updatedIndex == 0) {
    //  updatedIndex++;
    //}
        System.out.println("before while loop");
    while (chances >= 0) {
      //if (updatedIndex < players.size()) {
        Player currentPlayer = players.get(updatedIndex);
        System.out.println("after while loop");
        //

        // Player currentPlayer = players.get(updatedIndex);

        // System.out.println("\nDebug - updatedIndex: " + updatedIndex + "
        // currentPlayerIndex: " + currentPlayerIndex + " currentPlayer: " +
        // currentPlayer);
        // System.out.println(players);
        // System.out.println("\nPlayer " + currentPlayer.getPlayerNum() + ", you have "
        // + chances + " chance(s) to play a face card.");

        // Implement logic for player input to play a face card or not

        Card playedFaceCard = currentPlayer.playCard();
        if (playedFaceCard == null) {

          // System.out.println(players);
          System.out
              .println("Player " + currentPlayer.getPlayerNum() + " has no more cards and is removed from the game!");
          players.remove(currentPlayer);
          break;
        }

        //System.out.println("\nPlayer " + (currentPlayer.getPlayerNum()) + " played the " + playedFaceCard);

        //pile.add(playedFaceCard);
        //System.out.println("Current pile: " + pile);
        // System.out.println("Debug - updatedIndex: " + updatedIndex + "
        // currentPlayerIndex: " + currentPlayerIndex + " currentPlayer: " +
        // currentPlayer);

        if (playedFaceCard != null && playedFaceCard.getRank() >= 11 && playedFaceCard.getRank() <= 14) {
          // ++updatedIndex;

          // currentPlayer.playCard();
          // updatedIndex = handleFaceCard(updatedIndex,playedFaceCard);
           System.out.println("Player " + currentPlayer.getPlayerNum() + " played " + playedFaceCard);
          // PLEASE FOR THE LOVE OF GOD WORK
          
          // System.out.println("nextPlayerIndex: " +);

          updatedIndex++;
          if(updatedIndex >= players.size()){
            updatedIndex = 0;
          }
          //updatedIndex = handleFaceCard(updatedIndex, playedFaceCard);



        } 
        else if (chances == 0) {

          System.out.println("\nPlayer " + currentPlayer.getPlayerNum() + " couldn't play a face card in time!");
          // Whoever played the original face card takes the whole pile
          // System.out.println("Before pile: " + currentPlayer + "\n" +
          // currentPlayerIndex + "\n" + updatedIndex);

          //updatedIndex -= 1;
          //if (updatedIndex == -1) {
          //  updatedIndex = 0;
          //}

          players.get(updatedIndex).getHand().addAll(pile);

          System.out.println(players);
          // REMEMBER INDEX 0 = PLAYER 4, INDEX 1 = PLAYER 1,
          // when 1 loses, pile goes to 0, it should go to 4.
          // System.out.println("After pile: " + currentPlayer+ "\n" + currentPlayerIndex
          // + "\n" + updatedIndex);

          System.out.println("Player " + updatedIndex + " gets the pile.");
          pile.clear();
          // System.out.println(currentPlayerIndex);
          // pile is clearing
          // return updatedIndex;
          // return updatedIndex;
          chances--;

        }
      else {
          // System.out.println("\nPlayer " + currentPlayer.getPlayerNum() + " played " +
          // playedCard);

          // Use updatedIndex
          System.out.println("\nPlayer " + (currentPlayer.getPlayerNum()) + " has " + chances
              + " chance(s) left to play a face card.");

          System.out.println("currentPlayer2: " + currentPlayer.getPlayerNum());
          System.out.println("updatedIndex2: " + updatedIndex);
          // --updatedIndex;
          // updatedIndex = handleFaceCard(updatedIndex,playedFaceCard);

          System.out.println("currentPlayer3: " + currentPlayer.getPlayerNum());
          System.out.println("updatedIndex3: " + updatedIndex);

          chances--;

        } // --updatedIndex;
          // System.out.println(players);
        // return updatedIndex;
     // }

      // players.get(updatedIndex).getHand().addAll(pile);
      // System.out.println("Player " + updatedIndex + " gets the pile.");
      // pile.clear();
    }

    return updatedIndex;

  }

  private void handlePattern(int currentPlayerIndex) {
    for (int i = 0; i < players.size(); i++) {
      if (players.get(i).slaps(pile)) {
        players.get(i).getHand().addAll(pile);
        System.out.println("Player " + players.get(i).getPlayerNum() + " slaps the pile and gets the cards!");
        pile.clear();
      }
    }
  }

  // Static methods for patterns
  public static boolean topBottom(LinkedList<Card> pile) {
    return pile.size() >= 2 && pile.getFirst() != null && pile.getFirst().equals(pile.getLast());
  }

  public static boolean doubles(LinkedList<Card> pile) {
    if (pile.size() >= 2) {
      Card lastCard = pile.get(pile.size() - 1);
      Card secondLastCard = pile.get(pile.size() - 2);

      if (lastCard != null && secondLastCard != null && lastCard.getRank() == secondLastCard.getRank()) {
        return true;
      } // return true;
    }
    return false;
  }

  public static boolean sandwich(LinkedList<Card> pile) {
    return pile.size() >= 3 &&
        pile.getFirst() != null && pile.getLast() != null &&
        pile.getFirst().equals(pile.getLast()) &&
        pile.get(pile.size() - 2) != null &&
        pile.getFirst().getRank() == pile.get(pile.size() - 2).getRank();
  }

  // Accessor methods
  public LinkedList<Player> getPlayers() {
    return players;
  }

  public LinkedList<Card> getPile() {
    return pile;
  }

  public Dealer getDealer() {
    return dealer;
  }

  public void displayPlayerNumbers() {
    System.out.println("Player Numbers at the Beginning of the Game:");
    for (Player player : players) {
      System.out.println("Player " + player.getPlayerNum());
    }

  }

}