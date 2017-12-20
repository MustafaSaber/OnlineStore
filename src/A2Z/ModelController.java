package A2Z;
import static A2Z.system.models;
import static A2Z.system.suggestModels;

public class ModelController {
    private Model model;

    public ModelController(){

    }

    public ModelController(Model model) {
        this.model = model;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public boolean AddModelToDB(String modelName,String modelID, String brandID, String brandName ){
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

    public boolean RemoveModelFromDB(String modelID) {
        boolean flag = false;

        for (int i=0;i<models.size();i++){
            if(models.get(i).getModelID().equals(modelID) ){
                models.remove(i);
                flag=true;
                break;
            }
        }

        return flag;
    }

    public boolean UpdateModelDB(String oldModelID, String modelID,String modelName, String brandID, String brandName){
        boolean flag ;

        flag = RemoveModelFromDB(oldModelID);
        if(flag){flag = AddModelToDB(  modelID,modelName, brandID, brandName);}

        return flag;
    }

}
