package A2Z;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class OnsiteStore extends Store{
    private String Address;

    public OnsiteStore(String link) {
        Address = link;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public boolean Verify(){
        boolean flag=false;
        if(Address!=""){flag=true;}
        return flag;
    }
}
