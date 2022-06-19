
package modelos;

public class Ciudad {
   private String ciudad_ID, nombre;

    public Ciudad() {
    }

    public Ciudad(String ciudad_ID, String nombre) {
        this.ciudad_ID = ciudad_ID;
        this.nombre = nombre;
    }

    public String getCiudad_ID() {
        return ciudad_ID;
    }

    public void setCiudad_ID(String ciudad_ID) {
        this.ciudad_ID = ciudad_ID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

 
}
