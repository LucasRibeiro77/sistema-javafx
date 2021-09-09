package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.event.*;
import static sistema.cadastroFornecedores.cbMunicipio;
import static sistema.cadastroFornecedores.cbPais;
import static sistema.cadastroFornecedores.cbUF;

public class cadastroEstabelecimento {
    
    public static Button btnAdd = new Button("Adicionar");
    public static Button btnEditar = new Button("Editar");
    public static Button btnOK = new Button("Ok");
    public static Button btnCancelar = new Button("Cancelar");
    public static Button btnExcluir = new Button("Excluir");
    public static Button btnAlterar = new Button("Alterar");
    public static Button btnFechar = new Button("Fechar");
    public static Label lblRazaoSocial = new Label("Razão Social");
    public static Label lblNomeFantasia = new Label("Nome Fantasia");
    public static Label lblCNPJ = new Label("CNPJ");
    public static Label lblIE = new Label("IE                  ");
    public static Label lblIM = new Label("IM");
    public static Label lblCNAE = new Label("CNAE");
    public static Label lblIEST = new Label("IE por Subst. Trib");
    public static Label lblRegimeTributario = new Label("Regime Tributário");
    public static Label lblTelefone = new Label("Telefone");
    public static Label lblLogradouro = new Label("Logradouro ");
    public static Label lblNrLogradouro = new Label("Nrº");
    public static Label lblBairro = new Label("Bairro");
    public static Label lblUF = new Label("UF");
    public static Label lblMunicipio = new Label("Município    ");
    public static Label lblCEP = new Label("CEP");
    public static Label lblPais = new Label("País");
    public static Label lblBuscar = new Label("Buscar por: ");
    public static Label lblPlaca = new Label("Placa: ");
    public static Label lblANTT = new Label("Cód. ANTT: ");
    public static Label lblUFTransp = new Label("UF: ");
    public static ResultSet rs;
    public static Statement stm;
    public static TextField txtRazaoSocial = new TextField();
    public static TextField txtNomeFantasia = new TextField();
    public static MaskedTextField txtANTT = new MaskedTextField("UUU-########");
    public static MaskedTextField txtCNPJ = new MaskedTextField("##.###.###/####-##");
    public static MaskedTextField txtIE = new MaskedTextField("###.###.###.###");
    public static MaskedTextField txtIM = new MaskedTextField("###.###.###");
    public static TextField txtCNAE = new TextField();
    public static TextField txtIEST = new TextField();
    public static ComboBox cbRegimeTributario = new ComboBox();
    public static MaskedTextField txtTelefone = new MaskedTextField("(##)####-####");
    public static TextField txtLogradouro = new TextField();
    public static TextField txtNrLogradouro = new TextField();
    public static TextField txtBairro = new TextField();
    public static Label lblTransporte = new Label("Transporte");
    public static ComboBox<DadosEstado> cbUF = new ComboBox<DadosEstado>();
    public static ComboBox<DadosEstado> cbUFTransportadora = new ComboBox<DadosEstado>();
    public static ComboBox<DadosMunicipio> cbMunicipio = new ComboBox<DadosMunicipio>();
    public static MaskedTextField txtCEP = new MaskedTextField("#####-###");
    public static ComboBox<DadosPais> cbPais = new ComboBox<DadosPais>();
    public static TextField txtBuscarDescricao = new TextField();
    public static TextField txtBuscarCNPJ = new TextField();
    public static MaskedTextField txtCPF = new MaskedTextField("###.###.###-##");
    public static MaskedTextField txtPlaca = new MaskedTextField("UUU-####");
    public static String consultaEstabelecimento = "SELECT * FROM ESTABELECIMENTO ORDER BY ID";
    public static String consultaCidade = "SELECT MUNICIPIO FROM MUNICIPIOS ORDER BY MUNICIPIO";
    public static String consultaEstado = "SELECT SIGLA_UF FROM MUNICIPIOS GROUP BY SIGLA_UF ORDER BY SIGLA_UF";
    public static String consultaPais = "SELECT PAIS FROM MOEDAS GROUP BY PAIS ORDER BY PAIS";
    public static String pesquisaDescricao = "SELECT * FROM ESTABELECIMENTO WHERE RAZAOSOCIAL LIKE '%"+txtBuscarDescricao.getText()+"%' OR NOMEFANTASIA LIKE '%"+txtBuscarDescricao.getText()+"%';";
    public static String pesquisaCNPJ = "SELECT * FROM ESTABELECIMENTO WHERE CNPJ LIKE '%"+txtBuscarCNPJ.getText()+"%';";
    public static TableView<DadosEstabelecimento> tabela;
    public static TableColumn<DadosEstabelecimento, Integer> colunaID;
    public static TableColumn<DadosEstabelecimento, String> colunaRazao;
    public static TableColumn<DadosEstabelecimento, String> colunaNome;
    public static TableColumn<DadosEstabelecimento, String> colunaCNPJ;
    public static CheckBox chkbEstab = new CheckBox();
    public static CheckBox chkbTransportador = new CheckBox();
    public static ComboBox cbBuscar = new ComboBox();
    public static StackPane bordaPainelTransporte;
    
