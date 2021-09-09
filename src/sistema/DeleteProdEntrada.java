package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Font;

public class DeleteProdEntrada {
    
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
                carga.btnExcluir();
                inicio.close();
        });
    
        btnSim.setOnKeyPressed(evt -> 
        {
            if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                carga.btnExcluir();
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
