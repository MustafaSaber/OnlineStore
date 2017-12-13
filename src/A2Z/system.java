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
    static public BrandController BrandCon = new BrandController();
    static public ProductController ProductCon = new ProductController();
    static public ModelController ModelCon = new ModelController();
    static public AdministratorController AdminCon = new AdministratorController();
    static public StoreOwner StoreOwner = new StoreOwner();
    static public StoreOwnerController StoreOwnerCon = new StoreOwnerController();


}