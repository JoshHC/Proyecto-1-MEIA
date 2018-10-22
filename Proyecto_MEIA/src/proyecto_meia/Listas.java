package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Date;
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
    
    Procesos procesos = new Procesos();
    
    static String Usuario;
    static String Rol;
    private static String NombreListaSeleccionada;
    Procesos Acceso = new Procesos();
    
    
    public Listas(String Usuario, String Rol) throws IOException {
        initComponents();
        
        this.Usuario = Usuario;
        this.Rol = Rol;
        String pathRuta1 = "C:\\MEIA\\Lista.txt";
        String pathRuta2 = "C:\\MEIA\\Bitacora_Lista.txt";
        File Archivo1 = new File(pathRuta1);
        File Archivo2 = new File(pathRuta2);
        
        if(Archivo1.exists() || Archivo2.exists())
            BuscarListas(Usuario);
    }

    private Listas() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    //En esta Funcion se Buscan las Listas para llenar La Lista del Menu Principal.
    private void BuscarListas(String Usuario) throws FileNotFoundException, IOException
    {
        if(Rol.equals("Administrador"))
        {
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            
            if(Archivo.exists())
            {
                FileReader Lectura = new FileReader(Archivo);
                BufferedReader Leer = new BufferedReader(Lectura);
                String Linea = Leer.readLine();
                String[] Auxiliar;
                List<Lista> Listas = new ArrayList<Lista>();
                Lista NuevaLista;

                while(Linea != null)
                {
                    Auxiliar = Linea.split("\\|"); 
                    NuevaLista = new Lista(Auxiliar[0]+"  |",Auxiliar[1]+"|",Auxiliar[2]+"|",procesos.RellenarCaracteres(Auxiliar[3], 0)+"|"
                            ,Auxiliar[4] + "   "+"|",Auxiliar[5]);
                    Listas.add(NuevaLista);

                    Linea = Leer.readLine();
                }

                DefaultListModel Modelo = new DefaultListModel();
                Modelo.addElement(procesos.RellenarCaracteres("Nombre Lista", 1) +"|"+ procesos.RellenarCaracteres("Usuario", 0) +"|"+ 
                        procesos.RellenarCaracteres("Descripcion", 2) + "      " +"|"+ procesos.RellenarCaracteres("Numero de Usuarios", 0) +"|"+
                        "Fecha de Creacion               " +"|"+ procesos.RellenarCaracteres("Estatus", 0));
                
                for(int i = 0; i< Listas.size(); i++)
                {
                    Modelo.addElement(Listas.get(i).Nombre_lista+" "+Listas.get(i).Usuario+" "+
                            Listas.get(i).Descripcion+" "+Listas.get(i).Numero_usuarios+" "+
                            Listas.get(i).Fecha_creacion+" "+Listas.get(i).Status);
                }
                
                lstListas.setModel(Modelo);
            }
            else
            {
                pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
                Archivo = new File(pathRuta);
                FileReader Lectura = new FileReader(Archivo);
                BufferedReader Leer = new BufferedReader(Lectura);
                String Linea = Leer.readLine();
                String[] Auxiliar;
                List<Lista> Listas = new ArrayList<Lista>();
                Lista NuevaLista;

                while(Linea != null)
                {
                    Auxiliar = Linea.split("\\|"); 
                    NuevaLista = new Lista(Auxiliar[0]+"  |",Auxiliar[1]+"|",Auxiliar[2]+"|",procesos.RellenarCaracteres(Auxiliar[3], 0)+"|"
                            ,Auxiliar[4] + "   "+"|",Auxiliar[5]);
                    Listas.add(NuevaLista);

                    Linea = Leer.readLine();
                }

                DefaultListModel Modelo = new DefaultListModel();
                Modelo.addElement(procesos.RellenarCaracteres("Nombre Lista", 1) +"|"+ procesos.RellenarCaracteres("Usuario", 0) +"|"+ 
                        procesos.RellenarCaracteres("Descripcion", 2) + "      " +"|"+ procesos.RellenarCaracteres("Numero de Usuarios", 0) +"|"+
                        "Fecha de Creacion               " +"|"+ procesos.RellenarCaracteres("Estatus", 0));
                
                for(int i = 0; i< Listas.size(); i++)
                {
                    Modelo.addElement(Listas.get(i).Nombre_lista+" "+Listas.get(i).Usuario+" "+
                            Listas.get(i).Descripcion+" "+Listas.get(i).Numero_usuarios+" "+
                            Listas.get(i).Fecha_creacion+" "+Listas.get(i).Status);
                }
                
                lstListas.setModel(Modelo);
            }
            
        }
        else
        {
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            
            if(Archivo.exists())
            {
                FileReader Lectura = new FileReader(Archivo);
                BufferedReader Leer = new BufferedReader(Lectura);
                String Linea = Leer.readLine();
                String[] Auxiliar;
                List<Lista> Listas = new ArrayList<Lista>();
                Lista NuevaLista;

                while(Linea != null)
                {
                    Auxiliar = Linea.split("\\|"); 
                    NuevaLista = new Lista(Auxiliar[0]+"  |",Auxiliar[1]+"|",Auxiliar[2]+"|",procesos.RellenarCaracteres(Auxiliar[3], 0)+"|"
                            ,Auxiliar[4] + "   "+"|",Auxiliar[5]);
                    
                    if(Auxiliar[1].equals(Usuario))
                        Listas.add(NuevaLista);
                    
                    Linea = Leer.readLine();
                }

                DefaultListModel Modelo = new DefaultListModel();
                Modelo.addElement(procesos.RellenarCaracteres("Nombre Lista", 1) +"|"+ procesos.RellenarCaracteres("Usuario", 0) +"|"+ 
                        procesos.RellenarCaracteres("Descripcion", 2) + "      " +"|"+ procesos.RellenarCaracteres("Numero de Usuarios", 0) +"|"+
                        "Fecha de Creacion               " +"|"+ procesos.RellenarCaracteres("Estatus", 0));
                
                for(int i = 0; i< Listas.size(); i++)
                {
                    Modelo.addElement(Listas.get(i).Nombre_lista+"|"+Listas.get(i).Usuario+"|"+
                            Listas.get(i).Descripcion+"|"+Listas.get(i).Numero_usuarios+"|"+
                            Listas.get(i).Fecha_creacion+"|"+Listas.get(i).Status);
                }
                
                lstListas.setModel(Modelo);  
            }
            else
            {
                pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
                Archivo = new File(pathRuta);   
                FileReader Lectura = new FileReader(Archivo);
                BufferedReader Leer = new BufferedReader(Lectura);
                String Linea = Leer.readLine();
                String[] Auxiliar;
                List<Lista> Listas = new ArrayList<Lista>();
                Lista NuevaLista;

                while(Linea != null)
                {
                    Auxiliar = Linea.split("\\|"); 
                    NuevaLista = new Lista(Auxiliar[0]+"  |",Auxiliar[1]+"|",Auxiliar[2]+"|",procesos.RellenarCaracteres(Auxiliar[3], 0)+"|"
                            ,Auxiliar[4] + "   "+"|",Auxiliar[5]);

                    if(Auxiliar[1].equals(Usuario))
                      Listas.add(NuevaLista);

                    Linea = Leer.readLine();
                }

                DefaultListModel Modelo = new DefaultListModel();
                Modelo.addElement(procesos.RellenarCaracteres("Nombre Lista", 1) +"|"+ procesos.RellenarCaracteres("Usuario", 0) +"|"+ 
                        procesos.RellenarCaracteres("Descripcion", 2) + "      " +"|"+ procesos.RellenarCaracteres("Numero de Usuarios", 0) +"|"+
                        "Fecha de Creacion               " +"|"+ procesos.RellenarCaracteres("Estatus", 0));
                
                for(int i = 0; i< Listas.size(); i++)
                {
                    Modelo.addElement(Listas.get(i).Nombre_lista+"|"+Listas.get(i).Usuario+"|"+
                            Listas.get(i).Descripcion+"|"+Listas.get(i).Numero_usuarios+"|"+
                            Listas.get(i).Fecha_creacion+"|"+Listas.get(i).Status);
                }
                
                lstListas.setModel(Modelo); 
            }
        }
    }
    
    private Boolean ListaExiste(String Nombre) throws FileNotFoundException, IOException
    {
        boolean Existe = false;
        
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            
            if(Archivo.exists())
            {
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
            }
            else
            {
                pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
                Archivo = new File(pathRuta);
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
        btnCrearNuevaLista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtListaaBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
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
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 20, -1, -1));

        btnRegresar.setFont(new java.awt.Font("Calibri Light", 1, 13)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 530, 130, 30));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Calibri Light", 1, 16)); // NOI18N
        jLabel1.setText("Gestion de Listas");

        lstListas.setFont(new java.awt.Font("Calibri Light", 0, 14)); // NOI18N
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
        btnModificar.setText("Modificar Usuarios");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(267, 267, 267)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 626, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEliminarLista)
                        .addContainerGap())))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminarLista))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 670, 280));

        btnCrearNuevaLista.setFont(new java.awt.Font("Calibri Light", 1, 18)); // NOI18N
        btnCrearNuevaLista.setText("Crear Nueva Lista");
        btnCrearNuevaLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearNuevaListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnCrearNuevaLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 190, 40));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtListaaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtListaaBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnBuscar)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 80, 270, 120));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyecto_meia/Fondo1.png"))); // NOI18N
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 750, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // Aca se programa modificar
        String[] Campos = lstListas.getSelectedValue().toString().split("\\|");
        
        String nombre = procesos.EliminarCaracteres(Campos[0]);
        String usuario = procesos.EliminarCaracteres(Campos[1]);
        String desc = procesos.EliminarCaracteres(Campos[2]);
         
        CrearLista Modificar = new CrearLista(usuario, nombre, desc, 1, Usuario, Rol);
        Modificar.setLocationRelativeTo(null);
        Modificar.show();
        this.dispose();
                
        //Se debe programar modificar descripcion solamente, lo demas no
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    
    private void btnCrearNuevaListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearNuevaListaActionPerformed
        CrearLista NuevaLista = new CrearLista(Usuario, Rol);
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
        try 
        {
            Principal Menu = new Principal(Usuario, Rol);
            Menu.setLocationRelativeTo(null);
            Menu.show();
            this.dispose();
        } 
        catch (IOException ex) 
        {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        String Datos = lstListas.getSelectedValue();
        String []DatosdeEnvio = Datos.split("\\|");
        
        if(lstListas.getSelectedValue() != "")
        {
            try {
                Modificacion_De_Listas RealizarModificacion = new Modificacion_De_Listas(DatosdeEnvio[0],Usuario);
                RealizarModificacion.setLocationRelativeTo(null);
                RealizarModificacion.show();
                this.dispose();
            } catch (IOException ex) {
                Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else
        {
            JOptionPane.showMessageDialog(jMenu1, "No ha seleccionado ningun elemento");
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnEliminarListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarListaActionPerformed
        
        String Cadena = lstListas.getSelectedValue();
        String []ArregloCadena = Cadena.split("\\|");
        String Nombre = ArregloCadena[0];
        NombreListaSeleccionada = Nombre;
        String Usuario = ArregloCadena[1];
        Procesos TamañoFijo = new Procesos();
        
        if(Cadena!= "")
        {
        try {
            String pathRuta = "C:\\MEIA\\Lista.txt";
            File Archivo = new File(pathRuta);
            RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
            String Linea = ArchivoSustitucion.readLine();
            String [] Auxiliar;
         
               
            while(Linea != null)
            {
                Auxiliar = Linea.split("\\|"); 
                if(Auxiliar[0].equals(Nombre) && Auxiliar[1].equals(Usuario))
                {
                    Lista NuevaLista = new Lista(TamañoFijo.RellenarCaracteres(ArregloCadena[0], 1),TamañoFijo.RellenarCaracteres(ArregloCadena[1], 0), TamañoFijo.RellenarCaracteres(ArregloCadena[2], 2),ArregloCadena[3], ArregloCadena[4], "0");
                    String Sustitucion = NuevaLista.Nombre_lista+"|"+NuevaLista.Usuario+"|"+NuevaLista.Descripcion+"|"+NuevaLista.Numero_usuarios+"|"+NuevaLista.Fecha_creacion+"|"+NuevaLista.Status;
                    ArchivoSustitucion.writeBytes(Sustitucion);
                }
                Linea = ArchivoSustitucion.readLine();
            }
            
            
            pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
            Archivo = new File(pathRuta);
            ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
            Linea = ArchivoSustitucion.readLine();
         
               
            while(Linea != null)
            {
                Auxiliar = Linea.split("\\|"); 
                if(Auxiliar[0].equals(Nombre) && Auxiliar[1].equals(Usuario))
                {
                    Lista NuevaLista = new Lista(TamañoFijo.RellenarCaracteres(ArregloCadena[0], 1),TamañoFijo.RellenarCaracteres(ArregloCadena[1], 0), TamañoFijo.RellenarCaracteres(ArregloCadena[2], 2),ArregloCadena[3], ArregloCadena[4], "0");
                    String Sustitucion = NuevaLista.Nombre_lista+"|"+NuevaLista.Usuario+"|"+NuevaLista.Descripcion+"|"+NuevaLista.Numero_usuarios+"|"+NuevaLista.Fecha_creacion+"|"+NuevaLista.Status;
                    ArchivoSustitucion.writeBytes(Sustitucion);
                }
                Linea = ArchivoSustitucion.readLine();
            }
            
            DescriptorLista();
            DescriptorBitacoraLista();
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Listas.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        else
        {
            JOptionPane.showMessageDialog(jMenu1, "No Ha Seleccionado Ningun Elemento");
        }
            
    }//GEN-LAST:event_btnEliminarListaActionPerformed

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
        
        
        Descriptor_Bitacora_Lista Nuevo = new Descriptor_Bitacora_Lista(NombreListaSeleccionada,Fecha.toString(),Usuario,Fecha.toString(),Usuario,Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos),"");
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
        
        
        Descriptor_Listas Nuevo = new Descriptor_Listas(NombreListaSeleccionada,Fecha.toString(),Usuario,Fecha.toString(),Usuario,Integer.toString(NoRegistros),Integer.toString(Activos),Integer.toString(Inactivos));
        Acceso.DescriptorLista(Nuevo);
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
