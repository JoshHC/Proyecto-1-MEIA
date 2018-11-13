
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
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class BandejaES extends javax.swing.JFrame {
    
    Procesos procesos = new Procesos();
    
    private String Bandeja;
    
    DefaultListModel CorreosRecibidos;
    DefaultListModel CorreosEnviados;
    
    private String Usuario;
    private String Rol;
    
    public BandejaES(String Bandeja, String Usuario, String Rol) throws IOException {
        initComponents();
        
        this.Usuario = Usuario;
        this.Bandeja = Bandeja;
        this.Rol = Rol;
        
        CorreosRecibidos = new DefaultListModel();
        CorreosEnviados = new DefaultListModel();
        
        if (this.Bandeja.equals("Entrada"))
        {
            CorreosRecibidos.addElement("De                        |Asunto                  |Fecha");
            lblBandeja.setText("Bandeja de Entrada");
            
            ObtenerRecibidos();
            jLstBandeja.setModel(CorreosRecibidos);
            
        }
        else 
        {
            CorreosEnviados.addElement("Para                     |Asunto                  |Fecha");
            lblBandeja.setText("Bandeja de Salida");
            
            ObtenerEnviados();
            jLstBandeja.setModel(CorreosEnviados);
        }
    }

    private BandejaES() {
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        lblBandeja = new javax.swing.JLabel();
        jBtnDescartar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLstBandeja = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();

        jMenuItem1.setText("Visualizar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Eliminar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblBandeja.setFont(new java.awt.Font("Calibri Light", 0, 36)); // NOI18N
        lblBandeja.setForeground(new java.awt.Color(255, 255, 255));
        lblBandeja.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblBandeja.setText("Bandeja de ");
        getContentPane().add(lblBandeja, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jBtnDescartar.setFont(new java.awt.Font("Calibri Light", 0, 16)); // NOI18N
        jBtnDescartar.setText("Regresar");
        jBtnDescartar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnDescartarActionPerformed(evt);
            }
        });
        getContentPane().add(jBtnDescartar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jLstBandeja.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
        jLstBandeja.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(jLstBandeja);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 460, 230));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        
        String[] Campos = jLstBandeja.getSelectedValue().split("\\|");
        
        if (this.Bandeja.equals("Entrada"))
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
        else
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

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // Eliminar
        JOptionPane.showMessageDialog(null, "Aca se debe de Eliminar");
    }//GEN-LAST:event_jMenuItem2ActionPerformed

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
            java.util.logging.Logger.getLogger(BandejaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BandejaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BandejaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BandejaES.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BandejaES().setVisible(true);
            }
        });
    }

    
    private DefaultListModel ObtenerRecibidos() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Row = leerArchivo.readLine();
        String[] Linea = Row.split("\\|"); 
        
        while (Row != null)
        {
            if (procesos.EliminarCaracteres(Linea[3]).equals(this.Usuario))
                CorreosRecibidos.addElement(Linea[3] +"|"+ Linea[5] +"|"+ Linea[4]);
            
            try
            {
                Row = leerArchivo.readLine();
                Linea = Row.split("\\|");
            }
            catch(Exception e)
            {
                break;
            }
            
        }
        
        Leer.close();
        leerArchivo.close();
        
        return CorreosRecibidos;
    }
    
    private DefaultListModel ObtenerEnviados() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Row = leerArchivo.readLine();
        String[] Linea = Row.split("\\|");
        
        while (Row != null)
        {
            if (procesos.EliminarCaracteres(Linea[2]).equals(this.Usuario))
                CorreosEnviados.addElement(Linea[3] +"|"+ Linea[5] +"|"+ Linea[4]);
            
            try
            {
                Row = leerArchivo.readLine();
                Linea = Row.split("\\|");
            }
            catch(Exception e)
            {
                break;
            }
        }
        
        Leer.close();
        leerArchivo.close();
        
        return CorreosEnviados;
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnDescartar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList<String> jLstBandeja;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBandeja;
    // End of variables declaration//GEN-END:variables
}
