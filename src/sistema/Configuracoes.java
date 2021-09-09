package sistema;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import java.security.KeyStore;  
import java.security.KeyStoreException;  
import java.security.NoSuchAlgorithmException;  
import java.security.NoSuchProviderException;  
import java.security.cert.CertificateException;  
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.KeyFactory;
import java.text.SimpleDateFormat;
import java.util.List;
import java.security.KeyStore;  
import java.security.PublicKey;
import java.security.cert.X509Certificate;  
import java.security.spec.X509EncodedKeySpec;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;  
import java.util.Enumeration;  

public class Configuracoes {
    
    public static PublicKey pk;
    public static String resultado;
    public static String resultadoUrl;    
    public static Stage inicio;
    public static VBox painelPrincipal;
    public static HBox linha1;
    public static HBox linha2;
    public static HBox linha3;
    public static HBox linha1Ambiente;
    public static HBox linha1Proxy;
    public static HBox linha2Proxy;
    public static HBox linha1Email;
    public static HBox linha2Email;
    public static HBox linha3Email;
    public static HBox linha4Email;
    public static HBox linha5Email;
    public static Scene cenario;
    public static TabPane painelAbas;
    public static StackPane bordaWebService;
    public static StackPane bordaProxy;
    public static StackPane bordaAmbiente;
    public static StackPane bordaEmail;
    public static VBox painelWebService;
    public static VBox painelProxy;
    public static VBox painelAmbiente;
    public static VBox painelEmail;
    public static Tab tabNFe;
    public static Tab tabFormasPagamento;
    public static Tab tabCFe;
    public static Tab tabGeral;
    public static Tab tabCFOP;
    public static Tab tabCaixa;
    public static Button btnFechar;
    public static Button btnOk;
    public static ComboBox cbFormaEmissao;
    public static ComboBox cbTipoImpressao;
    public static ComboBox cbAmbiente;
    public static ComboBox<DadosEstado> cbUF;
    public static ComboBox<DadosMunicipio> cbMunicipio;
    public static ComboBox <DadosCertificado>cbCertificados;
    public static ComboBox cbDestinoOperacao;
    public static GridPane painelAbaNFe;
    public static TextField txtVersaoXml;
    public static TextField txtHost;
    public static TextField txtPorta;
    public static TextField txtUsuario;
    public static PasswordField txtSenha;
    public static String consultaCidade;
    public static String consultaEstado;
    public static ResultSet rs;
    public static Statement stm;
    public static Label lblFormaEmissao;
    public static Label lblTipoImpressao;
    public static Label lblVersaoXml;
    public static Label lblUF;
    public static Label lblMunicipio;
    public static Label lblAmbiente;
    public static Label lblHost;
    public static Label lblPorta;
    public static Label lblUsuario;
    public static Label lblSenha;
    public static Label lblProxy;
    public static Label lblWebService;
    public static Label lblEmail;
    public static Label lblCertificado;
    public static Label lblDestinoOperacao;
    public static SimpleDateFormat dateFormat;  
    
