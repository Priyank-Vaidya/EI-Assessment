package Educational_Incentives.Excercise1.Behavioural.Observer;

public class ConcreteSubscriber2 implements Subscriber {
    @Override
    public void update(String data) {
        System.out.println("Subscriber 2 received data: " + data);
    }
}
