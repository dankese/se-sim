import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

public class StockChecker {
	
	//gets html doc
	private String grabHtml(String symbol) {
	    URL url;
	    InputStream is = null;
	    BufferedReader br;
	    String line;
	    String out = "";

	    try {
	        url = new URL("http://finance.yahoo.com/quote/" + symbol);
	        is = url.openStream();  // throws an IOException
	        br = new BufferedReader(new InputStreamReader(is));

	        while ((line = br.readLine()) != null) {
	            out+= line;
	        }
	    } catch (IOException e) {
	    } 
	    
	    return out;
	}

    // Given symbol, get current stock price.
    public double priceOf(String symbol) {
        String html = grabHtml(symbol);
        int p     = html.indexOf("\"OPEN-value\"");      // "price.0" indexdata-reactid="251">
        int from  = html.indexOf(">", p);            // ">" index
        int to    = html.indexOf("<", from);   // "</span>" index
        String price = html.substring(from + 1, to);

        return Double.parseDouble(price);
    }

    // Given symbol, get current stock name.
    public String nameOf(String symbol) {
    	String html = grabHtml(symbol);
        int p    = html.indexOf("(" + symbol + ")") - 15;
        int from = html.indexOf(">", p);
        int to   = html.indexOf("(", from);
        String name = html.substring(from + 1, to);
        return name;
    }
    
    public static void main(String[] args){
    	
    }
    

}


/*

add to stock exchangeVVVVVVV

public void listStock(String symbol){
		listStock(symbol,checker.nameOf(symbol),checker.priceOf(symbol));
	}

	public String getQuote(String symbol){
		if(!stocks.containsKey(symbol)){
			listStock(symbol);
		}
		return stocks.get(symbol).getQuote();
	}


*/
