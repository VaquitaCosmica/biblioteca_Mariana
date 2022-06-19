package modelos;

import java.util.Date;

public class Alquila {

    private String id_alquiler, id_libro;
    private Date f_salida, f_entrada;
    private int ID_empleada, ID_cliente;

    public Alquila() {
    }

    public Alquila(String id_alquiler, String id_libro, Date f_salida, Date f_entrada, int ID_empleada, int ID_cliente) {
        this.id_alquiler = id_alquiler;
        this.id_libro = id_libro;
        this.f_salida = f_salida;
        this.f_entrada = f_entrada;
        this.ID_empleada = ID_empleada;
        this.ID_cliente = ID_cliente;
    }

    public String getId_alquiler() {
        return id_alquiler;
    }

    public void setId_alquiler(String id_alquiler) {
        this.id_alquiler = id_alquiler;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public Date getF_salida() {
        return f_salida;
    }

    public void setF_salida(Date f_salida) {
        this.f_salida = f_salida;
    }

    public Date getF_entrada() {
        return f_entrada;
    }

    public void setF_entrada(Date f_entrada) {
        this.f_entrada = f_entrada;
    }

    public int getID_empleada() {
        return ID_empleada;
    }

    public void setID_empleada(int ID_empleada) {
        this.ID_empleada = ID_empleada;
    }

    public int getID_cliente() {
        return ID_cliente;
    }

    public void setID_cliente(int ID_cliente) {
        this.ID_cliente = ID_cliente;
    }

}
