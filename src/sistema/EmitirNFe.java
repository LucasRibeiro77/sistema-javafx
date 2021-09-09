package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;

public class EmitirNFe {
    
    public static Stage inicio;
    public static VBox painelPrincipal;
    public static VBox painelBotoesChave;
    public static StackPane painelBotoes;
    public static HBox painelTxtChave;
    public static HBox linha1;
    public static HBox linha2;
    public static HBox linha3;
    public static HBox linha4;
    public static HBox linha5;
    public static Scene cenario;
    public static Label lblNumeroNFe;
    public static Label lblCFOP;
    public static Label lblTransportadora ;
    public static Label lblQtde;
    public static Label lblEspecie;
    public static Label lblMarca;
    public static Label lblNumeracao;
    public static Label lblPesoBrutoLiquido;
    public static Label lblPesoBruto;
    public static Label lblPesoLiquido;
    public static Label lblModalidadeFrete;
    public static Label lblTipoDocumento;
    public static Label lblFinalidade;
    public static Label lblConsumidorFinal;
    public static Label lblChaveReferencia;
    public static ComboBox cbModalidadeFrete;
    public static ComboBox cbTipoDocumento;
    public static ComboBox cbFinalidade;
    public static ComboBox cbDestinoOperacao;
    public static CheckBox cbPesoBrutoLiquido;
    public static ComboBox cbTipoAtendimento;
    public static ComboBox cbCFOP;
    public static ComboBox cbTransportadora;
    public static TableView<DadosChave> tabela;
    public static TableColumn<DadosChave, String> colunaChave;
    public static TextField txtNrNota;
    public static TextField txtChaveReferencia;
    public static TextField txtEspecie;
    public static TextField txtMarca;
    public static TextField txtNumeracao;
    public static TextField txtPesoBruto;
    public static TextField txtPesoLiquido;
    public static Button btnAdd;
    public static Button btnEditar;
    public static Button btnAlterar;
    public static Button btnExcluir;
    public static Button btnCancel;
    public static Button btnCancelar;
    public static Button btnOK;
    
