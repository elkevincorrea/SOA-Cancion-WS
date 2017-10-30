package model.estructural;

import java.text.DateFormat;

import java.text.SimpleDateFormat;

import java.util.Date;

public class Cancion {
    
    public final static String LIST_SQL = "SELECT * FROM CANCION";
    public final static String SELECT_NUMERO_SQL = "SELECT * FROM CANCION WHERE id = ";
    
    private int id;
    private String titulo;
    private String nombreArtista;
    private String genero;
    private Date fechaLanzamiento;
    
    public Cancion() {
        super();
    }
    
    public Cancion(int id, String titulo, String nombreArtista, String genero, Date fechaLanzamiento){
        this.id = id;
        this.titulo = titulo;
        this.nombreArtista = nombreArtista;
        this.genero = genero;
        this.fechaLanzamiento = fechaLanzamiento;
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
    
    public String insertSQL(){
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("INSERT INTO CANCION VALUES(%d, '%s', '%s', '%s', TO_DATE('%s', 'dd/mm/yyyy'))", id, titulo, nombreArtista, genero, format.format(fechaLanzamiento));
    }
        
    public String deleteSQL(){
        return String.format("DELETE FROM CANCION WHERE id = %d", id);
    }
    
    public String updateSQL() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        return String.format("UPDATE CANCION SET titulo = '%s', nombreArtista = '%s', genero = '%s', fechaLanzamiento = TO_DATE('%s', 'dd/mm/yyyy') WHERE id = %d",
                titulo, nombreArtista, genero, format.format(fechaLanzamiento), id);
    }
}

