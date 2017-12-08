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

    public void OpenBrandView() {
        //openBrandView;
    }
    public void OpenModelView() {
        //open ModelView;
    }


    public boolean AddAdminToDBCont(String name, String email,
                                    String username, String password) {
        Administrator admin = searchForAdmin(username);
        if (admin != null)
            return false;

        admin = new Administrator(name, email, username, password);

        return admin.AddAdminToDb();
    }

    public Administrator searchForAdmin(String username) {
        for (Administrator a : system.administrators) {
            if (a.getUsername().equals(username))
                return a;
        }
        return null;
    }

    public boolean UpdateAdminNameInDBCont(String username,String name)
    {
        Administrator admin = searchForAdmin(username);
        if (admin == null)
            return false;

        admin.setUsername(name);
        return true;
    }

    public boolean UpdateAdminPassInDBCont(String username,String password)
    {
        Administrator admin = searchForAdmin(username);
        if (admin == null)
            return false;

        admin.setPassword(password);
        return true;
    }

    public boolean RemoveAdminFromDBCont(String username) {

        Administrator admin = searchForAdmin(username);
        if (admin == null)
            return false;
        return admin.RemoveAdminFromDb();
    }

    public void ViewSuggBrandsCont()
    {
        System.out.println("Suggested Brands is : ");
        for (Brand b : system.suggestBrands)
        {
            System.out.println(b.getName());
        }
    }

    public void ViewSuggModelsCont()
    {

    }



}
