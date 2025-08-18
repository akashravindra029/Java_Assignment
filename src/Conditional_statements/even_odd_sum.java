package Conditional_statements;

import java.util.Scanner;

public class even_odd_sum {

        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);

            int EvenSum = 0;
            int OddSum = 0;

            System.out.print("How many numbers will you enter? ");
            int cont = input.nextInt();

            System.out.println("Enter " + cont + " numbers:");

            for (int i = 1; i <= cont; i++) {
                int num = input.nextInt();

                if (num % 2 == 0) {
                    EvenSum =  EvenSum + num;
                } else {
                    OddSum = OddSum + num;
                }
            }

            System.out.println("Sum of even numbers: " + EvenSum);
            System.out.println("Sum of odd numbers: " + OddSum);

            input.close();
        }
    }


