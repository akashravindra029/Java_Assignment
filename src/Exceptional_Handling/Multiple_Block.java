package Exceptional_Handling;

public class Multiple_Block {

        public static void main(String[] args) {
            try {
                String str = null;
                int p = 8/0;
                System.out.println(str.length());
            } catch (ArithmeticException e) {
                System.out.println("Get ArithmeticException:"+ e.getMessage());
            } catch (NullPointerException e) {
                System.out.println("Get NullPointerException:"+ e.getMessage());
            } catch (Exception e) {
                System.out.println("Get General Exception:"+ e.getMessage());
            }
        }
    }


