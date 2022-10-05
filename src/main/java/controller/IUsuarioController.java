package controller;

import java.util.Map;

public interface IUsuarioController {

    public String login(String username, String contrasena);

    public String register(String username, String contrasena,
            String nombre, String apellidos, String email, double saldo);

    public String pedir(String username);

    public String modificar(String username, String nuevaContrasena,
            String nuevoNombre, String nuevosApellidos, String nuevoEmail,
            double nuevoSaldo);
    
    public String verCantidad(String username);

    public String devolverVinos(String username, Map<Integer, Integer> cantidad);

    public String eliminar(String username);

}
