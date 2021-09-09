package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AbrirCaixa{
    
    public static TextField txtSaldoCaixa;
    public static Stage inicio;
    
    public static void show(String message, String title){
    
        inicio = new Stage();
        VBox painel = new VBox(5);
        HBox painel1 = new HBox(5);
        HBox painel2 = new HBox(5);
        HBox painel3 = new HBox(5);
        HBox painel4 = new HBox(5);
        VBox painelCampos = new VBox(5);
        Button btnSim = new Button("Sim");
        Button btnNao = new Button("_Não");
        Scene cenario = new Scene(painel, 350, 100);
        Label arg = new Label(message);
        Label lblSaldoFinal = new Label("Saldo Final      ");
        txtSaldoCaixa = new TextField();
        TextField txtSaldoFinal = new TextField();
        arg.setFont(new Font(11));
        arg.setStyle("-fx-font-weight: bold");
        lblSaldoFinal.setStyle("-fx-font-weight: bold");
        
        inicio.setScene(cenario);
        inicio.initModality(Modality.APPLICATION_MODAL);
        inicio.setTitle(title);
        btnSim.setOnAction(e -> 
        {
                InserirCaixa();
                Venda.show("", "Console de Vendas");
                inicio.close();
        });
    
        btnSim.setOnKeyPressed(evt -> 
        {
            if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                    InserirCaixa();
                    Venda.show("", "Console de Vendas");
                    inicio.close();
            }
        });

        btnNao.setOnKeyPressed(e -> 
        {
            if(btnNao.isFocused() == true && e.getCode() == KeyCode.ENTER){
                inicio.close();
            }
        });
    
        btnNao.setOnAction(e -> {
                inicio.close();
        });  
        
        txtSaldoFinal.setDisable(true);
        
        painelCampos.getChildren().addAll(painel3);
        painel1.getChildren().addAll(Login.imageViewCaixa, painelCampos);
        painel3.getChildren().addAll(arg, txtSaldoCaixa);
        painel2.getChildren().addAll(btnSim, btnNao);
        painel.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 60 0 0 0");
        painel.getChildren().addAll(painel1, painel2);
        
        painel.setPadding(new Insets(10));
        painel1.setAlignment(Pos.CENTER);
        painel2.setAlignment(Pos.BASELINE_RIGHT);
        
        inicio.showAndWait();
    }
    public static void FecharJanela(){
        inicio.close();
    }
    public static void InserirCaixa() {
                        
            try{
                Connection conexao = Conexao.getConexao();
                Index index = new Index();
                String sql = "INSERT INTO SALDO_TOTAL(ID, ABERTURA, DATA_HORA, USUARIO, STATUS) VALUES(default, '"+txtSaldoCaixa.getText().replace(",",".")+"', NOW(), '"+Login.campo1.getText()+"', 'ABERTO');";

                PreparedStatement stm = conexao.prepareStatement(sql);
                stm.execute(sql);
                
            }catch(Exception e){
                MessageBox.show(""+e, "Erro");
            }
    }
}

