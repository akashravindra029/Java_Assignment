package Exceptional_Handling;

public class nested_try {


        public static void main(String[] args) {
            try {
                System.out.println("Outer try block started");

                // Inner try block 1
                try {
                    int[] numbers = {1, 2, 3};
                    System.out.println("Accessing index 5: " + numbers[5]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("Caught in inner try 1: " + e.getMessage());
                }

                // Inner try block 2
                try {
                    String invalidNumber = "abc";
                    int parsed = Integer.parseInt(invalidNumber); // NumberFormatException
                    System.out.println("Parsed number: " + parsed);
                } catch (NumberFormatException e) {
                    System.out.println("Caught in inner try 2: " + e.getMessage());
                }

                System.out.println("Outer try block finished");
            } catch (Exception e) {
                System.out.println("Caught in outer catch block: " + e.getMessage());
            }
        }
    }
