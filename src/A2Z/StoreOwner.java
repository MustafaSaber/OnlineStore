package A2Z;

import java.util.Scanner;
import java.util.Vector;

public class StoreOwner extends User {
    private Vector<Store> stores;

    public StoreOwner() {
    }
    public StoreOwner(Vector<Store> stores) {
        this.stores = stores;
    }
    public StoreOwner(String nm, String email, String usernm, String pass) {
        this.setName(nm);
        this.setEmail(email);
        this.setUsername(usernm);
        this.setPassword(pass);
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
        //fadi
    }
    public void SuggestBrand(String name,String id)
    {
        Brand b = new Brand(name,id);
        System.suggestBrands.add(b);
    }
    public String ViewStat()
    {
        String stat = "";
        return stat;
    }
    public void AddProductToStore(Store s , Product p)
    {
        s.AddProduct(p);
    }
    public boolean AddStoreOwnerToDB(String name ,String email,String usernm ,String pass)
    {
        StoreOwner so = new StoreOwner(name,email,usernm,pass);
        System.storeOwners.add(so);
        return true;
    }
    public boolean RemoveStoreOwnerToDB(String Uname)
    {
        //search for storeowner
        for(StoreOwner so :System.storeOwners)
        {
            if(so.getUsername() == Uname)
            {
                System.storeOwners.remove(so);
                return true;
            }
        }
        return false;
    }
    public boolean UpdateStoreOwnerToDB(String Uname)
    {
        for(StoreOwner so :System.storeOwners)
        {
            if(so.getUsername() == Uname)
            {
                Scanner sc = new Scanner(java.lang.System.in);
                java.lang.System.out.print("Enter new name:");
                String n = sc.nextLine();
                so.setName(n);
                java.lang.System.out.print("Enter new email:");
                n = sc.nextLine();
                so.setEmail(n);
                java.lang.System.out.print("Enter new username:");
                n = sc.nextLine();
                so.setUsername(n);
                java.lang.System.out.print("Enter new password:");
                n = sc.nextLine();
                so.setPassword(n);
                return true;
            }
        }
        return false;
    }
    public boolean Verify(String address)
    {
        /////////
        return true;
    }
}