    public static void show(String mensagem, String titulo){
        
        Label msg = new Label(mensagem);
        Label lblTransportador = new Label("Transportador");
        tabela = new TableView<DadosEstabelecimento>();
        colunaID = new TableColumn<DadosEstabelecimento, Integer>("ID");
        colunaID.setPrefWidth(110);
        colunaID.setCellValueFactory(new PropertyValueFactory<DadosEstabelecimento, Integer>("id"));
        colunaRazao = new TableColumn<DadosEstabelecimento, String>("Razão Social");
        colunaRazao.setPrefWidth(200);
        colunaRazao.setCellValueFactory(new PropertyValueFactory<DadosEstabelecimento, String>("razaoSocial"));
        colunaNome = new TableColumn<DadosEstabelecimento, String>("Nome Fantasia");
        colunaNome.setPrefWidth(200);
        colunaNome.setCellValueFactory(new PropertyValueFactory<DadosEstabelecimento, String>("nomeFantasia"));
        colunaCNPJ = new TableColumn<DadosEstabelecimento, String>("CNPJ");
        colunaCNPJ.setPrefWidth(100);
        colunaCNPJ.setCellValueFactory(new PropertyValueFactory<DadosEstabelecimento, String>("CNPJ"));
        Label lblEstab = new Label("Emitente");
        Label lblCPF = new Label("CPF");
        
        GridPane painelDados = new GridPane();
        
        StackPane bordaPainelDados = new StackPane();
        StackPane bordaPainelBotoes = new StackPane();        
        bordaPainelTransporte = new StackPane();        
        
        HBox painelBotoes = new HBox(5);
        HBox painelBusca = new HBox(5);
        HBox RsBuscar = new HBox(5);
        HBox linha1 = new HBox(5);
        HBox linha2 = new HBox(5);
        HBox linha3 = new HBox(5);
        HBox linha4 = new HBox(5);
        HBox linha5 = new HBox(5);
        
        Stage inicio = new Stage();
        
        VBox telaPrincipal = new VBox(5);
        
        Scene cenario = new Scene(telaPrincipal, 1355, 560);
        
        inicio.setScene(cenario);
        inicio.initModality(Modality.WINDOW_MODAL);
        inicio.setTitle(titulo);
        lblRazaoSocial.setStyle("-fx-font-weight: bold");
        lblNomeFantasia.setStyle("-fx-font-weight: bold");
        lblCNPJ.setStyle("-fx-font-weight: bold");
        lblIE.setStyle("-fx-font-weight: bold");
        lblIM.setStyle("-fx-font-weight: bold");
        lblIEST.setStyle("-fx-font-weight: bold");
        lblRegimeTributario.setStyle("-fx-font-weight: bold");
        lblTelefone.setStyle("-fx-font-weight: bold");
        lblPlaca.setStyle("-fx-font-weight: bold");
        lblUFTransp.setStyle("-fx-font-weight: bold");
        lblANTT.setStyle("-fx-font-weight: bold");
        lblLogradouro.setStyle("-fx-font-weight: bold");
        lblNrLogradouro.setStyle("-fx-font-weight: bold");
        lblBairro.setStyle("-fx-font-weight: bold");
        lblMunicipio.setStyle("-fx-font-weight: bold");
        lblUF.setStyle("-fx-font-weight: bold");
        lblPais.setStyle("-fx-font-weight: bold");
        lblCNAE.setStyle("-fx-font-weight: bold");
        lblCEP.setStyle("-fx-font-weight: bold");
        lblEstab.setStyle("-fx-font-weight: bold");
        lblCPF.setStyle("-fx-font-weight: bold");
        lblTransportador.setStyle("-fx-font-weight: bold");

        btnAdd.setGraphic(Login.imageViewAdicionar);
        btnEditar.setGraphic(Login.imageViewEditar);
        btnOK.setGraphic(Login.imageViewSalvar);
        btnCancelar.setGraphic(Login.imageViewCancelar);
        btnExcluir.setGraphic(Login.imageViewExcluir);
        btnAlterar.setGraphic(Login.imageViewOk);
        btnFechar.setGraphic(Login.imageViewFechar);
        
        txtRazaoSocial.setDisable(true);
	txtNomeFantasia.setDisable(true);
	txtCNPJ.setDisable(true);
	txtIE.setDisable(true);
	txtIM.setDisable(true);
	txtIEST.setDisable(true);
	txtLogradouro.setDisable(true);
	txtNrLogradouro.setDisable(true);
	txtBairro.setDisable(true);
	txtCEP.setDisable(true);
	txtTelefone.setDisable(true);
	txtCNAE.setDisable(true);
	cbMunicipio.setDisable(true);
	cbUF.setDisable(true);
	cbPais.setDisable(true);
	cbRegimeTributario.setDisable(true);
        chkbEstab.setDisable(true);
        txtCPF.setDisable(true);
        chkbTransportador.setDisable(true);
	
	btnAdd.setDisable(false);
	btnEditar.setDisable(false);
	btnAlterar.setDisable(true);
	btnExcluir.setDisable(false);
	btnCancelar.setDisable(true);
	btnOK.setDisable(true);
	btnFechar.setDisable(false);

	tabela.setDisable(false);
        
        cbRegimeTributario.setPrefWidth(100);
        cbRegimeTributario.getItems().addAll("Normal", "Simples Nacional", "Simples Nacional - excesso de sublimite de receita bruta");
        
        txtRazaoSocial.setPrefWidth(250);
        txtNomeFantasia.setPrefWidth(250);
        txtLogradouro.setPrefWidth(350);
        txtNrLogradouro.setPrefWidth(60);
        cbMunicipio.setPrefWidth(100);
        cbUF.setPrefWidth(60);
        txtIE.setPrefWidth(115);
        txtIM.setPrefWidth(90);
        cbPais.setPrefWidth(80);
        tabela.setPrefHeight(210);
                
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
        
        cbUFTransportadora.setConverter(new StringConverter<DadosEstado>(){
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
        cbUFTransportadora.getItems().addAll(ListaUF());
        
        cbPais.setConverter(new StringConverter<DadosPais>(){
        @Override
        public String toString(DadosPais object){
            if(object!=null){
                return object.getNome();
            }
            return null;
        }
        @Override
        public DadosPais fromString(String String){
                return null;
            }
        });
        cbPais.getItems().addAll(ListaPais());

        bordaPainelTransporte.setVisible(false);
        
        linha1.getChildren().addAll(lblRazaoSocial, txtRazaoSocial, lblNomeFantasia, txtNomeFantasia, lblCNPJ, txtCNPJ);
        linha2.getChildren().addAll(lblIE, txtIE, lblIM, txtIM, lblIEST, txtIEST, lblRegimeTributario, cbRegimeTributario, lblCPF, txtCPF);
        linha3.getChildren().addAll(lblLogradouro, txtLogradouro, lblNrLogradouro, txtNrLogradouro, lblBairro, txtBairro, lblCEP, txtCEP, txtPlaca);
        linha4.getChildren().addAll(lblMunicipio, cbMunicipio, lblUF, cbUF, lblPais, cbPais, lblCNAE, txtCNAE, lblTelefone, txtTelefone, lblEstab, chkbEstab, lblTransportador, chkbTransportador);
        linha5.getChildren().addAll(lblPlaca, txtPlaca, lblUFTransp, cbUFTransportadora, lblANTT, txtANTT);
    
        bordaPainelTransporte.getChildren().addAll(lblTransporte, linha5);
        
        txtBuscarDescricao.setOnKeyPressed(e -> {
                if(BuscarDescricao().isEmpty()){
                    tabela.setItems(ListaEstabelecimento());
                }else{
                    tabela.setItems(BuscarDescricao());
                }
        });
        txtBuscarCNPJ.setOnKeyPressed(e -> {
                if(BuscarCNPJ().isEmpty()){
                    tabela.setItems(ListaEstabelecimento());
                }else{
                    tabela.setItems(BuscarCNPJ());
                }
        });
        
        cbBuscar.getItems().addAll("Razão Social ou Nome Fantasia", "CNPJ");
        
        cbBuscar.setOnAction(e -> {
            if(cbBuscar.getValue() == "Razão Social ou Nome Fantasia"){
                RsBuscar.getChildren().clear();
                RsBuscar.getChildren().addAll(txtBuscarDescricao);
            }else{
                RsBuscar.getChildren().clear();                
                RsBuscar.getChildren().addAll(txtBuscarCNPJ);
            }
        });
        painelBusca.getChildren().addAll(lblBuscar, cbBuscar, RsBuscar);
        
        chkbTransportador.setOnAction(e ->
        {
            if(chkbTransportador.isSelected()==true){
                bordaPainelTransporte.setVisible(true);
                
            }else{
                bordaPainelTransporte.setVisible(false);
            }
        });

        painelDados.setVgap(5);
        painelDados.setHgap(5);
        painelDados.add(linha1, 0, 0);
        painelDados.add(linha2, 0, 1);
        painelDados.add(linha3, 0, 2);
        painelDados.add(linha4, 0, 3);
        painelDados.add(bordaPainelTransporte, 0, 4);
        
        btnOK.setOnAction(e -> btnOK());
        
        btnAlterar.setOnAction(e -> btnAlterar());
        
        btnExcluir.setOnAction(e -> 
        {
            DadosEstabelecimento dados = tabela.getSelectionModel().getSelectedItem();
            if(dados == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{

                DeletarEstabelecimento.show("Tem certeza que deseja excluir este estabelecimento", "Confirmação de ação");
            }    
        });
        
        tabela.getColumns().addAll(colunaID, colunaRazao, colunaNome, colunaCNPJ);
        tabela.setItems(ListaEstabelecimento());
        
        bordaPainelBotoes.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: 5 5 5 5");
        bordaPainelBotoes.getChildren().add(painelBotoes);

        bordaPainelTransporte.setAlignment(lblTransporte, Pos.TOP_LEFT);
        bordaPainelTransporte.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -8 5 5 5");

        linha5.setPadding(new Insets(15));
        
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.getChildren().addAll(btnAdd, btnOK, btnAlterar, btnCancelar, btnEditar, btnExcluir, btnFechar);
        
        bordaPainelDados.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: -10 5 5 5");
        bordaPainelDados.setAlignment(msg, Pos.TOP_LEFT);
        msg.setStyle("-fx-background-color: #F4F4F4");
        lblTransporte.setStyle("-fx-background-color: #F4F4F4");
        
        bordaPainelDados.getChildren().addAll(msg, painelDados);
        bordaPainelDados.setPadding(new Insets(15));
        painelDados.setPadding(new Insets(15));
        
        btnFechar.setOnAction(e -> inicio.close());
        
        btnAdd.setOnAction(e -> btnAdicionar());
        
        btnEditar.setOnAction(e -> 
        {
            DadosEstabelecimento dados = tabela.getSelectionModel().getSelectedItem();
            if(dados == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{
                btnEditar();
            }
        });
        btnCancelar.setOnAction(e -> btnCancelar());
        
        telaPrincipal.setPadding(new Insets(15));
        telaPrincipal.getChildren().addAll(bordaPainelDados, painelBusca, tabela, bordaPainelBotoes);
        inicio.showAndWait();
    }
    
    public static ObservableList<DadosEstabelecimento> ListaEstabelecimento(){
        
	ObservableList<DadosEstabelecimento> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(consultaEstabelecimento);
		rs = stm.executeQuery(consultaEstabelecimento);

		while(rs.next()){
			int id = rs.getInt("ID");
                        String razaoSocial = rs.getString("RAZAOSOCIAL");
                        String nomeFantasia = rs.getString("NOMEFANTASIA");
                        String cnpj = rs.getString("CNPJ");
                        String IE = rs.getString("IE");
                        String IM = rs.getString("IM");
                        String IEST = rs.getString("IEST");
                        String CNAE = rs.getString("CNAE");
                        String regime = rs.getString("REGIMETRIBUTARIO");
                        String telefone = rs.getString("TELEFONE");
                        String logradouro = rs.getString("LOGRADOURO");
                        String nr = rs.getString("NR");
                        String cidade = rs.getString("CIDADE");
                        String estado = rs.getString("UF");
                        String pais = rs.getString("PAIS");
                        String cep = rs.getString("CEP");
                        String bairro = rs.getString("BAIRRO");
                        String estab = rs.getString("ESTAB");
                        String cpf = rs.getString("CPF");
                        String transportador = rs.getString("TRANSPORTADOR");
                        String placa = rs.getString("PLACA");
                        String UFTransportador = rs.getString("UF_TRANSPORTADOR");
                        String ANTT = rs.getString("ANTT_RNTC");
                        
			data.add(new DadosEstabelecimento(id, razaoSocial, nomeFantasia, cnpj, IE, IM, IEST, CNAE, regime, telefone, logradouro, nr, cidade, estado, pais, cep, bairro, estab, cpf, transportador, placa, UFTransportador, ANTT));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }
    public static ObservableList<DadosEstabelecimento> BuscarDescricao(){
        
	ObservableList<DadosEstabelecimento> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(pesquisaDescricao);
		rs = stm.executeQuery(pesquisaDescricao);

		while(rs.next()){
			int id = rs.getInt("ID");
                        String razaoSocial = rs.getString("RAZAOSOCIAL");
                        String nomeFantasia = rs.getString("NOMEFANTASIA");
                        String cnpj = rs.getString("CNPJ");
                        String IE = rs.getString("IE");
                        String IM = rs.getString("IM");
                        String IEST = rs.getString("IEST");
                        String CNAE = rs.getString("CNAE");
                        String regime = rs.getString("REGIMETRIBUTARIO");
                        String telefone = rs.getString("TELEFONE");
                        String logradouro = rs.getString("LOGRADOURO");
                        String nr = rs.getString("NR");
                        String cidade = rs.getString("CIDADE");
                        String estado = rs.getString("UF");
                        String pais = rs.getString("PAIS");
                        String cep = rs.getString("CEP");
                        String bairro = rs.getString("BAIRRO");
                        String estab = rs.getString("ESTAB");
                        String cpf = rs.getString("CPF");
                        String transportador = rs.getString("TRANSPORTADOR");
                        String placa = rs.getString("PLACA");
                        String UFTransportador = rs.getString("UF_TRANSPORTADOR");
                        String ANTT = rs.getString("ANTT_RNTC");
                        
			data.add(new DadosEstabelecimento(id, razaoSocial, nomeFantasia, cnpj, IE, IM, IEST, CNAE, regime, telefone, logradouro, nr, cidade, estado, pais, cep, bairro, estab, cpf, transportador, placa, UFTransportador, ANTT));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }
    public static ObservableList<DadosEstabelecimento> BuscarCNPJ(){
        
	ObservableList<DadosEstabelecimento> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(pesquisaCNPJ);
		rs = stm.executeQuery(pesquisaCNPJ);

		while(rs.next()){
			int id = rs.getInt("ID");
                        String razaoSocial = rs.getString("RAZAOSOCIAL");
                        String nomeFantasia = rs.getString("NOMEFANTASIA");
                        String cnpj = rs.getString("CNPJ");
                        String IE = rs.getString("IE");
                        String IM = rs.getString("IM");
                        String IEST = rs.getString("IEST");
                        String CNAE = rs.getString("CNAE");
                        String regime = rs.getString("REGIMETRIBUTARIO");
                        String telefone = rs.getString("TELEFONE");
                        String logradouro = rs.getString("LOGRADOURO");
                        String nr = rs.getString("NR");
                        String cidade = rs.getString("CIDADE");
                        String estado = rs.getString("UF");
                        String pais = rs.getString("PAIS");
                        String cep = rs.getString("CEP");
                        String bairro = rs.getString("BAIRRO");
                        String estab = rs.getString("ESTAB");
                        String cpf = rs.getString("CPF");
                        String transportador = rs.getString("TRANSPORTADOR");
                        String placa = rs.getString("PLACA");
                        String UFTransportador = rs.getString("UF_TRANSPORTADOR");
                        String ANTT = rs.getString("ANTT_RNTC");
                        
			data.add(new DadosEstabelecimento(id, razaoSocial, nomeFantasia, cnpj, IE, IM, IEST, CNAE, regime, telefone, logradouro, nr, cidade, estado, pais, cep, bairro, estab, cpf, transportador, placa, UFTransportador, ANTT));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }

    public static ObservableList<DadosMunicipio> ListaMunicipio(){
        
	ObservableList<DadosMunicipio> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(consultaCidade);
		rs = stm.executeQuery(consultaCidade);

		while(rs.next()){
			String nome = rs.getString("MUNICIPIO");

			data.add(new DadosMunicipio(nome));
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
    
    public static ObservableList<DadosPais> ListaPais(){
        
	ObservableList<DadosPais> data = FXCollections.observableArrayList();

	try{
                Connection conexao = Conexao.getConexao();
		stm = conexao.prepareStatement(consultaPais);
		rs = stm.executeQuery(consultaPais);

		while(rs.next()){
			String nome = rs.getString("PAIS");

			data.add(new DadosPais(nome));
		}
	}catch(Exception e){
		System.err.println(e);
	}
	return data;
    }
    public static void btnAdicionar(){
	
	txtRazaoSocial.setDisable(false);
	txtNomeFantasia.setDisable(false);
	txtCNPJ.setDisable(false);
	txtIE.setDisable(false);
	txtIM.setDisable(false);
	txtIEST.setDisable(false);
	txtLogradouro.setDisable(false);
	txtNrLogradouro.setDisable(false);
	txtBairro.setDisable(false);
	txtCEP.setDisable(false);
	txtTelefone.setDisable(false);
	txtCNAE.setDisable(false);
	cbMunicipio.setDisable(false);
	cbUF.setDisable(false);
	cbPais.setDisable(false);
	cbRegimeTributario.setDisable(false);
        chkbEstab.setDisable(false);
        txtCPF.setDisable(false);
        chkbTransportador.setDisable(false);
        
	btnAdd.setDisable(true);
	btnEditar.setDisable(true);
	btnAlterar.setDisable(true);
	btnExcluir.setDisable(true);
	btnCancelar.setDisable(false);
	btnOK.setDisable(false);
	btnFechar.setDisable(true);

	tabela.setDisable(true);
}	

public static void btnEditar(){
        
        DadosEstabelecimento dados = tabela.getSelectionModel().getSelectedItem();
        
        DadosMunicipio cidade = new DadosMunicipio(dados.getCidade());
        DadosPais pais = new DadosPais(dados.getPais());
        DadosEstado estado = new DadosEstado(dados.getEstado());
        DadosEstado UFTransportador = new DadosEstado(dados.getEstado());
        
        String estabelecimento = chkbEstab.getText();

        txtRazaoSocial.setText(dados.getRazaoSocial());
        txtNomeFantasia.setText(dados.getNomeFantasia());
        chkbEstab.setSelected(Boolean.valueOf(dados.getEstab()));
        txtRazaoSocial.setText(dados.getRazaoSocial());
        txtNomeFantasia.setText(dados.getNomeFantasia());
	txtCNPJ.setText(dados.getCNPJ());
	txtIE.setText(dados.getIE());
	txtIM.setText(dados.getIM());
	txtIEST.setText(dados.getIEST());
	txtCNAE.setText(dados.getCNAE());
	txtTelefone.setText(dados.getTelefone());
	txtLogradouro.setText(dados.getLogradouro());
	txtNrLogradouro.setText(dados.getNr());
	cbMunicipio.setValue(cidade);
	cbUF.setValue(estado);
	cbPais.setValue(pais);
	cbRegimeTributario.setValue(dados.getRegime());
        txtBairro.setText(dados.getBairro());
        txtCEP.setText(dados.getCEP());
        chkbEstab.setSelected(Boolean.valueOf(dados.getEstab()));
        txtCPF.setText(dados.getCPF());
        chkbTransportador.setSelected(Boolean.valueOf(dados.getTransportador()));
        txtPlaca.setText(dados.getPlaca());
        cbUFTransportadora.setValue(UFTransportador);
        txtANTT.setText(dados.getANTT());
        
        if(chkbTransportador.isSelected() == true){
            bordaPainelTransporte.setVisible(true); 
        }else{
            bordaPainelTransporte.setVisible(false);
        }
        
	txtRazaoSocial.setDisable(false);
	txtNomeFantasia.setDisable(false);
	txtCNPJ.setDisable(false);
	txtIE.setDisable(false);
	txtIM.setDisable(false);
	txtIEST.setDisable(false);
	txtLogradouro.setDisable(false);
	txtNrLogradouro.setDisable(false);
	txtBairro.setDisable(false);
	txtCEP.setDisable(false);
	txtTelefone.setDisable(false);
	txtCNAE.setDisable(false);
	cbMunicipio.setDisable(false);
	cbUF.setDisable(false);
	cbPais.setDisable(false);
	cbRegimeTributario.setDisable(false);
        chkbEstab.setDisable(false);
        txtCPF.setDisable(false);
        chkbTransportador.setDisable(false);
        
	btnAdd.setDisable(true);
	btnEditar.setDisable(true);
	btnAlterar.setDisable(false);
	btnExcluir.setDisable(true);
	btnCancelar.setDisable(false);
	btnOK.setDisable(true);
	btnFechar.setDisable(true);

	tabela.setDisable(true);
}	

public static void btnCancelar(){
	
	txtRazaoSocial.setDisable(true);
	txtNomeFantasia.setDisable(true);
	txtCNPJ.setDisable(true);
	txtIE.setDisable(true);
	txtIM.setDisable(true);
	txtIEST.setDisable(true);
	txtLogradouro.setDisable(true);
	txtNrLogradouro.setDisable(true);
	txtBairro.setDisable(true);
	txtCEP.setDisable(true);
	txtTelefone.setDisable(true);
	txtCNAE.setDisable(true);
	cbMunicipio.setDisable(true);
	cbUF.setDisable(true);
	cbPais.setDisable(true);
	cbRegimeTributario.setDisable(true);
	chkbEstab.setDisable(true);
        txtCPF.setDisable(true);
        chkbTransportador.setDisable(true);
        
        txtRazaoSocial.clear();
	txtNomeFantasia.clear();
	txtCNPJ.clear();
	txtIE.clear();
	txtIM.clear();
	txtIEST.clear();
	txtLogradouro.clear();
	txtNrLogradouro.clear();
	txtBairro.clear();
	txtCEP.clear();
	txtTelefone.clear();
	txtCNAE.clear();
	cbMunicipio.setValue(null);
	cbUF.setValue(null);
	cbPais.setValue(null);
	cbRegimeTributario.setValue(null);
	chkbEstab.setSelected(false);
        txtCPF.clear();
        txtPlaca.clear();
        txtANTT.clear();
        cbUFTransportadora.setValue(null);
        chkbTransportador.setSelected(false);

        bordaPainelTransporte.setVisible(false);
        
	btnAdd.setDisable(false);
	btnEditar.setDisable(false);
	btnAlterar.setDisable(true);
	btnExcluir.setDisable(false);
	btnCancelar.setDisable(true);
	btnOK.setDisable(true);
	btnFechar.setDisable(false);

	tabela.setDisable(false);
    }

    public static void btnOK(){
        
        try{
            DadosMunicipio cidade = cbMunicipio.getSelectionModel().getSelectedItem();
            DadosEstado estado = cbUF.getSelectionModel().getSelectedItem();
            DadosPais pais = cbPais.getSelectionModel().getSelectedItem();
            DadosEstado UFTransportadora = cbUFTransportadora.getSelectionModel().getSelectedItem();
            
            Connection conexao = Conexao.getConexao();
            
            String inserirDados = "insert into estabelecimento(razaosocial,nomefantasia,cnpj,IE,IM,IEST,telefone,CNAE,regimetributario,logradouro,nr,bairro,cidade,uf,pais,cep,estab,cpf,transportador,placa,UF_Transportador,ANTT_RNTC) values('"+txtRazaoSocial.getText()+"','"+txtNomeFantasia.getText()+"','"+txtCNPJ.getText().replace(".","").replace("-","").replace("/","")+"','"+txtIE.getText().replace(".","").replace("_","")+"','"+txtIM.getText().replace(".","").replace("_","")+"','"+txtIEST.getText().replace("_","")+"','"+txtTelefone.getText()+"','"+txtCNAE.getText()+"','"+cbRegimeTributario.getValue()+"','"+txtLogradouro.getText()+"','"+txtNrLogradouro.getText()+"','"+txtBairro.getText()+"','"+cidade.getMunicipio()+"','"+estado.getNome()+"','"+pais.getNome()+"','"+txtCEP.getText().replace("-", "")+"','"+chkbEstab.isSelected()+"','"+txtCPF.getText().replace(".","").replace("-","")+"','"+chkbTransportador.isSelected()+"','"+txtPlaca.getText().replace("-","").replace(".","").replace("_","")+"','"+UFTransportadora.getNome()+"','"+txtANTT.getText().replace("-","").replace(".","").replace("_","")+"')";
            
            PreparedStatement statement = conexao.prepareStatement(inserirDados);
            statement.execute(inserirDados);
            
            txtRazaoSocial.setDisable(true);
            txtNomeFantasia.setDisable(true);
            txtCNPJ.setDisable(true);
            txtIE.setDisable(true);
            txtIM.setDisable(true);
            txtIEST.setDisable(true);
            txtLogradouro.setDisable(true);
            txtNrLogradouro.setDisable(true);
            txtBairro.setDisable(true);
            txtCEP.setDisable(true);
            txtTelefone.setDisable(true);
            txtCNAE.setDisable(true);
            cbMunicipio.setDisable(true);
            cbUF.setDisable(true);
            cbPais.setDisable(true);
            cbRegimeTributario.setDisable(true);
            chkbEstab.setDisable(true);
            txtCPF.setDisable(true);
            chkbTransportador.setDisable(true);

            txtRazaoSocial.clear();
            txtNomeFantasia.clear();
            txtCNPJ.clear();
            txtIE.clear();
            txtIM.clear();
            txtIEST.clear();
            txtLogradouro.clear();
            txtNrLogradouro.clear();
            txtBairro.clear();
            txtCEP.clear();
            txtTelefone.clear();
            txtCNAE.clear();
            cbMunicipio.setValue(null);
            cbUF.setValue(null);
            cbPais.setValue(null);
            cbRegimeTributario.setValue(null);
            chkbEstab.setSelected(false);
            txtCPF.clear();
            chkbTransportador.setSelected(false);

            btnAdd.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);
            btnExcluir.setDisable(false);
            btnCancelar.setDisable(true);
            btnOK.setDisable(true);
            btnFechar.setDisable(false);

            tabela.setDisable(false);
            
            tabela.setItems(ListaEstabelecimento());
            
            conexao.close();
        }catch(Exception e){
            MessageBox.show(""+e,"Erro");
        } 
    }
    public static void btnAlterar(){
        
        try{
            DadosMunicipio cidade = cbMunicipio.getSelectionModel().getSelectedItem();
            DadosEstado estado = cbUF.getSelectionModel().getSelectedItem();
            DadosPais pais = cbPais.getSelectionModel().getSelectedItem();
            DadosEstabelecimento data = tabela.getSelectionModel().getSelectedItem();
            DadosEstado UFTransportadora = cbUFTransportadora.getSelectionModel().getSelectedItem();
            
            Connection conexao = Conexao.getConexao();
            
            String alterarDados = "update estabelecimento set razaosocial = '"+txtRazaoSocial.getText()+"', nomefantasia = '"+txtNomeFantasia.getText()+"', cnpj = '"+txtCNPJ.getText().replace(".","").replace("/", "").replace("-","")+"', IE = '"+txtIE.getText().replace(".","").replace("_","")+"', IM = '"+txtIM.getText().replace(".","").replace("_","")+"', IEST = '"+txtIEST.getText().replace(".","").replace("_","")+"', CNAE = '"+txtCNAE.getText()+"', telefone = '"+txtTelefone.getText()+"', regimetributario = '"+cbRegimeTributario.getValue()+"', logradouro = '"+txtLogradouro.getText()+"', nr = '"+txtNrLogradouro.getText()+"', bairro = '"+txtBairro.getText()+"', cidade = '"+cidade.getMunicipio()+"', uf = '"+estado.getNome()+"', pais = '"+pais.getNome()+"', cep = '"+txtCEP.getText().replace("-","")+"', estab = '"+chkbEstab.isSelected()+"', cpf = '"+txtCPF.getText().replace(".","").replace("-","")+"', transportador = '"+chkbTransportador.isSelected()+"', placa = '"+txtPlaca.getText().replace("-","").replace("_","").replace(".","")+"', UF_Transportador = '"+UFTransportadora.getNome()+"', ANTT_RNTC = '"+txtANTT.getText().replace("-","").replace(".","").replace("_","")+"' where id = '"+data.getId()+"'";
            
            PreparedStatement statement = conexao.prepareStatement(alterarDados);
            statement.execute(alterarDados);
            
            txtRazaoSocial.setDisable(true);
            txtNomeFantasia.setDisable(true);
            txtCNPJ.setDisable(true);
            txtIE.setDisable(true);
            txtIM.setDisable(true);
            txtIEST.setDisable(true);
            txtLogradouro.setDisable(true);
            txtNrLogradouro.setDisable(true);
            txtBairro.setDisable(true);
            txtCEP.setDisable(true);
            txtTelefone.setDisable(true);
            txtCNAE.setDisable(true);
            cbMunicipio.setDisable(true);
            cbUF.setDisable(true);
            cbPais.setDisable(true);
            cbRegimeTributario.setDisable(true);
            chkbEstab.setDisable(true);
            txtCPF.setDisable(true);
            chkbTransportador.setDisable(true);

            txtRazaoSocial.clear();
            txtNomeFantasia.clear();
            txtCNPJ.clear();
            txtIE.clear();
            txtIM.clear();
            txtIEST.clear();
            txtLogradouro.clear();
            txtNrLogradouro.clear();
            txtBairro.clear();
            txtCEP.clear();
            txtTelefone.clear();
            txtCNAE.clear();
            cbMunicipio.setValue(null);
            cbUF.setValue(null);
            cbPais.setValue(null);
            cbRegimeTributario.setValue(null);
            chkbEstab.setSelected(false);
            txtCPF.clear();
            chkbTransportador.setSelected(false);
            txtPlaca.clear();
            txtANTT.clear();
            cbUFTransportadora.setValue(null);
            bordaPainelTransporte.setVisible(false);
            
            btnAdd.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);
            btnExcluir.setDisable(false);
            btnCancelar.setDisable(true);
            btnOK.setDisable(true);
            btnFechar.setDisable(false);

            tabela.setDisable(false);
            
            tabela.setItems(ListaEstabelecimento());
            
            conexao.close();
        }catch(Exception e){
            MessageBox.show(""+e,"Erro");
        }         
    }
    public static void btnExcluir(){
        
        try{
            Connection conexao = Conexao.getConexao();
            DadosEstabelecimento data = tabela.getSelectionModel().getSelectedItem();
            String excluirDados = "delete from estabelecimento where id = '"+data.getId()+"'";
            PreparedStatement stm = conexao.prepareStatement(excluirDados);
            stm.execute(excluirDados);
            tabela.setItems(ListaEstabelecimento());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }
}
