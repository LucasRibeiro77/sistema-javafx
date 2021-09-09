package sistema;

import java.io.*;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import static sistema.FecharVenda.lblValorTotal;
import static sistema.Venda.lblValorTotalDesconto;
  

public class MessageBoxTroco{
    
        
    
	public static void show(String message, String title){
                
                Rectangle painelIcone = new Rectangle(100, 40);
                
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		VBox pane = new VBox(10);
                HBox painelAviso = new HBox(5);
                HBox painelBotao = new HBox(5);
		Scene cena = new Scene(pane);
		Label lbl = new Label(message);
		Button btn = new Button("Fechar");
                
		st.initModality(Modality.APPLICATION_MODAL);
		st.setTitle(title);
		st.setMinWidth(250);
		st.setMinHeight(100);
		st.setScene(cena);
		pane.setAlignment(Pos.CENTER);
                painelAviso.setAlignment(Pos.CENTER);
                lbl.setFont(new Font(16));
                lbl.setStyle("-fx-font-weight: bold");
		pane.setPadding(new Insets(20));
                painelAviso.getChildren().addAll(Login.imageViewTroco, lbl);
                painelBotao.setAlignment(Pos.BASELINE_RIGHT);
                pane.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 80 0 0 0");
                painelBotao.setMaxWidth(650);
                painelBotao.getChildren().addAll(btn);
		pane.getChildren().addAll(painelAviso, painelBotao);
                double total = Double.valueOf(String.valueOf(Venda.TotalizadoresNota()).replace("[", "").replace("]", ""));
                
		btn.setOnAction(e -> {
                    st.close();
                    Venda.lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                });
                btn.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){                
                        st.close();
                        Venda.lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                    }    
                });
		st.showAndWait();
	}
}
