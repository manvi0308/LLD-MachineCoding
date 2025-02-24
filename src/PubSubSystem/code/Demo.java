package PubSubSystem.code;

public class Demo {
    public static void main(String[] args) {
        // Create Topics
        Topic topic1 = new Topic("Foood");
        Topic topic2 = new Topic("Sports");

        Publisher publisher1 = new Publisher();
        Publisher publisher2 = new Publisher();

        publisher1.registerTopic(topic1);
        publisher2.registerTopic(topic2);
        Subscriber subscriber1 = new PrintSubscriber("Subscriber1");
        Subscriber subscriber2 = new PrintSubscriber("Subscriber2");
        Subscriber subscriber3 = new PrintSubscriber("Subscriber3");

        topic1.addSubsrciber(subscriber1);
        topic1.addSubsrciber(subscriber2);
        topic1.addSubsrciber(subscriber3);

        topic2.addSubsrciber(subscriber3);

        // Publish the messages
        publisher1.publish(topic1, new Message("Message 1 for Topic 1"));
        publisher1.publish(topic1, new Message("Message 2 for Topic 1"));


        publisher2.publish(topic2,  new Message("Message 1 for Topic 2"));


        // Remove the subscriber
        topic1.removeSubscriber(subscriber1);
        publisher1.publish(topic1, new Message("Message 1 for Topic 1"));
        publisher1.publish(topic1, new Message("Message 2 for Topic 1"));


    }


}
