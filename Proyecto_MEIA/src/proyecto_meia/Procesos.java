package proyecto_meia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import javax.swing.JOptionPane;

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

            while(Linea != null)
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

                while(Linea != null)
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
    
    public String[] ImplementacionSplit(String condiciones)
    {
        String[] porciones = new String[10];
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
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        String [] AuxTamaño = Auxiliar.split("\\|");
        
        
        if(AuxTamaño[1].equals("        "))
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
    
    public void DescriptorUsuario(Descriptor_Usuario Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Usuarios.txt";
        
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
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         ArchivoSustitucion.writeBytes("\r\n");
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
        // Max 30 caracteres
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
            // Max 30 caracteres
            case 0: cantidad = 20 - Texto.length(); break;
            // Max 30 caracteres
            case 1: cantidad = 30 - Texto.length(); break;
            // Max 40 caracteres
            case 2: cantidad = 40 - Texto.length(); break;
            // Max 200 caracteres
            case 3: cantidad = 200 - Texto.length(); break;
        }
        
        for (int i = 0; i < cantidad; i++)
            tetsto += " ";
        
        return tetsto;
    }
}
