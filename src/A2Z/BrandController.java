
package A2Z;

import static A2Z.system.brands;
import static A2Z.system.suggestBrands;

public class BrandController {
    private Brand myBrand;

    public BrandController(){}

    public BrandController(Brand myBrand) {
        this.myBrand = myBrand;
    }

    public Brand getMyBrand() {
        return myBrand;
    }

    public void setMyBrand(Brand myBrand) {
        this.myBrand = myBrand;
    }

    public boolean AddBrandToDB(String name,String brandID){
        boolean flag=true;
        for (int i=0;i<brands.size();i++){
            if(brands.get(i).getName().equals(name) && brands.get(i).getBrandID().equals(brandID)){
                flag=false;
                break;
            }
        }
        if(flag==true){
            Brand BrandObj=new Brand();
            BrandObj.setName(name); BrandObj.setBrandID(brandID);
            brands.add(BrandObj);
            for(int i = 0; i < system.suggestBrands.size(); i++)
            {
                if(suggestBrands.get(i).getBrandID().equals(brandID) && suggestBrands.get(i).getName().equals(name))
                    suggestBrands.remove(i);
            }
        }
        return flag;
    }

    public boolean RemoveBrandToDB(String name,String brandID){
        boolean flag=false;

        for (int i=0;i<brands.size();i++){
            if(brands.get(i).getName().equals(name) && brands.get(i).getBrandID().equals(brandID)){
                brands.remove(i);
                flag=true;
                break;
            }
        }

        return flag;

    }

    public boolean UpdateBrandToDB(String name,String brandID,String newName){
        boolean flag;
        flag=RemoveBrandToDB(name,brandID);
        if(flag==true){
           flag= AddBrandToDB(newName,brandID);
        }
        return flag;
    }
}
