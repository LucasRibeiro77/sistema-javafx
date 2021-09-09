package sistema;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class testeConexao{
    
    public static ImageView imagemTesteBd;
    
	public static void show(String message, String title){
            
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		VBox pane = new VBox(10);
                HBox paneButtons = new HBox(10);
		Scene cena = new Scene(pane);
                imagemTesteBd = null;
                String resposta = String.valueOf(message+": "+Conexao.status);
                Label argumento = new Label(resposta);                
                argumento.setStyle("-fx-font-weight: bold");
                argumento.setFont(new Font(15));
                pane.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 170 0 0 0");
		Button btn = new Button("Concluido");
                btn.setGraphic(Login.imageViewOkConexaoBd);
		st.initModality(Modality.APPLICATION_MODAL);
		st.setTitle(title);
		st.setMinWidth(350);
		st.setMinHeight(270);
		st.setScene(cena);
                
		pane.setAlignment(Pos.CENTER);
		pane.setPadding(new Insets(20));
                
                if(Conexao.status == "Conectado com sucesso!\n\n\n\n"){
                    imagemTesteBd = Login.imageViewConexaoOkBd;
                    argumento.setTextFill(Color.GREEN);
                }else{
                    imagemTesteBd = Login.imageViewFalhaConexaoBd;
                    argumento.setTextFill(Color.RED);
                }
                paneButtons.setAlignment(Pos.BOTTOM_CENTER);
                btn.setAlignment(Pos.BOTTOM_CENTER);
                paneButtons.getChildren().addAll(btn);
		pane.getChildren().addAll(imagemTesteBd, argumento, paneButtons);
		btn.setOnAction(e -> st.close());
		st.showAndWait();
	}
}
