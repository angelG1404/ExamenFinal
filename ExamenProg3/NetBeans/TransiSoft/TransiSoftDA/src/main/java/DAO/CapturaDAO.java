
package DAO;

import IDAO.IDAO;
import Model.Captura;

public interface CapturaDAO extends IDAO<Captura>{
    public int modificarEstadoCaptura(String estado,Captura captura);
}
