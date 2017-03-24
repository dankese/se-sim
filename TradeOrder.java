public class TradeOrder {

    private Trader trader;
    private String symbol;
    private boolean buyOrder;
    private boolean marketOrder;
    private int numShares;
    private double price;

    /**
     * Constructs a new TradeOrder for a given trader, stock symbol, a number of shares, and other parameters.
     *
     * @param trader      - a trader who placed this order.
     * @param symbol      - stock symbol.
     * @param buyOrder    - if true this is a buy order; otherwise this is a sell order.
     * @param marketOrder - if true this is a market order; otherwise this is a limit order.
     * @param numShares   - the number of shares to be traded.
     * @param price       - the bid or ask price, if this is a limit order.
     */

    public TradeOrder(Trader trader, String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price) {
        this.trader = trader;
        this.symbol = symbol;
        this.buyOrder = buyOrder;
        this.marketOrder = marketOrder;
        this.numShares = numShares;
        this.price = price;
    }

    /**
     * Returns the trader for this trade order.
     *
     * @return
     */

    public Trader getTrader() {
        return trader;
    }

    /**
     * @return - the stock symbol for this trade order.
     */

    public String getSymbol() {
        return symbol;
    }

    /**
     * Returns true if this is a buy order; otherwise returns false.
     *
     * @return - true if this is a buy order; false otherwise.
     */

    public boolean isBuy() {
        return buyOrder;
    }

    /**
     * Returns true if this is a sell order; otherwise returns false.
     *
     * @return - true if this is a sell order; false otherwise.
     */

    public boolean isSell() {
        return !buyOrder;
    }

    /**
     * Returns true if this is a market order; otherwise returns false.
     *
     * @return
     */

    public boolean isMarket() {
        return marketOrder;
    }

    /**
     * Returns true if this is a limit order; otherwise returns false.
     *
     * @return
     */

    public boolean isLimit() {
        return !marketOrder;
    }

    /**
     * Returns the number of shares to be traded in this trade order.
     *
     * @return
     */

    public int getShares() {
        return numShares;
    }

    /**
     * Returns the price per share for this trade order (used by a limit order).
     *
     * @return
     */

    public double getPrice() {
        return price;
    }

    /**
     * Subtracts a given number of shares from the total number of shares in this trade order.
     *
     * @param shares - a number of shares to be subtracted.
     *               <p>
     *               Throws:
     *               java.lang.IllegalArgumentException - if shares is greater than the number of shares in this order.
     */

    public void subtractShares(int shares) {
        if (shares > numShares) throw new IllegalArgumentException();
        else this.numShares -= shares;
    }
}
