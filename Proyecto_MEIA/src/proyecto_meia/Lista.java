package proyecto_meia;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Lista {
    
    String Nombre_lista;
    String Usuario;
    String Descripcion;
    String Numero_usuarios;
    String Fecha_creacion;
    String Status;

    public Lista(String Nombre_lista, String Usuario, String Descripcion, String Numero_usuarios, String Fecha_creacion, String Status) {
        this.Nombre_lista = Nombre_lista;
        this.Usuario = Usuario;
        this.Descripcion = Descripcion;
        this.Numero_usuarios = Numero_usuarios;
        this.Fecha_creacion = Fecha_creacion;
        this.Status = Status;
    }
    
}
