package A2Z;

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
    public boolean PayByCardCont() {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public boolean PayOnDeliveryCont() {
        // TODO implement here
        return false;
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

    /**
     * @param CardID 
     * @return
     */
    public void VerifyData(Card CardID) {
        // TODO implement here
    }

}