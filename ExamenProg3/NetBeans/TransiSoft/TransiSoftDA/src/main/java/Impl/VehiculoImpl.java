
package Impl;

import DAO.VehiculoDAO;
import Model.Vehiculo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import pe.edu.pucp.transisoft.config.DBManager;

public class VehiculoImpl implements VehiculoDAO{
    private ResultSet rs;

    @Override
    public int insertar(Vehiculo vehiculo) {
        Map<Integer,Object> parametrosSalida = new HashMap<>();
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosSalida.put(1, Types.INTEGER);
        parametrosEntrada.put(2, vehiculo.getPlaca());
        parametrosEntrada.put(3, vehiculo.getMarca());
        parametrosEntrada.put(4, vehiculo.getModelo());
        parametrosEntrada.put(5, vehiculo.getAnho());
        DBManager.getInstance().ejecutarProcedimiento("INSERTAR_VEHICULO", parametrosEntrada, parametrosSalida);
        vehiculo.setId((int) parametrosSalida.get(1));
        System.out.println("Se ha insertado el vehículo");
        return vehiculo.getId();
    }

    @Override
    public int modificar(Vehiculo vehiculo) {
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, vehiculo.getId());
        parametrosEntrada.put(2, vehiculo.getPlaca());
        parametrosEntrada.put(3, vehiculo.getMarca());
        parametrosEntrada.put(4, vehiculo.getModelo());
        parametrosEntrada.put(5, vehiculo.getAnho());
        int resultado = DBManager.getInstance().ejecutarProcedimiento("MODIFICAR_VEHICULO", parametrosEntrada, null);
        System.out.println("Se ha modificado el vehículo");
        return resultado;
    }

    @Override
    public int eliminar(int id) {
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        int resultado = DBManager.getInstance().ejecutarProcedimiento("ELIMINAR_VEHICULO", parametrosEntrada, null);
        System.out.println("Se ha eliminado el vehículo");
        return resultado;
    }

    @Override
    public Vehiculo obtenerPorId(int id) {
        Vehiculo vehiculo = null;
        Map<Integer,Object> parametrosEntrada = new HashMap<>();
        parametrosEntrada.put(1, id);
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("OBTENER_VEHICULO_X_ID", parametrosEntrada);
        try {
            if(rs.next()){
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnho(rs.getInt("anho"));
            }
        } catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        } finally{
            DBManager.getInstance().cerrarConexion();
        }
        return vehiculo;
    }

    @Override
    public ArrayList<Vehiculo> listarTodos() {
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        rs = DBManager.getInstance().ejecutarProcedimientoLectura("LISTAR_VEHICULOS_TODOS", null);
        try {
            while(rs.next()){
                Vehiculo vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
                vehiculo.setAnho(rs.getInt("anho"));
                vehiculos.add(vehiculo);
            }
        } catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        } finally {
            DBManager.getInstance().cerrarConexion();
        }
        return vehiculos;
    }

    @Override
    public Vehiculo ObtenerVehiculoxPlaca(String placa) {
         Vehiculo vehiculo = null;
        Map<Integer,Object> parametrosEntrada = new HashMap<>();

        // El parámetro 1 es la placa
        parametrosEntrada.put(1, placa);

        // Llamar al procedimiento
        rs = DBManager.getInstance()
                .ejecutarProcedimientoLectura("sp_buscarVehiculoPorPlaca", parametrosEntrada);

        try {
            if(rs.next()){
                vehiculo = new Vehiculo();
                vehiculo.setId(rs.getInt("id"));
                vehiculo.setPlaca(rs.getString("placa"));
                vehiculo.setMarca(rs.getString("marca"));
                vehiculo.setModelo(rs.getString("modelo"));
            }
        } catch(SQLException ex){
            System.out.println("ERROR: " + ex.getMessage());
        } finally{
            DBManager.getInstance().cerrarConexion();
        }

        return vehiculo;
    }
}
