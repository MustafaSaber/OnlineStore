package A2Z;

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

    public boolean AddModelToDB(Model myModel){
        boolean flag = true;

        return flag;
    }

    public boolean RemoveModelFromDB(String modelName){
        boolean flag = true;

        return flag;
    }

    public boolean UpdateModelDB(String modelName){
        boolean flag = true;

        return flag;
    }

}
