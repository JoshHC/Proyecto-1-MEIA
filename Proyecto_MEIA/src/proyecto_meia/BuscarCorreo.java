package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/**
 *
 * @author Admin
 */
public class BuscarCorreo extends javax.swing.JFrame {
    Procesos procesos = new Procesos();
    
    private String[] Arbol;
    
    DefaultListModel CorreosEncontrados;
    
    private String Usuario;
    private String Rol;
    
    public BuscarCorreo(String Usuario, String Rol) throws IOException
    {
        initComponents();
        
        this.Usuario = Usuario;
        this.Rol = Rol;
        
        ObtenerArbol();
        
        CorreosEncontrados = new DefaultListModel();
    }
    
    public BuscarCorreo() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        lblEncabezado = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstBusqueda = new javax.swing.JList<>();
        jTFParametros = new javax.swing.JTextField();
        jBtnDescartar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("Visualizar Correo");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblEncabezado.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lblEncabezado.setForeground(new java.awt.Color(255, 255, 255));
        lblEncabezado.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEncabezado.setText("BuscarCorreo ");
        getContentPane().add(lblEncabezado, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLstBusqueda.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLstBusqueda.setComponentPopupMenu(jPopupMenu1);
        jLstBusqueda.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jLstBusqueda);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 460, 220));

        jTFParametros.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jTFParametros.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTFParametrosKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTFParametrosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTFParametrosKeyTyped(evt);
            }
        });
        getContentPane().add(jTFParametros, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 460, 20));

        jBtnDescartar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnDescartar.setText("Regresar");
        jBtnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescartarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    
    private void jBtnDescartarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnDescartarActionPerformed

        try
        {
            Principal Menu = new Principal(Usuario, Rol);
            Menu.setLocationRelativeTo(null);
            Menu.show();
            this.dispose();
        }
        catch (IOException ex)
        {
            Logger.getLogger(BandejaES.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBtnDescartarActionPerformed


    private void jTFParametrosKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFParametrosKeyPressed
        
    }//GEN-LAST:event_jTFParametrosKeyPressed

    private void jTFParametrosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFParametrosKeyTyped
        
    }//GEN-LAST:event_jTFParametrosKeyTyped

    
    private void jTFParametrosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTFParametrosKeyReleased
        CorreosEncontrados.clear();
        CorreosEncontrados.addElement("Remitente             |Destinatario            |Asunto                |Fecha");

        Buscar();
    }//GEN-LAST:event_jTFParametrosKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        String[] Campos = jLstBusqueda.getSelectedValue().split("\\|");
        
        if (procesos.EliminarCaracteres(this.Usuario).equals(procesos.EliminarCaracteres(Campos[0])))
        {
            try 
            {
                EnviarMensaje Mensaje = new EnviarMensaje("Correo Enviado", this.Usuario, this.Rol,
                        procesos.EliminarCaracteres(Campos[0]), procesos.EliminarCaracteres(Campos[1]), 
                        procesos.EliminarCaracteres(Campos[2]));
                Mensaje.setLocationRelativeTo(null);
                Mensaje.show();
                this.dispose();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(BandejaES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else
        {
            try 
            {
                EnviarMensaje Mensaje = new EnviarMensaje("Correo Recibido", this.Usuario, this.Rol,
                        procesos.EliminarCaracteres(Campos[0]), procesos.EliminarCaracteres(Campos[1]), 
                        procesos.EliminarCaracteres(Campos[2]));
                Mensaje.setLocationRelativeTo(null);
                Mensaje.show();
                this.dispose();
            } 
            catch (IOException ex) 
            {
                Logger.getLogger(BandejaES.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void Buscar()
    {
        String Busqueda = jTFParametros.getText();
        
        for (String Linea : Arbol)
        {
            if (Linea.contains(Busqueda))
            {
                String[] Row = Linea.split("\\|");
                CorreosEncontrados.addElement(Row[2] +"|"+ Row[3] +"|"+ Row[5] + "|" + Row[4]);
            }
        }
        
        jLstBusqueda.setModel(CorreosEncontrados);
        
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
            java.util.logging.Logger.getLogger(BuscarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BuscarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BuscarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BuscarCorreo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BuscarCorreo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDescartar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jLstBusqueda;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTFParametros;
    private javax.swing.JLabel lblEncabezado;
    // End of variables declaration//GEN-END:variables
}
