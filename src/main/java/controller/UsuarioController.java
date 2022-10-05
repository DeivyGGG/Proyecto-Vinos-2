package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import com.google.gson.Gson;

import beans.Usuario;
import connection.DBConnection;
import java.util.HashMap;
import java.util.Map;

public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String username, String contrasena) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuarios where username = '" + username
                + "' and contrasena = '" + contrasena + "'";
        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");

                Usuario usuario
                        = new Usuario(username, contrasena, nombre, apellidos, email, saldo);
                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
     @Override
    public String register(String username, String contrasena, String nombre, String apellidos, String email,
            double saldo) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Insert into usuarios values('" + username + "', '" + contrasena + "', '" + nombre
                + "', '" + apellidos + "', '" + email + "', " + saldo + ")";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            Usuario usuario = new Usuario(username, contrasena, nombre, apellidos, email, saldo);

            st.close();

            return gson.toJson(usuario);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            con.desconectar();
        }

        return "false";

    }
        @Override
    public String pedir(String username) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from usuarios where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
  
            while (rs.next()) {
                String contrasena = rs.getString("contrasena");
                String nombre = rs.getString("nombre");
                String apellidos = rs.getString("apellidos");
                String email = rs.getString("email");
                double saldo = rs.getDouble("saldo");

                Usuario usuario = new Usuario(username, contrasena,
                        nombre, apellidos, email, saldo);

                return gson.toJson(usuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
      @Override
    public String modificar(String username, String nuevaContrasena, 
            String nuevoNombre, String nuevosApellidos,
            String nuevoEmail, double nuevoSaldo) {   

        DBConnection con = new DBConnection();

        String sql = "Update usuarios set contrasena = '" + nuevaContrasena +
                "', nombre = '" + nuevoNombre + "', "
                + "apellido = '" + nuevosApellidos + "', email = '" 
                + nuevoEmail + "', saldo = " + nuevoSaldo;

        sql += " where username = '" + username + "'";

        try {

            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String verCantidad(String username) {

        DBConnection con = new DBConnection();
        String sql = "Select id,count(*) as num_cantidad from compra where username = '" 
                + username + "' group by id;";

        Map<Integer, Integer> cantidad = new HashMap<Integer, Integer>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                int num_cantidad = rs.getInt("num_cantidad");

                cantidad.put(id, num_cantidad);
            }

            devolverVinos(username, cantidad);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";

    }

    @Override
    public String devolverVinos(String username, Map<Integer, Integer> cantidad) {

        DBConnection con = new DBConnection();

        try {
            for (Map.Entry<Integer, Integer> vino : cantidad.entrySet()) {
                int id = vino.getKey();
                int num_cantidad = vino.getValue();

                String sql = "Update vino set cantidad = (Select cantidad + " + num_cantidad +
                        " from vino where id = " + id + ") where id = " + id;

                Statement st = con.getConnection().createStatement();
                st.executeUpdate(sql);

            }

            this.eliminar(username);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }
        return "false";
    }

    public String eliminar(String username) {

        DBConnection con = new DBConnection();

        String sql1 = "Delete from compra where username = '" + username + "'";
        String sql2 = "Delete from usuario where username = '" + username + "'";

        try {
            Statement st = con.getConnection().createStatement();
            st.executeUpdate(sql1);
            st.executeUpdate(sql2);

            return "true";
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
}