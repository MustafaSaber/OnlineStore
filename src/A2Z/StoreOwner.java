package A2Z;

import A2Z.Store;

import java.util.*;

/**
 * 
 */
public abstract class StoreOwner extends User {
    private Vector<Store> stores = new Vector<Store>();;

    public StoreOwner() {
        stores = new Vector<Store>();
    }

    public StoreOwner(String username, String password) {
        super(username, password);
    }

    public StoreOwner(String name, String email, String username, String password) {
        super(name, email, username, password);
    }

    public Vector<Store> getStores() {
        return stores;
    }
    public String ViewStore(Store s)
    {
        return s.getName()+s.getStoreID();
    }

    public void setStores(Vector<Store> stores) {
        this.stores = stores;
    }
    abstract public String NumberOfViewsForEachProduct();
    abstract public String MostViewiedProductInEachStore();
}