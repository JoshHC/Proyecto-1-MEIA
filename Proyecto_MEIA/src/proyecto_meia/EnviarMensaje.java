package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class EnviarMensaje extends javax.swing.JFrame {

    Procesos procesos = new Procesos();
    
    private String Destinatario;
    private String Usuario;
    private String Rol;
    
    List<Usuario> ListaUsuarios;
    List<Lista> ListaListas;
    
    public EnviarMensaje(String destinatario, String usuario, String rol) throws IOException {
        initComponents();
        
        this.Destinatario = destinatario;
        this.Usuario = usuario;
        this.Rol = rol;
                
        ListaUsuarios = new ArrayList<Usuario>();
        ListaListas = new ArrayList<Lista>();
        
        RellenarCampos();
    }

    private EnviarMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblMenu = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jBtnAdjuntar = new javax.swing.JButton();
        jCBDestinatario = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMensaje = new javax.swing.JTextArea();
        jBtnEnviar = new javax.swing.JButton();
        jBtnDescartar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enviar Mensaje");
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenu.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Enviar Mensaje");
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asunto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mensaje");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTextField1.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 570, -1));

        jBtnAdjuntar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnAdjuntar.setText("Adjuntar Archivo");
        getContentPane().add(jBtnAdjuntar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jCBDestinatario.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jCBDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -" }));
        getContentPane().add(jCBDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 410, -1));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Para");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTAMensaje.setColumns(20);
        jTAMensaje.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jTAMensaje.setLineWrap(true);
        jTAMensaje.setRows(5);
        jTAMensaje.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTAMensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 570, 170));

        jBtnEnviar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnEnviar.setText("Enviar");
        getContentPane().add(jBtnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 350, -1, -1));

        jBtnDescartar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnDescartar.setText("Descartar");
        jBtnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescartarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, -1, -1));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 700, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDescartarActionPerformed
        
        Principal Menu;
        
        try 
        {
            Menu = new Principal(Usuario, Rol);
            Menu.setLocationRelativeTo(null);
            Menu.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_jBtnDescartarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnviarMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnviarMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnviarMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnviarMensaje.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnviarMensaje().setVisible(true);
            }
        });
    }
    
    // Rellena el ComboBox con los usuarios o con las listas
    private void RellenarCampos() throws IOException
    {
        if (Destinatario.equals("Usuario"))
        {
            ObtenerUsuarios("C:\\MEIA\\Bitacora_Usuarios.txt");
            ObtenerUsuarios("C:\\MEIA\\Usuarios.txt");
            
            for (Usuario item : ListaUsuarios)
            {
                String Texto = procesos.EliminarCaracteres(item.Usuario) + " - (" + procesos.EliminarCaracteres(item.Nombre)
                        + " " + procesos.EliminarCaracteres(item.Apellido) + ")";
                
                jCBDestinatario.addItem(Texto);
            }
            
            return;    
        }
        
        if (Destinatario.equals("Lista"));
        {
            ObtenerListas("C:\\MEIA\\Bitacora_Lista.txt");
            ObtenerListas("C:\\MEIA\\Lista.txt");
            
            for (Lista item : ListaListas)
            {
                String Texto = procesos.EliminarCaracteres(item.Nombre_lista);
                
                jCBDestinatario.addItem(Texto);
            }
            
            return;
        }
    }
    
    // Obtiene los usuarios activos
    private void ObtenerUsuarios(String path) throws IOException
    {
        String pathRuta = path;
        File Archivo = new File(pathRuta);

        FileReader Lectura = null;

        try 
        {
            Lectura = new FileReader(Archivo);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        BufferedReader Leer = new BufferedReader(Lectura);
        String Linea = Leer.readLine();
        String [] Auxiliar;
        Usuario Nuevo;

        while(Linea != null)
        {
            Auxiliar = Linea.split("\\|");

            Date Fecha = new Date(Auxiliar[5]);
            byte Aux;
            byte Aux2;

            if (Auxiliar[4].equals("1"))
                Aux = 1;
            else
                Aux = 0;

            if (Auxiliar[9].equals("1"))
                Aux2 = 1;
            else
                Aux2 = 0;


            if(Auxiliar[9].equals("1"))
            {
                Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Aux,Fecha,Auxiliar[6],
                        Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
                ListaUsuarios.add(Nuevo);
            }

            Linea = Leer.readLine();
        }
    }
    
    // Obtiene las listas activas
    private void ObtenerListas(String path) throws IOException
    {
        String pathRuta = path;
        File Archivo = new File(pathRuta);

        FileReader Lectura = null;

        try 
        {
            Lectura = new FileReader(Archivo);
        } 
        catch (FileNotFoundException ex) 
        {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }

        BufferedReader Leer = new BufferedReader(Lectura);
        String Linea = Leer.readLine();
        String [] Auxiliar;
        Lista Nuevo;

        while(Linea != null)
        {
            Auxiliar = Linea.split("\\|");

            if(Auxiliar[5].equals("1"))
            {
                Nuevo = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
                ListaListas.add(Nuevo);
            }

            Linea = Leer.readLine();
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdjuntar;
    private javax.swing.JButton jBtnDescartar;
    private javax.swing.JButton jBtnEnviar;
    private javax.swing.JComboBox<String> jCBDestinatario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMensaje;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblMenu;
    // End of variables declaration//GEN-END:variables
}
