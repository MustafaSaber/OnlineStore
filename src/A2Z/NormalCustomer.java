package A2Z;

public class NormalCustomer extends User {
    private Cart cart;
    /**
     * Default constructor
     */
    public NormalCustomer() {}

    public NormalCustomer(String name, String email, String username, String password) {
        super(name, email, username, password);
        cart = new Cart();
    }

    public NormalCustomer(String name, String email, String username, String password, Cart cart) {
        super(name, email, username, password);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}