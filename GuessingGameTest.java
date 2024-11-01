// CSE 142 HW 5
// Aza Mohr

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class GuessingGameTest {
    
  @Test
  void round1() {
    assertEquals(3.4, GuessingGame.round1(3.4449)); // rounding
    assertEquals(3.5, GuessingGame.round1(3.45));  // rounding with 5, should round up 
    assertEquals(3.0, GuessingGame.round1(3));  // should add 0 to integers
    assertEquals(4.0, GuessingGame.round1(3.99));  // round up to 1s place
    assertEquals(3.1, GuessingGame.round1(3.08));  // round up to 10ths place
    assertEquals(3.0, GuessingGame.round1(3.03));  // round down to 10ths place
  }

  @Test
  void compileOverallResults() {
    GuessingGame.totalGames = 5;
    GuessingGame.totalGuesses = 18;
    GuessingGame.bestGame = 2;

    assertEquals("Overall results:\n" + //
            "total games = 5\n" + //
            "total guesses = 18\n" + //
            "guesses/game = 3.6\n" + //
            "best game = 2", GuessingGame.compileOverallResults());
  }

  @Test
  void compileResults() {
    GuessingGame.totalGuesses = 7;
    GuessingGame.bestGame = 3;
    assertEquals("You got it right in 5 guesses", GuessingGame.compileResults(5));
    assertEquals(12, GuessingGame.totalGuesses);
    assertEquals(3, GuessingGame.bestGame);
    assertEquals("You got it right in 1 guess", GuessingGame.compileResults(1));
    assertEquals(13, GuessingGame.totalGuesses);
    assertEquals(1, GuessingGame.bestGame);
  }


  // private static String compileResults(int count) {
  //   totalGuesses += count;
  //   if (count < bestGame) bestGame = count;
  //   return("You got it right in " + count + " guess" + (count == 1?"":"es"));
  // }

}
