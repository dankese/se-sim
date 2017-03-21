
public class PriceComparator implements Comparable<Trader>{

	@Override
	public int compareTo(Trader arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	/**
	 * Constructs a price comparator that compares two orders in ascending order.
	 * Sets the private boolean ascending flag to true.
	 */
	public PriceComparator(){
		
	}

	/**
	 * Constructs a price comparator that compares two orders in ascending or descending order.
	 * The order of comparison depends on the value of a given parameter. Sets the private boolean 
	 * ascending flag to asc.
	 * @param asc
	 */
	public PriceComparator(boolean asc){
		
	}
	
	/**
	 * Compares two trade orders.
	 * @param order1
	 * @param order2
	 * @return
	 * 0 if both orders are market orders;
	 * -1 if order1 is market and order2 is limit;
	 * 1 if order1 is limit and order2 is market;
	 * the difference in prices, rounded to the nearest cent, if both order1 and order2 are limit orders. 
	 * In the latter case, the difference returned is cents1 - cents2 or cents2 - cents1, depending on whether 
	 * this is an ascending or descending comparator (ascending is true or false).
	 */
	public int compare(TradeOrder order1, TradeOrder order2){
		
		return 0;
	}
}
