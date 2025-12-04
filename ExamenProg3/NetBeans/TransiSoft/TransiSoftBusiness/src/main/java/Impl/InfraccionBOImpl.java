
package Impl;

import BO.InfraccionBO;
import DAO.InfraccionDAO;
import Model.Infraccion;
import java.util.ArrayList;

public class InfraccionBOImpl implements InfraccionBO{
    private InfraccionDAO daoinfraccion;

    public InfraccionBOImpl() {
        daoinfraccion=new InfraccionImpl();
    }

    
    @Override
    public int insertar(Infraccion objeto) throws Exception {
        return daoinfraccion.insertar(objeto);
    }

    @Override
    public int modificar(Infraccion objeto) throws Exception {
        return daoinfraccion.modificar(objeto);
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        return daoinfraccion.eliminar(idObjeto);
    }

    @Override
    public Infraccion obtenerPorId(int idObjeto) throws Exception {
        return daoinfraccion.obtenerPorId(idObjeto);
    }

    @Override
    public ArrayList<Infraccion> listarTodos() throws Exception {
        return daoinfraccion.listarTodos();
    }

    @Override
    public void validar(Infraccion objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
