package A2Z;

import A2Z.Product;

/**
 * 
 */
public class ProductController {

    /**
     * Default constructor
     */
    public ProductController() {
    }

    /**
     * 
     */
    private Product p;


    /**
     * @return
     */
    public String printInfoandUpdateView(Product p) {
        int f = p.getModel().getView();
        p.getModel().setView(++f);
        return ("Product ID: "+p.getProductID() + " ,Product brand: " + p.getBrand().getName() + " ,Product model: " + p.getModel().getName() + " ,Product price: " + p.getPrice() + " ,Product store: " + p.getStore().getName() + " ,No of views: " + p.getModel().getView());
    }

    public String PrintInfoOnly(Product p) {
       return ("Product ID: "+p.getProductID() + " ,Product brand: " + p.getBrand().getName() + "\n,Product model: " + p.getModel().getName() + "\n,Product price: " + p.getPrice() + "\n,Product store: " + p.getStore() + "\n,No of views: " + p.getModel().getView());
    }

}