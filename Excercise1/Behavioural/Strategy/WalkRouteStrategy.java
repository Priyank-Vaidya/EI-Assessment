package Educational_Incentives.Excercise1.Behavioural.Strategy;

class WalkRouteStrategy implements RouteStrategy {
    public String buildRoute(String start, String destination) {
        return "Route from " + start + " to " + destination + " optimized for walking.";
    }
}

