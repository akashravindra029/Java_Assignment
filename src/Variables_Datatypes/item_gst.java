package Variables_Datatypes;

import java.util.Scanner;

public class item_gst {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter the cost of a pencil: ");
            float pencil = scanner.nextFloat();

            System.out.print("Enter the cost of a pen: ");
            float pen = scanner.nextFloat();

            System.out.print("Enter the cost of an eraser: ");
            float eraser = scanner.nextFloat();


            float totalCost = pencil + pen + eraser;


            float gst = totalCost * 0.18f;


            float finalBill = totalCost + gst;


            System.out.println(" Bill Summary ");
            System.out.println("Total without GST: " + totalCost);
            System.out.println("GST with 18%: " + gst);
            System.out.println("Total Amount to Pay: " + finalBill);

            scanner.close();
        }
    }

