
package pe.edu.pucp.transisoft.services.general;
import Model.Vehiculo;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import pe.edu.pucp.transisoft.services.base.HttpJsonClient;

@WebService(serviceName = "VehiculoWS")
public class VehiculoWS {

    private static final String BASE_URL = "http://localhost:8080/TransiSoftWR/webresources/VehiculoWR";

    @WebMethod(operationName = "listarVehiculosTodos")
    public ArrayList<Vehiculo> listarVehiculosTodos() {
        ArrayList<Vehiculo> vehiculos = null;
        try {
            vehiculos = HttpJsonClient.get(BASE_URL + "/listarTodos", new TypeReference<ArrayList<Vehiculo>>() {});
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al listar todos los vehiculos: " + ex.getMessage());
        }
        return vehiculos;
    }

    @WebMethod(operationName = "obtenerVehiculoPorId")
    public Vehiculo obtenerVehiculoPorId(@WebParam(name = "idVehiculo") int idVehiculo) {
        Vehiculo vehiculo = null;
        try {
            vehiculo = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idVehiculo, Vehiculo.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener vehiculo por id: " + ex.getMessage());
        }
        return vehiculo;
    }
    @WebMethod(operationName = "obtenerVehiculoPorPlaca")
    public Vehiculo obtenerVehiculoPorPlaca(@WebParam(name = "placa") String placa) {
        Vehiculo vehiculo = null;
        try {
            vehiculo = HttpJsonClient.get(BASE_URL + "/obtenerPorPlaca/" + placa, Vehiculo.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener vehiculo por placa: " + ex.getMessage());
        }
        return vehiculo;
    }

    @WebMethod(operationName = "insertarVehiculo")
    public int insertarVehiculo(@WebParam(name = "vehiculo") Vehiculo vehiculo) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", vehiculo);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al insertar vehiculo: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarVehiculo")
    public int modificarVehiculo(@WebParam(name = "vehiculo") Vehiculo vehiculo) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", vehiculo);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al modificar vehiculo: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarVehiculo")
    public int eliminarVehiculo(@WebParam(name = "idVehiculo") int idVehiculo) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idVehiculo);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al eliminar vehiculo: " + ex.getMessage());
        }
        return resultado;
    }
}
