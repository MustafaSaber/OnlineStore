package A2Z;

/**
 * Created by Mina_Yousry on 14/12/2017.
 */
public class StoreOwnerPremuim extends StoreOwner {
    public String NumberOfViewsForEachProduct() //number of views of each model in a store
    {
        String rtrn = "";
        for (Store store : this.getStores())
        {
            for(Product p : store.getProducts()) {
                rtrn += ("Product: " + p.getModel().getName() + " >> " + p.getModel().getView()) + "\n";
            }
        }
        return rtrn;
    }

    public String MostViewiedProductInEachStore() //	Get the most viewed product in a store
    {
        int mostViews = 0;
        String modelName = "";
        String rtrn;
        for (Store store : this.getStores())
        {
            for(Product p : store.getProducts())
            {
                modelName = p.getModel().getName();
                if(mostViews < (p.getModel().getView()))
                    mostViews = p.getModel().getView();

            }
        }
        rtrn = ("The most viewed product: "+ modelName+" >> "+ mostViews);
        return rtrn;
    }

    public StoreOwnerPremuim() {
    }

    public StoreOwnerPremuim(String name, String email, String username, String password) {
        super(name, email, username, password);
    }
}
