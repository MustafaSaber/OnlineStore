package A2Z;

public class NormalCustomerController {

    /**
     * Default constructor
     */
    public NormalCustomerController() {}

    public NormalCustomerController(NormalCustomer normal) {

        this.normal = normal;
    }

    public NormalCustomer getNormal() {
        return normal;
    }

    public void setNormal(NormalCustomer normal) {
        this.normal = normal;
    }

    private NormalCustomer normal = new NormalCustomer();


    /**
     * @param Name 
     * @param Email 
     * @param UserName 
     * @param password 
     * @return
     */
    public Boolean AddUserToDBCont(String Name, String Email, String UserName, String password) {
        if (existMailUsername(UserName,Email))
            return false;
        system.normalCustomers.add(
                new NormalCustomer(Name,Email,UserName,password));
        return true;
    }

    /**
     * @return
     */
    public Boolean UpdateUserNameInDBCont(String username, String name) {
        NormalCustomer n = searchByUsername(username);
        if (n == null)
            return false;
        n.setName(name);
        return true;
    }

    public Boolean UpdateUserPassInDBCont(String username, String pass) {
        NormalCustomer n = searchByUsername(username);
        if (n == null)
            return false;
        n.setPassword(pass);
        return true;
    }


    /**
     * @param Username 
     * @return
     */
    public Boolean RemoveFromDBCont(String Username) {
        NormalCustomer n = searchByUsername(Username);
        if (n == null)
            return false;
        system.normalCustomers.remove(n);
        return true;
    }

    private NormalCustomer searchByUsername(String username)
    {
        for (NormalCustomer a : system.normalCustomers)
            if (a.getUsername().equals(username))
                return a;
        return null;
    }

    private boolean existMailUsername(String username, String mail)
    {
        for (NormalCustomer a : system.normalCustomers)
            if (a.getUsername().equals(username) || a.getEmail().equals(mail))
                return true;
        return false;
    }

    public void SuggestModelCont(String name,String id,Brand b) {
        Model model = new Model(id,name,b);
        system.suggestModels.add(model);
    }

    public void SuggestBrandCont(String id,String name) {
        Brand brand = new Brand(name,id);
        system.suggestBrands.add(brand);
    }

}