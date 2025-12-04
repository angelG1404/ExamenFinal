
package Impl;

import BO.CamaraBO;
import DAO.CamaraDAO;
import Model.Camara;
import java.util.ArrayList;

public class CamaraBOImpl implements CamaraBO{
    private CamaraDAO camaradao;

    public CamaraBOImpl() {
        camaradao=new CamaraImpl();
    }
    
    @Override
    public int insertar(Camara objeto) throws Exception {
        return camaradao.insertar(objeto);
    }

    @Override
    public int modificar(Camara objeto) throws Exception {
        return camaradao.modificar(objeto);
    }

    @Override
    public int eliminar(int idObjeto) throws Exception {
        return camaradao.eliminar(idObjeto);
    }

    @Override
    public Camara obtenerPorId(int idObjeto) throws Exception {
        return camaradao.obtenerPorId(idObjeto);
    }

    @Override
    public ArrayList<Camara> listarTodos() throws Exception {
        return camaradao.listarTodos();
    }

    @Override
    public void validar(Camara objeto) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
