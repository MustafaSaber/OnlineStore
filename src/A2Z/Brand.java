package A2Z;
import java.util.Vector;

/**
 * Created by lenovo on 12/7/2017.
 */
public class Brand {
    private String Name = "";
    private String BrandID = "";
    private Vector<Model> Models = new Vector<Model>();

    public Brand(){

    }

    public Brand(String name, String brandID) {
        Name = name;
        BrandID = brandID;

    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getBrandID() {
        return BrandID;
    }

    public void setBrandID(String brandID) {
        BrandID = brandID;
    }

    public Vector<Model> getModels() {
        return Models;
    }

    public void setModels(Vector<Model> models) {
        Models = models;
    }

}
