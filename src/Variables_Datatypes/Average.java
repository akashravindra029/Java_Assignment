package Variables_Datatypes;

import java.util.Scanner;

public class Average {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter  1st number A:");
            double A = scanner.nextDouble();
            System.out.print("Enter  2nd number B:");
            double B = scanner.nextDouble();
            System.out.print("Enter  3rd number C:");
            double C = scanner.nextDouble();


            double average = (A + B + C) / 3;


            System.out.println("Average of  three numbers is: " + average);

            scanner.close();
        }
    }


