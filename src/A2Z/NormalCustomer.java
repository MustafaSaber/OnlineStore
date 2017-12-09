package A2Z;

/**
 * Created by Mina_Yousry on 08/12/2017.
 */
public class NormalCustomer  extends User {

    public NormalCustomer() {

    }

    public NormalCustomer(String name, String email,
                          String username, String password) {
        super(name, email, username, password);
    }

    public boolean AddUserToDb()
    {
        system.normalCustomers.add(this);
        return true;
    }

    public boolean RemoveUserFromDB()
    {
        system.normalCustomers.remove(this);
        return true;
    }

}
