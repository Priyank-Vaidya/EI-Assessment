package Educational_Incentives.Excercise1.Behavioural.Strategy;

class Navigator {
    private RouteStrategy strategy;

    public Navigator(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public String calculateRoute(String start, String destination) {
        return strategy.buildRoute(start, destination);
    }}

