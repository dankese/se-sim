import java.util.LinkedList;
import java.util.Queue;

public class Trader implements Comparable<Trader> {
    private Brokerage brokerage;
    private String name;
    private String pswd;
    private Queue<String> mailbox;
    private TraderWindow myWindow;

    //Constructs a new trader, affiliated with a given brokerage, with a given screen name and password.

    public Trader(Brokerage brokerage, java.lang.String name, java.lang.String pswd) {
        this.brokerage = brokerage;
        this.name = name;
        this.pswd = pswd;
        this.mailbox = new LinkedList<String>();
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

    public boolean equals(Object obj) {
        if (obj instanceof Trader) return this.compareTo((Trader) obj) == 0;
        throw new ClassCastException();
    }

    public int compareTo(Trader other) {
        return this.getName().toLowerCase().compareTo(other.getName().toLowerCase());
    }


    //Creates a new TraderWindow for this trader and saves a reference to it in myWindow

    public void openWindow() {
        myWindow = new TraderWindow(this);
        while (hasMessages()) myWindow.showMessage(mailbox.poll());
    }

    //Returns true if this trader has any messages in its mailbox.

    public boolean hasMessages() {
        return !mailbox.isEmpty();
    }

    /**
     * Adds msg to this trader's mailbox and displays all messages. If this trader is logged in
     * (myWindow is not null) removes and shows all the messages in the mailbox by calling myWindow.showMessage(msg)
     * for each msg in the mailbox.
     *
     * @param msg
     */

    public void receiveMessage(String msg) {
        mailbox.add(msg);
        while (hasMessages()) myWindow.showMessage(mailbox.poll());
    }

    public void getQuote(String symbol) {
        brokerage.getQuote(symbol, this);
    }

    public void placeOrder(TradeOrder order) {
        brokerage.placeOrder(order);
    }

    public void quit() {
        brokerage.logout(this);
        myWindow = null;
    }
}
