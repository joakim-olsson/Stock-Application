import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

import java.util.*;

/**
 * @Author Joakim Olsson <lomo133>
 * Last edit: 2019-05-09
 */
public class StockPrice {

    String apiKey = "PG7CBC5EW4MYU288";
    int timeout = 3000;
    private AlphaVantageConnector apiConnector;
    private TimeSeries stockTimeSeries;
    private IntraDay response;
    private List<StockData> stockData;
    private String symbol;

    public StockPrice(String sym) {
        this.symbol = sym;
        apiConnector = new AlphaVantageConnector(apiKey, timeout);
        stockTimeSeries = new TimeSeries(apiConnector);
        response = stockTimeSeries.intraDay(sym, Interval.ONE_MIN, OutputSize.FULL);
        stockData = response.getStockData();
    }

    public void symbolOutput(String symbol) {
        String apiKey = "PG7CBC5EW4MYU288";
        int timeout = 3000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);

        System.out.print("Type your stock symbol. E.g MSFT for Microsoft: ");

        try {
            IntraDay response = stockTimeSeries.intraDay(symbol, Interval.THIRTY_MIN, OutputSize.FULL);
            //Map<String, String> metaData = response.getMetaData();
            //System.out.println("Information: " + metaData.get("1. Information"));
            //System.out.println("Stock: " + metaData.get("2. Symbol"));
            //System.out.println("time zone: " + metaData.get("6. Time Zone"));
            List<StockData> stockData = response.getStockData();
            //System.out.println(metaData.keySet());

            System.out.println(stockData.get(0).getHigh());
            System.out.println(stockData.get(0).getLow());
            System.out.println(stockData.get(0).getDateTime());
            System.out.println(stockData.get(0).getVolume());
            System.out.println(stockData.get(1).getDateTime());
            System.out.println(stockData.get(389).getDateTime());

            System.out.println(stockData.size());

            //System.out.println(stockData.get(stockData.size()-1).getDateTime());


//
//            List<StockData> stockData = response.getStockData();
//            stockData.forEach(stock -> {
//                System.out.println("date:   " + stock.getDateTime());
//                System.out.println("open:   " + stock.getOpen());
//                System.out.println("high:   " + stock.getHigh());
//                System.out.println("low:    " + stock.getLow());
//                System.out.println("close:  " + stock.getClose());
//                System.out.println("volume: " + stock.getVolume());
//            });
        } catch (AlphaVantageException e) {
            System.out.println("something went wrong");
        }
    }
    public String getHigh() {
        return Double.toString(stockData.get(0).getHigh());
    }

    public String getLow() {
        return Double.toString(stockData.get(0).getLow());
    }

    public String getVolume() {
        return Long.toString(stockData.get(0).getVolume());
    }

    public String getDate() {
        return stockData.get(0).getDateTime().toString();
    }

//    public String randomizeSymbol() {
//        Random rnd = new Random();
//        List<String> keysAsArray = new ArrayList<>(symbols.keySet());
//        return keysAsArray.get(rnd.nextInt(keysAsArray.size()));
//    }
}
