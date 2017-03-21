
public class Brokerage implements Login{

	/**
	 * Constructs new brokerage affiliated with a given stock exchange. 
	 * Initializes the map of traders to an empty map (a TreeMap<String, Trader>), 
	 * keyed by trader's name; initializes the set of active (logged-in) traders to an empty set (a TreeSet).
	 * @param exchange
	 */
	public Brokerage(StockExchange exchange){
		
	}
	
	/**
	 * Tries to register a new trader with a given screen name and password. If successful, 
	 * creates a Trader object for this trader and adds this trader to the map of all traders 
	 * (using the screen name as the key).
	 * @param name - the screen name of the trader.
	 * @param password - the password for the trader.
	 * @return
	 * 0 if successful, or an error code (a negative integer) if failed:
	 * -1 -- invalid screen name (must be 4-10 chars)
	 * -2 -- invalid password (must be 2-10 chars)
	 * -3 -- the screen name is already taken.
	 */
	public int addUser(String name, String password){
		
		return 0;
	}
	
	/**
	 * Tries to login a trader with a given screen name and password. If no messages are waiting for 
	 * the trader, sends a "Welcome to SafeTrade!" message to the trader. Opens a dialog window for 
	 * the trader by calling trader's openWindow() method. Adds the trader to the set of all logged-in traders.
	 * @param name - the screen name of the trader.
	 * @param password - the password for the trader.
	 * @return
	 * 0 if successful, or an error code (a negative integer) if failed:
	 * -1 -- screen name not found
	 * -2 -- invalid password
	 * -3 -- user is already logged in.
	 */
	public int login(String name, String password){
		
		return 0;
	}

	/**
	 * Removes a specified trader from the set of logged-in traders.
	 * @param trader
	 */
	public void logout(Trader trader){
		
	}
	
	/**
	 * Requests a quote for a given stock from the stock exachange and passes it along to the trader by 
	 * calling trader's receiveMessage method.
	 * @param symbol
	 * @param trader
	 */
	public void getQuote(String symbol, Trader trader){
		
	}
	
	/**
	 * Places an order at the stock exchange.
	 * @param order
	 */
	public void placeOrder(TradeOrder order){
		
	}
}
