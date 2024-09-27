package Educational_Incentives.Excercise1.Behavioural.Observer;

public class ConcreteSubscriber1 implements Subscriber {
    @Override
    public void update(String data) {
        System.out.println("Subscriber 1 received data: " + data);
    }
}
