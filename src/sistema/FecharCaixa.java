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

/**
 *
 * @author LUCAS
 */
public class FecharCaixa {
    
    public static TextField txtSaldoCaixa;
    
    public static void show(String message, String title){
    
        Stage inicio = new Stage();
        VBox painel = new VBox(5);
        HBox painel1 = new HBox(5);
        HBox painel2 = new HBox(5);
        HBox painel3 = new HBox(5);
        HBox painel4 = new HBox(5);
        VBox painelCampos = new VBox(5);
        Button btnSim = new Button("Sim");
        Button btnNao = new Button("_Não");
        Scene cenario = new Scene(painel, 350, 120);
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
                FechamentoCaixa();
                inicio.close();
        });
    
        btnSim.setOnKeyPressed(evt -> 
        {
            if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                    FechamentoCaixa();
                    inicio.close();
            }
        });

        btnNao.setOnKeyPressed(e -> 
        {
            if(btnNao.isFocused() == true && e.getCode() == KeyCode.ENTER){
                    //Venda.txtBuscarProduto.requestFocus();
                    inicio.close();
            }
        });
    
        btnNao.setOnAction(e -> {
                //Venda.txtBuscarProduto.requestFocus();
                inicio.close();
        });  
        
        txtSaldoFinal.setDisable(true);
        
        painelCampos.getChildren().addAll(painel3, painel4);
        painel1.getChildren().addAll(Login.imageViewCaixa, painelCampos);
        painel3.getChildren().addAll(arg, txtSaldoCaixa);
        painel4.getChildren().addAll(lblSaldoFinal, txtSaldoFinal);
        painel2.getChildren().addAll(btnSim, btnNao);
        painel.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 70 0 0 0");
        painel.getChildren().addAll(painel1, painel2);
        
        painel.setPadding(new Insets(10));
        painel1.setAlignment(Pos.CENTER);
        painel2.setAlignment(Pos.BASELINE_RIGHT);
        
        inicio.showAndWait();
    }
    public static void FechamentoCaixa() {
                        
                        try{

                            Connection conexao = Conexao.getConexao();

                            Index index = new Index();

                            String sql = "UPDATE SALDO_TOTAL SET FECHAMENTO = '"+txtSaldoCaixa.getText().replace(",",".")+"' WHERE STATUS = 'ABERTO' AND USUARIO = '"+Login.campo1.getText()+"';";
                            
                            String mysql = "UPDATE SALDO_TOTAL SET TOTAL = TOTAL_VENDIDO + CARGA - SANGRIA, DATA_HORA = NOW(), USUARIO = '"+Login.campo1.getText()+"', STATUS = 'FECHADO' WHERE STATUS = 'ABERTO' AND USUARIO = '"+Login.campo1.getText()+"';";

                            PreparedStatement stm = conexao.prepareStatement(sql);
                            
                            PreparedStatement stmsql = conexao.prepareStatement(mysql);

                            stm.execute(sql);
                            
                            stmsql.execute(mysql);
                            
                            int numero = Integer.parseInt(String.valueOf(Venda.acessoPDV()).replace("[","").replace("]",""));
                            Venda.barraStatusCaixa.setStyle("-fx-border-color: #D3D3D3; -fx-border-solid: 1; -fx-border-padding: -20 5 5 5;-fx-background-color: red;");
                            Venda.lblStatusCaixa.setText("PDV nº "+String.format("%05d", numero)+" - CAIXA FECHADO");

                        }catch(Exception e){
                            MessageBox.show(""+e, "Erro");
                        }
            }    
}
