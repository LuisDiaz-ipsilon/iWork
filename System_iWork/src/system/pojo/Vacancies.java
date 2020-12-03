/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.pojo;

/**
-idCampoLa
-idVacante
-NameVacancy; string
-Sueldo; double
-description; String
-contact; Srting
-lugares; int
+searchVacancy(overload);
+showVacancy(); vancante

 */
public class Vacancies {
    //foreing
    private int idFieldLabor;
    
    //--------local
    
    private int idVacancy;
    private String nameVacancy;
    private double salaryVacancy;
    private String descVacancy;
    private String contactVacancy;
    private int placesAvailable;
    
    public Vacancies(){
        
    }

    public Vacancies(int idVacancy, String nameVacancy, double salaryVacancy, String descVacancy, String contactVacancy, int placesAvailable, int idFieldLabor) {
        this.idFieldLabor = idFieldLabor;
        this.idVacancy = idVacancy;
        this.nameVacancy = nameVacancy;
        this.salaryVacancy = salaryVacancy;
        this.descVacancy = descVacancy;
        this.contactVacancy = contactVacancy;
        this.placesAvailable = placesAvailable;
    }
    
    
    
    
    public Vacancies searhVacancy(){
        return null;
    }

    public int getIdFieldLabor() {
        return idFieldLabor;
    }

    public void setIdFieldLabor(int idFieldLabor) {
        this.idFieldLabor = idFieldLabor;
    }

    public int getIdVacancy() {
        return idVacancy;
    }

    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public String getDescVacancy() {
        return descVacancy;
    }

    public void setDescVacancy(String descVacancy) {
        this.descVacancy = descVacancy;
    }

    public String getNameVacancy() {
        return nameVacancy;
    }

    public void setNameVacancy(String nameVacancy) {
        this.nameVacancy = nameVacancy;
    }

    public double getSalaryVacancy() {
        return salaryVacancy;
    }

    public void setSalaryVacancy(double salaryVacancy) {
        this.salaryVacancy = salaryVacancy;
    }

    public String getContactVacancy() {
        return contactVacancy;
    }

    public void setContactVacancy(String contactVacancy) {
        this.contactVacancy = contactVacancy;
    }   

    public int getPlacesAvailable() {
        return placesAvailable;
    }

    public void setPlacesAvailable(int placesAvailable) {
        this.placesAvailable = placesAvailable;
    }
    
}
