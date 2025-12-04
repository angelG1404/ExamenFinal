
package DAO;

import IDAO.IDAO;
import Model.Vehiculo;

public interface VehiculoDAO extends IDAO<Vehiculo>{
    Vehiculo ObtenerVehiculoxPlaca(String placa);
}
