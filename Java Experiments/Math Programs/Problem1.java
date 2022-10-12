import java.util.Scanner;
//Name: Prabhjot Bhandal
//Date: October 12th, 2022
/*Multiply the quantity of the item by the unitPrice to get the subTotal. Next, multiply the subTotal by 0.13 
to determine the tax, and then we determine the total by adding the tax and the subTotal. */

public class Problem1 {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
           System.out.print("Please enter the name of the item: ");
           //Gets item's name
           String name = in.next();
           System.out.print("Please enter the quantity of the item you are purchasing: ");
           //Gets item's name
           int quantity = in.nextInt();
           System.out.print("Please enter the price of the item: $");
           //Gets item's name
           double price = in.nextDouble();
           
           //hundredth variable for rounding to the nearest hundredth
           double hundredth = 0.01;
           //Calculates subTotal
           double subTotal = quantity * price;
           //Calculates tax and rounds it to the nearest hundredth
           double tax = Math.round((subTotal * 0.13) / hundredth) * hundredth;
           //Calculates total
           double total = Math.round((tax + subTotal) / hundredth) * hundredth;
           System.out.println("Qty: " + quantity + "\nName: " + name + "\nUnitPrice: $" + price + "\nExtPrice: $" + price + "\nSub-Total: $" + subTotal + "\nTax(13%): $" + tax + "\nTotal: $" + total);

        }
}
}
