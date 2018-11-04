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
    String Asunto;
    String Status
    
    private int Numero;
    private char Caracter;
    
    Node left;
    Node right;
    
    public int getNumero() {
        return Numero;
    }

    public void setNumero(int numero) {
        Numero = numero;
    }

    public char getCaracter() {
        return Caracter;
    }

    public void setCaracter(char caracter) {
        Caracter = caracter;
    }

    public boolean isLeaf ()
    {
        return left == null && right == null;
    }

    public Node()
    {
        Numero = 0;
        Caracter = '\0';
        left = null;
        right = null;
        coding = "";
    }

    public Node(char caracter, int repeticiones)
    {
        Numero = repeticiones;
        Caracter = caracter;
        left = null;
        right = null;
        coding = "";
    }

}
