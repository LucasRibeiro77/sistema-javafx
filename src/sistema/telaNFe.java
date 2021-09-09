package sistema;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.geometry.*;
import javafx.event.*;

public class telaNFe {
    
        public static VBox painelTela2 = new VBox(15);
        public static VBox painelTela3 = new VBox(15);
        public static Scene cenario2 = new Scene(painelTela2, 250, 150);
        public static Scene cenario3 = new Scene(painelTela3, 580, 300);        
    	public static Label lblNumNFe = new Label("Numero NFe");
        public static Button btnCancelarTela2 = new Button("Cancelar");
        public static Button btnAvancar = new Button("Avancar");
        public static Stage tela2 = new Stage();
        public static TextField txtNumNFe = new TextField();
        public static HBox telaNumeracaoNFe = new HBox(15);
        public static HBox painelBotoesTela2 = new HBox(15);
                
        
        public static void show(String msg, String titulo){
            
                    txtNumNFe.setPrefWidth(80);
                    lblNumNFe.setStyle("-fx-font-weight: bold");        
                    painelTela3.setAlignment(Pos.BASELINE_LEFT);
                    Label msgs = new Label(msg);
                    tela2.setScene(cenario2);
                    tela2.setTitle(titulo);
                    tela2.initModality(Modality.APPLICATION_MODAL);
                    btnCancelarTela2.setOnAction(e -> tela2.close());
                    btnAvancar.setOnAction(e -> Avancar());
                    painelBotoesTela2.getChildren().addAll(btnCancelarTela2, btnAvancar);
                    telaNumeracaoNFe.getChildren().addAll(lblNumNFe, txtNumNFe);
                    painelTela2.setPadding(new Insets(15));
                    painelTela2.getChildren().addAll(msgs, telaNumeracaoNFe, painelBotoesTela2);
                    tela2.showAndWait();
                
        }
        public static void Avancar(){
                tela2.setScene(cenario3);
                tela2.show();
        }
}
