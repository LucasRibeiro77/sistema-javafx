package sistema;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
  
public class Conexao{
 
        public static String status = "Falha ao conectar ao Banco de Dados.\nFavor contatar o Administrador do sistema.\n\n\n\n";
 
        public Conexao() { 
        
        }
 
        public static java.sql.Connection getConexao() {
 
        Connection connection = null;         
 
            try {

                String driverName = Exibir().getDriver();

                Class.forName(driverName);

                String serverName = Exibir().getNomeServidor();
                String mydatabase = String.valueOf(Exibir().getBancoDados());
                String url = Exibir().getURL() + serverName + "/" + mydatabase;
                String username = Exibir().getUsuario();
                String password = Exibir().getSenha();
                connection = DriverManager.getConnection(url, username, password);

                if (connection != null) {
                    status = ("Conectado com sucesso!\n\n\n\n");
                } else {
                    status = ("Não foi possivel realizar conexão\n\n\n\n"); 
                }
                return connection;

        } catch (ClassNotFoundException e) {
            
            System.out.println("O driver expecificado nao foi encontrado.\n\n\n\n");
            status = ("O driver expecificado nao foi encontrado.\n\n\n\n");
            return null;
            
        } catch (SQLException e) {
            
            System.out.println("Nao foi possivel conectar ao Banco de Dados.\n\n\n\n");
            return null;
            
        }
    }

    public static String statusConection() {
        
        return status;
        
    }

    public static boolean FecharConexao() {
        try {
            
            Conexao.getConexao().close();
            return true;
            
        } catch (SQLException e) {
            
            return false;
            
        }
    }

    public static java.sql.Connection ReiniciarConexao() {
        
        FecharConexao();
        return Conexao.getConexao();
    }
    public static ConfigServidor Exibir(){
        
            ResultSet rs;
            ConfigServidor d = new ConfigServidor();
            
            try(Connection conexao = DriverManager.getConnection("jdbc:sqlite:C:\\Sistema\\dist\\configBd.db")){
               
                String consulta = "SELECT * FROM CONFIG_SERVIDOR";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery();

                while(rs.next()){
                    
                    d.setNomeServidor(rs.getString("SERVIDOR"));
                    d.setBancoDados(rs.getString("BANCO_DADOS"));
                    d.setPorta(rs.getString("PORTA"));
                    d.setDriver(rs.getString("DRIVER"));
                    d.setUsuario(rs.getString("USUARIO"));
                    d.setSenha(rs.getString("SENHA"));   
                    d.setURL(rs.getString("URL"));   
                    
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return d;
    }
}