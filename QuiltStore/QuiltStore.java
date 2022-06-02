/*
Josh Knopf
January 27, 2022
Tina's Quilt Store
Designs a quilt based off of the size the user requests.
*/
import java.util.*;
public class QuiltStore {
   public static void main(String[]args) { //Code starts in main
      Scanner console = new Scanner(System.in);
      System.out.println("Welcome to Tina's Quilts! I'm glad you're here!");
      System.out.println("What size quilt would you like?");
      if (console.hasNextInt()) {
         int size = console.nextInt();
         System.out.println("Sure! Coming right up...");
         String[] quilt = {design(size, 0), design(size, 1), design(size, 2), design(size, 3), design(size, 4)};
         printQuilt(quilt);
      }
      else {
         System.out.println("Please input a number");
      }
   }
   public static String design(int sizeMod, int lineNum) { //Designs a line of the quilt based off of the size and line number.
      //Make sizeMod 1 if it's less than 1
      if (sizeMod < 1) {
         sizeMod = 1;
      }
      String line = "";
      String space = "";
      String dotOrArrow = "";
      if (lineNum == 0) {
         for (int j = 0; j < sizeMod; j++) { 
            line += "#================#";
         }
      }
      else if (lineNum == 1) {
         for (int j = 0; j < sizeMod; j++) {
            dotOrArrow += "<><>";
            space += "      ";
         }
      }
      else if (lineNum == 2) {
         for (int j = 0; j < sizeMod; j++) {
            dotOrArrow += "....";
            space += "    ";
         }
      }
      else if (lineNum == 3) {
         for (int j = 0; j < sizeMod; j++) {
            dotOrArrow += "........";
            space += "  ";
         }
      }
      else if (lineNum == 4) {
         for (int j = 0; j < sizeMod; j++) {
            dotOrArrow += "............";
         }  
      }
      //Adjustments for quilts larger than size 1
      if (sizeMod > 1 && lineNum == 1) {
         for (int i = 0; i < (sizeMod - 1); i++) {
            space += " ";
         }  
      }
      if (sizeMod > 1 && lineNum > 1) {
         for (int i = 0; i < (sizeMod - 1); i++) {
            space += "   ";
         }
      } 
      //Return the line
      if (lineNum == 0) {
         return line;
      }
      if (lineNum == 1) {
         line = space + "|" + dotOrArrow + "|";
      }
      else {
         line = space + "|<>" + dotOrArrow + "<>|";
      }
      return line;
   }
   
   public static void printQuilt(String[] quilt) { //Prints out the quilt based on the string array passed into it.
      for (int i = 0; i < 5; i++) {
         System.out.println(quilt[i]);
      }
      for (int i = 4; i >= 0; i--) {
         System.out.println(quilt[i]);
      }
   }
}