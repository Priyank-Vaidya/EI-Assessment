package Educational_Incentives.Excercise1.Creational.Singleton;

public class ConnectionPool {
    // Static variable that holds the single instance of the class
    private static ConnectionPool instance;

    // Private constructor to prevent instantiation
    private ConnectionPool() {
        // Initialize the connection pool
        System.out.println("Connection Pool Initialized");
    }

    // Public method to provide access to the singleton instance
    public static ConnectionPool getInstance() {
        if (instance == null) {
            instance = new ConnectionPool(); // Create instance if it doesn't exist
        }
        return instance; // Return the singleton instance
    }

    // Method to simulate getting a connection from the pool
    public void getConnection() {
        System.out.println("Getting a connection from the pool...");
        // Logic to get a connection (not implemented for simplicity)
    }

    // Method to simulate returning a connection to the pool
    public void releaseConnection() {
        System.out.println("Releasing a connection back to the pool...");
        // Logic to release a connection (not implemented for simplicity)
    }
}
