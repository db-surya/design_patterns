package Builder;

class Phone {
    private String os;
    private String processor;
    private double screenSize;
    private int battery;

    // Private constructor to enforce the use of the builder
    private Phone(PhoneBuilder builder) {
        this.os = builder.os;
        this.processor = builder.processor;
        this.screenSize = builder.screenSize;
        this.battery = builder.battery;
    }

    @Override
    public String toString() {
        return "Phone [OS=" + os + ", Processor=" + processor + ", Screen Size=" + screenSize + " inches, Battery=" + battery + "mAh]";
    }

    // Static nested Builder class
    public static class PhoneBuilder {
        private String os;
        private String processor;
        private double screenSize;
        private int battery;

        public PhoneBuilder setOS(String os) {
            this.os = os;
            return this;
        }

        public PhoneBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public PhoneBuilder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public PhoneBuilder setBattery(int battery) {
            this.battery = battery;
            return this;
        }

        public Phone build() {
            return new Phone(this);
        }
    }
}

// Main class to demonstrate the Builder Pattern
public class BuilderPatternDemo {
    public static void main(String[] args) {
        // Creating a Phone using the Builder pattern
        Phone phone = new Phone.PhoneBuilder()
                .setOS("Android")
                .setProcessor("Snapdragon 888")
                .setScreenSize(6.5)
                .setBattery(5000)
                .build();

        // Output the phone details
        System.out.println(phone);

        // Creating another Phone with different specifications
        Phone anotherPhone = new Phone.PhoneBuilder()
                .setOS("iOS")
                .setProcessor("A16 Bionic")
                .setScreenSize(6.1)
                .setBattery(4350)
                .build();

        System.out.println(anotherPhone);
    }
}
