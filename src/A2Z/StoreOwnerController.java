package A2Z;

/**
 * Created by Nardeen on 08-Dec-17.
 */
public class StoreOwnerController {
    private StoreOwner so = new StoreOwner();

    public StoreOwnerController() {
    }

    public StoreOwnerController(StoreOwner so) {
        this.so = so;
    }

    public StoreOwner getSo() {
        return so;
    }

    public void setSo(StoreOwner so) {
        this.so = so;
    }


}
