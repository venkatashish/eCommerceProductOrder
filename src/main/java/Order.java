import java.util.ArrayList;
import java.util.Scanner;

class OrderClass{
    private int id;
    private int qty;

    public OrderClass(int id, int qty){
        this.id = id;
        this.qty = qty;
    }

    public int getId(){
        return id;
    }

    public int getQty(){
        return qty;
    }
}


public class Order {

    private final ArrayList<Product> products;
    Scanner ect = new Scanner(System.in);
    char enterOrder = 'Y';
    ArrayList<OrderClass> orderList = new ArrayList<>();

    public Order(ArrayList<Product> products){
        this.products = products;
    }

    public void createOrder(){
        while(enterOrder == 'Y') {
            System.out.println("Enter id of the product");
            int id = ect.nextInt();
            ect.nextLine();
            System.out.println("Enter qty of product you want to purchase");
            int qty = ect.nextInt();
            ect.nextLine();
            int response = canAddOrder(id, qty);
            if(response==1){
                orderList.add(new OrderClass(id, qty));
            } else {System.out.println("You can't have qty more than in the stock");}
            System.out.println("Do you want to add more to your order list [Y/N]?");
            char res = ect.next().charAt(0);
            ect.nextLine();
            enterOrder = res;
        }


    }

    public void showOrderDetails(){
        double totalprice = 0.0;
        for(OrderClass element: orderList){
            for(Product element1: products){
                if(element.getId() == element1.getId()){
                    double price = element1.getPrice()*element.getQty();
                    totalprice += price;
                    System.out.println(element1.getName()+"   "+element.getQty()+"  "+price);
                }
            }
        }
        System.out.printf("Total order price is:- %,f", totalprice);
        }

    private int canAddOrder(int id, int qty){
        for(Product element: products){
            if(element.getId()==id){
                if(element.getStock()>=qty){
                    element.reduceStock(qty); //to reduce the stock from global
                    return 1;
                }
            }

        }
        return 0;
    }


}
