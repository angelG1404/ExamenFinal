
package pe.edu.pucp.transisoft.services.general;

import BO.CapturaBO;
import Impl.CapturaBOImpl;
import Model.Captura;
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

@Path("CapturaWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CapturaWR {
    private CapturaBO bocaptura;
    
    @GET
    @Path("listarTodas")
    public ArrayList<Captura> listarTodas() {
        ArrayList<Captura> capturas = null;
        try {
            bocaptura = new CapturaBOImpl();
            capturas = bocaptura.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return capturas;
    }

    @GET
    @Path("obtenerPorId/{id}")
    public Captura obtenerPorId(@PathParam("id") int id) {
        Captura captura = null;
        try {
            bocaptura = new CapturaBOImpl();
            captura = bocaptura.obtenerPorId(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return captura;
    }

    @POST
    @Path("insertar")
    public int insertar(Captura captura) {
        int resultado = 0;
        try {
            bocaptura = new CapturaBOImpl();
            resultado = bocaptura.insertar(captura);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path("modificar")
    public int modificar(Captura captura) {
        int resultado = 0;
        try {
            bocaptura = new CapturaBOImpl();
            resultado = bocaptura.modificar(captura);
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
            bocaptura = new CapturaBOImpl();
            resultado = bocaptura.eliminar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
