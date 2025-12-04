
package DAO;

import IDAO.IDAO;
import Model.Propietario;

public interface PropietarioDAO extends IDAO<Propietario>{
    Propietario obtenerPropietarioxPlaca(String placa);
}
