package sw;

import java.util.ArrayList;

import javax.jws.WebService;

import model.ServicioCancion;
import model.estructural.Cancion;

@WebService(targetNamespace = "http://tempuri.org/")
public class CancionSW {
    public CancionSW() {
        super(); 
    }
    
    public ArrayList<Cancion> listarCanciones(){
        return ServicioCancion.getCanciones();
    }
    
    public boolean adicionarCancion(Cancion c){
        return ServicioCancion.agregarCancion(c);
    }
    
    public Cancion buscarCancion(int id){
        return ServicioCancion.buscarCancion(id);
    }
    
    public boolean actualizarCancion(Cancion c){
        return ServicioCancion.actualizarCancion(c);
    }
    
    public boolean eliminarCancion(int id){
        return ServicioCancion.eliminarCancion(id);
    }
}
