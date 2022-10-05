package controller;

public interface IVinoController {

    public String listar(boolean ordenar, String orden);
    
    public String devolver(int id, String username);
    
        public String sumarCantidad(int id);

}
