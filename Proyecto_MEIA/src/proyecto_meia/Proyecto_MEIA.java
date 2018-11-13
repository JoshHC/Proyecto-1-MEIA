/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_meia;

import java.sql.SQLException;

/**
 *
 * @author josue
 */
public class Proyecto_MEIA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Login MenuPrincipal = new Login();
        MenuPrincipal.setLocationRelativeTo(null);
        MenuPrincipal.show();
    }
    
}
