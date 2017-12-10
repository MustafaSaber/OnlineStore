package A2Z;

public class Model {
    private String modelID;
    private String name;
    private Brand myBrand;

    public Model(){

    }

    public Model(String modelID, String name, Brand myBrand) {
        this.modelID = modelID;
        this.name = name;
        this.myBrand = myBrand;
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
