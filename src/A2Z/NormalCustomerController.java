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

    public boolean AddUserToDBCont(String name,String email,
                                   String username,String password) {
        normalCustomer = new NormalCustomer(name,email,username,password);
        return normalCustomer.AddUserToDb();
    }

    public boolean UpdateUserInDbCont()
    {
        return normalCustomer.UpdateUserInDb();
    }


    public boolean RemoveUserFromDBCont()
    {
        return normalCustomer.RemoveUserFromDB();
    }

}
