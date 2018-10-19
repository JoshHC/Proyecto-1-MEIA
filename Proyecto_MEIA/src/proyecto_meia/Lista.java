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
    int Numero_usuarios;
    Date Fecha_creacion;
    byte Status;
    
    public Lista(String Nombre, String Usuario, String Desc, int CantUsuarios, Date FechaCreacion)
    {
        this.Nombre_lista = Nombre;
        this.Usuario = Usuario;
        this.Descripcion = Desc;
        this.Numero_usuarios = CantUsuarios;
        this.Fecha_creacion = FechaCreacion;
    }
    
}
