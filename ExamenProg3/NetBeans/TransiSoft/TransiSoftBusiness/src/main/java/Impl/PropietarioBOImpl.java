
package Impl;

import BO.PropietarioBO;
import DAO.PropietarioDAO;
import Model.Propietario;
import java.util.ArrayList;

public class PropietarioBOImpl implements PropietarioBO{
    private PropietarioDAO daopropietario;

    public PropietarioBOImpl() {
        daopropietario = new PropietarioImpl();
    }

    @Override
    public int insertar(Propietario objeto) throws Exception {
        return daopropietario.insertar(objeto);
    }

    @Override
    public int modificar(Propietario objeto) throws Exception {
        return daopropietario.modificar(objeto);
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        return daopropietario.eliminar(idObjeto);
    }

    @Override
    public Propietario obtenerPorId(int idObjeto) throws Exception {
        return daopropietario.obtenerPorId(idObjeto);
    }

    @Override
    public ArrayList<Propietario> listarTodos() throws Exception {
        return daopropietario.listarTodos();
    }

    @Override
    public void validar(Propietario objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Propietario obtenerPropietarioxPlaca(String placa) {
        return daopropietario.obtenerPropietarioxPlaca(placa);

    }
    
}
