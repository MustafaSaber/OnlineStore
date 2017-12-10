package A2Z;

public class OnlineStoreController extends StoreController {

    private OnlineStore onlinestore;
    public OnlineStoreController() {
    }
    public boolean Verify() {
        boolean flag=false;
        if(onlinestore.getLink()!=""){flag=true;}
        return flag;
    }

}