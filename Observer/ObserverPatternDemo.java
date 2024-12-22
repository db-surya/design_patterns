package Observer;
import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Subscriber {
    void update(String videoTitle);
}

// Concrete Observer: YouTube User/Subscriber
class YouTubeSubscriber implements Subscriber {
    private String name;

    public YouTubeSubscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String videoTitle) {
        System.out.println(name + " has been notified about the new video: " + videoTitle);
    }
}

// Subject Interface
interface YouTubeChannel {
    void addSubscriber(Subscriber subscriber);
    void removeSubscriber(Subscriber subscriber);
    void notifySubscribers();
}

// Concrete Subject: YouTube Channel (Observable)
class YouTubeChannelImpl implements YouTubeChannel {
    private List<Subscriber> subscribers = new ArrayList<>();
    private String videoTitle;

    // Adding a subscriber
    @Override
    public void addSubscriber(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    // Removing a subscriber
    @Override
    public void removeSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    // Notify all subscribers about a new video upload
    @Override
    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(videoTitle);
        }
    }

    // Setting new video title and notifying all subscribers
    public void uploadVideo(String videoTitle) {
        this.videoTitle = videoTitle;
        System.out.println("New video uploaded: " + videoTitle);
        notifySubscribers();
    }
}

// Main Class: Demo of Observer Pattern in action
public class ObserverPatternDemo {
    public static void main(String[] args) {
        // Create the YouTube channel
        YouTubeChannelImpl channel = new YouTubeChannelImpl();

        // Create some subscribers
        Subscriber subscriber1 = new YouTubeSubscriber("Alice");
        Subscriber subscriber2 = new YouTubeSubscriber("Bob");

        // Add subscribers to the channel
        channel.addSubscriber(subscriber1);
        channel.addSubscriber(subscriber2);

        // Upload a new video and notify all subscribers
        channel.uploadVideo("Observer Pattern Tutorial");

        // Removing a subscriber
        channel.removeSubscriber(subscriber1);

        // Upload another video and only notify remaining subscribers
        channel.uploadVideo("Design Patterns in Java");
    }
}
