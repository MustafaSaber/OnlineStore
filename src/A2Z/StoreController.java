package A2Z;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class StoreController {
    private Store myStore;

    public StoreController(){}

    public StoreController(Store myStore) {
        this.myStore = myStore;
    }

    public Store getMyStore() {
        return myStore;
    }

    public void setMyStore(Store myStore) {
        this.myStore = myStore;
    }

    public boolean AddStoreToDB(String name, String storeID){
        boolean flag=true;
        File StoreFile = new File("StoreFile.txt");
        Vector<Store> myStores = new Vector<>();
        Scanner S = null;
        try {
            S = new Scanner(StoreFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (S.hasNextLine()){
            String[] words=(S.nextLine()).split("\\s+");
            Store TempBrand=new Store();
            TempBrand.setName(words[0]);
            TempBrand.setStoreID(words[1]);
            myStores.add(TempBrand);
        }
        for (int i=0;i<myStores.size();i++){
            if(myStores.elementAt(i).getName().equals(name) && myStores.elementAt(i).getStoreID().equals(storeID)){
                flag=false;
                break;
            }
        }
        if(flag==true){
            PrintWriter P=null;
            try {
                P = new PrintWriter(StoreFile);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            P.append(name+" "+storeID);
            P.close();
        }
        return flag;
    }

    public boolean RemoveStoreToDB(String name, String storeID){
        boolean flag=false;
        File StoreFile = new File("StoreFile.txt");
        Vector<Store> myStores = new Vector<>();
        Scanner S = null;
        PrintWriter P = null;
        try {
            P = new PrintWriter(StoreFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            S = new Scanner(StoreFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (S.hasNextLine()){
            String[] words=(S.nextLine()).split("\\s+");
            Store TempBrand=new Store();
            TempBrand.setName(words[0]);
            TempBrand.setStoreID(words[1]);
            myStores.add(TempBrand);
        }
        for (int i=0;i<myStores.size();i++){
            if(myStores.elementAt(i).getName().equals(name) && myStores.elementAt(i).getStoreID().equals(storeID)){
                myStores.remove(i);
                flag=true;
                break;
            }
        }
        for (int i=0;i<myStores.size();i++){
            P.println(myStores.elementAt(i).getName()+" "+myStores.elementAt(i).getStoreID());
        }
        P.close();

        return flag;
    }

    public void UpdateStoreToDB(String name,String storeID,String newName,String newStoreID){
        RemoveStoreToDB(name,storeID);
        AddStoreToDB(newName,newStoreID);
    }

    public boolean Verify(){return false;}
}
