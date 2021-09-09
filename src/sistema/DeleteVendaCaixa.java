package sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DeleteVendaCaixa {
    
        public static void show(String message, String title){
            
            Stage inicio = new Stage();
            VBox painel = new VBox(5);
            HBox painel1 = new HBox(5);
            HBox painel2 = new HBox(5);
            Button btnSim = new Button("Sim");
            Button btnNao = new Button("_Não");
            Scene cenario = new Scene(painel, 350, 120);
            Label arg = new Label(message);
            arg.setFont(new Font(11));
            arg.setStyle("-fx-font-weight: bold");

            inicio.setScene(cenario);
            inicio.initModality(Modality.APPLICATION_MODAL);
            inicio.setTitle(title);
            btnSim.setOnAction(e -> 
            {
                    Venda.VerificarPermissao2();
                    inicio.close();
            });

            btnSim.setOnKeyPressed(evt -> 
            {
                if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                    Venda.VerificarPermissao2();
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

            painel1.getChildren().addAll(Login.imageViewAviso, arg);
            painel2.getChildren().addAll(btnSim, btnNao);
            painel.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 70 0 0 0");
            painel.getChildren().addAll(painel1, painel2);

            painel.setPadding(new Insets(10));
            painel1.setAlignment(Pos.CENTER);
            painel2.setAlignment(Pos.BASELINE_RIGHT);

            inicio.showAndWait();
        }
    
}
