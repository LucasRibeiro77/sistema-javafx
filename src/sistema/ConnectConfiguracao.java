package sistema;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.Iterator;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
  
public class ConnectConfiguracao{
    
        public static String status = "Falha ao conectar ao Banco de Dados. \n\nFavor contatar o Administrador do sistema.";
        public static Statement stm;
             
        public ConnectConfiguracao() { 
        
        }
 
        public static java.sql.Connection getConexao() throws Exception, SQLException, ClassNotFoundException {
 
        Connection connection = null;         
                
            String driverName = "org.sqlite.JDBC";                        

            Class.forName(driverName);

            String mydatabase = "src/sistema/lib/configBd.db";    
            String url = "jdbc:sqlite:" + mydatabase;

            connection = DriverManager.getConnection(url);
            
            if (connection != null) {
                status = ("STATUS--->Conectado com sucesso!");
            } else {
                status = ("STATUS--->Não foi possivel realizar conexão"); 
            }
  
            return connection;
        }
        public void initDB() {	  
		try {

			this.stm.executeUpdate("DROP TABLE IF EXISTS CONFIG_SERVIDOR");

			this.stm.executeUpdate("CREATE TABLE CONFIG_SERVIDOR ("
				+ "SERVIDOR varchar(50) PRIMARY KEY NOT NULL,"
				+ "PORTA varchar(50),"
                                + "USUARIO varchar(50),"
                                + "SENHA varchar(15),"
                                + "DRIVER varchar(100),"
                                + "BANCO_DADOS varchar(50),"
                                + "URL varchar(50));");
		} 
		catch (SQLException e) {
			e.printStackTrace();  
		}  
	}
}
