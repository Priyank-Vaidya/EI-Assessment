package Educational_Incentives.Excercise1.Behavioural.Observer;

public class Main {
    public static void main(String[] args) {
        Publisher publisher = new Publisher();

        ConcreteSubscriber1 subscriber1 = new ConcreteSubscriber1();
        ConcreteSubscriber2 subscriber2 = new ConcreteSubscriber2();

        // Subscribe to the publisher
        publisher.subscribe(subscriber1);
        publisher.subscribe(subscriber2);

        System.out.printf("Current State: " + publisher.getState());

        // Notify all subscribers
        publisher.updateState("New state");
        System.out.printf("New state: " + publisher.getState());



    }
}
