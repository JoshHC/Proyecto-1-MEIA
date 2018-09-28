/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.print.attribute.Size2DSyntax.MM;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author josue
 */
public class Nuevo_Usuario extends javax.swing.JFrame {

    /**
     * Creates new form Nuevo_Usuario
     */
    public Nuevo_Usuario() {
        initComponents();
        txtmostrador.setEditable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtPassword = new javax.swing.JPasswordField();
        txtUserName = new javax.swing.JTextField();
        txtmostrador = new javax.swing.JTextField();
        lblUserName = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        btnCargarFoto = new javax.swing.JButton();
        lblFoto = new javax.swing.JLabel();
        lblNombre = new javax.swing.JLabel();
        lblApellido = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        lblFechaNac = new javax.swing.JLabel();
        lblTelefono = new javax.swing.JLabel();
        btnCrear = new javax.swing.JButton();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtFechaNac = new javax.swing.JTextField();
        txtCorreoAlterno = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 153, 255));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 240, 260, -1));
        getContentPane().add(txtUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 260, -1));
        getContentPane().add(txtmostrador, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 350, 200, 120));

        lblUserName.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblUserName.setText("Nombre de Usuario:");
        getContentPane().add(lblUserName, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, -1, -1));

        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 100, -1));

        btnCargarFoto.setText("Cargar Foto");
        btnCargarFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarFotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCargarFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 200, -1));

        lblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblFoto.setText("Foto");
        lblFoto.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)), null));
        getContentPane().add(lblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 200, 170));

        lblNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 140, 60, 20));

        lblApellido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblApellido.setText("Apellido:");
        getContentPane().add(lblApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 190, 60, 20));

        lblPassword.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblPassword.setText("Contraseña:");
        getContentPane().add(lblPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 80, -1));

        lblCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblCorreo.setText("Correo:");
        getContentPane().add(lblCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, -1, -1));

        lblFechaNac.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblFechaNac.setText("Fecha de Nacimiento:");
        getContentPane().add(lblFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 390, 140, 20));

        lblTelefono.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblTelefono.setText("Telefono:");
        getContentPane().add(lblTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 290, 60, 20));

        btnCrear.setForeground(new java.awt.Color(51, 51, 51));
        btnCrear.setText("Crear Usuario");
        btnCrear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrear, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 440, 260, -1));
        getContentPane().add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 260, -1));
        getContentPane().add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 260, -1));
        getContentPane().add(txtFechaNac, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 390, 260, -1));
        getContentPane().add(txtCorreoAlterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 340, 260, -1));
        getContentPane().add(txtTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 260, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 48)); // NOI18N
        jLabel2.setText("Crea un Nuevo Usuario");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 0, 560, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static File fichero;
    
    private void btnCargarFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarFotoActionPerformed
        
        int resultado;
        CargarFoto ventana = new CargarFoto();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("JPG y PNG","jpg","png");
        ventana.jfchCargarFoto.setFileFilter(filtro);
        resultado= ventana.jfchCargarFoto.showOpenDialog(null);

        if (JFileChooser.APPROVE_OPTION == resultado){
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

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Login Principal = new Login();
        Principal.setLocationRelativeTo(null);
        Principal.show();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnCrearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearActionPerformed
        
        String Resultado;
        String Password = txtPassword.getText();
        
        try {
            String ValidacionContraseña = ValidarContraseña(Password);
            
            if (ValidacionContraseña != "")
            {
                if(ValidacionContraseña.charAt(0) == '1')
                {
                    String[] condicional = ValidacionContraseña.split(",");
                    JOptionPane.showMessageDialog(null, "El nivel de seguridad de su contraseña es Bajo.\n"
                            + " La contraseña debe contener al menos " + condicional[1] + " caracteres.\n"
                            + " Ingrese otra contraseña");
                    txtPassword.setText("");
                }
                else if (ValidacionContraseña.equals("2"))
                {
                    JOptionPane.showMessageDialog(null, "El nivel de seguridad de su contraseña es Bajo.\n"
                            + " La contraseña debe contener al menos una Mayuscula\n"
                            + " Ingrese otra contraseña");
                    txtPassword.setText("");
                }
            }
            else
            {
                int puntuacion = obtenerNivelSeguridad(Password);
                
                byte rol = 1;
                byte Status = 1;
                
                try
                {
                    int numero = Integer.parseInt(txtTelefono.getText());
                    String cadena = txtTelefono.getText().toString();
                    
                    if (cadena.length() != 8)
                    {
                        JOptionPane.showMessageDialog(null, "El numero de telefono ingresado no tiene la longitud adecuada.\n"
                            + "Ingresa una numero telefonico valido por favor");
                        txtTelefono.setText("");
                        return;
                    }
                }
                catch (NumberFormatException ex)
                {
                    JOptionPane.showMessageDialog(null, "El numero de telefono ingresado no es valido.\n"
                            + "Ingresa una numero telefonico valido por favor");
                    txtTelefono.setText("");
                    return;
                }
                
                
                Date Fecha;
                try
                {
                    String fecha = txtFechaNac.getText();
                    SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
                    
                    Fecha = formatofecha.parse(fecha);
                }
                catch (ParseException ex)
                {
                    JOptionPane.showMessageDialog(null, "La fecha ingresada es invalida.\n"
                            + "Ingresa una fecha valida por favor");
                    txtFechaNac.setText("");
                    return;
                }
                
                
                Usuario NewUser = new Usuario();
                String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
                File Archivo = new File(pathRuta);
                if (Archivo.length() == 0)
                {
                    NewUser = new Usuario(txtUserName.getText(),txtNombre.getText(),txtApellido.getText(),Password,rol,Fecha,txtCorreoAlterno.getText(),Integer.parseInt(txtTelefono.getText()),fichero.getAbsolutePath(),Status);
                }
                else
                {
                    rol = 0;
                    NewUser = new Usuario(txtUserName.getText(),txtNombre.getText(),txtApellido.getText(),Password,rol,Fecha,txtCorreoAlterno.getText(),Integer.parseInt(txtTelefono.getText()),fichero.getAbsolutePath(),Status);
                    
                }
                //Usuario NewUser = new Usuario(txtUserName.getText(),txtNombre.getText(),Password,);
                switch(puntuacion) 
                {
                    case 0:
                        Resultado = "Apenas Aceptable";
                        txtmostrador.setText("Nivel de Seguridad de la Contraseña: "+Resultado);
                        IngresarUsuarioNuevo(NewUser);
                        break;
                        
                    case 1:
                        Resultado = "Intermedio";
                        txtmostrador.setText("Nivel de Seguridad de la Contraseña: "+Resultado);
                        IngresarUsuarioNuevo(NewUser);
                        break;
                        
                    case 2:
                        Resultado = "Bueno";
                        txtmostrador.setText("Nivel de Seguridad de la Contraseña: "+Resultado);
                        IngresarUsuarioNuevo(NewUser);
                        break;
                        
                    case 3:
                        Resultado = "Fuerte";
                        txtmostrador.setText("Nivel de Seguridad de la Contraseña: "+Resultado);
                        IngresarUsuarioNuevo(NewUser);
                        break;
                }
            }
            
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Nuevo_Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnCrearActionPerformed

    // Retorna "" Si la contraseña es valida
    // Retorna "1" Si la contraseña tiene menos de n caracteres
    // Retorna "2" Si la contraseña no tiene mayusculas
    private String ValidarContraseña(String Password) throws FileNotFoundException, IOException
    {
        String error = "";
        String texto = ObtenerContenidoArchivo("Obligatorias");
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
        
        String[] Condiciones = ObtenerContenidoArchivo("Obligatorias").split(" ");
        
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
    
    
    // Retorna la linea de las condiciones o la linea de los punteos del archivo de contraseña en MEIA
    private String ObtenerContenidoArchivo(String obligatorias) throws FileNotFoundException, IOException
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
    
    public void IngresarUsuarioNuevo(Usuario Nuevo) throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
        
        File Archivo = new File(pathRuta);
        RandomAccessFile File = new RandomAccessFile(pathRuta, "rw");
        String Linea = File.readLine();
        int ContadorLineas = 0;    
        
        if(Archivo.length() == 0)
        {
            File.writeBytes(Nuevo.Usuario+"|"+Nuevo.Nombre+"|"+Nuevo.Apellido+"|"+Nuevo.Password+"|"+Nuevo.rol+"|"+Nuevo.Fecha+"|"+Nuevo.CorreoAlterno+"|"+Nuevo.Telefono+"|"+Nuevo.PathFotografia+"|"+Nuevo.status);
        }
        else
        {
            while(Linea != null)
            {
                String [] Auxiliar = Linea.split("|");
                ContadorLineas++;
               if (Auxiliar[0].compareTo(Nuevo.Nombre) == 1)
                {
                    break;
                }
         
               Linea = File.readLine();
            } 
        File.close();
              
        RandomAccessFile FileSustitucion = new RandomAccessFile(pathRuta, "rw");
        String LineaSustitucion = FileSustitucion.readLine();
        for (int i = 0; i < ContadorLineas; i++) 
        {
            LineaSustitucion = FileSustitucion.readLine();
        }
        String UsuarioSustituto = Nuevo.Usuario+"|"+Nuevo.Nombre+"|"+Nuevo.Apellido+"|"+Nuevo.Password+"|"+Nuevo.rol+"|"+Nuevo.Fecha+"|"+Nuevo.CorreoAlterno+"|"+Nuevo.Telefono+"|"+Nuevo.PathFotografia+"|"+Nuevo.status;
        FileSustitucion.skipBytes(LineaSustitucion.getBytes().length);
        FileSustitucion.writeBytes(UsuarioSustituto);    
        }
        
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
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nuevo_Usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nuevo_Usuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCargarFoto;
    private javax.swing.JButton btnCrear;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblFechaNac;
    private javax.swing.JLabel lblFoto;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblTelefono;
    private javax.swing.JLabel lblUserName;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreoAlterno;
    private javax.swing.JTextField txtFechaNac;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtTelefono;
    private javax.swing.JTextField txtUserName;
    private javax.swing.JTextField txtmostrador;
    // End of variables declaration//GEN-END:variables
}
