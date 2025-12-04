package Model;
public class Camara {
    private int id;
    private String modelo;
    private String codigo_serie;
    private int latitud;
    private int longitud;
    
    public Camara(){};
    public Camara(String modelo, String codigo_serie, int latitud, int longitud) {
        this.modelo = modelo;
        this.codigo_serie = codigo_serie;
        this.latitud = latitud;
        this.longitud = longitud;
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
     * @return the modelo
     */
    public String getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the codigo_serie
     */
    public String getCodigo_serie() {
        return codigo_serie;
    }

    /**
     * @param codigo_serie the codigo_serie to set
     */
    public void setCodigo_serie(String codigo_serie) {
        this.codigo_serie = codigo_serie;
    }

    /**
     * @return the latitud
     */
    public int getLatitud() {
        return latitud;
    }

    /**
     * @param latitud the latitud to set
     */
    public void setLatitud(int latitud) {
        this.latitud = latitud;
    }

    /**
     * @return the longitud
     */
    public int getLongitud() {
        return longitud;
    }

    /**
     * @param longitud the longitud to set
     */
    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }
    
    
}
