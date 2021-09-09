package sistema;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfigConexaoBd {
    
    public static Label lblNomeServidor;
    public static Label lblNomeBd;
    public static Label lblPortaBd;
    public static Label lblDriver;
    public static Label lblUsuarioBd;
    public static Label lblSenhaBd;
    public static TextField txtNomeServidor;
    public static TextField txtNomeBd;
    public static TextField txtUsuarioBd;
    public static TextField txtSenhaBd;
    public static TextField txtPortaBd;
    public static ComboBox cbDriver;
    public static Button btnOk;
    public static Button btnCancelar;
    public static Button btnTesteConexaoBd;
    public static Stage inicio;
    public static Scene cenario;
    public static VBox painelPrincipal;
    public static GridPane painelDados;
    public static StackPane painelBordas;
    public static PrintWriter gravarArq;
    public static FileWriter arq;
    public static String resultado;
    public static String resultadoUrl;
    public static Properties config = new Properties();
    public static String arquivo = "C:\\documents\\NetBeansProjects\\Sistema\\dist\\ConfigBD.ini";//local do arquivo
    
    public static void show(String mensagem, String titulo) throws IOException{
        
            lblNomeServidor = new Label("Servidor:");
            lblNomeBd = new Label("Banco de Dados:");
            lblPortaBd = new Label("Porta:");
            lblDriver = new Label("Driver:");
            lblUsuarioBd = new Label("Usuario:");
            lblSenhaBd = new Label("Senha:");
            cbDriver = new ComboBox();

            lblNomeServidor.setStyle("-fx-font-weight: bold");
            lblNomeBd.setStyle("-fx-font-weight: bold");
            lblPortaBd.setStyle("-fx-font-weight: bold");
            lblDriver.setStyle("-fx-font-weight: bold");
            lblUsuarioBd.setStyle("-fx-font-weight: bold");
            lblSenhaBd.setStyle("-fx-font-weight: bold");
            
            txtNomeServidor = new TextField();
            txtNomeBd = new TextField();
            txtUsuarioBd = new TextField();
            txtSenhaBd = new TextField();
            txtPortaBd = new TextField();
            
            resultadoUrl = null;
            
            txtNomeServidor.setText(Exibir().getNomeServidor());
            txtNomeBd.setText(Exibir().getBancoDados());
            txtPortaBd.setText(Exibir().getPorta());
            cbDriver.setValue(Exibir().getDriver().replace("org.apache.derby.jdbc.EmbeddedDriver","JDBC").replace("com.mysql.jdbc.Driver","MySQL").replace("com.microsoft.sqlserver.jdbc.SQLServerDriver","SQL Server").replace("oracle.jdbc.driver.OracleDriver","Oracle"));
            txtUsuarioBd.setText(Exibir().getUsuario());
            txtSenhaBd.setText(Exibir().getSenha());
            
            btnOk = new Button("Ok");
            btnOk.setPrefWidth(80);
            btnCancelar = new Button("Cancelar");
            btnTesteConexaoBd = new Button("Teste Conexão");

            cbDriver.getItems().addAll("JDBC", "MySQL", "SQL Server", "Oracle");
            
            resultado = String.valueOf(cbDriver.getValue());
            
            cbDriver.setOnAction(e -> {
                if(resultado == "JDBC"){
                    resultado = "org.apache.derby.jdbc.EmbeddedDriver";
                    resultadoUrl = "jdbc:derby://";
                }else if(resultado == "MySQL"){
                    resultado = "com.mysql.jdbc.Driver";
                    resultadoUrl = "jdbc:mysql://";
                }else if(resultado == "SQL Server"){
                    resultado = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
                    resultadoUrl = "jdbc:sqlserver://";
                }else if(resultado == "Oracle"){
                    resultado = "oracle.jdbc.driver.OracleDriver";
                    resultadoUrl = "jdbc:oracle://";
                }
            });
            inicio = new Stage();
            painelPrincipal = new VBox();
            cenario = new Scene(painelPrincipal, 400, 245);
            painelDados = new GridPane();        
            painelBordas = new StackPane();
            
            painelDados.setVgap(5);
            painelDados.setHgap(5);
            
            painelDados.add(lblNomeServidor, 0, 0);
            painelDados.add(txtNomeServidor, 1, 0);
            painelDados.add(lblNomeBd, 0, 1);
            painelDados.add(txtNomeBd, 1, 1);
            painelDados.add(lblPortaBd, 0, 2);
            painelDados.add(txtPortaBd, 1, 2);
            painelDados.add(lblDriver, 0, 3);
            painelDados.add(cbDriver, 1, 3);
            painelDados.add(lblUsuarioBd, 0, 4);
            painelDados.add(txtUsuarioBd, 1, 4);
            painelDados.add(lblSenhaBd, 0, 5);
            painelDados.add(txtSenhaBd, 1, 5);
            painelDados.add(btnOk, 0, 6);
            painelDados.add(btnCancelar, 1, 6);            
            painelDados.add(btnTesteConexaoBd, 2, 6);            
            
            painelDados.setPadding(new Insets(10));
            
            painelBordas.setStyle("-fx-border-color: gray; -fx-border-insets: 10 9 9 9; -fx-padding: -7 5 5 5; -fx-border-radius: 2");

            btnOk.setGraphic(Login.imageViewSalvar);
            btnTesteConexaoBd.setGraphic(Login.imageViewTesteBd);
            btnTesteConexaoBd.setOnAction( e -> testeConexao.show("Status","Teste de Conexao do Banco de Dados"));
            btnOk.setOnAction(e -> {

                try {
                    btnOK();
                } catch (Exception ex) {
                    System.err.println(ex);
                }
                Login.tela2.close();
                inicio.close();
            });
            btnCancelar.setGraphic(Login.imageViewFechar);
            btnCancelar.setOnAction(e -> inicio.close());
            
            painelBordas.getChildren().addAll(painelDados);
            painelPrincipal.getChildren().addAll(painelBordas);
            
            inicio.setScene(cenario);
            inicio.setTitle(titulo);
            inicio.initModality(Modality.APPLICATION_MODAL);
            
            inicio.showAndWait();
    }
    
    public static void btnOK() throws Exception, Exception, Exception{
        
        Connection conexaoConfig = ConnectConfiguracao.getConexao();
        
        try{
            resultado = String.valueOf(cbDriver.getValue()).replace("JDBC","org.apache.derby.jdbc.EmbeddedDriver").replace("MySQL","com.mysql.jdbc.Driver").replace("SQL Server","com.microsoft.sqlserver.jdbc.SQLServerDriver").replace("Oracle","oracle.jdbc.driver.OracleDriver");
            resultadoUrl = String.valueOf(cbDriver.getValue()).replace("JDBC","jdbc:derby://").replace("MySQL","jdbc:mysql://").replace("SQL Server","jdbc:sqlserver://").replace("Oracle","jdbc:oracle://");
            Index index = new Index(); 
            String delsql = "DELETE FROM CONFIG_SERVIDOR;";
            String sql = "INSERT INTO CONFIG_SERVIDOR(SERVIDOR, PORTA, USUARIO, SENHA, DRIVER, BANCO_DADOS, URL) VALUES('"+txtNomeServidor.getText()+"','"+txtPortaBd.getText()+"','"+txtUsuarioBd.getText()+"','"+txtSenhaBd.getText()+"','"+resultado+"', '"+txtNomeBd.getText()+"','"+resultadoUrl+"');";
            PreparedStatement stmConfig = conexaoConfig.prepareStatement(sql);
            PreparedStatement stmDelConfig = conexaoConfig.prepareStatement(delsql);
            stmDelConfig.executeUpdate();
            stmConfig.executeUpdate();
            conexaoConfig.close();
            
        }catch(Exception ex){
            MessageBox.show(""+ex, "Erro");
        }
    }
    public static ConfigServidor Exibir(){
        
            ResultSet rs;
            ConfigServidor d = new ConfigServidor();
        
            try{
                Connection conexao = ConnectConfiguracao.getConexao();
                String consulta = "SELECT * FROM CONFIG_SERVIDOR;";
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
