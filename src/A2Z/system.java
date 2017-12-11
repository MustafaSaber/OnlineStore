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

    static public StoreController sc = new StoreController();
    static public ProductController productcon = new ProductController();
}