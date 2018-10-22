package proyecto_meia;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyecto_meia.Nuevo_Usuario.fichero;
import org.apache.commons.io.FileUtils;

public class Principal extends javax.swing.JFrame {

    Procesos procesos = new Procesos();
    static String Usuario;
    static String Rol;
    
    public Principal(String usuario, String Rol) throws IOException {
        initComponents();
        
        if(Rol.equals(""))
            this.Rol = Rol;
        
        this.Usuario = procesos.EliminarCaracteres(usuario);
        
        LlenarDatos();
        if(this.Rol.equals("Administrador"))
            btnBackup.show();
        else
            btnBackup.hide();
        
    }

    Principal() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        btnMenudeAdministracion1 = new javax.swing.JButton();
        lblFondo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 120, 110));

        lblRol.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblRol.setForeground(new java.awt.Color(255, 255, 255));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblRol.setText("Rol:");
        getContentPane().add(lblRol, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 90, 210, 30));

        lblBienvenido.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblBienvenido.setForeground(new java.awt.Color(255, 255, 255));
        lblBienvenido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblBienvenido.setText("Bienvenido");
        getContentPane().add(lblBienvenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 350, 30));

        lblNiveldeAcceso.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblNiveldeAcceso.setForeground(new java.awt.Color(255, 255, 255));
        lblNiveldeAcceso.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblNiveldeAcceso.setText("Nivel de Acceso:");
        getContentPane().add(lblNiveldeAcceso, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 270, 30));

        lblUsuario.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblUsuario.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuario.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUsuario.setText("Usuario:");
        getContentPane().add(lblUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 210, 30));

        btnBackup.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnBackup.setText("Respaldo de Informacion");
        btnBackup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackupActionPerformed(evt);
            }
        });
        getContentPane().add(btnBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 350, 230, 50));

        btnMenudeAdministracion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnMenudeAdministracion.setText("Administracion de Usuarios");
        btnMenudeAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenudeAdministracionActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenudeAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 230, 50));

        lblMenu.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lblMenu.setForeground(new java.awt.Color(255, 255, 255));
        lblMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMenu.setText("Menu");
        getContentPane().add(lblMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        btnSalir.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnSalir.setText("Log Out");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 400, 100, 30));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, 10));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 660, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 660, 10));

        btnMenudeAdministracion1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnMenudeAdministracion1.setText("Administracion de Listas");
        btnMenudeAdministracion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenudeAdministracion1ActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenudeAdministracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 290, 230, 50));

        lblFondo.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 660, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LlenarDatos() throws FileNotFoundException, IOException
    {
            String Ubicacion = "";
            Ubicacion = procesos.EncontrarUsuario(Usuario);
            
            if (Ubicacion.equals("Usuarios"))
            {
                String pathRuta = "C:\\MEIA\\Usuarios.txt";
                File Archivo = new File(pathRuta);
                FileReader Leer = new FileReader(Archivo);
                BufferedReader leerArchivo = new BufferedReader(Leer);
                String Linea = leerArchivo.readLine();
                
                while(Linea != null)
                {
                    if(Linea.contains(Usuario))
                    {                    
                        String[] SegmentosInfo = procesos.ImplementacionSplit(Linea);
                        
                        String pathImagen = SegmentosInfo[8];
                        
                        ImageIcon icon = new ImageIcon(pathImagen);
                        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                        lblFoto.setText(null);
                        lblFoto.setIcon( icono );
                        
                        lblBienvenido.setText("Bienvenido " + SegmentosInfo[1]);
                        lblUsuario.setText("Usuario: " + SegmentosInfo[0]);
                        
                        if(SegmentosInfo[4].equals("1"))
                        {
                            lblNiveldeAcceso.setText("Nivel de acceso ➙ Maestro");
                            lblRol.setText("Rol ➙ Administrador");
                            Rol = "Administrador";
                        }
                        else
                        {
                            lblNiveldeAcceso.setText("Nivel de acceso ➙ Estandar");
                            lblRol.setText("Rol ➙ Usuario");
                            Rol = "Usuario";
                        }
                    }

                    Linea = leerArchivo.readLine();
                } 
                leerArchivo.close();
                Leer.close();
            }
            else if (Ubicacion.equals("Bitacora_Usuarios"))
            {
                String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
                File Archivo = new File(pathRuta);
                FileReader Leer = new FileReader(Archivo);
                BufferedReader leerArchivo = new BufferedReader(Leer);
                String Linea = leerArchivo.readLine();
                
                while(Linea != null)
                {
                    if(Linea.contains(Usuario))
                    {
                        String[] SegmentosInfo = procesos.ImplementacionSplit(Linea);
                        
                        String pathImagen = SegmentosInfo[8];
                        
                        ImageIcon icon = new ImageIcon(pathImagen);
                        Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                        lblFoto.setText(null);
                        lblFoto.setIcon( icono );
                        
                        lblBienvenido.setText("Bienvenido " + SegmentosInfo[1]);
                        lblUsuario.setText("Usuario: " + SegmentosInfo[0]);
                        
                        if(SegmentosInfo[4].equals("1"))
                        {
                            lblNiveldeAcceso.setText("Nivel de acceso ➙ Maestro");
                            lblRol.setText("Rol ➙ Administrador");
                            Rol = "Administrador";
                        }
                        else
                        {
                            lblNiveldeAcceso.setText("Nivel de acceso ➙ Estandar");
                            lblRol.setText("Rol ➙ Usuario");
                            Rol = "Usuario";
                        }
                    }

                    Linea = leerArchivo.readLine();
                } 
                leerArchivo.close();
                Leer.close();
            }
    }
    
    private void btnBackupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackupActionPerformed
        JFileChooser dialogo = new JFileChooser();
        File Backup;
        File Direccion = new File("C:\\MEIA");
        dialogo.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int valor = dialogo.showOpenDialog(this);
        if (valor == JFileChooser.APPROVE_OPTION) {
            Backup = dialogo.getSelectedFile();
            File Backupfile = new File(Backup.getPath()+"\\BackupMEIA");
            try {
                FileUtils.copyDirectory(Direccion, Backupfile);
                RespaldarFotos(Backupfile);
                String pathRuta = "C:\\MEIA\\Bitacora_Backup.txt";
                File Archivo = new File(pathRuta);
                FileWriter Escribir = new FileWriter(Archivo,true);
                BufferedWriter bw = new BufferedWriter(Escribir);
                Date Fecha = new Date();

                bw.write("Ruta Absoluta|"+Backupfile.getPath());
                bw.write("Usuario|"+Usuario);
                bw.write("Fecha de Transaccion|"+Fecha.toString());
                bw.close();
                Escribir.close();

                FileReader Leer = new FileReader(Archivo);
                BufferedReader bs = new BufferedReader(Leer);
                int contador = 0;
                String Linea = bs.readLine();

                while(Linea != null)
                {   contador++;
                    Linea = bs.readLine();
                }

                contador = contador/3;

                Procesos NuevoProceso = new Procesos();
                Descriptor_Backup NuevoBackup = new Descriptor_Backup("Bitacora_Backup",Fecha.toString(),Usuario,Fecha.toString(),Usuario,String.valueOf(contador));
                NuevoProceso.DescriptorBakcup(NuevoBackup);
            } catch (IOException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_btnBackupActionPerformed

    private void RespaldarFotos(File BackupFile) throws IOException
    {
        String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
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
        List<File> ListaUsuarios = new ArrayList<File>();
        String Linea = "";
        Linea = Leer.readLine();
       
        String [] Auxiliar;

        while(Linea != null)
        {
            Auxiliar = Linea.split("\\|");
            File AuxiliarPath = new File(Auxiliar[8].toString());
            ListaUsuarios.add(AuxiliarPath);

            Linea = Leer.readLine();
        }

        Leer.close();
        Lectura.close();

        String pathRutaU = "C:\\MEIA\\Usuarios.txt";
        File ArchivoU = new File(pathRutaU);
        
        if(ArchivoU.exists())
        {
            try 
            {
                FileReader LecturaU = null;
                
                try
                {
                    LecturaU = new FileReader(ArchivoU);
                }
                catch (FileNotFoundException ex)
                {
                    Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                BufferedReader LeerU = new BufferedReader(LecturaU);
                String LineaU = "";
                LineaU = LeerU.readLine();
                String [] AuxiliarU;
                
                while(LineaU != null)
                {
                    AuxiliarU = LineaU.split("\\|");
                    File AuxiliarPath = new File(AuxiliarU[8].toString());
                    ListaUsuarios.add(AuxiliarPath);
                    
                    LineaU = LeerU.readLine();
                }
                
                LeerU.close();
                LecturaU.close();

                for(int i= 0; i<=ListaUsuarios.size(); i++)
                {
                    FileUtils.copyFileToDirectory(ListaUsuarios.get(i), BackupFile);
                }
                
            }
            catch (IOException ex) 
            {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }            
    }
    private void btnMenudeAdministracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenudeAdministracionActionPerformed
        Menu_de_Administracion Usuario;
        try 
        {
            Usuario = new Menu_de_Administracion(this.Usuario, Rol);
            Usuario.setLocationRelativeTo(null);
            Usuario.show();
            this.dispose();
        } 
        catch (IOException | ParseException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }//GEN-LAST:event_btnMenudeAdministracionActionPerformed

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        Nuevo_Usuario Actualizador = new Nuevo_Usuario();

        try 
        {
            procesos.Reorganizar();
            
            Actualizador.DescriptorBitácora();
            Actualizador.DescriptorUsuario();

        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (JOptionPane.showConfirmDialog(null, "Quieres Salir de Mail", "Confirmar Salida", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION)
        System.exit(0);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnMenudeAdministracion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenudeAdministracion1ActionPerformed
        Listas listas;
        
        try 
        {
            listas = new Listas(Usuario, Rol);
            listas.setLocationRelativeTo(null);
            listas.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnMenudeAdministracion1ActionPerformed

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
    private javax.swing.JButton btnMenudeAdministracion1;
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
