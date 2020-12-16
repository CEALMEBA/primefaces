/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.DaoDepartamentos;
import IDAO.IDAOGENERAL;
import MODELO.departamentos;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author cealmeba
 */
@ManagedBean(name = "DetpaBean")
@RequestScoped
public class DetpaBean {

   private departamentos dept;
    private List <departamentos> records;
    private IDAOGENERAL MIDAO;
    private  int clave;

    public DetpaBean() {
        dept =new departamentos();
        MIDAO= new DaoDepartamentos();
        records =MIDAO.readall();      
}

    public departamentos getDept() {
        return dept;
    }

    public void setDept(departamentos dept) {
        this.dept = dept;
    }

    public List<departamentos> getRecords() {
        return records;
    }

    public void setRecords(List<departamentos> records) {
        this.records = records;
    }

    public IDAOGENERAL getMIDAO() {
        return MIDAO;
    }

    public void setMIDAO(IDAOGENERAL MIDAO) {
        this.MIDAO = MIDAO;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }
     public void REGISTRADO() {
        addMessage("REGISTRADO!!");
    }
       
          public void eliminado() {
        addMessage("ELIMINADO!!");
    }
             
    public void sendData(){
    MIDAO.insert(dept);
       REGISTRADO();
    }

    public void delete(){
        System.out.println("delete");
        MIDAO.delete(clave);
        records=MIDAO.readall();
        eliminado();
    }
    public void update(){
        System.out.println("update");
        MIDAO.update(dept);
    }
       
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    
}