package proyecto_meia;

import java.awt.Color;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import static proyecto_meia.Nuevo_Usuario.fichero;

/**
 *
 * @author josue
 */
public class Menu_de_Administracion extends javax.swing.JFrame {

    static String Usuario;
    private String Rol;
    
    /**
     * Creates new form Menu_de_Administracion
     */
    public Menu_de_Administracion(String usuario, String Rol) throws IOException, ParseException {
        initComponents();
        Procesos Acceso = new Procesos();
        
        this.Rol = Rol;
        this.Usuario = usuario;
      
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
        List<Usuario> ListaUsuarios = new ArrayList<Usuario>();
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        String Linea = "";
        Linea = Leer.readLine();
        String [] Auxiliar;
        Usuario Nuevo;
        boolean Admin = false;

        while(Linea != null)
        {
            Auxiliar = Linea.split("\\|");
            byte Aux;
            byte Aux2;

            if(Auxiliar[4].equals("1"))
                Aux = 1;
            else
                Aux = 0;

            if(Auxiliar[9].equals("1"))
                Aux2 = 1;
            else
                Aux2 = 0;

            Date Fecha = new Date(Auxiliar[5]);
            Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Acceso.EliminarCaracteres(Auxiliar[3]),Aux,Fecha,Acceso.EliminarCaracteres(Auxiliar[6]),Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
            ListaUsuarios.add(Nuevo);

            Linea = Leer.readLine();
        }

        Leer.close();
        Lectura.close();

        String pathRutaU = "C:\\MEIA\\Usuarios.txt";
        File ArchivoU = new File(pathRutaU);
        
        if(ArchivoU.exists())
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
            Nuevo = null;
            Admin = false;

             while(LineaU != null)
            {
                Auxiliar = LineaU.split("\\|");
                byte Aux;
                byte Aux2;

                if(Auxiliar[4].equals("1"))
                    Aux = 1;
                else
                    Aux = 0;

                if(Auxiliar[9].equals("1"))
                    Aux2 = 1;
                else
                    Aux2 = 0;

                Date Fecha = new Date(Auxiliar[5]);
                Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Acceso.EliminarCaracteres(Auxiliar[3]),Aux,Fecha,Acceso.EliminarCaracteres(Auxiliar[6]),Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
                ListaUsuarios.add(Nuevo);

                LineaU = LeerU.readLine();
            }
             
            LeerU.close();
            LecturaU.close();
            
        }
        usuario = Acceso.RellenarCaracteres(usuario, 0);
        
