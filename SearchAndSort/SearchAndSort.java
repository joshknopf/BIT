/*
Josh Knopf
March 1st, 2022
Search and Sort
Sorts an array and finds a user requested number based on the type of search the user requests.
*/
import java.util.*;

public class SearchAndSort {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      int index = -1;
      
      System.out.println("Hello! Welcome to my Searching and Sorting Algorithm!\n\nWhat searching / sort method would you like to use?");
      String searchType = scan.nextLine();
      if (searchType.equals("Binary Search") || searchType.equals("Linear Search") || searchType.equals("Jump Search")) {
         System.out.println("How many number do you have?");
         int num = scan.nextInt();
         int[] numArray = new int[num];
         for (int i = 0; i < num; i++) {
            System.out.println("Please enter a number: ");
            numArray[i] = scan.nextInt();
         }
         System.out.println("What number are you looking for?");
         int searchNum = scan.nextInt();
         if (searchType.equals("Binary Search")) {
            index = binarySearch(bubbleSort(numArray), searchNum);
         }
         else if (searchType.equals("Linear Search")) {
            index = linearSearch(bubbleSort(numArray), searchNum);
         }
         else {
            index = jumpSearch(cycleSort(numArray), searchNum);
         }
         if (index >= 0) {
            System.out.println("The element you are looking for is at index " + index);
         }
         else {
            System.out.println("The element you are looking for is not in this list.");
         }
      }
      else {
         System.out.println("Please enter 'Binary Search' or 'Linear Search or 'Jump Search'");
      }
   }
   
   public static int binarySearch(int[] arr, int searchNum) { //Continuously splits the array in half while looking for the number provided
      int low = 0;
      int high = arr.length - 1;
      while (low <= high) {
         int mid = low + ((high - low) / 2);
         if (searchNum > arr[mid]) {
            low = mid + 1;
         }
         else if (searchNum < arr[mid]) {
            high = mid - 1;
         }
         else if (searchNum == arr[mid]) {
            return mid;
         }
      }
      return -1;
   }
   
   public static int linearSearch(int[] arr, int searchNum) { //Looks through each number in the array lowest to highest to find the number provided
      for (int i = 0; i < arr.length - 1; i++) {
         if (arr[i] == searchNum) {
            return i;
         }
      }
      return -1;
   }
   
   public static int jumpSearch(int[] arr, int searchNum) { //Jumps through the array in chunks looking for the number provided.
      int step = (int)Math.floor(Math.sqrt(arr.length));
      int index = 0;
      while (index < arr.length) {
         index += step;
         if (index > arr.length - 1) {
            index = arr.length - 1;
         }
         if (arr[index] >= searchNum) {
            for (int i = step; i >= 0; i--) {
               if (arr[index - i] == searchNum) {
                  return (index - i);
               }
            } 
            return -1;
         }
      }
      return -1;
   }
   
   public static int[] bubbleSort(int[] arr) { //Sorts the array by swapping numbers that are next to each other.
      int lengthMinusOne = arr.length - 1;
      for (int i = 0; i < lengthMinusOne; i++) {
         for (int j = 0; j < lengthMinusOne - i; j++) {
            if (arr[j] > arr[j + 1]) {
               int temp = arr[j];
               arr[j] = arr[j + 1];
               arr[j + 1] = temp;
            }
         }
      }
      return arr;
   }
   
   public static int[] cycleSort(int[] arr) { //Sorts the array by initially finding the correct spot for the number and placing it there.
      int element = 0;
      int pos = 0;
      int temp = 0; 
   
      for (int i = 0; i <= arr.length - 2; i++) {
         element = arr[i];
         pos = i;
         for (int j = i + 1; j < arr.length; j++) {
            if (arr[j] < element) {
               pos++;
            }
         }
         if (pos == i) {
            continue;
         }
         while (element == arr[pos]) {
            pos += 1;
         }
         if (pos != i) {
            temp = element;
            element = arr[pos];
            arr[pos] = temp;
         }
         while (pos != i) {
            pos = i;
            for (int j = i + 1; j < arr.length; j++) {
               if (arr[j] < element)
                  pos += 1;
            }
            while (element == arr[pos]) {
               pos += 1;
            }
            if (element != arr[pos]) {
               temp = element;
               element = arr[pos];
               arr[pos] = temp;
            }
         }
      }
      printArray(arr);
      return arr;
   }
   
   public static void printArray(int[] x) { //prints out the array
      for (int i = 0; i < x.length; i++) {
         System.out.println(x[i]);
      }
   }
}