package A2Z;

/**
 * Created by Mina_Yousry on 08/12/2017.
 */
public class NormalCustomerController {
    private NormalCustomer normalCustomer;

    public NormalCustomerController() {

    }

    public NormalCustomerController(NormalCustomer normalCustomer) {

        this.normalCustomer = normalCustomer;
    }

    public NormalCustomer getNormalCustomer() {
        return normalCustomer;
    }

    public void setNormalCustomer(NormalCustomer normalCustomer) {
        this.normalCustomer = normalCustomer;
    }


    public NormalCustomer searchForNormalCustomer(String username)
    {
        for (NormalCustomer n : system.normalCustomers)
            if (n.getUsername().equals(username))
                return n;
        return null;
    }

    public boolean AddUserToDBCont(String name,String email,
                                   String username,String password) {
        if (searchForNormalCustomer(username) != null)
            return false;
        NormalCustomer n = new NormalCustomer(name,email,username,password);
        return n.AddUserToDb();
    }

    public boolean UpdateUserNameInDbCont(String username,String name)
    {
        NormalCustomer n = searchForNormalCustomer(username);
        if (n == null)
            return false;
        n.setName(name);
        return true;
    }

    public boolean UpdateUserPassInDbCont(String username,String password)
    {
        NormalCustomer n = searchForNormalCustomer(username);
        if (n == null)
            return false;
        n.setPassword(password);
        return true;
    }


    public boolean RemoveUserFromDBCont(String username)
    {
        NormalCustomer n = searchForNormalCustomer(username);
        if (username == null)
            return false;
        return n.RemoveUserFromDB();
    }

}
