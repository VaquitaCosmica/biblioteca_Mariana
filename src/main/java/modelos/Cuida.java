package modelos;

import java.util.Date;

public class Cuida {

    private String id_manto, id_mobiliario;
    private Date f_manto;
    private int ID_empleado;

    public Cuida() {
    }

    public Cuida(String id_manto, String id_mobiliario, Date f_manto, int ID_empleado) {
        this.id_manto = id_manto;
        this.id_mobiliario = id_mobiliario;
        this.f_manto = f_manto;
        this.ID_empleado = ID_empleado;
    }

    public String getId_manto() {
        return id_manto;
    }

    public void setId_manto(String id_manto) {
        this.id_manto = id_manto;
    }

    public String getId_mobiliario() {
        return id_mobiliario;
    }

    public void setId_mobiliario(String id_mobiliario) {
        this.id_mobiliario = id_mobiliario;
    }

    public Date getF_manto() {
        return f_manto;
    }

    public void setF_manto(Date f_manto) {
        this.f_manto = f_manto;
    }

    public int getID_empleado() {
        return ID_empleado;
    }

    public void setID_empleado(int ID_empleado) {
        this.ID_empleado = ID_empleado;
    }

}
