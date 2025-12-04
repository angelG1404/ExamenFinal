package Model;
import jakarta.json.bind.annotation.JsonbTypeAdapter;
import java.util.Date;


public class Captura {
    private int id;
    private String placa;
    private double velocidad;
    @JsonbTypeAdapter(DateAdapter.class)
    private Date fecha_captura;
    private String estado;
    private Camara camara;
    
    public Captura(){};

    public Captura(String placa, double velocidad, Date fecha_captura, String estado, Camara camara) {
        this.placa = placa;
        this.velocidad = velocidad;
        this.fecha_captura = fecha_captura;
        this.estado = estado;
        this.camara = camara;
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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the velocidad
     */
    public double getVelocidad() {
        return velocidad;
    }

    /**
     * @param velocidad the velocidad to set
     */
    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * @return the fecha_captura
     */
    public Date getFecha_captura() {
        return fecha_captura;
    }

    /**
     * @param fecha_captura the fecha_captura to set
     */
    public void setFecha_captura(Date fecha_captura) {
        this.fecha_captura = fecha_captura;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
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
    
    @Override
    public String toString(){
        String cadena="";
        cadena+="ID Captura: "+id;
        cadena+="\nPlaca: "+placa;
        cadena+="\nVelocidad: "+velocidad;
        cadena+="\nEstado: "+estado;
        cadena+="\n------------------------------------\n";
        cadena+="\nID Camara: "+camara.getId();
        cadena+="\nModelo: "+camara.getModelo();
        cadena+="\nCodigo de serie: "+camara.getCodigo_serie();
        cadena+="\n============================================\n";
        return cadena;
    }
    
}
