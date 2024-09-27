package Educational_Incentives.Excercise1.Behavioural.Observer;

import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private List<Subscriber> subscribers = new ArrayList<>();
    String state;

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void unsubscribe(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    public void updateState(String newState) {
        this.state = newState; // Update the internal state
        notifySubscribers(); // Notify all subscribers about the state change
    }

    public String getState() {
        return state;
    }

    public void notifySubscribers() {
        for (Subscriber subscriber : subscribers) {
            subscriber.update(state);
        }
    }
}

