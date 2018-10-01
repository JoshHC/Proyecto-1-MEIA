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
import javax.swing.JOptionPane;
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
        
        
        if(Auxiliar == null)
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
    
    public String EliminarCaracteres (String Texto)
    {
        char[] caracteres = Texto.toCharArray();
        String TextoSinEspacios = "";
        
        for (char letra : caracteres)
        {
            if (letra != ' ')
                TextoSinEspacios += Character.toString(letra);
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
}
