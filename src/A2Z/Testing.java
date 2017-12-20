package A2Z;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class Testing {

    @Test
    public void addProd2Carttest(){
        Store s1 = new Store("ss", "5");
        Brand b1 = new Brand("bb", "10");
        NormalCustomer nc = new NormalCustomer("nc1","nc1" , "nc1" , "nc1");
        system.NormalCustomerCon.setNormal(nc);
        Product p1 = new Product("20", new Model( "10"  , "mm" , b1) , b1 , 20 , s1);
        Product p2 = new Product("21", new Model( "10"  , "mm" , b1), b1 , 10 , s1);
        Product p3 = new Product("22", new Model( "10"  , "mm" , b1) , b1 , 15 , s1);
        Product p4 = new Product("23", new Model( "10"  , "mm" , b1) , b1 , 15 , s1);
        system.ProductCon.printInfoandUpdateView(p1);
        system.ProductCon.printInfoandUpdateView(p1);
        system.ProductCon.printInfoandUpdateView(p1);
        system.ProductCon.printInfoandUpdateView(p1);
        system.ProductCon.printInfoandUpdateView(p2);
        system.ProductCon.printInfoandUpdateView(p2);
        system.ProductCon.printInfoandUpdateView(p2);
        system.ProductCon.printInfoandUpdateView(p3);
        system.ProductCon.printInfoandUpdateView(p3);
        Assert.assertEquals(p1.getModel().getView() , 4);
        Assert.assertEquals(p2.getModel().getView() , 3);
        Assert.assertEquals(p3.getModel().getView() , 2);
        system.cartController.setCart(nc.getCart());
        assertEquals(system.cartController.AddToCartCont(p1) , true);
        assertEquals(system.cartController.AddToCartCont(p2) , true);
        assertEquals(system.cartController.AddToCartCont(p3) , true);
        assertEquals(system.cartController.AddToCartCont(p4) , true);
        Assert.assertEquals(system.cartController.GetTotalPriceCont(), 60 , Math.pow(10,-6));
        //StoreOwner so = new StoreOwnerPremuim("so1", "so1" ,"so1" ,"so1");
        //so.updateStores(s1);

    }

    @Test
    public void loginT(){

    }

}