        for(Usuario i: ListaUsuarios)
        {
            if(Acceso.RellenarCaracteres(usuario, 0).equals(i.Usuario))
            {
                if(i.rol == 1)
                    Admin = true;
                else
                    Admin = false;
            }
        }
            
            
        if (Admin == true)
        {
            for(Usuario item : ListaUsuarios)
                ComboBoxSeleccionarUsuario.addItem(item.Usuario);
        }
        else
        {
            for(Usuario item : ListaUsuarios)
            {
                if(item.Usuario.equals(usuario))
                {
                    ComboBoxSeleccionarUsuario.addItem(item.Usuario);
                }
            }      
        }
    }

    private Menu_de_Administracion() {
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

        jFileChooser1 = new javax.swing.JFileChooser();
        panel3 = new java.awt.Panel();
        btnAgregaraLista = new javax.swing.JButton();
        txtFecha = new javax.swing.JFormattedTextField();
        btnGuardar = new javax.swing.JButton();
        lblPassword = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        btnMenuPrincipal = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();
        btnCargarFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        btnEstado = new javax.swing.JToggleButton();
        txtPassword = new javax.swing.JTextField();
        ComboBoxSeleccionarUsuario = new javax.swing.JComboBox<>();
        txtCorreo = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        PanelEstado = new javax.swing.JPanel();
        btnBuscar = new javax.swing.JButton();
        txtBusqueda = new javax.swing.JTextField();
        lblBusqueda = new javax.swing.JLabel();
        lblTitulo = new javax.swing.JLabel();
        lblResultado = new javax.swing.JLabel();
        lblAdministracion = new javax.swing.JLabel();
        panel1 = new java.awt.Panel();
        lblFondo = new javax.swing.JLabel();
        panel2 = new java.awt.Panel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout panel3Layout = new javax.swing.GroupLayout(panel3);
        panel3.setLayout(panel3Layout);
        panel3Layout.setHorizontalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        panel3Layout.setVerticalGroup(
            panel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 830, 10));

        btnAgregaraLista.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        btnAgregaraLista.setText("Agregar a una Lista");
        btnAgregaraLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregaraListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnAgregaraLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 480, 170, 30));

        try {
            txtFecha.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 160, -1));

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, 30));

        lblPassword.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Contraseña:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNac.setText("Fecha de Nacimiento:");
        getContentPane().add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTelefono.setForeground(new java.awt.Color(255, 255, 255));
        lblTelefono.setText("Telefono:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        btnMenuPrincipal.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnMenuPrincipal.setText("Menu Principal");
        btnMenuPrincipal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuPrincipalActionPerformed(evt);
            }
        });
        getContentPane().add(btnMenuPrincipal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 480, 140, 30));

        btnNuevoUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnNuevoUsuario.setText("Ingresar Nuevo Usuario");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(btnNuevoUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, 200, 30));

        btnCargarFoto.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 330, 190, -1));

        lblFoto.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblFoto.setForeground(new java.awt.Color(255, 255, 255));
        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 130, 190, 170));

        btnEstado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEstado.setText("Activo");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });
        getContentPane().add(btnEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 190, 30));
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 160, -1));

        ComboBoxSeleccionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSeleccionarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxSeleccionarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 160, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 160, -1));

        PanelEstado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 102), 3));

        btnBuscar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        lblBusqueda.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblBusqueda.setText("Ingrese el nombre de usuario:");

        lblTitulo.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitulo.setText("Busqueda de Usuarios");

        lblResultado.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblResultado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultado.setText("Resultado");

        javax.swing.GroupLayout PanelEstadoLayout = new javax.swing.GroupLayout(PanelEstado);
        PanelEstado.setLayout(PanelEstadoLayout);
        PanelEstadoLayout.setHorizontalGroup(
            PanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblTitulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelEstadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblBusqueda, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEstadoLayout.createSequentialGroup()
                        .addGroup(PanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBusqueda, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblResultado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        PanelEstadoLayout.setVerticalGroup(
            PanelEstadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelEstadoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(lblBusqueda)
                .addGap(18, 18, 18)
                .addComponent(txtBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(lblResultado)
                .addGap(23, 23, 23))
        );

        getContentPane().add(PanelEstado, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 130, 250, 270));

        lblAdministracion.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        lblAdministracion.setForeground(new java.awt.Color(255, 255, 255));
        lblAdministracion.setText("Administracion");
        getContentPane().add(lblAdministracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        javax.swing.GroupLayout panel1Layout = new javax.swing.GroupLayout(panel1);
        panel1.setLayout(panel1Layout);
        panel1Layout.setHorizontalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        panel1Layout.setVerticalGroup(
            panel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 830, 10));

        lblFondo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        lblFondo.setText("jLabel1");
        getContentPane().add(lblFondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 830, 520));

        javax.swing.GroupLayout panel2Layout = new javax.swing.GroupLayout(panel2);
        panel2.setLayout(panel2Layout);
        panel2Layout.setHorizontalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 830, Short.MAX_VALUE)
        );
        panel2Layout.setVerticalGroup(
            panel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(panel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 100, 830, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnMenuPrincipalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuPrincipalActionPerformed
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
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    File fichero;
    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed

        int resultado;
        
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.jfchCargarFoto.setFileFilter(filtro);
        resultado= ventana.jfchCargarFoto.showOpenDialog(null);
        
        if (JFileChooser.APPROVE_OPTION == resultado)
        {
            fichero = ventana.jfchCargarFoto.getSelectedFile();

            try
            {
                ImageIcon icon = new ImageIcon(fichero.toString());
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                lblFoto.setText(null);
                lblFoto.setIcon( icono );
            }
            catch(Exception ex)
            {
                JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);  
            }
        }
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void ComboBoxSeleccionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSeleccionarUsuarioActionPerformed
        Procesos Acceso = new Procesos();
        
        try {                                                           
            
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
            List<Usuario> ListaUsuarios = new ArrayList<Usuario>();
            DateFormat formatter = DateFormat.getDateInstance(DateFormat.MEDIUM);
            String Linea = "";
            Linea = Leer.readLine();
            String [] Auxiliar;
            Usuario Nuevo;
           
            while(Linea != null)
            {
                Auxiliar = Linea.split("\\|");
                byte Aux;
                byte Aux2;
                
                if(Auxiliar[4].equals("1"))
                    Aux = 1;
                else
                    Aux = 0;
            
                if(Auxiliar[9].equals("1"))
                    Aux2 = 1;
                else
                    Aux2 = 0;
                
                Date Fecha = new Date(Auxiliar[5]);
                Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Acceso.EliminarCaracteres(Auxiliar[3]),Aux,Fecha,Acceso.EliminarCaracteres(Auxiliar[6]),Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
                ListaUsuarios.add(Nuevo);
                
                Linea = Leer.readLine();
            }
            
            Leer.close();
            Lectura.close();
            
            String pathRutaU = "C:\\MEIA\\Usuarios.txt";
            File ArchivoU = new File(pathRutaU);
            
            if(ArchivoU.exists())
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
                Nuevo = null;

                while(LineaU != null)
                {
                    Auxiliar = LineaU.split("\\|");
                    byte Aux;
                    byte Aux2;

                    if(Auxiliar[4].equals("1"))
                        Aux = 1;
                    else
                        Aux = 0;

                    if(Auxiliar[9].equals("1"))
                        Aux2 = 1;
                    else
                        Aux2 = 0;

                    Date Fecha = new Date(Auxiliar[5]);
                    Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Acceso.EliminarCaracteres(Auxiliar[3]),Aux,Fecha,Acceso.EliminarCaracteres(Auxiliar[6]),Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
                    ListaUsuarios.add(Nuevo);

                    LineaU = LeerU.readLine();
                }
                
                LeerU.close();
                LecturaU.close();
                
            }
            
            String Seleccion = (String)ComboBoxSeleccionarUsuario.getSelectedItem();
       
            for(Usuario item : ListaUsuarios)
            {
                if(item.Usuario.equals(Seleccion))
                {
                    ImageIcon icon = new ImageIcon(item.PathFotografia);
                    fichero = new File (item.PathFotografia);
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                    txtPassword.setText(item.Password);
                    txtCorreo.setText(item.CorreoAlterno);
                    txtTelefono.setText(Integer.toString(item.Telefono));
                    String FechaFormateada = formatter.format(item.Fecha);
                    txtFecha.setText(FechaFormateada);
                    lblFoto.setText(null);
                    lblFoto.setIcon( icono );
                    if(item.status == 1)
                    {
                         btnEstado.setSelected(true);
                         btnEstado.setBackground(Color.BLUE);
                         btnEstado.setText("Activo");
                    }
                    else
                    {
                        btnEstado.setSelected(false);
                        btnEstado.setBackground(Color.RED);
                        btnEstado.setText("Inactivo");
                    }
                    
            }
                 
        }
        
        } catch (IOException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_ComboBoxSeleccionarUsuarioActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
       Nuevo_Usuario Usuario = new Nuevo_Usuario();
       Usuario.setLocationRelativeTo(null);
       Usuario.show();
       this.dispose();
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        Procesos Acceso = new Procesos();
        Nuevo_Usuario Actualizador = new Nuevo_Usuario();
        
        try {
            String pathU = "C:\\MEIA\\Usuarios.txt";
            String pathB = "C:\\MEIA\\Bitacora_Usuarios.txt";
            Usuario Modificado = new Usuario();
            String [] UsuarioAuxiliar;
            String User = "";
            boolean bitacora = false;
            
            File ArchivoU = new File(pathU);
            FileReader LeerU = new FileReader(ArchivoU);
            BufferedReader leerArchivo = new BufferedReader(LeerU);
            String Linea = leerArchivo.readLine();
            
            while(Linea != null)
            {
                UsuarioAuxiliar = Linea.split("\\|");
                if(UsuarioAuxiliar[0].equals(ComboBoxSeleccionarUsuario.getSelectedItem().toString()))                
                {
                    bitacora = false;
                    User = Linea;
                }
                Linea = leerArchivo.readLine();
            }
            
            LeerU.close();
            leerArchivo.close();
            
            File ArchivoB = new File(pathB);
            FileReader LeerB = new FileReader(ArchivoB);
            BufferedReader leerArchivoB = new BufferedReader(LeerB);
            Linea = leerArchivoB.readLine();
            
            while(Linea != null)
            {
                UsuarioAuxiliar = Linea.split("\\|");
                if(UsuarioAuxiliar[0].equals(ComboBoxSeleccionarUsuario.getSelectedItem().toString()))                
                {
                    bitacora = true;
                    User = Linea;
                }
               Linea = leerArchivoB.readLine();
            }
            
            UsuarioAuxiliar = User.split("\\|");
            byte Aux;
            byte Aux2;
            
            if(UsuarioAuxiliar[4].equals("1"))
                  Aux = 1;
            else
                Aux = 0;
            
            if(btnEstado.isSelected())
                Aux2 = 1;
            else
                Aux2 = 0;
                
            String Password = Acceso.RellenarCaracteres(txtPassword.getText(), 2);
            String CorreoAlterno = Acceso.RellenarCaracteres(txtCorreo.getText(), 2);
            int Telefono = Integer.parseInt(txtTelefono.getText());
            String Path = Acceso.RellenarCaracteres(fichero.getAbsolutePath(), 3);
            Date Fecha = new Date(UsuarioAuxiliar[5]);
            Modificado = new Usuario(UsuarioAuxiliar[0],UsuarioAuxiliar[1],UsuarioAuxiliar[2],Password,Aux,Fecha,CorreoAlterno,Telefono,Path,Aux2);
            
            
            if(bitacora == false)
            {
                FileReader lectorU = new FileReader(ArchivoU);
                BufferedReader buferU = new BufferedReader(lectorU);
                String LineaAdelantada = buferU.readLine();
                
                RandomAccessFile Modificar = new RandomAccessFile(ArchivoU,"rw");
                String Registro = "";
                String Sustitucion = "";
                while(LineaAdelantada != null)
                {
                    UsuarioAuxiliar = LineaAdelantada.split("\\|");
                    if(UsuarioAuxiliar[0].equals(Modificado.Usuario))                
                    {
                       Sustitucion = Modificado.Usuario+"|"+Modificado.Nombre+"|"+Modificado.Apellido+"|"+Modificado.Password+"|"+Modificado.rol+"|"+Modificado.Fecha+"|"+Modificado.CorreoAlterno+"|"+Modificado.Telefono+"|"+Modificado.PathFotografia+"|"+Modificado.status;
                       Modificar.writeBytes(Sustitucion);
                    }
                    
                    LineaAdelantada = buferU.readLine();
                    Registro = Modificar.readLine();
                }
                
                
            }else if (bitacora == true)
            {
                FileReader lectorB = new FileReader(ArchivoB);
                BufferedReader buferB = new BufferedReader(lectorB);
                String LineaAdelantada = buferB.readLine();
                
                RandomAccessFile Modificar = new RandomAccessFile(ArchivoB,"rw");
                String Registro = "";
                String Sustitucion = "";
                while(LineaAdelantada != null)
                {
                    UsuarioAuxiliar = LineaAdelantada.split("\\|");
                    if(UsuarioAuxiliar[0].equals(Modificado.Usuario))                
                    {
                       Sustitucion = Modificado.Usuario+"|"+Modificado.Nombre+"|"+Modificado.Apellido+"|"+Modificado.Password+"|"+Modificado.rol+"|"+Modificado.Fecha+"|"+Modificado.CorreoAlterno+"|"+Modificado.Telefono+"|"+Modificado.PathFotografia+"|"+Modificado.status;
                       Modificar.writeBytes(Sustitucion);
                    }
                    
                    LineaAdelantada = buferB.readLine();
                    Registro = Modificar.readLine();
                }
                
            }

           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            String pathU = "C:\\MEIA\\Usuarios.txt";
            String pathB = "C:\\MEIA\\Bitacora_Usuarios.txt";
            Usuario Modificado = new Usuario();
            String [] UsuarioAuxiliar;
            String User = "";
            boolean bitacora = false;
            
            File ArchivoU = new File(pathU);
            FileReader LeerU = new FileReader(ArchivoU);
            BufferedReader leerArchivo = new BufferedReader(LeerU);
            String Linea = leerArchivo.readLine();
            
            while(Linea != null)
            {
                UsuarioAuxiliar = Linea.split("\\|");
                if(UsuarioAuxiliar[0].equals(ComboBoxSeleccionarUsuario.getSelectedItem().toString()))                
                {
                    bitacora = false;
                    User = Linea;
                }
                Linea = leerArchivo.readLine();
            }
            
            LeerU.close();
            leerArchivo.close();
            
            File ArchivoB = new File(pathB);
            FileReader LeerB = new FileReader(ArchivoB);
            BufferedReader leerArchivoB = new BufferedReader(LeerB);
            Linea = leerArchivoB.readLine();
            
            while(Linea != null)
            {
                UsuarioAuxiliar = Linea.split("\\|");
                if(UsuarioAuxiliar[0].equals(ComboBoxSeleccionarUsuario.getSelectedItem().toString()))                
                {
                    bitacora = true;
                    User = Linea;
                }
               Linea = leerArchivoB.readLine();
            }
            
            UsuarioAuxiliar = User.split("\\|");
            byte Aux;
            byte Aux2;
            
            if(UsuarioAuxiliar[4].equals("1"))
                  Aux = 1;
            else
                Aux = 0;
            
            if(btnEstado.isSelected())
                Aux2 = 1;
            else
                Aux2 = 0;
                
            String Password = Acceso.RellenarCaracteres(txtPassword.getText(), 2);
            String CorreoAlterno = Acceso.RellenarCaracteres(txtCorreo.getText(), 2);
            int Telefono = Integer.parseInt(txtTelefono.getText());
            String Path = Acceso.RellenarCaracteres(fichero.getAbsolutePath(), 3);
            Date Fecha = new Date(UsuarioAuxiliar[5]);
            Modificado = new Usuario(UsuarioAuxiliar[0],UsuarioAuxiliar[1],UsuarioAuxiliar[2],Password,Aux,Fecha,CorreoAlterno,Telefono,Path,Aux2);
            
            
            if(bitacora == false)
            {
                FileReader lectorU = new FileReader(ArchivoU);
                BufferedReader buferU = new BufferedReader(lectorU);
                String LineaAdelantada = buferU.readLine();
                
                RandomAccessFile Modificar = new RandomAccessFile(ArchivoU,"rw");
                String Registro = "";
                String Sustitucion = "";
                while(LineaAdelantada != null)
                {
                    UsuarioAuxiliar = LineaAdelantada.split("\\|");
                    if(UsuarioAuxiliar[0].equals(Modificado.Usuario))                
                    {
                       Sustitucion = Modificado.Usuario+"|"+Modificado.Nombre+"|"+Modificado.Apellido+"|"+Modificado.Password+"|"+Modificado.rol+"|"+Modificado.Fecha+"|"+Modificado.CorreoAlterno+"|"+Modificado.Telefono+"|"+Modificado.PathFotografia+"|"+Modificado.status;
                       Modificar.writeBytes(Sustitucion);
                    }
                    
                    LineaAdelantada = buferU.readLine();
                    Registro = Modificar.readLine();
                }
                
                Actualizador.DescriptorUsuario();
                
            }else if (bitacora == true)
            {
                FileReader lectorB = new FileReader(ArchivoB);
                BufferedReader buferB = new BufferedReader(lectorB);
                String LineaAdelantada = buferB.readLine();
                
                RandomAccessFile Modificar = new RandomAccessFile(ArchivoB,"rw");
                String Registro = "";
                String Sustitucion = "";
                while(LineaAdelantada != null)
                {
                    UsuarioAuxiliar = LineaAdelantada.split("\\|");
                    if(UsuarioAuxiliar[0].equals(Modificado.Usuario))                
                    {
                       Sustitucion = Modificado.Usuario+"|"+Modificado.Nombre+"|"+Modificado.Apellido+"|"+Modificado.Password+"|"+Modificado.rol+"|"+Modificado.Fecha+"|"+Modificado.CorreoAlterno+"|"+Modificado.Telefono+"|"+Modificado.PathFotografia+"|"+Modificado.status;
                       Modificar.writeBytes(Sustitucion);
                    }
                    
                    LineaAdelantada = buferB.readLine();
                    Registro = Modificar.readLine();
                }
                
                Actualizador.DescriptorBitácora();
                
            }
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        if (btnEstado.isSelected() == true)
        {
             btnEstado.setBackground(Color.GREEN);
             btnEstado.setText("Activo");
        }
        else
        {
            btnEstado.setBackground(Color.RED);
             btnEstado.setText("Inactivo");
        }
                    
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        Procesos Busqueda = new Procesos();
        String Usuario = txtBusqueda.getText();
        
        if(txtBusqueda.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ingrese un Nombre de Usuario Valido para Buscar");
        }
        else
        {
        try {
            String Resultado = Busqueda.BuscarUsuario(Usuario);
            
            if(Resultado.equals("Usuarios"))
               lblResultado.setText("El usuario SI existe");
            else if (Resultado.equals("Bitacora_Usuarios"))
               lblResultado.setText("El usuario SI existe"); 
            else if (Resultado.equals("No Existe"))
               lblResultado.setText("El usuario NO existe"); 
            
        } catch (IOException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnAgregaraListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregaraListaActionPerformed
        Listas listas = null;
        
        try 
        {
            listas = new Listas(Usuario, Rol);
            listas.setLocationRelativeTo(null);
            listas.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnAgregaraListaActionPerformed

    private String ValidarContraseña(String Password) throws FileNotFoundException, IOException
    {
        String error = "";
        String texto = ObtenerContenidoArchivo();
        String[] Condiciones = texto.split(" ");
        
        // Si la cadena tiene mas de n caracteres puede seguir
        if (Password.length() < Integer.parseInt(Condiciones[0]))
            error += "1,"+Condiciones[0];
        
        
        // Si la condicion de mayusuclas está activa
        else if (Boolean.valueOf(Condiciones[1]))
            if (!ContieneMayusculas(Password))
                error += "2";
        
        return error;
    }
    
    // Devuelve el punteo adicional de la contraseña
    private int obtenerNivelSeguridad (String Password) throws IOException
    {
        int Punteo = 0;
        
        String[] Condiciones = ObtenerContenidoArchivo().split(" ");
        
        if (Boolean.valueOf(Condiciones[2]))
        {
            if (Password.contains("1") || Password.contains("2") || Password.contains("3")
             || Password.contains("4") || Password.contains("5") || Password.contains("6")
             || Password.contains("7") || Password.contains("8") || Password.contains("9")
             || Password.contains("0"))
                Punteo++;
        }
        else
        {
            Punteo++;
        }
        
        
        if (ContieneCaracteresEspeciales(Condiciones[3].toCharArray(), Password))
            Punteo++;
        
        if (Boolean.valueOf(Condiciones[4]))
        {
            if (Password.contains(" "))
                Punteo++;
        }
        else
        {
            Punteo++;
        }

        return Punteo;
    }
    
    // Verifica si la clave tiene caracteres Especiales
    private boolean ContieneCaracteresEspeciales (char[] caracteres, String Password)
    {
        boolean contiene = false;
        
        for (char caracter : caracteres)
        {
            if (Password.contains(Character.toString(caracter)))
                contiene = true;
        }
        
        return contiene;
    }
    
    private boolean ContieneMayusculas(String Texto)
    {
        boolean Mayusculas = false;
        char [] Caracteres = Texto.toCharArray();
        
        for (char i: Caracteres) {
            if (Character.isUpperCase(i))
                Mayusculas = true;
        }
        
        return Mayusculas;
    }
    
    // Retorna la linea de las condiciones o la linea de los punteos del archivo de contraseña en MEIA
    private String ObtenerContenidoArchivo() throws FileNotFoundException, IOException
    {
        String path = "C:\\MEIA\\ValidacionContraseña.txt";
        File Archivo = new File(path);
        
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        
        String Linea = leerArchivo.readLine();

        Leer.close();
        leerArchivo.close();

        return Linea;

    }
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
            java.util.logging.Logger.getLogger(Menu_de_Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu_de_Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu_de_Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu_de_Administracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu_de_Administracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxSeleccionarUsuario;
    private javax.swing.JPanel PanelEstado;
    private javax.swing.JButton btnAgregaraLista;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JToggleButton btnEstado;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnMenuPrincipal;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel lblAdministracion;
    private javax.swing.JLabel lblBusqueda;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFondo;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblResultado;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblTitulo;
    private java.awt.Panel panel1;
    private java.awt.Panel panel2;
    private java.awt.Panel panel3;
    private javax.swing.JTextField txtBusqueda;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JFormattedTextField txtFecha;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
