package A2Z;

public class OnsiteStore extends Store {
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

}
