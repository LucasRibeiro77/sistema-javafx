package sistema;

import javafx.application.*;
import javafx.animation.*;
import javafx.stage.Stage;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.beans.*;
import javafx.beans.property.*;
import javafx.collections.*;
import java.sql.*;

public class NovoRegistro{
	
	

	public static void show(String texto, String Titulo){
		Stage inicio = new Stage();
		inicio.initModality(Modality.APPLICATION_MODAL);

//		static Image img = new Image( getClass().getResourceAsStream("vcsadded_93506.ico"));

                StackPane painel = new StackPane();
	
		Label texto1 = new Label(texto);

		TextField campo1 = new TextField();
		TextField campo2 = new TextField();

		Scene cenario = new Scene(painel, 600, 400);
		
		HBox painel3 = new HBox(5);
		
		VBox painel4 = new VBox(10);
		
		GridPane painel2 = new GridPane();



		Button btnInserir = new Button("Inserir");

		
		Label arg1 = new Label("Descrição");

		Label arg2 = new Label("Valor");
		
		Label arg3 = new Label("Tipo de Registro:");
		
		ComboBox Lista = new ComboBox();
		
		Lista.getItems().addAll(" ","Entrada", "Saida");

		campo2.setMinWidth(70);

		TableView<Conteudo> tabela = new TableView<Conteudo>();
		TableColumn<Conteudo, String> coluna1 = new TableColumn<Conteudo, String>("Tipo");
		coluna1.setMinWidth(70);
		coluna1.setCellValueFactory(new PropertyValueFactory<Conteudo, String>("Tipo"));

		TableColumn<Conteudo, String> coluna2 = new TableColumn<Conteudo, String>("Descricao");
		coluna2.setMinWidth(300);
		coluna2.setCellValueFactory(new PropertyValueFactory<Conteudo, String>("Descricao"));

		TableColumn<Conteudo, Double> coluna3 = new TableColumn<Conteudo, Double>("Valor");
		coluna3.setMinWidth(100);
		coluna3.setCellValueFactory(new PropertyValueFactory<Conteudo, Double>("Valor"));
		
				
		btnInserir.setOnAction(e -> 
		{
		if(Lista.getValue()=="Entrada"){

			Conteudo c = new Conteudo();
			c.setTipo("Entrada");
			c.setDescricao(campo1.getText());
			c.setValor(Double.parseDouble(campo2.getText()));
			tabela.getItems().add(c);
			campo1.clear();
			campo2.clear();
			Lista.setValue(" ");
		} else if(Lista.getValue()=="Saida"){

			Conteudo c = new Conteudo();
			c.setTipo("Saida");
			c.setDescricao(campo1.getText());
			c.setValor(Double.parseDouble(campo2.getText()));
			tabela.getItems().add(c);
			campo1.clear();
			campo2.clear();
			Lista.setValue(" ");
		} else {
			MessageBox.show("Valor não inserido", "Erro");
		}
			
		});

		
		inicio.setScene(cenario);
		inicio.setTitle(Titulo);
		tabela.getColumns().addAll(coluna1, coluna2, coluna3);
		tabela.setItems(ConteudoTabela());
	
		painel.setStyle(".bordered-titled-title {-fx-border-fill: #f00; -fx-padding: -8 5 5 5;-fx-border-style: solid; -fx-border-insets: 20 15 15 15; -fx-border-color: gray;}");

		texto1.setStyle("-fx-background-color: 	#F4F4F4;");

		painel.setAlignment(texto1, Pos.TOP_LEFT);

		painel2.setPadding(new Insets(15));
		

		painel2.setVgap(5);
		painel2.setHgap(5);
		
		painel2.add(arg1, 0, 0);
		painel2.add(campo1, 1, 0);
		painel2.add(arg2, 2, 0);
		painel2.add(campo2, 3, 0);
		painel2.add(btnInserir, 4, 0);

		painel3.getChildren().addAll(arg3, Lista);
		btnInserir.setStyle("-fx-image-pattern: url('vcsadded_93506.bmp');");
	
		arg1.setStyle("-fx-font-weight: bold");
		arg2.setStyle("-fx-font-weight: bold");
		arg3.setStyle("-fx-font-weight: bold");
		
		painel.getChildren().addAll(texto1, painel4);
		painel4.setPadding(new Insets(25));
		painel4.getChildren().addAll(painel3, painel2, tabela);		
		inicio.showAndWait();
	}

	public static ObservableList<Conteudo> ConteudoTabela()
	{
		ObservableList<Conteudo> dados = 
			FXCollections.observableArrayList();

		dados.add(new Conteudo("Saida","Pao",14.36));

		return dados;	
	}
}
