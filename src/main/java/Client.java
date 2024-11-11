import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    public static void main(String[] args){

        Scanner obj = new Scanner(System.in);
        char addProductResponse = 'Y';
        ArrayList<Product> products = new ArrayList<>();
        int counter=0;

        while(addProductResponse == 'Y'){
            counter++;
            System.out.println("Enter the name of product");
            String name = obj.nextLine();
            System.out.println("Enter the price of product");
            Double price = obj.nextDouble();
            obj.nextLine();
            System.out.println("Enter the stock of product");
            int stock = obj.nextInt();
            obj.nextLine();
            int id = counter;

            products.add(new Product(id,name,price,stock));

            System.out.println("Want to enter more [Y/N]?");
            addProductResponse = obj.next().charAt(0);
            obj.nextLine();
        }



        for(Product element: products){
            System.out.println(element);
        }

        Order o1 = new Order(products);
        o1.createOrder();
        o1.showOrderDetails();
    }
}
