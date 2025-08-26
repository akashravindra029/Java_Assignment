package Exceptional_Handling;

public class divisble {
    public static void main(String[] args) {
        try {
            int p= 8, q = 0;
            int result = p / q;
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Arthematic Exception Occurs Here.");
        }
    }
}
