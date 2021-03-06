import java.util.HashMap;

//A StockExchange keeps a HashMap of stocks, keyed by a stock symbol
public class StockExchange {

    private HashMap<String, Stock> stocks;

    public StockExchange() {
        stocks = new HashMap<String, Stock>();
    }

    /**
     * Adds a new stock with given parameters to the listed stocks.
     *
     * @param symbol
     * @param name
     * @param price
     */

    public void listStock(String symbol, String name, double price) {
        stocks.put(symbol, new Stock(symbol, name, price));
    }

    /**
     * Returns a quote for a given stock.
     *
     * @param symbol
     * @return
     */

    public String getQuote(String symbol) {
        return stocks.get(symbol).getQuote();
    }

    /**
     * Places a trade order by calling stock.placeOrder for the stock specified by the stock symbol
     * in the trade order.
     *
     * @param order
     */

    public void placeOrder(TradeOrder order) {
        stocks.get(order.getSymbol()).placeOrder(order);
    }
}
