package proyecto_meia;

import java.awt.Menu;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static proyecto_meia.Modificacion_De_Listas.NombreLista;

/**
 *
 * @author Admin
 */
public class EnviarMensaje extends javax.swing.JFrame {

    Procesos procesos = new Procesos();
    
    private String Destinatario;
    private String Usuario;
    private String Rol;
    
    private int InicioArbol;
    String[] Arbol;
    
    List<Usuario> ListaUsuarios;
    List<Lista> ListaListas;
    List<String> IntegrantesLista;
    
    // CONSTRUCTOR
    public EnviarMensaje(String destinatario, String usuario, String rol) throws IOException {
        initComponents();
        
        lblEncabezado.setText("Enviar Mensaje");
        
        this.Destinatario = destinatario;
        this.Usuario = usuario;
        this.Rol = rol;
                
        ListaUsuarios = new ArrayList<Usuario>();
        ListaListas = new ArrayList<Lista>();
        IntegrantesLista = new ArrayList<String>();
        
        RellenarCampos();
    }
    
    // CONSTRUCTOR
    public EnviarMensaje(String Encabezado, String usuario, String rol, String Para, String Asutno, String Fecha) throws IOException {
        initComponents();
        
        lblEncabezado.setText(Encabezado);
        
        if(Encabezado.equals("Correo Recibido"))
        {
            jLblPara.setText("De");
        }
        
        jCBDestinatario.enable(false);
        jTFAsunto.enable(false);
        jTAMensaje.enable(false);
        
        this.Usuario = usuario;
        this.Rol = rol;
                
        jCBDestinatario.removeItemAt(0);
        jCBDestinatario.addItem(Para);
        
        jTFAsunto.setText(Asutno);
        jTAMensaje.setText(ObtenerMensaje(this.Usuario, Para, Fecha));
        
        jBtnDescartar.hide();
        jBtnEnviar.setText("Regresar");
    }
    
