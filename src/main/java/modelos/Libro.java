
package modelos;

public class Libro {

    private String id_libro, titulo, editorial, categoria, autor, idioma;
    private int paginas, anaquel, año;

    public Libro() {
    }

    public Libro(String id_libro, String titulo, String editorial, String categoria, String autor, String idioma, int paginas, int anaquel, int año) {
        this.id_libro = id_libro;
        this.titulo = titulo;
        this.editorial = editorial;
        this.categoria = categoria;
        this.autor = autor;
        this.idioma = idioma;
        this.paginas = paginas;
        this.anaquel = anaquel;
        this.año = año;
    }

    public String getId_libro() {
        return id_libro;
    }

    public void setId_libro(String id_libro) {
        this.id_libro = id_libro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public int getAnaquel() {
        return anaquel;
    }

    public void setAnaquel(int anaquel) {
        this.anaquel = anaquel;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    

    
}
