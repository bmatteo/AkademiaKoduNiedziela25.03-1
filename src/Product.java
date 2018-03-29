public class Product {
    int id;
    String name;
    double price;
    int amount;

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public void persist() {


    }
}
