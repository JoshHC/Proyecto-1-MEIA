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
    
    public void DescriptorBitacoraUsuario(Descriptor_Bitacora Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Usuarios.txt";
        File Archivo = new File(pathRuta);
        RandomAccessFile ArchivoSustitucion = new RandomAccessFile(Archivo,"rw");
        /*FileReader Leer = new FileReader(Archivo);
        BufferedReader bs = new BufferedReader(Leer);*/
        String Auxiliar = ArchivoSustitucion.readLine();
        String [] AuxTamaño = Auxiliar.split("\\|");
       
        /*
        FileWriter Escribir = new FileWriter(Archivo);
        BufferedWriter bw = new BufferedWriter(Escribir);
*/
        
        
        if(AuxTamaño.length == 1)
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
         ArchivoSustitucion.writeBytes("Usuario que lo Modifico"+"|"+Descriptor.Fecha_Modificacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Numero de Registros"+"|"+Descriptor.NumerodeRegistros);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.writeBytes("Max.Reorganizacion"+"|"+Descriptor.Max_Reorganizacion);
         ArchivoSustitucion.writeBytes("\r\n");
         ArchivoSustitucion.close();
        }
        else
        {
            String Sustitucion;
            String Linea = ArchivoSustitucion.readLine();
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
             Linea = ArchivoSustitucion.readLine();
             
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_Modificacion;
            ArchivoSustitucion.skipBytes(Linea.length());
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "No. Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Max. Reorganizacion"+"|"+Descriptor.Max_Reorganizacion;
            ArchivoSustitucion.writeBytes(Sustitucion);     
        }
        
    }
    
     public void DescriptorUsuario(Descriptor_Usuario Descriptor) throws IOException
    {
        String pathRuta = "C:\\MEIA\\desc_Bitacora_Usuarios.txt";
        
        File Archivo = new File(pathRuta);
        FileWriter Escribir = new FileWriter(Archivo,true);
        BufferedWriter bw = new BufferedWriter(Escribir);
        
        RandomAccessFile File = new RandomAccessFile(pathRuta, "rw");
        
        if(Archivo.length() == 0)
        {
         bw.write("Nombre Simbolico"+"|"+Descriptor.Nombre_Simbolico);
         bw.newLine();
         bw.write("Fecha de Creacion"+"|"+Descriptor.Fecha_Creacion);
         bw.newLine();
         bw.write("Usuario que lo Creo"+"|"+Descriptor.Usuario_Creacion);
         bw.newLine();
         bw.write("Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion);
         bw.newLine();
         bw.write("Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion);
         bw.newLine();
         bw.write("No. Registros"+"|"+Descriptor.NumerodeRegistros);
         bw.newLine();
         bw.write("Registros Activos"+"|"+Descriptor.RegistrosActivos);
         bw.newLine();
         bw.write("Registros Inactivos"+"|"+Descriptor.RegistrosInactivos);
         bw.newLine();
         bw.close();   
         Escribir.close();
        }
        else
        {
            RandomAccessFile ArchivoSustitucion = new RandomAccessFile(pathRuta, "rw");
            String Sustitucion;
            String Linea = ArchivoSustitucion.readLine();
            Linea = ArchivoSustitucion.readLine();
            Linea = ArchivoSustitucion.readLine();
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Fecha de Modificacion"+"|"+Descriptor.Fecha_Modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
             Linea = ArchivoSustitucion.readLine();
             
            Sustitucion = "Usuario que lo Modifico"+"|"+Descriptor.Usuario_modificacion;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "No. Registros"+"|"+Descriptor.NumerodeRegistros;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Registros Activos"+"|"+Descriptor.RegistrosActivos;
            ArchivoSustitucion.writeBytes(Sustitucion);
            
            Linea = ArchivoSustitucion.readLine();
            
            Sustitucion = "Registros Inactivos"+"|"+Descriptor.RegistrosInactivos;
            ArchivoSustitucion.writeBytes(Sustitucion);    
        }
        
    }
}
