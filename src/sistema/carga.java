package sistema;

import com.sun.glass.events.KeyEvent;
import java.io.InputStream;
import java.io.*;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import static sistema.cargaEstoque.cbFornecedor;

public class carga extends cargaEstoque{
    
    public static VBox telaPrincipal;
    public static HBox painelPesquisa;
    public static HBox painelPesquisa2;
    public static HBox painelBotoes;
    public static Scene cenarioPrincipal;
    public static Stage init;
    public static Label message;
    public static Label razaoDestinatario;
    public static Label lbltipoEntrada;
    public static Label lblDataEmissaoNF;
    public static Button btnCancelar;
    public static Button btnAdicionar;
    public static Button btnExcluir;
    public static Button btnConcluir;
    public static TextField txtBuscaDescricao;
    public static TextField txtBuscaId_Barras;
    public static TextField txtQtde;
    public static ComboBox cbBuscar;
    public static TableView<DadosProdutos> tabelaProdutos;
    public static TableView<DadosEstoqueAdd> tabela;
    public static TableColumn<DadosProdutos, Integer> colunaID;
    public static TableColumn<DadosProdutos, String> colunaDescricao;
    public static TableColumn<DadosProdutos, Double> colunaQtde;
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
    public static TableColumn<DadosProdutos, Double> colunaMarckup;    
    public static TableColumn<DadosProdutos, Double> colunaValorVarejo;    
    public static TableColumn<DadosEstoqueAdd, Integer> colunaIDAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaDescricaoAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaQtdeAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaNCMAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaCESTAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaCSTAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaBarrasAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorUnitarioAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorTotalUnitarioAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaBaseICMSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaAliqICMSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaRedICMSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorICMSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaBaseICMS_STAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaMVAAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorICMS_STAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaBaseIPIAdd;
    public static TableColumn<DadosEstoqueAdd, String> colunaEnquadramentoAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaAliqIPIAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorIPIAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaBasePISAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaAliqPISAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorPISAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaBaseCOFINSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaAliqCOFINSAdd;
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorCOFINSAdd;    
    public static TableColumn<DadosEstoqueAdd, Double> colunaValorSubTotal;    
    public static TableColumn<DadosEstoqueAdd, Double> colunaNrNota;    
    public static Label lblTotalProdutos;
    public static Label lblValorTotalProdutos ;
    public static Label lblTotalNota;
    public static Label lblDataEntrada;
    public static Label lblValorTotalNota;
    public static HBox painelTotalizadores;
    public static String dt;
    public static String dataFormatada;
    public static String dataFormatadaD;
    public static String txtDataEmissao;
    
