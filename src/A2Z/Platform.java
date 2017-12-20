package A2Z;

import javax.swing.*;

public class Platform {
    public void fillDB()
    {
        //Brands
        Brand brand1 = new Brand("Apple","brand1");
        Brand brand2 = new Brand("Lenovo","brand2");
        Brand brand3 = new Brand("Google","brand3");
        //Models
        Model model11 = new Model("model1","iPhone 6",brand1);
        Model model12 = new Model("model2","iPhone 7",brand1);
        Model model21 = new Model("model3","Laptop5",brand2);
        Model model22 = new Model("model4","MobileX4",brand2);
        Model model31 = new Model("model5","Pixel1",brand3);
        Model model32 = new Model("model6","Chrome",brand3);
        //add models to brands
        brand1.getModels().add(model11);
        brand1.getModels().add(model12);
        brand2.getModels().add(model21);
        brand2.getModels().add(model22);
        brand3.getModels().add(model31);
        brand3.getModels().add(model32);
        //add Models
        system.models.add(model11);
        system.models.add(model12);
        system.models.add(model21);
        system.models.add(model22);
        system.models.add(model31);
        system.models.add(model32);
        //add brands
        system.brands.add(brand1);
        system.brands.add(brand2);
        system.brands.add(brand3);
        //Admin
        Administrator admin = new Administrator("admin","admin","admin","admin");
        system.administrators.add(admin);
    }
    public static void main(String[] args){
        Platform p = new Platform();
        p.fillDB();

        View object=new View();
        object.setVisible(true);
        object.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
