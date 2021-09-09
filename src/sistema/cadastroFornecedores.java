package sistema;

import java.io.InputStream;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.event.*;
import java.sql.*;
import java.text.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.StringConverter;
import static sistema.Produto.ListaProdutos;
import static sistema.Produto.data;
import static sistema.Produto.tabela;

public class cadastroFornecedores{
        
        public static Label lblRazaoSocial = new Label("Razão Social");
        public static Label lblNomeFantasia = new Label("Nome Fantasia");
        public static Label lblCNPJ = new Label("CNPJ           ");
        public static Label lblIM = new Label("IM");
        public static Label lblIE = new Label("IE");
        public static Label lblLogradouro = new Label("Endereço    ");
        public static Label lblNrEndereco = new Label("Nrº");
        public static Label lblBairro = new Label("Bairro");
        public static Label lblMunicipio = new Label("Cidade");
        public static Label lblUF = new Label("UF               ");
        public static Label lblComplemento = new Label("Complemento");
        public static Label lblCEP = new Label("CEP");
        public static Label lblTel = new Label("Tel. Comercial");
        public static Label lblTel2 = new Label("Tel. Contato");
        public static Label lblTel3 = new Label("Tel. Celular");
        public static Label lblEmail = new Label("E-mail");
        public static Label lblTpContribuinte = new Label("Contibuinte");
        public static Label lblPais = new Label("País");
        public static Label lblBuscar = new Label("Buscar por");
        public static TableView<DadosFornecedor> tabela = new TableView<DadosFornecedor>();
        public static TableColumn<DadosFornecedor, Integer> colunaID;
        public static TableColumn<DadosFornecedor, String> colunaRazao;
        public static TableColumn<DadosFornecedor, String> colunaFantasia;
        public static TableColumn<DadosFornecedor, String> colunaCNPJ;
        public static TextField txtRazaoSocial = new TextField();
        public static TextField txtNomeFantasia = new TextField();
        public static MaskedTextField txtCNPJ = new MaskedTextField("##.###.###/####-##");
        public static MaskedTextField txtIM = new MaskedTextField("###.###.###");
        public static MaskedTextField txtIE = new MaskedTextField("###.###.###.###");
        public static TextField txtLogradouro = new TextField();
        public static TextField txtNrEndereco = new TextField();
        public static TextField txtBairro = new TextField();
        public static ComboBox<DadosMunicipio> cbMunicipio = new ComboBox<DadosMunicipio>();
        //public static TextField txtMunicipio = new TextField();
        public static ComboBox<DadosEstado> cbUF = new ComboBox<DadosEstado>();
        public static TextField txtComplemento = new TextField();
        public static MaskedTextField txtCEP = new MaskedTextField("#####-###");
        public static MaskedTextField txtTel = new MaskedTextField("(##)####-####");
        public static MaskedTextField txtTel2 = new MaskedTextField("(##)####-####");
        public static MaskedTextField txtTel3 = new MaskedTextField("(##)#####-####");
        public static TextField txtEmail = new TextField();
        public static ComboBox cbTpContribuinte = new ComboBox();
        public static ComboBox<DadosPais> cbPais = new ComboBox<DadosPais>();
        public static ComboBox cbBuscar = new ComboBox();
        public static TextField txtBuscarDescricao = new TextField();
        public static TextField txtBuscarID_CNPJ = new TextField();
        public static Button btnAdd = new Button("Adicionar");
        public static Button btnEditar = new Button("Editar");
        public static Button btnCancelar = new Button("Cancelar");
        public static Button btnExcluir = new Button("Excluir");
        public static Button btnAlterar = new Button("Alterar");
        public static Button btnFechar = new Button("Fechar");
        public static Button btnOK = new Button("Ok");
        public static void show(String mensagem, String titulo){
            
            colunaID = new TableColumn<DadosFornecedor, Integer>("Código");
            colunaRazao = new TableColumn<DadosFornecedor, String>("Razão Social");
            colunaFantasia = new TableColumn<DadosFornecedor, String>("Nome Fantasia");
            colunaCNPJ = new TableColumn<DadosFornecedor, String>("Cnpj");
            
            Stage inicio = new Stage();
            VBox tela = new VBox(15);
            
            HBox linha1 = new HBox(15);
            HBox linha2 = new HBox(15);
            HBox linha3 = new HBox(15);
            HBox linha4 = new HBox(15);
            HBox linha5 = new HBox(15);
            HBox pBotoes = new HBox(5);
            
            Scene cenario = new Scene(tela, 1100, 520);
            Label msg = new Label(mensagem);
            StackPane painelPrincipal = new StackPane();
            StackPane painelBotoes = new StackPane();
            Popup painelTabela = new Popup();
            GridPane painelCadastro = new GridPane();
            HBox painelBusca = new HBox(5);
            HBox BuscarItens = new HBox(5);
            
            colunaID.setCellValueFactory(new PropertyValueFactory<DadosFornecedor, Integer>("ID"));
            colunaID.setPrefWidth(70);
            colunaRazao.setCellValueFactory(new PropertyValueFactory<DadosFornecedor, String>("razaoSocial"));
            colunaRazao.setPrefWidth(300);
            colunaFantasia.setCellValueFactory(new PropertyValueFactory<DadosFornecedor, String>("nomeFantasia"));
            colunaFantasia.setPrefWidth(200);
            colunaCNPJ.setCellValueFactory(new PropertyValueFactory<DadosFornecedor, String>("CNPJ"));
            colunaCNPJ.setPrefWidth(200);
        
            btnAdd.setGraphic(Login.imageViewAdicionar);
            btnEditar.setGraphic(Login.imageViewEditar);
            btnCancelar.setGraphic(Login.imageViewCancelar);
            btnExcluir.setGraphic(Login.imageViewExcluir);
            btnAlterar.setGraphic(Login.imageViewOk);
            btnOK.setGraphic(Login.imageViewSalvar);
            btnFechar.setGraphic(Login.imageViewFechar);
            
            tabela.getColumns().addAll(colunaID, colunaRazao, colunaFantasia, colunaCNPJ);
            
            tabela.setItems(ListaFornecedores());
            
            lblRazaoSocial.setStyle("-fx-font-weight: bold");
            lblNomeFantasia.setStyle("-fx-font-weight: bold");
            lblTpContribuinte.setStyle("-fx-font-weight: bold");
            lblLogradouro.setStyle("-fx-font-weight: bold");
            lblNrEndereco.setStyle("-fx-font-weight: bold");
            lblCEP.setStyle("-fx-font-weight: bold");
            lblMunicipio.setStyle("-fx-font-weight: bold");
            lblUF.setStyle("-fx-font-weight: bold");
            lblBairro.setStyle("-fx-font-weight: bold");
            lblIE.setStyle("-fx-font-weight: bold");
            lblIM.setStyle("-fx-font-weight: bold");
            lblCNPJ.setStyle("-fx-font-weight: bold");
            lblEmail.setStyle("-fx-font-weight: bold");            
            lblTel.setStyle("-fx-font-weight: bold");
            lblTel2.setStyle("-fx-font-weight: bold");
            lblTel3.setStyle("-fx-font-weight: bold");
            lblPais.setStyle("-fx-font-weight: bold");
            lblBuscar.setStyle("-fx-font-weight: bold");
            
            txtRazaoSocial.setPrefWidth(270);
            txtNomeFantasia.setPrefWidth(240);
            txtTel.setPrefWidth(100);
            txtTel2.setPrefWidth(100);
            txtTel3.setPrefWidth(100);
            txtCNPJ.setPrefWidth(150);
            cbTpContribuinte.setPrefWidth(90);
            txtLogradouro.setPrefWidth(350);
            txtNrEndereco.setPrefWidth(60);
            txtEmail.setPrefWidth(300);
            txtBuscarDescricao.setPrefWidth(300);
            txtBuscarID_CNPJ.setPrefWidth(300);
                       
            txtRazaoSocial.setDisable(true);
            txtNomeFantasia.setDisable(true);
            txtCNPJ.setDisable(true);
            txtIE.setDisable(true);
            txtIM.setDisable(true);
            txtLogradouro.setDisable(true);
            txtNrEndereco.setDisable(true);
            txtCEP.setDisable(true);
            cbUF.setDisable(true);
            cbTpContribuinte.setDisable(true);
            txtTel.setDisable(true);
            txtTel2.setDisable(true);
            txtTel3.setDisable(true);
            cbMunicipio.setDisable(true);
            txtEmail.setDisable(true);
            cbPais.setDisable(true);
            txtBairro.setDisable(true);
            
            btnAdd.setDisable(false);
            btnCancelar.setDisable(true);
            btnAlterar.setDisable(true);
            btnOK.setDisable(true);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            
            cbTpContribuinte.getItems().addAll("1 - Contribuinte ICMS", "2 - Contribuinte ISENTO", "9 - Não COntribuinte");
            
            tela.setPadding(new Insets(9));
            tela.getChildren().addAll(painelPrincipal, painelBusca, tabela, painelBotoes);
            
            pBotoes.setAlignment(Pos.CENTER);
            
            painelBotoes.getChildren().addAll(pBotoes);
            pBotoes.getChildren().addAll(btnAdd, btnOK, btnAlterar, btnCancelar, btnEditar, btnExcluir, btnFechar);
            
            btnOK.setOnAction(e -> btnOK());
            
            linha1.setPadding(new Insets(5));
            linha2.setPadding(new Insets(5));
            linha3.setPadding(new Insets(5));
            linha4.setPadding(new Insets(5));
            linha5.setPadding(new Insets(5));
            
            linha1.getChildren().addAll(lblRazaoSocial, txtRazaoSocial, lblNomeFantasia, txtNomeFantasia, lblTpContribuinte, cbTpContribuinte);
            linha2.getChildren().addAll(lblCNPJ, txtCNPJ, lblIE, txtIE, lblIM, txtIM);
            linha3.getChildren().addAll(lblTel, txtTel, lblTel2, txtTel2, lblTel3, txtTel3);
            linha4.getChildren().addAll(lblLogradouro, txtLogradouro, lblNrEndereco, txtNrEndereco, lblBairro, txtBairro, lblMunicipio, cbMunicipio);
            linha5.getChildren().addAll(lblUF, cbUF, lblCEP, txtCEP, lblPais, cbPais, lblEmail, txtEmail);
                    
            painelCadastro.setVgap(5);
            painelCadastro.setHgap(5);
            painelCadastro.add(linha1, 0, 0);
            painelCadastro.add(linha2, 0, 1);
            painelCadastro.add(linha3, 0, 2);
            painelCadastro.add(linha4, 0, 3);
            painelCadastro.add(linha5, 0, 4);
            
            painelCadastro.setPadding(new Insets(15));
            
            cbMunicipio.setConverter(new StringConverter<DadosMunicipio>() {
            @Override
            public String toString(DadosMunicipio object) {
                if(object!=null){
                    return object.getMunicipio();
                }
                return null;
            }
            @Override
            public DadosMunicipio fromString(String string) {
                return null;
                }
            });
            
            btnAlterar.setOnAction(e -> btnAlterar());
            
            btnEditar.setOnAction(e -> btnEditar());
            
            cbMunicipio.setPrefWidth(100);
            
            cbMunicipio.getItems().addAll(ListaCidades());
            cbUF.getItems().addAll(ListaEstado());
            
            cbUF.setConverter(new StringConverter<DadosEstado>() {
            @Override
            public String toString(DadosEstado object) {
                if(object!=null){
                    return object.getNome();
                }
                return null;
            }
            @Override
            public DadosEstado fromString(String string) {
                return null;
                }
            });
            
            cbPais.getItems().addAll(ListaPais());
            
            cbPais.setConverter(new StringConverter<DadosPais>() {
            @Override
            public String toString(DadosPais object) {
                if(object!=null){
                    return object.getNome();
                }
                return null;
            }
            @Override
            public DadosPais fromString(String string) {
                return null;
                }
            });
            
            cbPais.setPrefWidth(90);
            
            painelPrincipal.setAlignment(msg, Pos.TOP_LEFT);
            painelPrincipal.setStyle("-fx-border-radius: 2; -fx-padding: -10 5 5 5; -fx-border-insets: -3 15 15 15; -fx-border-color: gray;");
            msg.setStyle("-fx-background-color: #F4F4F4");
            
            painelBotoes.setStyle("-fx-border-radius: 2; -fx-padding: 0 5 5 5; -fx-border-insets: -5 15 15 15; -fx-border-color: gray;");
            
            painelPrincipal.setPadding(new Insets(15));
            painelPrincipal.getChildren().addAll(msg, painelCadastro);

            cbBuscar.getItems().addAll("ID ou CNPJ", "Razão Social ou Nome Fantasia");

            painelBusca.getChildren().addAll(lblBuscar, cbBuscar, BuscarItens);
            
            btnCancelar.setOnAction(e -> btnCancelar());
            btnAdd.setOnAction(e -> btnAdicionar());

            btnExcluir.setOnAction(e -> DeleteFornecedor.show("Tem certeza que deseja excluir este fornecedor?", "Excluir Fornecedor"));
            txtBuscarDescricao.setOnKeyPressed(e -> { 
            if(BuscarDescricao().isEmpty()){
                    tabela.setItems(ListaFornecedores());
                }else{
                    tabela.setItems(BuscarDescricao());
                }
            });
            txtBuscarID_CNPJ.setOnKeyPressed(e -> {
            if(BuscarID_CNPJ().isEmpty()){
                    tabela.setItems(ListaFornecedores());
                }else{  
                    tabela.setItems(BuscarID_CNPJ());
                }
            });
            
            cbBuscar.setOnAction( e -> {
                if(cbBuscar.getValue() == "ID ou CNPJ"){
                        BuscarItens.getChildren().clear();
        		BuscarItens.getChildren().add(txtBuscarID_CNPJ);		
        	}else if(cbBuscar.getValue() == "Razão Social ou Nome Fantasia"){
                        BuscarItens.getChildren().clear();
        		BuscarItens.getChildren().add(txtBuscarDescricao);
        	}
            });

            inicio.setScene(cenario);
            inicio.initModality(Modality.APPLICATION_MODAL);
            inicio.setTitle(titulo);
            btnFechar.setOnAction(e -> inicio.close());
            
            inicio.showAndWait();
        }
        public static ObservableList<DadosFornecedor> ListaFornecedores(){
            ObservableList<DadosFornecedor> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT * FROM FORNECEDOR;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){
                    int codigo = rs.getInt("ID");
                    String razaoSocial = rs.getString("RAZAOSOCIAL");
                    String nomeFantasia = rs.getString("NOMEFANTASIA");
                    String Contribuinte = rs.getString("CONTRIBUINTE");
                    String CNPJ = rs.getString("CNPJ");
                    String IE = rs.getString("IE");
                    String logradouro = rs.getString("LOGRADOURO");
                    String bairro = rs.getString("BAIRRO");
                    String nrEndereco = rs.getString("NR_ENDERECO");
                    String UF = rs.getString("UF");
                    String municipio = rs.getString("MUNICIPIO");
                    String CEP = rs.getString("CEP");
                    String tel = rs.getString("TEL");
                    String tel2 = rs.getString("TEL2");
                    String tel3 = rs.getString("TEL3");
                    String email = rs.getString("EMAIL");
                    String pais = rs.getString("PAIS");
                    String IM = rs.getString("IM");
                    
                    dados.add(new DadosFornecedor(codigo, razaoSocial, nomeFantasia, Contribuinte, CNPJ, IE, logradouro, nrEndereco, bairro, municipio, UF, CEP, tel, tel2, tel3, email, pais, IM));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
        public static ObservableList<DadosMunicipio> ListaCidades(){
            ObservableList<DadosMunicipio> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT municipio FROM municipios ORDER BY municipio;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){

                    String nome = rs.getString("MUNICIPIO");
                    
                    dados.add(new DadosMunicipio(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
        public static ObservableList<DadosMunicipio> BuscaCidades(){
            ObservableList<DadosMunicipio> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT * FROM municipios ORDER BY municipio);";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                while(rs.next()){

                    String nome = rs.getString("MUNICIPIO");                    
                    dados.add(new DadosMunicipio(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }

        public static ObservableList<DadosEstado> ListaEstado(){
            ObservableList<DadosEstado> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT sigla_uf FROM municipios GROUP BY sigla_uf;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                while(rs.next()){
                    String nome = rs.getString("sigla_uf");
                    
                    dados.add(new DadosEstado(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
        public static ObservableList<DadosPais> ListaPais(){
            ObservableList<DadosPais> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT pais FROM moedas GROUP BY pais;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                while(rs.next()){
                    String nome = rs.getString("pais");
                    
                    dados.add(new DadosPais(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
        public static void btnAdicionar(){
            
            txtRazaoSocial.setDisable(false);
            txtNomeFantasia.setDisable(false);
            txtCNPJ.setDisable(false);
            txtIE.setDisable(false);
            txtIM.setDisable(false);
            txtLogradouro.setDisable(false);
            txtNrEndereco.setDisable(false);
            txtCEP.setDisable(false);
            cbUF.setDisable(false);
            cbTpContribuinte.setDisable(false);
            txtTel.setDisable(false);
            txtTel2.setDisable(false);
            txtTel3.setDisable(false);
            cbMunicipio.setDisable(false);
            txtEmail.setDisable(false);
            cbPais.setDisable(false);
            txtBairro.setDisable(false);
            txtBuscarID_CNPJ.setDisable(true);
            txtBuscarDescricao.setDisable(true);
            txtBuscarID_CNPJ.setDisable(true);
            txtBuscarDescricao.setDisable(true);
	    cbBuscar.setDisable(true);
            
            btnAdd.setDisable(true);
            btnCancelar.setDisable(false);
            btnOK.setDisable(false);
            btnAlterar.setDisable(true);
            btnFechar.setDisable(true);
            btnEditar.setDisable(true);
            btnExcluir.setDisable(true);
        }
        public static void btnCancelar(){
            txtRazaoSocial.setDisable(true);
            txtNomeFantasia.setDisable(true);
            txtCNPJ.setDisable(true);
            txtIE.setDisable(true);
            txtIM.setDisable(true);
            txtLogradouro.setDisable(true);
            txtNrEndereco.setDisable(true);
            txtCEP.setDisable(true);
            cbUF.setDisable(true);
            cbTpContribuinte.setDisable(true);
            txtTel.setDisable(true);
            txtTel2.setDisable(true);
            txtTel3.setDisable(true);
            cbMunicipio.setDisable(true);
            txtEmail.setDisable(true);
            cbPais.setDisable(true);
            txtBairro.setDisable(true);           
            txtBuscarID_CNPJ.setDisable(false);
            txtBuscarDescricao.setDisable(false);
            txtBuscarID_CNPJ.setDisable(false);
            txtBuscarDescricao.setDisable(false);
	    cbBuscar.setDisable(false);
            
            txtRazaoSocial.clear();
            txtNomeFantasia.clear();
            txtCNPJ.clear();
            txtIE.clear();
            txtIM.clear();
            txtLogradouro.clear();
            txtNrEndereco.clear();
            txtCEP.clear();
            cbUF.setValue(null);
            cbTpContribuinte.setValue("");
            txtTel.clear();
            txtTel2.clear();
            txtTel3.clear();
            cbMunicipio.setValue(null);
            txtEmail.clear();
            cbPais.setValue(null);
            txtBairro.clear();           
            txtBuscarID_CNPJ.clear();
            txtBuscarDescricao.clear();
	    cbBuscar.setValue("");		

            tabela.setDisable(false);
            
            btnAdd.setDisable(false);
            btnCancelar.setDisable(true);
            btnOK.setDisable(true);
            btnAlterar.setDisable(true);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            btnExcluir.setDisable(false);
        }
        public static void btnOK(){
            
            ResultSet rs;
            
            DadosMunicipio cidade = cbMunicipio.getSelectionModel().getSelectedItem();
            DadosEstado estado = cbUF.getSelectionModel().getSelectedItem();
            DadosPais pais = cbPais.getSelectionModel().getSelectedItem();
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "INSERT INTO FORNECEDOR(RAZAOSOCIAL,NOMEFANTASIA,CNPJ,IE,IM,LOGRADOURO,NR_ENDERECO,MUNICIPIO,UF,CEP,TEL,TEl2,TEL3,EMAIL,PAIS,CONTRIBUINTE,BAIRRO) VALUES('"+txtRazaoSocial.getText()+"','"+txtNomeFantasia.getText()+"','"+txtCNPJ.getText().replace(".", "").replace("/", "").replace("-", "")+"','"+txtIE.getText().replace(".","")+"','"+txtIM.getText().replace(".","")+"','"+txtLogradouro.getText()+"','"+txtNrEndereco.getText()+"','"+cidade.getMunicipio()+"','"+estado.getNome()+"','"+txtCEP.getText().replaceAll("-", "")+"','"+txtTel.getText()+"','"+txtTel2.getText()+"','"+txtTel3.getText()+"','"+txtEmail.getText()+"','"+pais.getNome()+"','"+cbTpContribuinte.getValue()+"','"+txtBairro.getText()+"');";    
                Statement st = conexao.prepareStatement(sql);    
                st.execute(sql);

                conexao.close();

                txtRazaoSocial.setDisable(true);
                txtNomeFantasia.setDisable(true);
                txtCNPJ.setDisable(true);
                txtIE.setDisable(true);
                txtIM.setDisable(true);
                txtLogradouro.setDisable(true);
                txtNrEndereco.setDisable(true);
                txtCEP.setDisable(true);
                cbUF.setDisable(true);
                cbTpContribuinte.setDisable(true);
                txtTel.setDisable(true);
                txtTel2.setDisable(true);
                txtTel3.setDisable(true);
                cbMunicipio.setDisable(true);
                txtEmail.setDisable(true);
                cbPais.setDisable(true);
                txtBairro.setDisable(true);           
                txtBuscarID_CNPJ.setDisable(false);
                txtBuscarDescricao.setDisable(false);
                txtBuscarID_CNPJ.setDisable(false);
                txtBuscarDescricao.setDisable(false);
                cbBuscar.setDisable(false);

                txtRazaoSocial.clear();
                txtNomeFantasia.clear();
                txtCNPJ.clear();
                txtIE.clear();
                txtIM.clear();
                txtLogradouro.clear();
                txtNrEndereco.clear();
                txtCEP.clear();
                cbUF.setValue(null);
                cbTpContribuinte.setValue("");
                txtTel.clear();
                txtTel2.clear();
                txtTel3.clear();
                cbMunicipio.setValue(null);
                txtEmail.clear();
                cbPais.setValue(null);
                txtBairro.clear();           
                txtBuscarID_CNPJ.clear();
                txtBuscarDescricao.clear();
                cbBuscar.setValue("");		


                btnAdd.setDisable(false);
                btnCancelar.setDisable(true);
                btnOK.setDisable(true);
                btnAlterar.setDisable(true);
                btnFechar.setDisable(false);
                btnEditar.setDisable(false);
                btnExcluir.setDisable(false);

                tabela.setItems(ListaFornecedores());
                }catch(Exception err){
                    System.err.println(err);
                }
            
        }
        public static void btnAlterar(){
            ResultSet rs;
            DadosFornecedor dados = tabela.getSelectionModel().getSelectedItem();
            DadosMunicipio cidade = cbMunicipio.getSelectionModel().getSelectedItem();
            DadosEstado estado = cbUF.getSelectionModel().getSelectedItem();
            DadosPais pais = cbPais.getSelectionModel().getSelectedItem();
            
            try{

                Connection conexao = Conexao.getConexao();
                String sql = "UPDATE FORNECEDOR SET RAZAOSOCIAL = '"+txtRazaoSocial.getText()+"',NOMEFANTASIA = '"+txtNomeFantasia.getText()+"',CNPJ = '"+txtCNPJ.getText().replace(".", "").replace("/", "").replace("-", "")+"',IE = '"+txtIE.getText().replace(".","")+"',IM = '"+txtIM.getText().replace(".","")+"',LOGRADOURO = '"+txtLogradouro.getText()+"',NR_ENDERECO = '"+txtNrEndereco.getText()+"',MUNICIPIO = '"+cidade.getMunicipio()+"',UF = '"+estado.getNome()+"',CEP = '"+txtCEP.getText().replaceAll("-", "")+"',TEL = '"+txtTel.getText()+"',TEl2 = '"+txtTel2.getText()+"',TEL3 = '"+txtTel3.getText()+"',EMAIL = '"+txtEmail.getText()+"',PAIS = '"+pais.getNome()+"',CONTRIBUINTE = '"+cbTpContribuinte.getValue().toString()+"',BAIRRO = '"+txtBairro.getText()+"' WHERE ID = '"+dados.getID()+"';";    
                Statement st = conexao.prepareStatement(sql);    
                st.execute(sql);

                conexao.close();

                txtRazaoSocial.setDisable(true);
                txtNomeFantasia.setDisable(true);
                txtCNPJ.setDisable(true);
                txtIE.setDisable(true);
                txtIM.setDisable(true);
                txtLogradouro.setDisable(true);
                txtNrEndereco.setDisable(true);
                txtCEP.setDisable(true);
                cbUF.setDisable(true);
                cbTpContribuinte.setDisable(true);
                txtTel.setDisable(true);
                txtTel2.setDisable(true);
                txtTel3.setDisable(true);
                cbMunicipio.setDisable(true);
                txtEmail.setDisable(true);
                cbPais.setDisable(true);
                txtBairro.setDisable(true);           
                txtBuscarID_CNPJ.setDisable(false);
                txtBuscarDescricao.setDisable(false);
                txtBuscarID_CNPJ.setDisable(false);
                txtBuscarDescricao.setDisable(false);
                cbBuscar.setDisable(false);

                txtRazaoSocial.clear();
                txtNomeFantasia.clear();
                txtCNPJ.clear();
                txtIE.clear();
                txtIM.clear();
                txtLogradouro.clear();
                txtNrEndereco.clear();
                txtCEP.clear();
                cbUF.setValue(null);
                cbTpContribuinte.setValue("");
                txtTel.clear();
                txtTel2.clear();
                txtTel3.clear();
                cbMunicipio.setValue(null);
                txtEmail.clear();
                cbPais.setValue(null);
                txtBairro.clear();           
                txtBuscarID_CNPJ.clear();
                txtBuscarDescricao.clear();
                cbBuscar.setValue("");		


                btnAdd.setDisable(false);
                btnCancelar.setDisable(true);
                btnOK.setDisable(true);
                btnAlterar.setDisable(true);
                btnFechar.setDisable(false);
                btnEditar.setDisable(false);
                btnExcluir.setDisable(false);

                tabela.setDisable(false);

                tabela.setItems(ListaFornecedores());
                }catch(Exception err){
                    System.err.println(err);
                }
        }
        public static void btnEditar(){
            
            DadosFornecedor dados = tabela.getSelectionModel().getSelectedItem();
            DadosMunicipio dadosCidade = new DadosMunicipio(dados.getMunicipio());
            DadosPais dadosPais = new DadosPais(dados.getPais());
            DadosEstado dadosEstado = new DadosEstado(dados.getUF());
            
            txtRazaoSocial.setText(dados.getRazaoSocial());
            txtNomeFantasia.setText(dados.getNomeFantasia());
            txtIE.setText(dados.getIE());
            txtIM.setText(dados.getIM());
            txtCNPJ.setText(dados.getCNPJ());
            txtLogradouro.setText(dados.getLogradouro());
            txtNrEndereco.setText(dados.getNrEndereco());
            txtBairro.setText(dados.getBairro());
            cbTpContribuinte.setValue(dados.getContribuinte());
            txtCNPJ.setText(dados.getCNPJ());
            txtCEP.setText(dados.getCEP());
            txtTel.setText(dados.getTel());
            txtTel2.setText(dados.getTel2());
            txtTel3.setText(dados.getTel3());
            txtEmail.setText(dados.getEmail());
            cbMunicipio.setValue(dadosCidade);
            cbUF.setValue(dadosEstado);
            cbPais.setValue(dadosPais);
            
            txtRazaoSocial.setDisable(false);
            txtNomeFantasia.setDisable(false);
            txtCNPJ.setDisable(false);
            txtIE.setDisable(false);
            txtIM.setDisable(false);
            txtLogradouro.setDisable(false);
            txtNrEndereco.setDisable(false);
            txtCEP.setDisable(false);
            cbUF.setDisable(false);
            cbTpContribuinte.setDisable(false);
            txtTel.setDisable(false);
            txtTel2.setDisable(false);
            txtTel3.setDisable(false);
            cbMunicipio.setDisable(false);
            txtEmail.setDisable(false);
            cbPais.setDisable(false);
            txtBairro.setDisable(false);
            txtBuscarID_CNPJ.setDisable(true);
            txtBuscarDescricao.setDisable(true);
            txtBuscarID_CNPJ.setDisable(true);
            txtBuscarDescricao.setDisable(true);
	    cbBuscar.setDisable(true);
            
            btnAdd.setDisable(true);
            btnCancelar.setDisable(false);
            btnOK.setDisable(true);
            btnAlterar.setDisable(false);
            btnFechar.setDisable(true);
            btnEditar.setDisable(true);
            btnExcluir.setDisable(true);
            
            tabela.setDisable(true);
            }
    public static void btnExcluir(){
        
        DadosFornecedor data = tabela.getSelectionModel().getSelectedItem();             
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM FORNECEDOR WHERE ID = '"+data.getID()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            if(data == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{
            stm.execute(sql);
            tabela.setItems(ListaFornecedores());
            conexao.close();
            }
        }catch(Exception ex){
            MessageBox.show(""+ex, "Erro");
        }
    }
    public static ObservableList<DadosFornecedor> BuscarDescricao(){
        
            ObservableList<DadosFornecedor> dado = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT * FROM FORNECEDOR WHERE RAZAOSOCIAL LIKE '%"+txtBuscarDescricao.getText()+"%' XOR NOMEFANTASIA LIKE '%"+txtBuscarDescricao.getText()+"%';";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                while(rs.next()){
                    int codigo = rs.getInt("ID");
                    String razaoSocial = rs.getString("RAZAOSOCIAL");
                    String nomeFantasia = rs.getString("NOMEFANTASIA");
                    String Contribuinte = rs.getString("CONTRIBUINTE");
                    String CNPJ = rs.getString("CNPJ");
                    String IE = rs.getString("IE");
                    String logradouro = rs.getString("LOGRADOURO");
                    String bairro = rs.getString("BAIRRO");
                    String nrEndereco = rs.getString("NR_ENDERECO");
                    String UF = rs.getString("UF");
                    String municipio = rs.getString("MUNICIPIO");
                    String CEP = rs.getString("CEP");
                    String tel = rs.getString("TEL");
                    String tel2 = rs.getString("TEL2");
                    String tel3 = rs.getString("TEL3");
                    String email = rs.getString("EMAIL");
                    String pais = rs.getString("PAIS");
                    String IM = rs.getString("IM");
                    
                    dado.add(new DadosFornecedor(codigo, razaoSocial, nomeFantasia, Contribuinte, CNPJ, IE, logradouro, nrEndereco, bairro, municipio, UF, CEP, tel, tel2, tel3, email, pais, IM));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dado;
        }
        public static ObservableList<DadosFornecedor> BuscarID_CNPJ(){
            ObservableList<DadosFornecedor> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT * FROM FORNECEDOR WHERE ID = "+txtBuscarID_CNPJ.getText()+" OR CNPJ LIKE '%"+txtBuscarID_CNPJ.getText()+"%';";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                while(rs.next()){
                    int codigo = rs.getInt("ID");
                    String razaoSocial = rs.getString("RAZAOSOCIAL");
                    String nomeFantasia = rs.getString("NOMEFANTASIA");
                    String Contribuinte = rs.getString("CONTRIBUINTE");
                    String CNPJ = rs.getString("CNPJ");
                    String IE = rs.getString("IE");
                    String logradouro = rs.getString("LOGRADOURO");
                    String bairro = rs.getString("BAIRRO");
                    String nrEndereco = rs.getString("NR_ENDERECO");
                    String UF = rs.getString("UF");
                    String municipio = rs.getString("MUNICIPIO");
                    String CEP = rs.getString("CEP");
                    String tel = rs.getString("TEL");
                    String tel2 = rs.getString("TEL2");
                    String tel3 = rs.getString("TEL3");
                    String email = rs.getString("EMAIL");
                    String pais = rs.getString("PAIS");
                    String IM = rs.getString("IM");
                    
                    dados.add(new DadosFornecedor(codigo, razaoSocial, nomeFantasia, Contribuinte, CNPJ, IE, logradouro, nrEndereco, bairro, municipio, UF, CEP, tel, tel2, tel3, email, pais, IM));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
}