    public static void show(String msg, String title){
        
        String dataEmUmFormato = String.valueOf(cargaEstoque.dataEmissao.getValue());
        SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        Date dataD;
        Date dataDa;
        
        try {
            dataD = formato.parse(dataEmUmFormato);
            dataDa = formato.parse(String.valueOf(LocalDate.now()));
            formato.applyPattern("dd/MM/yyyy");
            dataFormatada = formato.format(dataD);
            dataFormatadaD = formato.format(dataDa);
        } catch (ParseException ex) {
            Logger.getLogger(carga.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        telaPrincipal = new VBox(5);
        cenarioPrincipal = new Scene(telaPrincipal, 890, 520);
        lblDataEmissaoNF = new Label();
        cbBuscar = new ComboBox();
        painelPesquisa = new HBox(5);
        painelPesquisa2 = new HBox(5);
        painelTotalizadores = new HBox(5);
        painelBotoes = new HBox(5);
        txtBuscaDescricao = new TextField();
        txtBuscaId_Barras = new TextField();
        txtQtde = new TextField();
        init = new Stage();
        lblDataEntrada = new Label();
        btnAdicionar = new Button("_Adicionar");
        btnExcluir = new Button("E_xcluir");
        btnConcluir = new Button("Con_cluir");
        btnCancelar = new Button("Canc_elar");
        tabelaProdutos = new TableView<DadosProdutos>();
        tabela = new TableView<DadosEstoqueAdd>();
        razaoDestinatario = new Label();
        Label numeroProt = new Label();
        dt = String.valueOf(cargaEstoque.dataEmissao.getValue());
        Label lblQtde = new Label("Qtde");
        lblTotalProdutos = new Label("Total: ");
        lblTipoEntrada = new Label();
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
        
        cbBuscar.setValue("ID ou Cód. Barras");        
        
        cbBuscar.getItems().addAll("ID ou Cód. Barras", "Descrição");
        
        txtBuscaId_Barras.setOnKeyPressed(e -> {
		    if(Pesquisar().isEmpty()){
                        tabelaProdutos.setItems(Produto.ListaProdutos());
                    }else{
                        tabelaProdutos.setItems(Pesquisar());
                        tabelaProdutos.getSelectionModel().selectFirst();
                    }
                    if(e.getCode() == KeyCode.ENTER){
                    consultarQtde();
                    txtBuscaId_Barras.setText(null);
                    txtBuscaId_Barras.isFocused();
                    }
                });

                btnAdicionar.setGraphic(Login.imageViewAdicionar);
                btnExcluir.setGraphic(Login.imageViewExcluir);
                btnConcluir.setGraphic(Login.imageViewOkCargaEstoque);
                btnCancelar.setGraphic(Login.imageViewCancelarCargaEstoque);
        
                txtBuscaDescricao.setOnKeyPressed(e -> {
		    if(BuscarDescricao().isEmpty()){
                        tabelaProdutos.setItems(Produto.ListaProdutos());
                    }else{
                        tabelaProdutos.setItems(BuscarDescricao());
                        tabelaProdutos.getSelectionModel().selectFirst();
                    }
                    if(e.getCode() == KeyCode.ENTER){
                    consultarQtde();
                    txtBuscaDescricao.setText(null);
                    txtBuscaDescricao.isFocused();
                    }
                });
                txtQtde.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                        consultarQtde();
                        if(cbBuscar.getValue() == "Descrição"){
                            txtBuscaDescricao.setText(null);
                            txtBuscaDescricao.isFocused();
                        }else if(cbBuscar.getValue() == "ID ou Cód. Barras"){
                            txtBuscaId_Barras.setText(null);
                            txtBuscaId_Barras.isFocused();
                        }
                        
                    }
                });
                
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
//                              Focus();
                      }else if(cbBuscar.getValue() == "Descrição"){
                              painelPesquisa2.getChildren().clear();
                              txtBuscaId_Barras.clear();
                              txtBuscaId_Barras.setDisable(true);
                              txtBuscaDescricao.clear();
                              txtBuscaDescricao.setDisable(false);
                              painelPesquisa2.getChildren().addAll(txtBuscaDescricao, lblQtde, txtQtde);
//                              Focus();
                      }        
                 });
        
        cargaEstoque.cbFornecedor.setConverter(new StringConverter<DadosForn>() {
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
        
        numeroProt.setText("Número Nota: "+cargaEstoque.txtNumeroNota.getText());
        numeroProt.setStyle("-fx-font-weight: bold");
        lblQtde.setStyle("-fx-font-weight: bold");
        lblDataEmissaoNF.setStyle("-fx-font-weight: bold");
        lblDataEntrada.setStyle("-fx-font-weight: bold");
        lblTipoEntrada.setStyle("-fx-font-weight: bold");
        lblTotalProdutos.setStyle("-fx-font-weight: bold");
        razaoDestinatario.setStyle("-fx-font-weight: bold");
        razaoDestinatario.setText("Fornecedor: "+cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem().getRazaoSocial());
        lblTipoEntrada.setText("Tipo Entrada: "+cargaEstoque.cbTipoEntrada.getValue());
        lblDataEntrada.setText("Data Entrada: "+dataFormatadaD);
        lblDataEmissaoNF.setText("Data Emissão NFe: "+dataFormatada);
        
        colunaID = new TableColumn<DadosProdutos, Integer>("Código");
        colunaID.setPrefWidth(100);
        colunaID.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Integer>("ID"));
        colunaDescricao = new TableColumn<DadosProdutos, String>("Descrição");
        colunaDescricao.setPrefWidth(300);
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("descricao"));
        colunaQtde = new TableColumn<DadosProdutos, Double>("Qtde Estoque");
        colunaQtde.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("estoque"));
        colunaBarras = new TableColumn<DadosProdutos, String>("Cód. Barras");
        colunaBarras.setPrefWidth(120);
        colunaBarras.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("barras"));     
        colunaValorUnitario = new TableColumn<DadosProdutos, Double>("Valor Unit."); 
        colunaValorUnitario.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("custo"));     
        colunaMarckup = new TableColumn<DadosProdutos, Double>("Margem(%)"); 
        colunaMarckup.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("marckup"));     
        colunaValorVarejo = new TableColumn<DadosProdutos, Double>("Valor Varejo"); 
        colunaValorVarejo.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("varejo"));     
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
        colunaIDAdd = new TableColumn<DadosEstoqueAdd, Integer>("Código");
        colunaIDAdd.setPrefWidth(100);
        colunaIDAdd.setStyle(".table-column{ -fx-alignment: CENTER_LEFT };");
        colunaIDAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Integer>("id"));
        colunaDescricaoAdd = new TableColumn<DadosEstoqueAdd, String>("Descrição");
        colunaDescricaoAdd.setPrefWidth(300);
        colunaDescricaoAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("descricao"));
        colunaQtdeAdd = new TableColumn<DadosEstoqueAdd, Double>("Qtde");
        colunaQtdeAdd.setPrefWidth(85);
        colunaQtdeAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("qtde"));
        colunaNCMAdd = new TableColumn<DadosEstoqueAdd, String>("NCM");
        colunaNCMAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("ncm"));
        colunaCESTAdd = new TableColumn<DadosEstoqueAdd, String>("CEST");
        colunaCESTAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("cest"));    
        colunaCSTAdd = new TableColumn<DadosEstoqueAdd, String>("CST");
        colunaCSTAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("cst"));     
        colunaBarrasAdd = new TableColumn<DadosEstoqueAdd, String>("Cód. Barras");
        colunaBarrasAdd.setPrefWidth(150);
        colunaBarrasAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("barras"));     
        colunaValorUnitarioAdd = new TableColumn<DadosEstoqueAdd, Double>("Valor Unit."); 
        colunaValorUnitarioAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("custo"));     
        colunaValorTotalUnitarioAdd = new TableColumn<DadosEstoqueAdd, Double>("Valor Total."); 
        colunaValorTotalUnitarioAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("valor_total"));     
        colunaBaseICMSAdd = new TableColumn<DadosEstoqueAdd, Double>("Base ICMS");
        colunaBaseICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("BASE_ICMS"));     
        colunaAliqICMSAdd = new TableColumn<DadosEstoqueAdd, Double>("Aliq ICMS");
        colunaAliqICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("icms"));
        colunaRedICMSAdd = new TableColumn<DadosEstoqueAdd, Double>("Redutor ICMS");
        colunaRedICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("redutor"));
        colunaValorICMSAdd = new TableColumn<DadosEstoqueAdd, Double>("Vlr ICMS");
        colunaValorICMSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("VALORICMS"));
        colunaBaseICMS_STAdd = new TableColumn<DadosEstoqueAdd, Double>("Base ICMS-ST");
        colunaBaseICMS_STAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("base_icms_st"));
        colunaMVAAdd = new TableColumn<DadosEstoqueAdd, Double>("MVA");
        colunaMVAAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("mva"));
        colunaValorICMS_STAdd = new TableColumn<DadosEstoqueAdd, Double>("Vlr. ICMS-ST"); 
        colunaValorICMS_STAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("valor_icms_st"));
        colunaBaseIPIAdd = new TableColumn<DadosEstoqueAdd, Double>("Base IPI");
        colunaBaseIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("base_ipi"));
        colunaEnquadramentoAdd = new TableColumn<DadosEstoqueAdd, String>("Enquad.");
        colunaEnquadramentoAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, String>("enquadramento"));
        colunaAliqIPIAdd = new TableColumn<DadosEstoqueAdd, Double>("Aliq. IPI");
        colunaAliqIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("ipi"));
        colunaValorIPIAdd = new TableColumn<DadosEstoqueAdd, Double>("Vlr. IPI");
        colunaValorIPIAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("valor_ipi"));
        colunaBasePISAdd = new TableColumn<DadosEstoqueAdd, Double>("Base PIS");
        colunaBasePISAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("base_pis"));
        colunaAliqPISAdd = new TableColumn<DadosEstoqueAdd, Double>("Aliq PIS");
        colunaAliqPISAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("pis"));
        colunaValorPISAdd = new TableColumn<DadosEstoqueAdd, Double>("Vlr. PIS");
        colunaValorPISAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("valor_pis"));
        colunaBaseCOFINSAdd = new TableColumn<DadosEstoqueAdd, Double>("Base Cofins");
        colunaBaseCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("base_cofins"));
        colunaAliqCOFINSAdd = new TableColumn<DadosEstoqueAdd, Double>("Aliq. Cofins");
        colunaAliqCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("cofins"));
        colunaValorCOFINSAdd = new TableColumn<DadosEstoqueAdd, Double>("Vlr. Cofins");
        colunaValorCOFINSAdd.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("valor_cofins"));
        colunaValorSubTotal = new TableColumn<DadosEstoqueAdd, Double>("SubTotal");
        colunaValorSubTotal.setPrefWidth(110);
        colunaValorSubTotal.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("subtotal"));
        colunaNrNota = new TableColumn<DadosEstoqueAdd, Double>("Nrº Nota");
        colunaNrNota.setPrefWidth(110);
        colunaNrNota.setCellValueFactory(new PropertyValueFactory<DadosEstoqueAdd, Double>("NR_NOTA"));
        
        init.setScene(cenarioPrincipal);
        init.setTitle(title);
        init.initModality(Modality.APPLICATION_MODAL);
        
        message = new Label(msg);
        
        txtQtde.setText("1");
        
        lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
        
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
                    DadosEstoqueAdd data = tabela.getSelectionModel().getSelectedItem();
                    data = tabela.getSelectionModel().getSelectedItem();             
                    if(data == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        DeleteProdEntrada.show("Tem certeza que deseja excluir este item?","Erro");
                    }
        });
        btnExcluir.setOnKeyPressed(e -> {
            if(btnExcluir.isFocused() == true && e.getCode() == KeyCode.ENTER){
                    DadosEstoqueAdd data = tabela.getSelectionModel().getSelectedItem();
                    data = tabela.getSelectionModel().getSelectedItem();             
                    if(data == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        DeleteProdEntrada.show("Tem certeza que deseja excluir este item?","Erro");
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
/*        tabelaProdutos.setOnMouseClicked(e -> Focus());
        tabelaProdutos.setOnKeyPressed(e -> Focus());
        tabelaProdutos.getSelectionModel().selectFirst();
        Focus();
*/        
        btnConcluir.setOnAction(e -> {
            if(ListaEstoque().isEmpty()){
                MessageBox.show("Não existe itens na tabela", "Erro");
            }else{
                concluirEstoque.show("","Fechar");
            }
        });
        
        btnCancelar.setOnAction(e -> {
                confirmacaoCancelarEstoque.show("Tem certeza que deseja cancelar esta entrada?","Confirmação de cancelamento");
        });
        btnCancelar.setOnKeyPressed(evt -> {
            if(btnCancelar.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                confirmacaoCancelarEstoque.show("Tem certeza que deseja cancelar esta entrada?","Confirmação de cancelamento");
            }
        });
        tabela.setItems(ListaEstoque());
        
        tabelaProdutos.getColumns().addAll(colunaID, colunaDescricao, colunaQtde, colunaBarras, colunaValorUnitario, colunaMarckup, colunaValorVarejo);
        tabela.getColumns().addAll(colunaIDAdd, colunaDescricaoAdd, colunaQtdeAdd, colunaBarrasAdd, colunaValorUnitarioAdd, colunaValorSubTotal);
        painelPesquisa.getChildren().addAll(cbBuscar, painelPesquisa2);
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.getChildren().addAll(btnAdicionar, btnExcluir, btnConcluir, btnCancelar);
        telaPrincipal.setPadding(new Insets(15));
        painelTotalizadores.getChildren().addAll(lblTotalProdutos, lblValorTotalProdutos);
        telaPrincipal.getChildren().addAll(numeroProt, razaoDestinatario, lblDataEmissaoNF, lblDataEntrada, lblTipoEntrada, message, painelPesquisa,tabelaProdutos, tabela, painelTotalizadores, painelBotoes);
        init.showAndWait();
    }   
    
    public static void btnAdicionar(){
        
        DadosProdutos dadosTabela = tabelaProdutos.getSelectionModel().getSelectedItem();
        DadosForn fornecedor = cbFornecedor.getSelectionModel().getSelectedItem();
        
        ResultSet rs;
        
        try{
            Connection conexao = Conexao.getConexao();

            String sql = "INSERT INTO ENTRADA(CODIGO_ITEM,DESCRICAO,QTDE,CUSTO,SUBTOTAL,DATA_ENTRADA,NR_NOTA,DATA_EMISSAO,TIPO_ENTRADA,USUARIO,COD_BARRAS,FORNECEDOR) VALUES("+dadosTabela.getID()+",'"+dadosTabela.getDescricao()+"',"+txtQtde.getText()+","+dadosTabela.getCusto().replace("R$","").replace(",",".")+","+Double.parseDouble(txtQtde.getText().replace(",","."))+"*"+dadosTabela.getCusto().replace("R$","").replace(",",".")+",NOW(),"+cargaEstoque.txtNumeroNota.getText()+",'"+String.valueOf(cargaEstoque.dataEmissao.getValue())+"','"+cargaEstoque.cbTipoEntrada.getValue()+"','"+Login.campo1.getText()+"','"+dadosTabela.getBarras()+"','"+fornecedor.getRazaoSocial()+"')";
            
            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.execute();

        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }        
        
        tabela.setItems(ListaEstoque());
        
        lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
    }        
    public static ObservableList<DadosEstoqueAdd> ListaEstoque(){
                ObservableList<DadosEstoqueAdd> dados = FXCollections.observableArrayList();
        
                try{
                        ResultSet rs;

                        Connection conexao = Conexao.getConexao();
                        String consulta = "SELECT CODIGO_ITEM,DESCRICAO,QTDE,COD_BARRAS,CUSTO,SUBTOTAL,NR_NOTA FROM ENTRADA WHERE NR_NOTA = "+cargaEstoque.txtNumeroNota.getText()+" ;";
                        PreparedStatement stm = conexao.prepareStatement(consulta);
                        rs = stm.executeQuery(consulta);

                        while(rs.next()){
                            int id = rs.getInt("CODIGO_ITEM");
                            String descricao = rs.getString("DESCRICAO");
                            double qtde = rs.getDouble("QTDE");
                            String barras = rs.getString("COD_BARRAS");
                            double custo = rs.getDouble("CUSTO");
                            double subtotal = rs.getDouble("SUBTOTAL");
                            int nr_nota = rs.getInt("NR_NOTA");
                            
                            dados.add(new DadosEstoqueAdd(id, descricao, String.format("%.2f", qtde).replace(".",","), barras, "R$"+String.format("%.2f", custo).replace(".",","), "R$"+String.format("%.2f", subtotal).replace(".",","), nr_nota));
                        }
                }catch(Exception e){
                    MessageBox.show(""+e, "Erro");
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
                    
                    dadosDescr.add(new DadosProdutos(id, descricao, categoria, barras, ncm, cest, fabricante, fornecedor, und_medida, String.format("%.02f", estoque).replace(".",","), est_minimo, est_maximo, valor_pago, desc_promocional, qtde_promocional, ii, ipi, pis, cofins, icms, mva, redutor, redutor_st, seguro, outros, desconto, frete, validade, "R$"+String.format("%.02f", custo).replace(".",","), String.format("%.02f", marckup).replace(".",",")+"%", "R$"+String.format("%.02f", varejo).replace(".",","), inclusao, alteracao, FCP, CST_ICMS, Origem, CST_IPI, CodEnquadramento, CST_PIS, CST_COFINS, Tributacao,QTDE_CX_PCT_SC_FD));
                }
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
    public static void btnAdicionarQtde(){
        
        DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
        ResultSet rs;
        PreparedStatement stm;
        PreparedStatement consulta;
        PreparedStatement atualiza;
        
        try{
            Connection conexao = Conexao.getConexao();
            
            String atualizarQtde = "UPDATE ENTRADA SET QTDE = QTDE + "+txtQtde.getText().replace(",",".")+" WHERE NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+" AND DESCRICAO = '"+data.getDescricao()+"';";
            String sql = "UPDATE ENTRADA SET SUBTOTAL = CUSTO * QTDE WHERE NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+" AND DESCRICAO = '"+data.getDescricao()+"';";            
            
            atualiza = conexao.prepareStatement(atualizarQtde);
            stm = conexao.prepareStatement(sql);

            atualiza.execute();
            stm.execute();
            
            txtQtde.setText("1");
            tabela.setItems(ListaEstoque());

            lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
            
            conexao.close();
        }catch(Exception e){
            System.err.println(e);
        }
    }

    public static ObservableList<DadosEstoqueAdd> consultarQtde(){
        
           ResultSet rs;
           PreparedStatement stm;
           ObservableList<DadosEstoqueAdd> dados = FXCollections.observableArrayList();
           DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
            
           try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT COUNT(*) AS COUNT FROM ENTRADA WHERE NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+" AND DESCRICAO = '"+data.getDescricao()+"';";
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
                    btnAdicionar();
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
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM ENTRADA WHERE NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+";";
            stm = conexao.prepareStatement(sql);
            stm.execute(sql);
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }
    /*public static void Focus(){
        
        DadosProdutos data = tabelaProdutos.getSelectionModel().getSelectedItem();
        
        txtBuscaDescricao.setText(data.getDescricao());
        txtBuscaId_Barras.setText(String.valueOf(data.getID()));
    }*/
    public static void btnExcluir(){
        
        DadosEstoqueAdd data = tabela.getSelectionModel().getSelectedItem();
        
        try{
            Connection conexao = Conexao.getConexao();
            String sql = "DELETE FROM ENTRADA WHERE DESCRICAO = '"+data.getDescricao()+"' AND NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+";";
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            if(data == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{
                stm.execute(sql);
                tabela.setItems(ListaEstoque());
                lblValorTotalProdutos.setText("R$"+String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
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
                String consulta = "SELECT SUM(SUBTOTAL) AS VALOR_TOTAL FROM ENTRADA WHERE NR_NOTA = "+Integer.parseInt(cargaEstoque.txtNumeroNota.getText())+";";
                stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    double valor_produtos = rs.getDouble("VALOR_TOTAL");    
                    dados.add(new DadosTotalizadores(valor_produtos));
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
                String consulta = "SELECT ID FROM entrada WHERE FORNECEDOR = '"+cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem().getRazaoSocial()+"';";
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
