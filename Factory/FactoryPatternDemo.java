package Factory;

import java.util.Scanner;

// Step 1: Define an interface
interface OS {
    void spec();
}

// Step 2: Implement concrete classes
class Android implements OS {
    public void spec() {
        System.out.println("This is Android: Open Source and User-Friendly.");
    }
}

class IOS implements OS {
    public void spec() {
        System.out.println("This is iOS: Secure and Premium Experience.");
    }
}

class Windows implements OS {
    public void spec() {
        System.out.println("This is Windows: Legacy and Enterprise-friendly.");
    }
}

// Step 3: Create a Factory to generate objects
class OSFactory {
    public OS getInstance(String type) {
        if (type.equalsIgnoreCase("Android")) {
            return new Android();
        } else if (type.equalsIgnoreCase("iOS")) {
            return new IOS();
        } else if (type.equalsIgnoreCase("Windows")) {
            return new Windows();
        }
        return null;
    }
}

// Step 4: Test the Factory Design Pattern
public class FactoryPatternDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the type of OS (Android/iOS/Windows): ");
        String osType = scanner.nextLine();

        OSFactory factory = new OSFactory(); // Create a factory
        OS os = factory.getInstance(osType); // Get the required object

        if (os != null) {
            os.spec(); // Call the method on the object
        } else {
            System.out.println("Invalid OS type entered!");
        }

        scanner.close();
    }
}
