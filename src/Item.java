/*
 Class Item is a class that includes product name and price
 author Moshe Yakubov
 version 21/03/23
 */

public class Item {

    /*Declaration of instance variables*/
    private String itemName;
    private double price;



    /*
     Construct a new Item.
     The constructor gets a String parameter represents the name of the item
     and a double parameter represents the price of the item
     and produces a new instance of the item.
     */
    public Item(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    /*The method returns the name of the item.*/
    public String getItemName() {
        return this.itemName;
    }

    /*The method returns the price of the item.*/
    public double getPrice() {
        return this.price;
    }

}