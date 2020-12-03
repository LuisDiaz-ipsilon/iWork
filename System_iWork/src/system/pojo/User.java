/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.pojo;

import system.dataBase.DataBaseIWork;

/**
-idUsuario
-password
-userName
+VerifyLogin(); Boolean
+aplicarVacancy() 
 */
public class User {
    //local variables
    private int idUser;
    private String password;
    private String userName;
    
    DataBaseIWork dbW= new DataBaseIWork();
    User us;
    
    public User(int idUser, String userName, String password) {
        this.idUser = idUser;
        this.password = password;
        this.userName = userName;
    }
    
    public User(){
        
    }
    
    public boolean verifyLogin(String userName, String password){
        boolean verify= dbW.verifyLogin(userName, password);
        User us= dbW.getUser(userName);
        this.idUser= us.getIdUser();
        return verify;
    }
    
    public void applyForVacancy(int idUser, int idVacant, String contactEmployee, int ageEmployee){
        Vacancies vacant= dbW.getVacant(idVacant);
        
        
        dbW.applyForVacant(vacant, this.idUser, contactEmployee, ageEmployee);
       
    }
    
    public boolean userIsEmployee(User us){
        boolean isEmployee;
        isEmployee= dbW.isEmployee(this.idUser);
        return isEmployee;
    }

    public int getIdUser() {
        
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
    
    
}
