package sistema;

import java.io.*;
import java.text.SimpleDateFormat;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import java.util.Date;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;

public class CancelarProtocoloAnterior {
        
        public static TableView<DadosCancelarProtocolo> tabela; 
        public static TableColumn<DadosCancelarProtocolo, String> tabelaColuna1;
        public static TableColumn<DadosCancelarProtocolo, String> tabelaColuna2;
        public static TableColumn<DadosCancelarProtocolo, String> tabelaColuna3;        
        public static TextField txtBuscarProtocolo;
        
        public static void show(String message, String title) throws IOException, Exception{
                
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
                
                txtBuscarProtocolo = new TextField();
                
                tabela = new TableView();
                tabelaColuna1 = new TableColumn<DadosCancelarProtocolo, String>("Protocolo");
                tabelaColuna1.setMinWidth(100);
                tabelaColuna1.setCellValueFactory(new PropertyValueFactory<DadosCancelarProtocolo, String>("protocolo"));
                tabelaColuna2 = new TableColumn<DadosCancelarProtocolo, String>("Chave xml");
                tabelaColuna2.setMinWidth(310);
                tabelaColuna2.setCellValueFactory(new PropertyValueFactory<DadosCancelarProtocolo, String>("chaveNfe"));
                tabelaColuna3 = new TableColumn<DadosCancelarProtocolo, String>("Data");
                tabelaColuna3.setMinWidth(125);
                tabelaColuna3.setCellValueFactory(new PropertyValueFactory<DadosCancelarProtocolo, String>("data"));
                
		VBox pane = new VBox(10);
                HBox painelBuscar = new HBox(5);
                HBox painelAviso = new HBox(5);
                HBox painelBotao = new HBox(5);
		Scene cena = new Scene(pane, 590, 200);
		Label lbl = new Label(message);
		Button btn = new Button("F_echar");
                Button btnCancelar = new Button("_Cancelar");
                
		st.initModality(Modality.APPLICATION_MODAL);
		st.setTitle(title);
		st.setMinWidth(580);
		st.setMinHeight(50);
		st.setScene(cena);
                tabela.setPrefHeight(120);
                tabela.setPrefWidth(540);
                tabela.getColumns().addAll(tabelaColuna1, tabelaColuna2, tabelaColuna3);
                tabela.setItems(listarArquivos());
		pane.setAlignment(Pos.CENTER);
                painelAviso.setAlignment(Pos.CENTER);
                lbl.setFont(new Font(11));
                lbl.setStyle("-fx-font-weight: bold");
		pane.setPadding(new Insets(20));
                painelAviso.getChildren().addAll(tabela);
                painelBotao.setAlignment(Pos.BASELINE_RIGHT);
                pane.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 200 0 0 0");
                painelBotao.setMaxWidth(650);
                painelBotao.setAlignment(Pos.CENTER);
                painelBuscar.getChildren().addAll(lbl, txtBuscarProtocolo);
                painelBotao.getChildren().addAll(btnCancelar, btn);
		pane.getChildren().addAll(painelBuscar, painelAviso, painelBotao);
                
		btn.setOnAction(e -> st.close());
                //btnCancelar.setOnAction(e -> listarArquivos());
                btn.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        st.close();
                    }    
                });
		st.showAndWait();
	}
        public static ObservableList<DadosCancelarProtocolo> listarArquivos() throws Exception{
            
                ObservableList<DadosCancelarProtocolo> dados = FXCollections.observableArrayList();
            
		int i = 0;
		File arq = new File("C:\\Users\\USER\\Documents\\Sistema\\dist\\xml\\");
		File arquivos[] = arq.listFiles();
                                
		while (i != arquivos.length){
                        FileReader reader = new FileReader(arquivos[i]);
                        BufferedReader leitor = new BufferedReader(reader);
                    
                        SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                        Date d = new Date(arquivos[i].lastModified());
                        
			String nome = arquivos[i].getName();
                        String data = sd.format(d);
                        String protocolo = "";
                        i++;

                        while ((protocolo = leitor.readLine()) != null) {
                                if (protocolo.contains("<nNF>") && protocolo.contains("</nNF>")) {
                                        dados.add(new DadosCancelarProtocolo(""+protocolo.replaceAll("<nNF>", "").replaceAll("</nNF>", ""),""+nome.replace(".xml","").replace(".txt","").replace(".jar","").replace("NFe","").replace(".TXT","").replaceAll("- Cópia",""), String.valueOf(data)));
                                }
                        }		
		}
                return dados;
	}
}
