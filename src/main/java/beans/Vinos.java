
package beans;

public class Vinos {
    private int id;
    private String nombre_vino;
    private int anos_anejado;
    private String pais_procedencia;
    private int cantidad;
    private boolean novedad;

    public Vinos(int id, String nombre_vino, int anos_anejado, String pais_procedencia, int cantidad, boolean novedad) {
        this.id = id;
        this.nombre_vino = nombre_vino;
        this.anos_anejado = anos_anejado;
        this.pais_procedencia = pais_procedencia;
        this.cantidad = cantidad;
        this.novedad = novedad;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_vino() {
        return nombre_vino;
    }

    public void setNombre_vino(String nombre_vino) {
        this.nombre_vino = nombre_vino;
    }

    public int getAnos_anejado() {
        return anos_anejado;
    }

    public void setAnos_anejado(int anos_anejado) {
        this.anos_anejado = anos_anejado;
    }

    public String getpais_procedencia() {
        return pais_procedencia;
    }

    public void setpais_procedencia(String pais_procedencia) {
        this.pais_procedencia = pais_procedencia;
    }

    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    @Override
    public String toString() {
        return "Vinos{" + "id=" + id + ", nombre_vino=" + nombre_vino + ", anos_anejado=" + anos_anejado 
                + ", pais_procedencia=" + pais_procedencia + ", cantidad=" + cantidad + ", novedad=" + novedad + '}';
    }
    
    
}
