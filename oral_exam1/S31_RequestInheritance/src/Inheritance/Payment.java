package Inheritance;

/**
 * A payment class which include a String type sender name , int type random number and string type receiver name
 */
public class Payment {
    /**
     * A private string sender
     */
    private String sender;
    /**
     * a private integer rand
     */
    private int rand;
    /**
     * A private string receiver
     */
    private String receiver;

    /**
     * A constructor  for Payment class which needs 3 parameters
     * @param sender String sender name
     * @param rand integer of random send amount
     * @param receiver a string for receiver's name
     */
    public Payment(String sender, int rand, String receiver){
        this.rand = rand;
        this.receiver =receiver;
        this.sender = sender;
    }

    /**
     * a getter for int rand
     * @return int rand
     */
    public int getRand() {
        return rand;
    }

    /**
     * A getter method for string receiver
     * @return string receiver
     */
    public String getReceiver() {
        return receiver;
    }

    /***
     * A getter methond for sender class member
     * @return string sender
     */
    public String getSender() {
        return sender;
    }

    /**
     * A toSring weill reutern  two arrylist[
     * @return string
     */
    public String toString(){
        return "\nPayment Data" + "\nPayment sender: " + getSender() + "\nPayment amount: $" + getRand() + "\nPayment receiver: " + getReceiver();


    }
}
