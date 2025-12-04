
package BO;

import IBO.IBO;
import Model.Propietario;

public interface PropietarioBO extends IBO<Propietario>{
    Propietario obtenerPropietarioxPlaca(String placa);
}
