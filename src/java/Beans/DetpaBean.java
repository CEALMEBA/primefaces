/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Beans;

import DAO.DaoDepartamentos;
import IDAO.IDAOGENERAL;
import MODELO.departamentos;
import java.util.ArrayList;
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
    private List<departamentos> detpfind;
    private IDAOGENERAL MIDAO;
    private int clave;

    public DetpaBean() {
        dept = new departamentos();
        MIDAO = new DaoDepartamentos();
        detpfind = MIDAO.readall();
    }

    public void sendData() {
        MIDAO.insert(dept);
        addMessage("Registrado!!");
    }

    public void delete() {
        System.out.println("delete");
       /* MIDAO.delete(clave);
        detpfind = MIDAO.readall();
        addMessage("ELIMINADO!!");*/
    }

    public void update() {
        System.out.println("update");
        MIDAO.update(dept);
    }

    public departamentos getDept() {
        return dept;
    }

    public void setDept(departamentos dept) {
        this.dept = dept;
    }

    public List<departamentos> getDetpfind() {
        return detpfind;
    }

    public void setDetpfind(List<departamentos> detpfind) {
        this.detpfind = detpfind;
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
