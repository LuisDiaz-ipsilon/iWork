/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package system.dataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import system.pojo.Employee;
import system.pojo.User;
import system.pojo.Vacancies;
import system.pojo.fieldLabor;


/**
 *
 * @author Luis Fernando
 */
public class DataBaseIWork {
    
    Connection conn= null;
    PreparedStatement st= null;
    ResultSet rs= null;
    
     public DataBaseIWork(){
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
     public void insertVacant(Vacancies vacant){         
         try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
           
            
            String sql= "INSERT INTO vacancies (id_laborfield, id_vacant, name_vacant, salary_vacant, desc_vacant, contact_vacant, places_available)"
            + " VALUES (?, ?, ?, ?, ?, ?, ?)";
        
            st= conn.prepareStatement(sql);
            
            st.setInt(1, vacant.getIdFieldLabor());
            st.setInt(2, vacant.getIdVacancy());
            st.setString(3, vacant.getNameVacancy());
            st.setDouble(4, vacant.getSalaryVacancy());
            st.setString(5, vacant.getDescVacancy());
            st.setString(6, vacant.getContactVacancy());
            st.setInt(7, vacant.getPlacesAvailable());
            
            st.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
     }
     
     public void insertLaborField(fieldLabor laborField){
         try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
           
            
            String sql= "INSERT INTO labor_field (id_laborfield, name_laborfield, desc_laborfield, id_location)"
            + " VALUES (?, ?, ?, ?)";
        
            st= conn.prepareStatement(sql);
            
            st.setInt(1, laborField.getIdFieldLabor());
            st.setString(2, laborField.getNameFieldLabor());
            st.setString(3, laborField.getDescLaborField());
            st.setInt(4, 11);
            //por el momenrto solo se agrega a la localicacion 11 solo por la version americana
            
            st.executeUpdate();
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
     
    public void registerUser(User registerUser){
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
           
            
            String sql= "INSERT INTO user_iwork (id_user, password, user_name)"
            + " VALUES (?, ?, ?)";
        
            st= conn.prepareStatement(sql);
            
            st.setInt(1, registerUser.getIdUser());
            st.setString(2, registerUser.getPassword());
            st.setString(3, registerUser.getUserName());
            
            st.executeUpdate();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
            ex.printStackTrace();
        } catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, "please fill in the fields correctly");
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
                ex.printStackTrace();
            }
        }
    }
    
    public boolean verifyLogin(String userName, String password){
        boolean credential = false;
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            
            String sql= "SELECT * FROM user_iwork WHERE user_name=?";
            
            st=conn.prepareStatement(sql);
                  
            st.setString(1, userName);           
            
            rs= st.executeQuery();
            
            while(rs.next()){
                int id= rs.getInt("id_user");
                String passDB= rs.getString("password");
                String userNameDB= rs.getString("user_name");
                
                
                
                if(passDB.equals(password)){
                    User us= new User(id, userNameDB, passDB);
                    credential=true;
                } else {
                    credential=false;
                }
                
            }
            
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }        
        return credential;
    }
     
    public ArrayList<Vacancies> getVacancies(){
        ArrayList<Vacancies> listVacancies= new ArrayList<Vacancies>();
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            
            String sql= "SELECT * FROM vacancies order by name_vacant";
        
                   
            st= conn.prepareStatement(sql);           
            
            rs= st.executeQuery();
            
            while(rs.next()){
                int id= rs.getInt("id_vacant");
                String nameVacant= rs.getString("name_vacant");
                double salary= rs.getDouble("salary_vacant");
                String description= rs.getString("desc_vacant");
                String contact= rs.getString("contact_vacant");
                int places= rs.getInt("places_available");
                int idLabor= rs.getInt("id_laborfield");
                
                
                Vacancies vacant= new Vacancies(id, nameVacant, salary, description, contact, places, idLabor);
                listVacancies.add(vacant);
            }
            
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return listVacancies;
    }
    
    public Vacancies getVacant(int idVacant){
        Vacancies vacant= new Vacancies();
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            String sql= "SELECT * FROM vacancies WHERE id_vacant=?";
            
            st= conn.prepareStatement(sql);  
            
            st.setInt(1, idVacant);
            
            rs= st.executeQuery();
            
            while (rs.next()){
                int id= rs.getInt("id_vacant");
                String nameVacant= rs.getString("name_vacant");
                double salary= rs.getDouble("salary_vacant");
                String description= rs.getString("desc_vacant");
                String contact= rs.getString("contact_vacant");
                int places= rs.getInt("places_available");
                int idLabor= rs.getInt("id_laborfield");
                vacant= new Vacancies(id, nameVacant, salary, description, contact, places, idLabor); 
            }           
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return vacant;
    }
    
    public User getUser(String userN){
        User us= new User();
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            String sql= "SELECT * FROM user_iwork WHERE user_name=?";
            
            st= conn.prepareStatement(sql);  
            
            st.setString(1, userN);
            
            rs= st.executeQuery();
            
            while(rs.next()){            
                int id= rs.getInt("id_user");
                String pass= rs.getString("password");
                String userName= rs.getString("user_name");
                
                us= new User(id, userName, pass);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return us;
    }
    
    public User getUser(int idUs){
        User us= new User();
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            String sql= "SELECT * FROM user_iwork WHERE id_user=?";
            
            st= conn.prepareStatement(sql);  
            
            st.setInt(1, idUs);
            
            rs= st.executeQuery();
            
            while(rs.next()){            
                int id= rs.getInt("id_user");
                String pass= rs.getString("password");
                String userName= rs.getString("user_name");
                
                us= new User(id, userName, pass);
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
        
        return us;
    }
    
    public void applyForVacant(Vacancies vacant, int idUs, String contactE, int ageE){
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
           
            
            String sql= "INSERT INTO employee_s (id_employee, contact_employee, age_employee, id_user, id_vacant)"
            + " VALUES (?, ?, ?, ?, ?)";
        
            st= conn.prepareStatement(sql);
            
            int newiDEmployee= 23;
            newiDEmployee+=idUs;//us.getIdUser();
            newiDEmployee+=vacant.getIdVacancy();
            
            
            //Modificar metodo para seleccionar el id, quizas un string que contcatene ids y fecha con region
            st.setInt(1, newiDEmployee);
            st.setString(2, contactE);
            st.setInt(3, ageE);
            st.setInt(4, idUs);
            st.setInt(5, vacant.getIdVacancy());
            
            
            st.executeUpdate();
        }
        catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
                ex.printStackTrace();
            }
        }
    }
    
    public boolean isEmployee(int idUs){
        boolean isEmployee;
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            String sql= "SELECT * FROM employee_s WHERE id_user=?";
            
            st= conn.prepareStatement(sql);  
            
            st.setInt(1, idUs);
            
            isEmployee=true;
        }
        catch (SQLException ex){
            ex.printStackTrace();
            isEmployee=false;
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
                isEmployee=false;
            }
        }
        return isEmployee;
    }
    
    public Employee getEmployee(int idUs){
        Employee emee= new Employee();
        
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
            
            String sql= "SELECT * FROM employee_s WHERE id_user=?";
            
            st= conn.prepareStatement(sql);  
            
            st.setInt(1, idUs);
            
            rs= st.executeQuery();
            
            while(rs.next()){
                int idEmee= rs.getInt("id_employee");
                String contEmee= rs.getString("contact_employee");
                int ageEmployee= rs.getInt("age_employee");
                int idVacant= rs.getInt("id_vacant");
                
                emee= new Employee(idUs, idVacant, idEmee, contEmee, ageEmployee);
                
            }
        }
        catch (SQLException ex){
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
        }
        finally{
            try{
                st.close();
                conn.close();
                
            }
            catch (SQLException ex){
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "ERROR IN DATA BASE");
            }
        }
        return emee;
    }

    public void leaveJob(Employee employeObj) {
        Employee emee;
        emee=employeObj;
        try{
            conn= DriverManager.getConnection("jdbc:postgresql://localhost:5432/db-iwork", "postgres", "1234");
                                                     
            String sql= "DELETE FROM employee_s WHERE id_employee=?";
        
            st= conn.prepareStatement(sql);
            
            st.setInt(1, emee.getIdEmployee()); 
            
            st.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Good work, see you later...");
        }
        catch (SQLException ex){
            ex.printStackTrace();
        }
        finally{
            try{
                st.close();
                conn.close();
            }
            catch (SQLException ex){
                ex.printStackTrace();
            }
        }
    }
    
    
}
