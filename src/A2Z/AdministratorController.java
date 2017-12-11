package A2Z;

import A2Z.Administrator;

/**
 * 
 */
public class AdministratorController {

    /**
     * Default constructor
     */
    public AdministratorController() {
    }

    /**
     * 
     */
    public Administrator admin;


    /**
     * @return
     */
    public void AddBrandCont() {
        //open brand view;
    }

    /**
     * @return
     */
    public void RemoveBrandCont() {
        //open brand view;
    }

    /**
     */
    public void AddModelCont() {
        // model view ;
    }

    /**
     * @return
     */
    public void RemoveModelCont() {
        // model view ;
    }

    /**
     * @param name
     * @param email
     * @param username 
     * @param password 
     * @return
     */

    public Boolean AddAdminToDBCont(String name,String email, String username, String password) {
        if (existMailUsername(username,email))
            return false;
        Administrator a = new Administrator(name,email,username,password);
        system.administrators.add(a);
        return true;
    }

    /**
     * @return
     */
    public Boolean RemoveAdminFromDBCont(String username) {
        Administrator a = searchByUsername(username);
        if (a == null)
            return false;
        system.administrators.remove(a);
        return true;
    }

    public boolean UpdateAdminName(String username ,String name)
    {
        Administrator a = searchByUsername(username);
        if (a == null)
            return false;
        a.setName(name);
        return true;
    }

    public boolean UpdateAdminPassword(String username ,String pass)
    {
        Administrator a = searchByUsername(username);
        if (a == null)
            return false;
        a.setPassword(pass);
        return true;
    }

    /**
     * @param
     * @return
     */
    public String ViewSuggbrandCont() {
        String s = "";
        for (Brand b : system.brands)
            s += b.getName()+"\n";
        return s;
    }


    public String ViewSuggModelsCont() {
        String s = "";
        for (Model m : system.models)
            s+=m.getName()+ " " + m.getMyBrand().getName() +"\n";
        return s;
    }


    private Administrator searchByUsername(String username)
    {
        for (Administrator a : system.administrators)
            if (a.getUsername().equals(username))
                return a;
        return null;
    }

    private boolean existMailUsername(String username, String mail)
    {
        for (Administrator a : system.administrators)
            if (a.getUsername().equals(username) || a.getEmail().equals(mail))
                return true;
        return false;
    }
}