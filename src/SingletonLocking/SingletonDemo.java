package SingletonLocking;

class Singleton {
    // Volatile ensures proper handling of the instance in multithreaded environment
    private static volatile Singleton instance;

    // Private constructor prevents instantiation
    private Singleton() {
        System.out.println("Singleton instance created.");
    }

    // Thread-safe method to get the Singleton instance
    public static Singleton getInstance() {
        if (instance == null) {             // First check (without locking)
            synchronized (Singleton.class) {
                if (instance == null) {     // Second check (with locking)
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    // Method to demonstrate different inputs
    public void showMessage(String message) {
        System.out.println("Message: " + message);
    }
}

public class SingletonDemo {
    public static void main(String[] args) {
        // Runnable tasks with different inputs
        Runnable task1 = () -> {
            Singleton s = Singleton.getInstance();
            s.showMessage("Hello from Thread 1");
        };

        Runnable task2 = () -> {
            Singleton s = Singleton.getInstance();
            s.showMessage("Hello from Thread 2");
        };

        Runnable task3 = () -> {
            Singleton s = Singleton.getInstance();
            s.showMessage("Hello from Thread 3");
        };

        // Start multiple threads
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);

        t1.start();
        t2.start();
        t3.start();
    }
}

