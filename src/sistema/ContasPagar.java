package sistema;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.sql.Connection;
import java.sql.ResultSet;
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import java.text.DateFormat.*;
import java.text.SimpleDateFormat.*;
import java.util.*;
import java.util.Calendar;
import java.util.Date;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.*;
import javafx.event.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.scene.control.MultipleSelectionModel;
import java.util.function.Consumer;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.util.StringConverter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ContasPagar{

	public static Label msg;
	public static Label lblNrDoc;
	public static Label lblBeneficiario;
	public static Label lblDataEmissao;
	public static Label lblDataVencimento;
	public static Label lblDataPagamento;
	public static Label lblValorDocumento;
	public static Label lblDescAbatimento;
	public static Label lblJurosMulta;
	public static Label lblValorCobrado;
	public static Label lblEspecieDocumento;
	public static Label lblMoeda;
	public static Label lblLocalPagamento;
	public static Label lblDescricao;
	public static Label lblFormaPagamento;
        public static Label lblDataInicio;
        public static Label lblDataFim;
        public static Label lblCodBarras;
        public static Label lblStatus;
        public static Label lblFiltro;
        public static Label lblValorSelecionado;
        public static Connection con;
	public static TextField txtNrDoc;
	public static ComboBox cbBeneficiario;
	public static DatePicker txtDataEmissao;
	public static DatePicker txtDataVencimento;
	public static DatePicker txtDataPagamento;
        public static DatePicker txtDataInicio;
        public static DatePicker txtDataFim;
        public static ComboBox cbStatus;
	public static TextField txtValorDocumento;
	public static TextField txtDescAbatimento;
	public static TextField txtJurosMulta;
	public static TextField txtValorCobrado;
	public static ComboBox cbEspecieDocumento;
	public static ComboBox cbMoeda;
	public static TextField txtLocalPagamento;
	public static TextField txtDescricao;
	public static ComboBox cbFormaPagamento;
        public static TextField txtCodBarras;
        public static Stage inicio;
        public static GridPane painelDados;
        public static VBox painelPrincipal;
        public static HBox linha1;
        public static HBox linha2;
        public static HBox linha3;
        public static HBox linha4;
        public static HBox linha5;
        public static HBox linhaFiltro;
        public static StackPane painelBotoes;
        public static StackPane painelDadosBorda;
        public static StackPane painelFiltro;
        public static HBox linhaBotoes;
        public static Scene cenario;
        public static TableView<DadosContasPagar> tabela;
        public static Button btnAdicionar;
        public static Button btnBaixar;
        public static Button btnCancelar;
        public static Button btnEditar;
        public static Button btnAlterar;
        public static Button btnOk;
        public static Button btnFechar;
        public static Button btnFiltrar;
        public static Button btnConcluir;
        public static Button btnImprimir;
        public static Statement stm;
        public static TableColumn<DadosContasPagar, String> colunaNrDocumento;
        public static TableColumn<DadosContasPagar, String> colunaDescricao;
        public static TableColumn<DadosContasPagar, String> colunaDataBoleto;
        public static TableColumn<DadosContasPagar, String> colunaDataVencimento;
        public static TableColumn<DadosContasPagar, String> colunaValorDocumento;
        public static TableColumn<DadosContasPagar, String> colunaFormaPagamento;
        public static TableColumn<DadosContasPagar, String> colunaDataPagamento;
        public static TableColumn<DadosContasPagar, Double> colunaValorCobrado;
        public static TableColumn<DadosContasPagar, String> colunaStatus;
        public static TableColumn colunaUsuario;
        public static DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        public static DecimalFormat df;
        public static Date d = new Date();
        public static String strDataBoleto;
        public static String strDataVencimento;
        public static ResultSet rs;
        private static final String url = "jdbc:mysql://127.0.0.1/sistema";
	private static final String driver = "com.mysql.jdbc.Driver";
	private static final String login = "";
	private static final String pwd = "";
        
	public static void show(String mensagem, String titulo){
            
                msg = new Label(mensagem);    
                con = Conexao.getConexao();
                lblNrDoc = new Label("Nr. Documento:");
                lblBeneficiario = new Label("Favorecido:");
                lblDataEmissao = new Label("Data Emissão:");
                lblDataVencimento = new Label("Data Vencimento:");
                lblDataPagamento = new Label("Data Pagamento:");
                lblValorDocumento = new Label("valor Documento:");
                lblDescAbatimento = new Label("Desc/Abatimento:");
                lblJurosMulta = new Label("Juros/Multa/Acréscimos:");
                lblValorCobrado = new Label("Valor Cobrado:");
                lblEspecieDocumento= new Label("Tipo Documento:");
                lblMoeda = new Label("Moeda:");
                lblLocalPagamento = new Label("Local Pagamento:");
                lblDescricao = new Label("Descrição:");
                lblFormaPagamento = new Label("Forma Pagamento:");
                lblDataInicio = new Label("Data Inicio:");
                lblDataFim = new Label("Data Fim:");
                lblCodBarras = new Label("Cód. Barras:");
                lblStatus = new Label("Status:");
                lblFiltro = new Label("Filtro");
                lblValorSelecionado = new Label("Selecionados: ");
                txtNrDoc = new TextField();
                cbBeneficiario = new ComboBox();
                txtDataEmissao = new DatePicker();
                txtDataVencimento = new DatePicker();
                txtDataPagamento = new DatePicker();
                txtDataInicio = new DatePicker();
                txtDataFim = new DatePicker();
                cbStatus = new ComboBox();
                df = new DecimalFormat("#,##0.00");
                txtValorDocumento = new TextField();
                txtDescAbatimento = new TextField();
                txtJurosMulta = new TextField();
                txtValorCobrado = new TextField();
                cbEspecieDocumento = new ComboBox();
                cbMoeda = new ComboBox();
                txtLocalPagamento = new TextField();
                txtDescricao = new TextField();
                cbFormaPagamento = new ComboBox();
                txtCodBarras = new TextField();
                painelDados = new GridPane();
                painelPrincipal = new VBox(5);
                linha1 = new HBox(5);
                linha2 = new HBox(5);
                linha3 = new HBox(5);
                linha4 = new HBox(5);
                linha5 = new HBox(5);
                linhaFiltro = new HBox(5);
                painelBotoes = new StackPane();
                painelDadosBorda = new StackPane();
                painelFiltro = new StackPane();
                linhaBotoes = new HBox(5);
                cenario = new Scene(painelPrincipal, 1000, 550);
                colunaNrDocumento = new TableColumn<DadosContasPagar, String>("Nrº Documento");
                colunaNrDocumento.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("nrDocumento"));
                colunaDescricao = new TableColumn<DadosContasPagar, String>("Descricao");
                colunaDescricao.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("descricao"));
                colunaDataBoleto = new TableColumn<DadosContasPagar, String>("Emissão");
                colunaDataBoleto.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("dataBoleto"));
                colunaDataVencimento = new TableColumn<DadosContasPagar, String>("Vencimento");
                colunaDataVencimento.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("dataVencimento"));
                colunaFormaPagamento = new TableColumn<DadosContasPagar, String>("Forma Pagamento");
                colunaFormaPagamento.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("formaPagamento"));
                colunaDataPagamento = new TableColumn<DadosContasPagar, String>("Pagamento");
                colunaDataPagamento.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("dataPagamento"));
                colunaValorCobrado = new TableColumn<DadosContasPagar, Double>("Valor");
                colunaValorCobrado.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, Double>("valorCobrado"));
                colunaStatus = new TableColumn<DadosContasPagar, String>("Status");
                colunaStatus.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("status"));
                colunaUsuario = new TableColumn("Usuário");
                colunaUsuario.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("usuario"));
                btnAdicionar = new Button("_Adicionar");
                btnBaixar = new Button("_Baixar");
                btnCancelar = new Button("_Cancelar");
                btnEditar = new Button("_Editar");
                btnAlterar = new Button("A_lterar");
                btnOk = new Button("_Ok");
                btnFechar = new Button("_Fechar");
                btnFiltrar = new Button("Filtrar");
                btnConcluir = new Button("C_oncluir");
                btnImprimir = new Button("_Imprimir");
                inicio = new Stage();
		inicio.setScene(cenario);
                tabela = new TableView<DadosContasPagar>();
                inicio.initModality(Modality.APPLICATION_MODAL);
                painelDadosBorda.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -7 5 5 5");
                painelFiltro.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -7 5 5 5");
                inicio.setTitle(titulo);
                txtCodBarras.setDisable(true);
                txtCodBarras.setVisible(false);
                lblCodBarras.setVisible(false);

                txtValorDocumento.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.TAB){
                        tabValores();
                    }
                });

                colunaNrDocumento.setPrefWidth(110);
                colunaDescricao.setPrefWidth(275);
                colunaDataBoleto.setPrefWidth(80);
                colunaDataVencimento.setPrefWidth(80);
                colunaDataPagamento.setPrefWidth(80);
                colunaFormaPagamento.setPrefWidth(120);
                colunaUsuario.setPrefWidth(80);
                painelDadosBorda.setAlignment(msg, Pos.TOP_LEFT);
                
                lblNrDoc.setStyle("-fx-font-weight: bold");
                lblBeneficiario.setStyle("-fx-font-weight: bold");
                lblDataEmissao.setStyle("-fx-font-weight: bold");
                lblDataVencimento.setStyle("-fx-font-weight: bold");
                lblEspecieDocumento.setStyle("-fx-font-weight: bold");
                lblMoeda.setStyle("-fx-font-weight: bold");
                lblJurosMulta.setStyle("-fx-font-weight: bold");
                lblDescAbatimento.setStyle("-fx-font-weight: bold");
                lblValorCobrado.setStyle("-fx-font-weight: bold");
                lblCodBarras.setStyle("-fx-font-weight: bold");
                lblDescricao.setStyle("-fx-font-weight: bold");
                lblDataPagamento.setStyle("-fx-font-weight: bold");
                lblFormaPagamento.setStyle("-fx-font-weight: bold");
                lblLocalPagamento.setStyle("-fx-font-weight: bold");
                lblDataInicio.setStyle("-fx-font-weight: bold");
                lblValorDocumento.setStyle("-fx-font-weight: bold");
                lblDataFim.setStyle("-fx-font-weight: bold");
                lblStatus.setStyle("-fx-font-weight: bold");
                lblFiltro.setStyle("-fx-background-color: #F4F4F4");
                msg.setStyle("-fx-background-color: #F4F4F4");
                
                btnOk.setGraphic(Login.imageViewSalvar);
                btnAlterar.setGraphic(Login.imageViewOk);
                btnCancelar.setGraphic(Login.imageViewCancelar);
                btnFechar.setGraphic(Login.imageViewFechar);
                btnAdicionar.setGraphic(Login.imageViewAdicionar);
                btnBaixar.setGraphic(Login.imageViewBaixar);
                btnEditar.setGraphic(Login.imageViewEditar);
                btnImprimir.setGraphic(Login.imageViewImprimir);
                
                cbBeneficiario.setPrefWidth(200);
                cbEspecieDocumento.setPrefWidth(100);
                txtNrDoc.setPrefWidth(90);
                txtJurosMulta.setPrefWidth(105);
                txtDescAbatimento.setPrefWidth(105);
                cbMoeda.setPrefWidth(105);
                txtDescricao.setPrefWidth(300);
                txtCodBarras.setPrefWidth(330);
                cbFormaPagamento.setPrefWidth(200);
         
                tabela.getColumns().addAll(colunaNrDocumento, colunaDescricao, colunaDataBoleto, colunaDataVencimento, colunaValorCobrado, colunaStatus, colunaDataPagamento, colunaFormaPagamento, colunaUsuario);
                
                tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
                
                txtNrDoc.setDisable(true);
                cbBeneficiario.setDisable(true);
                cbEspecieDocumento.setDisable(true);
                txtDescricao.setDisable(true);
                txtDataEmissao.setDisable(true);
                txtDataVencimento.setDisable(true);
                txtDataPagamento.setDisable(true);
                cbMoeda.setDisable(true);
                cbFormaPagamento.setDisable(true);
                txtLocalPagamento.setDisable(true);
                txtCodBarras.setDisable(true);
                txtJurosMulta.setDisable(true);
                txtDescAbatimento.setDisable(true);
                txtValorCobrado.setDisable(true);
                txtValorDocumento.setDisable(true);

                btnAdicionar.setDisable(false);
                btnEditar.setDisable(false);
                btnOk.setDisable(true);
                btnAlterar.setDisable(true);
                btnCancelar.setDisable(true);
                btnFechar.setDisable(false);
                btnBaixar.setDisable(false);           
                btnConcluir.setDisable(true);      
                
                linha1.getChildren().addAll(lblNrDoc, txtNrDoc, lblBeneficiario, cbBeneficiario, lblEspecieDocumento, cbEspecieDocumento);
                linha2.getChildren().addAll(lblDataEmissao, txtDataEmissao, lblDataVencimento, txtDataVencimento, lblMoeda, cbMoeda);
                linha3.getChildren().addAll(lblDescricao, txtDescricao, lblDescAbatimento, txtDescAbatimento, lblJurosMulta, txtJurosMulta);                
                linha4.getChildren().addAll(lblDataPagamento,txtDataPagamento, lblFormaPagamento, cbFormaPagamento, lblLocalPagamento, txtLocalPagamento, btnConcluir);
                linha5.getChildren().addAll(lblValorDocumento, txtValorDocumento, lblValorCobrado, txtValorCobrado);
                linhaFiltro.getChildren().addAll(lblDataInicio, txtDataInicio, lblDataFim, txtDataFim, lblStatus, cbStatus, btnFiltrar);

                cbFormaPagamento.getItems().addAll("DINHEIRO", "DEBITO", "DEPOSITO", "CHEQUE", "INTERNET BANK", "CREDITO", "OUTROS");
                
                btnFiltrar.setOnMouseClicked(e -> {
                    if(cbStatus.getValue() == "Em aberto"){
                        
                        tabela.getItems().remove(ListarContasPagarStatus());
                        tabela.setItems(ListarContasPagar());
                        lblValorCobrado.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
                    }else{
                        
                        tabela.getItems().remove(ListarContasPagar());
                        tabela.setItems(ListarContasPagarStatus());
                        lblValorCobrado.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));                        
                    }
                });
                
                cbBeneficiario.getItems().addAll(ListarBancos());
                cbBeneficiario.setConverter(new StringConverter<DadosBancos>() {
                    
                @Override
                public String toString(DadosBancos object) {
                    if(object!=null){
                        return object.getNomeBanco();
                    }
                    return null;
                }
                @Override
                public DadosBancos fromString(String string) {
                    return null;
                    }
                });
                
                cbMoeda.setItems(ListarMoedas());
                cbEspecieDocumento.getItems().addAll("Boleto","Boleto Simples","DARF","Guia Imposto Importação","Guia PIS/PASEP","Guia IRRF","Guia COFINS","Guia Previdência","Guia ICMS","Guia FGTS","Fatura","Outros");
                cbMoeda.setConverter(new StringConverter<DadosMoedas>() {
                    
                @Override
                public String toString(DadosMoedas object) {
                    if(object!=null){
                        return object.getMoeda();
                    }
                    return null;
                }
                @Override
                public DadosMoedas fromString(String string) {
                    return null;
                    }
                });
               
                txtDataInicio.setValue(LocalDate.now());
                txtDataFim.setValue(LocalDate.now());
                cbStatus.setValue("Em aberto");
                painelBotoes.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: 2 5 5 5");
                btnFiltrar.setGraphic(Login.imageViewFiltrar);
                painelBotoes.setPadding(new Insets(10));
                painelFiltro.setPadding(new Insets(10));
                painelBotoes.getChildren().addAll(linhaBotoes);
                linhaBotoes.setAlignment(Pos.CENTER);
                linhaBotoes.setPadding(new Insets(5));
                linhaFiltro.setPadding(new Insets(10));
                linhaBotoes.getChildren().addAll(btnAdicionar, btnOk, btnAlterar, btnCancelar, btnEditar, btnBaixar, btnImprimir, btnFechar);
                
                cbStatus.getItems().addAll("Em aberto", "Pago");
                
                painelDados.setVgap(5);
                painelDados.setHgap(5);
                painelDados.add(linha1, 0, 0);
                painelDados.add(linha2, 0, 1);
                painelDados.add(linha3, 0, 2);
                painelDados.add(linha5, 0, 3);
                painelDados.add(linha4, 0, 4);
                
                txtCodBarras.setOnKeyPressed(e -> {
                   if(e.getCode() == KeyCode.TAB){
                       tabCodBarras();
                   } 
                });
                
                btnFechar.setOnAction(e -> inicio.close());
                btnAdicionar.setOnAction(e -> btnAdd());
                btnAlterar.setOnAction(e -> btnAlterar());
                btnOk.setOnAction(e -> btnOk());
                
                btnEditar.setOnAction(e -> {
                    DadosContasPagar dados = tabela.getSelectionModel().getSelectedItem();    
                    if(dados == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        BuscarEditarContasPagar();
                    }
                });
                
                btnBaixar.setOnAction(e -> {
                DadosContasPagar dados = tabela.getSelectionModel().getSelectedItem();    
                    if(dados == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        BuscarContasPagar();
                    }
                });
                
                btnConcluir.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        btnConcluirBaixa();
                    }
                });
                
                txtDataPagamento.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        btnConcluirBaixa();
                    }
                });
                
                cbFormaPagamento.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        btnConcluirBaixa();
                    }
                });
                
                txtLocalPagamento.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        btnConcluirBaixa();
                    }
                });
                
                btnCancelar.setOnAction(e -> btnCancelar());
                btnConcluir.setOnAction(e -> btnConcluirBaixa());
                painelDados.setPadding(new Insets(15));
                painelDadosBorda.getChildren().addAll(msg, painelDados);
                painelFiltro.getChildren().addAll(lblFiltro, linhaFiltro);                
                painelFiltro.setAlignment(lblFiltro, Pos.TOP_LEFT);
                painelPrincipal.setPadding(new Insets(6));
                painelPrincipal.getChildren().addAll(painelDadosBorda, painelFiltro, tabela, lblValorCobrado, painelBotoes);
                inicio.showAndWait();
	}
        
        public static ObservableList<DadosBancos> ListarBancos(){
            
            ObservableList dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "SELECT BANCO FROM BANCOS ORDER BY BANCO";
                
                PreparedStatement st = conexao.prepareStatement(sql);    
                rs = st.executeQuery(sql);
                
                while(rs.next()){
                    String nomeBanco = rs.getString("BANCO");
                    dados.add(new DadosBancos(nomeBanco));
                }  
            } catch(Exception e){
                MessageBox.show("\n"+e+"\n","Erro");
            }
            return dados;
        }
        
        public static ObservableList<DadosMoedas> ListarMoedas(){
            
            ObservableList dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();    
                String sql = "SELECT MOEDA FROM MOEDAS ORDER BY MOEDA";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                rs = st.executeQuery(sql);
                
                while(rs.next()){
                    String nomeMoeda = rs.getString("MOEDA");
                    dados.add(new DadosMoedas(nomeMoeda));
                }  
                
            } catch(Exception e){
                MessageBox.show("\n"+e+"\n","Erro");
            }
            return dados;
        }
        
        public static ObservableList<DadosContasPagar> ListarContasPagar(){
            
            ObservableList<DadosContasPagar> dados = FXCollections.observableArrayList();
            ResultSet rs;
            ResultSet rst;
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "SELECT ID, NR_DOCUMENTO, DESCRICAO, BENEFICIARIO, date_format(DATA_BOLETO, '%d/%m/%Y') AS DATA_BOLETO, date_format(DATA_VENCIMENTO, '%d/%m/%Y') AS DATA_VENCIMENTO, FORMA_PAGAMENTO, date_format(DATA_PAGAMENTO, '%d/%m/%Y') AS DATA_PAGAMENTO, ESPECIE_DOCUMENTO, MOEDA, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, LOCAL_PAGAMENTO, COD_BARRAS, STATUS, USUARIO, PARCELA FROM CONTASPAGAR WHERE DATA_VENCIMENTO BETWEEN '"+txtDataInicio.getValue()+"' AND '"+txtDataFim.getValue()+"' AND STATUS = '"+String.valueOf(cbStatus.getValue())+"';";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                rs = st.executeQuery(sql);

                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nrDocumento = rs.getString("NR_DOCUMENTO");
                    String descricao = rs.getString("DESCRICAO");
                    String especieDocumento = rs.getString("ESPECIE_DOCUMENTO");
                    String moeda = rs.getString("MOEDA");
                    String dataBoleto = rs.getString("DATA_BOLETO");
                    String dataVencimento = rs.getString("DATA_VENCIMENTO");
                    String dataPagamento = rs.getString("DATA_PAGAMENTO");
                    String formaPagamento = rs.getString("FORMA_PAGAMENTO");
                    double jurosMulta = rs.getDouble("JUROS_MULTA");
                    double descontoAbatimento = rs.getDouble("DESCONTO_ABATIMENTO");
                    double valorBoleto = rs.getDouble("VALOR_BOLETO");
                    double valorCobrado = rs.getDouble("VALOR_COBRADO");
                    String localPagamento = rs.getString("LOCAL_PAGAMENTO");
                    String codBarras = rs.getString("COD_BARRAS");
                    String status = rs.getString("STATUS");
                    String beneficiario = rs.getString("BENEFICIARIO");
                    String usuario = rs.getString("USUARIO");
                    int parcela = rs.getInt("PARCELA");
                    
                    dados.add(new DadosContasPagar(id, nrDocumento, descricao, especieDocumento, moeda, dataBoleto, dataVencimento, dataPagamento,  formaPagamento, jurosMulta, descontoAbatimento, valorBoleto, "R$"+String.format("%.02f",valorCobrado).replace(".",","), localPagamento, codBarras, status, beneficiario, usuario, parcela));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }

        public static ObservableList<DadosContasPagar> ListContasPagar(){
            
            ObservableList<DadosContasPagar> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "SELECT * FROM CONTASPAGAR;";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                rs = st.executeQuery(sql);

                while(rs.next()){
                    
                    int id = rs.getInt("ID");
                    String nrDocumento = rs.getString("NR_DOCUMENTO");
                    String descricao = rs.getString("DESCRICAO");
                    String especieDocumento = rs.getString("ESPECIE_DOCUMENTO");
                    String moeda = rs.getString("MOEDA");
                    String dataBoleto = rs.getString("DATA_BOLETO");
                    String dataVencimento = rs.getString("DATA_VENCIMENTO");
                    String dataPagamento = rs.getString("DATA_PAGAMENTO");
                    String formaPagamento = rs.getString("FORMA_PAGAMENTO");
                    double jurosMulta = rs.getDouble("JUROS_MULTA");
                    double descontoAbatimento = rs.getDouble("DESCONTO_ABATIMENTO");
                    double valorBoleto = rs.getDouble("VALOR_BOLETO");
                    double valorCobrado = rs.getDouble("VALOR_COBRADO");
                    String localPagamento = rs.getString("LOCAL_PAGAMENTO");
                    String codBarras = rs.getString("COD_BARRAS");
                    String status = rs.getString("STATUS");
                    String beneficiario = rs.getString("BENEFICIARIO");
                    String usuario = rs.getString("USUARIO");
                    int parcela = rs.getInt("PARCELA");
                    
                    dados.add(new DadosContasPagar(id, nrDocumento, descricao, especieDocumento, moeda, dataBoleto, dataVencimento, dataPagamento,  formaPagamento, jurosMulta, descontoAbatimento, valorBoleto, "R$"+String.format("%.02f",valorCobrado).replace(".",","), localPagamento, codBarras, status, beneficiario, usuario, parcela));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }

        
        public static ObservableList<DadosContasPagar> ListarContasPagarStatus(){
            
            ObservableList<DadosContasPagar> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "SELECT ID, NR_DOCUMENTO, DESCRICAO, BENEFICIARIO, date_format(DATA_BOLETO, '%d/%m/%Y') AS DATA_BOLETO, date_format(DATA_VENCIMENTO, '%d/%m/%Y') AS DATA_VENCIMENTO, FORMA_PAGAMENTO, date_format(DATA_PAGAMENTO, '%d/%m/%Y') AS DATA_PAGAMENTO, ESPECIE_DOCUMENTO, MOEDA, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, LOCAL_PAGAMENTO, COD_BARRAS, STATUS, USUARIO, PARCELA FROM CONTASPAGAR WHERE DATA_PAGAMENTO BETWEEN '"+txtDataInicio.getValue()+"' AND '"+txtDataFim.getValue()+"' AND STATUS = '"+String.valueOf(cbStatus.getValue())+"';";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                rs = st.executeQuery(sql);

                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nrDocumento = rs.getString("NR_DOCUMENTO");
                    String descricao = rs.getString("DESCRICAO");
                    String especieDocumento = rs.getString("ESPECIE_DOCUMENTO");
                    String moeda = rs.getString("MOEDA");
                    String dataBoleto = rs.getString("DATA_BOLETO");
                    String dataVencimento = rs.getString("DATA_VENCIMENTO");
                    String dataPagamento = rs.getString("DATA_PAGAMENTO");
                    String formaPagamento = rs.getString("FORMA_PAGAMENTO");
                    double jurosMulta = rs.getDouble("JUROS_MULTA");
                    double descontoAbatimento = rs.getDouble("DESCONTO_ABATIMENTO");
                    double valorBoleto = rs.getDouble("VALOR_BOLETO");
                    double valorCobrado = rs.getDouble("VALOR_COBRADO");
                    String localPagamento = rs.getString("LOCAL_PAGAMENTO");
                    String codBarras = rs.getString("COD_BARRAS");
                    String status = rs.getString("STATUS");
                    String beneficiario = rs.getString("BENEFICIARIO");
                    String usuario = rs.getString("USUARIO");
                    int parcela = rs.getInt("PARCELA");
                    
                    dados.add(new DadosContasPagar(id, nrDocumento, descricao, especieDocumento, moeda, dataBoleto, dataVencimento, dataPagamento,  formaPagamento, jurosMulta, descontoAbatimento, valorBoleto, "R$"+String.format("%.02f",valorCobrado).replace(".",","), localPagamento, codBarras, status, beneficiario, usuario, parcela));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }

        
        public static boolean BuscarContasPagar(){
            
            ResultSet rs;
            int cont = 0;
            boolean verificador = false;

            try{
                ObservableList<DadosContasPagar> sel, items;
                items = tabela.getItems();
                sel = tabela.getSelectionModel().getSelectedItems();
                
                for(DadosContasPagar m : sel){
                
                    Connection conexao = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) AS count FROM CONTASPAGAR WHERE STATUS = 'Pago' AND DESCRICAO = '"+m.getDescricao()+"' AND NR_DOCUMENTO = '"+m.getNrDocumento()+"' AND PARCELA = "+m.getParcela()+";";

                    PreparedStatement st = conexao.prepareStatement(sql);
                    rs = st.executeQuery(sql);

                    while(rs.next()){
                            cont = rs.getInt("count");
                    }
                }
                if(cont == 0){
                    verificador = false;
                    btnBaixar();
                }else{
                    verificador = true;
                    MessageBox.show("Não é possível efetuar a baixa! \n\nDespesa(s) já quitada(s)","Alerta");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return verificador;
        }
        public static boolean BuscarEditarContasPagar(){
            
            ResultSet rs;
            int cont = 0;
            boolean verificador = false;

            try{
                ObservableList<DadosContasPagar> sel, items;
                items = tabela.getItems();
                sel = tabela.getSelectionModel().getSelectedItems();
                for(DadosContasPagar m : sel){
                
                        Connection conexao = Conexao.getConexao();
                        String sql = "SELECT COUNT(*) AS count FROM CONTASPAGAR WHERE STATUS = 'Pago' AND DESCRICAO = '"+m.getDescricao()+"' AND NR_DOCUMENTO = '"+m.getNrDocumento()+"' AND PARCELA = "+m.getParcela()+";";

                        PreparedStatement st = conexao.prepareStatement(sql);
                        rs = st.executeQuery(sql);

                        while(rs.next()){
                            cont = rs.getInt("count");
                        }
                    }
                    if(cont == 0){
                        verificador = false;
                        btnEditar();
                    }else{
                        verificador = true;
                        MessageBox.show("Não é possível Editar! \n\nDespesa(s) já quitada(s)","Alerta");
                    }
                
            }catch(Exception e){
                System.out.println(e);
            }
            return verificador;
        }
        
        public static void btnOk(){
                        
            try{
                Connection conexao = Conexao.getConexao();
                DadosMoedas moeda = (DadosMoedas) cbMoeda.getSelectionModel().getSelectedItem();
                DadosBancos banco = (DadosBancos) cbBeneficiario.getSelectionModel().getSelectedItem();
                String sql = "INSERT INTO CONTASPAGAR(NR_DOCUMENTO, DESCRICAO, BENEFICIARIO, ESPECIE_DOCUMENTO, DATA_BOLETO, DATA_VENCIMENTO, MOEDA, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, STATUS, USUARIO) VALUES('"+txtNrDoc.getText()+"','"+txtDescricao.getText()+"','"+banco.getNomeBanco()+"','"+cbEspecieDocumento.getValue()+"', '"+String.valueOf(txtDataEmissao.getValue())+"', '"+String.valueOf(txtDataVencimento.getValue())+"', '"+moeda.getMoeda()+"',"+txtJurosMulta.getText().replace(",", ".")+", "+txtDescAbatimento.getText().replace(",", ".")+", "+txtValorDocumento.getText().replace(",", ".")+", "+txtValorCobrado.getText().replace(",", ".")+",'Em Aberto','"+Login.campo1.getText()+"');";
                
                PreparedStatement ps = conexao.prepareStatement(sql);
                ps.execute(sql);
                
                txtNrDoc.setDisable(true);
                txtDescricao.setDisable(true);
                cbBeneficiario.setDisable(true);
                txtDataEmissao.setDisable(true);
                txtDataVencimento.setDisable(true);
                cbEspecieDocumento.setDisable(true);
                cbMoeda.setDisable(true);
                btnImprimir.setDisable(true);
                txtDataPagamento.setDisable(true);
                cbFormaPagamento.setDisable(true);
                txtLocalPagamento.setDisable(true);
                txtDataInicio.setDisable(false);
                txtDataFim.setDisable(false);
                cbStatus.setDisable(false);
                btnFiltrar.setDisable(false);
                txtCodBarras.setDisable(true);
                txtValorCobrado.setDisable(true);
                txtValorDocumento.setDisable(true);
                txtDescAbatimento.setDisable(true);
                txtJurosMulta.setDisable(true);
                btnAdicionar.setDisable(false);
                btnEditar.setDisable(false);
                btnOk.setDisable(true);
                btnAlterar.setDisable(true);
                btnCancelar.setDisable(true);
                btnFechar.setDisable(false);
                btnBaixar.setDisable(false);           
                btnConcluir.setDisable(true);           
                txtNrDoc.clear();
                txtDescricao.clear();
                cbBeneficiario.setValue(null);
                txtDataEmissao.setValue(null);
                txtDataVencimento.setValue(null);
                cbEspecieDocumento.setValue(null);
                cbMoeda.setValue(null);
                txtDataPagamento.setValue(null);
                cbFormaPagamento.setValue(null);
                txtLocalPagamento.clear();
                txtCodBarras.clear();
                txtValorCobrado.clear();
                txtValorDocumento.clear();
                txtDescAbatimento.clear();
                txtJurosMulta.clear();
                tabela.setDisable(false);
                tabela.setItems(ListarContasPagar());
                lblValorCobrado.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
                
            }catch(Exception e){
                MessageBox.show("\n"+e+"\n", "Erro");
                System.out.println(e);
            }
        }
        
        public static void tabCodBarras(){

            try{
                Connection conexao = Conexao.getConexao();
                ResultSet rs;
                
                String codbanco = txtCodBarras.getText().substring(0,3);
                String sqlBanco = "SELECT BANCO FROM BANCOS WHERE COD_BANCO LIKE '%"+codbanco+"%';";
                
                PreparedStatement ps = conexao.prepareStatement(sqlBanco);
                rs = ps.executeQuery(sqlBanco);
                
                String banco = rs.getString("BANCO");
                cbBeneficiario.setValue(banco);     
            
            }catch(Exception e){
                MessageBox.show("\n"+e+"\n", "Erro");
                System.out.println(e);
            }
        }
        
        public static void btnConcluirBaixa(){
                       
            try{
                    DadosContasPagar dados = (DadosContasPagar) tabela.getSelectionModel().getSelectedItem();    
                    Connection conexao = Conexao.getConexao();

                    ObservableList<DadosContasPagar> sel, items;
                    items = tabela.getItems();
                    sel = tabela.getSelectionModel().getSelectedItems();
                    for(DadosContasPagar m : sel){

                        String descricao = m.getDescricao();
                        String nrDocumento = m.getNrDocumento();
                        int parcela = m.getParcela();
                        String sql = "UPDATE CONTASPAGAR SET DATA_PAGAMENTO = '"+String.valueOf(txtDataPagamento.getValue())+"', FORMA_PAGAMENTO = '"+String.valueOf(cbFormaPagamento.getValue())+"', LOCAL_PAGAMENTO = '"+txtLocalPagamento.getText()+"', STATUS = 'Pago', USUARIO = '"+Login.campo1.getText()+"' WHERE  NR_DOCUMENTO = '%"+nrDocumento+"%' AND DESCRICAO = '"+descricao+"' OR PARCELA = "+parcela+";";

                        PreparedStatement ps = conexao.prepareStatement(sql);

                        ps.execute(sql);
                    }                    

                    txtNrDoc.setDisable(true);
                    txtDescricao.setDisable(true);
                    cbBeneficiario.setDisable(true);
                    txtDataEmissao.setDisable(true);
                    txtDataVencimento.setDisable(true);
                    btnImprimir.setDisable(false);
                    cbEspecieDocumento.setDisable(true);
                    cbMoeda.setDisable(true);
                    txtDataPagamento.setDisable(true);
                    cbFormaPagamento.setDisable(true);
                    txtLocalPagamento.setDisable(true);
                    txtDataInicio.setDisable(false);
                    txtDataFim.setDisable(false);
                    cbStatus.setDisable(false);
                    btnFiltrar.setDisable(false);
                    txtCodBarras.setDisable(true);
                    btnAdicionar.setDisable(false);
                    btnEditar.setDisable(false);
                    btnOk.setDisable(true);
                    btnAlterar.setDisable(true);
                    btnCancelar.setDisable(true);
                    btnFechar.setDisable(false);
                    btnBaixar.setDisable(false);           
                    btnConcluir.setDisable(true);           
                    txtNrDoc.clear();
                    txtDescricao.clear();
                    cbBeneficiario.setValue(null);
                    txtDataEmissao.setValue(null);
                    txtDataVencimento.setValue(null);
                    cbEspecieDocumento.setValue(null);
                    cbMoeda.setValue(null);
                    txtDataPagamento.setValue(null);
                    cbFormaPagamento.setValue(null);
                    txtLocalPagamento.clear();
                    txtCodBarras.clear();
                    tabela.setDisable(false);
                    tabela.setItems(ListarContasPagar());
                    lblValorCobrado.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
                    
            }catch(Exception e){
                MessageBox.show("\n"+e+"\n", "Erro");
                System.out.println(e);
            }
        }

        public static void btnAlterar(){
                       
            try{
                    DadosContasPagar dados = (DadosContasPagar) tabela.getSelectionModel().getSelectedItem();    
                    DadosMoedas moeda = (DadosMoedas) cbMoeda.getSelectionModel().getSelectedItem();
                    DadosBancos banco = (DadosBancos) cbBeneficiario.getSelectionModel().getSelectedItem();
                    Connection conexao = Conexao.getConexao();

                    String sql = "UPDATE CONTASPAGAR SET NR_DOCUMENTO = '"+txtNrDoc.getText()+"', DESCRICAO = '"+txtDescricao.getText()+"', BENEFICIARIO = '"+banco.getNomeBanco()+"', ESPECIE_DOCUMENTO = '"+cbEspecieDocumento.getValue()+"', MOEDA = '"+moeda.getMoeda()+"', DATA_BOLETO = '"+String.valueOf(txtDataEmissao.getValue())+"', DATA_VENCIMENTO = '"+String.valueOf(txtDataVencimento.getValue())+"', JUROS_MULTA = "+txtJurosMulta.getText().replace(",", ".")+", DESCONTO_ABATIMENTO = "+txtDescAbatimento.getText().replace(",", ".")+", VALOR_BOLETO = "+txtValorDocumento.getText().replace(",", ".")+", VALOR_COBRADO = "+txtValorCobrado.getText().replace(",", ".")+", USUARIO = '"+Login.campo1.getText()+"' WHERE  NR_DOCUMENTO = '%"+dados.getNrDocumento()+"%' OR DESCRICAO = '"+dados.getDescricao()+"';";
                    PreparedStatement ps = conexao.prepareStatement(sql);
                    ps.execute(sql);                    

                    txtNrDoc.setDisable(true);
                    txtDescricao.setDisable(true);
                    cbBeneficiario.setDisable(true);
                    txtDataEmissao.setDisable(true);
                    txtDataVencimento.setDisable(true);
                    cbEspecieDocumento.setDisable(true);
                    cbMoeda.setDisable(true);
                    txtDataPagamento.setDisable(true);
                    cbFormaPagamento.setDisable(true);
                    txtLocalPagamento.setDisable(true);
                    btnImprimir.setDisable(false);
                    txtDataInicio.setDisable(false);
                    txtDataFim.setDisable(false);
                    cbStatus.setDisable(false);
                    btnFiltrar.setDisable(false);
                    txtCodBarras.setDisable(true);
                    txtValorCobrado.setDisable(true);
                    txtJurosMulta.setDisable(true);
                    txtDescAbatimento.setDisable(true);
                    txtValorDocumento.setDisable(true);
                    btnAdicionar.setDisable(false);
                    btnEditar.setDisable(false);
                    btnOk.setDisable(true);
                    btnAlterar.setDisable(true);
                    btnCancelar.setDisable(true);
                    btnFechar.setDisable(false);
                    btnBaixar.setDisable(false);           
                    btnConcluir.setDisable(true);      
                    txtNrDoc.clear();
                    txtDescricao.clear();
                    cbBeneficiario.setValue(null);
                    txtDataEmissao.setValue(null);
                    txtDataVencimento.setValue(null);
                    cbEspecieDocumento.setValue(null);
                    cbMoeda.setValue(null);
                    txtDataPagamento.setValue(null);
                    cbFormaPagamento.setValue(null);
                    txtLocalPagamento.clear();
                    txtCodBarras.clear();
                    txtValorCobrado.clear();
                    txtJurosMulta.clear();
                    txtDescAbatimento.clear();
                    txtValorDocumento.clear();
                    tabela.setDisable(false);
                    tabela.setItems(ListarContasPagar());
                    
            }catch(Exception e){
                MessageBox.show("\n"+e+"\n", "Erro");
                System.out.println(e);
            }
        }
        
        public static void tabValores(){
            
            
            double resultado = Double.parseDouble(txtValorDocumento.getText().replace(",",".")) + Double.parseDouble(txtJurosMulta.getText().replace(",",".")) - Double.parseDouble(txtDescAbatimento.getText().replace(",","."));
            
            txtValorCobrado.setText(String.valueOf(resultado).replace(".",","));
        }
        
        public static void btnAdd(){

                txtValorDocumento.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.TAB){
                        tabValores();
                    }
                });
            
            txtNrDoc.setDisable(false);
            txtDescricao.setDisable(false);
            cbBeneficiario.setDisable(false);
            txtDataEmissao.setDisable(false);
            txtDataVencimento.setDisable(false);
            cbEspecieDocumento.setDisable(false);
            cbMoeda.setDisable(false);
            txtDataPagamento.setDisable(true);
            cbFormaPagamento.setDisable(true);
            txtLocalPagamento.setDisable(true);
            txtDataInicio.setDisable(true);
            txtDataFim.setDisable(true);
            cbStatus.setDisable(true);
            btnFiltrar.setDisable(true);
            txtCodBarras.setDisable(false);
            txtValorCobrado.setDisable(true);
            txtValorDocumento.setDisable(false);
            txtDescAbatimento.setDisable(false);
            txtJurosMulta.setDisable(false);
            btnImprimir.setDisable(true);
            txtJurosMulta.setText(String.valueOf(df.format(0.00)));
            txtDescAbatimento.setText(String.valueOf(df.format(0.00)));
            txtValorDocumento.setText(String.valueOf(df.format(0.00)));
            txtValorCobrado.setText(String.valueOf(df.format(0.00)));
            txtDataEmissao.setValue(LocalDate.now());
            txtDataVencimento.setValue(LocalDate.now());
            btnAdicionar.setDisable(true);
            btnEditar.setDisable(true);
            btnOk.setDisable(false);
            btnAlterar.setDisable(true);
            btnCancelar.setDisable(false);
            btnFechar.setDisable(true);
            btnBaixar.setDisable(true);
            tabela.setDisable(true);
        }
        public static void btnEditar(){
            
            DadosContasPagar dados = tabela.getSelectionModel().getSelectedItem();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DadosMoedas moeda = new DadosMoedas(String.valueOf(dados.getMoeda()));
            DadosBancos banco = new DadosBancos(String.valueOf(dados.getBeneficiario()));
            
            txtNrDoc.setText(dados.getNrDocumento());
            txtDescricao.setText(dados.getDescricao());
            txtDataEmissao.setValue(LocalDate.parse(dados.getDataBoleto(), formatter));
            txtDataVencimento.setValue(LocalDate.parse(dados.getDataVencimento(), formatter));
            cbEspecieDocumento.setValue(dados.getEspecieDocumento());
            cbMoeda.setValue(moeda);
            cbBeneficiario.setValue(banco);
            txtValorCobrado.setText(String.valueOf(df.format(dados.getValorCobrado())));
            txtJurosMulta.setText(String.valueOf(df.format(dados.getJurosMulta())));
            txtDescAbatimento.setText(String.valueOf(df.format(dados.getDescontoAbatimento())));
            txtValorDocumento.setText(String.valueOf(df.format(dados.getValorBoleto())));
            txtNrDoc.setDisable(false);
            txtDescricao.setDisable(false);
            cbBeneficiario.setDisable(false);
            btnImprimir.setDisable(true);
            txtDataEmissao.setDisable(false);
            txtDataVencimento.setDisable(false);
            cbEspecieDocumento.setDisable(false);            
            cbMoeda.setDisable(false);
            txtDataPagamento.setDisable(true);
            cbFormaPagamento.setDisable(true);
            txtLocalPagamento.setDisable(true);
            txtDataInicio.setDisable(true);
            txtDataFim.setDisable(true);
            cbStatus.setDisable(true);
            btnFiltrar.setDisable(true);
            txtCodBarras.setDisable(false);
            txtValorCobrado.setDisable(true);
            txtValorDocumento.setDisable(false);
            txtDescAbatimento.setDisable(false);
            txtJurosMulta.setDisable(false);
            btnAdicionar.setDisable(true);
            btnEditar.setDisable(true);
            btnOk.setDisable(true);
            btnAlterar.setDisable(false);
            btnCancelar.setDisable(false);
            btnFechar.setDisable(true);
            btnBaixar.setDisable(true);
            btnConcluir.setDisable(true);  
            tabela.setDisable(true);
        }
        public static void btnBaixar(){
            
            txtNrDoc.setDisable(true);
            txtDescricao.setDisable(true);
            cbBeneficiario.setDisable(true);
            txtDataEmissao.setDisable(true);
            txtDataVencimento.setDisable(true);
            cbEspecieDocumento.setDisable(true);
            cbMoeda.setDisable(true);
            txtDataPagamento.setDisable(false);
            cbFormaPagamento.setDisable(false);
            txtLocalPagamento.setDisable(false);
            txtDataInicio.setDisable(true);
            btnImprimir.setDisable(true);
            txtDataFim.setDisable(true);
            cbStatus.setDisable(true);
            btnFiltrar.setDisable(true);
            txtCodBarras.setDisable(true);
            txtDataPagamento.setValue(LocalDate.now());
            cbFormaPagamento.setValue("DINHEIRO");
            btnAdicionar.setDisable(true);
            btnEditar.setDisable(true);
            btnOk.setDisable(true);
            btnAlterar.setDisable(true);
            btnCancelar.setDisable(false);
            btnFechar.setDisable(true);
            btnBaixar.setDisable(true);
            btnConcluir.setDisable(false);           
            tabela.setDisable(true);
        }
        public static void btnCancelar(){
            
            txtNrDoc.clear();
            txtDescricao.clear();
            txtDataEmissao.setValue(null);
            txtDataVencimento.setValue(null);
            cbEspecieDocumento.setValue(null);
            cbMoeda.setValue(null);
            txtValorCobrado.clear();
            txtJurosMulta.clear();
            txtDescAbatimento.clear();
            txtValorDocumento.clear();
            txtNrDoc.setDisable(true);
            txtDescricao.setDisable(true);
            btnImprimir.setDisable(false);
            cbBeneficiario.setDisable(true);
            txtDataEmissao.setDisable(true);
            txtDataVencimento.setDisable(true);
            cbEspecieDocumento.setDisable(true);
            cbMoeda.setDisable(true);
            txtDataPagamento.setDisable(true);
            cbFormaPagamento.setDisable(true);
            txtLocalPagamento.setDisable(true);
            txtDataInicio.setDisable(false);
            txtDataFim.setDisable(false);
            cbStatus.setDisable(false);
            btnFiltrar.setDisable(false);
            txtCodBarras.setDisable(true);
            txtValorCobrado.setDisable(true);
            txtValorDocumento.setDisable(true);
            txtDescAbatimento.setDisable(true);
            txtJurosMulta.setDisable(true);
            btnAdicionar.setDisable(false);
            btnEditar.setDisable(false);
            btnOk.setDisable(true);
            btnAlterar.setDisable(true);
            btnCancelar.setDisable(true);
            btnFechar.setDisable(false);
            btnBaixar.setDisable(false);           
            btnConcluir.setDisable(true);           
            tabela.setDisable(false);
        }

        public static ObservableList<DadosTotalizadoresContasPagar> Totalizadores(){
            
            ResultSet rs;
            PreparedStatement stm;
            ObservableList<DadosTotalizadoresContasPagar> dados = FXCollections.observableArrayList();
            
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT SUM(valor_cobrado) as valor_cobrado FROM contaspagar where data_boleto between '"+txtDataInicio.getValue()+"' AND '"+txtDataFim.getValue()+"' AND STATUS = '"+String.valueOf(cbStatus.getValue())+"';";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    double valor_cobrado = rs.getDouble("valor_cobrado");    
                    dados.add(new DadosTotalizadoresContasPagar(valor_cobrado));
                }
           }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static ObservableList<DadosSelecionadosContasPagar> TotalizadoresSelecionados(){
        
        ResultSet rs;
        PreparedStatement stm;
        ObservableList<DadosSelecionadosContasPagar> dados = FXCollections.observableArrayList();
            
        try{
            ObservableList<DadosContasPagar> sel, items;
            items = tabela.getItems();
            sel = (ObservableList<DadosContasPagar>)(DadosTotalizadoresContasPagar)tabela.getOnMouseClicked();
            String descricao;
            String nrDocumento;
            Connection conexao;
            String consulta;
            double valor_selecionados = 0.00;
            double total = 0.00;
            
            for(DadosContasPagar m : sel){
            
                descricao = m.getDescricao();
                nrDocumento = m.getNrDocumento();                            
                conexao = Conexao.getConexao();
                
                consulta = "SELECT SUM(valor_cobrado) as valor_cobrado FROM contaspagar where nr_documento = '"+nrDocumento+"' AND descricao = '"+descricao+"' group by valor_cobrado;";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    
                    valor_selecionados = rs.getDouble("valor_cobrado");    
                    total += valor_selecionados;
                    dados.add(new DadosSelecionadosContasPagar(total));
                }
            }
        }catch(Exception ex){
            System.err.println(ex);
        }
        return dados;
    }
}