    public static void show(String mensagem, String Titulo) throws KeyStoreException, IOException, NoSuchAlgorithmException, NoSuchAlgorithmException, NoSuchAlgorithmException{
        
        inicio = new Stage();
        consultaEstado = "SELECT SIGLA_UF FROM MUNICIPIOS GROUP BY SIGLA_UF ORDER BY SIGLA_UF";
        consultaCidade = "SELECT MUNICIPIO FROM MUNICIPIOS ORDER BY MUNICIPIO";
        bordaWebService = new StackPane();
        bordaProxy = new StackPane();
        bordaAmbiente = new StackPane();
        bordaEmail = new StackPane();
        painelWebService = new VBox();
        painelProxy = new VBox(5);
        painelAmbiente = new VBox();
        painelEmail = new VBox();
        linha1 = new HBox(5);
        linha2 = new HBox(5);
        linha3 = new HBox(5);
        linha1Ambiente = new HBox(5);
        linha1Proxy = new HBox(5);
        linha2Proxy = new HBox(5);
        linha1Email = new HBox(5);
        linha2Email = new HBox(5);
        linha3Email = new HBox(5);
        linha4Email = new HBox(5);
        linha5Email = new HBox(5);
        txtHost = new TextField();
        txtPorta = new TextField();
        txtUsuario = new TextField();
        txtSenha = new PasswordField();
        painelPrincipal = new VBox(5);
        cenario = new Scene(painelPrincipal, 750, 400);
        painelAbas = new TabPane();
        tabNFe = new Tab("NF-e");
        tabFormasPagamento = new Tab("Formas de Pagamento");
        tabCFe = new Tab("CF-e");
        tabGeral = new Tab("Geral");
        tabCFOP = new Tab("CFOP");
        tabCaixa = new Tab("Caixa/PDV");
        btnFechar = new Button("Fechar");
        btnOk = new Button("OK");
        lblFormaEmissao = new Label("Forma Emissão");
        lblTipoImpressao = new Label("Tipo Impressão");
        lblVersaoXml = new Label("Versão XML");
        lblUF = new Label("       UF");
        lblMunicipio = new Label("Município");
        lblAmbiente = new Label("     Ambiente de Destino        ");
        lblHost = new Label("Host     ");
        lblPorta = new Label("Porta ");
        lblUsuario = new Label("Usuário");
        lblSenha = new Label("Senha");
        lblWebService = new Label("Web Service");
        lblProxy = new Label("Proxy");
        lblEmail = new Label("E-mail");
        lblCertificado = new Label("Certificados     ");
        lblDestinoOperacao = new Label("Destino Operação");
        dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        cbFormaEmissao = new ComboBox();
        cbTipoImpressao = new ComboBox();
        cbAmbiente = new ComboBox();
        cbCertificados = new ComboBox<DadosCertificado>();
        cbDestinoOperacao = new ComboBox();
        cbUF = new ComboBox<DadosEstado>();
        cbMunicipio = new ComboBox<DadosMunicipio>();
        painelAbaNFe = new GridPane();
        txtVersaoXml = new TextField();
        
        lblFormaEmissao.setStyle("-fx-font-weight: bold");
        lblTipoImpressao.setStyle("-fx-font-weight: bold");
        lblVersaoXml.setStyle("-fx-font-weight: bold");
        lblHost.setStyle("-fx-font-weight: bold");
        lblPorta.setStyle("-fx-font-weight: bold");
        lblUsuario.setStyle("-fx-font-weight: bold");
        lblSenha.setStyle("-fx-font-weight: bold");
        lblMunicipio.setStyle("-fx-font-weight: bold");
        lblUF.setStyle("-fx-font-weight: bold");
        lblAmbiente.setStyle("-fx-font-weight: bold");
        lblCertificado.setStyle("-fx-font-weight: bold");
        lblDestinoOperacao.setStyle("-fx-font-weight: bold");
        
        txtVersaoXml.setText("4.00");
        txtVersaoXml.setDisable(true);
        txtVersaoXml.setPrefWidth(50);
        
        cbDestinoOperacao.getItems().addAll("Operacao interna", "Operacao interestadual", "Operacao com exterior");
        linha1.getChildren().addAll(lblFormaEmissao, cbFormaEmissao, lblTipoImpressao, cbTipoImpressao, lblVersaoXml, txtVersaoXml);
        linha2.getChildren().addAll(lblUF, cbUF, lblMunicipio, cbMunicipio);
        linha3.getChildren().addAll(lblCertificado, cbCertificados, lblDestinoOperacao, cbDestinoOperacao);
        linha1Ambiente.getChildren().addAll(lblAmbiente, cbAmbiente);
        linha1Proxy.getChildren().addAll(lblHost, txtHost, lblPorta, txtPorta);
        linha2Proxy.getChildren().addAll(lblUsuario, txtUsuario, lblSenha, txtSenha);
        linha1Email.getChildren().addAll();
        linha2Email.getChildren().addAll();
        linha3Email.getChildren().addAll();
        linha4Email.getChildren().addAll();
        linha5Email.getChildren().addAll();

        painelProxy.getChildren().addAll(linha1Proxy, linha2Proxy);
        painelAmbiente.getChildren().addAll(linha1Ambiente);
        painelEmail.getChildren().addAll(linha1Email, linha2Email, linha3Email, linha4Email, linha5Email);        
        lblWebService.setStyle("-fx-background-color: #F4F4F4");
        lblEmail.setStyle("-fx-background-color: #F4F4F4");
        lblProxy.setStyle("-fx-background-color: #F4F4F4");
        bordaWebService.setAlignment(lblWebService, Pos.TOP_LEFT);
        bordaProxy.setAlignment(lblProxy, Pos.TOP_LEFT);
        bordaEmail.setAlignment(lblEmail, Pos.TOP_LEFT);
        bordaWebService.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -8 5 5 5");
        bordaAmbiente.setStyle("-fx-border-radius: 2; -fx-border-insets: 10 15 15 15; -fx-padding: 5 5 5 5");
        bordaProxy.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -8 5 5 5");
        
        bordaWebService.getChildren().addAll(lblWebService, painelWebService);
        bordaProxy.getChildren().addAll(lblProxy, painelProxy);
        bordaAmbiente.getChildren().addAll(painelAmbiente);
        bordaEmail.getChildren().addAll(lblEmail, painelEmail);
        cbCertificados.setItems(DadosCertificadoRepositorioWindows());
        
        painelWebService.getChildren().addAll(linha2, bordaAmbiente, bordaProxy);
        painelWebService.setPadding(new Insets(15));
        painelProxy.setPadding(new Insets(15));
        painelEmail.setPadding(new Insets(15));

        painelAbaNFe.setVgap(5);
        painelAbaNFe.setHgap(5);
        painelAbaNFe.add(linha1, 0, 0);
        painelAbaNFe.add(linha3, 0, 1);
        painelAbaNFe.add(bordaWebService, 0, 2);
        painelAbaNFe.add(bordaEmail, 0, 4);

        inicio.setScene(cenario);
        inicio.setTitle(Titulo);
        inicio.initModality(Modality.APPLICATION_MODAL);
        
        btnFechar.setOnAction( e -> inicio.close());
        
        cbFormaEmissao.getItems().addAll("Normal", "Contingencia FS-IA", "Contingencia via EPEC", "Contingencia FS-DA", "Contingencia SVC-AN", "Contingencia SVC-RS");
        cbTipoImpressao.getItems().addAll("Retrato", "Paisagem");
        cbAmbiente.getItems().addAll("Homologacao", "Producao");
        
        painelAbaNFe.setPadding(new Insets(10));
        
        cbMunicipio.setConverter(new StringConverter<DadosMunicipio>(){
        @Override 
        public String toString(DadosMunicipio object){
            if(object!=null){
                return object.getMunicipio();
            }
            return null;
        }
        @Override
        public DadosMunicipio fromString(String String){
            return null;
            }
        });
        cbMunicipio.getItems().addAll(ListaMunicipio());
        
        cbUF.setConverter(new StringConverter<DadosEstado>(){
        @Override
        public String toString(DadosEstado object){
            if(object!=null){
                return object.getNome();
            }
            return null;
        }
        @Override
        public DadosEstado fromString(String String){
            return null;
            }
        });
        cbUF.getItems().addAll(ListaUF());

        tabNFe.setContent(painelAbaNFe);
        
        tabNFe.setClosable(false);
        tabFormasPagamento.setClosable(false);
        tabCFe.setClosable(false);
        tabGeral.setClosable(false);
        tabCFOP.setClosable(false);
        tabCaixa.setClosable(false);
        
        DadosEstado UF = new DadosEstado(DadosConfigNFe().getUF());
        DadosMunicipio municipio = new DadosMunicipio(DadosConfigNFe().getMunicipio());
        DadosCertificado certificado = new DadosCertificado(DadosConfigNFe().getCertificado());

        cbMunicipio.setValue(municipio);
        cbUF.setValue(UF);
        cbCertificados.setValue(certificado);
        cbFormaEmissao.setValue(DadosConfigNFe().getFormaEmissao());
        cbTipoImpressao.setValue(DadosConfigNFe().getTipoImpressao());
        cbDestinoOperacao.setValue(DadosConfigNFe().getDestinoOperacao());
        cbAmbiente.setValue(DadosConfigNFe().getAmbiente());
        txtHost.setText(DadosConfigNFe().getHost());
        txtPorta.setText(DadosConfigNFe().getPorta());
        txtUsuario.setText(DadosConfigNFe().getUsuario());
        txtSenha.setText(DadosConfigNFe().getSenha());

        
        btnOk.setOnAction(e -> {
            try {
                btnOk();
            } catch (SQLException ex) {
                Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(Configuracoes.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        painelAbas.getTabs().addAll(tabGeral, tabCaixa, tabFormasPagamento, tabCFe, tabNFe, tabCFOP);
        painelPrincipal.getChildren().addAll(painelAbas, btnFechar, btnOk);
        
        inicio.showAndWait();
    }
    public static ObservableList<DadosMunicipio> ListaMunicipio(){
	ObservableList<DadosMunicipio> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(consultaCidade);
		rs = stm.executeQuery(consultaCidade);

		while(rs.next()){
			String municipio = rs.getString("MUNICIPIO");

			data.add(new DadosMunicipio(municipio));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }
    public static ObservableList<DadosEstado> ListaUF(){
	ObservableList<DadosEstado> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(consultaEstado);
		rs = stm.executeQuery(consultaEstado);

		while(rs.next()){
			String nome = rs.getString("SIGLA_UF");

			data.add(new DadosEstado(nome));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }
    public static void btnOk() throws SQLException, Exception{

        Connection conexaoConfig;

	DadosEstado UF = cbUF.getSelectionModel().getSelectedItem();
	DadosCertificado certificado = cbCertificados.getSelectionModel().getSelectedItem();
	DadosMunicipio municipio = cbMunicipio.getSelectionModel().getSelectedItem();

	try{
        	conexaoConfig = ConnectConfiguracao.getConexao();
                String delsql = "DELETE FROM CONFIG_NFE;";
		String sql = "INSERT INTO CONFIG_NFE(FORMA_EMISSAO,TIPO_IMPRESSAO,CERTIFICADO_DIGITAL,DESTINO_OPERACAO,UF,MUNICIPIO,AMBIENTE,HOST,PORTA,USUARIO,SENHA) VALUES('"+cbFormaEmissao.getValue()+"','"+cbTipoImpressao.getValue()+"','"+certificado.getCertificado()+"','"+cbDestinoOperacao.getValue()+"','"+UF.getNome()+"','"+municipio.getMunicipio()+"','"+cbAmbiente.getValue()+"','"+txtHost.getText()+"','"+txtPorta.getText()+"','"+txtUsuario.getText()+"','"+txtSenha.getText()+"');";
		PreparedStatement stm = conexaoConfig.prepareStatement(sql);
                PreparedStatement stmDelConfig = conexaoConfig.prepareStatement(delsql);
                stmDelConfig.executeUpdate();
		stm.executeUpdate();
                
        }catch(SQLException ex){
            MessageBox.show(""+ex, "Erro");
        }
    }
    public static DadosConfigNFe DadosConfigNFe(){
            ResultSet rs;
            DadosConfigNFe d = new DadosConfigNFe();

            try{
                Connection conexao = ConnectConfiguracao.getConexao();
                String consulta = "SELECT * FROM CONFIG_NFE;";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery();

                while(rs.next()){
                    d.setFormaEmissao(rs.getString("FORMA_EMISSAO"));
                    d.setTipoImpressao(rs.getString("TIPO_IMPRESSAO"));
                    d.setDestinoOperacao(rs.getString("DESTINO_OPERACAO"));
                    d.setUF(rs.getString("UF"));
                    d.setMunicipio(rs.getString("MUNICIPIO"));
                    d.setCertificado(rs.getString("CERTIFICADO_DIGITAL"));
                    d.setAmbiente(rs.getString("AMBIENTE"));
                    d.setHost(rs.getString("HOST"));
                    d.setPorta(rs.getString("PORTA"));
                    d.setUsuario(rs.getString("USUARIO"));
                    d.setSenha(rs.getString("SENHA"));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return d;
    }

    public static ObservableList<DadosCertificado> DadosCertificadoRepositorioWindows(){  
      
        ObservableList<DadosCertificado> dados = FXCollections.observableArrayList();  
        
        try {  
            KeyStore keyStore = KeyStore.getInstance("Windows-MY", "SunMSCAPI");  
            keyStore.load(null, null);  
              
            Enumeration <String> al = keyStore.aliases();  
            while (al.hasMoreElements()) {  
                String alias = al.nextElement();  
                info("--------------------------------------------------------");  
                if (keyStore.containsAlias(alias)) {  
                    info("Emitido para........: " + alias);  
  
                    X509Certificate cert = (X509Certificate) keyStore.getCertificate(alias);  
                    info("SubjectDN...........: " + cert.getSubjectDN().toString());  
                    info("Version.............: " + cert.getVersion());  
                    info("SerialNumber........: " + cert.getSerialNumber());  
                    info("SigAlgName..........: " + String.valueOf(cert.getSigAlgName()).replace("with",""));  
                    info("Válido a partir de..: " + dateFormat.format(cert.getNotBefore()));  
                    info("Válido até..........: " + dateFormat.format(cert.getNotAfter())); 
                    info("Válido até..........: " + cert.getKeyUsage());
                    info("Válido até..........: " + cert.getExtendedKeyUsage());
                    info("Válido até..........: " + cert.getPublicKey().hashCode());
                    info("Válido até..........: " + cert.getSignature().hashCode());
                    info("Válido até..........: " + cert.getSignature().hashCode());
                    info("Válido até..........: " + cert.hashCode());
                    info("Válido até..........: " + cert.getEncoded());
                    dados.add(new DadosCertificado(alias));
                } else {  
                    info("Alias doesn't exists : " + alias);  
                }  
            }  
        } catch (Exception e) {  
            error(e.toString());  
        }  
        return dados;
    }  
    
    private static void info(String log) {  
        System.out.println("INFO: " + log);  
    }  
  
    private static void error(String log) {  
        System.out.println("ERROR: " + log);  
    }  
}
