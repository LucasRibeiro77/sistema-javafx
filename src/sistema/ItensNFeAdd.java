package sistema;

import com.sun.glass.events.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import static sistema.ItensNfe.cbFornecedor;

public class ItensNFeAdd extends ItensNfe{
    
    public static VBox telaPrincipal;
    public static HBox painelPesquisa;
    public static HBox painelPesquisa2;
    public static HBox painelBotoes;
    public static Scene cenarioPrincipal;
    public static Stage init;
    public static Label message;
    public static Label razaoDestinatario;
    public static Button btnCancelar;
    public static Button btnAdicionar;
    public static Button btnExcluir;
    public static Button btnConcluir;
    public static TextField txtBuscaDescricao;
    public static TextField txtBuscaId_Barras;
    public static TextField txtQtde;
    public static ComboBox cbBuscar;
    public static TableView<DadosProdutos> tabelaProdutos;
    public static TableView<DadosProdutosAdd> tabela;
    public static TableColumn<DadosProdutos, Integer> colunaID;
    public static TableColumn<DadosProdutos, String> colunaDescricao;
    public static TableColumn<DadosProdutos, String> colunaQtde;
    public static TableColumn<DadosProdutos, String> colunaNCM;
    public static TableColumn<DadosProdutos, String> colunaCEST;
    public static TableColumn<DadosProdutos, String> colunaCST;
    public static TableColumn<DadosProdutos, String> colunaBarras;
    public static TableColumn<DadosProdutos, Double> colunaValorUnitario;
    public static TableColumn<DadosProdutos, Double> colunaBaseICMS;
    public static TableColumn<DadosProdutos, Double> colunaAliqICMS;
    public static TableColumn<DadosProdutos, Double> colunaRedICMS;
    public static TableColumn<DadosProdutos, Double> colunaValorICMS;
    public static TableColumn<DadosProdutos, Double> colunaBaseICMS_ST;
    public static TableColumn<DadosProdutos, Double> colunaMVA;
    public static TableColumn<DadosProdutos, Double> colunaValorICMS_ST;
    public static TableColumn<DadosProdutos, Double> colunaBaseIPI;
    public static TableColumn<DadosProdutos, String> colunaEnquadramento;
    public static TableColumn<DadosProdutos, Double> colunaAliqIPI;
    public static TableColumn<DadosProdutos, Double> colunaValorIPI;
    public static TableColumn<DadosProdutos, Double> colunaBasePIS;
    public static TableColumn<DadosProdutos, Double> colunaAliqPIS;
    public static TableColumn<DadosProdutos, Double> colunaValorPIS;
    public static TableColumn<DadosProdutos, Double> colunaBaseCOFINS;
    public static TableColumn<DadosProdutos, Double> colunaAliqCOFINS;
    public static TableColumn<DadosProdutos, Double> colunaValorCOFINS;    
    public static TableColumn<DadosProdutosAdd, Integer> colunaIDAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaDescricaoAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaQtdeAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaNCMAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaCESTAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaCSTAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaBarrasAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorUnitarioAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorTotalUnitarioAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaBaseICMSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaAliqICMSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaRedICMSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorICMSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaBaseICMS_STAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaMVAAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorICMS_STAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaBaseIPIAdd;
    public static TableColumn<DadosProdutosAdd, String> colunaEnquadramentoAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaAliqIPIAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorIPIAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaBasePISAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaAliqPISAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorPISAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaBaseCOFINSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaAliqCOFINSAdd;
    public static TableColumn<DadosProdutosAdd, Double> colunaValorCOFINSAdd;    
    public static Label lblTotalProdutos;
    public static Label lblValorTotalProdutos ;
    public static Label lblTotalNota;
    public static Label lblValorTotalNota;
    public static HBox painelTotalizadores;
    
    
    public static void show(String msg, String title) {
        
        telaPrincipal = new VBox(5);
        cenarioPrincipal = new Scene(telaPrincipal, 1000, 520);
        cbBuscar = new ComboBox();
        painelPesquisa = new HBox(5);
        painelPesquisa2 = new HBox(5);
        painelTotalizadores = new HBox(5);
        painelBotoes = new HBox(5);
        txtBuscaDescricao = new TextField();
        txtBuscaId_Barras = new TextField();
        txtQtde = new TextField();
        init = new Stage();
        btnAdicionar = new Button("_Adicionar");
        btnExcluir = new Button("E_xcluir");
        btnConcluir = new Button("Con_cluir");
        btnCancelar = new Button("Canc_elar");
        tabelaProdutos = new TableView<DadosProdutos>();
        tabela = new TableView<DadosProdutosAdd>();
        razaoDestinatario = new Label();
        Label numeroProt = new Label();
        Label lblQtde = new Label("Qtde");
        lblTotalProdutos = new Label("Total Produtos:");
        lblValorTotalProdutos = new Label();
        lblTotalNota = new Label("          Total da Nota:");
        lblValorTotalNota = new Label();        
        txtBuscaId_Barras.setPrefWidth(110);
        txtBuscaDescricao.setPrefWidth(200);
        lblTotalProdutos.setFont(new Font(15));
        lblValorTotalProdutos.setFont(new Font(15));
        lblTotalNota.setFont(new Font(15));
        lblValorTotalNota.setFont(new Font(15));
        txtQtde.setPrefWidth(60);
        
        txtBuscaId_Barras.setOnKeyPressed(e -> {
		    if(Pesquisar().isEmpty()){
                        tabelaProdutos.setItems(Produto.ListaProdutos());
                    }else{
                        tabelaProdutos.setItems(Pesquisar());
                        tabelaProdutos.getSelectionModel().selectFirst();
                    }
                    if(e.getCode() == KeyCode.ENTER){
                    consultarQtde();
                    }
                });
        
                txtBuscaDescricao.setOnKeyPressed(e -> {
		    if(BuscarDescricao().isEmpty()){
                        tabelaProdutos.setItems(Produto.ListaProdutos());
                    }else{
                        tabelaProdutos.setItems(BuscarDescricao());
                        tabelaProdutos.getSelectionModel().selectFirst();
                    }
                    if(e.getCode() == KeyCode.ENTER){
                    consultarQtde();
                    }
                });
        cbBuscar.setValue("ID ou Cód. Barras");        
        
        cbBuscar.getItems().addAll("ID ou Cód. Barras", "Descrição");
        painelPesquisa2.getChildren().addAll(txtBuscaId_Barras, lblQtde, txtQtde);
                
                cbBuscar.setOnAction(e -> {
                      if(cbBuscar.getValue() == "ID ou Cód. Barras"){
                              painelPesquisa2.getChildren().clear();    
                              txtBuscaId_Barras.clear();
                              txtBuscaId_Barras.setDisable(false);
                              txtBuscaDescricao.clear();
                              txtBuscaDescricao.setDisable(true);
                              txtBuscaId_Barras.setVisible(true);
                              painelPesquisa2.getChildren().addAll(txtBuscaId_Barras, lblQtde, txtQtde);
                              Focus();
                      }else if(cbBuscar.getValue() == "Descrição"){
                              painelPesquisa2.getChildren().clear();
                              txtBuscaId_Barras.clear();
                              txtBuscaId_Barras.setDisable(true);
                              txtBuscaDescricao.clear();
                              txtBuscaDescricao.setDisable(false);
                              painelPesquisa2.getChildren().addAll(txtBuscaDescricao, lblQtde, txtQtde);
                              Focus();
                      }        
                 });
        
        ItensNfe.cbFornecedor.setConverter(new StringConverter<DadosForn>() {
                @Override
                public String toString(DadosForn object){
                    if(object!= null){
                        return object.getRazaoSocial();
                    }
                    return null;
                }
                @Override
                public DadosForn fromString(String string){
                    return null;
                }
            });
        
        numeroProt.setText("Número Protocolo: "+String.valueOf(Protocolo()).replace("[","").replace("]",""));
        numeroProt.setStyle("-fx-font-weight: bold");
        lblQtde.setStyle("-fx-font-weight: bold");
        lblTotalProdutos.setStyle("-fx-font-weight: bold");
        lblTotalNota.setStyle("-fx-font-weight: bold");
        razaoDestinatario.setStyle("-fx-font-weight: bold");
        razaoDestinatario.setText("Destinatário: "+ItensNfe.cbFornecedor.getSelectionModel().getSelectedItem().getRazaoSocial());

        colunaID = new TableColumn<DadosProdutos, Integer>("Código");
        colunaID.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Integer>("ID"));
        colunaDescricao = new TableColumn<DadosProdutos, String>("Descrição");
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("descricao"));
        colunaQtde = new TableColumn<DadosProdutos, String>("Qtde Estoque");
        colunaQtde.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("estoque"));
        colunaNCM = new TableColumn<DadosProdutos, String>("NCM");
        colunaNCM.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("ncm"));
        colunaCEST = new TableColumn<DadosProdutos, String>("CEST");
        colunaCEST.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("cest"));    
        colunaCST = new TableColumn<DadosProdutos, String>("CST");
        colunaCST.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("cst"));     
        colunaBarras = new TableColumn<DadosProdutos, String>("EAN");
        colunaBarras.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("barras"));     
        colunaValorUnitario = new TableColumn<DadosProdutos, Double>("Valor Unit."); 
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("valor_pago"));     
        colunaBaseICMS = new TableColumn<DadosProdutos, Double>("Base ICMS");
        colunaBaseICMS.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("valor_pago"));     
        colunaAliqICMS = new TableColumn<DadosProdutos, Double>("Aliq ICMS");
        colunaRedICMS = new TableColumn<DadosProdutos, Double>("Redutor ICMS");
        colunaValorICMS = new TableColumn<DadosProdutos, Double>("Vlr. ICMS");
        colunaBaseICMS_ST = new TableColumn<DadosProdutos, Double>("Base ICMS-ST");
        colunaMVA = new TableColumn<DadosProdutos, Double>("MVA");
        colunaValorICMS_ST = new TableColumn<DadosProdutos, Double>("Vlr. ICMS-ST"); 
        colunaBaseIPI = new TableColumn<DadosProdutos, Double>("Base IPI");
        colunaEnquadramento = new TableColumn<DadosProdutos, String>("Enquad.");
        colunaAliqIPI = new TableColumn<DadosProdutos, Double>("Aliq. IPI");
        colunaValorIPI = new TableColumn<DadosProdutos, Double>("Vlr. IPI");
        colunaBasePIS = new TableColumn<DadosProdutos, Double>("Base PIS");
        colunaAliqPIS = new TableColumn<DadosProdutos, Double>("Aliq PIS");
        colunaValorPIS = new TableColumn<DadosProdutos, Double>("Vlr. PIS");
        colunaBaseCOFINS = new TableColumn<DadosProdutos, Double>("Base Cofins");
        colunaAliqCOFINS = new TableColumn<DadosProdutos, Double>("Aliq. Cofins");
        colunaValorCOFINS = new TableColumn<DadosProdutos, Double>("Vlr. Cofins");        
        
        colunaIDAdd = new TableColumn<DadosProdutosAdd, Integer>("Código");
        colunaIDAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Integer>("ID"));
        colunaDescricaoAdd = new TableColumn<DadosProdutosAdd, String>("Descrição");
        colunaDescricaoAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("descricao"));
        colunaQtdeAdd = new TableColumn<DadosProdutosAdd, String>("Qtde");
        colunaQtdeAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("qtde"));
        colunaNCMAdd = new TableColumn<DadosProdutosAdd, String>("NCM");
        colunaNCMAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("ncm"));
        colunaCESTAdd = new TableColumn<DadosProdutosAdd, String>("CEST");
        colunaCESTAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("cest"));    
        colunaCSTAdd = new TableColumn<DadosProdutosAdd, String>("CST");
        colunaCSTAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("cst"));     
        colunaBarrasAdd = new TableColumn<DadosProdutosAdd, String>("EAN");
        colunaBarrasAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("barras"));     
        colunaValorUnitarioAdd = new TableColumn<DadosProdutosAdd, Double>("Valor Unit."); 
        colunaValorUnitarioAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_pago"));     
        colunaValorTotalUnitarioAdd = new TableColumn<DadosProdutosAdd, Double>("Valor Total."); 
        colunaValorTotalUnitarioAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_total"));     
        colunaBaseICMSAdd = new TableColumn<DadosProdutosAdd, Double>("Base ICMS");
        colunaBaseICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("BASE_ICMS"));     
        colunaAliqICMSAdd = new TableColumn<DadosProdutosAdd, Double>("Aliq ICMS");
        colunaAliqICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("icms"));
        colunaRedICMSAdd = new TableColumn<DadosProdutosAdd, Double>("Redutor ICMS");
        colunaRedICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("redutor"));
        colunaValorICMSAdd = new TableColumn<DadosProdutosAdd, Double>("Vlr ICMS");
        colunaValorICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("VALORICMS"));
        colunaBaseICMS_STAdd = new TableColumn<DadosProdutosAdd, Double>("Base ICMS-ST");
        colunaBaseICMS_STAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("base_icms_st"));
        colunaMVAAdd = new TableColumn<DadosProdutosAdd, Double>("MVA");
        colunaMVAAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("mva"));
        colunaValorICMS_STAdd = new TableColumn<DadosProdutosAdd, Double>("Vlr. ICMS-ST"); 
        colunaValorICMS_STAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_icms_st"));
        colunaBaseIPIAdd = new TableColumn<DadosProdutosAdd, Double>("Base IPI");
        colunaBaseIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("base_ipi"));
        colunaEnquadramentoAdd = new TableColumn<DadosProdutosAdd, String>("Enquad.");
        colunaEnquadramentoAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, String>("enquadramento"));
        colunaAliqIPIAdd = new TableColumn<DadosProdutosAdd, Double>("Aliq. IPI");
        colunaAliqIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("ipi"));
        colunaValorIPIAdd = new TableColumn<DadosProdutosAdd, Double>("Vlr. IPI");
        colunaValorIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_ipi"));
        colunaBasePISAdd = new TableColumn<DadosProdutosAdd, Double>("Base PIS");
        colunaBasePISAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("base_pis"));
        colunaAliqPISAdd = new TableColumn<DadosProdutosAdd, Double>("Aliq PIS");
        colunaAliqPISAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("pis"));
        colunaValorPISAdd = new TableColumn<DadosProdutosAdd, Double>("Vlr. PIS");
        colunaValorPISAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_pis"));
        colunaBaseCOFINSAdd = new TableColumn<DadosProdutosAdd, Double>("Base Cofins");
        colunaBaseCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("base_cofins"));
        colunaAliqCOFINSAdd = new TableColumn<DadosProdutosAdd, Double>("Aliq. Cofins");
        colunaAliqCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("cofins"));
        colunaValorCOFINSAdd = new TableColumn<DadosProdutosAdd, Double>("Vlr. Cofins");
        colunaValorCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosProdutosAdd, Double>("valor_cofins"));
        
        init.setScene(cenarioPrincipal);
        init.setTitle(title);
        init.initModality(Modality.APPLICATION_MODAL);
        
        
        message = new Label(msg);
        
        txtQtde.setText("1");
        
        lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
        lblValorTotalNota.setText("R$"+String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", "").replace(".",","));
        
        tabelaProdutos.setPrefHeight(110);
        tabela.setPrefHeight(220);
        tabelaProdutos.setItems(Produto.ListaProdutos());

        btnAdicionar.setOnAction(e -> {
            consultarQtde();    
        });
        btnAdicionar.setOnKeyPressed(evt ->{
            if(btnAdicionar.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                consultarQtde();
            }
        });
        
        btnExcluir.setOnAction(e -> 
                {
                    DadosProdutosAdd data = tabela.getSelectionModel().getSelectedItem();
                    data = tabela.getSelectionModel().getSelectedItem();             
                    if(data == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        DeleteProdNfe.show("Tem certeza que deseja excluir este item?","Erro");
                    }
        });
        tabela.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        btnConcluir.setOnAction(e -> {
            tabela.getSelectionModel().selectFirst();
            tabela.getSelectionModel().selectAll();
            EmitirNFe.show("","");
        });
        
        btnExcluir.setOnKeyPressed(e -> {
            if(btnExcluir.isFocused() == true && e.getCode() == KeyCode.ENTER){
                    DadosProdutosAdd data = tabela.getSelectionModel().getSelectedItem();
                    data = tabela.getSelectionModel().getSelectedItem();             
                    if(data == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        DeleteProdNfe.show("Tem certeza que deseja excluir este item?","Erro");
                    }
            }
        });
        
        txtQtde.setOnKeyPressed((KeyEvent) -> {
            
        if(KeyEvent.getCode() == KeyCode.ENTER){
                consultarQtde();
            }
        });
        cbBuscar.setOnKeyPressed((KeyEvent) -> {
            
        if(KeyEvent.getCode() == KeyCode.ENTER){
                consultarQtde();
            }
        });
        tabelaProdutos.setOnMouseClicked(e -> Focus());
        tabelaProdutos.setOnKeyPressed(e -> Focus());
        tabelaProdutos.getSelectionModel().selectFirst();
        Focus();
        
        btnCancelar.setOnAction(e -> {
                confirmacaoCancelar.show("Tem certeza que deseja cancelar este protocolo?","Confirmação de cancelamento");
        });
        btnCancelar.setOnKeyPressed(evt -> {
            if(btnCancelar.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                confirmacaoCancelar.show("Tem certeza que deseja cancelar este protocolo?","Confirmação de cancelamento");
            }
        });
        tabelaProdutos.getColumns().addAll(colunaID, colunaDescricao, colunaQtde, colunaBarras, colunaNCM, colunaCEST, colunaValorUnitario);
        tabela.getColumns().addAll(colunaIDAdd, colunaDescricaoAdd, colunaQtdeAdd, colunaBarrasAdd, colunaNCMAdd, colunaCESTAdd, colunaValorUnitarioAdd, colunaValorTotalUnitarioAdd);
        tabela.setItems(ListaNFeAdd());
        painelPesquisa.getChildren().addAll(cbBuscar, painelPesquisa2);
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.getChildren().addAll(btnAdicionar, btnExcluir, btnConcluir, btnCancelar);
        telaPrincipal.setPadding(new Insets(15));
        painelTotalizadores.getChildren().addAll(lblTotalProdutos, lblValorTotalProdutos, lblTotalNota, lblValorTotalNota);
        telaPrincipal.getChildren().addAll(numeroProt, razaoDestinatario, message, painelPesquisa,tabelaProdutos, tabela, painelTotalizadores, painelBotoes);
        init.showAndWait();
    }
    public static ObservableList<DadosProdutosAdd> ListaNFeAdd(){
        
        ObservableList<DadosProdutosAdd> dados = FXCollections.observableArrayList();
        
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        
        try{
            String sql = "SELECT * FROM ITEMSNFE;";
            Statement stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                    int id = rs.getInt("ID_PRODUTO");
                    String descricao = rs.getString("DESCRICAO");
                    String barras = rs.getString("BARRAS");
                    int ncm = rs.getInt("NCM");
                    int cest = rs.getInt("CEST");
                    String und_medida = rs.getString("UND_MEDIDA");
                    double qtde = rs.getDouble("QTDE");
                    double valor_pago = rs.getDouble("VALOR_UNITARIO");
                    double valor_total = rs.getDouble("VALOR_TOTAL_UNITARIO");
                    double ii = rs.getDouble("ALIQ_II");
                    double ipi = rs.getDouble("ALIQ_IPI");
                    double pis = rs.getDouble("ALIQ_PIS");
                    double cofins = rs.getDouble("ALIQ_COFINS");
                    double icms = rs.getDouble("ALIQ_ICMS");
                    double mva = rs.getDouble("MVA");
                    double redutor = rs.getDouble("REDUTOR_ICMS");
                    double redutor_st = rs.getDouble("REDUTOR_ICMS_ST");
                    double seguro = rs.getDouble("VALOR_SEGURO");
                    double outros = rs.getDouble("OUTRAS_DESPESAS");
                    double desconto = rs.getDouble("VALOR_DESCONTO");
                    double frete = rs.getDouble("VALOR_FRETE");
                    double FCP = rs.getDouble("ALIQ_FCP");
                    String CST_ICMS = rs.getString("CST_ICMS");
                    String Origem = rs.getString("ORIGEM_ICMS");
                    String CST_IPI = rs.getString("CST_IPI");
                    String CodEnquadramento = rs.getString("ENQUADRAMENTO");
                    String CST_PIS = rs.getString("CST_PIS");
                    String CST_COFINS = rs.getString("CST_COFINS");
                    double base_calc_icms = rs.getDouble("BASE_ICMS");
                    double valorIcms = rs.getDouble("VALORICMS");
                    double base_icms_st = rs.getDouble("BASE_ICMS_ST");
                    double valor_icms_st = rs.getDouble("VALOR_ICMS_ST");
                    double base_ipi = rs.getDouble("BASE_IPI");
                    double valor_ipi = rs.getDouble("VALOR_IPI");
                    double base_pis = rs.getDouble("BASE_PIS");
                    double valor_pis = rs.getDouble("VALOR_PIS");
                    double base_cofins = rs.getDouble("BASE_COFINS");
                    double valor_cofins = rs.getDouble("VALOR_COFINS");
                    double valor_fcp = rs.getDouble("VALOR_FCP");
                    String codUf = rs.getString("COD_UF_EMIT");
                    String cnpjEmit = rs.getString("CNPJ_EMIT");
                    String razaoSocialEmit = rs.getString("RAZAO_SOCIAL_EMIT");
                    String nomeFantasiaEmit = rs.getString("NOME_FANTASIA_EMIT");
                    String IEemit = rs.getString("IE_EMIT");
                    String IMemit = rs.getString("IM_EMIT");
                    String IESTemit = rs.getString("IEST_EMIT");
                    String CNAEemit = rs.getString("CNAE_EMIT");
                    String regimeEmit = rs.getString("COD_REGIME_EMIT");
                    String telefoneEmit = rs.getString("TELEFONE_EMIT");
                    String logradouroEmit = rs.getString("ENDERECO_EMIT");
                    String nrEmit = rs.getString("NR_ENDERECO_EMIT");
                    String cidadeEmit = rs.getString("CIDADE_ENDERECO_EMIT");
                    String estadoEmit = rs.getString("UF_ENDERECO_EMIT");
                    String paisEmit = rs.getString("PAIS_EMIT");
                    String cepEmit = rs.getString("CEP_ENDERECO_EMIT");
                    String bairroEmit = rs.getString("BAIRRO_ENDERECO_EMIT");
                    String codPaisEmit = rs.getString("COD_PAIS_EMIT");
                    String codMunicipioEmit = rs.getString("COD_CIDADE_ENDERECO_EMIT");
                    String razaoSocialTransp = rs.getString("RAZAO_SOCIAL_TRANSP");
                    String cnpjTransp = rs.getString("CNPJ_TRANSP");
                    String ieTransp = rs.getString("IE_TRANSP");
                    String ufTransp = rs.getString("UF_TRANSP");
                    String logradouroTransp = rs.getString("LOGRADOURO_TRANSP");
                    String nrTransp = rs.getString("NR_ENDERECO_TRANSP");
                    String ufEndTransp = rs.getString("UF_ENDERECO_TRANSP");
                    String municipioEndTransp = rs.getString("MUNICIPIO_ENDERECO_TRANSP");
                    String placa = rs.getString("PLACA_TRANSP");
                    String ufVeicTransp = rs.getString("UF_VEICULO_TRANSP");
                    String antt = rs.getString("ANTT_TRANSP");
                    double qtdeVolumes = rs.getDouble("QTDEVOLUMES");
                    String codUfDest = rs.getString("COD_UF_DEST");
                    String cnpjDest = rs.getString("CNPJ_DEST");
                    String razaoSocialDest = rs.getString("RAZAO_SOCIAL_DEST");
                    String nomeFantasiaDest = rs.getString("NOME_FANTASIA_DEST");
                    String IEDest = rs.getString("IE_DEST");
                    String IMDest = rs.getString("IM_DEST");
                    String IESTDest = rs.getString("IEST_DEST");
                    String CNAEDest = rs.getString("CNAE_DEST");
                    String regimeDest = rs.getString("COD_REGIME_DEST");
                    String telefoneDest = rs.getString("TELEFONE_DEST");
                    String logradouroDest = rs.getString("ENDERECO_DEST");
                    String nrDest = rs.getString("NR_ENDERECO_DEST");
                    String cidadeDest = rs.getString("CIDADE_ENDERECO_DEST");
                    String estadoDest = rs.getString("UF_ENDERECO_DEST");
                    String paisDest = rs.getString("PAIS_DEST");
                    String cepDest = rs.getString("CEP_ENDERECO_DEST");
                    String bairroDest = rs.getString("BAIRRO_ENDERECO_DEST");
                    String codPaisDest = rs.getString("COD_PAIS_DEST");
                    String codMunicipioDest = rs.getString("COD_CIDADE_ENDERECO_DEST");                    
                    double total_bc_icms = rs.getDouble("total_bc_icms");
                    double total_valor_icms = rs.getDouble("total_valor_icms");
                    double total_bc_icms_st = rs.getDouble("total_bc_icms_st");
                    double total_valor_icms_st = rs.getDouble("total_valor_icms_st");
                    double total_valor_icms_desonerado = rs.getDouble("total_valor_icms_desonerado");
                    double total_valor_fcp = rs.getDouble("total_valor_fcp");
                    double total_bc_fcp_st = rs.getDouble("total_bc_fcp_st");
                    double total_valor_fcp_st = rs.getDouble("total_valor_fcp_st");
                    double total_valor_fcp_st_retido = rs.getDouble("total_valor_fcp_st_retido");
                    double total_produtos = rs.getDouble("total_produtos");
                    double total_frete = rs.getDouble("total_frete");
                    double total_seguro = rs.getDouble("total_seguro");
                    double total_desconto = rs.getDouble("total_desconto");
                    double total_ii = rs.getDouble("total_ii");
                    double total_ipi = rs.getDouble("total_ipi");
                    double total_ipi_devolvido = rs.getDouble("total_ipi_devolvido");
                    double total_pis = rs.getDouble("total_pis");
                    double total_cofins = rs.getDouble("total_cofins");
                    double total_outros = rs.getDouble("total_outros");
                    double total_nota = rs.getDouble("total_nota");
                    
                    dados.add(new DadosProdutosAdd(id,  descricao,  barras,  ncm,  cest,  und_medida,  qtde,  valor_pago,   valor_total,  ii,  ipi,  pis,  cofins,  icms,  mva,  redutor,  redutor_st,  seguro,  outros,  desconto,  frete,  FCP,  CST_ICMS,  Origem,  CST_IPI,  CodEnquadramento,  CST_PIS,  CST_COFINS,  base_calc_icms,  valorIcms,  base_icms_st,  valor_icms_st,  base_ipi,  valor_ipi,  base_pis,  valor_pis,  base_cofins,  valor_cofins,  valor_fcp, codUf, cnpjEmit, razaoSocialEmit, nomeFantasiaEmit, IEemit, IMemit, IESTemit, CNAEemit, regimeEmit, telefoneEmit, logradouroEmit, nrEmit, cidadeEmit, estadoEmit, paisEmit, cepEmit, bairroEmit, codPaisEmit, codMunicipioEmit, razaoSocialTransp, cnpjTransp, ieTransp, ufTransp, logradouroTransp, nrTransp, ufEndTransp, municipioEndTransp, placa, ufVeicTransp, antt, qtdeVolumes, codUfDest, cnpjDest, razaoSocialDest, nomeFantasiaDest, IEDest, IMDest, IESTDest, CNAEDest, regimeDest, telefoneDest, logradouroDest, nrDest, cidadeDest, estadoDest, paisDest, cepDest, bairroDest, codPaisDest, codMunicipioDest, total_bc_icms, total_valor_icms, total_bc_icms_st, total_valor_icms_st, total_valor_icms_desonerado, total_valor_fcp, total_bc_fcp_st, total_valor_fcp_st, total_valor_fcp_st_retido, total_produtos, total_frete, total_seguro, total_desconto, total_ii, total_ipi, total_ipi_devolvido, total_pis, total_cofins, total_outros, total_nota));
            }
        }catch(Exception e){
            MessageBox.show(""+e, "erro");
        }
        return dados;
    }
    private static ObservableList<DadosProdutos> BuscarDescricao() {
        ObservableList<DadosProdutos> dadosDescr = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT * FROM PRODUTOS WHERE produtos.DESCRICAO LIKE '%"+txtBuscaDescricao.getText()+"%';";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);

                while(rs.next()){
                    int id = rs.getInt("ID");
                    String descricao = rs.getString("DESCRICAO");
                    String categoria = rs.getString("CATEGORIA");
                    String barras = rs.getString("BARRAS");
                    int ncm = rs.getInt("NCM");
                    int cest = rs.getInt("CEST");
                    String fabricante = rs.getString("FABRICANTE");
                    String fornecedor = rs.getString("FORNECEDOR");
                    String und_medida = rs.getString("UND_MEDIDA");
                    double estoque = rs.getDouble("ESTOQUE");
                    double est_minimo = rs.getDouble("EST_MINIMO");
                    double est_maximo = rs.getDouble("EST_MAXIMO");
                    double valor_pago = rs.getDouble("VALOR_PAGO");
                    double desc_promocional = rs.getDouble("DESC_PROMOCIONAL");
                    double qtde_promocional = rs.getDouble("QTDE_PROMOCIONAL");
                    double ii = rs.getDouble("II");
                    double ipi = rs.getDouble("IPI");
                    double pis = rs.getDouble("PIS");
                    double cofins = rs.getDouble("COFINS");
                    double icms = rs.getDouble("ICMS");
                    double mva = rs.getDouble("MVA");
                    double redutor = rs.getDouble("REDUTOR");
                    double redutor_st = rs.getDouble("REDUTOR_ST");
                    double seguro = rs.getDouble("SEGURO");
                    double outros = rs.getDouble("OUTROS");
                    double desconto = rs.getDouble("DESCONTO");
                    double frete = rs.getDouble("FRETE");
                    String validade = rs.getString("VALIDADE");
                    double custo = rs.getDouble("CUSTO");
                    double marckup = rs.getDouble("MARCKUP");                    
                    double varejo = rs.getDouble("VAREJO"); 
                    String inclusao = rs.getString("INCLUSAO");
                    String alteracao = rs.getString("ALTERACAO");
                    double FCP = rs.getDouble("FCP");
                    String CST_ICMS = rs.getString("CST_ICMS");
                    String Origem = rs.getString("ORIGEM");
                    String CST_IPI = rs.getString("CST_IPI");
                    String CodEnquadramento = rs.getString("ENQUADRAMENTO");
                    String CST_PIS = rs.getString("CST_PIS");
                    String CST_COFINS = rs.getString("CST_COFINS");
                    String Tributacao = rs.getString("TRIBUTACAO");
                    double QTDE_CX_PCT_SC_FD = rs.getDouble("QTDE_CX_PCT_SC_FD");
                    
                    dadosDescr.add(new DadosProdutos(id, descricao, categoria, barras, ncm, cest, fabricante, fornecedor, und_medida, String.format("%.02f", estoque).replace(".",","), est_minimo, est_maximo, valor_pago, desc_promocional, qtde_promocional, ii, ipi, pis, cofins, icms, mva, redutor, redutor_st, seguro, outros, desconto, frete, validade, "R$"+String.format("%.02f", custo).replace(".",","), String.format("%.02f", marckup).replace(".",",")+"%", "R$"+String.format("%.02f", varejo).replace(".",","), inclusao, alteracao, FCP, CST_ICMS, Origem, CST_IPI, CodEnquadramento, CST_PIS, CST_COFINS, Tributacao, QTDE_CX_PCT_SC_FD));
                }
              
                //tabela.setItems(dados);               
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dadosDescr;
    }
    public static ObservableList<DadosProdutos> Pesquisar(){
            ObservableList<DadosProdutos> dados = FXCollections.observableArrayList();
            ResultSet rs;

            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT * FROM PRODUTOS WHERE produtos.BARRAS LIKE '%"+txtBuscaId_Barras.getText()+"%' XOR produtos.ID = "+txtBuscaId_Barras.getText()+";";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);

                while(rs.next()){
                    int id = rs.getInt("ID");
                    String descricao = rs.getString("DESCRICAO");
                    String categoria = rs.getString("CATEGORIA");
                    String barras = rs.getString("BARRAS");
                    int ncm = rs.getInt("NCM");
                    int cest = rs.getInt("CEST");
                    String fabricante = rs.getString("FABRICANTE");
                    String fornecedor = rs.getString("FORNECEDOR");
                    String und_medida = rs.getString("UND_MEDIDA");
                    double estoque = rs.getDouble("ESTOQUE");
                    double est_minimo = rs.getDouble("EST_MINIMO");
                    double est_maximo = rs.getDouble("EST_MAXIMO");
                    double valor_pago = rs.getDouble("VALOR_PAGO");
                    double desc_promocional = rs.getDouble("DESC_PROMOCIONAL");
                    double qtde_promocional = rs.getDouble("QTDE_PROMOCIONAL");
                    double ii = rs.getDouble("II");
                    double ipi = rs.getDouble("IPI");
                    double pis = rs.getDouble("PIS");
                    double cofins = rs.getDouble("COFINS");
                    double icms = rs.getDouble("ICMS");
                    double mva = rs.getDouble("MVA");
                    double redutor = rs.getDouble("REDUTOR");
                    double redutor_st = rs.getDouble("REDUTOR_ST");
                    double seguro = rs.getDouble("SEGURO");
                    double outros = rs.getDouble("OUTROS");
                    double desconto = rs.getDouble("DESCONTO");
                    double frete = rs.getDouble("FRETE");
                    String validade = rs.getString("VALIDADE");
                    double custo = rs.getDouble("CUSTO");
                    double marckup = rs.getDouble("MARCKUP");                    
                    double varejo = rs.getDouble("VAREJO"); 
                    String inclusao = rs.getString("INCLUSAO");
                    String alteracao = rs.getString("ALTERACAO");
                    double FCP = rs.getDouble("FCP");
                    String CST_ICMS = rs.getString("CST_ICMS");
                    String Origem = rs.getString("ORIGEM");
                    String CST_IPI = rs.getString("CST_IPI");
                    String CodEnquadramento = rs.getString("ENQUADRAMENTO");
                    String CST_PIS = rs.getString("CST_PIS");
                    String CST_COFINS = rs.getString("CST_COFINS");
                    String Tributacao = rs.getString("TRIBUTACAO");
                    double QTDE_CX_PCT_SC_FD = rs.getDouble("QTDE_CX_PCT_SC_FD");
                            
                    dados.add(new DadosProdutos(id, descricao, categoria, barras, ncm, cest, fabricante, fornecedor, und_medida, String.format("%.02f", estoque).replace(".",","), est_minimo, est_maximo, valor_pago, desc_promocional, qtde_promocional, ii, ipi, pis, cofins, icms, mva, redutor, redutor_st, seguro, outros, desconto, frete, validade, "R$"+String.format("%.02f", custo).replace(".",","), String.format("%.02f", marckup).replace(".",",")+"%", "R$"+String.format("%.02f", varejo).replace(".",","), inclusao, alteracao, FCP, CST_ICMS, Origem, CST_IPI, CodEnquadramento, CST_PIS, CST_COFINS, Tributacao,QTDE_CX_PCT_SC_FD));
                }
            tabelaProdutos.getSelectionModel().selectFirst();
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static void btnAdicionarDescricao(){
        
        DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
        ResultSet rs;
        PreparedStatement stmq;
        PreparedStatement stm;
        PreparedStatement totalstm;
        PreparedStatement consulta;
        PreparedStatement atualiza;
        
        try{
            Connection conexao = Conexao.getConexao();
            
            DadosForn fornecedor = ItensNfe.cbFornecedor.getSelectionModel().getSelectedItem();
            
            String inserirQtde = "insert into itemsnfe(qtde,id_produto,descricao) value('"+txtQtde.getText()+"','"+data.getID()+"','"+data.getDescricao()+"')";

            String sql = "update itemsnfe set id_produto = '"+data.getID()+"', "
                    + "descricao = '"+data.getDescricao()+"', "
                    + "ncm = '"+data.getNcm()+"', "
                    + "cest = '"+data.getCest()+"', "
                    + "und_medida = '"+data.getUnd_medida()+"', "
                    + "origem_icms = '"+data.getOrigem().substring(0, 1)+"',  "
                    + "cst_icms = '"+data.getCST_ICMS().substring(0, 3)+"', "
                    + "cst_ipi = '"+data.getCST_IPI().substring(0, 6).replace("IPI ", "")+"',"
                    + "cst_pis = '"+data.getCST_PIS().substring(0, 6).replace("PIS ", "")+"',"
                    + "cst_cofins = '"+data.getCST_COFINS().substring(0, 10).replace("COFINS", "")+"', "
                    + "enquadramento = '"+data.getCodEnquadramento()+"',"
                    + "redutor_icms = "+data.getRedutor()+", "
                    + "base_icms = "+txtQtde.getText()+" * "+data.getValor_pago()+" - ("+txtQtde.getText()+" * "+data.getValor_pago()+" * "+data.getRedutor()+" / 100), "
                    + "aliq_icms = "+data.getICMS()+", valorIcms = base_icms * aliq_icms / 100, "
                    + "redutor_icms_st = "+data.getRedutor_ST()+", "
                    + "mva = "+data.getMVA()+", "
                    + "base_icms_st = (base_icms * "+data.getMVA()+" / 100 + base_icms) - ((base_icms * "+data.getMVA()+" / 100 + base_icms) * "+data.getRedutor_ST()+" / 100), "
                    + "aliq_icms_st = "+data.getICMS()+", "
                    + "valor_icms_st = base_icms_st * aliq_icms_st / 100 - valorIcms, "
                    + "base_ipi = "+data.getValor_pago()+" * "+txtQtde.getText()+", "
                    + "aliq_ipi = "+data.getIPI()+", "
                    + "valor_ipi = base_ipi * aliq_ipi / 100, "
                    + "base_pis = "+data.getValor_pago()+" * "+txtQtde.getText()+", "
                    + "aliq_pis = "+data.getPIS()+", "
                    + "valor_pis = base_pis * aliq_pis / 100, "
                    + "base_cofins = "+data.getValor_pago()+" * "+txtQtde.getText()+", "
                    + "aliq_cofins = "+data.getCOFINS()+", "
                    + "valor_cofins = base_cofins * aliq_cofins / 100, "
                    + "base_fcp_st = "+data.getValor_pago()+" * "+txtQtde.getText()+", "
                    + "aliq_fcp_st = "+data.getFCP()+", "
                    + "valor_fcp_st = base_fcp_st * aliq_fcp_st / 100, "
                    + "base_ii = "+data.getValor_pago()+" * "+txtQtde.getText()+", "
                    + "aliq_ii = "+data.getII()+", "
                    + "valor_ii = base_ii * aliq_ii / 100, "
                    + "valor_unitario = "+data.getValor_pago()+", "
                    + "valor_total_unitario = valor_unitario * qtde, "
                    + "valor_frete = "+data.getFrete()+", "
                    + "valor_seguro = "+data.getSeguro()+", "
                    + "valor_desconto = "+data.getDesconto()+", "
                    + "outras_despesas = "+data.getOutros()+", "
                    + "razao_social_emit = (select razaosocial from estabelecimento where estab = 'true'), "
                    + "nome_fantasia_emit = (select nomefantasia from estabelecimento where estab = 'true'), "
                    + "cnpj_emit = (select cnpj from estabelecimento where estab = 'true'), "
                    + "IE_emit = (select ie from estabelecimento where estab = 'true'), "
                    + "IM_emit = (select im from estabelecimento where estab = 'true'), "
                    + "IEST_emit = (select iest from estabelecimento where estab = 'true'), "
                    + "CNAE_emit = (select cnae from estabelecimento where estab = 'true'), "
                    + "endereco_emit  = (select logradouro from estabelecimento where estab = 'true'), "
                    + "nr_endereco_emit = (select nr from estabelecimento where estab = 'true'), "
                    + "bairro_endereco_emit = (select bairro from estabelecimento where estab = 'true'), "
                    + "cod_cidade_endereco_emit = (select municipios.COD_UF from municipios inner join estabelecimento where municipios.MUNICIPIO = estabelecimento.cidade and estabelecimento.estab = 'true'), "
                    + "cidade_endereco_emit = (select cidade from estabelecimento where estab = 'true'), "
                    + "uf_endereco_emit = (select uf from estabelecimento where estab = 'true'), "
                    + "cep_endereco_emit = (select cep from estabelecimento where estab = 'true'), "
                    + "telefone_emit = (select telefone from estabelecimento where estab = 'true'), "
                    + "cod_pais_emit = (select moedas.COD_PAIS from moedas inner join estabelecimento where moedas.PAIS = estabelecimento.pais and estabelecimento.estab = 'true' group by moedas.COD_PAIS), "
                    + "pais_emit = (select pais from estabelecimento where estab = 'true'), "
                    + "cod_uf_emit = (select cod_uf from municipios inner join estabelecimento where municipios.sigla_uf = estabelecimento.uf and estabelecimento.estab = 'true' limit 1), "
                    + "razao_social_dest = (select razaosocial from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "nome_fantasia_dest = (select nomefantasia from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "cnpj_dest = (select cnpj from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "IE_dest = (select ie from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "IM_dest = (select im from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "endereco_dest  = (select logradouro from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "nr_endereco_dest = (select nr_endereco from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "bairro_endereco_dest = (select bairro from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "cod_cidade_endereco_dest = (select municipios.COD_MUNICIPIO from municipios inner join fornecedor where municipios.MUNICIPIO = fornecedor.municipio and fornecedor.razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "cidade_endereco_dest = (select municipio from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "uf_endereco_dest = (select uf from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "cep_endereco_dest = (select cep from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "telefone_dest = (select tel from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), "
                    + "cod_pais_dest = (select moedas.COD_PAIS from moedas inner join fornecedor where moedas.PAIS = fornecedor.pais and fornecedor.razaosocial = '"+fornecedor.getRazaoSocial()+"' group by moedas.COD_PAIS), "
                    + "pais_dest = (select pais from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), where id_produto = '"+data.getID()+"' or descricao = '"+data.getDescricao()+"';";
            
            stmq = conexao.prepareStatement(inserirQtde);
            stm = conexao.prepareStatement(sql);

            stmq.execute();
            stm.execute();
            
            txtQtde.clear();
            tabela.setItems(ListaNFeAdd());
            
            lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
            lblValorTotalNota.setText("R$"+String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", "").replace(".",","));
            
            conexao.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnAdicionarQtde(){
        
        DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
        ResultSet rs;
        PreparedStatement stm;
        PreparedStatement consulta;
        PreparedStatement atualiza;
        PreparedStatement totalstm;
        
        try{
            Connection conexao = Conexao.getConexao();
            
            DadosForn fornecedor = ItensNfe.cbFornecedor.getSelectionModel().getSelectedItem();
            
            String atualizarQtde = "update itemsnfe set qtde = qtde + "+txtQtde.getText()+" where id_produto = '"+data.getID()+"' and descricao = '"+data.getDescricao()+"';";            
            String sql = "update itemsnfe set id_produto = '"+data.getID()+"', descricao = '"+data.getDescricao()+"', ncm = '"+data.getNcm()+"', cest = '"+data.getCest()+"', und_medida = '"+data.getUnd_medida()+"', origem_icms = '"+data.getOrigem().substring(0, 1)+"',  cst_icms = '"+data.getCST_ICMS().substring(0, 3)+"', cst_ipi = '"+data.getCST_IPI().substring(0, 6).replace("IPI ", "")+"',cst_pis = '"+data.getCST_PIS().substring(0, 6).replace("PIS ", "")+"',cst_cofins = '"+data.getCST_COFINS().substring(0, 10).replace("COFINS", "")+"', enquadramento = '"+data.getCodEnquadramento()+"',redutor_icms = "+data.getRedutor()+", base_icms = "+txtQtde.getText()+" * "+data.getValor_pago()+" - ("+txtQtde.getText()+" * "+data.getValor_pago()+" * "+data.getRedutor()+" / 100), aliq_icms = "+data.getICMS()+", valorIcms = base_icms * aliq_icms / 100, redutor_icms_st = "+data.getRedutor_ST()+", mva = "+data.getMVA()+", base_icms_st = (base_icms * "+data.getMVA()+" / 100 + base_icms) - ((base_icms * "+data.getMVA()+" / 100 + base_icms) * "+data.getRedutor_ST()+" / 100), aliq_icms_st = "+data.getICMS()+", valor_icms_st = base_icms_st * aliq_icms_st / 100 - valorIcms, base_ipi = "+data.getValor_pago()+" * "+txtQtde.getText()+", aliq_ipi = "+data.getIPI()+", valor_ipi = base_ipi * aliq_ipi / 100, base_pis = "+data.getValor_pago()+" * "+txtQtde.getText()+", aliq_pis = "+data.getPIS()+", valor_pis = base_pis * aliq_pis / 100, base_cofins = "+data.getValor_pago()+" * "+txtQtde.getText()+", aliq_cofins = "+data.getCOFINS()+", valor_cofins = base_cofins * aliq_cofins / 100, base_fcp_st = "+data.getValor_pago()+" * "+txtQtde.getText()+", aliq_fcp_st = "+data.getFCP()+", valor_fcp_st = base_fcp_st * aliq_fcp_st / 100, base_ii = "+data.getValor_pago()+" * "+txtQtde.getText()+", aliq_ii = "+data.getII()+", valor_ii = base_ii * aliq_ii / 100, valor_unitario = "+data.getValor_pago()+", valor_total_unitario = valor_unitario * qtde, valor_frete = "+data.getFrete()+", valor_seguro = "+data.getSeguro()+", valor_desconto = "+data.getDesconto()+", outras_despesas = "+data.getOutros()+", razao_social_emit = (select razaosocial from estabelecimento where estab = 'true'), nome_fantasia_emit = (select nomefantasia from estabelecimento where estab = 'true'), cnpj_emit = (select cnpj from estabelecimento where estab = 'true'), IE_emit = (select ie from estabelecimento where estab = 'true'), IM_emit = (select im from estabelecimento where estab = 'true'), IEST_emit = (select iest from estabelecimento where estab = 'true'), CNAE_emit = (select cnae from estabelecimento where estab = 'true'), endereco_emit  = (select logradouro from estabelecimento where estab = 'true'), nr_endereco_emit = (select nr from estabelecimento where estab = 'true'), bairro_endereco_emit = (select bairro from estabelecimento where estab = 'true'), cod_cidade_endereco_emit = (select municipios.COD_MUNICIPIO from municipios inner join estabelecimento where municipios.MUNICIPIO = estabelecimento.cidade and estabelecimento.estab = 'true'), cidade_endereco_emit = (select cidade from estabelecimento where estab = 'true'), uf_endereco_emit = (select uf from estabelecimento where estab = 'true'), cep_endereco_emit = (select cep from estabelecimento where estab = 'true'), telefone_emit = (select telefone from estabelecimento where estab = 'true'), cod_pais_emit = (select moedas.COD_PAIS from moedas inner join estabelecimento where moedas.PAIS = estabelecimento.pais and estabelecimento.estab = 'true' group by moedas.COD_PAIS), pais_emit = (select pais from estabelecimento where estab = 'true'), razao_social_dest = (select razaosocial from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), nome_fantasia_dest = (select nomefantasia from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), cnpj_dest = (select cnpj from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), IE_dest = (select ie from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), IM_dest = (select im from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), endereco_dest  = (select logradouro from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), nr_endereco_dest = (select nr_endereco from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), bairro_endereco_dest = (select bairro from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), cod_cidade_endereco_dest = (select municipios.COD_MUNICIPIO from municipios inner join fornecedor where municipios.MUNICIPIO = fornecedor.municipio and fornecedor.razaosocial = '"+fornecedor.getRazaoSocial()+"'), cidade_endereco_dest = (select municipio from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), uf_endereco_dest = (select uf from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), cep_endereco_dest = (select cep from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), telefone_dest = (select tel from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"'), cod_pais_dest = (select moedas.COD_PAIS from moedas inner join fornecedor where moedas.PAIS = fornecedor.pais and fornecedor.razaosocial = '"+fornecedor.getRazaoSocial()+"' group by moedas.COD_PAIS), pais_dest = (select pais from fornecedor where razaosocial = '"+fornecedor.getRazaoSocial()+"') where id_produto = '"+data.getID()+"' and descricao = '"+data.getDescricao()+"';";//
            
            atualiza = conexao.prepareStatement(atualizarQtde);
            stm = conexao.prepareStatement(sql);

            atualiza.execute();
            stm.execute();
            
            txtQtde.setText("1");
            tabela.setItems(ListaNFeAdd());
            tabela.getSelectionModel().getSelectedItems();
            
            lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
            lblValorTotalNota.setText("R$"+String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", "").replace(".",","));
            
            conexao.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static ObservableList<DadosProdutosAdd> consultarQtde(){
           ResultSet rs;
           PreparedStatement stm;
           ObservableList<DadosProdutosAdd> dados = FXCollections.observableArrayList();
           DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
            
           try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT COUNT(*) as count FROM itemsnfe WHERE id_produto = '"+data.getID()+"' or id_produto = '"+txtBuscaId_Barras.getText()+"' and descricao = '"+data.getDescricao()+"';";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                int count = 0;
                
                while(rs.next()){
                    count = rs.getInt("count");    
                }
                if(count == 1){
                    btnAdicionarQtde();
                    txtQtde.setText("1");
                }else{
                    btnAdicionarDescricao();
                    txtQtde.setText("1");
                }
           }catch(Exception ex){
                System.err.println(ex);
           }
            return dados;
    }
    public static void btnCancelar(){

        ResultSet rs;
        PreparedStatement stm;
        PreparedStatement consulta;
        PreparedStatement atualiza;        
        PreparedStatement stmdelete;
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "truncate table itemsnfe";
            String delete = "delete from nfe";
            stm = conexao.prepareStatement(sql);
            stmdelete = conexao.prepareStatement(delete);
            stm.execute(sql);
            stmdelete.execute(delete);
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }
    public static void Focus(){
        DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
        
        txtBuscaDescricao.setText(data.getDescricao());
        txtBuscaId_Barras.setText(String.valueOf(data.getID()));
    }
    public static void btnExcluir(){
        
        DadosProdutosAdd data = tabela.getSelectionModel().getSelectedItem();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM ITEMSNFE WHERE DESCRICAO = '"+data.getDescricao()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            if(data == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{
                stm.execute(sql);
                tabela.setItems(ListaNFeAdd());
                lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
                lblValorTotalNota.setText("R$"+String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", "").replace(".",","));
                conexao.close();
            }
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }    
        public static ObservableList<DadosTotalizadores> Totalizadores(){
            ResultSet rs;
            PreparedStatement stm;
            ObservableList<DadosTotalizadores> dados = FXCollections.observableArrayList();
            DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
            
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT SUM(valor_total_unitario) as valor_produtos FROM itemsnfe;";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    double valor_produtos = rs.getDouble("valor_produtos");    
                    dados.add(new DadosTotalizadores(valor_produtos));
                }
           }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
        
    public static ObservableList<DadosTotalNota> TotalizadoresNota(){
            ResultSet rs;
            PreparedStatement stm;
            ObservableList<DadosTotalNota> dados = FXCollections.observableArrayList();
            DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
            
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT SUM(valor_total_unitario) as valor_total_unitario, SUM(valor_icms_st) as valor_icms_st, SUM(valor_frete) as valor_frete, SUM(valor_seguro) as valor_seguro, SUM(outras_despesas) as outras_despesas, SUM(valor_fcp_st) as valor_fcp_st, SUM(valor_desconto) as valor_desconto, SUM(valor_total_unitario + valor_icms_st + valor_frete + valor_seguro + outras_despesas + valor_fcp_st - valor_desconto) as valor_total FROM itemsnfe";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    double valor_total = rs.getDouble("valor_total");    
                    dados.add(new DadosTotalNota(valor_total));
                }
           }catch(Exception ex){
                System.err.println(ex);
           }
           return dados;
    }    
    public static ObservableList<DadosProtocolo> Protocolo(){
            ResultSet rs;
            PreparedStatement stm;
            ObservableList<DadosProtocolo> dados = FXCollections.observableArrayList();
            DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
            
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT ID FROM nfe WHERE razao_social_dest = '"+ItensNfe.cbFornecedor.getSelectionModel().getSelectedItem().getRazaoSocial()+"';";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    int id = rs.getInt("ID");    
                    dados.add(new DadosProtocolo(id));
                }
           }catch(Exception ex){
                System.err.println(ex);
           }
           return dados;
    }    
}
