package A2Z;

import A2Z.Cart;

/**
 * 
 */
public class NormalCustomer extends User {

    /**
     * Default constructor
     */
    public NormalCustomer() {
    }

    public NormalCustomer(String name, String email, String username, String password) {
        super(name, email, username, password);
        cart = new Cart();
    }

    public NormalCustomer(String name, String email, String username,
                          String password, Cart cart) {
        super(name, email, username, password);
        this.cart = cart;
    }

    /**
     *

     */
    private Cart cart;




}