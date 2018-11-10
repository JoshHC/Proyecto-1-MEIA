/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author josue
 */
public class BDD {
    
    
     private static BDD instancia;
        
    //Conexión a la  base de datos jdbc:postgresql://localhost:0000/midatabase
    private static Connection con; 
    private static Connection con2;
    private static Statement stmt;
    private static String mensaje;
    
    public static BDD getInstancia() throws ClassNotFoundException, SQLException{
        if(instancia == null){
            instancia = new BDD();
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://logical-honor-222019:us-central1:meia-mail-proyecto", "postgres", "meia");
            con2 = DriverManager.getConnection("jdbc:postgresql://logical-honor-222019:us-central1:meia-mail-proyecto", "postgres", "meia");
            stmt = con.createStatement();
            DriverManager.setLogWriter(new PrintWriter(System.out, true));            
            Listener listener = new Listener(con);
            Notificador notifier = new Notificador(con2);
            listener.start();
            notifier.start();
        }
        return instancia;
    }
    
    public String getMensaje(){
        return mensaje;
    }
    
    public void setMensaje(String msj){
        mensaje = msj;
    }
    
    public void conexion(){
        
    }
    
    public void Insert(int grupoEmisor,int grupoReceptor, String emisor, String receptor, String mensaje) throws SQLException{
        //INSERTA EN LA BASE DE DATOS
        String sql = "INSERT INTO solicitud(grupoEmisor, grupoReceptor,emisor, receptor, fecha, mensaje, aceptado) VALUES(" + grupoEmisor + " ," + grupoReceptor + ", '" + emisor + "','" + receptor + "',current_timestamp,'" + mensaje + "', false)";    
        stmt.executeUpdate(sql);        
    }
    
    public void Update(String id, boolean bool) throws SQLException{
        //MODIFICA EN LA BASE DE DATOS
        if(bool){
            stmt.executeUpdate("UPDATE solicitud SET aceptado = true WHERE idSolicitud = " + id);
        }else{
            stmt.executeUpdate("UPDATE solicitud SET aceptado = false WHERE idSolicitud = " + id);
        }
    }
    
    public void Delete(String id) throws SQLException{
		//ELIMINA EN LA BASE DE DATOS
        stmt.executeUpdate("DELETE FROM solicitud WHERE idSolicitud = " + id);
    }
    
}
