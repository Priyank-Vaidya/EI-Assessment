package Educational_Incentives.Excercise1.Creational.Singleton;

public class Main {
    public static void main(String[] args) {
        ConnectionPool pool1 = ConnectionPool.getInstance();
        pool1.getConnection();

        ConnectionPool pool2 = ConnectionPool.getInstance();
        pool2.releaseConnection();


        System.out.println("Are both pool instances the same? " + (pool1 == pool2));

    }
}
