package A2Z;

import A2Z.Store;

import java.util.*;

/**
 * 
 */
public class StoreOwner extends User {
    private Vector<Store> stores;

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

    public void setStores(Vector<Store> stores) {
        this.stores = stores;
    }
}