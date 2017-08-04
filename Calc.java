import java.util.*;
import java.util.Scanner;
import java.util.ArrayList;

public class Calc {
	
	public static void main(String[] args) {

	System.out.println("enter integers to calculate");

	int n = 0;
	List<Integer> stackArray = new ArrayList<Integer>();
	int stackCount = 0;
	
	List <String> operatorList = new ArrayList<String>();
	operatorList.add("+");
	operatorList.add("-");
	operatorList.add("*");
	operatorList.add("/");
	operatorList.add("%");

	List <String> specialOperatorList = new ArrayList<String>();
	specialOperatorList.add("?");
	specialOperatorList.add("^");
	specialOperatorList.add("!");

    boolean toExit = false;
   	
	    while(!toExit) {

			Scanner input = new Scanner(System.in);
		    String userInput = input.nextLine();
		    String[] inputParts = userInput.split(" ");
		    int result = 0;

		    if ((inputParts.length == 0) || (userInput.equals(""))) {
		      System.out.println("# nothing entered, try again (1)");
		      return;
		    } 

			if (inputParts.length != 0) {
				if (isInputInvalid(inputParts,operatorList,specialOperatorList)) {
					System.out.println("# invalid entry, try again (2)");
				} else {
					try {
						int num = Integer.parseInt(inputParts[0]);
						stackArray.add(num);
						stackCount = stackCount + 1;
					} 
					catch (NumberFormatException ex)
					{
			            if (operatorList.contains(inputParts[0])) {
			            	if (stackCount > 1) {
			            		switch (inputParts[0]) {
			            			case "+": 
			            				result = (stackArray.get(stackCount - 2)) + (stackArray.get(stackCount - 1));
		            					break;
			            			case "-": 
			            				result = (stackArray.get(stackCount - 2)) - (stackArray.get(stackCount - 1));
			            				break;
			            			case "*": 
			            				result = (stackArray.get(stackCount - 2)) * (stackArray.get(stackCount - 1));
			            				break;
			            			case "/": 
			            				result = (stackArray.get(stackCount - 2)) / (stackArray.get(stackCount - 1));
			            				break;
			            			case "%": 
			            				result = (stackArray.get(stackCount - 2)) % (stackArray.get(stackCount - 1));
			            				break;
			            		}
	
			            		stackArray.remove(stackCount - 1);
			            		stackCount = stackCount - 1;
			            		stackArray.remove(stackCount - 1);
			            		stackCount = stackCount - 1;
			            		stackArray.add(result);
			            		stackCount = stackCount + 1;
			            		System.out.println("answer is: " + result);
			            		result = 0;
			            	} else {
			            		System.out.println("there are not enough numbers on which to perform this operation");
			            	}
			            }

			            if (specialOperatorList.contains(inputParts[0])) {
				            switch (inputParts[0]) {
		            			case "?": 
		            				for(int i = 0; i < stackArray.size(); i++) {
		            					System.out.print((stackArray.get(i)).toString() + " ");
									}
	            					break;
		            			case "^": 
		            				if (stackCount > 0) {
		            					result = stackArray.get(stackCount - 1);
		            					stackArray.remove(stackCount - 1);
			            				stackCount = stackCount - 1;
					            		System.out.println("answer is: " + result);
					            		result = 0;
		            				} else {
		            					System.out.println("nothing in memory");
		            				}
		            				break;
		            			case "!": 
		            				break;
			            		}
			            }
					}

				}
			}		    

	    } // end While

	}  // end main

public static boolean isInputInvalid(String[] inputToTest, List <String> opList, List <String> sOpList) {
	for (int i = 0; i < inputToTest.length; i++) {
          try 
          {
            int num = Integer.parseInt(inputToTest[i]);
          }  // end if integer is found
          catch (NumberFormatException ex)
          {
            if ((!opList.contains(inputToTest[i])) && (!sOpList.contains(inputToTest[i]))) {
            	return true;
            }
          } // end of catch
   	}
   	return false;
}  // end of method isInputValid

}  // end class Calc