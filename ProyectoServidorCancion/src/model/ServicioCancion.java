package model;

import java.util.ArrayList;

import model.estructural.Cancion;

public class ServicioCancion {
    
    private static ArrayList<Cancion> canciones = new ArrayList<Cancion>();
    
    public ServicioCancion() {
        super();
    }
    
    public static ArrayList<Cancion> getCanciones(){
        return canciones;
    }
    
    public static boolean agregarCancion(Cancion cancion){
        if(canciones.contains(cancion)){
            return false;
        }
        return canciones.add(cancion);
    }
    
    public static Cancion buscarCancion(int id){
        for(Cancion cancion : canciones){
            if(cancion.getId() == id){
                return cancion;
            }
        }
        return null;
    }
    
    public static boolean actualizarCancion(Cancion cancion){
        Cancion buscada = buscarCancion(cancion.getId());
        if(buscada != null){
            buscada.setTitulo(cancion.getTitulo());
            buscada.setGenero(cancion.getGenero());
            buscada.setNombreArtista(cancion.getNombreArtista());
            return true;
        }
        return false;
    }
    
    public static boolean eliminarCancion(int id){
        Cancion buscada = buscarCancion(id);
        if(buscada != null){
            return canciones.remove(buscada);
        }
        return false;
    }
}
