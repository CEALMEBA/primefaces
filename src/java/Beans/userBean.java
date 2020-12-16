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
    private List <usuarios> userfind;
    private IDAOGENERAL MIDAO;
    private  int clave;
    
    public userBean(){
    user =new usuarios();
    userfind=new ArrayList();
    MIDAO= new DaoUsuario();
     userfind =MIDAO.readall();
    }
    
    public void sendData(){
    MIDAO.insert(user);
        addMessage("Registrado!!");
    }

    public void delete(){
        System.out.println("delete");
        MIDAO.delete(clave);
        userfind=MIDAO.readall();
        addMessage("ELIMINADO!!");
    }
    public void update(){
        System.out.println("update");
        MIDAO.update(user);
    }
    
    
    
    
    
    
    public usuarios getUser() {
        return user;
    }

    public void setUser(usuarios user) {
        this.user = user;
    }

    public List<usuarios> getUserfind() {
        return userfind;
    }

    public void setUserfind(List<usuarios> userfind) {
        this.userfind = userfind;
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
       
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
