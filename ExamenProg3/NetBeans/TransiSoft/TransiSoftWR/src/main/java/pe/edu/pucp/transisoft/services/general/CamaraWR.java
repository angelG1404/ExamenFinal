
package pe.edu.pucp.transisoft.services.general;

import BO.CamaraBO;
import Impl.CamaraBOImpl;
import Model.Camara;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;

@Path("CamaraWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CamaraWR {
    private CamaraBO boCamara;
    
    @GET
    @Path("listarTodas")
    public ArrayList<Camara> listarTodas(){
        ArrayList<Camara> camaras = null;
        try{
            boCamara = new CamaraBOImpl();
            camaras = boCamara.listarTodos();
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return camaras;
    }
    
    @GET
    @Path("obtenerPorId/{id}")
    public Camara obtenerPorId(@PathParam("id") int id){
        Camara camara = null;
        try{
            boCamara = new CamaraBOImpl();
            camara = boCamara.obtenerPorId(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return camara;
    }
    
    @POST
    @Path("insertar")
    public int insertar(Camara camara){
        int resultado = 0;
        try{
            boCamara = new CamaraBOImpl();
            resultado = boCamara.insertar(camara);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @PUT
    @Path("modificar")
    public int modificar(Camara camara){
        int resultado = 0;
        try{
            boCamara = new CamaraBOImpl();
            resultado = boCamara.modificar(camara);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
    
    @DELETE
    @Path("eliminar/{id}")
    public int eliminar(@PathParam("id") int id){
        int resultado = 0;
        try{
            boCamara = new CamaraBOImpl();
            return boCamara.eliminar(id);
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
