package Singleton;

// Singleton Class
class Singleton {
    // Step 1: Private static instance of the class
    private static Singleton instance;

    // Step 2: Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton Instance Created");
    }

    // Step 3: Public static method to provide access to the instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton(); // Create instance if not already created
        }
        return instance;
    }

    // Example method
    public void showMessage() {
        System.out.println("Singleton Pattern Demo");
    }
}

// Main Class
public class SingletonPatternDemo {
    public static void main(String[] args) {
        // Access Singleton instance
        Singleton singleton1 = Singleton.getInstance();
        singleton1.showMessage();

        // Access Singleton instance again
        Singleton singleton2 = Singleton.getInstance();
        singleton2.showMessage();

        // Verify that both references point to the same instance
        System.out.println("Are both instances the same? " + (singleton1 == singleton2));
    }
}
