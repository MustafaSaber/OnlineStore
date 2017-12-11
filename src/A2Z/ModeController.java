package A2Z;
import static A2Z.system.models;

public class ModeController {
    private Model model;

    public ModeController(){

    }

    public ModeController(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean AddModelToDB(String modelID, String modelName, String brandID, String brandName ){
        boolean flag = true;

        for (int i=0;i<models.size();i++){
            if(models.get(i).getModelID().equals(modelID) && models.get(i).getName().equals(modelName) && models.get(i).getMyBrand().getBrandID().equals(brandID) && models.get(i).getMyBrand().getName().equals(brandName)){
                flag=false;
                break;
            }
        }

        if(flag == true){
            Model myModel = new Model();
            myModel.setModelID(modelID);
            myModel.setName(modelName);
            myModel.getMyBrand().setBrandID(brandID);
            myModel.getMyBrand().setName(brandName);
            models.add(myModel);
        }

        return flag;
    }

    public boolean RemoveModelFromDB(String modelName, String modelID, String brandID, String brandName){
        boolean flag = false;

        for (int i=0;i<models.size();i++){
            if(models.get(i).getName().equals(modelName) && models.get(i).getModelID().equals(modelID) && models.get(i).getMyBrand().getBrandID().equals(brandID) && models.get(i).getMyBrand().getName().equals(brandName)){
                models.remove(i);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public boolean UpdateModelDB(String modelName, String modelID, String brandID, String brandName){
        boolean flag1;
        boolean flag2;
        boolean flag = true;

        flag1 = RemoveModelFromDB(modelName, modelID, brandID, brandName);
        flag2 = AddModelToDB( modelName, modelID, brandID, brandName);

        if(flag1 == false || flag2 == false){
            flag = false;
        }

        return flag;
    }

}
