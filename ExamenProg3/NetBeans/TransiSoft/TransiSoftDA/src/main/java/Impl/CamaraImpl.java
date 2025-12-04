
package Impl;

import DAO.CamaraDAO;
import Model.Camara;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transisoft.config.DBManager;

public class CamaraImpl implements CamaraDAO{

    
    private ResultSet rs;

    @Override
    public int insertar(Camara camara) {
        Map<Integer, Object> parametrosSalida = new HashMap<>();
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, camara.getModelo());
        parametrosEntrada.put(3, camara.getCodigo_serie());
        parametrosEntrada.put(4, camara.getLatitud());
        parametrosEntrada.put(5, camara.getLongitud());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_CAMARA", parametrosEntrada, parametrosSalida);
        camara.setId((int) parametrosSalida.get(1));
        System.out.println("Se ha insertado la cámara");
        return camara.getId();
    }

    @Override
    public int modificar(Camara camara) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, camara.getId());
        parametrosEntrada.put(2, camara.getModelo());
        parametrosEntrada.put(3, camara.getCodigo_serie());
        parametrosEntrada.put(4, camara.getLatitud());
        parametrosEntrada.put(5, camara.getLongitud());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_CAMARA", parametrosEntrada, null);
        System.out.println("Se ha modificado la cámara");
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_CAMARA", parametrosEntrada, null);
        System.out.println("Se ha eliminado la cámara");
        return resultado;
    }

    @Override
    public Camara obtenerPorId(int id) {
        Camara camara = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_CAMARA_X_ID", parametrosEntrada);
        try {
            if (rs.next()) {
                camara = new Camara();
                camara.setId(rs.getInt("id"));
                camara.setModelo(rs.getString("modelo"));
                camara.setCodigo_serie(rs.getString("codigo_serie"));
                camara.setLatitud(rs.getInt("latitud"));
                camara.setLongitud(rs.getInt("longitud"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return camara;
    }

    @Override
    public ArrayList<Camara> listarTodos() {
        ArrayList<Camara> camaras = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_CAMARAS_TODAS", null);
        try {
            while (rs.next()) {
                Camara camara = new Camara();
                camara.setId(rs.getInt("id"));
                camara.setModelo(rs.getString("modelo"));
                camara.setCodigo_serie(rs.getString("codigo_serie"));
                camara.setLatitud(rs.getInt("latitud"));
                camara.setLongitud(rs.getInt("longitud"));
                camaras.add(camara);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return camaras;
    }
    
}
