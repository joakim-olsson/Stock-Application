/**
 * @Author Joakim Olsson <lomo133>
 * Last edit: 2019-02-05
 */

public class App {

    /**
     * Starting point for the application.
     */
    public static void main(String[] args) {
        App.startApp();
    }

    /**
     * Method for connecting and calling the api.
     */
    public static void startApp() {
        String apiKey = "PG7CBC5EW4MYU288";
        int timeout = 1500;
        PriceGuesser start = new PriceGuesser();
        start.guessPrice(apiKey, timeout);
    }
}
