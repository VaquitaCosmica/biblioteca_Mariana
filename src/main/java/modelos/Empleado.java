package modelos;

import java.util.Date;

public class Empleado {

    private int ID_empleado, numero;
    private String nombre, ape_pat, ape_mat, calle, colonia, ciudad_id, user, telefono;
    private Date f_nacimiento;

    public Empleado() {
    }

    public Empleado(int ID_empleado, String telefono, int numero, String nombre, String ape_pat, String ape_mat, String calle, String colonia, String ciudad_id, String user, Date f_nacimiento) {
        this.ID_empleado = ID_empleado;
        this.telefono = telefono;
        this.numero = numero;
        this.nombre = nombre;
        this.ape_pat = ape_pat;
        this.ape_mat = ape_mat;
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad_id = ciudad_id;
        this.user = user;
        this.f_nacimiento = f_nacimiento;
    }

    public int getID_empleado() {
        return ID_empleado;
    }

    public void setID_empleado(int ID_empleado) {
        this.ID_empleado = ID_empleado;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApe_pat() {
        return ape_pat;
    }

    public void setApe_pat(String ape_pat) {
        this.ape_pat = ape_pat;
    }

    public String getApe_mat() {
        return ape_mat;
    }

    public void setApe_mat(String ape_mat) {
        this.ape_mat = ape_mat;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getColonia() {
        return colonia;
    }

    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    public String getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(String ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

}
