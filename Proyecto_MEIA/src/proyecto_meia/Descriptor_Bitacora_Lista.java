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
public class Descriptor_Bitacora_Lista {
    
   String Nombre_simbolico;
   String Fecha_Creacion;
   String Usuario_Creacion;
   String Fecha_Modificacion;
   String Usuario_Modificacion;
   String NumerodeRegistros;
   String RegistrosActivos;
   String RegistrosInactivos;
   String Max_Reorganizacion;
   
   
   public Descriptor_Bitacora_Lista(String Nombre_simbolico, String Fecha_Creacion, String Usuario_Creacion, String Fecha_Modificacion, String Usuario_Modificacion, String NumerodeRegistros, String RegistrosActivos, String RegistrosInactivos, String Max_Reorganizacion) {
        this.Nombre_simbolico = Nombre_simbolico;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Usuario_Creacion = Usuario_Creacion;
        this.Fecha_Modificacion = Fecha_Modificacion;
        this.Usuario_Modificacion = Usuario_Modificacion;
        this.NumerodeRegistros = NumerodeRegistros;
        this.RegistrosActivos = RegistrosActivos;
        this.RegistrosInactivos = RegistrosInactivos;
        this.Max_Reorganizacion = Max_Reorganizacion;
    }
}
