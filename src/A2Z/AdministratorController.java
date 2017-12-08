package A2Z;

/**
 * Created by Mina_Yousry on 08/12/2017.
 */
public class AdministratorController {
    Administrator administrator;

    public AdministratorController() {
    }

    public AdministratorController(Administrator administrator) {

        this.administrator = administrator;
    }

    public void OpenBrandView()
    {
        //openBrandView;
    }
    public boolean AddAdminToDBCont(String name,String email,
                                    String username,String password) {
        Administrator admin = searchForAdmin(username);
        if (admin != null)
            return false;

        admin = new Administrator(name,email,username,password);

        return admin.AddAdminToDb();
    }

    public Administrator searchForAdmin(String username)
    {
        for (Administrator a : System.administrators)
        {
            if (a.getUsername().equals(username))
                return a;
        }
        return null;
    }

public boolean RemoveAdminFromDBCont(String username)
    {

        Administrator admin = searchForAdmin(username);
        if (admin == null)
            return false;
        return admin.RemoveAdminFromDb();
    }




}
