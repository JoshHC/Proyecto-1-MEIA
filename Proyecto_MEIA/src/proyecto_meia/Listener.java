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

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Listener extends Thread {
    private Connection Conexion;
    private final org.postgresql.PGConnection pgconn;
    private String id;
    private String GrupoReceptor;
    private String GrupoEmisor;
    private Notificacion Not;  

    Listener(Connection conn) throws SQLException {
		this.Conexion = conn;
		this.pgconn = (org.postgresql.PGConnection)conn;
		Statement stmt = conn.createStatement();
		stmt.execute("LISTEN q_event");
		stmt.close();
    }

    public void run() {
        while (true) {
            try {
                //Escucha en la base de Datos para ver si hay mensajes nuevos
                Statement stmt = Conexion.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT 1"); 
                rs.close();
                stmt.close();

	       //recibe las notificaciones de JDBC
                org.postgresql.PGNotification notifications[] = pgconn.getNotifications();
                if (notifications != null) {
                    for (int i=0; i<notifications.length; i++) {
                        //Descomponer el json que accion es en esta parte notifications[i] es cada una de las notificaciones de postgresql 
                        String action = "";
                                          
                        if(action.equals("INSERT")){
                            //comprobar si es para mi
                            
                            id = "";
                            GrupoReceptor = "";
                            GrupoEmisor = "";                           
                            boolean existe = false;
                            
                            if(GrupoReceptor.equals("1")){
                                //si es para mi enviar el update con la respuesta
                                BDD.getInstancia().setMensaje("El grupo " + GrupoReceptor + " te ha enviado un mensaje." );
                                Not = new Notificacion();
                                Not.setVisible(true);
                             
                                //si es para mi enviar el update con la respuesta de que el usuario existe
                                if(existe){
                                    BDD.getInstancia().Update(id, existe);
                                }else{
                                    BDD.getInstancia().Update(id, existe);
                                }                                        
                            }
                        }else{
                            //UPDATE
                            
                            //comprobar si yo fui el que envie la solicitud
                            //Descomponer id, grupo emisor y grupo receptor en esta parte
                            id = "";
                            GrupoEmisor = "";
                            GrupoReceptor = "";
                            
                            if(GrupoEmisor.equals("1")){
								 //comprobar si el update fue true or false descomponiendo el json
								 String respuesta = "";
								 //Comprobar cual fue la respuesta
								 if(respuesta.equals("false")){
									BDD.getInstancia().setMensaje("El grupo " + GrupoReceptor + " no encontro el usuario." );
									Not = new Notificacion();
									Not.setVisible(true);
								 }else{
									BDD.getInstancia().setMensaje("El grupo " + GrupoReceptor + " ha recibido el mensaje." );
									Not = new Notificacion();
									Not.setVisible(true);
								 }
								 //Eliminar la solicitud
								 BDD.getInstancia().Delete(id);
                            }
                        }                                             
                    }
                }
                //Espera para la siguiente notifiacion
                Thread.sleep(500);
            } catch (SQLException | InterruptedException sqle) {
                    sqle.printStackTrace();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Listener.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
