/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.DaoUsuario;
import MODELO.usuarios;
import java.util.List;
import IDAO.IDAOGENERAL;
import java.util.ArrayList;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;


/**
 *
 * @author cealmeba
 */
@ManagedBean(name="userBean")
@RequestScoped
public class userBean {
    
    private usuarios user;
    private List <usuarios> records;
    private IDAOGENERAL MIDAO;
    private  int clave;
    
    public userBean(){
        user =new usuarios();
        MIDAO= new DaoUsuario();
        records =MIDAO.readall();
    }
     
    public usuarios getUser() {
        return user;
    }

    public void setUser(usuarios user) {
        this.user = user;
    }

    public List<usuarios> getRecords() {
        return records;
    }

    public void setRecords(List<usuarios> records) {
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
    MIDAO.insert(user);
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
        MIDAO.update(user);
    }
       
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public void buttonAction() {
        addMessage("Welcome to PrimeFaces!!");
    }
    
    public void hola(){
        System.out.println("HOLA");   
    }
}
