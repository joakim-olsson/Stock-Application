package com.lomo133.stockapp;

import org.patriques.AlphaVantageConnector;
import org.patriques.TimeSeries;
import org.patriques.input.timeseries.Interval;
import org.patriques.input.timeseries.OutputSize;
import org.patriques.output.AlphaVantageException;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.data.StockData;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        response = stockTimeSeries.intraDay(this.symbol, Interval.ONE_MIN, OutputSize.FULL);
        stockData = response.getStockData();
    }

    public StockPrice() {
        this.symbol = getRandomSymbol();
        apiConnector = new AlphaVantageConnector(apiKey, timeout);
        stockTimeSeries = new TimeSeries(apiConnector);
        response = stockTimeSeries.intraDay(this.symbol, Interval.ONE_MIN, OutputSize.FULL);
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
            Map<String, String> metaData = response.getMetaData();
            for (String key : metaData.keySet()) {
                System.out.println(metaData.get(key));
            }

            System.out.println(stockData.get(0).getHigh());
            System.out.println(stockData.get(0).getLow());
            System.out.println(stockData.get(0).getDateTime());
            System.out.println(stockData.get(0).getVolume());
            System.out.println(stockData.get(1).getDateTime());
            System.out.println(stockData.get(389).getDateTime());

            System.out.println(stockData.size());
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

    public String getSymbol() {
        return symbol;
    }

    public String getRandomSymbol() {
        List<String> list = null;
        try (Stream<String> lines = Files.lines(Paths.get("/home/lomo133/projects/Stock-Application/src/stocklist/stocksymbols.txt"))) {
            list = lines.collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Path to symbol text file is wrong" + e);
        }
        return list.get(getRandomElement(list));
    }

    public int getRandomElement(List<String> list) {
        Random rnd = new Random();
        return rnd.nextInt(list.size());

    }

//    public static void main(String args[]) {
//        StockPrice test = new StockPrice("msft");
//        test = new StockPrice("m");
//        System.out.println(test.getRandomSymbol());
//    }
}
