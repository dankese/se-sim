
public class Trader implements Comparable<Trader> {
    private Brokerage brokerage;
    private String name;
    private String pswd;

    @Override
    public int compareTo(Trader other) {
        return this.getName().toLowerCase().compareTo(other.getName().toLowerCase());
    }

    //Constructs a new trader, affiliated with a given brockerage, with a given screen name and password.

    public Trader(Brokerage brokerage, java.lang.String name, java.lang.String pswd) {
        this.brokerage = brokerage;
        this.name = name;
        this.pswd = pswd;
    }

    //Returns the screen name for this trader.

    public java.lang.String getName() {
        return name;
    }

    //Returns the password for this trader.

    public java.lang.String getPassword() {
        return pswd;
    }

    //Indicates whether this trader is equal to the other, based on comparing their screen names case blind

    public boolean equals(Object other) {
        return (this.compareTo((Trader) other) == 0);
    }

    //Creates a new TraderWindow for this trader and saves a reference to it in myWindow

    public void openWindow() {
        TraderWindow myWindow = new TraderWindow(this);
        //finish when mailbox class done
    }

    //Returns true if this trader has any messages in its mailbox.

    public boolean hasMessages() {
        //finish when mailbox class done
        return true;
    }

    /**
     * Adds msg to this trader's mailbox and displays all messages. If this trader is logged in 
     * (myWindow is not null) removes and shows all the messages in the mailbox by calling myWindow.showMessage(msg) 
     * for each msg in the mailbox.
     * @param msg
     */

    public void receiveMessage(String msg) {
        //finish when mailbox class done 
    }
    
    public void getQuote(String symbol) {
        //finish when brokerage class done
    }
    
    public void placeOrder(TradeOrder order) {
        //finish when tradeorder class done
    }
    
    public void quit() {
        //finish when brokerage class done 
    }

}
