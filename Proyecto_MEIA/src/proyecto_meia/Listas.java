package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import static proyecto_meia.Login.Usuario;

/**
 *
 * @author Admin
 */
public class Listas extends javax.swing.JFrame {

    private String Usuario;
    
    private Listas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Listas(String Usuario) throws IOException {
        initComponents();
        
        this.Usuario = Usuario;
        BuscarListas(Usuario);
    }

    
    //En esta Funcion se Buscan las Listas para llenar La Lista del Menu Principal.
    private void BuscarListas(String Usuario) throws FileNotFoundException, IOException
    {
        if(Usuario == "Administrador")
        {
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            FileReader Lectura = new FileReader(Archivo);
            BufferedReader Leer = new BufferedReader(Lectura);
            String Linea = Leer.readLine();
            String[] Auxiliar;
            List<Lista> Listas = new ArrayList<Lista>();
            Lista NuevaLista;
            
            while(Linea != null)
            {
              Auxiliar = Linea.split("\\|"); 
              NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
              Listas.add(NuevaLista);
            }
            
            DefaultListModel Modelo = new DefaultListModel();
            Modelo.addElement("Nombre Lista:    "+ "Usuario:    "+"Descripcion:    "+"Numero de Usuarios:    "+"Fecha de Creacion:    "+"Estatus    ");
            for(int i = 0; i< Listas.size(); i++)
            {
                Modelo.addElement(Listas.get(i).Nombre_lista+" "+Listas.get(i).Usuario+" "+Listas.get(i).Descripcion+" "+Listas.get(i).Numero_usuarios+" "+Listas.get(i).Fecha_creacion+" "+Listas.get(i).Status);
            }
            lstListas.setModel(Modelo);
            
        }else
        {
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            FileReader Lectura = new FileReader(Archivo);
            BufferedReader Leer = new BufferedReader(Lectura);
            String Linea = Leer.readLine();
            String[] Auxiliar;
            List<Lista> Listas = new ArrayList<Lista>();
            Lista NuevaLista;
            
            while(Linea != null)
            {
              Auxiliar = Linea.split("\\|"); 
              NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
              if(Auxiliar[1].equals(Usuario))
              Listas.add(NuevaLista);
            }
            
            DefaultListModel Modelo = new DefaultListModel();
            Modelo.addElement("Nombre Lista:    "+ "Usuario:    "+"Descripcion:    "+"Numero de Usuarios:    "+"Fecha de Creacion:    "+"Estatus    ");
            for(int i = 0; i< Listas.size(); i++)
            {
                Modelo.addElement(Listas.get(i).Nombre_lista+" "+Listas.get(i).Usuario+" "+Listas.get(i).Descripcion+" "+Listas.get(i).Numero_usuarios+" "+Listas.get(i).Fecha_creacion+" "+Listas.get(i).Status);
            }
            lstListas.setModel(Modelo);    
        }
    }
    
    private Boolean ListaExiste(String Nombre) throws FileNotFoundException, IOException
    {
        boolean Existe = false;
        
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            FileReader Lectura = new FileReader(Archivo);
            BufferedReader Leer = new BufferedReader(Lectura);
            String Linea = Leer.readLine();
            String[] Auxiliar;
            Lista NuevaLista;
            
            while(Linea != null)
            {
              Auxiliar = Linea.split("\\|"); 
              NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
              if(Nombre.equals(Auxiliar[0]))
                  Existe = true;
            }

        return Existe; 
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jLabel2 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstListas = new javax.swing.JList<>();
        btnEliminarLista = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtListaaBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCrearNuevaLista = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jMenu1.setText("jMenu1");

        jMenuItem1.setText("Modificar Lista");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Calibri Light", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Administración de Listas");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Calibri Light", 1, 13)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 130, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel1.setText("Gestion de Listas");

        lstListas.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(lstListas);

        btnEliminarLista.setFont(new java.awt.Font("Calibri Light", 1, 13)); // NOI18N
        btnEliminarLista.setText("Eliminar Lista");
        btnEliminarLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarListaActionPerformed(evt);
            }
        });

        btnModificar.setFont(new java.awt.Font("Calibri Light", 1, 13)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(125, 125, 125))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 364, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarLista)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminarLista))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 390, 280));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel3.setText("Busqueda de Listas");

        btnBuscar.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        btnCrearNuevaLista.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        btnCrearNuevaLista.setText("Crear Nueva Lista");
        btnCrearNuevaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearNuevaListaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrearNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtListaaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtListaaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(btnCrearNuevaLista, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, -1, 280));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 740, 520));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Aca se programa modificar
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnCrearNuevaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearNuevaListaActionPerformed
        CrearLista NuevaLista = new CrearLista(Usuario);
        NuevaLista.setLocationRelativeTo(null);
        NuevaLista.show();
        this.dispose();
    }//GEN-LAST:event_btnCrearNuevaListaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        
        String Nombre = txtListaaBuscar.getText();
        try {
            if(ListaExiste(Nombre) == true)
            {
                JOptionPane.showMessageDialog(jMenu1,"La Lista que busca SI Existe","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }else
            {
                JOptionPane.showMessageDialog(jMenu1,"La Lista que busca NO Existe","Aviso",JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        Principal Menu = null;
        try {
            Menu = new Principal(Usuario);
        } catch (IOException ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        Menu.setLocationRelativeTo(null);
        Menu.show();
        this.dispose();
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        Modificacion_De_Listas RealizarModificacion = new Modificacion_De_Listas();
        RealizarModificacion.setLocationRelativeTo(null);
        RealizarModificacion.show();
        this.dispose();
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaActionPerformed
            
    }//GEN-LAST:event_btnEliminarListaActionPerformed

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
            java.util.logging.Logger.getLogger(Listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Listas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Listas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCrearNuevaLista;
    private javax.swing.JButton btnEliminarLista;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstListas;
    private javax.swing.JTextField txtListaaBuscar;
    // End of variables declaration//GEN-END:variables
}
