import java.util.*;
import java.util.Scanner;

public class Tutorial2B {
	public static void main(String[] args) {

    Scanner input = new Scanner(System.in); // Reading from input
    System.out.println("enter list of integers (do not leave blank)");

    String userCompleteInput = input.nextLine();
    String[] inputParts = userCompleteInput.split(" ");
   	
    if ((inputParts.length == 0) || (userCompleteInput.equals(""))) {
      System.out.println("hey! you didn't enter any integers, try again");
      return;
    }

   	if (inputParts.length != 0) {
   			int[] inputList = new int[(inputParts.length - 1)];
        int nonIntegerCount = 0;
        int integerCount = 0;
        String uniqueIntegers = "";

   			for (int i = 0; i < inputParts.length; i++) {
          try 
          {
            int num = Integer.parseInt(inputParts[i]);
            if (integerCount == 0)
            {
              inputList[integerCount] = num;
              integerCount = integerCount + 1;
              uniqueIntegers = Integer.toString(num);
            }
            else
            {
              if (isNumUnique(num, integerCount, inputList)) {
                inputList[integerCount] = num;
                integerCount = integerCount + 1;
                uniqueIntegers = uniqueIntegers + ", " + Integer.toString(num);
              }
            }  // end of else i.e. not the first integer found
          }  // end if integer is found
          catch (NumberFormatException ex)
          {
            nonIntegerCount = nonIntegerCount + 1;
          } // end of catch
   			}

        System.out.println("there are " + integerCount +" unique integers. They are: " + uniqueIntegers);
        System.out.println("there are " + nonIntegerCount +" non integers");        

   	} // end of if input string not empty

	}  // end of main

  // determine if an integer is unique
  public static boolean isNumUnique(int currentNum, int currentIntCount, int[] currentIntList) {
    boolean newUnique = false;
    for (int j = 0; j < currentIntCount; j++) {
      if (currentIntList[j] == currentNum) { //no action if integer is duplicated
        newUnique = false;
      } 

      if (j == (currentIntCount - 1)) {
        newUnique = true;
      }
    } // end of for
    
    if (newUnique) {
      return true;
    } else {
      return false;
    }

  }  // end of method isNumUnique

}  // end of class