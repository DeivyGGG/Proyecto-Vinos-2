package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import java.util.List;

import com.google.gson.Gson;

import beans.Compra;
import connection.DBConnection;

public class CompraController implements ICompraController {

    @Override
    public String listarCompras(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select l.id, l.nombre_vino, l.anos_anejado, l.novedad, a.fecha from vino l "
                + "inner join compra a on l.id = a.id inner join usuario u on a.username = u.username "
                + "where a.username = '" + username + "'";

        List<String> compras = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nombre_vino = rs.getString("nombre_vino");
                int anos_anejado = rs.getInt("anos_anejado");
                boolean novedad = rs.getBoolean("novedad");
                Date fechaCompra = rs.getDate("fecha");

                Compra compra = new Compra(id, nombre_vino, fechaCompra, novedad, anos_anejado);

                compras.add(gson.toJson(compra));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return gson.toJson(compras);
    }
}
