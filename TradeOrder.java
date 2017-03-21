
public class TradeOrder {

	/**
	 * Constructs a new TradeOrder for a given trader, stock symbol, a number of shares, and other parameters.
	 * @param trader - a trader who placed this order.
	 * @param symbol - stock symbol.
	 * @param buyOrder - if true this is a buy order; otherwise this is a sell order.
	 * @param marketOrder - if true this is a market order; otherwise this is a limit order.
	 * @param numShares - the number of shares to be traded.
	 * @param price - the bid or ask price, if this is a limit order.
	 */
	public TradeOrder(Trader trader, String symbol, boolean buyOrder, boolean marketOrder, int numShares, double price){
	
	}
	
	/**
	 * Returns the trader for this trade order.
	 * @return
	 */
	public Trader getTrader(){
		return null;
	}
	
//public java.lang.String getSymbol()
//Returns the stock symbol for this trade order.
//Returns:
//the stock symbol for this trade order.
//

//public boolean isBuy()
//Returns true if this is a buy order; otherwise returns false.
//Returns:
//true if this is a buy order; false otherwise.
//
//public boolean isSell()
//Returns true if this is a sell order; otherwise returns false.
//Returns:
//true if this is a sell order; false otherwise.
//
//public boolean isMarket()
//Returns true if this is a market order; otherwise returns false.
//Returns:
//true if this is a market order; false otherwise.
//
//public boolean isLimit()
//Returns true if this is a limit order; otherwise returns false.
//Returns:
//true if this is a limit order; false otherwise.
//
//public int getShares()
//Returns the number of shares to be traded in this trade order.
//Returns:
//the number of shares to be traded in this trade order.
//
//public double getPrice()
//Returns the price per share for this trade order (used by a limit order).
//Returns:
//the price per share for this trade order.
//
//public void subtractShares(int shares)
//Subtracts a given number of shares from the total number of shares in this trade order.
//Parameters:
//shares - a number of shares to be subtracted.
//Throws:
//java.lang.IllegalArgumentException - if shares is greater than the number of shares in this order.
}
