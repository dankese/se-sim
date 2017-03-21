import java.text.DecimalFormat;

public class Stock {
	public static DecimalFormat money;

	/**
	 * Constructs a new stock with a given symbol, company name, and starting price. 
	 * Sets low price, high price, and last price to the same opening price. Sets "day" volume to zero. 
	 * Initializes a priority qieue for sell orders to an empty PriorityQueue with a PriceComparator configured 
	 * for comparing orders in ascending order; initializes a priority qieue for buy orders to an empty PriorityQueue 
	 * with a PriceComparator configured for comparing orders in descending order.
	 * @param symbol
	 * @param name
	 * @param price
	 */
	public Stock(String symbol, String name, double price){
		
	}
	
	
	/**
	 * Returns a quote string for this stock. The quote includes: the company name for this stock; 
	 * the stock symbol; last sale price; the lowest and highest day prices; the lowest price 
	 * in a sell order (or "market") and the number of shares in it (or "none" if there are no sell orders); 
	 * the highest price in a buy order (or "market") and the number of shares in it (or "none" if there are
	 * no buy orders). 
	 * 
	 * For example:
 	 * Giggle.com (GGGL)
 	 * Price: 10.00  hi: 10.00  lo: 10.00  vol: 0
 	 * Ask: 12.75 size: 300  Bid: 12.00 size: 500
	 * @return
	 */
	public String getQuote(){
		
		return null;
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
	 * @param order
	 */
	public void placeOrder(TradeOrder order){
		
	}

}