    public static void show(String message, String title){
        
        btnAdd = new Button("Adicionar");
        btnAlterar = new Button("Alterar");
        btnAlterar.setPrefWidth(80);
        btnEditar = new Button("Editar");
        btnEditar.setPrefWidth(80);
        btnExcluir = new Button("Excluir");
        btnExcluir.setPrefWidth(80);
        btnCancel = new Button("Cancelar");
        btnCancel.setPrefWidth(80);
        btnCancelar = new Button("Cancelar");
        btnOK = new Button("Avançar");
        lblPesoBrutoLiquido = new Label("Habilita Peso Bruto/ Líq.");
        painelBotoes = new StackPane();
        painelPrincipal = new VBox(5);
        
        cenario = new Scene(painelPrincipal, 1002, 520);
        
        painelTxtChave = new HBox(5);
        painelBotoesChave = new VBox(5);
        linha1 = new HBox(5);
        linha2 = new HBox(5);
        linha3 = new HBox(5);
        linha4 = new HBox(5);
        linha5 = new HBox(5);
        tabela = new TableView<DadosChave>();
        colunaChave = new TableColumn<DadosChave, String>("Chave de acesso de referência");
        colunaChave.setPrefWidth(500);
        colunaChave.setCellValueFactory(new PropertyValueFactory<DadosChave, String>("chave"));
        
        painelBotoes.setStyle("-fx-border-radius: 2; -fx-border-color: gray; -fx-border-insets: 10 15 15 15; -fx-padding: 0 5 5 5");
        painelBotoes.getChildren().addAll(linha5);
        tabela.setPrefWidth(570);
        lblNumeroNFe = new Label("Número NFe           ");
        lblCFOP = new Label("CFOP");
        lblTransportadora = new Label("Transportadora       ");
        lblQtde = new Label("Qtde");
        lblEspecie = new Label("Espécie");
        lblMarca = new Label("Marca");
        lblNumeracao = new Label("Numeração");
        lblPesoBruto = new Label("Peso Bruto             ");
        lblPesoLiquido = new Label("Peso Líquido");
        lblModalidadeFrete = new Label("Modalidade do frete");
        lblTipoDocumento = new Label("Tipo de Documento");
        lblFinalidade = new Label("Finalidade");
        lblConsumidorFinal = new Label("ConsumidorFinal");
        lblChaveReferencia = new Label("Chave de Referência");

        cbModalidadeFrete = new ComboBox();
        cbTransportadora = new ComboBox();
        cbTipoDocumento = new ComboBox();
        cbFinalidade = new ComboBox();
        cbDestinoOperacao = new ComboBox();
        cbPesoBrutoLiquido = new CheckBox();
        cbTipoAtendimento = new ComboBox();
        cbCFOP = new ComboBox();
        txtChaveReferencia = new TextField();
        txtPesoBruto = new TextField();
        txtPesoLiquido = new TextField();
        txtChaveReferencia.setPrefWidth(400);

        txtNrNota = new TextField();
        txtNrNota.setPrefWidth(100);
        txtEspecie = new TextField();
        txtMarca = new TextField();
        txtNumeracao = new TextField();
        tabela.getColumns().addAll(colunaChave);
        painelTxtChave.setVisible(false);
        linha4.setVisible(false);
        
        cbCFOP.setOnAction(e -> {
            if(VerificaDevolucao() == true){
                painelTxtChave.setVisible(true);
                linha4.setVisible(true);
            }else{
                painelTxtChave.setVisible(false);
                linha4.setVisible(false);
            }
        });
        cbCFOP.setPrefWidth(712);
        cbCFOP.setConverter(new StringConverter<DadosCFOP>() {
                @Override
                public String toString(DadosCFOP object){
                    if(object!= null){
                        return object.getCFOP() + object.getNaturezaOperacao();
                    }
                    return null;
                }
                @Override
                public DadosCFOP fromString(String string){
                    return null;
                }
            });
        cbTransportadora.setPrefWidth(150);
        cbTransportadora.setConverter(new StringConverter<DadosTransportador>() {
                @Override
                public String toString(DadosTransportador object){
                    if(object!= null){
                        return object.getRazaoSocial();
                    }
                    return null;
                }
                @Override
                public DadosTransportador fromString(String string){
                    return null;
                }
            });
        txtNrNota.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.TAB){
                        int numero = Integer.parseInt(txtNrNota.getText());
                        txtNrNota.setText(String.format("%07d", numero));
                    }
                    if(txtNrNota.getText().length() > 9){
                            MessageBox.show("Quantidade de caracteres maior que 11 dígitos" ,"Erro");
                    }
        });
        
        txtPesoLiquido.setDisable(true);
        txtPesoBruto.setDisable(true);
        
        cbPesoBrutoLiquido.setOnAction(e -> {
            if(cbPesoBrutoLiquido.isSelected() == true){
                txtPesoLiquido.setDisable(false);
                txtPesoBruto.setDisable(false);
            }else{
                txtPesoLiquido.setDisable(true);
                txtPesoBruto.setDisable(true);
            }
        });
        
        btnAdd.setDisable(false);
        btnEditar.setDisable(false);
        btnExcluir.setDisable(false);
        btnCancel.setDisable(true);
        btnAlterar.setDisable(true);
        
        btnOK.setOnAction(e -> {
            incluirTransportadora();
            ConcluirNFe.show("","");
        });
        btnAdd.setOnAction(e -> btnAdd());
        btnAlterar.setOnAction(e -> btnAlterar());
        btnExcluir.setOnAction(e -> {
            DadosChave dados =  tabela.getSelectionModel().getSelectedItem();
                    if(dados == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        btnExcluir();
                    }   
                });
        btnEditar.setOnAction(e -> {
            DadosChave dados =  tabela.getSelectionModel().getSelectedItem();
                if(dados == null){
                    MessageBox.show("Selecione um item da lista", "Erro");
                }else{
                    btnEditar();
                }
            });
        btnCancel.setOnAction(e -> btnCancelar());
        cbTransportadora.setItems(listaTransportadora());
        cbModalidadeFrete.getItems().addAll("0 - Contratação do Frete por conta do Remetente(CIF)","1 - Contratação do Frete por conta do Destinatário(FOB)", "2 - Contratação do Frete por conta de Terceiros","3 - Transporte Próprio por conta do Remetente","4 - Transporte próprio por conta do Destinatário","9 - Sem ocorrência de transporte");
        cbTipoDocumento.getItems().addAll("0 - Entrada","1 - Saída");
        cbFinalidade.getItems().addAll("1 - NFe Normal","2 - NFe Complementar","3 - NFe Ajuste","4 - NFe Devolução");
        cbDestinoOperacao.getItems().addAll("1 - Operação Interna","2 - Operação Interestadual","3 - Operação Exterior");
        cbTipoAtendimento.getItems().addAll("0 - Não se Aplica","1 - Operação Presencial","2 - Operação não presencial, pela internet","3 - Operação não presencial, Teleatendimento","4 - NFC-e em operação com entrega a domicílio","9 - Operação não presencial, outros");
        
        painelTxtChave.getChildren().addAll(lblChaveReferencia, txtChaveReferencia, btnAdd);
        painelBotoesChave.getChildren().addAll(btnEditar, btnAlterar, btnCancel, btnExcluir);
        cbCFOP.getItems().addAll(listaCFOP());
        inicio = new Stage();
        inicio.setScene(cenario);
        inicio.initModality(Modality.APPLICATION_MODAL);
        btnCancelar.setOnAction(e -> inicio.close());
        painelPrincipal.setPadding(new Insets(15));
        linha1.getChildren().addAll(lblNumeroNFe, txtNrNota, lblCFOP, cbCFOP);
        linha2.getChildren().addAll(lblTransportadora, cbTransportadora, lblEspecie, txtEspecie, lblMarca, txtMarca, lblNumeracao, txtNumeracao, lblPesoBrutoLiquido, cbPesoBrutoLiquido);
        linha3.getChildren().addAll(lblPesoBruto, txtPesoBruto, lblPesoLiquido, txtPesoLiquido, lblModalidadeFrete, cbModalidadeFrete);
        linha4.getChildren().addAll(tabela, painelBotoesChave);
        linha5.getChildren().addAll(btnCancelar, btnOK);
        linha5.setPadding(new Insets(10));
        linha5.setAlignment(Pos.CENTER);
        painelPrincipal.getChildren().addAll(linha1, linha2, linha3, painelTxtChave, linha4, painelBotoes);
        inicio.showAndWait();
    }
    public static ObservableList<DadosCFOP>listaCFOP(){
        
        ResultSet rs;
        
        ObservableList<DadosCFOP> dados = FXCollections.observableArrayList();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT CFOP, NATUREZA_OPERACAO FROM TABELA_CFOP ORDER BY CFOP";
            PreparedStatement stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String cfop = rs.getString("CFOP");
                String natureza_operacao = rs.getString("NATUREZA_OPERACAO");
                dados.addAll(new DadosCFOP(cfop+" - ",natureza_operacao));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return dados;
    }
    public static ObservableList<DadosChave>listaChave(){
        
        ResultSet rs;
        
        ObservableList<DadosChave> dados = FXCollections.observableArrayList();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT CHAVE FROM CHAVE_REFERENCIA ORDER BY CHAVE";
            PreparedStatement stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String chave = rs.getString("CHAVE");
                dados.addAll(new DadosChave(chave));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return dados;
    }
    public static ObservableList<DadosTransportador>listaTransportadora(){
        
        ResultSet rs;
        
        ObservableList<DadosTransportador> dados = FXCollections.observableArrayList();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT RAZAOSOCIAL FROM ESTABELECIMENTO WHERE TRANSPORTADOR = 'true' ORDER BY RAZAOSOCIAL";
            PreparedStatement stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String razaosocial = rs.getString("RAZAOSOCIAL");
                dados.addAll(new DadosTransportador(razaosocial));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return dados;
    }
    
    public static boolean VerificaDevolucao(){
        
        int cont = 0;
        boolean verificador = false;
        
        DadosCFOP dados = (DadosCFOP) cbCFOP.getValue();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT COUNT(*) AS cont FROM TABELA_CFOP WHERE NATUREZA_OPERACAO LIKE '"+dados.getNaturezaOperacao()+"%' AND DEVOLUCAO = 1";
            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                cont = rs.getInt("cont");
            }
            if(cont>=1){
                verificador = true;
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return verificador;
    }
    public static void btnAdd(){
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "INSERT INTO CHAVE_REFERENCIA(ID, CHAVE) VALUES(default, '"+txtChaveReferencia.getText().replaceAll(" ", "").replaceAll("�", "")+"');";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.execute();
            txtChaveReferencia.clear();
            tabela.setItems(listaChave());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }

    public static void btnAlterar() {
        
        DadosChave dados = tabela.getSelectionModel().getSelectedItem();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "UPDATE CHAVE_REFERENCIA SET CHAVE = '"+txtChaveReferencia.getText().replaceAll(" ", "").replaceAll("�", "")+"' WHERE CHAVE = '"+dados.getChave()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.execute();
            txtChaveReferencia.clear();
            tabela.setDisable(false);
            btnAdd.setDisable(false);
            btnEditar.setDisable(false);
            btnExcluir.setDisable(false);
            btnCancel.setDisable(true);
            btnAlterar.setDisable(true);
            tabela.setItems(listaChave());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }
    public static void btnExcluir() {
        
        DadosChave dados = tabela.getSelectionModel().getSelectedItem();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM CHAVE_REFERENCIA WHERE CHAVE = '"+dados.getChave()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.execute();
            tabela.setItems(listaChave());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }

    public static void btnEditar() {
        
        DadosChave dados = tabela.getSelectionModel().getSelectedItem();        

        txtChaveReferencia.setText(dados.getChave());
        btnAdd.setDisable(true);
        btnEditar.setDisable(true);
        btnExcluir.setDisable(true);
        btnCancel.setDisable(false);
        btnAlterar.setDisable(false);
        tabela.setDisable(true);
    }
    public static void btnCancelar(){
        
        txtChaveReferencia.clear();
        btnAdd.setDisable(false);
        btnEditar.setDisable(false);
        btnExcluir.setDisable(false);
        btnCancel.setDisable(true);
        btnAlterar.setDisable(true);
        tabela.setDisable(false);
    }
    public static void incluirTransportadora(){
        
        try{
            DadosTransportador transportador = (DadosTransportador) cbTransportadora.getValue();
            Connection conexao = Conexao.getConexao();
            String sql = "update itemsnfe set razao_social_transp = '"+String.valueOf(transportador.getRazaoSocial())+"', cnpj_transp = (select cnpj from estabelecimento where transportador = 'true'), ie_transp = (select IE from estabelecimento where transportador = 'true'), uf_transp = (select uf_transportador from estabelecimento where transportador = 'true'), logradouro_transp = (select logradouro from estabelecimento where transportador = 'true'), nr_endereco_transp = (select nr from estabelecimento where transportador = 'true'), municipio_endereco_transp = (select cidade from estabelecimento where transportador = 'true'), uf_endereco_transp = (select uf from estabelecimento where transportador = 'true'), placa_transp = (select placa from estabelecimento where transportador = 'true'), antt_transp = (select antt_rntc from estabelecimento where transportador = 'true'), uf_veiculo_transp = (select uf_transportador from estabelecimento where transportador = 'true'), qtdevolumes = (select sum(qtde) from itemsnfe where razao_social_emit = '"+String.valueOf(transportador.getRazaoSocial())+"');";
            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
        }catch(Exception e){
            System.err.println(e);
        }
    }
}
