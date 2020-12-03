
package system.pojo;

/**
-idAdmin
-userName
+makeVacancy; vacante
+updateVancancy; vacante
+borrarVacante(); void

 */
public class admin extends User{
    //local
    private int idAdmin;
    
    //Foreing
    private String userName;
    
    public void deleteVacancy(){
       //deletevacancy
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @Override
    public String getUserName() {
        return userName;
    }

    @Override
    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}
