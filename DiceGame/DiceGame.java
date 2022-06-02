/*
Josh Knopf
January 13, 2022
Dice Game
Rolls two dice and adds the results together, can be repeatable any number of times.
*/

import java.util.*;
import java.util.Random;

public class DiceGame { //Calls each of the methods
   public static void main(String[] args) {
      Intro();
      PlayGame();
      Outro();
      
   }
   public static void Intro() { //Welcomes the user to the game 
      System.out.println("Hey! Welcome to Tina's Dice Game.");
      System.out.println("Let's start!");
   }

   public static void PlayGame() { //Rolls the die, adds them together and prints the results.
      Random random = new Random();
      int diceOne = random.nextInt(6);
      int diceTwo = random.nextInt(6);
      int addDice = diceOne + diceTwo;
      
      //System.out.println(addDice);
      System.out.println("Dice 1 = " + diceOne);
      System.out.println("Dice 2 = " + diceTwo);
      System.out.println("I got " + diceOne + " and " + diceTwo);
      
      if(addDice % 2 == 0) {
         System.out.println("Evens are better than odds!");
      }
      else {
         System.out.println("Odds are still cool!");
      }
   } 
   
   public static void End() { //Asks user if they want to play again and ends once they do not.
      Scanner consol = new Scanner(System.in);
      System.out.println("Do you want to play again?");
      int numGames = 1;
      
      String input = consol.nextLine();
      while(input.equals("YES")) {
         PlayGame();
         numGames++;
         System.out.println("Do you want to play again?");
         input = consol.nextLine();
      }
      
      /* //== is not working when comparing two strings, one from user input and one from code. For some reason .equals() is able to compare them though...
      int x = consol.nextInt();
      while(x == 0) {
         PlayGame();
         System.out.println("Do you want to play again?");
         x = consol.nextInt();
      }
      */
      
      System.out.println("The number of times the dice was thrown is: " + numGames);
      System.out.println("Nice game!");
      System.out.println("Thanks for playing, come play again soon!");
   }
}