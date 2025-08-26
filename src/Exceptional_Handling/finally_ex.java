package Exceptional_Handling;

public class finally_ex {

        public static void main(String[] args) {
            try {
                int a = 10, b = 2;
                int result = a / b; // No exception here
                System.out.println("Result: " + result);
            } catch (ArithmeticException e) {
                System.out.println("Exception catch " + e.getMessage());
            } finally {
                System.out.println("It's  the finally block,and always runs.");
            }
        }
    }


