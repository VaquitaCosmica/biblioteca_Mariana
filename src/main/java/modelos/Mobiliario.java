package modelos;

public class Mobiliario {

    private String id_mobiliario, nombre;
    private int cantidad;

    public Mobiliario() {
    }

    public Mobiliario(String id_mobiliario, String nombre, int cantidad) {
        this.id_mobiliario = id_mobiliario;
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    public String getId_mobiliario() {
        return id_mobiliario;
    }

    public void setId_mobiliario(String id_mobiliario) {
        this.id_mobiliario = id_mobiliario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}
