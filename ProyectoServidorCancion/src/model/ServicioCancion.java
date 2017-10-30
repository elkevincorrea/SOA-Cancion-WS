package model;

import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

import model.conexion.ConexionBD;
import model.estructural.Cancion;

public class ServicioCancion {
    
    private static ArrayList<Cancion> canciones = new ArrayList<Cancion>();
 
    private static ConexionBD conexionBD = new ConexionBD("cancion", "cancion");
    private static boolean cargado = false;
       
    public ServicioCancion() {
        super();
    }
    
    
    private static void cargar() throws SQLException{
        ResultSet rs = conexionBD.executeQueryStatement(Cancion.LIST_SQL);
        while(rs.next()){
            int id = rs.getInt(1);
            String titulo = rs.getString(2);
            String artista = rs.getString(3);
            String genero = rs.getString(4);
            Date fecha = rs.getTimestamp(5);
            canciones.add(new Cancion(id, titulo, artista, genero, fecha));
        }
    }
    
    public static ArrayList<Cancion> getCanciones(){
        if(!cargado){
            try{
                cargar();
            }
            catch(Exception e){
                e.printStackTrace();
            }
            cargado = true;
        }
        return canciones;
    }
    
    public static void agregarCancion(Cancion cancion) throws Exception{
        if(canciones.contains(cancion)){
            throw new Exception("La canción ya existe");
        }
        if(conexionBD.executeUpdateStatement(cancion.insertSQL())){
            canciones.add(cancion);
        }else{
            throw new Exception("La canción ya existe");
        }
    }
    
    public static Cancion buscarCancion(int id) throws Exception{
        for(Cancion cancion : canciones){
            if(cancion.getId() == id){
                return cancion;
            }
        }
        ResultSet rs = conexionBD.executeQueryStatement(Cancion.SELECT_NUMERO_SQL + id);
        try{
            rs.next();
            String titulo = rs.getString(2);
            String artista = rs.getString(3);
            String genero = rs.getString(4);
            Date fecha = rs.getTimestamp(5);
            Cancion c = new Cancion(id, titulo, artista, genero, fecha);
            canciones.add(c);
            return c;
        }catch (Exception e){}
        throw new Exception("La canción no existe");
    }
    
    public static void actualizarCancion(Cancion cancion) throws Exception{
        Cancion buscada = buscarCancion(cancion.getId());
        if(buscada != null){
            buscada.setTitulo(cancion.getTitulo());
            buscada.setGenero(cancion.getGenero());
            buscada.setNombreArtista(cancion.getNombreArtista());
            buscada.setFechaLanzamiento(cancion.getFechaLanzamiento());
            if(!conexionBD.executeUpdateStatement(buscada.updateSQL())){
                throw new Exception("La canción no existe en la BD");
            }
        }
    }
    
    public static void eliminarCancion(int id) throws Exception{
        Cancion buscada = buscarCancion(id);
        if(buscada != null && conexionBD.executeUpdateStatement(buscada.deleteSQL())){
            canciones.remove(buscada);
        }else{
            throw new Exception("La canción no existe en la BD");
        }
    }
}
