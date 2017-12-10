package A2Z;

/**
 * 
 */
public class Product {

    /**
     * Default constructor
     */
    public Product() {
    }

    /**
     * 
     */
    private String productID;

    /**
     * 
     */
    private Model model;

    /**
     * 
     */
    private Brand brand;

    /**
     * 
     */
    private double price;

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    /**
     * 
     */
    private Store store;

    public Product(String productID, Model model, Brand brand, double price, Store store) {
        this.productID = productID;
        this.model = model;
        this.brand = brand;
        this.price = price;
        this.store = store;
    }


    public void printInfo(Product p) {
        // TODO implement here
    }

    /**
     * @return
     */
    public void viewProduct() {
        // TODO implement here
    }

}