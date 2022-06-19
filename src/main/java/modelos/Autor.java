
package modelos;

public class Autor {
    private String id, nombre;

    public Autor() {
    }

    public Autor(String id_Autor, String nombre) {
        this.id = id_Autor;
        this.nombre = nombre;
    }

    public String getId_Autor() {
        return id;
    }

    public void setId_Autor(String id_Autor) {
        this.id = id_Autor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


}
