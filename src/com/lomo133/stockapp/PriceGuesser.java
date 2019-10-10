package com.lomo133.stockapp;

//import java.util.Scanner;
//
///**
// * @Author Joakim Olsson <lomo133>
// * Last edit: 2019-02-05
// */
//
///**
// * Class for guessing the prices for a specific stock, counts as a correct guess if is ±1 dollar from the today's actual stock price.
// */
//public class PriceGuesser extends StockPrice {
//    Scanner scanner = new Scanner(System.in);
//
//    public void guessPrice(String apiKey, int timeout) {
//        System.out.print("Would you like to guess the current stock price for a stock? (Y/N): ");
//        Character ans = scanner.next().charAt(0);
//        if (ans.equals('N')) {
//            printStockPrice(apiKey, timeout);
//        }
//        else if (ans.equals('Y')) {
//            System.out.println("Enter the stock you would like to guess the price for: ");
//            int input = scanner.nextInt();
//            //TODO
//
//        } else {
//            System.out.println("Please only enter Y or N).");
//            guessPrice(apiKey, timeout);
//        }
//    }
//}
