package Educational_Incentives.Excercise1.Structural.Adaptor;


// Adapter class
public class StockDataAdapter implements JsonStockData {
    private XMLStockDataStack xmlStockDataSource;

    public StockDataAdapter(XMLStockDataStack xmlStockDataSource) {
        this.xmlStockDataSource = xmlStockDataSource;
    }

    @Override
    public void sendStockData(String jsonData) {
        System.out.println("Sending stock data to third-party analytics library: " + jsonData);
    }

    public void convertAndSendData() {
        String xmlData = xmlStockDataSource.getStockData();
        String jsonData = convertXmlToJson(xmlData);
        sendStockData(jsonData);
    }

    private String convertXmlToJson(String xmlData) {
        return "The XML is not converted into JSON through implementation from this program";
    }
}
