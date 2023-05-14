/*
 Class CashRegister represents a cash register and has a
 variety of methods that are used to operate the cash register.
 author Moshe Yakubov
 version 21/03/23
 */

import java.util.ArrayList;
import java.util.Scanner;

public class CashRegister {
    /*Declaration of instance variables*/
    private double cashRegisterAmount;
    private double totalCustomersPayment;
    private ArrayList<LineInTheAccount> items = new ArrayList<>();

    /*
     Construct a new CashRegister (default constructor)
     */
    public CashRegister() {
    }

    /*
     Construct a new CashRegister.
     The constructor gets a double parameter represents the initial amount
     that will be in the cash register and resets the amount of it accordingly.
     */
    public CashRegister(double cashRegisterAmount) {
        this.cashRegisterAmount = cashRegisterAmount;
    }

    /*
     A method for adding an item to buy.
     The method receives an item and amount and adds a line to the
     account The current customer's purchases.
     */
    public void addItem(Item item, int amount) {
        LineInTheAccount line = new LineInTheAccount(item, amount);
        items.add(line);
    }

    /*
    A method that prints a string representing the current customer's account.
    For each line in the invoice, the name of the item, the amount and the total
    price for this item are indicated.
    */
    public void printShoppingList() {
        for (LineInTheAccount item : items)
            System.out.printf("Name of item: %s, Amount: %d, Price: %.2f %n", item.getItem().getItemName(),
                    item.getAmount(), item.getTotal());
        System.out.println();
    }

    /*
    The method returns the total amount of the current customer's purchase.
    */
    public double totalAmountPurchase() {
        double totalAmountToPay = 0;
        for (LineInTheAccount item : items)
            totalAmountToPay += item.getTotal();
        return totalAmountToPay;
    }

    /*
    A method that receives payment from the buyer, and returns the change.
    This method resets the details of the current purchase and updates the amount
    which is included in the checkout.
    */
    public double getPayment(double payment) {
        double amountToPay = totalAmountPurchase();
        cashRegisterAmount += amountToPay;
        totalCustomersPayment += amountToPay;
        items = new ArrayList<>();
        return (payment - amountToPay);
    }

    /*A method that returns the total amount in the cash register.*/
    public double getCashRegisterAmount() {
        return cashRegisterAmount;
    }

    /*The method returns the total amount of all purchases of all buyers*/
    private double getTotalCustomersPayment() {
        return totalCustomersPayment;
    }

    /*The method prints a message asking if we would be interested
    in updating an initial amount at the cash register.*/
    private void hasInitialAmount() {
        System.out.println("""
                Hi, before we start using the cash register,\s
                would you be interested in putting an initial amount into it?
                Select:
                1: Yes, 0: No""");
    }

    /*The method asks the user to enter an initial amount into the cash register.*/
    private void askForInitialAmount() {
        System.out.println("Please choose an initial amount to put in the cash register");
    }

    /*The method prints a customer service start message.*/
    private void acceptCustomersMessage() {
        System.out.println("Great!\nNow we can accept customers\n");
    }

    /*The method prints a product shopping menu.*/
    private void printProductsMenu() {
        System.out.printf("Please choose a product from the list below:%n"
                + "1: bread %n"
                + "2: milk %n"
                + "3: honey %n"
                + "4: eggs %n"
                + "5: cheese %n"
                + "6: shampoo %n"
                + "7: cucumber %n"
                + "8: tomato %n"
                + "9: canola oil %n"
                + "0: finish the purchase %n");
    }

    /*The method prints a message asking the customer to enter the
    quantity he wishes to purchase of the selected product.*/
    private void amountOfProductMessage() {
        System.out.println("Please indicate the quantity you would like to purchase");
    }

