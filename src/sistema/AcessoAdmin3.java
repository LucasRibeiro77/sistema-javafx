package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AcessoAdmin3 {
    
    public static MaskedTextField txtUsuario;
    public static PasswordField txtSenha;
    
    public static void show(String message, String title){
        
        Stage inicio = new Stage();
        VBox painel = new VBox(5);
        HBox painel1 = new HBox(5);
        HBox painel2 = new HBox(5);
        HBox painel3 = new HBox(5);
        Button btnSim = new Button("Ok");
        Button btnNao = new Button("_Cancelar");
        Scene cenario = new Scene(painel, 240, 115);
        Label arg = new Label(message);
        Label lblUsuario = new Label("Usuário: ");
        Label lblSenha = new Label("Senha:   ");
        txtUsuario = new MaskedTextField("UUUUUUUUUU");
        txtSenha = new PasswordField();
        arg.setFont(new Font(11));
        lblUsuario.setStyle("-fx-font-weight: bold");
        lblSenha.setStyle("-fx-font-weight: bold");
        
        inicio.setScene(cenario);
        inicio.initModality(Modality.APPLICATION_MODAL);
        inicio.setTitle(title);
        btnSim.setOnAction(e -> 
        {
                ConcederPermissao();
                inicio.close();
        });
    
        btnSim.setOnKeyPressed(evt -> 
        {
            if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                ConcederPermissao();
                inicio.close();
            }
        });

        btnNao.setOnKeyPressed(e -> 
        {
            if(btnNao.isFocused() == true && e.getCode() == KeyCode.ENTER){
                inicio.close();
            }
        });
    
        btnNao.setOnAction(e -> inicio.close());  
        
        painel1.getChildren().addAll(lblUsuario, txtUsuario);
        painel2.getChildren().addAll(lblSenha, txtSenha);
        painel3.getChildren().addAll(btnSim, btnNao);
        painel.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 70 0 0 0");
        painel.getChildren().addAll(painel1, painel2, painel3);
        
        painel.setPadding(new Insets(10));
        painel3.setPadding(new Insets(10));
        painel1.setAlignment(Pos.CENTER);
        painel2.setAlignment(Pos.CENTER);
        painel3.setAlignment(Pos.BASELINE_RIGHT);
        
        inicio.showAndWait();
    }
    public static boolean ConcederPermissao(){
        int cont = 0;
        boolean verificador = false;
        Connection conexao = Conexao.getConexao();
        
        try {
            String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+txtUsuario.getText()+"' AND PASS = '"+txtSenha.getText()+"' AND CARGO = 'Administrador'";
        
            PreparedStatement stm = conexao.prepareStatement(sql);
        
            ResultSet rs = stm.executeQuery(sql);
                      
            while(rs.next()){
                cont = rs.getInt("cont");
            }
            if(cont == 1){
                verificador = true;
                Venda.btnDesconto();            
            } else{
                 MessageBox.show("Usuário ou senha incorretos\n\n ou este usuário não é administrador.","Erro");
            }
        } catch (Exception ex) {
            MessageBox.show(""+ex,"Erro");
        }
        return verificador;
    }
}
