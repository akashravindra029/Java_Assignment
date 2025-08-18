package Conditional_statements;


import java.util.Scanner;

public class calculator {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);



        int choice; // To store the menu option selected
        double number1, number2, result;



        while (true){

            System.out.println("\n --- Calculator Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Subtract");
            System.out.println("3. Multiplication");
            System.out.println("4. Division");
            System.out.println("5. Exit");


            System.out.print("Choose an option: ");

            choice = scanner.nextInt();


            if (choice == 5){
                System.out.println("Exit calculator. Goodbye!");
                break;
            }


            System.out.print("Enter first number: ");
            number1 = scanner.nextDouble();

            System.out.print("Enter the second number: ");
            number2 = scanner.nextDouble();


            switch (choice){
                case 1:
                    result = number1 + number2;
                    System.out.println("Result: " + result);
                    break;

                case 2:
                    result = number1 - number2;
                    System.out.println("Result " + result);
                    break;

                case 3:
                    result = number1 * number2;
                    System.out.println("Result " + result);
                    break;

                case 4:
                    if (number2 !=0) {
                        result = number1 / number2;
                        System.out.println("Result " + result);
                    }else {
                        System.out.println("Error: Cannot divide by zero!");
                    }
                    break;

                default:
                    System.out.println("Invalid option. Please choose between 1 and 5");
            }

        }
        scanner.close();

    }
}


