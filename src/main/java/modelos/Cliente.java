package modelos;

import java.util.Date;

public class Cliente {

    private int ID_cliente, numero;
    private String nombre,  telefono, ape_pat, ape_mat, calle, colonia, ocupacion, ciudad_id;
    private Date f_nacimiento;

    public Cliente() {
    }

    public Cliente(int ID_cliente, String telefono, int numero, String nombre, String ape_pat, String ape_mat, String calle, String colonia, String ocupacion, String ciudad_id, Date f_nacimiento) {
        this.ID_cliente = ID_cliente;
        this.telefono = telefono;
        this.numero = numero;
        this.nombre = nombre;
        this.ape_pat = ape_pat;
        this.ape_mat = ape_mat;
        this.calle = calle;
        this.colonia = colonia;
        this.ocupacion = ocupacion;
        this.ciudad_id = ciudad_id;
        this.f_nacimiento = f_nacimiento;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
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

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public String getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(String ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public Date getF_nacimiento() {
        return f_nacimiento;
    }

    public void setF_nacimiento(Date f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }

}
