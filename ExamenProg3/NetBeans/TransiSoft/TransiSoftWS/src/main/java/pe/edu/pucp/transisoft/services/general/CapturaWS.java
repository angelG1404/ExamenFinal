
package pe.edu.pucp.transisoft.services.general;

import Model.Captura;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.io.IOException;
import java.util.ArrayList;
import com.fasterxml.jackson.core.type.TypeReference;
import pe.edu.pucp.transisoft.services.base.HttpJsonClient;

@WebService(serviceName = "CapturaWS")
public class CapturaWS {

    private static final String BASE_URL = "http://localhost:8080/TransiSoftWR/webresources/CapturaWR";

    @WebMethod(operationName = "listarCapturasTodas")
    public ArrayList<Captura> listarCapturasTodas() {
        ArrayList<Captura> capturas = null;
        try {
            capturas = HttpJsonClient.get(BASE_URL + "/listarTodas", new TypeReference<ArrayList<Captura>>() {});
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al listar todas las capturas: " + ex.getMessage());
        }
        return capturas;
    }

    @WebMethod(operationName = "obtenerCapturaPorId")
    public Captura obtenerCapturaPorId(@WebParam(name = "idCaptura") int idCaptura) {
        Captura captura = null;
        try {
            captura = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idCaptura, Captura.class);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al obtener captura por id: " + ex.getMessage());
        }
        return captura;
    }

    @WebMethod(operationName = "insertarCaptura")
    public int insertarCaptura(@WebParam(name = "captura") Captura captura) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", captura);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al insertar captura: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarCaptura")
    public int modificarCaptura(@WebParam(name = "captura") Captura captura) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", captura);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al modificar captura: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarCaptura")
    public int eliminarCaptura(@WebParam(name = "idCaptura") int idCaptura) {
        int resultado = 0;
        try {
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idCaptura);
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error al eliminar captura: " + ex.getMessage());
        }
        return resultado;
    }
}
