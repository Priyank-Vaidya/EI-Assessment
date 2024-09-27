package Educational_Incentives.Excercise1.Behavioural.Strategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("Custoemer wants to walk");
        RouteStrategy routeStrategy = new WalkRouteStrategy();
        Navigator navigator = new Navigator(routeStrategy);
        System.out.println(navigator.calculateRoute("AMD", "BOM"));

        System.out.println("Customer wants to take public transport");
        RouteStrategy publicTransportStrategy = new PublicTransportStrategy();
        navigator.setStrategy(publicTransportStrategy);
        System.out.println(navigator.calculateRoute("AMD", "DEL"));

    }
}
