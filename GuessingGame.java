// CSE 142 HW 5
// Aza Mohr
import java.util.Scanner;

public class GuessingGame {

  static Scanner scan;

  static int totalGames;
  static int totalGuesses;
  static int bestGame;

  public static void main(String[] args) {
    scan = new Scanner(System.in);
    int max = 10;

    totalGames = 0;
    totalGuesses = 0;
    bestGame = 0;
    
    introduction(max);
   
    do {
      int count = playGame(max);
      printOutput(compileResults(count));
    } while (askToPlayAgain());
    printOutput(compileOverallResults());

  }

  protected static void introduction(int max) {
    System.out.print("This program allows you to play a guessing game.\n"
                      + "I will think of a number between 1 and\n"
                      + max + " and will allow you to guess until\n"
                      + "you get it. For each guess, I will tell you\n"
                      + "whether the right answer is higher or lower\n"
                      + "than your guess.\n");
  }

  protected static int playGame(int max) {
    totalGames++;
    // Choose a random number from 1 to max
    int number = (int) (Math.random() * max + 1);
    int count = 0;

    // Ask the user to guess a number from 1 to max
    // Get the first guess using scan.nextInt();

    System.out.print("\nI'm thinking of a number between 1 and " + max + "...");
    
    boolean keepPlaying = true;
    while(keepPlaying) {
      System.out.print("\nYour guess? ");
      int guess = scan.nextInt();
      if (guess < number && guess >= 1) {
        System.out.print("It's higher.");
        count++;
      } else if (guess > number && guess <= max) {
        System.out.print("It's lower.");
        count++;
      } else if (guess == number) {
        count++;
        keepPlaying = false;
      } else { // Guess is not in 1-max range. Count is not increased.
        System.out.print("Invalid number! Guess must be between 1 and " + max + ". Try again!\n");
      }
    }

    return count;

  }

  protected static String compileResults(int count) {
    totalGuesses += count;
    if (count < bestGame) bestGame = count;
    return("You got it right in " + count + " guess" + (count == 1?"":"es"));
  }

  protected static boolean askToPlayAgain() {
    System.out.print("\nDo you want to play again? ");
    String input = scan.nextLine();
    String firstLetter = input.substring(0,1).toLowerCase();
    if (firstLetter.equals("y")) {
      return true;
    } else {
      return false;
    }

  }
  
  static void printOutput(String input) {
  System.out.print(input);
  }

  static String compileOverallResults() {
    double guesssesPerGame = round1(1.0 * totalGuesses / totalGames);
    
    return("Overall results:"
    + "\ntotal games = " + totalGames
    + "\ntotal guesses = " + totalGuesses
    + "\nguesses/game = " + guesssesPerGame
    + "\nbest game = " + bestGame);
  }

  static double round1 (double input) {
    return Math.round(input * 10) / 10.0;
  }



}