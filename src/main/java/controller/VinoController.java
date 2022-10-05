package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Vinos;
import connection.DBConnection;

public class VinoController implements IVinoController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from vino";

        if (ordenar == true) {
            sql += " order by anos_anejado " + orden;
        }

        List<String> vinos = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int id = rs.getInt("id");
                String nombre_vino = rs.getString("nombre_vino");
                int anos_anejado = rs.getInt("anos_anejado");
                String pais_procedencia = rs.getString("pais_procedencia");
                int cantidad = rs.getInt("cantidad");
                boolean novedad = rs.getBoolean("novedad");

                Vinos vino = new Vinos(id, nombre_vino, anos_anejado, pais_procedencia, cantidad, novedad);

                vinos.add(gson.toJson(vino));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(vinos);
    }

    @Override
    public String devolver(int id, String username) {

        DBConnection con = new DBConnection();
        String sql = "Delete from compra where id= " + id + " and username = '"
                + username + "' limit 1";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeQuery(sql);

            this.sumarCantidad(id);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";
    }

    @Override
    public String sumarCantidad(int id) {

        DBConnection con = new DBConnection();

        String sql = "Update vinos set cantidad = (Select cantidad from vinos where id = "
                + id + ") + 1 where id = " + id;

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            con.desconectar();
        }

        return "false";

    }
}
