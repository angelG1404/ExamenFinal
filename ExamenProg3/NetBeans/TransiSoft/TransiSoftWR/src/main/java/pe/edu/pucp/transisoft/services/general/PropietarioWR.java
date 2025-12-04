
package pe.edu.pucp.transisoft.services.general;
import BO.PropietarioBO;
import Impl.PropietarioBOImpl;
import Model.Propietario;
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

@Path("PropietarioWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PropietarioWR {
    private PropietarioBO bopropietario;
    
    
    @GET
    @Path("listarTodos")
    public ArrayList<Propietario> listarTodos() {
        ArrayList<Propietario> propietarios = null;
        try {
            bopropietario = new PropietarioBOImpl();
            propietarios = bopropietario.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return propietarios;
    }

    @GET
    @Path("obtenerPorId/{id}")
    public Propietario obtenerPorId(@PathParam("id") int id) {
        Propietario propietario = null;
        try {
            bopropietario = new PropietarioBOImpl();
            propietario = bopropietario.obtenerPorId(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return propietario;
    }
    @GET
    @Path("obtenerPorPlaca/{placa}")
    public Propietario obtenerPorPlaca(@PathParam("placa") String placa) {
        Propietario propietario = null;
        try {
            bopropietario = new PropietarioBOImpl();
            propietario = bopropietario.obtenerPropietarioxPlaca(placa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return propietario;
    }

    @POST
    @Path("insertar")
    public int insertar(Propietario propietario) {
        int resultado = 0;
        try {
            bopropietario = new PropietarioBOImpl();
            resultado = bopropietario.insertar(propietario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path("modificar")
    public int modificar(Propietario propietario) {
        int resultado = 0;
        try {
            bopropietario = new PropietarioBOImpl();
            resultado = bopropietario.modificar(propietario);
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
            bopropietario = new PropietarioBOImpl();
            resultado = bopropietario.eliminar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
