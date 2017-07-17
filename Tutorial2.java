import java.util.*;
// import java.util.Scanner;

public class Tutorial2 {
	public static void main(String[] args) {

    // Scanner input = new Scanner(System.in); // Reading from System.in

   	if (args.length == 0) {
   			System.out.println("enter list of integers");
    }

   	if (args.length != 0) {
   			int[] inputList = new int[(args.length - 1)];
        int nonIntegerCount = 0;
        int integerCount = 0;
        String uniqueIntegers = "";

   			for (int i = 0; i < args.length; i++) {
          try 
          {
            int num = Integer.parseInt(args[i]);
            if (integerCount == 0)
            {
              inputList[integerCount] = num;
              integerCount = integerCount + 1;
              uniqueIntegers = Integer.toString(num);
            }
            else
            {
              for (int j = 0; j < integerCount; j++) {
                if (inputList[j] == num) {
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