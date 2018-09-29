package proyecto_meia;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
            
}
