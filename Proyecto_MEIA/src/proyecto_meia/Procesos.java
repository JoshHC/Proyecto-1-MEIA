package proyecto_meia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.commons.io.FileUtils;
import static proyecto_meia.Nuevo_Usuario.fichero;

/**
 *
 * @author Admin
 */
public class Procesos {
    
    // Metodo que indica en que archivo se encuentra el usuario enviado.
    public String EncontrarUsuario(String user) throws FileNotFoundException, IOException
    {
        boolean ExisteUsuarios = false;
        boolean ExisteBitacora = false;
        
        String pathRuta;
        File Archivo;
        FileReader Leer;
        BufferedReader leerArchivo;
        String Linea;
        
        try
        {
            pathRuta = "C:\\MEIA\\Usuarios.txt";
            Archivo = new File(pathRuta);
            Leer = new FileReader(Archivo);
            leerArchivo = new BufferedReader(Leer);
            Linea = leerArchivo.readLine();
            
            while(Linea != null && ExisteUsuarios == false)
            {
                if(Linea.contains(user))
                    ExisteUsuarios = true;

                Linea = leerArchivo.readLine();
            } 
            leerArchivo.close();
            Leer.close();
        }
        catch(IOException ex)
        {
            
        }
        
        if (!ExisteUsuarios)
        {
            try
            {
                pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
                Archivo = new File(pathRuta);
                Leer = new FileReader(Archivo);
                leerArchivo = new BufferedReader(Leer);
                Linea = leerArchivo.readLine();

                while(Linea != null && ExisteBitacora == false)
                {
                    if(Linea.contains(user))
                        ExisteBitacora = true;

                    Linea = leerArchivo.readLine();
                } 
                leerArchivo.close();
                Leer.close();
            }
            catch (IOException ex)
            {
            
            }
            
        }
        
        if (ExisteUsuarios)
            return "Usuarios";
        else if(ExisteBitacora)
            return "Bitacora_Usuarios";
        else
            return "No Existe";
    }
    
    // Metodo que indica en que archivo se encuentra el usuario enviado.
    public Boolean AdicionExiste(String Lista, String Usuario) throws FileNotFoundException, IOException
    {
        boolean Existe = false;
        
        String pathRuta;
        File Archivo;
        FileReader Leer;
        BufferedReader leerArchivo;
        String Linea;
        
        try
        {
            pathRuta = "C:\\MEIA\\ListaUsuario.txt";
            Archivo = new File(pathRuta);
            Leer = new FileReader(Archivo);
            leerArchivo = new BufferedReader(Leer);
            Linea = leerArchivo.readLine();
            
            while(Linea != null && Existe == false)
            {
                if(Linea.contains(Lista) && Linea.contains(Usuario))
                    Existe = true;

                Linea = leerArchivo.readLine();
            } 
            
            leerArchivo.close();
            Leer.close();
        }
        catch(IOException ex)
        {
            
        }
        
        return Existe;
    }
    
     public String BuscarUsuario(String user) throws FileNotFoundException, IOException
    {
        boolean ExisteUsuarios = false;
        boolean ExisteBitacora = false;
        
        String pathRuta;
        File Archivo;
        FileReader Leer;
        BufferedReader leerArchivo;
        String Linea;
        
        try
        {
            pathRuta = "C:\\MEIA\\Usuarios.txt";
            Archivo = new File(pathRuta);
            Leer = new FileReader(Archivo);
            leerArchivo = new BufferedReader(Leer);
            Linea = leerArchivo.readLine();

            while(Linea != null)
            {
                String[] pedazos = Linea.split("\\|");
                    
                if(Linea.contains(user) && pedazos[9].equals("1"))
                    ExisteUsuarios = true;

                Linea = leerArchivo.readLine();
            } 
            leerArchivo.close();
            Leer.close();
        }
        catch(IOException ex)
        {
            
        }
        
        if (!ExisteUsuarios)
        {
            try
            {
                pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
                Archivo = new File(pathRuta);
                Leer = new FileReader(Archivo);
                leerArchivo = new BufferedReader(Leer);
                Linea = leerArchivo.readLine();
                
                while(Linea != null)
                {
                    String[] pedazos = Linea.split("\\|");
                    
                    if(Linea.contains(user) && pedazos[9].equals("1"))
                        ExisteBitacora = true;

                    Linea = leerArchivo.readLine();
                } 
                leerArchivo.close();
                Leer.close();
            }
            catch (IOException ex)
            {
            
            }
            
        }
        
        if (ExisteUsuarios)
            return "Usuarios";
        else if(ExisteBitacora)
            return "Bitacora_Usuarios";
        else
            return "No Existe";
    }
    
