public class Product {
    private int id;
    private String name;
    private Double price;
    private int stock;

    public Product(int id, String name, Double price, int stock){
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public Double getPrice(){
        return price;
    }

    public int getStock(){
        return stock;
    }

    public void reduceStock(int qty){
        this.stock -= qty;
    }

    @Override
    public String toString(){
        return "ID:- "+id+" || Name:- "+name+" || Price:- "+price+" || Stock:- "+stock;
    }

}
