package A2Z;

import java.util.*;

/**
 * 
 */
public class Cart {

    private Vector<Product> products =  new Vector<Product>();

    private CreditCard creditcard = new CreditCard();

    private String address;

    private VoucherCard Vouchercard = new VoucherCard();

    private double TotalPrice;
    /**
     * Default constructor
     */
    public Cart() {
    }

    public Cart(String address, double totalPrice) {
        this.products = new Vector<>();
        this.creditcard = new CreditCard();
        this.address = address;
        this.Vouchercard = new VoucherCard();
        TotalPrice = totalPrice;
    }
    public void addProuct(Product p)
    {
        products.addElement(p);
    }

    public Vector<Product> getProducts() {
        return products;
    }

    public void setProducts(Vector<Product> products) {
        this.products = products;
    }

    public CreditCard getCreditcard() {
        return creditcard;
    }

    public void setCreditcard(CreditCard creditcard) {
        this.creditcard = creditcard;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public VoucherCard getVouchercard() {
        return Vouchercard;
    }

    public void setVouchercard(VoucherCard vouchercard) {
        Vouchercard = vouchercard;
    }

    public double getTotalPrice() {
        double t =0;
        for (Product p :products)
            t += p.getPrice();

        setTotalPrice(t);
         return t;
    }

    public void setTotalPrice(double totalPrice) {
        TotalPrice = totalPrice;
    }
}