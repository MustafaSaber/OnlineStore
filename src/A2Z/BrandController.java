package A2Z;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Nardeen on 08-Dec-17.
 */
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
        File BrandFile = new File("BrandFile.txt");
        Vector<Brand> myBrands = new Vector<>();

        Scanner S = null;
        try {
            S = new Scanner(BrandFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (S.hasNextLine()){
            String[] words=(S.nextLine()).split("\\s+");
            Brand TempBrand=new Brand();
            TempBrand.setName(words[0]);
            TempBrand.setBrandID(words[1]);
            myBrands.add(TempBrand);
        }
        for (int i=0;i<myBrands.size();i++){
            if(myBrands.elementAt(i).getName().equals(name) && myBrands.elementAt(i).getBrandID().equals(brandID)){
                flag=false;
                break;
            }
        }
        if(flag==true){
            PrintWriter P=null;
            try {
                P = new PrintWriter(BrandFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            P.append(name+" "+brandID);
            P.close();
        }

        return flag;
    }

    public boolean RemoveBrandToDB(String name,String brandID){
        boolean flag=false;
        File BrandFile = new File("BrandFile.txt");
        Vector<Brand> myBrands = new Vector<>();
        PrintWriter P = null;
        try {
            P = new PrintWriter(BrandFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Scanner S = null;
        try {
            S = new Scanner(BrandFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (S.hasNextLine()){
            String[] words=(S.nextLine()).split("\\s+");
            Brand TempBrand=new Brand();
            TempBrand.setName(words[0]);
            TempBrand.setBrandID(words[1]);
            myBrands.add(TempBrand);
        }
        for (int i=0;i<myBrands.size();i++){
            if(myBrands.elementAt(i).getName().equals(name) && myBrands.elementAt(i).getBrandID().equals(brandID)){
                myBrands.remove(i);
                flag=true;
                break;
            }
        }
        for (int i=0;i<myBrands.size();i++){
            P.println(myBrands.elementAt(i).getName()+" "+myBrands.elementAt(i).getBrandID());
        }
        P.close();

        return flag;

    }

    public void UpdateBrandToDB(String name,String brandID,String newName,String newBrandID){
        RemoveBrandToDB(name,brandID);
        AddBrandToDB(newName,newBrandID);
    }
}
