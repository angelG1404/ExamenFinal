
package pe.edu.pucp.transisoft.services.general;

import Model.Camara;
import com.fasterxml.jackson.core.type.TypeReference;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.io.IOException;
import java.util.ArrayList;
import pe.edu.pucp.transisoft.services.base.HttpJsonClient;

@WebService(serviceName = "CamaraWS")
public class CamaraWS {
    
    private static final String BASE_URL = "http://localhost:8080/TransiSoftWR/webresources/CamaraWR";

    @WebMethod(operationName = "listarCamarasTodas")
    public ArrayList<Camara> listarCamarasTodas(){
        ArrayList<Camara> camaras = null;
        try{
            camaras = HttpJsonClient.get(BASE_URL + "/listarTodas", new TypeReference<ArrayList<Camara>>(){});
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al listar todas las cámaras: " + ex.getMessage());
        }
        return camaras;
    }

    @WebMethod(operationName = "obtenerCamaraPorId")
    public Camara obtenerCamaraPorId(@WebParam(name = "idCamara") int idCamara){
        Camara camara = null;
        try{
            camara = HttpJsonClient.get(BASE_URL + "/obtenerPorId/" + idCamara, Camara.class);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al obtener una cámara por id: " + ex.getMessage());
        }
        return camara;
    }

    @WebMethod(operationName = "insertarCamara")
    public int insertarCamara(@WebParam(name = "camara") Camara camara){
        int resultado = 0;
        try{
            resultado = HttpJsonClient.post(BASE_URL + "/insertar", camara);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al insertar cámara: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "modificarCamara")
    public int modificarCamara(@WebParam(name = "camara") Camara camara){
        int resultado = 0;
        try{
            resultado = HttpJsonClient.put(BASE_URL + "/modificar", camara);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al modificar cámara: " + ex.getMessage());
        }
        return resultado;
    }

    @WebMethod(operationName = "eliminarCamara")
    public int eliminarCamara(@WebParam(name = "idCamara") int idCamara){
        int resultado = 0;
        try{
            resultado = HttpJsonClient.delete(BASE_URL + "/eliminar/" + idCamara);
        }catch(IOException | InterruptedException ex){
            System.out.println("Error al eliminar cámara: " + ex.getMessage());
        }
        return resultado;
    }
}
