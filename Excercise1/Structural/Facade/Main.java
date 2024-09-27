package Educational_Incentives.Excercise1.Structural.Facade;

public class Main {
    public static void main(String[] args) {
        // Create a facade for video conversion
        VideoConversionFacade videoConversionFacade = new VideoConversionFacade();

        // Convert a video using the facade
        videoConversionFacade.convertVideo("funny_cats.mp4", "avi");
    }
}
