package A2Z;

import A2Z.Product;

import java.util.Vector;

/**
 * Created by lenovo on 12/7/2017.
 */
public class Store {
    private String Name;
    private String StoreID;
    private Vector<Product> Products = new Vector<Product>();

    public Store(){
        Name="";
        StoreID="";
    }

    public Store(String name, String storeID) {
        Name = name;
        StoreID = storeID;
    }

    public void AddProduct(Product myProduct){
        Products.add(myProduct);
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getStoreID() {
        return StoreID;
    }

    public void setStoreID(String storeID) {
        StoreID = storeID;
    }

    public Vector<Product> getProducts() {
        return Products;
    }

    public void setProducts(Vector<Product> products) {
        Products = products;
    }


}
