package Educational_Incentives.Excercise1.Structural.Adaptor;

public class Main {
    public static void main(String[] args) {
        XMLStockDataStack xmlStockDataSource = new XMLStockDataStack();
        StockDataAdapter adapter = new StockDataAdapter(xmlStockDataSource);
        adapter.convertAndSendData();
    }
}

