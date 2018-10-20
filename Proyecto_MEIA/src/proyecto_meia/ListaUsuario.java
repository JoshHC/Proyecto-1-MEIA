/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.util.Date;

/**
 *
 * @author josue
 */
public class ListaUsuario {
    
    
    String Nombre_lista;
    String Usuario;
    String Usuario_Asociado;
    String Descripcion;
    String Fecha_creacion;
    String Status;

    public ListaUsuario(String Nombre_lista, String Usuario, String Usuario_Asociado, String Descripcion, String Fecha_creacion, String Status) {
        this.Nombre_lista = Nombre_lista;
        this.Usuario = Usuario;
        this.Usuario_Asociado = Usuario_Asociado;
        this.Descripcion = Descripcion;
        this.Fecha_creacion = Fecha_creacion;
        this.Status = Status;
    }
}
