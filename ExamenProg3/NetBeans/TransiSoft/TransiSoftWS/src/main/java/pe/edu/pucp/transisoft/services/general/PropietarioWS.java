
package pe.edu.pucp.transisoft.services.general;

import Model.Propietario;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import pe.edu.pucp.transisoft.services.base.HttpJsonClient;

@WebService(serviceName = "PropietarioWS")
public class PropietarioWS {

    private static final String BASE_URL = "http://localhost:8080/TransiSoftWR/webresources/PropietarioWR";

    @WebMethod(operationName = "listarPropietariosTodos")
    public ArrayList<Propietario> listarPropietariosTodos() {
        ArrayList<Propietario> propietarios = null;
        try {
            propietarios = HttpJsonClient.get(BASE_URL + "/listarTodos", new TypeReference<ArrayList<Propietario>>() {});
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al listar todos los propietarios: " + ex.getMessage());
        }
        return propietarios;
    }

    @WebMethod(operationName = "obtenerPropietarioPorId")
    public Propietario obtenerPropietarioPorId(@WebParam(name = "idPropietario") int idPropietario) {
        Propietario propietario = null;
        try {
            propietario = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idPropietario, Propietario.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener propietario por id: " + ex.getMessage());
        }
        return propietario;
    }
    @WebMethod(operationName = "obtenerPropietarioPorPlaca")
    public Propietario obtenerPropietarioPorPlaca(@WebParam(name = "placa") String placa) {
        Propietario propietario = null;
        try {
            propietario = HttpJsonClient.get(BASE_URL + "/obtenerPorPlaca/" + placa, Propietario.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener propietario por id: " + ex.getMessage());
        }
        return propietario;
    }

    @WebMethod(operationName = "insertarPropietario")
    public int insertarPropietario(@WebParam(name = "propietario") Propietario propietario) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", propietario);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al insertar propietario: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarPropietario")
    public int modificarPropietario(@WebParam(name = "propietario") Propietario propietario) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", propietario);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al modificar propietario: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarPropietario")
    public int eliminarPropietario(@WebParam(name = "idPropietario") int idPropietario) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idPropietario);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al eliminar propietario: " + ex.getMessage());
        }
        return resultado;
    }
}

