package A2Z;
import static A2Z.system.stores;
public class StoreController {
    private Store myStore;

    public StoreController(){}

    public StoreController(Store myStore) {
        this.myStore = myStore;
    }

    public Store getMyStore() {
        return myStore;
    }

    public void setMyStore(Store myStore) {
        this.myStore = myStore;
    }

    public boolean AddStoreToDB(String name, String storeID){
        boolean flag=true;

        for (int i=0;i<stores.size();i++){
            if(stores.get(i).getName().equals(name) && stores.get(i).getStoreID().equals(storeID)){
                flag=false;
                break;
            }
        }
        if(flag==true){
            Store StoreObj=new Store();
            StoreObj.setName(name);
            StoreObj.setStoreID(storeID);
            stores.add(StoreObj);
        }
        return flag;
    }

    public boolean RemoveStoreToDB(String name, String storeID){
        boolean flag=false;

        for (int i=0;i<stores.size();i++){
            if(stores.get(i).getName().equals(name) && stores.get(i).getStoreID().equals(storeID)){
                stores.remove(i);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public void UpdateStoreToDB(String name,String storeID,String newName){
        RemoveStoreToDB(name,storeID);
        AddStoreToDB(newName,storeID);
    }

    public boolean Verify(){return false;}
}
