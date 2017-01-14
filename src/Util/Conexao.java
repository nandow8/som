 
package Util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Conexao {
    
                         //Banco de dados Local Xampp									//CLASSE DE CONEXAO COM O BANCO
    private final String URL = "jdbc:mysql://mysql.padaria.kinghost.net/padaria01";
    private final String Driver = "org.gjt.mm.mysql.Driver";
    private final String Usuario = "padaria01";
    private final String Senha = "flaviaw8";
    private static Connection Con;  
    public Conexao() {
        try {
            Con = DriverManager.getConnection(URL, Usuario, Senha);
            Con.setAutoCommit(false);
           //JOptionPane.showMessageDialog(null, "Conectado com Sucesso", "Conectado", 1);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao Conectar com o Banco", "Erro", 0);
        }
    }
    public static Connection getConnection() {
        if (Con == null) {
            new Conexao();
        }
        return Con;
    }
    public static void fecharConexao() {
        try {
            if (!Con.isClosed()) {
                Con.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void main(String[] args) {
        try {
            Conexao.getConnection();
            JOptionPane.showMessageDialog(null,"BOM");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"RUIM");
        }
    }
    
}
