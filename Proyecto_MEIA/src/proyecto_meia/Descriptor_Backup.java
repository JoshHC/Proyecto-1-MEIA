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
public class Descriptor_Backup 
{   
    String Nombre_Simbolico;
    String Fecha_Creacion;
    String Usuario_Creacion;
    String Fecha_Modificacion;
    String Usuario_modificacion;
    String NumerodeRegistros;
    
    public Descriptor_Backup(String Nombre_Simbolico, String Fecha_Creacion, String Usuario_Creacion, String Fecha_Modificacion, String Usuario_modificacion, String NumerodeRegistros) {
        this.Nombre_Simbolico = Nombre_Simbolico;
        this.Fecha_Creacion = Fecha_Creacion;
        this.Usuario_Creacion = Usuario_Creacion;
        this.Fecha_Modificacion = Fecha_Modificacion;
        this.Usuario_modificacion = Usuario_modificacion;
        this.NumerodeRegistros = NumerodeRegistros;
    }
    
    
}
