package A2Z;

/**
 * Created by Mina_Yousry on 14/12/2017.
 */
public class StoreOwnerRegular extends StoreOwner {
    public String MostViewiedProductInEachStore() //	Get the most viewed product in a store
    {
        return ("Regular accounts can't view Stats");
    }

    public String NumberOfViewsForEachProduct() //number of views of each model in a store
    {
        return ("Regular accounts can't view Stats");
    }

    public StoreOwnerRegular() {
    }

    public StoreOwnerRegular(String name, String email, String username, String password) {

        super(name, email, username, password);
    }
}

