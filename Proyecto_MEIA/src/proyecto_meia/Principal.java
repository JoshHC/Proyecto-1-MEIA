package proyecto_meia;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import static proyecto_meia.Modificacion_De_Listas.ContadorListaIndizada;
import static proyecto_meia.Modificacion_De_Listas.Usuario;


public class Principal extends javax.swing.JFrame {

    Procesos procesos = new Procesos();
    static String Usuario;
    static String Rol;
    static String Comienzo;
    
    public Principal(String Usuario, String Rol) throws IOException {
        initComponents();
        
        try {
            BDD.getInstancia().conexion();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EnviarMensajeRed.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EnviarMensajeRed.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(Rol.equals(""))
            this.Rol = Rol;
        
        this.Usuario = procesos.EliminarCaracteres(Usuario);
        
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
        lblMenu = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnMenudeAdministracion = new javax.swing.JButton();
        panel1 = new java.awt.Panel();
        panel2 = new java.awt.Panel();
        btnMenudeAdministracion1 = new javax.swing.JButton();
        btnEnviar = new javax.swing.JButton();
        btnBandejaEntrada = new javax.swing.JButton();
        btnEnviarUsuario = new javax.swing.JButton();
        btnBandejaEnviados = new javax.swing.JButton();
        btnEnviarListaDifusion = new javax.swing.JButton();
        btnEnviarRed = new javax.swing.JButton();
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
        getContentPane().add(btnBackup, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 230, 50));

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
        getContentPane().add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 420, 100, 30));

        btnMenudeAdministracion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnMenudeAdministracion.setText("Administracion de Usuarios");
        btnMenudeAdministracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenudeAdministracionActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenudeAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 230, 50));

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
        getContentPane().add(btnMenudeAdministracion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 290, 230, 50));

        btnEnviar.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnEnviar.setText("Enviar Correo");
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, 230, 50));

        btnBandejaEntrada.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnBandejaEntrada.setText("Bandeja de Entrada");
        btnBandejaEntrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBandejaEntradaActionPerformed(evt);
            }
        });
        getContentPane().add(btnBandejaEntrada, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 290, 230, 50));

        btnEnviarUsuario.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnEnviarUsuario.setText("Enviar a un Usuario");
        btnEnviarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 230, 240, 50));

        btnBandejaEnviados.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnBandejaEnviados.setText("Bandeja de Enviados");
        btnBandejaEnviados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBandejaEnviadosActionPerformed(evt);
            }
        });
        getContentPane().add(btnBandejaEnviados, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 230, 50));

        btnEnviarListaDifusion.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnEnviarListaDifusion.setText("Enviar a Lista de Difusion");
        btnEnviarListaDifusion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarListaDifusionActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarListaDifusion, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 240, 50));

        btnEnviarRed.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        btnEnviarRed.setLabel("Enviar a un Usuario (RED)");
        btnEnviarRed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarRedActionPerformed(evt);
            }
        });
        getContentPane().add(btnEnviarRed, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 290, 240, 50));

        lblFondo.setFont(new java.awt.Font("Calibri Light", 0, 20)); // NOI18N
        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        lblFondo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblFondoMouseClicked(evt);
            }
        });
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void LlenarDatos() throws FileNotFoundException, IOException
    {
        btnEnviarListaDifusion.hide();
        btnEnviarUsuario.hide();
        btnEnviarRed.hide();
        
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
                    String[] SegmentosInfo = Linea.split("\\|");

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
                        lblRol.setText("Rol → Administrador");
                        Rol = "Administrador";
                    }
                    else
                    {
                        lblNiveldeAcceso.setText("Nivel de acceso ➙ Estandar");
                        lblRol.setText("Rol → Usuario");
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
                    String[] SegmentosInfo = Linea.split("\\|");

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
                        lblRol.setText("Rol → Administrador");
                        Rol = "Administrador";
                    }
                    else
                    {
                        lblNiveldeAcceso.setText("Nivel de acceso ➙ Estandar");
                        lblRol.setText("Rol → Usuario");
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
            procesos.Reorganizacion();
            
            Actualizador.DescriptorBitácora();
            Actualizador.DescriptorUsuario();
            
            ReasignarIndices();
            DescriptorListaIndizada();

        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
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

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        btnEnviarListaDifusion.show();
        btnEnviarUsuario.show();
        btnEnviarRed.show();
        
        btnBackup.hide();
        btnEnviar.hide();
        btnBandejaEntrada.hide();
        btnBandejaEnviados.hide();
        btnMenudeAdministracion.hide();
        btnMenudeAdministracion1.hide();
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnBandejaEntradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBandejaEntradaActionPerformed
        
        try 
        {
            BandejaES BandejaEntrada = new BandejaES("Entrada", Usuario, Rol);
            BandejaEntrada.setLocationRelativeTo(null);
            BandejaEntrada.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBandejaEntradaActionPerformed

    private void btnBandejaEnviadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBandejaEnviadosActionPerformed
        
        try 
        {
            BandejaES BandejaSalida = new BandejaES("Enviados", Usuario, Rol);
            BandejaSalida.setLocationRelativeTo(null);
            BandejaSalida.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnBandejaEnviadosActionPerformed

    private void btnEnviarListaDifusionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarListaDifusionActionPerformed
        
        EnviarMensaje enviarMensaje;
        
        try 
        {
            
            enviarMensaje = new EnviarMensaje("Lista", Usuario, Rol);
            enviarMensaje.setLocationRelativeTo(null);
            enviarMensaje.show();
            this.dispose();
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnEnviarListaDifusionActionPerformed

    private void btnEnviarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarUsuarioActionPerformed
        
        EnviarMensaje enviarMensaje;
        
        try 
        {
            enviarMensaje = new EnviarMensaje("Usuario", this.Usuario, this.Rol);
            enviarMensaje.setLocationRelativeTo(null);
            enviarMensaje.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_btnEnviarUsuarioActionPerformed

    private void lblFondoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblFondoMouseClicked
        btnEnviarListaDifusion.hide();
        btnEnviarUsuario.hide();
        btnEnviarRed.hide();
        
        btnBackup.show();
        btnEnviar.show();
        btnBandejaEntrada.show();
        btnBandejaEnviados.show();
        btnMenudeAdministracion.show();
        btnMenudeAdministracion1.show();
    }//GEN-LAST:event_lblFondoMouseClicked

    private void btnEnviarRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarRedActionPerformed
        EnviarMensajeRed enviarMensaje;
        
        enviarMensaje = new EnviarMensajeRed(this.Usuario, this.Rol);
        enviarMensaje.setLocationRelativeTo(null);
        enviarMensaje.show();
        this.dispose();
        
    }//GEN-LAST:event_btnEnviarRedActionPerformed

    private void ReasignarIndices() throws FileNotFoundException, IOException
    {
        String path = "C:\\MEIA\\ListaUsuarioIndizada.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        List<ListaIndizada> Listas = new ArrayList<ListaIndizada>();
        int contador = 1;
        
        while(Linea != null)
        {
           String [] Auxiliar = Linea.split("\\|");
           String Posicion = "1"+"."+(contador);
           ListaIndizada Nueva = new ListaIndizada(String.valueOf(contador),Posicion,Auxiliar[2],Auxiliar[3],Auxiliar[4],"0",Auxiliar[6]);
           Listas.add(Nueva);
           Linea = leerArchivo.readLine();
           contador++;
        }
        Leer.close();
        leerArchivo.close();
        
        Collections.sort(Listas, new Comparator<ListaIndizada>(){
                @Override
                public int compare(ListaIndizada p1, ListaIndizada p2) {
		int resultado = p1.Nombre_Lista.compareTo(p2.Nombre_Lista);
                if ( resultado != 0 ) { return resultado;}
                
                resultado = p1.Usuario.compareTo(p2.Usuario);
                if ( resultado != 0 ) { return resultado;}
                
                resultado = p1.Usuario_Asociado.compareTo(p2.Usuario_Asociado);
                if ( resultado != 0 ) { return resultado;}
                
                return resultado;
                }
                });
                
                if(Listas.size() != 0)
                {
                Comienzo = Listas.get(0).NoRegistro;
                
                for(int i = 0; i<Listas.size();i++)
                {
                    if(i+1 <= Listas.size())
                    {
                        //if(Listas.get(i).Siguiente.equals("0") == true)
                        if(i != 0)
                        Listas.get(i-1).Siguiente = Listas.get(i).NoRegistro;
                    }
                    else
                    {
                        Listas.get(i).Siguiente = "0";
                    }
                }
                
                
                 Leer = new FileReader(Archivo);
                 leerArchivo = new BufferedReader(Leer);
                 Linea = leerArchivo.readLine();
                 
                 while(Linea != null)
                {
                    String [] Auxiliar = Linea.split("\\|");
                    ListaIndizada Nueva = new ListaIndizada(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5],Auxiliar[6]);
                    if(Nueva.Status.equals("0"))
                    Listas.add(Nueva);
                    Linea = leerArchivo.readLine();
                }
                Leer.close();
                leerArchivo.close();
                
                Collections.sort(Listas, new Comparator<ListaIndizada>(){
                @Override
                public int compare(ListaIndizada p1, ListaIndizada p2) {
                return p1.NoRegistro.compareTo(p2.NoRegistro);
                }
                });
                
                FileOutputStream writer = new FileOutputStream(Archivo);
                writer.write(("").getBytes());
                writer.close();     
               
                FileWriter Escritor = new FileWriter(Archivo);
                BufferedWriter bs = new BufferedWriter(Escritor);
                
                for(int i= 0;i<Listas.size();i++)
                {
                    bs.write(Listas.get(i).NoRegistro+"|"+Listas.get(i).Posicion+"|"+Listas.get(i).Nombre_Lista+"|"+Listas.get(i).Usuario+"|"+Listas.get(i).Usuario_Asociado+"|"+Listas.get(i).Siguiente+"|"+Listas.get(i).Status);
                    bs.write(System.lineSeparator());
                }
                bs.close();
                Escritor.close();      
                }
    }
    /**
     * @param args the command line arguments
     */
    
    
     //método donde se crea el Descriptor de Lista y se Actualiza
    public void DescriptorListaIndizada() throws FileNotFoundException, IOException
    {
        Procesos Acceso = new Procesos();
        Date Fecha = new Date();
        String path = "C:\\MEIA\\ListaUsuarioIndizada.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        int NoRegistros = 0;
        int Activos = 0;
        int Inactivos = 0;
        
        //Se compara en la posicion 6 porque en esa posicion se encontrara el status a la hora de hacer el split y separarlo.
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
            
            if(Auxiliar[6].equals("1"))
            {
                Activos++;
            }
            else if (Auxiliar[6].equals("0") == true)
            {
                Inactivos++;
            }
            Linea = leerArchivo.readLine();
            NoRegistros++;
        }
        
        Leer.close();
        leerArchivo.close();
        
        
        Descriptor_ListaUsuarioIndizada Nuevo = new Descriptor_ListaUsuarioIndizada("Lista Indizada",Fecha.toString(),Usuario,Fecha.toString(),Usuario,Comienzo,Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos));
        Acceso.DescriptorListaIndizada(Nuevo);
    }
    
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
    private javax.swing.JButton btnBandejaEntrada;
    private javax.swing.JButton btnBandejaEnviados;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnEnviarListaDifusion;
    private javax.swing.JButton btnEnviarRed;
    private javax.swing.JButton btnEnviarUsuario;
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
