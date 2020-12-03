/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.pojo;


import java.sql.Time;



/**
 -idVacante
-idTrabajador
-fechaDeInicio; time

 */
public class activeJobs extends Vacancies{
    //------- foreng key
    private int idVacancy;
    private int idUser;
    
    //local
    private int idEmployee;
    private Time dateStart;

    public activeJobs(int idVacancy, String nameVacancy, double salaryVacancy, String descVacancy, String contactVacancy, int placesAvailable, int idFieldLabor) {
        super(idVacancy, nameVacancy, salaryVacancy, descVacancy, contactVacancy, placesAvailable, idFieldLabor);
    }

 
    

    @Override
    public int getIdVacancy() {
        return idVacancy;
    }

    @Override
    public void setIdVacancy(int idVacancy) {
        this.idVacancy = idVacancy;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEmployee() {
        return idEmployee;
    }

    public void setIdEmployee(int idEmployee) {
        this.idEmployee = idEmployee;
    }

    public Time getDateStart() {
        return dateStart;
    }

    public void setDateStart(Time dateStart) {
        this.dateStart = dateStart;
    }
    
    
    
}
