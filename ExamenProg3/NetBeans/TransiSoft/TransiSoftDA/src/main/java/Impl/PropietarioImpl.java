
package Impl;

import DAO.PropietarioDAO;
import Model.Propietario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transisoft.config.DBManager;

public class PropietarioImpl implements PropietarioDAO{
    private ResultSet rs;

    @Override
    public int insertar(Propietario propietario) {
        Map<Integer, Object> parametrosSalida = new HashMap<>();
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, propietario.getDni());
        parametrosEntrada.put(3, propietario.getNombres());
        parametrosEntrada.put(4, propietario.getApellidos());
        parametrosEntrada.put(5, propietario.getDireccion());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_PROPIETARIO", parametrosEntrada, parametrosSalida);
        propietario.setId((int) parametrosSalida.get(1));
        System.out.println("Se ha insertado el propietario");
        return propietario.getId();
    }

    @Override
    public int modificar(Propietario propietario) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, propietario.getId());
        parametrosEntrada.put(2, propietario.getDni());
        parametrosEntrada.put(3, propietario.getNombres());
        parametrosEntrada.put(4, propietario.getApellidos());
        parametrosEntrada.put(5, propietario.getDireccion());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_PROPIETARIO", parametrosEntrada, null);
        System.out.println("Se ha modificado el propietario");
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_PROPIETARIO", parametrosEntrada, null);
        System.out.println("Se ha eliminado el propietario");
        return resultado;
    }

    @Override
    public Propietario obtenerPorId(int id) {
        Propietario propietario = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_PROPIETARIO_X_ID", parametrosEntrada);
        try {
            if (rs.next()) {
                propietario = new Propietario();
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return propietario;
    }

    @Override
    public ArrayList<Propietario> listarTodos() {
        ArrayList<Propietario> propietarios = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_PROPIETARIOS_TODOS", null);
        try {
            while (rs.next()) {
                Propietario propietario = new Propietario();
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
                propietarios.add(propietario);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return propietarios;
    }

    @Override
    public Propietario obtenerPropietarioxPlaca(String placa) {
        Propietario propietario = null;
        Map<Integer, Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, placa);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("sp_listarPropietariosPorPlaca", parametrosEntrada);
        try {
            if (rs.next()) {
                propietario = new Propietario();
                propietario.setId(rs.getInt("id"));
                propietario.setDni(rs.getString("dni"));
                propietario.setNombres(rs.getString("nombres"));
                propietario.setApellidos(rs.getString("apellidos"));
                propietario.setDireccion(rs.getString("direccion"));
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return propietario;   
    }
    
}
