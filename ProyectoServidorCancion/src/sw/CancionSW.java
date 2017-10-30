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
    
    public void adicionarCancion(Cancion c) throws Exception{
        ServicioCancion.agregarCancion(c);
    }
    
    public Cancion buscarCancion(int id) throws Exception{
        return ServicioCancion.buscarCancion(id);
    }
    
    public void actualizarCancion(Cancion c) throws Exception{
        ServicioCancion.actualizarCancion(c);
    }
    
    public void eliminarCancion(int id) throws Exception{
        ServicioCancion.eliminarCancion(id);
    }
}
