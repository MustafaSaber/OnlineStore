package A2Z;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class StoreOwnerControllerTest {

    @Test
    public void addStoreOwnertest(){
        int tempsize = system.storeOwners.size();
        system.StoreOwnerCon.AddStoreOwnerToDBCont( "a" , "a" , "a" , "a" , true);
        int tempsize2 = system.storeOwners.size();
        Assert.assertEquals(tempsize+1 , tempsize2);
        system.storeOwners.remove(system.storeOwners.size()-1);
    }

    @Test
    public void removeStoreOwnertest(){
        system.StoreOwnerCon.AddStoreOwnerToDBCont("a" , "a" , "a" , "a" , true);
        Assert.assertEquals(system.StoreOwnerCon.RemoveStoreOwnerToDBCont("a" , "a") , true);
    }


    @Test
    public void addStoreT(){
        int tempsize = system.stores.size();
        system.StoreOwnerCon.AddStoreCont("a" , "1" , "add" , false , true);
        Assert.assertEquals(tempsize+1, system.stores.size());
        system.StoreOwnerCon.AddStoreCont("b" , "1" , "link" , true , false);
        Assert.assertEquals(tempsize+1, system.stores.size());
    }

    @Test
    public void removeStoreT(){
        system.StoreOwnerCon.AddStoreCont("a" , "1" , "add" , false, true);
        Assert.assertEquals(system.StoreOwnerCon.RemoveStoreCont("a" , "1") , true);
        Assert.assertEquals(system.StoreOwnerCon.RemoveStoreCont("a" , "1") , false);
    }

    @Test
    public void suggestModelandBrandT(){
        Brand x = new Brand("1" , "TV brand");
        int tempbrandSize = system.suggestBrands.size();
        int tempmodelSize = system.suggestModels.size();
        system.StoreOwnerCon.SuggestBrandCont("5" , "TV brand");
        Assert.assertEquals(tempbrandSize +1 , system.suggestBrands.size());
        system.StoreOwnerCon.SuggestModelCont("a" , "8" , x);
        Assert.assertEquals(tempmodelSize +1 , system.suggestModels.size());
        system.suggestModels.remove(system.suggestModels.size()-1);
        system.suggestBrands.remove(system.suggestBrands.size()-1);
    }
}