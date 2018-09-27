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
public class Usuario 
{
   String Usuario;
   String Nombre;
   String Apellido;
   String Password;
   byte rol;
   Date Fecha;
   String CorreoAlterno;
   int Telefono;
   String PathFotografia;
   byte status;

 public Usuario(String usuario, String nombre, String apellido, String password, byte rol, Date fecha, String correoalterno, int telefono, String pathfotografia, byte status)
 {
     Usuario = usuario;
     Nombre = nombre;
     Apellido = apellido;
     Password = password;
     this.rol = rol;
     Fecha = fecha;
     CorreoAlterno = correoalterno;
     Telefono = telefono;
     PathFotografia = pathfotografia;
     this.status = status;   
 }

 public Usuario()
 {
     
 }

   
}
