package proyecto_meia;

/**
 *
 * @author Admin
 */
public class Node {
    
    int Izq;
    int Der;
    String UsuarioEmisor;
    String UsuarioReceptor;
    String FechaTransaccion;
    String Asunto;
    String Mensaje;
    String Adjunto;
    String Status;
    
    Node left;
    Node right;

    public boolean isLeaf ()
    {
        return left == null && right == null;
    }

    //TENGO QUE CONSTRUIR EL CONSTRUCTOR JAJA
    
    public Node()
    {
        
        
        left = null;
        right = null;
    }

    public Node(char caracter, int repeticiones)
    {
        
        
        left = null;
        right = null;
    }

}
