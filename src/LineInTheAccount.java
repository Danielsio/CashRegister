/*
 Class LineInTheAccount is a class which represents a line in the customer's invoice.
 author Moshe Yakubov
 version 21/03/23
 */

public class LineInTheAccount {

    /*Declaration of instance variables*/
    private Item item;
    private int amount;
    private double total;

    /*
     Construct a new LineInTheAccount.
     The constructor gets an Item parameter represents an item
     and an int parameter represents the amount of the item the customer
     wants to purchase and adds a line to the invoice accordingly.
     The constructor also calculates the total amount of the item * the selected amount
     and adds it to the line in the invoice.
     */
    public LineInTheAccount(Item item, int amount) {
        this.item = item;
        this.amount = amount;
        this.total = item.getPrice() * amount;
    }

    /*The method returns the item of the line in the account.*/
    public Item getItem() {
        return this.item;
    }

    /*The method returns the amount of item of the line in the account.*/
    public int getAmount() {
        return this.amount;
    }

    /*The method returns the total amount of the
    cost of the product * its amount.*/
    public double getTotal() {
        return this.total;
    }


}
