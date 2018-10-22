package proyecto_meia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class CrearLista extends javax.swing.JFrame {

    private int Code;
    private String Rol;
    private static String Usuario;
    private static String NombreLista;
    private static String Descripcion;
    Procesos Acceso = new Procesos();

    public CrearLista(String Usuario, String Rol) {
        initComponents();
        
        this.Usuario = Usuario;
        this.Rol = Rol;
        
        jTFUsuario.setText(Usuario);
        
        if (Rol == "Administrador")
            jTFUsuario.enable(true);
        else
            jTFUsuario.enable(false);
    }
    
    public CrearLista(String Usuario, String NombreLista, String Descripcion, int Code, String Rol) {
        initComponents();
        
        this.Code = Code;
        this.Usuario = Usuario;
        this.Rol = Rol;
        
        jTFUsuario.setText(Usuario);
        
        this.NombreLista = NombreLista;
        jTFNombreLista.setText(NombreLista);
        
        this.Descripcion = Descripcion;
        jTADescripcion.setText(Descripcion);
        
        jLTitulo.setText("Modificar Lista");
        jTFUsuario.enable(false);
        jTFNombreLista.enable(false);
        btnCrearLista.setText("Modificar");
        
    }

    private CrearLista() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancelar = new javax.swing.JButton();
        jLTitulo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTFUsuario = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTFNombreLista = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTADescripcion = new javax.swing.JTextArea();
        btnCrearLista = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        btnCancelar.setText("Regresar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, 180, 30));

        jLTitulo.setFont(new java.awt.Font("Calibri Light", 1, 48)); // NOI18N
        jLTitulo.setForeground(new java.awt.Color(255, 255, 255));
        jLTitulo.setText("Crear Lista");
        getContentPane().add(jLTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nombre de la Lista");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, -1, 20));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Usuario");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 140, -1, -1));
        getContentPane().add(jTFUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 140, 180, -1));

        jLabel4.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Descripcion");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 170, -1, -1));

        jTFNombreLista.setToolTipText("");
        getContentPane().add(jTFNombreLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 110, 180, -1));

        jTADescripcion.setColumns(20);
        jTADescripcion.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTADescripcion.setLineWrap(true);
        jTADescripcion.setRows(2);
        jTADescripcion.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTADescripcion);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 170, 180, -1));

        btnCrearLista.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        btnCrearLista.setText("Crear");
        btnCrearLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 180, 31));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        jLabel5.setText("jLabel5");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 330));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearListaActionPerformed
        if (Code == 1)
        {
            // MODIFICAR
        }
        else
        {
            Crear();
        }
        
        
        
    }//GEN-LAST:event_btnCrearListaActionPerformed

    private void Crear()
    {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd/MM/yyyy");
        
        String Nombre = jTFNombreLista.getText();
        String Usuario = jTFUsuario.getText();
        String Descripcion = jTADescripcion.getText();
        
        Lista NuevaLista = new Lista(Nombre, Usuario, Descripcion, "0", fecha.toString(), "1");
        
        try 
        {
            CrearLista(NuevaLista);
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CrearLista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void Modificar()
    {
    
    }
    
    
    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Listas Nueva = null;
        try 
        {
            Nueva = new Listas(Usuario, Rol);
            Nueva.setLocationRelativeTo(null);
            Nueva.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(CrearLista.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    //ESTO NO TIENE NADA QUE VER LA LISTA INDIZADA
    private void CrearLista(Lista NuevaLista) throws IOException
    {
        if (ListaExiste(NuevaLista))
        {
            JOptionPane.showMessageDialog(null, "No es posible crear esta lista en este momento. \n"
                    + "La lista que quieres crear ya existe.");
            jTFNombreLista.setText("");
            jTFUsuario.setText("");
            jTADescripcion.setText("");
        }
        else
        {
            String pathRutaLista = "C:\\MEIA\\Bitacora_Lista.txt";
            File ArchivoLista = new File(pathRutaLista);
                
            FileWriter Escribir = new FileWriter(ArchivoLista);
            BufferedWriter bw = new BufferedWriter(Escribir);
            
            if (VerificarEspacioBitacora())
            {
                //Se Inserta el Nuevo Registro
                bw.write(Acceso.RellenarCaracteres(NuevaLista.Nombre_lista,1)+"|"+Acceso.RellenarCaracteres(NuevaLista.Usuario,0)+"|"+Acceso.RellenarCaracteres(NuevaLista.Descripcion,2)+"|"+NuevaLista.Numero_usuarios+"|"+NuevaLista.Fecha_creacion+"|"+NuevaLista.Status);
                bw.close();
                Escribir.close();
                DescriptorBitacoraLista();      
                JOptionPane.showMessageDialog(this,"Lista Creada","La Lista se ha Creado Exitosamente",JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                Acceso.ReorganizarLista();
                //Se Inserta el Nuevo Registro
                bw.write(Acceso.RellenarCaracteres(NuevaLista.Nombre_lista,1)+"|"+Acceso.RellenarCaracteres(NuevaLista.Usuario,0)+"|"+Acceso.RellenarCaracteres(NuevaLista.Descripcion,2)+"|"+NuevaLista.Numero_usuarios+"|"+NuevaLista.Fecha_creacion+"|"+NuevaLista.Status);
                bw.close();
                Escribir.close();
                DescriptorBitacoraLista();
                DescriptorLista();
                JOptionPane.showMessageDialog(this,"Lista Creada","La Lista se ha Creado Exitosamente",JOptionPane.INFORMATION_MESSAGE);
            }
            
        jTFNombreLista.setText("");
        jTFUsuario.setText("");
        jTADescripcion.setText("");
        
        }
    }
    
    //METODO DUPLICADO HAY OTRO CON LA MISMA FUNCIONALIDAD EN PROCESOS
    private boolean VerificarEspacioBitacora() throws FileNotFoundException, IOException
    {
        boolean HayEspacio = true;
        
        String pathRutaBitacoraLista = "C:\\MEIA\\Bitacora_Lista.txt";
        File ArchivoBitacoraLista = new File(pathRutaBitacoraLista);
        FileReader Leer = new FileReader(ArchivoBitacoraLista);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
            
        if(Linea == null)
        {
            HayEspacio = true;
        }
        else
        {
        for(int i = 0; i < 6; i++)
            Linea = leerArchivo.readLine();
        
        String[] Trozos = new String[2];
        Trozos = Linea.split("\\|");
        
        for(int i = 0; i < 3; i++)
            Linea = leerArchivo.readLine();
        
        String[] trozos = new String[2];
        trozos = Linea.split("\\|");
        
        if (Trozos[1].equals(trozos[1]))
            HayEspacio = false;
        }
        
        return HayEspacio;   
    }
    
    private boolean ListaExiste(Lista NuevaLista) throws FileNotFoundException, IOException
    {
        boolean Existe = false;
        
        String pathRutaLista = "C:\\MEIA\\Lista.txt";
        File ArchivoLista = new File(pathRutaLista);
        
        String pathRutaBitacoraLista = "C:\\MEIA\\Bitacora_Lista.txt";
        File ArchivoBitacoraLista = new File(pathRutaBitacoraLista);
        
        if (ArchivoLista.exists())
        {
            FileReader Leer = new FileReader(ArchivoLista);
            BufferedReader leerArchivo = new BufferedReader(Leer);
            String Linea = leerArchivo.readLine();
            
            if(Linea != null)
            {
                while (!"".equals(Linea))
                {
                    String[] Datos = new String[6];
                    Datos = Linea.split("\\|");

                    if (NuevaLista.Nombre_lista.equals(Datos[0]) && NuevaLista.Usuario.equals(Datos[1]) && Datos[5].equals("1"))
                        Existe = true;

                    Linea = leerArchivo.readLine();
                }
            }
        } 
        
        if (ArchivoBitacoraLista.exists())
        {
            FileReader Leer = new FileReader(ArchivoBitacoraLista);
            BufferedReader leerArchivo = new BufferedReader(Leer);
            String Linea = leerArchivo.readLine();
            
            if(Linea != null)
            {
                while (!"".equals(Linea))
                {
                    String[] Datos = new String[6];
                    Datos = Linea.split("\\|");

                    if (NuevaLista.Nombre_lista.equals(Datos[0]) && NuevaLista.Usuario.equals(Datos[1]) && Datos[5].equals("1"))
                        Existe = true;

                    Linea = leerArchivo.readLine();
                }
            }
        }
        
        return Existe;
    }
    
    //método donde se crea el Descriptor de la Bitacora de Lista y se Actualiza
    public void DescriptorBitacoraLista() throws FileNotFoundException, IOException
    {
        Date Fecha = new Date();
        String path = "C:\\MEIA\\Bitacora_Lista.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        int NoRegistros = 0;
        int Activos = 0;
        int Inactivos = 0;        
        
        //Se compara en la posicion 9 porque en esa posicion se encontrara el status a la hora de hacer el split y separarlo.
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
            
            if(Auxiliar[5].equals("1"))
            {
                Activos++;
            }
            else if (Auxiliar[5].equals("0") == true)
            {
                Inactivos++;
            }
            Linea = leerArchivo.readLine();
            NoRegistros++;
        }
        

        Leer.close();
        leerArchivo.close();
        
        String Nombre = jTFNombreLista.getText();
        Descriptor_Bitacora_Lista Nuevo = new Descriptor_Bitacora_Lista(Acceso.RellenarCaracteres(Nombre,1),Fecha.toString(),Acceso.RellenarCaracteres(Usuario,0),Fecha.toString(),Acceso.RellenarCaracteres(Usuario,0),Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos),"");
        Acceso.DescriptorBitacoraLista(Nuevo);
    }
    
    //método donde se crea el Descriptor de Lista y se Actualiza
    public void DescriptorLista() throws FileNotFoundException, IOException
    {
        Date Fecha = new Date();
        String path = "C:\\MEIA\\Lista.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        int NoRegistros = 0;
        int Activos = 0;
        int Inactivos = 0;        
        
        //Se compara en la posicion 9 porque en esa posicion se encontrara el status a la hora de hacer el split y separarlo.
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
            
            if(Auxiliar[5].equals("1"))
            {
                Activos++;
            }
            else if (Auxiliar[5].equals("0") == true)
            {
                Inactivos++;
            }
            Linea = leerArchivo.readLine();
            NoRegistros++;
        }
        

        Leer.close();
        leerArchivo.close();
        
        
        Descriptor_Listas Nuevo = new Descriptor_Listas(NombreLista,Fecha.toString(),Usuario,Fecha.toString(),Usuario,Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos));
        Acceso.DescriptorLista(Nuevo);
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
            java.util.logging.Logger.getLogger(CrearLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrearLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrearLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrearLista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrearLista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnCrearLista;
    private javax.swing.JLabel jLTitulo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTADescripcion;
    private javax.swing.JTextField jTFNombreLista;
    private javax.swing.JTextField jTFUsuario;
    // End of variables declaration//GEN-END:variables
}
