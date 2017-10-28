package model.estructural;

import java.util.Date;

public class Cancion {
    
    private int id;
    private String titulo;
    private String nombreArtista;
    private String genero;
    private Date fechaLanzamiento;
    
    public Cancion() {
        super();
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }
    
    public boolean equals(Object o){
        return o != null && o instanceof Cancion && ((Cancion) o).id == id;
    }

    public void setFechaLanzamiento(Date fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public Date getFechaLanzamiento() {
        return fechaLanzamiento;
    }
}
