package A2Z;
import java.util.*;


public class system {
    static public ArrayList<NormalCustomer> normalCustomers = new ArrayList<>();
    static public ArrayList<Administrator> administrators = new ArrayList<>();
    static public ArrayList<StoreOwner> storeOwners = new ArrayList<>();
    static public ArrayList<Brand> brands = new ArrayList<>();
    static public ArrayList<Model> models = new ArrayList<>();
    static public ArrayList<Store> stores = new ArrayList<>();
    static public ArrayList<VoucherCard> voucherCards = new ArrayList<>();
    static public ArrayList<Brand> suggestBrands  = new ArrayList<>();
    static public ArrayList<Model> suggestModels  = new ArrayList<>();

    static public StoreController StoreCon = new StoreController();
    static public NormalCustomerController NormalCustomerCon = new NormalCustomerController();
    static public BrandController BrandCon = new BrandController();
    static public ProductController ProductCon = new ProductController();
    static public ModelController ModelCon = new ModelController();
    static public AdministratorController AdminCon = new AdministratorController();
    static public CartController cartController = new CartController();
    static public StoreOwner StoreOwner; //= new StoreOwner();
    static public StoreOwnerController StoreOwnerCon = new StoreOwnerController();


    static boolean CheckForStoreOwner(String username)
    {
        for(int i=0;i<storeOwners.size();i++){
            if(storeOwners.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    static boolean CheckForNormalCustmer(String username)
    {
        for(int i=0;i<normalCustomers.size();i++){
            if(normalCustomers.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
    static boolean CheckForAdmin(String username)
    {
        for(int i=0;i<administrators.size();i++){
            if(administrators.get(i).getUsername().equals(username)){
                return true;
            }
        }
        return false;
    }
}