    /*The method receives an object of type cashRegister, the customer's product selection and the
    quantity he wishes to purchase from the product and adds the product to the customer's shopping list.
    The method returns true when the customer wants to purchase another product, otherwise it returns false.*/
    private boolean choosingProducts(CashRegister safe, int choice, int amount) {
        switch (choice) {
            case 1 -> safe.addItem(new Item("bread", 7.50), amount);
            case 2 -> safe.addItem(new Item("milk", 5.00), amount);
            case 3 -> safe.addItem(new Item("honey", 24.90), amount);
            case 4 -> safe.addItem(new Item("eggs", 29.90), amount);
            case 5 -> safe.addItem(new Item("cheese", 22.50), amount);
            case 6 -> safe.addItem(new Item("shampoo", 15.00), amount);
            case 7 -> safe.addItem(new Item("cucumber", 1.20), amount);
            case 8 -> safe.addItem(new Item("tomato", 1.50), amount);
            case 9 -> safe.addItem(new Item("canola oil", 11.5), amount);
            case 0 -> {
                System.out.println("You chose to finish the purchase\n");
                return false;
            }
        }
        return true;
    }

    /*The method prints an introduction message for the printing
    of the products that the customer wishes to purchase.*/
    private void printProductInterestMessage() {
        System.out.println("The list of products you are interested in purchasing is:");
    }

    /*The method gets CashRegister parameter and
    prints the total cost of the customer's purchase.*/
    private void PrintShoppingCost(CashRegister safe) {
        System.out.printf("Total cost: %.2f%n", safe.totalAmountPurchase());
    }

    /*The method prints a request for the customer to
    enter the payment for his purchase.*/
    private void printPaymentRequest() {

        System.out.println("Please enter the amount you are paying:");
    }

    /*The method gets CashRegister parameter and the payment
    of the customer and prints the change of the customer.*/
    private void returnChange(CashRegister safe, double payment) {
        System.out.printf("Your change is: %.2f NIS%nThank you for shopping with us!\n\n", safe.getPayment(payment));
    }

    /*The method prints a message asking if there is
    another customer interested in purchasing products.*/
    private void askIfThereIsCustomer() {
        System.out.println("""
                Please note if there is one more customer waiting to pay for his groceries:
                1: Yes
                0: No""");
    }

    /*The method receives a variable that represents whether
    there is another customer interested in purchasing products
    and returns true if so and false otherwise.*/
    private boolean hasAnotherCustomer(int hasCustomer) {
        return hasCustomer == 1;
    }

    /*The method receives a parameter of type cashRegister
    and prints a message that the cash register is closed.
    The method also prints the current amount in the cash
    register and the amount of all purchases by all customers.*/
    private void closeCashRegisterMessage(CashRegister safe) {
        System.out.printf("""
                        The cash register is closed!

                        The amount in the cash register is: %.2f
                        The cumulative amount of all customers' purchases is: %.2f
                        """,
                safe.getCashRegisterAmount(), safe.getTotalCustomersPayment());
    }


    /*The program uses the services of the cash register.
    The program includes a central menu that allows you to
    activate the various operations of the cash register.*/

    /*main method begins program execution*/
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CashRegister safe = new CashRegister();
        int productChoice, hasCustomer, amount;
        double payment;

        safe.hasInitialAmount();
        if (input.nextInt() == 1) {
            safe.askForInitialAmount();
            safe = new CashRegister(input.nextDouble());
        }
        safe.acceptCustomersMessage();

        do {
            do {
                safe.printProductsMenu();
                productChoice = input.nextInt();
                if (productChoice != 0) {
                    safe.amountOfProductMessage();
                    amount = input.nextInt();
                } else
                    amount = 0;
            } while (safe.choosingProducts(safe, productChoice, amount));

            safe.printProductInterestMessage();
            safe.printShoppingList();
            safe.PrintShoppingCost(safe);
            safe.printPaymentRequest();
            payment = input.nextDouble();
            safe.returnChange(safe, payment);
            safe.askIfThereIsCustomer();
            hasCustomer = input.nextInt();
        } while (safe.hasAnotherCustomer(hasCustomer));

        safe.closeCashRegisterMessage(safe);
    }
}