    public String[] ImplementacionSplit(String condiciones, int cant)
    {
        String[] porciones = new String[cant];
        int contador = 0;
        
        char[] Caracteres = condiciones.toCharArray();
        
        for(int i = 0; i < Caracteres.length; i++)
        {
            if (Caracteres[i] != '|' && porciones[contador] == null)
                porciones[contador] = Character.toString(Caracteres[i]);
            else if (Caracteres[i] != '|')
                porciones[contador] += Character.toString(Caracteres[i]);
            else
                contador++;
        }
        
        return porciones;
    }

    public void DescriptorBitacoraUsuario(Descriptor_Bitacora Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Usuarios.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        String Auxiliar = ArchivoSustitucion.readLine();
        String [] AuxTamaño = Auxiliar.split("\\|");
        
        if(Descriptor.NumerodeRegistros.equals("1"))
        {
            ArchivoSustitucion.seek(0);
            ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_simbolico);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);  
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
    
    public void DescriptorUsuario(Descriptor_Usuario Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Usuarios.txt";
        
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        String Auxiliar = ArchivoSustitucion.readLine();
        
        if(Auxiliar == null)
        {
            FileWriter Escritor = new FileWriter(Archivo,true);
            BufferedWriter bw = new BufferedWriter(Escritor);

            bw.write("Nombre Simbolico"+"|"+Descriptor.Nombre_Simbolico+System.lineSeparator());
            bw.write("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion+System.lineSeparator());
            bw.write("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion+System.lineSeparator());
            bw.write("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion+System.lineSeparator());
            bw.write("Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion+System.lineSeparator());
            bw.write("Numero de Registros"+"|"+Descriptor.NumerodeRegistros+System.lineSeparator());
            bw.write("Registros Activos"+"|"+Descriptor.RegistrosActivos+System.lineSeparator());
            bw.write("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos+System.lineSeparator());
            
            bw.close();
            Escritor.close();
            
            /*
            ArchivoSustitucion.seek(0);
            ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_Simbolico);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.close();
            */
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
    
    public void DescriptorBakcup(Descriptor_Backup Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Backup.txt";
        
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        String Auxiliar = ArchivoSustitucion.readLine();
        String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(AuxTamaño[1].equals("        "))
        {
         ArchivoSustitucion.seek(0);
         ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_Simbolico);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
         ArchivoSustitucion.close();
        }
        else
        {
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "No. Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
     
    public boolean ValidarCaracteres (String Texto, int cod)
    {   
        // Max 20 caracteres
        if (cod == 0)
        {
            if (Texto.length() < 20)
                return false;
            else
                return true;
        }
        // Max 30 caracteres
        else if (cod == 1)
        {
            if (Texto.length() < 30)
                return false;
            else
                return true;
        }
        // Max 40 caracteres
        else if (cod == 2)
        {
            if (Texto.length() < 40)
                return false;
            else
                return true;
        }
        // Max 200 caracteres
        else
        {
            if (Texto.length() < 200)
                return false;
            else
                return true;
        }
    }
    
    public String RellenarCaracteres (String Texto, int cod)
    {
        String tetsto = Texto;
        int cantidad = 0;
        
        switch(cod)
        {
            // Max 20 caracteres
            case 0: cantidad = 20 - Texto.length(); break;
            
            // Max 30 caracteres
            case 1: cantidad = 30 - Texto.length(); break;
            
            // Max 40 caracteres
            case 2: cantidad = 40 - Texto.length(); break;
            
            // Max 200 caracteres
            case 3: cantidad = 200 - Texto.length(); break;
            
            // Max 80 caracteres
            case 4: cantidad = 80 - Texto.length(); break;
        }
        
        for (int i = 0; i < cantidad; i++)
            tetsto += " ";
        
        return tetsto;
    }
    
    
    public Boolean ListaExiste(String Nombre) throws FileNotFoundException, IOException
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

                pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
                Archivo = new File(pathRuta);
                Lectura = new FileReader(Archivo);
                Leer = new BufferedReader(Lectura);
                Linea = Leer.readLine();

                while(Linea != null)
                {
                  Auxiliar = Linea.split("\\|");
                  NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
                  if(Nombre.equals(Auxiliar[0]))
                      Existe = true;
                  Linea = Leer.readLine();
                }

        return Existe; 
    }
    
    
    // Elimina los espacios
    public String EliminarCaracteres (String Texto)
    {
        char[] caracteres = Texto.toCharArray();
        String TextoSinEspacios = "";
        
        try
        {
            for (int i = 0; i < caracteres.length; i++)
            {
                if (caracteres[i] != ' ' || caracteres[i+1] != ' ')
                    TextoSinEspacios += Character.toString(caracteres[i]);
            }
        }
        catch(Exception e)
        {
        
        }
        
        
        return TextoSinEspacios;
    }
    
    public String Validador() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Usuarios.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);

        String Linea = bw.readLine();
        String Auxiliar = "";
        String ObtenerRegistros = "";
        int contadorregistros = 0;
        
        while(Linea != null)
        {
            Auxiliar = Linea;
            Linea = bw.readLine();
            
            if(Linea == null)
            {
                ObtenerRegistros = Auxiliar;
            }
            
        }
        Leer.close();
        bw.close();
        
        String [] AuxRegistros = ObtenerRegistros.split("\\|");
        
        String path = "C:\\MEIA\\Bitacora_Usuarios.txt";
        File Archivou = new File(path);
        FileReader Leeru = new FileReader(Archivou);
        BufferedReader bs = new BufferedReader(Leeru);

        String Lineau = bs.readLine();
        
        while(Lineau != null)
        {
            contadorregistros++;
            Lineau = bs.readLine();
        }
        Leer.close();
        bw.close();
        
        if(Integer.toString(contadorregistros).equals(AuxRegistros[1]) == true)
        {
            return "Reorganizar";
        }
        else
        {
            return "Estable";
        }       
    }
    
    public String ValidadorListaUsuario() throws FileNotFoundException, IOException
    {
       String pathRuta = "C:\\MEIA\\desc_Bitacora_ListaUsuario.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);

        String Linea = bw.readLine();
        String Auxiliar = "";
        String ObtenerRegistros = "";
        int contadorregistros = 0;
        
        while(Linea != null)
        {
            Auxiliar = Linea;
            Linea = bw.readLine();
            
            if(Linea == null)
            {
                ObtenerRegistros = Auxiliar;
            }
            
        }
        Leer.close();
        bw.close();
        
        String [] AuxRegistros = ObtenerRegistros.split("\\|");
        
        String path = "C:\\MEIA\\Bitacora_ListaUsuario.txt";
        File Archivou = new File(path);
        FileReader Leeru = new FileReader(Archivou);
        BufferedReader bs = new BufferedReader(Leeru);

        String Lineau = bs.readLine();
        
        while(Lineau != null)
        {
            contadorregistros++;
            Lineau = bs.readLine();
        }
        Leer.close();
        bw.close();
        
        if(Integer.toString(contadorregistros).equals(AuxRegistros[1]) == true)
        {
            return "Reorganizar";
        }
        else
        {
            return "Estable";
        }       
 
    }
    
    public String ValidadorLista() throws FileNotFoundException, IOException
    {
       String pathRuta = "C:\\MEIA\\desc_Bitacora_Lista.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);

        String Linea = bw.readLine();
        String Auxiliar = "";
        String ObtenerRegistros = "";
        int contadorregistros = 0;
        
        while(Linea != null)
        {
            Auxiliar = Linea;
            Linea = bw.readLine();
            
            if(Linea == null)
            {
                ObtenerRegistros = Auxiliar;
            }
            
        }
        Leer.close();
        bw.close();
        
        String [] AuxRegistros = ObtenerRegistros.split("\\|");
        
        String path = "C:\\MEIA\\Bitacora_Lista.txt";
        File Archivou = new File(path);
        FileReader Leeru = new FileReader(Archivou);
        BufferedReader bs = new BufferedReader(Leeru);

        String Lineau = bs.readLine();
        
        while(Lineau != null)
        {
            contadorregistros++;
            Lineau = bs.readLine();
        }
        Leer.close();
        bw.close();
        
        if(Integer.toString(contadorregistros).equals(AuxRegistros[1]) == true)
        {
            return "Reorganizar";
        }
        else
        {
            return "Estable";
        }       
 
    }
    
    public void Reorganizar() throws FileNotFoundException, IOException
    {
        
        String pathRuta = "C:\\MEIA\\Bitacora_Usuarios.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);
        Usuario usuarioaux = new Usuario();
        List<Usuario> Lista = new ArrayList<Usuario>();

        String Linea = bw.readLine();
        while(Linea != null)
        {
            String [] Auxiliar = Linea.split("\\|");
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
            usuarioaux = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Aux,Fecha,Auxiliar[6],Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
            Lista.add(usuarioaux);
            Linea = bw.readLine(); 
        }
        Leer.close();
        bw.close();
        
        String path = "C:\\MEIA\\Usuarios.txt";
        File Archivou = new File(path);
            if(Archivou.exists() == true)
            {
            FileReader Leeru = new FileReader(Archivou);
            BufferedReader bs = new BufferedReader(Leeru);

            String Lineau = bs.readLine();
                while(Lineau != null)
                {
                    byte Aux;
                    byte Aux2;
                    String [] Auxiliar = Lineau.split("\\|");

                    if(Auxiliar[4].equals("1"))
                        Aux = 1;
                    else
                        Aux = 0;

                    if(Auxiliar[9].equals("1"))
                        Aux2 = 1;
                    else
                        Aux2 = 0;

                    Date Fecha = new Date(Auxiliar[5]);
                    usuarioaux = new Usuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Aux,Fecha,Auxiliar[6],Integer.parseInt(Auxiliar[7]),Auxiliar[8],Aux2);
                    Lista.add(usuarioaux);
                    Lineau = bs.readLine(); 
                }
            Leer.close();
            bw.close();
            }
        Collections.sort(Lista, new Comparator<Usuario>() {
            
        public int compare(Usuario obj1, Usuario obj2) 
        {
            return obj1.getUsuario().compareTo(obj2.getUsuario());
        }
        
        });
        
        FileOutputStream writer = new FileOutputStream(Archivo);
        writer.write(("").getBytes());
        writer.close(); 
       
        FileWriter Escribir = new FileWriter(Archivou);
        BufferedWriter wr = new BufferedWriter(Escribir);
        
        for(int i = 0; i<= Lista.size()-1; i++)
        { 
            wr.write(Lista.get(i).Usuario+"|"+Lista.get(i).Nombre+"|"+Lista.get(i).Apellido+"|"+Lista.get(i).Password+"|"+Lista.get(i).rol+"|"+Lista.get(i).Fecha+"|"+Lista.get(i).CorreoAlterno+"|"+Lista.get(i).Telefono+"|"+Lista.get(i).PathFotografia+"|"+Lista.get(i).status);
            wr.write("\r\n");
        }
        wr.close();
        Escribir.close();
        
    }
    
    public void ReorganizarListaUsuario() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\Bitacora_ListaUsuario.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);
        ListaUsuario ListaAux = new ListaUsuario();
        List<ListaUsuario> Lista = new ArrayList<ListaUsuario>();

        String Linea = bw.readLine();
        while(Linea != null)
        {
            String []Auxiliar = Linea.split("\\|"); 
            ListaUsuario NuevaLista = new ListaUsuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
            Lista.add(NuevaLista);
            Linea = bw.readLine(); 
        }
        Leer.close();
        bw.close();
        
        String path = "C:\\MEIA\\ListaUsuario.txt";
        File Archivou = new File(path);
            if(Archivou.exists() == true)
            {
            FileReader Leeru = new FileReader(Archivou);
            BufferedReader bs = new BufferedReader(Leeru);

            String Lineau = bs.readLine();
                while(Lineau != null)
                {
                    String []Auxiliar = Linea.split("\\|"); 
                    ListaUsuario NuevaLista = new ListaUsuario(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
                    Lista.add(NuevaLista);
                    Lineau = bs.readLine(); 
                }
            Leer.close();
            bw.close();
            }
        Collections.sort(Lista, new Comparator<ListaUsuario>() {
            
        public int compare(ListaUsuario obj1, ListaUsuario obj2) 
        {
            return obj1.Nombre_lista.compareTo(obj2.Nombre_lista);
        }
        
        });
        
        FileOutputStream writer = new FileOutputStream(Archivo);
        writer.write(("").getBytes());
        writer.close(); 
       
        FileWriter Escribir = new FileWriter(Archivou);
        BufferedWriter wr = new BufferedWriter(Escribir);
        
        for(int i = 0; i<= Lista.size()-1; i++)
        { 
            wr.write("Nombre Lista"+"|"+Lista.get(i).Nombre_lista+"Usuario"+"|"+Lista.get(i).Usuario+"UsuarioAsociado"+"|"+Lista.get(i).Usuario_Asociado+"Descripcion"+"|"+Lista.get(i).Descripcion+"Fecha de Creacion "+"|"+Lista.get(i).Fecha_creacion+"Estatus"+"|"+Lista.get(i).Status);
            wr.write("\r\n");
        }
        wr.close();
        Escribir.close();
    }
    
    public void ReorganizarLista() throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\Bitacora_Lista.txt";
        File Archivo = new File(pathRuta);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader bw = new BufferedReader(Leer);
        Lista ListaAux = new Lista();
        List<Lista> Lista = new ArrayList<Lista>();

        String Linea = bw.readLine();
        
        while(Linea != null)
        {
            String []Auxiliar = Linea.split("\\|"); 
            Lista NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
            Lista.add(NuevaLista);
            Linea = bw.readLine(); 
        }
        
        Leer.close();
        bw.close();
        
        String path = "C:\\MEIA\\Lista.txt";
        File Archivou = new File(path);
        
        if(Archivou.exists() == true)
        {
            FileReader Leeru = new FileReader(Archivou);
            BufferedReader bs = new BufferedReader(Leeru);

            String Lineau = bs.readLine();

            try
            {
                while(Lineau != null)
                {
                    String []Auxiliar = Linea.split("\\|"); 
                    Lista NuevaLista = new Lista(Auxiliar[0],Auxiliar[1],Auxiliar[2],Auxiliar[3],Auxiliar[4],Auxiliar[5]);
                    Lista.add(NuevaLista);
                    Lineau = bs.readLine(); 
                }
            }
            catch(Exception e)
            {
            
            }
            

            Leer.close();
            bw.close();
        }
            
        /*
        Collections.sort(Lista, new Comparator<Lista>() {
            
        public int compare(Lista obj1, Lista obj2) 
        {
            return obj1.Nombre_lista.compareTo(obj2.Nombre_lista);
        }
        
        });
            */
        
        Collections.sort(Lista, new Comparator<Lista>(){
            public int compare(Lista p1, Lista p2) 
            {
                int resultado = p1.Nombre_lista.compareTo(p2.Nombre_lista);
                if ( resultado != 0 ) { return resultado;}

                resultado = p1.Usuario.compareTo(p2.Usuario);
                if ( resultado != 0 ) { return resultado;}

                return resultado;
            }

        });
        
        FileOutputStream writer = new FileOutputStream(Archivo);
        writer.write(("").getBytes());
        writer.close(); 
       
        FileWriter Escribir = new FileWriter(Archivou);
        BufferedWriter wr = new BufferedWriter(Escribir);
        
        for(int i = 0; i<= Lista.size()-1; i++)
        { 
            wr.write(Lista.get(i).Nombre_lista+"|"+ Lista.get(i).Usuario+"|"+ Lista.get(i).Descripcion+"|" 
                    +Lista.get(i).Numero_usuarios+"|" +Lista.get(i).Fecha_creacion+"|" +Lista.get(i).Status);
            wr.write("\r\n");
        }
        wr.close();
        Escribir.close();
    }
    
    public void DescriptorListaUsuario(Descriptor_ListaUsuario Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_ListaUsuario.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        //String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(Auxiliar == null)
        {
         ArchivoSustitucion.seek(0);
         ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_simbolico);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);  
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
     
     //NO ESTA EN USO
    public void DescriptorBitacoraListaUsuario(Descriptor_Bitacora_ListaUsuario Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_ListaUsuario.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        //String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(Auxiliar == null)
        {
         ArchivoSustitucion.seek(0);
         ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_simbolico);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);  
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
     
    public void DescriptorLista(Descriptor_Listas Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Lista.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        //String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(Auxiliar == null)
        {
         ArchivoSustitucion.seek(0);
         ArchivoSustitucion.writeBytes("Nombre Simbolico"+"|"+Descriptor.Nombre_simbolico);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);  
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
    
    public void DescriptorBitacoraLista(Descriptor_Bitacora_Lista Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Lista.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        //String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        //if(Descriptor.NumerodeRegistros.equals("1"))
        if(Descriptor.NumerodeRegistros.equals("1"))
        {
            ArchivoSustitucion.seek(0);
            ArchivoSustitucion.writeBytes("Nombre Simbolico|Bitacora_Lista");
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);  
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
      
    public void DescriptorListaIndizada(Descriptor_ListaUsuarioIndizada Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_ListaUsuarioIndizada.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        //String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(Auxiliar == null)
        {
            ArchivoSustitucion.seek(0);
            ArchivoSustitucion.writeBytes("Nombre Simbolico|Lista");
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registro de Inicio"+"|"+Descriptor.RegistrodeInicio);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registro de Inicio"+"|"+Descriptor.RegistrodeInicio;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
    
    // DESCRIPTOR DEL ARCHIVO ARBOL
    public void DescriptorArbolMensajes(Descriptor_ArbolMensajes Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_ArbolMensajes.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        String Auxiliar = ArchivoSustitucion.readLine();
        
        if(Auxiliar == null)
        {
            ArchivoSustitucion.seek(0);
            ArchivoSustitucion.writeBytes("Nombre Simbolico|ArbolMensajes");
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo creo"+"|"+Descriptor.Usuario_Creacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registro de Inicio"+"|"+Descriptor.RegistrodeInicio);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
            ArchivoSustitucion.writeBytes("\r\n");
            ArchivoSustitucion.close();
        }
        else
        {
            ArchivoSustitucion.seek(0);
            String Sustitucion;
            ArchivoSustitucion.readLine();
            ArchivoSustitucion.readLine();
            
            ArchivoSustitucion.readLine();            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
                        
            ArchivoSustitucion.readLine();
            Sustitucion = "Registro de Inicio"+"|"+Descriptor.RegistrodeInicio;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Numero de Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            ArchivoSustitucion.readLine();
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
        }
        
    }
    
    // Retorna cual es el inicio del Arbol
    public String ObtenerInicioArbol() throws FileNotFoundException, IOException
    {
        String path = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(path);
        FileReader Leer = new FileReader(Archivo);
        BufferedReader leerArchivo = new BufferedReader(Leer);
        String Linea = leerArchivo.readLine();
        
        List<String> Indices = new ArrayList<String>();
         
        int contElementos = 0;
        
        while (Linea != null)
        {
            String[] Row = Linea.split("\\|");
            
            String P0 = Row[0];
            if (P0.length() < 2)
                P0 = "0" + P0;
            String P1 = Row[1];
            if (P1.length() < 2)
                P1 = "0" + P1;
            
            if (P0.equals("-1"))
            {
                String Aux = String.valueOf(contElementos +1);
                
                if (Aux.length() < 2)
                    Aux = "0" + Aux;
                
                Indices.add(Aux);
            }
                
            
            if (!P0.equals("-1") && !P0.equals("  "))
                Indices.add(P0);
            if (!P1.equals("-1") && !P1.equals("  "))
                Indices.add(P1);
            
            contElementos++;
            Linea = leerArchivo.readLine();
        }
        
        for(int i = 1; i <= contElementos; i++)
        {
            String j = String.valueOf(i);
            
            if(j.length() < 2)
                j = "0" + j;
            
            if (!Indices.contains(j))
                return j;
        }
        
        return "";
    }
      
    public void Reorganizacion() throws FileNotFoundException, IOException
    {
        String[] path = {"C:\\MEIA\\Bitacora_Lista.txt", "C:\\MEIA\\Lista.txt", "C:\\MEIA\\ListaUsuario.txt"};
        
        for(int i = 0; i < 3; i++)
        {
            List<String> Lineas = new ArrayList<String>();
            File Archivo = new File(path[i]);
            
            if (Archivo.exists())
            {
                FileReader Leer = new FileReader(Archivo);
                BufferedReader leerArchivo = new BufferedReader(Leer);
                String Linea = leerArchivo.readLine();
                
                while(Linea != null)
                {
                    String[] Auxiliar = Linea.split("\\|");
                    
                    if (Auxiliar[5].equals("1"))
                        Lineas.add(Linea);
                    
                    Linea = leerArchivo.readLine();
                }
                
                Leer.close();
                leerArchivo.close();
                
                // Vacia el archivo
                FileOutputStream writer = new FileOutputStream(Archivo);
                writer.write(("").getBytes());
                writer.close(); 
                
                FileWriter Escritor = new FileWriter(Archivo,true);
                BufferedWriter bw = new BufferedWriter(Escritor);
                
                for (String line : Lineas)
                    bw.write(line + System.lineSeparator());
                
                Leer.close();
                bw.close();
            }
        }
        
        List<String> Lineas = new ArrayList<String>();
        File Archivo = new File("C:\\MEIA\\ListaUsuarioIndizada.txt");

        if (Archivo.exists())
        {
            FileReader Leer = new FileReader(Archivo);
            BufferedReader leerArchivo = new BufferedReader(Leer);
            String Linea = leerArchivo.readLine();

            while(Linea != null)
            {
                String[] Auxiliar = Linea.split("\\|");

                if (Auxiliar[6].equals("1"))
                    Lineas.add(Linea);

                Linea = leerArchivo.readLine();
            }

            Leer.close();
            leerArchivo.close();

            FileOutputStream writer = new FileOutputStream(Archivo);
            writer.write(("").getBytes());
            writer.close(); 


            FileWriter Escritor = new FileWriter(Archivo,true);
            BufferedWriter bw = new BufferedWriter(Escritor);

            for (String line : Lineas)
                bw.write(line + System.lineSeparator());

            Leer.close();
            bw.close();

        }

    }
    
    public String ObtenerExtension(String Path)
    {
        String[] Bloques = Path.split("\\.");
        return Bloques[Bloques.length - 1];
    }
    
    public void ReorganizarArbol() throws IOException
    {
        List<String> ListArbol = ObtenerArbol();

        int tamaño = ListArbol.size();
        
        String[] Arbol = new String[tamaño];
        
        for (int i = 0; i < tamaño; i++) {
            Arbol[i] = ListArbol.remove(0);
        }
        
        int cantEliminados = 0;
        
        for (int i = 0; i < Arbol.length; i++)
        {
            String[] Row = Arbol[i].split("\\|");
            
            if (!Row[0].equals("-1"))
            {
                Arbol[i - cantEliminados] = Arbol[i];
                Arbol = ReemplazarSiguiente(Arbol, String.valueOf(i + 1), String.valueOf(i - cantEliminados + 1));
            }
            else
            {
                cantEliminados++;
            }

        }
        
        for (int i = (Arbol.length - cantEliminados); i < Arbol.length; i++)
            Arbol[i] = "";
        
        ModificarArbol(Arbol);
    }
    
    // Canbia el indice
    // Donde encuentra el apuntador del que ya no está le pone el apuntador siguiente siguiente
    // -> () ->
    // ------->
    private String[] ReemplazarSiguiente(String[] Arbol, String numero, String sustitucion) throws IOException
    {
        for (int i = 0; i < Arbol.length; i++)
        {
            String[] Row = Arbol[i].split("\\|");
            
            if(numero.length() < 2)
                numero = "0" + numero;
            if(sustitucion.length() < 2)
                sustitucion = "0" + sustitucion;
            
            if (Row[0].equals(numero) || Row[1].equals(numero))
            {
                if (Row[0].equals(numero))
                    Row[0] = sustitucion;
                else if (Row[1].equals(numero))
                    Row[1] = sustitucion;
                
                Arbol[i] =  Row[0] +"|"+ Row[1] +"|"+ Row[2] +"|"+ Row[3] +"|"+ Row[4] +"|"+ Row[5] +"|"+ 
                        Row[6] +"|"+ Row[7] +"|"+ Row[8];
                
            }
        }
        
        return Arbol;
    }
    
    
    private void ModificarArbol(String[] Arbol) throws FileNotFoundException, IOException
    {
        String pathRuta = "C:\\MEIA\\ArbolMensajes.txt";
        File Archivo = new File(pathRuta);

        FileOutputStream writer = new FileOutputStream(Archivo);
        writer.write(("").getBytes());
        writer.close();
        
        FileWriter Escritor = new FileWriter(Archivo,true);
        BufferedWriter bw = new BufferedWriter(Escritor);

        for (String line : Arbol)
        {
            if (!line.equals(""))
                bw.write(line + System.lineSeparator());
        }
        
        bw.close();
        Escritor.close();
    }
    
    private List<String> ObtenerArbol() throws FileNotFoundException, IOException
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

        Leer.close();
        leerArchivo.close();
        
        return ListaArbol;
    }
}
