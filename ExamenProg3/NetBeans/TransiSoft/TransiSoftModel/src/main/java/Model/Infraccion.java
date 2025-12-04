package Model;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.Date;


public class Infraccion {
    private int id;
    private Vehiculo vehiculo;
    private Propietario propietario;
    private Camara camara;
    private Captura captura;
    private double monto;
    private double limite;
    private double exceso;
    @JsonbTypeAdapter(DateAdapter.class)
    private Date fecha_registro;

    public Infraccion() {
    }

    public Infraccion(Vehiculo vehiculo, Propietario propietario, Camara camara, 
            Captura captura, double monto, double limite, double exceso, Date fecha_registro) {
        this.vehiculo = vehiculo;
        this.propietario = propietario;
        this.camara = camara;
        this.captura = captura;
        this.monto = monto;
        this.limite = limite;
        this.exceso = exceso;
        this.fecha_registro = fecha_registro;
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

    /**
     * @return the camara
     */
    public Camara getCamara() {
        return camara;
    }

    /**
     * @param camara the camara to set
     */
    public void setCamara(Camara camara) {
        this.camara = camara;
    }

    /**
     * @return the captura
     */
    public Captura getCaptura() {
        return captura;
    }

    /**
     * @param captura the captura to set
     */
    public void setCaptura(Captura captura) {
        this.captura = captura;
    }

    /**
     * @return the monto
     */
    public double getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(double monto) {
        this.monto = monto;
    }

    /**
     * @return the limite
     */
    public double getLimite() {
        return limite;
    }

    /**
     * @param limite the limite to set
     */
    public void setLimite(double limite) {
        this.limite = limite;
    }

    /**
     * @return the exceso
     */
    public double getExceso() {
        return exceso;
    }

    /**
     * @param exceso the exceso to set
     */
    public void setExceso(double exceso) {
        this.exceso = exceso;
    }

    /**
     * @return the fecha_registro
     */
    public Date getFecha_registro() {
        return fecha_registro;
    }

    /**
     * @param fecha_registro the fecha_registro to set
     */
    public void setFecha_registro(Date fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    
    
    
}
