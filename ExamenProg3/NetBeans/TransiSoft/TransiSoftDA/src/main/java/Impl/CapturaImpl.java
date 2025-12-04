
package Impl;

import DAO.CapturaDAO;
import Model.Camara;
import Model.Captura;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transisoft.config.DBManager;

public class CapturaImpl implements CapturaDAO{
    private ResultSet rs;
    
    @Override
    public int insertar(Captura captura) {
        Map<Integer, Object> parametrosSalida = new HashMap<>();
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, captura.getId());
        parametrosEntrada.put(3, captura.getPlaca());
        parametrosEntrada.put(4, captura.getVelocidad());
        parametrosEntrada.put(5, captura.getFecha_captura());
        parametrosEntrada.put(6, captura.getEstado());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_CAPTURA", parametrosEntrada, parametrosSalida);
        captura.setId((int) parametrosSalida.get(1));
        System.out.println("Se ha insertado la captura");
        return captura.getId();
    }

    @Override
    public int modificar(Captura captura) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, captura.getId());
        parametrosEntrada.put(2, captura.getId());
        parametrosEntrada.put(3, captura.getPlaca());
        parametrosEntrada.put(4, captura.getVelocidad());
        parametrosEntrada.put(5, captura.getFecha_captura());
        parametrosEntrada.put(6, captura.getEstado());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_CAPTURA", parametrosEntrada, null);
        System.out.println("Se ha modificado la captura");
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_CAPTURA", parametrosEntrada, null);
        System.out.println("Se ha eliminado la captura");
        return resultado;
    }

    @Override
    public Captura obtenerPorId(int id) {
        Captura captura = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_CAPTURA_X_ID", parametrosEntrada);
        try {
            if (rs.next()) {
                captura = new Captura();
                captura.setId(rs.getInt("id"));
                captura.setId(rs.getInt("id_camara"));
                captura.setPlaca(rs.getString("placa"));
                captura.setVelocidad(rs.getDouble("velocidad"));
                captura.setFecha_captura(rs.getTimestamp("fecha_captura"));
                captura.setEstado(rs.getString("estado"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return captura;
    }

    @Override
    public ArrayList<Captura> listarTodos() {
        ArrayList<Captura> capturas = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("listarCapturas", null);
        System.out.println("Lectura de todas las capturas...");
        try{
            while(rs.next()){
                if(capturas == null) capturas = new ArrayList<>();
                Captura captura = new Captura();
                captura.setId(rs.getInt("id"));
                captura.setPlaca(rs.getString("placa"));
                captura.setFecha_captura(rs.getDate("fecha_captura"));
                
                Camara camara = new Camara();
                camara.setId(rs.getInt("id_camara"));
                camara.setCodigo_serie(rs.getString("camara_codigo_serie"));
                camara.setModelo(rs.getString("camara_modelo"));
                camara.setLatitud(rs.getInt("camara_latitud"));
                camara.setLongitud(rs.getInt("camara_longitud"));
                captura.setCamara(camara);
                
                captura.setEstado(rs.getString("estado"));
                captura.setVelocidad(rs.getDouble("velocidad"));
                capturas.add(captura);
            }
        }catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return capturas;
    }

    @Override
    public int modificarEstadoCaptura(String estado, Captura captura) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, estado);
        parametrosEntrada.put(2, captura.getId());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("modificarEstadoCaptura", parametrosEntrada, null);
        System.out.println("Se ha realizado la modificacion del estado de la captura");
        return resultado;
    }
    
}
