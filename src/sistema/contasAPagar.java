package sistema;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
import javafx.scene.image.ImageView;

public class contasAPagar {
    	 
	 Label nrDoc = new Label("Nº Documento:");
	 Label Beneficiario = new Label("Beneficiário:");
	 Label dataEmissao = new Label("Data Emissão:");
	 Label dataVencimento = new Label("Data Vencimento:");
	 Label dataPagamento = new Label("Data Pagamento:");
	 Label valorDocumento = new Label("valor Documento:");
	 Label descAbatimento = new Label("Desc/Abatimento:");
	 Label jurosMulta = new Label("Juros/Multa:");
	 Label valorCobrado = new Label("Valor Cobrado:");
	 Label especieDocumento= new Label("Espécie Documento:");
	 Label moeda = new Label("Moeda:");
	 Label tipoDocumento = new Label("Tipo Documento:");
	 Label localPagamento = new Label("Local Pagamento:");
	 Label histProvisao = new Label("Histórico Provisão:");
	 Label historico = new Label("Histórico:");
	 Label condPagamento = new Label("Condição Pagamento:");

	 public static TextField NrDoc = new TextField();
	 public static ComboBox beneficiario = new ComboBox();
	 public static DatePicker DataEmissao = new DatePicker();
	 public static DatePicker DataVencimento = new DatePicker();
	 public static DatePicker DataPagamento = new DatePicker();
	 public static TextField ValorDocumento = new TextField();
	 public static TextField DescAbatimento = new TextField();
	 public static TextField JurosMulta = new TextField();
	 public static TextField ValorCobrado = new TextField();
	 public static ComboBox EspecieDocumento = new ComboBox();
	 public static TextField Moeda = new TextField();
	 public static ComboBox TipoDocumento = new ComboBox();
	 public static TextField LocalPagamento = new TextField();
	 public static TextField HistProvisao = new TextField();
	 public static TextField Historico = new TextField();
	 public static ComboBox CondPagamento = new ComboBox();
            
	 public static void show(String mensagem, String titulo){
             
                Stage ini = new Stage();
                GridPane painelDados = new GridPane();
                VBox painelPrincipal = new VBox(15);
                Scene cenario = new Scene(painelPrincipal, 500, 400);
             
		ini.setScene(cenario);
                ini.setTitle(titulo);                
                ini.initModality(Modality.APPLICATION_MODAL);
                Label msg = new Label(mensagem);
                painelPrincipal.getChildren().addAll(msg);
                ini.showAndWait();
	}    
}
