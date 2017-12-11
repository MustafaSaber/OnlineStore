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
    public void printInfoandUpdateView(Product p) {
        System.out.println("Product ID: "+p.getProductID() + " ,Product brand: " + p.getBrand() + " ,Product model: " + p.getModel() + " ,Product price: " + p.getPrice() + " ,Product store: " + p.getStore());
        int f = p.getModel().getView();
        p.getModel().setView(f++);
    }

    public void PrintInfoOnly(Product p) {
        System.out.println("Product ID: "+p.getProductID() + " ,Product brand: " + p.getBrand() + " ,Product model: " + p.getModel() + " ,Product price: " + p.getPrice() + " ,Product store: " + p.getStore());
    }

}