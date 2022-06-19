
package modelos;

public class Editorial {
    private String razon_social, nombre;

    public Editorial() {
    }

    public Editorial(String razon_social, String nombre) {
        this.razon_social = razon_social;
        this.nombre = nombre;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
