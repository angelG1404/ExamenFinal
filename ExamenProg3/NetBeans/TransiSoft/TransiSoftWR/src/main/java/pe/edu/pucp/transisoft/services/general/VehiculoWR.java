
package pe.edu.pucp.transisoft.services.general;

import BO.VehiculoBO;
import Impl.VehiculoBOImpl;
import Model.Vehiculo;
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

@Path("VehiculoWR")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class VehiculoWR {
    private VehiculoBO bovehiculo;
    
    
    @GET
    @Path("listarTodos")
    public ArrayList<Vehiculo> listarTodos() {
        ArrayList<Vehiculo> vehiculos = null;
        try {
            bovehiculo = new VehiculoBOImpl();
            vehiculos = bovehiculo.listarTodos();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vehiculos;
    }

    @GET
    @Path("obtenerPorId/{id}")
    public Vehiculo obtenerPorId(@PathParam("id") int id) {
        Vehiculo vehiculo = null;
        try {
            bovehiculo = new VehiculoBOImpl();
            vehiculo = bovehiculo.obtenerPorId(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vehiculo;
    }
    @GET
    @Path("obtenerPorPlaca/{placa}")
    public Vehiculo obtenerPorPlaca(@PathParam("placa") String placa) {
        Vehiculo vehiculo = null;
        try {
            bovehiculo = new VehiculoBOImpl();
            vehiculo = bovehiculo.ObtenerVehiculoxPlaca(placa);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return vehiculo;
    }

    @POST
    @Path("insertar")
    public int insertar(Vehiculo vehiculo) {
        int resultado = 0;
        try {
            bovehiculo = new VehiculoBOImpl();
            resultado = bovehiculo.insertar(vehiculo);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }

    @PUT
    @Path("modificar")
    public int modificar(Vehiculo vehiculo) {
        int resultado = 0;
        try {
            bovehiculo = new VehiculoBOImpl();
            resultado = bovehiculo.modificar(vehiculo);
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
            bovehiculo = new VehiculoBOImpl();
            resultado = bovehiculo.eliminar(id);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return resultado;
    }
}
