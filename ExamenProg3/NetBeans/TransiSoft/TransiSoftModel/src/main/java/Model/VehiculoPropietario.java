package Model;
public class VehiculoPropietario {
    private int id;
    private Vehiculo vehiculo;
    private Propietario propietario;

    public VehiculoPropietario() {
    }

    public VehiculoPropietario(Vehiculo vehiculo, Propietario propietario) {
        this.vehiculo = vehiculo;
        this.propietario = propietario;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the vehiculo
     */
    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    /**
     * @param vehiculo the vehiculo to set
     */
    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    /**
     * @return the propietario
     */
    public Propietario getPropietario() {
        return propietario;
    }

    /**
     * @param propietario the propietario to set
     */
    public void setPropietario(Propietario propietario) {
        this.propietario = propietario;
    }
    
    
}
