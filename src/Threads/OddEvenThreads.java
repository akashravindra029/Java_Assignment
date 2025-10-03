package Threads;


class NumberPrinter {
    private int number = 1;
    private final int MAX = 20;

    // Synchronized method to print numbers
    public synchronized void printOdd() {
        while (number <= MAX) {
            if (number % 2 == 0) {  // Wait if number is even
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Odd Thread: " + number);
                number++;
                notify();  // Wake up even thread
            }
        }
    }

    public synchronized void printEven() {
        while (number <= MAX) {
            if (number % 2 != 0) {  // Wait if number is odd
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Even Thread: " + number);
                number++;
                notify();  // Wake up odd thread
            }
        }
    }
}

public class OddEvenThreads {
    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        // Thread to print odd numbers
        Thread t1 = new Thread(() -> printer.printOdd());

        // Thread to print even numbers
        Thread t2 = new Thread(() -> printer.printEven());

        t1.start();
        t2.start();
    }
}
