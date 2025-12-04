
package Impl;

import BO.CapturaBO;
import DAO.CapturaDAO;
import Model.Captura;
import java.util.ArrayList;

public class CapturaBOImpl implements CapturaBO{
    private CapturaDAO daocaptura;

    public CapturaBOImpl() {
        daocaptura=new CapturaImpl();
    }
    @Override
    public int insertar(Captura objeto) throws Exception {
        return daocaptura.insertar(objeto);
    }

    @Override
    public int modificar(Captura objeto) throws Exception {
        return daocaptura.modificar(objeto);
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        return daocaptura.eliminar(idObjeto);
    }

    @Override
    public Captura obtenerPorId(int idObjeto) throws Exception {
        return daocaptura.obtenerPorId(idObjeto);
    }

    @Override
    public ArrayList<Captura> listarTodos() throws Exception {
        return daocaptura.listarTodos();
    }

    @Override
    public void validar(Captura objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
