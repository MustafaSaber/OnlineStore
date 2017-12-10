package A2Z;

public class OnsiteStoreController extends StoreController {

    private OnsiteStore onsitestore;

    public OnsiteStoreController() {}

    public OnsiteStore getOnsitestore() {
        return onsitestore;
    }

    public void setOnsitestore(OnsiteStore onsitestore) {
        this.onsitestore = onsitestore;
    }

    public boolean Verify(){
        boolean flag=false;
        if(onsitestore.getAddress()!=""){flag=true;}
        return flag;
    }

}