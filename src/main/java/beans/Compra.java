
package beans;

import java.sql.Date;

public class Compra {
    
    private int id;
    private String username;
    private Date fechaCompra;
    private boolean novedad;
    private int anos_anejado;

    public Compra(int id, String username, Date fechaCompra, boolean novedad, int anos_anejado) {
        this.id = id;
        this.username = username;
        this.fechaCompra = fechaCompra;
        this.novedad = novedad;
        this.anos_anejado = anos_anejado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public boolean isNovedad() {
        return novedad;
    }

    public void setNovedad(boolean novedad) {
        this.novedad = novedad;
    }

    public int getAnos_anejado() {
        return anos_anejado;
    }

    public void setAnos_anejado(int anos_anejado) {
        this.anos_anejado = anos_anejado;
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id + ", username=" + username + ", fechaCompra=" + fechaCompra + ", novedad=" + novedad + ", anos_anejado=" + anos_anejado + '}';
    }       
}
