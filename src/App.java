import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author Joakim Olsson
 * 2019-01-03
 */

/**
 * An app asking the user for a stock symbol and returns information about that stock. (Date, High/Low price and Volume etc.) 
 */

public class App {
    public static void main(String[] args) {
        String apiKey = "Your apikey"; // apikey from AlphaVantage
        int timeout = 2000;
        AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
        TimeSeries stockTimeSeries = new TimeSeries(apiConnector);

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Input a stock symbol: ");
            String input = scanner.nextLine();
            IntraDay response = stockTimeSeries.intraDay(input, Interval.ONE_MIN, OutputSize.COMPACT);
            Map<String, String> metaData = response.getMetaData();
            System.out.println("Information: " + metaData.get("1. Information"));
            System.out.println("Stock: " + metaData.get("2. Symbol"));

            List<StockData> stockData = response.getStockData();
            stockData.forEach(stock -> {
                System.out.println("date:   " + stock.getDateTime());
                System.out.println("open:   " + stock.getOpen());
                System.out.println("high:   " + stock.getHigh());
                System.out.println("low:    " + stock.getLow());
                System.out.println("close:  " + stock.getClose());
                System.out.println("volume: " + stock.getVolume());
            });
        } catch (AlphaVantageException e) {
            System.out.println("Not a valid symbol.");
        }
    }
}
