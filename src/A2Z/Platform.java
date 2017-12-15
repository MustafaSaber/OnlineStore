package A2Z;

import javax.swing.*;

public class Platform {
    public void fillDB()
    {
        //Brands
        Brand brand1 = new Brand("Apple","01");
        Brand brand2 = new Brand("Lenovo","02");
        //Models
        Model model11 = new Model("011","iPhone 6",brand1);
        Model model12 = new Model("012","iPhone 7",brand1);
        Model model21 = new Model("021","Laptop5",brand2);
        Model model22 = new Model("022","MobileX4",brand2);
        //add models to brands
        brand1.getModels().add(model11);
        brand1.getModels().add(model12);
        brand2.getModels().add(model21);
        brand2.getModels().add(model22);
        //add Models
        system.models.add(model11);
        system.models.add(model12);
        system.models.add(model21);
        system.models.add(model22);
        //add brands
        system.brands.add(brand1);
        system.brands.add(brand2);
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
