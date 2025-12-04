
package pucp.edu.pe.softprog.transisoft;

//import pe.edu.pucp.transisoft.config.Encriptamiento;

import BO.CamaraBO;
import BO.InfraccionBO;
import DAO.CapturaDAO;
import DAO.InfraccionDAO;
import Impl.CamaraBOImpl;
import Impl.CapturaImpl;
import Impl.InfraccionBOImpl;
import Impl.InfraccionImpl;
import Model.Camara;
import Model.Captura;
import Model.Infraccion;
import java.util.ArrayList;
import pe.edu.pucp.transisoft.config.Encriptamiento;



public class TransiSoft {

    public static void main(String[] args) throws Exception {
//        String clave = Encriptamiento.encriptar("14angel042004", 
//                "jGwZUx4lOJZj8wXav7Sknw==");
//        System.out.println(clave);
        CamaraBO bocamara=new CamaraBOImpl();
        ArrayList<Camara> lista= new ArrayList<>();
        if(lista==null)System.out.println("No se leyo nd");
        lista=bocamara.listarTodos();
        for(Camara c : lista){
            System.out.println(c.getId()+"  "+c.getModelo());
        }
    }
}
