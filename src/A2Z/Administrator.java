package A2Z;

/**
 * Created by Mina_Yousry on 08/12/2017.
 */
public class Administrator extends User{

    public Administrator() {
    }

    public Administrator(String name, String email, String username, String password) {
        super(name, email, username, password);
    }

    public boolean AddAdminToDb()
    {
        return true;
    }

    public boolean RemoveAdminFromDb()
    {
        return true;
    }

    public boolean UpdateAdminInDb()
    {
        return true;
    }
}
