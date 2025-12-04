
package Impl;

import BO.VehiculoBO;
import DAO.VehiculoDAO;
import Model.Vehiculo;
import java.util.ArrayList;

public class VehiculoBOImpl implements VehiculoBO{

    private VehiculoDAO daovehiculo;

    public VehiculoBOImpl() {
        daovehiculo = new VehiculoImpl();
    }

    @Override
    public int insertar(Vehiculo objeto) throws Exception {
        return daovehiculo.insertar(objeto);
    }

    @Override
    public int modificar(Vehiculo objeto) throws Exception {
        return daovehiculo.modificar(objeto);
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        return daovehiculo.eliminar(idObjeto);
    }

    @Override
    public Vehiculo obtenerPorId(int idObjeto) throws Exception {
        return daovehiculo.obtenerPorId(idObjeto);
    }

    @Override
    public ArrayList<Vehiculo> listarTodos() throws Exception {
        return daovehiculo.listarTodos();
    }

    @Override
    public void validar(Vehiculo objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vehiculo ObtenerVehiculoxPlaca(String placa) {
        return daovehiculo.ObtenerVehiculoxPlaca(placa);
    }
}
