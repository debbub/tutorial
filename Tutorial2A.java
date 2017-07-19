import java.util.*;
import java.util.Scanner;

public class Tutorial2A {
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
              for (int j = 0; j < integerCount; j++) {
                if (inputList[j] == num) { //no action if integer is duplicated
                  break;
                }
                
                if (j == (integerCount - 1)) {
                  inputList[integerCount] = num;
                  integerCount = integerCount + 1;
                  uniqueIntegers = uniqueIntegers + ", " + Integer.toString(num);
                }
              } // end for checking through current unique integer list
            }
          }
          catch (NumberFormatException ex)
          {
            nonIntegerCount = nonIntegerCount + 1;
          }
   			}
        System.out.println("there are " + integerCount +" unique integers. They are: " + uniqueIntegers);
        System.out.println("there are " + nonIntegerCount +" non integers");        
   	} // end of if input string not empty

	}  // end of main


}  // end of class