package A2Z;

public class Model {
    private String modelID;
    private String name;
    private Brand myBrand;
    private int views;

    public Model(){
        views = 0;
    }

    public Model(String modelID, String name, Brand myBrand) {
        this.modelID = modelID;
        this.name = name;
        this.myBrand = myBrand;
        views = 0;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public String getModelID() {
        return modelID;

    }

    public void setModelID(String modelID) {
        this.modelID = modelID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Brand getMyBrand() {
        return myBrand;
    }

    public void setMyBrand(Brand myBrand) {
        this.myBrand = myBrand;
    }

}
