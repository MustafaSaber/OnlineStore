package A2Z;

import A2Z.Card;
import A2Z.Cart;
import A2Z.system;

import java.util.Date;
import java.util.Scanner;

/**
 * 
 */
public class CartController {

    /**
     * Default constructor
     */
    public CartController() {
    }

    /**
     * 
     */
    private Cart cart;

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    /**
     * @param
     * @return
     */
    public Boolean AddToCartCont(Product prouduct ) {
        return cart.getProducts().add(prouduct);
    }

    /**
     * @return
     */
    public Boolean RemoveFromCartCont(Product p) {
        for (Product curr : cart.getProducts()){
            if(curr.getProductID()==p.getProductID())
            {
                cart.getProducts().remove(p);
                return true;
            }
        }
        return false;
    }

    /**
     * @return
     */
    public double GetTotalPriceCont() {
        double tp = 0;
        for(Product curr: cart.getProducts()) tp+=curr.getPrice();
        return tp;
    }

    /**
     * @return
     */
    public boolean CheckOutCont() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean PayByCreditCont() {
       double mo =  GetTotalPriceCont();
        if(cart.getCreditcard().getMyMoney() < mo) {
            System.out.println("Sorry you don't have enough credit");
            return false;
        }
        else {
            cart.getCreditcard().setMyMoney(cart.getCreditcard().getMyMoney() - mo);
            System.out.println("You buyed items successfully!");
            return true;
        }

    }

    public boolean PayByVoucherCont() {
        double mo =  GetTotalPriceCont();
        Date currdate = new Date();
        if(cart.getVouchercard().getValue() < mo || cart.getVouchercard().getExpiryDate().after(currdate)) {
            System.out.println("Sorry you can't use this voucher card to buy this item");
            return false;
        }
        else {
            cart.getVouchercard().setValue(cart.getVouchercard().getValue() - mo);
            System.out.println("You buyed items successfully!");
            return true;
        }
    }

    /**
     * @return
     */
    public boolean PayOnDeliveryCont() {
        System.out.println("Your items will be sent to:" + cart.getAddress());
        return true;
    }

    /**
     * @return
     */
    public void ShowItemsCont() {
        for(Product curr: cart.getProducts()){
            system.ProductCon.PrintInfoOnly(curr);
        }
    }

    /**
     * @return
     */
    public Boolean AddVoucherCont(VoucherCard vc) {
        if(cart.getVouchercard()==null) {
            cart.setVouchercard(vc);
            return true;
        }
        else {
            cart.getVouchercard().setValue(cart.getVouchercard().getValue()+vc.getValue());
            return true;
        }
    }

    /**
     * @return
     */
    public Boolean RemoveVoucherCont() {
        if(cart.getVouchercard()==null)
            return false;
        cart.setVouchercard(null);
        return true;
    }


}