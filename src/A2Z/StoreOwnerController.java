package A2Z;



public class StoreOwnerController
{
    private StoreOwner so = new StoreOwner();

    public StoreOwnerController() {
    }

    public Boolean AddStoreCont(String id,String name) {
        Store store = new Store(name,id);
        so.getStores().add(store);
        system.sc.AddStoreToDB(name,id);
        return true;
    }

    public Boolean RemoveStoreCont(String id,String name) {
        system.sc.RemoveStoreToDB(name,id);
        for (Store store : so.getStores())
        {
            if(store.getStoreID().equals(id) && store.getName().equals(name))
            {
                so.getStores().remove(store);
                return true;
            }
        }
        return false;
    }

    public void SuggestModelCont(String name,String id,Brand b) {
         Model model = new Model(id,name,b);
         system.suggestModels.add(model);
    }
    public void SuggestBrandCont(String id,String name) {
         Brand brand = new Brand(name,id);
         system.suggestBrands.add(brand);
    }

    public void NumberOfViewsForEachProduct() //number of views of each model in a store
    {
        for (Store store : so.getStores())
        {
            for(Product p : store.getProducts()) {
                System.out.println("Product: " + p.getModel().getName() + " >> " + p.getModel().getView());
            }
        }
    }
    public void MostViewiedProductInEachStore() //	Get the most viewed product in a store
    {
        int mostViews = 0;
        String modelName = "";
        for (Store store : so.getStores())
        {
            for(Product p : store.getProducts())
            {
                 modelName = p.getModel().getName();
                 if(mostViews < (p.getModel().getView()))
                     mostViews = p.getModel().getView();

            }
        }
        System.out.println("The most viewed product: "+ modelName+" >> "+ mostViews);
    }

    public Boolean AddStoreOwnerToDBCont(String name, String email,String username,String password) {
        StoreOwner storeOwner = new StoreOwner(name,email,username,password);
        system.storeOwners.add(storeOwner);
        return true;
    }

    public Boolean RemoveStoreOwnerToDBCont(String username,String email) {
        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getUsername().equals(username) && storeOwner.getEmail().equals(email))
            {
                system.storeOwners.remove(storeOwner);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerNameToDBCont(String name) {

        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getName().equals(so.getName()))
            {
                storeOwner.setName(name);
                return true;
            }
        }
        return false;
    }

    public Boolean UpdateStoreOwnerPasswordToDBCont(String password) {
        for (StoreOwner storeOwner : system.storeOwners)
        {
            if(storeOwner.getPassword().equals(so.getPassword()))
            {
                storeOwner.setPassword(password);
                return true;
            }
        }
        return false;
    }

}