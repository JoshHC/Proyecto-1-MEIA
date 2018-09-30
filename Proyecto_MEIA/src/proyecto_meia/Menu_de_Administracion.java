/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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

    /**
     * Creates new form Menu_de_Administracion
     */
    public Menu_de_Administracion() {
        initComponents();
        
        try {                                                           
            
            String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
            
            File Archivo = new File(pathRuta);
            FileReader Lectura = null;
            try {
                Lectura = new FileReader(Archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader Leer = new BufferedReader(Lectura);
            List<Usuario> ListaUsuarios = new ArrayList<Usuario>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String Linea = "";
            Linea = Leer.readLine();
            String [] Auxiliar;
            Usuario Nuevo;
           
            
            while(Linea != null)
            {
                Auxiliar = Linea.split("|");
                byte [] Aux = Auxiliar[4].getBytes();
                byte [] Aux2 = Auxiliar[9].getBytes();
                Date Fecha = formatter.parse(Auxiliar[5]);
                Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Aux[0],Fecha,Auxiliar[6],Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2[0]);
                ListaUsuarios.add(Nuevo);
                
                Linea = Leer.readLine();
            }
            
            Leer.close();
            Lectura.close();
            
          
        for(Usuario item : ListaUsuarios)
        {
                 ComboBoxSeleccionarUsuario.addItem(item.Usuario);
        }
            
        String Seleccion = (String)ComboBoxSeleccionarUsuario.getSelectedItem();
       
         for(Usuario item : ListaUsuarios)
        {
            if(item.Usuario == Seleccion)
            {
                ImageIcon icon = new ImageIcon(item.PathFotografia);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                txtPassword.setText(item.Password);
                txtCorreo.setText(item.CorreoAlterno);
                txtTelefono.setText(Integer.toString(item.Telefono));
                txtFecha.setText(item.Fecha.toString());
                lblFoto.setText(null);
                lblFoto.setIcon( icono );
                if(item.status == 1)
                {
                     btnEstado.setSelected(true);
                     btnEstado.setBackground(Color.GREEN);
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
        } catch (ParseException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
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

        jFileChooser1 = new javax.swing.JFileChooser();
        panel3 = new java.awt.Panel();
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
        txtFecha = new javax.swing.JTextField();
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

        btnGuardar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });
        getContentPane().add(btnGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 370, 160, 30));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setForeground(new java.awt.Color(255, 255, 255));
        lblPassword.setText("Contraseña:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, -1, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCorreo.setForeground(new java.awt.Color(255, 255, 255));
        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 230, -1, -1));

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechaNac.setForeground(new java.awt.Color(255, 255, 255));
        lblFechaNac.setText("Fecha de Nacimiento:");
        getContentPane().add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, -1, -1));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
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

        ComboBoxSeleccionarUsuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ComboBoxSeleccionarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxSeleccionarUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxSeleccionarUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 130, 160, -1));
        getContentPane().add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 160, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 280, 160, -1));
        getContentPane().add(txtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 330, 160, -1));

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

        lblFondo.setIcon(new javax.swing.ImageIcon("C:\\Users\\josue\\Desktop\\Logos Correo MA\\Diseño sin título.jpg")); // NOI18N
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
        Principal Menu = new Principal();
        Menu.show();
        this.dispose();
    }//GEN-LAST:event_btnMenuPrincipalActionPerformed

    File fichero;
    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed

        int resultado;
        
        CargarFoto ventana = new CargarFoto();

        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");

        ventana.jfchCargarFoto.setFileFilter(filtro);

        resultado= ventana.jfchCargarFoto.showOpenDialog(null);


        if (JFileChooser.APPROVE_OPTION == resultado){


        fichero = ventana.jfchCargarFoto.getSelectedFile();

        try{

               ImageIcon icon = new ImageIcon(fichero.toString());

               Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));

               lblFoto.setText(null);
               
               lblFoto.setIcon( icono );


        }catch(Exception ex){

           
        JOptionPane.showMessageDialog(null, "Error abriendo la imagen "+ ex);
                 
        }
        
        } 
    }//GEN-LAST:event_btnCargarFotoActionPerformed

    private void ComboBoxSeleccionarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxSeleccionarUsuarioActionPerformed
        
        try {                                                           
            
            String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
            
            File Archivo = new File(pathRuta);
            FileReader Lectura = null;
            try {
                Lectura = new FileReader(Archivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
            }
            BufferedReader Leer = new BufferedReader(Lectura);
            List<Usuario> ListaUsuarios = new ArrayList<Usuario>();
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            String Linea = "";
            Linea = Leer.readLine();
            String [] Auxiliar;
            Usuario Nuevo;
           
            
            while(Linea != null)
            {
                Auxiliar = Linea.split("|");
                byte [] Aux = Auxiliar[4].getBytes();
                byte [] Aux2 = Auxiliar[9].getBytes();
                Date Fecha = formatter.parse(Auxiliar[5]);
                Nuevo = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Aux[0],Fecha,Auxiliar[6],Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2[0]);
                ListaUsuarios.add(Nuevo);
                
                Linea = Leer.readLine();
            }
            
            Leer.close();
            Lectura.close();
            
          
        for(Usuario item : ListaUsuarios)
        {
                 ComboBoxSeleccionarUsuario.addItem(item.Usuario);
        }
            
        String Seleccion = (String)ComboBoxSeleccionarUsuario.getSelectedItem();
       
         for(Usuario item : ListaUsuarios)
        {
            if(item.Usuario == Seleccion)
            {
                ImageIcon icon = new ImageIcon(item.PathFotografia);
                Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                txtPassword.setText(item.Password);
                txtCorreo.setText(item.CorreoAlterno);
                txtTelefono.setText(Integer.toString(item.Telefono));
                txtFecha.setText(item.Fecha.toString());
                lblFoto.setText(null);
                lblFoto.setIcon( icono );
                if(item.status == 1)
                {
                     btnEstado.setSelected(true);
                     btnEstado.setBackground(Color.GREEN);
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
        } catch (ParseException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
   
    }//GEN-LAST:event_ComboBoxSeleccionarUsuarioActionPerformed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed
       Nuevo_Usuario Usuario = new Nuevo_Usuario();
       Usuario.show();
       this.dispose();
    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        String path = "C:\\MEIA\\Usuarios.txt";
        File Archivo = new File(path);
        //FileReader Leer = new FileReader(Archivo);
        //BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = "";
        int NoRegistros = 0;
        int Activos = 0;
        int Inactivos = 0;        
        
        //Se compara en la posicion 9 porque en esa posicion se encontrara el status a la hora de hacer el split y separarlo.
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
            
            if(Auxiliar[9].equals("1"))
            {
                Activos++;
            }
            else if (Auxiliar[9].equals("0") == true)
            {
                Inactivos++;
            }
            //Linea = leerArchivo.readLine();
            NoRegistros++;
        }
        
        //Descriptor_Usuario Nuevo = new Descriptor_Usuario("Usuario",Fecha.toString(),UsuarioActivo,Fecha.toString(),UsuarioActivo,Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos));
        
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
        try {
            String Resultado = Busqueda.EncontrarUsuario(Usuario);
            
            if(Resultado == "Usuarios")
            {
               lblResultado.setText("El usuario SI existe");
            }else if (Resultado == "Bitacora_Usuarios")
            {
               lblResultado.setText("El usuario SI existe"); 
            }else if (Resultado == "No Existe")
            {
               lblResultado.setText("El usuario NO existe"); 
            }
        } catch (IOException ex) {
            Logger.getLogger(Menu_de_Administracion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

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
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtPassword;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
