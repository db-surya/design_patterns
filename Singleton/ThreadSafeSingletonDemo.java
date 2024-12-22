package Singleton;

// Thread-Safe Singleton Class
class ThreadSafeSingleton {
    // Step 1: Private static instance of the class
    private static ThreadSafeSingleton instance;

    // Step 2: Private constructor to prevent instantiation
    private ThreadSafeSingleton() {
        System.out.println("Thread-Safe Singleton Instance Created");
    }

    // Step 3: Public static synchronized method for thread-safe access
    public static synchronized ThreadSafeSingleton getInstance() {
        if (instance == null) {
            instance = new ThreadSafeSingleton(); // Create instance if not already created
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Thread-Safe Singleton Pattern Demo");
    }
}

// Main Class
public class ThreadSafeSingletonDemo {
    public static void main(String[] args) {
        // Create multiple threads to test thread safety
        Runnable task = () -> {
            ThreadSafeSingleton singleton = ThreadSafeSingleton.getInstance();
            singleton.showMessage();
        };

        // Start multiple threads
        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);
        Thread thread3 = new Thread(task);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

//To reduce the overhead of synchronized, you can use Double-Checked Locking:


// public static ThreadSafeSingleton getInstance() {
//     if (instance == null) {
//         synchronized (ThreadSafeSingleton.class) {
//             if (instance == null) {
//                 instance = new ThreadSafeSingleton();
//             }
//         }
//     }
//     return instance;
// }
