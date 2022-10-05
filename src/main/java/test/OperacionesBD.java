package test;

import beans.Vinos;
import connection.DBConnection;
import java.sql.ResultSet;
import java.sql.Statement;

public class OperacionesBD {

    public static void main(String[] args) {
        //listarVino();
        actualizarVino(1, 10/11);
    }

    public static void actualizarVino(int id, int anos_anejado) {

        DBConnection con = new DBConnection();
        String sql = "UPDATE vino SET anos_anejado = '" + anos_anejado + "' where id = " + id;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }

    public static void listarVino() {

        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM vino;";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                int anos_anejado = rs.getInt("anos_anejado");
                String autor = rs.getString("autor");
                int copias = rs.getInt("copias");
                boolean novedad = rs.getBoolean("novedad");

                Vinos vinos = new Vinos(id, titulo, anos_anejado, autor, copias, novedad);
                System.out.println(vinos.toString());
            }
            st.executeQuery(sql);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
    }
}

