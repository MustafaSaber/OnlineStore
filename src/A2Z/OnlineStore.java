package A2Z;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class OnlineStore extends Store {
    private String Link;

    public OnlineStore(String link) {
        Link = link;
    }

    public String getLink() {
        return Link;
    }

    public void setLink(String link) {
        Link = link;
    }

    public boolean Verify() {
        boolean flag=false;
        if(Link!=""){flag=true;}
        return flag;
    }
}
