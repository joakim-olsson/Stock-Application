# Stock Application

An application created in Java used for fetching stock data using Alpha Vantage.

Alpha Vantage is a leading provider of free APIs for realtime and historical data on stocks and digital/crypto currencies.

Link to Alpha Vantage: https://www.alphavantage.co/ <br/>
Link to generate Alpha Vantage api key: https://www.alphavantage.co/support/#api-key

Made with an Alpha Vantage Java wrapper made by patriques82.

Link to Java wrapper: https://github.com/patriques82/alphavantage4j

### How to use the application:

Run the main method in the "App" class and make sure to include the .jar dependencies when compiling the project.

### FAQ

#### Q: Why does the application show the stock price for 16:00 yesterday?

#### A: This is because the time is timezone is set to US eastern time. If it shows yesterdays date 16:00 then it means that the stock market in US hasn't opened yet and the most recent price of that stock was yesterday when the market closed for the day.
