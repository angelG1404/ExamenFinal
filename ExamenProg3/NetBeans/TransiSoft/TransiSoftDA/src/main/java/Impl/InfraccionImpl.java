
package Impl;

import DAO.InfraccionDAO;
import Model.Camara;
import Model.Captura;
import Model.Infraccion;
import Model.Propietario;
import Model.Vehiculo;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transisoft.config.DBManager;

public class InfraccionImpl implements InfraccionDAO{
    private ResultSet rs;
    @Override
    public int insertar(Infraccion infraccion) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();   
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, infraccion.getVehiculo().getPlaca());
        parametrosEntrada.put(3, infraccion.getCaptura().getVelocidad());
        parametrosEntrada.put(4, infraccion.getLimite());
        parametrosEntrada.put(5, infraccion.getExceso());
        parametrosEntrada.put(6, infraccion.getVehiculo().getMarca());
        parametrosEntrada.put(7, infraccion.getVehiculo().getModelo());
        parametrosEntrada.put(8, infraccion.getVehiculo().getAnho());
        parametrosEntrada.put(9, infraccion.getPropietario().getDni());
        parametrosEntrada.put(10, infraccion.getPropietario().getNombres());
        parametrosEntrada.put(11, infraccion.getPropietario().getApellidos());
        parametrosEntrada.put(12, infraccion.getPropietario().getDireccion());
        parametrosEntrada.put(13, infraccion.getCamara().getId());
        parametrosEntrada.put(14, infraccion.getCamara().getModelo());
        parametrosEntrada.put(15, infraccion.getCamara().getCodigo_serie());
        parametrosEntrada.put(16, infraccion.getCamara().getLatitud());
        parametrosEntrada.put(17, infraccion.getCamara().getLongitud());
        parametrosEntrada.put(18, infraccion.getMonto());
        parametrosEntrada.put(19, infraccion.getCaptura().getFecha_captura());
        parametrosEntrada.put(20, infraccion.getFecha_registro());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_INFRACCION", parametrosEntrada, parametrosSalida);
        infraccion.setId((int) parametrosSalida.get(1));
        System.out.println("Se ha realizado el registro de la infraccion");
        return infraccion.getId();
    }

    @Override
    public int modificar(Infraccion infraccion) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, infraccion.getId());
//        parametrosEntrada.put(2, infraccion.getPlaca());
//        parametrosEntrada.put(3, infraccion.getVelocidad());
        parametrosEntrada.put(4, infraccion.getLimite());
        parametrosEntrada.put(5, infraccion.getExceso());
        parametrosEntrada.put(6, infraccion.getVehiculo().getMarca());
        parametrosEntrada.put(7, infraccion.getVehiculo().getModelo());
        parametrosEntrada.put(8, infraccion.getVehiculo().getAnho());
        parametrosEntrada.put(9, infraccion.getPropietario().getDni());
        parametrosEntrada.put(10, infraccion.getPropietario().getNombres());
        parametrosEntrada.put(11, infraccion.getPropietario().getApellidos());
        parametrosEntrada.put(13, infraccion.getCamara().getId());
        parametrosEntrada.put(14, infraccion.getCamara().getModelo());
        parametrosEntrada.put(15, infraccion.getCamara().getCodigo_serie());
        parametrosEntrada.put(16, infraccion.getCamara().getLatitud());
        parametrosEntrada.put(17, infraccion.getCamara().getLongitud());
        parametrosEntrada.put(18, infraccion.getMonto());
        parametrosEntrada.put(19, infraccion.getCaptura().getFecha_captura());
        parametrosEntrada.put(20, infraccion.getFecha_registro());

        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_INFRACCION", parametrosEntrada, null);
        System.out.println("Se ha modificado la infracción");
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_INFRACCION", parametrosEntrada, null);
        System.out.println("Se ha eliminado la infracción");
        return resultado;
    }

    @Override
    public Infraccion obtenerPorId(int id) {
        Infraccion infraccion = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_INFRACCION_X_ID", parametrosEntrada);
        try {
            if (rs.next()) {
                infraccion = new Infraccion();
                infraccion.setId(rs.getInt("id"));
//                infraccion.setPlaca(rs.getString("placa"));
//                infraccion.setVelocidad(rs.getDouble("velocidad"));
                infraccion.setLimite(rs.getDouble("limite"));
                infraccion.setExceso(rs.getDouble("exceso"));
                
                Vehiculo v =new Vehiculo();
                v.setMarca(rs.getString("vehiculo_marca"));
                v.setModelo(rs.getString("vehiculo_modelo"));
                v.setAnho(rs.getInt("vehiculo_anho"));
                infraccion.setVehiculo(v);
                
                Propietario p=new Propietario();
                p.setDni(rs.getString("propietario_dni"));
                p.setNombres(rs.getString("propietario_nombres"));
                p.setApellidos(rs.getString("propietario_apellidos"));
                p.setDireccion(rs.getString("propietario_direccion"));
                infraccion.setPropietario(p);
                
                Camara c =new Camara();
                c.setId(rs.getInt("id_camara"));
                c.setModelo(rs.getString("camara_modelo"));
                c.setCodigo_serie(rs.getString("camara_codigo_serie"));
                c.setLatitud(rs.getInt("camara_latitud"));
                c.setLongitud(rs.getInt("camara_longitud"));
                infraccion.setCamara(c);
                
                
                Captura cap=new Captura();
                cap.setFecha_captura(rs.getTimestamp("fecha_captura"));
                infraccion.setCaptura(cap);
                
                infraccion.setMonto(rs.getDouble("monto"));
                infraccion.setFecha_registro(rs.getTimestamp("fecha_registro"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return infraccion;
    }
    @Override
    public ArrayList<Infraccion> listarTodos() {
         ArrayList<Infraccion> infracciones = null;
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_INFRACCIONES_TODAS", null);
        System.out.println("Lectura de infracciones...");
        try{
            while(rs.next()){
                if(infracciones == null) infracciones = new ArrayList<>();
                Infraccion i = new Infraccion();
                i.setId(rs.getInt("id"));
                
                //Vehiculo
                Vehiculo v = new Vehiculo();
                v.setMarca(rs.getString("vehiculo_marca"));
                v.setModelo(rs.getString("vehiculo_modelo"));
                v.setAnho(rs.getInt("vehiculo_anho"));
                i.setVehiculo(v);
                
                //Propietario
                Propietario p = new Propietario();
                p.setDni(rs.getString("propietario_dni"));
                p.setNombres(rs.getString("propietario_nombres"));
                p.setApellidos(rs.getString("propietario_apellidos"));
                p.setDireccion(rs.getString("propietario_direccion"));
                i.setPropietario(p);
                
                //Camara
                Camara c =new Camara();
                c.setModelo(rs.getString("camara_modelo"));
                c.setCodigo_serie(rs.getString("camara_codigo_serie"));
                c.setLatitud(rs.getInt("camara_latitud"));
                c.setLongitud(rs.getInt("camara_longitud"));
                i.setCamara(c);
                
                i.setMonto(rs.getDouble("monto"));
                i.setFecha_registro(rs.getDate("fecha_registro"));
                i.setLimite(rs.getDouble("limite"));
                i.setExceso(rs.getDouble("exceso"));
                
                Captura cap =new Captura();
                cap.setFecha_captura(rs.getDate("fecha_captura"));
                cap.setPlaca(rs.getString("placa"));
                cap.setVelocidad(rs.getDouble("velocidad"));
                infracciones.add(i);
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally{
            DBManager.getInstance().cerrarConexion();
        }
        return infracciones;

    }
    
}
