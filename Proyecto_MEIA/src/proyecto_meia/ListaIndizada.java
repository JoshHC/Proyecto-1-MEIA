/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

/**
 *
 * @author josue
 */
public class ListaIndizada {
    
    String NoRegistro;
    String Posicion;
    String Nombre_Lista;
    String Usuario;
    String Usuario_Asociado;
    String Siguiente;
    String Status;
    
    public ListaIndizada()
    {
        
    }

    public ListaIndizada(String NoRegistro, String Posicion, String Nombre_Lista, String Usuario, String Usuario_Asociado, String Siguiente, String Status) {
        this.NoRegistro = NoRegistro;
        this.Posicion = Posicion;
        this.Nombre_Lista = Nombre_Lista;
        this.Usuario = Usuario;
        this.Usuario_Asociado = Usuario_Asociado;
        this.Siguiente = Siguiente;
        this.Status = Status;
    }
    
}