    // CONSTRUCTOR
    private EnviarMensaje() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        lblEncabezado = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTFAsunto = new javax.swing.JTextField();
        jBtnAdjuntar = new javax.swing.JButton();
        jCBDestinatario = new javax.swing.JComboBox<>();
        jLblPara = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTAMensaje = new javax.swing.JTextArea();
        jBtnEnviar = new javax.swing.JButton();
        jBtnDescartar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Enviar Mensaje");
        setAutoRequestFocus(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEncabezado.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("Enviar Mensaje");
        getContentPane().add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Asunto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

        jLabel2.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mensaje");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jTFAsunto.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jTFAsunto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTFAsuntoActionPerformed(evt);
            }
        });
        getContentPane().add(jTFAsunto, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, 570, -1));

        jBtnAdjuntar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnAdjuntar.setText("Adjuntar Archivo");
        jBtnAdjuntar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAdjuntarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnAdjuntar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 80, -1, -1));

        jCBDestinatario.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jCBDestinatario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-  -  -  -  -  -  -  -  -  -  -  -  -  -  -  -" }));
        jCBDestinatario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCBDestinatarioActionPerformed(evt);
            }
        });
        getContentPane().add(jCBDestinatario, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 410, -1));

        jLblPara.setFont(new java.awt.Font("Calibri Light", 0, 18)); // NOI18N
        jLblPara.setForeground(new java.awt.Color(255, 255, 255));
        jLblPara.setText("Para");
        getContentPane().add(jLblPara, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jTAMensaje.setColumns(20);
        jTAMensaje.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jTAMensaje.setLineWrap(true);
        jTAMensaje.setRows(5);
        jTAMensaje.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTAMensaje);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 570, 170));

        jBtnEnviar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnEnviar.setText("Enviar");
        jBtnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnEnviarActionPerformed(evt);
            }
        });
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
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 700, 410));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBtnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnEnviarActionPerformed
        if (lblEncabezado.getText().equals("Correo Recibido"))
        {
            try
            {
                BandejaES BandejaEntrada = new BandejaES("Entrada", this.Usuario, this.Rol);
                BandejaEntrada.setLocationRelativeTo(null);
                BandejaEntrada.show();
                this.dispose();
                return;
            }
            catch (IOException ex)
            {
                Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(lblEncabezado.getText().equals("Correo Enviado"))
        {
            try
            {
                BandejaES BandejaEntrada = new BandejaES("Salida", this.Usuario, this.Rol);
                BandejaEntrada.setLocationRelativeTo(null);
                BandejaEntrada.show();
                this.dispose();
                return;
            }
            catch (IOException ex)
            {
                Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        String Para = jCBDestinatario.getSelectedItem().toString();
        String Asunto = jTFAsunto.getText();
        String Mensaje = jTAMensaje.getText();

        if (Mensaje.length() > 200)
        {
            JOptionPane.showMessageDialog(this,"El mensaje que intentas enviar es muy largo","      Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Asunto.length() > 20)
        {
            JOptionPane.showMessageDialog(this,"El asunto del mensaje que intentas enviar es muy largo","      Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if(Destinatario.equals("Usuario"))
        {
            try
            {
                EnviarPersona(Para, Asunto, Mensaje);

                JOptionPane.showMessageDialog(this,"El correo ha sido enviado", "Envío Exitoso", JOptionPane.INFORMATION_MESSAGE);

                Principal Menu = new Principal(Usuario, Rol);
                Menu.setLocationRelativeTo(null);
                Menu.show();
                this.dispose();

            }
            catch (IOException ex)
            {
                Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try
            {
                EnviarLista(Para, Asunto, Mensaje);

                JOptionPane.showMessageDialog(this,"Los correos han sido enviados", "Envío Exitoso", JOptionPane.INFORMATION_MESSAGE);

                Principal Menu = new Principal(Usuario, Rol);
                Menu.setLocationRelativeTo(null);
                Menu.show();
                this.dispose();
            }
            catch (IOException ex)
            {
                Logger.getLogger(EnviarMensaje.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jBtnEnviarActionPerformed

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

    private void jCBDestinatarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCBDestinatarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCBDestinatarioActionPerformed

    private void jBtnAdjuntarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAdjuntarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jBtnAdjuntarActionPerformed

    private void jTFAsuntoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTFAsuntoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTFAsuntoActionPerformed

    private void EnviarPersona(String Para, String Asunto, String Mensaje)
    {
        try
        {
            Date Fecha = new Date();
            String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
            File Archivo = new File(pathRuta);
            FileWriter Escritor = new FileWriter(Archivo,true);
            BufferedWriter bw = new BufferedWriter(Escritor);

            Usuario = procesos.RellenarCaracteres(Usuario, 0);
            
            String[] DestinoVerdadero = Para.split("-");
            Para = DestinoVerdadero[0];
            
            Para = procesos.RellenarCaracteres(Para, 0);
            Asunto = procesos.RellenarCaracteres(Asunto, 0);
            Mensaje = procesos.RellenarCaracteres(Mensaje, 3);
            
            Correo Nuevo;

            Nuevo = new Correo("  ", "  ", Usuario, Para, Fecha.toString(), Asunto, Mensaje, 
                    procesos.RellenarCaracteres("", 3), "1");
            bw.write(Nuevo.Izq+"|"+Nuevo.Der+"|"+Nuevo.UsuarioEmisor+"|"+Nuevo.UsuarioReceptor+"|"+
                    Nuevo.FechaTransaccion+"|"+Nuevo.Asunto+"|"+Nuevo.Mensaje+"|"+Nuevo.Adjunto+"|"+Nuevo.Estatus);
            bw.write(System.lineSeparator());

            bw.close();
            Escritor.close();
            
            
            DescriptorArbolMensajes(false);
            
            ObtenerIncio();
            ObtenerArbol();

            try
            {
                ActualizarIndicesArbol(Nuevo);
            }
            catch(Exception e)
            {
                
            }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Modificacion_De_Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void EnviarLista(String Para, String Asunto, String Mensaje) throws IOException
    {
        ObtenerIntegrantesLista("C:\\MEIA\\ListaUsuarioIndizada.txt", Para);
        
        IntegrantesLista.forEach((Integrante) -> {
            EnviarPersona(Integrante, Asunto, Mensaje);
        });

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

            if(Auxiliar[5].equals("1") && procesos.EliminarCaracteres(Auxiliar[1]).equals(this.Usuario))
            {
                Nuevo = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
                ListaListas.add(Nuevo);
            }

            Linea = Leer.readLine();
        }
    }
    
    private void ObtenerIntegrantesLista(String path, String Lista) throws FileNotFoundException, IOException
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

        while(Linea != null)
        {
            Auxiliar = Linea.split("\\|");

            if(procesos.EliminarCaracteres(Auxiliar[2]).equals(Lista) && 
                    procesos.EliminarCaracteres(Auxiliar[3]).equals(this.Usuario))
            {
                IntegrantesLista.add(procesos.EliminarCaracteres(Auxiliar[4]));
            }

            Linea = Leer.readLine();
        }
    }
    
    //método donde se crea el Descriptor del Arbol y se Actualiza
    // TRUE SI SE MODIFICA EL VALOR DE INICIO
    // FALSE SI NO
    public void DescriptorArbolMensajes(boolean Desicion) throws FileNotFoundException, IOException
    {
        Date Fecha = new Date();
        String path = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        int NoRegistros = 0;
        int Activos = 0;
        int Inactivos = 0;        
        
        //Se compara en la posicion 8 porque en esa posicion se encontrara el status
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
            
            if(Auxiliar[8].equals("1"))
                Activos++;
            else if (Auxiliar[8].equals("0") == true)
                Inactivos++;

            Linea = leerArchivo.readLine();
            NoRegistros++;
        }
        
        Leer.close();
        leerArchivo.close();
        
        
        Descriptor_ArbolMensajes Nuevo = new Descriptor_ArbolMensajes("ArbolMensajes",Fecha.toString(),Usuario,Fecha.toString(),Usuario,"01",Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos));
        
        if (!Desicion)
            procesos.DescriptorArbolMensajes(Nuevo, false, 0);
        else
            // Alguna otra cosa, saber que
            return;
    }
    
    private void ActualizarIndicesArbol(Correo Nuevo) throws IOException
    {
        String Siguiente = String.valueOf(InicioArbol);
        boolean Procesando = true;
        
        while(Procesando)
        {
            String[] Row = Arbol[Integer.valueOf(Siguiente) -1].split("\\|");
        
            Correo Temp = new Correo(Row[0], Row[1], Row[2], Row[3], Row[4], Row[5], Row[6], Row[7], Row[8]);
            int ResultadoComparar = Ordenar(Nuevo, Temp);
            
            if (ResultadoComparar < 0)
            {
                if(Row[0].equals("  "))
                {
                    Row[0] = String.valueOf(Arbol.length);
                    if (Row[0].length() == 1)
                        Row[0] = "0" + Row[0];

                    String Actualizacion = Row[0]+"|"+Row[1]+"|"+Row[2]+"|"+Row[3]+"|"+Row[4]+"|"+Row[5]+"|"+Row[6]+"|"+Row[7]+"|"+Row[8];
                    Arbol[Integer.valueOf(Siguiente) -1] = Actualizacion;
                    
                    Procesando = false;
                }
                else
                {
                    Siguiente = Row[0];
                }
            }
            else if (ResultadoComparar > 0)
            {
                if(Row[1].equals("  "))
                {
                    Row[1] = String.valueOf(Arbol.length);
                    if (Row[1].length() == 1)
                        Row[1] = "0" + Row[1];

                    String Actualizacion = Row[0]+"|"+Row[1]+"|"+Row[2]+"|"+Row[3]+"|"+Row[4]+"|"+Row[5]+"|"+Row[6]+"|"+Row[7]+"|"+Row[8];
                    Arbol[Integer.valueOf(Siguiente) -1] = Actualizacion;
                    
                    Procesando = false;
                }
                else
                {
                    Siguiente = Row[1];
                }
            }
            else
            {
                //Se comparó a si mismo
                // Quiere decir que se acaba de ingresar el primer mensaje
                Procesando = false;
            }
        }
        
        ModificarArbol();
    }
   
    private int Ordenar(Correo p1, Correo p2)
    {
        int resultado = p1.UsuarioEmisor.compareTo(p2.UsuarioEmisor);
        if ( resultado != 0 ) { return resultado;}

        resultado = p1.UsuarioReceptor.compareTo(p2.UsuarioReceptor);
        if ( resultado != 0 ) { return resultado;}

        resultado = p1.FechaTransaccion.compareTo(p2.FechaTransaccion);
        if ( resultado != 0 ) { return resultado;}

        return resultado;
    }
    
    
    // Obtiene el contenido del Arbol
    private void ObtenerArbol() throws FileNotFoundException, IOException
    {
        List<String> ListaArbol = new ArrayList<String>();
        
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        
        while (Linea != null)
        {
            ListaArbol.add(Linea);
            Linea = leerArchivo.readLine();
        }
        
        int tamaño = ListaArbol.size();
        
        this.Arbol = new String[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            this.Arbol[i] = ListaArbol.remove(0);
        }
        
        Leer.close();
        leerArchivo.close();
    }
    
    // Obtiene el inicio del Arbol
    private void ObtenerIncio() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\desc_ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        
        if (Archivo.exists())
        {
            FileReader Leer = new FileReader(Archivo);
            BufferedReader leerArchivo = new BufferedReader(Leer);
            String Linea = "";

            for (int i = 0; i < 6; i++)
                Linea = leerArchivo.readLine();

            String[] Segmentos = Linea.split("\\|");

            InicioArbol = Integer.valueOf(Segmentos[1]);
            
            Leer.close();
            leerArchivo.close();
        }
    }
    
    private void ModificarArbol() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        
        String Auxiliar;
        
        int cont = 0;
        
        while (Linea != null)
        {
            if (!Linea.equals(Arbol[cont]))
            {
                ArchivoSustitucion.writeBytes(Arbol[cont]);
            }
            
            Linea = leerArchivo.readLine();
            Auxiliar = ArchivoSustitucion.readLine();
            cont++;
        }
        
        leerArchivo.close();
        Leer.close();
        ArchivoSustitucion.close();
    }
    
    private String ObtenerMensaje(String De, String Para, String Fecha) throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        
        while(Linea != null)
        {
            if (Linea.contains(De) && Linea.contains(Para) && Linea.contains(Fecha))
            {
                String[] Row = Linea.split("\\|");
                return Row[6];
            }
            
            Linea = leerArchivo.readLine();
        }
        
        return "";
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAdjuntar;
    private javax.swing.JButton jBtnDescartar;
    private javax.swing.JButton jBtnEnviar;
    private javax.swing.JComboBox<String> jCBDestinatario;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLblPara;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTAMensaje;
    private javax.swing.JTextField jTFAsunto;
    private javax.swing.JLabel lblEncabezado;
    // End of variables declaration//GEN-END:variables

    private Date SimpleDateFormat(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
