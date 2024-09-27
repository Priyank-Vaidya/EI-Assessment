package Educational_Incentives.Excercise1.Structural.Facade;

// Facade class
class VideoConversionFacade {
    private VideoEncoder encoder;
    private VideoCompressor compressor;
    private VideoStorage storage;

    public VideoConversionFacade() {
        encoder = new VideoEncoder();
        compressor = new VideoCompressor();
        storage = new VideoStorage();
    }

    public void convertVideo(String filename, String format) {
        encoder.encode(filename, format); // Encode the video
        compressor.compress(filename);     // Compress the encoded video
        storage.save(filename);            // Save the final video
    }
}
