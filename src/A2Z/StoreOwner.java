package A2Z;

import java.util.Vector;

public class StoreOwner {
    private Vector<Store> stores;

    public StoreOwner() {
    }

    public StoreOwner(Vector<Store> stores) {
        this.stores = stores;
    }

    public Vector<Store> getStores() {
        return stores;
    }

    public void setStores(Vector<Store> stores) {
        this.stores = stores;
    }

    public boolean AddStore(String name,String StoreId)
    {
        Store s = new Store(name,StoreId);
        stores.add(s);
        return true;
    }
    public boolean RemoveStore(String name,String StoreId)
    {
        for (Store store : stores)
        {
            if (store.getName() == name && store.getStoreID() == StoreId)
            {
                stores.remove(store);
                return true;
            }
        }
        return false;
    }
    public void SuggestProduct()
    {

    }
    public void SuggestBrand()
    {

    }
}
