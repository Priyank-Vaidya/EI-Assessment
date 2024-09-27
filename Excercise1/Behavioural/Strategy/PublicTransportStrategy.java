package Educational_Incentives.Excercise1.Behavioural.Strategy;

class PublicTransportStrategy implements RouteStrategy {
    public String buildRoute(String start, String destination) {
        return "Route from " + start + " to " + destination + " optimized for public transport.";
    }
}
