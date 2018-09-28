/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author josue && pablo
 */
public class Principal extends javax.swing.JFrame {

    Procesos procesos = new Procesos();
    String usuario;
    
    public Principal(String usuario) throws IOException {
        initComponents();
        this.usuario = usuario;
        
        LlenarDatos();
    }

    private Principal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void LlenarDatos() throws FileNotFoundException, IOException
    {
            String Ubicacion = "";
            Ubicacion = procesos.EncontrarUsuario(usuario);
            
            if (Ubicacion.equals("Usuarios"))
            {
                String pathRuta = "C:\\MEIA\\Usuarios.txt";
                File Archivo = new File(pathRuta);
                FileReader Leer = new FileReader(Archivo);
                BufferedReader leerArchivo = new BufferedReader(Leer);
                String Linea = leerArchivo.readLine();
                
                while(Linea != null)
                {
                    if(Linea.contains(usuario))
                    {
                        String[] SegmentosInfo = Linea.split("|");
                        
                        String pathImagen = SegmentosInfo[8];
                        
                        
                        //lblFoto
                    }

                    Linea = leerArchivo.readLine();
                } 
                leerArchivo.close();
                Leer.close();
            }
            else if (Ubicacion.equals("Bitacora_Usuarios"))
            {

            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblFoto = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        lblBienvenido = new javax.swing.JLabel();
        lblNiveldeAcceso = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnBackup = new javax.swing.JButton();
        btnMenudeAdministracion = new javax.swing.JButton();
        lblMenu = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 130, 120));

        lblRol.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRol.setText("Rol:");
        getContentPane().add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 90, 200, 30));

        lblBienvenido.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBienvenido.setText("Bienvenido:");
        getContentPane().add(lblBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 200, 30));

        lblNiveldeAcceso.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblNiveldeAcceso.setForeground(new java.awt.Color(255, 255, 255));
        lblNiveldeAcceso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNiveldeAcceso.setText("Nivel de Acceso:");
        getContentPane().add(lblNiveldeAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 200, 30));

        lblUsuario.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 200, 30));

        btnBackup.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBackup.setText("Respaldo de Informacion");
        getContentPane().add(btnBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 330, 220, 50));

        btnMenudeAdministracion.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMenudeAdministracion.setText("Menu de Administracion");
        getContentPane().add(btnMenudeAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 240, 220, 50));

        lblMenu.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Elija una Opcion del Menu");
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("Log Out");
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 420, 100, 30));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 610, 10));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 610, 10));

        lblFondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\josue\\Desktop\\Logos Correo MA\\Diseño sin título.jpg")); // NOI18N
        lblFondo.setText("jLabel1");
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBackup;
    private javax.swing.JButton btnMenudeAdministracion;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel lblBienvenido;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblMenu;
    private javax.swing.JLabel lblNiveldeAcceso;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel lblUsuario;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    // End of variables declaration//GEN-END:variables
}
