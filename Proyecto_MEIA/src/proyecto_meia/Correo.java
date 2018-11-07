/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

/**
 *
 * @author Admin
 */
public class Correo {
    
    String Izq;
    String Der;
    String UsuarioEmisor;
    String UsuarioReceptor;
    String FechaTransaccion;
    String Asunto;
    String Mensaje;
    String Adjunto;
    String Estatus;
    
    public Correo()
    {
        
    }

    public Correo(String Izq, String Der, String UsuarioEmisor, String UsuarioReceptor, String FechaTransaccion, 
            String Asunto, String Mensaje, String Adjunto, String Estatus) {
        this.Izq = Izq;
        this.Der = Der;
        this.UsuarioEmisor = UsuarioEmisor;
        this.UsuarioReceptor = UsuarioReceptor;
        this.FechaTransaccion = FechaTransaccion;
        this.Asunto = Asunto;
        this.Mensaje = Mensaje;
        this.Adjunto = Adjunto;
        this.Estatus = Estatus;
    }
    
}
