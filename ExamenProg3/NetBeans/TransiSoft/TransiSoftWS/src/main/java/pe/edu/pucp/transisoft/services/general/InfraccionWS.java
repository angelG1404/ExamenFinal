
package pe.edu.pucp.transisoft.services.general;

import Model.Infraccion;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.transisoft.services.base.HttpJsonClient;

@WebService(serviceName = "InfraccionWS")
public class InfraccionWS {
    private static final String BASE_URL = "http://localhost:8080/TransiSoftWR/webresources/InfraccionWR";

    @WebMethod(operationName = "listarInfraccionesTodas")
    public ArrayList<Infraccion> listarInfraccionesTodas() {
        ArrayList<Infraccion> infracciones = null;
        try {
            infracciones = HttpJsonClient.get(BASE_URL + "/listarTodas", new TypeReference<ArrayList<Infraccion>>() {});
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al listar todas las infracciones: " + ex.getMessage());
        }
        return infracciones;
    }

    @WebMethod(operationName = "obtenerInfraccionPorId")
    public Infraccion obtenerInfraccionPorId(@WebParam(name = "idInfraccion") int idInfraccion) {
        Infraccion infraccion = null;
        try {
            infraccion = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idInfraccion, Infraccion.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener infracción por id: " + ex.getMessage());
        }
        return infraccion;
    }

    @WebMethod(operationName = "insertarInfraccion")
    public int insertarInfraccion(@WebParam(name = "infraccion") Infraccion infraccion) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", infraccion);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al insertar infracción: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarInfraccion")
    public int modificarInfraccion(@WebParam(name = "infraccion") Infraccion infraccion) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", infraccion);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al modificar infracción: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarInfraccion")
    public int eliminarInfraccion(@WebParam(name = "idInfraccion") int idInfraccion) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idInfraccion);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al eliminar infracción: " + ex.getMessage());
        }
        return resultado;
    }
}
