public class Driver {

    public static void main(String[] args) {
      Game game = new Game(4);
      int winner = game.play();
      if (winner != -1) {
        System.out.println("Player " + winner + " wins!");
      } else {
        System.out.println("Game ended with no winner.");
      }
    }
  }