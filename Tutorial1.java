public class Tutorial1 {

    //on cmd line enter two arguments, the first is the question number (1,2,3 or 4)
    //and the second is the value of n

    public static void main(String[] args){

        int x;
        x = Integer.parseInt(args[0]);

        // fibonacci series
        if (x == 1) {

            int a;
            a = Integer.parseInt(args[1]);
            int[] fibNumbers = new int[a]; // stores the whole series;
            
            if (a == 0) {
                System.out.println("can not be zero (0)");
            } else {

                String theFibSeries = "0"; // holds the series numbers for printing
                fibNumbers[0] = 0; // array holds all the numbers, the first one being zero
                fibNumbers[1] = 1;
                theFibSeries = theFibSeries + ", " + "1";

                for (int m=2; m <= (a - 1); m++){
                    fibNumbers[m] = fibNumbers[(m-1)] + fibNumbers[(m-2)];
                    theFibSeries = theFibSeries + ", " + Integer.toString(fibNumbers[m]);
                }

                System.out.println("question 1 - Fibonacci series for n=" + a + " is:");
                System.out.println(theFibSeries);
            }

        }  // end - fibonacci series

        
        // n factorial
        if (x == 2) {

            int n;
            n = Integer.parseInt(args[1]);

            int factorial;
            factorial = 1;

            String factorialExpression;
            factorialExpression = "";

            System.out.println("second question - Factorial: " + 9);

            for (int i = n; i > 0; i = (i - 1)) {

                if (i != n) {
                    factorialExpression = factorialExpression + " * " + i;
                } else {
                    factorialExpression = Integer.toString(i);
                }

                factorial = i * factorial;

            }
            System.out.println(n + " factorial is: " + factorialExpression + " = " + factorial);
        } // end - n factorial



        // max and min numbers from a string of numbers
        if (x == 3) {
            
            if (args.length > 2) {

                int i;
                i = args.length - 1;
                double[] numList = new double[i];

                int argsPosition;
                argsPosition = 1;

                int y = 0;
                double minInput = 0;
                double maxInput = 0;

                String listInputNumbers;
                listInputNumbers = args[1];

                for (y=0; y < i; y++){
                    numList[y] = Double.parseDouble(args[argsPosition]);
                    argsPosition = argsPosition + 1;

                    if (y == 0) {
                        minInput = numList[y];
                        maxInput = numList[y];
                    }
                        
                    if ((y !=0 )  || (y != 1)) {
                        listInputNumbers = listInputNumbers + ", " + args[y];
                    }

                    if (numList[y] < minInput) {
                            minInput = numList[y];
                        }

                    if (numList[y] > maxInput){
                        maxInput = numList[y];
                    }
                }

                listInputNumbers = listInputNumbers + ", " + args[i];
                System.out.println("string of numbers to compare is: " + listInputNumbers);
                System.out.println("minimum = " + minInput);
                System.out.println("maximum = " + maxInput);

            } else {
                System.out.println("list 2 or more numbers after the first number '3'");
            }
        } // end - max and min numbers from a string of numbers



        if (x == 4) {
            System.out.println("question 4: not completed");
        }
    }

}
