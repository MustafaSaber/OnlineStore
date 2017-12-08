package A2Z;

import java.util.Vector;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class Store {
    private String Name;
    private String StoreID;
    private Vector<Product> Products;

    public Store(){
        Name="";
        StoreID="";
        Products=new Vector<>();
    }

    public Store(String name, String storeID) {
        Name = name;
        StoreID = storeID;
        Products = new Vector();
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
