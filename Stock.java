import java.text.DecimalFormat;
import java.util.PriorityQueue;

public class Stock {
    public static DecimalFormat money;
    private String symbol, company;
    private double open, high, low, close;
    private int volume;

    private PriorityQueue<TradeOrder> buy, sell;

    /**
     * Constructs a new stock with a given symbol, company name, and starting price.
     * Sets low price, high price, and last price to the same opening price. Sets "day" volume to zero.
     * Initializes a priority qieue for sell orders to an empty PriorityQueue with a PriceComparator configured
     * for comparing orders in ascending order; initializes a priority qieue for buy orders to an empty PriorityQueue
     * with a PriceComparator configured for comparing orders in descending order.
     *
     * @param symbol
     * @param name
     * @param price
     */

    public Stock(String symbol, String name, double price) {
        this.symbol = symbol;
        company = name;
        open = price;
        high = price;
        low = price;
        close = price;
        volume = 0;
        buy = new PriorityQueue<TradeOrder>(20, new PriceComparator(false));
        sell = new PriorityQueue<TradeOrder>(20, new PriceComparator());
    }


    /**
     * Returns a quote string for this stock. The quote includes: the company name for this stock;
     * the stock symbol; last sale price; the lowest and highest day prices; the lowest price
     * in a sell order (or "market") and the number of shares in it (or "none" if there are no sell orders);
     * the highest price in a buy order (or "market") and the number of shares in it (or "none" if there are
     * no buy orders).
     * <p>
     * For example:
     *
     * @return
     */

    public String getQuote() {
        String sellOrderStatus;
        String buyOrderStatus;
        if (sell.isEmpty()) sellOrderStatus = "none";
        else sellOrderStatus = String.valueOf(sell.peek().getPrice()) + " size: " + sell.peek().getShares();
        if (buy.isEmpty()) buyOrderStatus = "none";
        else buyOrderStatus = String.valueOf(buy.peek().getPrice()) + " size: " + buy.peek().getShares();
        return company + " (" + symbol + ")\nPrice: " + close + " hi: " + high + " lo: " + low + " vol: "
                + volume + "\nAsk: " + sellOrderStatus +
                " Bid: " + buyOrderStatus;
    }

    /**
     * Places a trading order for this stock. Adds the order to the appropriate priority queue depending
     * on whether this is a buy or sell order. Notifies the trader who placed the order that the order has
     * been placed, by sending a message to that trader. For example:
     * New order:  Buy GGGL (Giggle.com)
     * 200 shares at $38.00
     * Or:
     * New order:  Sell GGGL (Giggle.com)
     * 150 shares at market
     * Executes pending orders by calling executeOrders.
     *
     * @param order
     */

    public void placeOrder(TradeOrder order) {
        if (order.isBuy()) {
            buy.add(order);
            if (order.isMarket())
                order.getTrader().receiveMessage("New order: " + "Buy " + order.getShares() + " shares at market");
            else
                order.getTrader().receiveMessage("New order: " + "Buy " + order.getShares() + " shares at $" + order.getPrice());
        } else {
            sell.add(order);
            if (order.isMarket())
                order.getTrader().receiveMessage("New order: " + "Sell " + order.getShares() + " shares at market");
            else
                order.getTrader().receiveMessage("New order: " + "Sell " + order.getShares() + " shares at $" + order.getPrice());
        }
        executeOrders();
    }

    /**
     * (Called at the end of any Stock's PLACE ORDER method to resolve
     * as many orders as possible after a new order has been placed.)
     * Executes as many pending orders as possible. <br>
     * <p>
     * 1. Examines the top sell order and the top buy order in
     * the respective priority queues.<br>
     * i) If both are limit orders and the asking price is less than
     * or equal to the selling price, executes the order (or a part of it)
     * at the sell order price.<br>
     * ii) If one order is limit and the other is market, executes the
     * order (or a part of it) at the limit order price<br>
     * iii) If both orders are market, executes the order (or a part of it)
     * at the last sale price.<br>
     * <p>
     * 2. Figures out how many shares can be traded, which
     * is the smallest of the numbers of shares in the two orders.<br>
     * <p>
     * 3. Subtracts the traded number of shares from each order;
     * Removes each of the orders with 0 remaining shares from the respective queue.<br>
     * <p>
     * 4. Updates the day's low price, high price, and volume.<br>
     * <p>
     * 5. Sends a message to each of the two traders involved in the transaction.
     * For example:
     * <p>
     * You bought: 150 GGGL at 38.00 amt 5700.00</pre>
     * <p>
     * 6. Repeats steps 1-5 for as long as possible, that is as long as
     * there is any movement in the buy / sell order queues.
     * (The process gets stuck when the top buy order and sell order
     * are both limit orders and the ask price is higher than the bid
     * price.)
     */

    protected void executeOrders() {
        while (!buy.isEmpty() && !sell.isEmpty()) {
            int possShares = 0;
            double transPrice = 0;
            if (buy.peek().isLimit() && sell.peek().isLimit() && buy.peek().getPrice() >= sell.peek().getPrice()) {
                // execute at the sell order price
                possShares = Math.min(buy.peek().getShares(), sell.peek().getShares());
                transPrice = sell.peek().getPrice();
                if (transPrice < low) low = transPrice;
                else if (transPrice > high) high = transPrice;
                close = transPrice;
                volume += possShares;
                sell.peek().getTrader().receiveMessage("You sold: " + possShares + " " + sell.peek().getSymbol() +
                        " at " + transPrice + " amt " + possShares * transPrice);
                buy.peek().getTrader().receiveMessage("You bought: " + possShares + " " + buy.peek().getSymbol() +
                        " at " + transPrice + " amt " + possShares * transPrice);
                buy.peek().subtractShares(possShares);
                sell.peek().subtractShares(possShares);
                if (buy.peek().getShares() == 0) buy.poll();
                else sell.poll();
            } else if ((buy.peek().isLimit() && sell.peek().isMarket()) || (buy.peek().isMarket() && sell.peek().isLimit())) {
                // execute at the limit order price
                possShares = Math.min(buy.peek().getShares(), sell.peek().getShares());
                if (buy.peek().isLimit()) transPrice = buy.peek().getPrice();
                else if (sell.peek().isLimit()) transPrice = sell.peek().getPrice();
                if (transPrice < low) low = transPrice;
                else if (transPrice > high) high = transPrice;
                close = transPrice;
                volume += possShares;
                sell.peek().getTrader().receiveMessage("You sold: " + possShares + " " + sell.peek().getSymbol() +
                        " at " + transPrice + " amt " + possShares * transPrice);
                buy.peek().getTrader().receiveMessage("You bought: " + possShares + " " + buy.peek().getSymbol() +
                        " at " + transPrice + " amt " + possShares * transPrice);
                buy.peek().subtractShares(possShares);
                sell.peek().subtractShares(possShares);
                if (buy.peek().getShares() == 0) buy.poll();
                else sell.poll();
            } else {
                // execute at the last sale price
                possShares = Math.min(buy.peek().getShares(), sell.peek().getShares());
                volume += possShares;
                sell.peek().getTrader().receiveMessage("You sold: " + possShares + " " + sell.peek().getSymbol() +
                        " at " + close + " amt " + possShares * close);
                buy.peek().getTrader().receiveMessage("You bought: " + possShares + " " + buy.peek().getSymbol() +
                        " at " + close + " amt " + possShares * close);
                buy.peek().subtractShares(possShares);
                sell.peek().subtractShares(possShares);
                if (buy.peek().getShares() == 0) buy.poll();
                else sell.poll();
            }
        }
    }

}
