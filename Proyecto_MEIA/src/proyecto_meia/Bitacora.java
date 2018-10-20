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
public class Bitacora 
{
    String Ruta_Absoluta;
    String Usuario;
    Date Fecha_Transaccion;
    
    public Bitacora(String ruta_absoluta, String usuario,Date fecha_transaccion) 
    {
        Ruta_Absoluta = ruta_absoluta;
        Usuario = usuario;
        Fecha_Transaccion = fecha_transaccion;
    }
    
}
