package A2Z;

public class Model {
    private String modelID;
    private String name;
    private Brand myBrand;
    private int view;

    public Model(){
        view = 0;
    }

    public Model(String modelID, String name, Brand myBrand, int view) {
        this.modelID = modelID;
        this.name = name;
        this.myBrand = myBrand;
        this.view = view;
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

    public int getView() {
        return view;
    }

    public void setView(int view) {
        this.view = view;
    }
}
