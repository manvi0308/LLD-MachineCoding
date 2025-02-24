package PubSubSystem;

import java.util.HashSet;
import java.util.Set;

public class Publisher {
    // A list of all the topics
    private final Set<Topic> topics;

    public Publisher() {
        this.topics = new HashSet<>();
    }
    // should have ability to add topics
    public void registerTopic(Topic topic){
        topics.add(topic);
    }
    // should have the ability to publish Message to all the subscribers for a topic.
    public void publish(Topic topic, Message message){
        if(!topics.contains(topic)){
            System.out.println("This publisher can't publish to topic: " + topic.getName());
            return;
        }
        topic.publish(message);

    }
}
