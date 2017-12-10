package A2Z;

/**
 * 
 */
public class StoreOwnerController {
    private StoreOwner so;

    public StoreOwnerController() {
    }

    public Boolean AddStoreCont(String id,String name) {
        Store store = new Store(name,id);
        so.getStores().add(store);
        System.sc.AddStoreToDB(name,id);
        return true;
    }

    public Boolean RemoveStoreCont(String id,String name) {
        System.sc.RemoveStoreToDB(name,id);
        for (Store store : so.getStores())
        {
            if(store.getStoreID() == id && store.getName() == name)
            {
                so.getStores().remove(store);
                return true;
            }
        }
        return false;
    }

    public void SuggestModelCont(String name,String id,Brand b) {
         Model model = new Model(id,name,b);
         System.suggestModels.add(model);
    }
    public void SuggestBrandCont(String id,String name) {
         Brand brand = new Brand(name,id);
         System.suggestBrands.add(brand);
    }

    public String ViewStatCont() {

        return "";
    }

    public Boolean AddStoreOwnerToDBCont(String name, String email,String username,String password) {
        StoreOwner storeOwner = new StoreOwner(name,email,username,password);
        System.storeOwners.add(storeOwner);
        return true;
    }

    public Boolean RemoveStoreOwnerToDBCont(String username,String email) {
        for (StoreOwner storeOwner : System.storeOwners)
        {
            if(storeOwner.getUsername() == username && storeOwner.getEmail()==email)
            {
                System.storeOwners.remove(storeOwner);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerNameToDBCont(String name) {

        for (StoreOwner storeOwner : System.storeOwners)
        {
            if(storeOwner.getName() == so.getName())
            {
                storeOwner.setName(name);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerPasswordToDBCont(String password) {
        for (StoreOwner storeOwner : System.storeOwners)
        {
            if(storeOwner.getPassword() == so.getPassword())
            {
                storeOwner.setPassword(password);
                return true;
            }
        }
        return false;
    }

    public Boolean VerifyCont(String Address) {

        return null;
    }

}