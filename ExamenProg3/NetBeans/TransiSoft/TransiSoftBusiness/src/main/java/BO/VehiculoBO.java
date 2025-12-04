
package BO;

import IBO.IBO;
import Model.Vehiculo;

public interface VehiculoBO extends IBO<Vehiculo>{
    Vehiculo ObtenerVehiculoxPlaca(String placa);
}
