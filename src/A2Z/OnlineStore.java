package A2Z;

/**
 * Created by lenovo on 12/7/2017.
 */
public class OnlineStore extends Store {
    private String Link;

    public OnlineStore(String link) {
        Link = link;
    }

    public OnlineStore(String name, String storeID, String link) {
        super(name, storeID);
        Link = link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

}
