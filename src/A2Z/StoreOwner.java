package A2Z;

import A2Z.Store;

import java.util.*;

/**
 * 
 */
public abstract class StoreOwner extends User {
    private Vector<Store> stores=new Vector<>();

    public StoreOwner() {

    }

    public StoreOwner(String username, String password) {
        super(username, password);
    }

    public StoreOwner(String name, String email, String username, String password) {
        super(name, email, username, password);
    }
    public String ViewStore(Store s){
        return s.getName()+s.getStoreID();
    }

    public Vector<Store> getStores() {
        return stores;
    }

    public void setStores(Vector<Store> stores) {
        this.stores = stores;
    }

    abstract public String NumberOfViewsForEachProduct(); //number of views of each model in a store
    abstract public String MostViewiedProductInEachStore();
}