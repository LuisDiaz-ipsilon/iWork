/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.pojo;

/**
 -idUsuario
-idTrabajador
-idVacante
-contactoTrabajador; string
-edad; int
+renunciar();

 */
public class Employee extends User{
    //foreng key
    private int idUser;
    private int idVacancy;
    
    //local 
    private int idEmployee;
    private String contactEmployee;
    private int ageEmployee;

    public Employee() {
    }
    
    

    public Employee(int idUser, int idVacancy, int idEmployee, String contactEmployee, int ageEmployee) {
        this.idUser = idUser;
        this.idVacancy = idVacancy;
        this.idEmployee = idEmployee;
        this.contactEmployee = contactEmployee;
        this.ageEmployee = ageEmployee;
    }
    
    

    @Override
    public int getIdUser() {
        return idUser;
    }

    @Override
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    
    

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public String getContactEmployee() {
        return contactEmployee;
    }

    public void setContactEmployee(String contactEmployee) {
        this.contactEmployee = contactEmployee;
    }

    public int getAgeEmployee() {
        return ageEmployee;
    }

    public void setAgeEmployee(int ageEmployee) {
        this.ageEmployee = ageEmployee;
    }
    
    public void leaveJob(){
       
    }
    
}
