
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package system.pojo;
/**
 -idCampoLa
-nameCampoLa; String
-descLaborField
* 
+mostrarVacantes(); vacante

 */
public class fieldLabor implements Localization{
    //----------------------
    private int idFieldLabor;
    private String nameFieldLabor;
    private String descLaborField;
     
    //dato de la interface padre
    private int idLocalization;
    private int nameLozalization;    
    //-----------------------
    
    public int getIdLocalization() {
        return idLocalization;
    }

    public void setIdLocalization(int idLocalization) {
        this.idLocalization = idLocalization;
    }

    public int getNameLozalization() {
        return nameLozalization;
    }
    
    public void setNameLozalization(int nameLozalization) {
        this.nameLozalization = nameLozalization;
    }

    public int getIdFieldLabor() {
        return idFieldLabor;
    }

    public void setIdFieldLabor(int idFieldLabor) {
        this.idFieldLabor = idFieldLabor;
    }

    public String getNameFieldLabor() {
        return nameFieldLabor;
    }

    public void setNameFieldLabor(String nameFieldLabor) {
        this.nameFieldLabor = nameFieldLabor;
    }

    public String getDescLaborField() {
        return descLaborField;
    }

    public void setDescLaborField(String descLaborField) {
        this.descLaborField = descLaborField;
    }

    @Override
    public void showVacancies() {
        //
    }
    
    
    
}
