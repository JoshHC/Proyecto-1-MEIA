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
    
    public Lista(String Nombre, String Usuario, String Desc, String CantUsuarios, String FechaCreacion)
    {
        this.Nombre_lista = Nombre;
        this.Usuario = Usuario;
        this.Descripcion = Desc;
        this.Numero_usuarios = CantUsuarios;
        this.Fecha_creacion = FechaCreacion;
    }
    
}
