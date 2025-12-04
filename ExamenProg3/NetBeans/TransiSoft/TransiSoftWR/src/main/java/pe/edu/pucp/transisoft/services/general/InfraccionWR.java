
package pe.edu.pucp.transisoft.services.general;
import BO.InfraccionBO;
import Impl.InfraccionBOImpl;
import Model.Infraccion;
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

@Path("InfraccionWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class InfraccionWR {
    private InfraccionBO boinfraccion;
    
    @GET
    @Path("listarTodas")
    public ArrayList<Infraccion> listarTodas() {
        ArrayList<Infraccion> infracciones = null;
        try {
            boinfraccion = new InfraccionBOImpl();
            infracciones = boinfraccion.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return infracciones;
    }

    @GET
    @Path("obtenerPorId/{id}")
    public Infraccion obtenerPorId(@PathParam("id") int id) {
        Infraccion infraccion = null;
        try {
            boinfraccion = new InfraccionBOImpl();
            infraccion = boinfraccion.obtenerPorId(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return infraccion;
    }

    @POST
    @Path("insertar")
    public int insertar(Infraccion infraccion) {
        int resultado = 0;
        try {
            boinfraccion = new InfraccionBOImpl();
            resultado = boinfraccion.insertar(infraccion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path("modificar")
    public int modificar(Infraccion infraccion) {
        int resultado = 0;
        try {
            boinfraccion = new InfraccionBOImpl();
            resultado = boinfraccion.modificar(infraccion);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @DELETE
    @Path("eliminar/{id}")
    public int eliminar(@PathParam("id") int id) {
        int resultado = 0;
        try {
            boinfraccion = new InfraccionBOImpl();
            resultado = boinfraccion.eliminar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
