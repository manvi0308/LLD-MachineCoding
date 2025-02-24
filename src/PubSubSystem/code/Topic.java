package PubSubSystem.code;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Topic {
    // A topic has a name and a list of all the subscribers.
    private String name;
    private Set<Subscriber> subscribers = new CopyOnWriteArraySet<>();
    public Topic(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    // Should have the ability to add and remove subscribers for a topic
    public void addSubsrciber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    public void removeSubscriber(Subscriber subscriber){
        subscribers.remove(subscriber);
    }

    // Should have the ability to publish a message to all its subscribers.
    public void publish(Message message) {
        for(Subscriber subscriber : subscribers){
            subscriber.onMessage(message);
        }
    }
}
