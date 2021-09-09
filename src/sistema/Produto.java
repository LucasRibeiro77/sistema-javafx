package sistema;

import java.io.InputStream;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.geometry.*;
import java.sql.*;
import java.text.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.util.StringConverter;

public class Produto{
    
    public static DadosProdutos data;
    public static TextField campo1;
    public static ComboBox<DadosCat> campo2;
    public static ComboBox<DadosFabr> campo3;
    public static ComboBox<DadosForn> campo4;
    public static TextField campo5;
    public static TextField campo6;
    public static TextField campo7;
    public static TextField campo8;
    public static TextField campo9;
    public static TextField campo10;
    public static TextField campo11;
    public static TextField campo12;
    public static TextField campo13;
    public static TextField campo14;
    public static TextField campo15;
    public static TextField campo16;
    public static MaskedTextField campo17;
    public static MaskedTextField campo18;
    public static ComboBox<DadosMed> campo19;
    public static TextField campo20;
    public static TextField formatado2;
    public static TextField campo21;
    public static TextField campo22;
    public static TextField campo23;
    public static TextField campo24;
    public static TextField campo25;
    public static TextField campo26;
    public static TextField campo27;
    public static TextField campo28;
    public static TextField campo29;
    public static TextField campo30;
    public static TextField campo31;
    public static TextField campo32;
    public static TextField campo34;
    public static ComboBox campo35;
    public static ComboBox campo36;
    public static ComboBox campo37;
    public static TextField campo38;
    public static ComboBox campo39;
    public static ComboBox campo40;
    public static ComboBox campo41;
    public static ComboBox campo42;
    public static TextField campo43;
    public static TextField campo44;       
    public static MaskedTextField campo33;
    public static TableView<DadosProdutos> tabela;
    public static TableView<DadosHistoricoCompra> tabelaHistCompra;
    public static TableView<DadosHistoricoVenda> tabelaHistVenda;
    public static TableView<DadosHistoricoEvento> tabelaHistEvento;
    public static TableColumn<DadosProdutos, Integer> coluna1;
    public static TableColumn<DadosProdutos, String> coluna2;
    public static TableColumn<DadosProdutos, String> coluna3;
    public static TableColumn<DadosProdutos, String> coluna4;
    public static TableColumn<DadosProdutos, Double> coluna5;
    public static TableColumn<DadosProdutos, String> coluna6;
    public static TableColumn<DadosProdutos, String> coluna7;
    public static TableColumn<DadosProdutos, String> coluna8;
    public static TableColumn<DadosProdutos, String> coluna9;
    public static TableColumn<DadosHistoricoCompra, Integer> colunaCompraNrNF;
    public static TableColumn<DadosHistoricoCompra, String> colunaCompraFornecedor;
    public static TableColumn<DadosHistoricoCompra, String> colunaCompraCusto;
    public static TableColumn<DadosHistoricoCompra, String> colunaCompraQtde;
    public static TableColumn<DadosHistoricoCompra, String> colunaCompraDataHora;
    public static TableColumn<DadosHistoricoCompra, String> colunaCompraUsuario;
    public static TableColumn<DadosHistoricoVenda, String> colunaVendaProtocolo;
    public static TableColumn<DadosHistoricoVenda, Double> colunaVenda;
    public static TableColumn<DadosHistoricoVenda, Double> colunaVendaQtde;
    public static TableColumn<DadosHistoricoVenda, String> colunaVendaDataHora;
    public static TableColumn<DadosHistoricoVenda, String> colunaVendaUsuario;
    public static TableColumn<DadosHistoricoVenda, String> colunaVendaCliente;
    public static TableColumn<DadosHistoricoEvento, String> colunaEventoDescricao;
    public static TableColumn<DadosHistoricoEvento, String> colunaEventoDataHora;
    public static TableColumn<DadosHistoricoEvento, String> colunaEventoUsuario;
    public static Button btnAlterar;
    public static Button btnAdd;
    public static Button btnEditar;
    public static Button btnOk;
    public static Button btnCancel;
    public static Button btnExcluir;
    public static Button btnFechar;
    public static Button btnBuscar;
    public static Button btnBuscarID;
    public static DecimalFormat df;
    public static LocalDate dataAtual;
    public static String qtdeDias;
    public static Label arg42;
    public static Label lblHistCompra;
    public static Label lblHistVenda;
    public static Label lblHistEvento;
    public static TextField tf;
                
    public static void show(String mensagem, String titulo){

                lblHistCompra = new Label("Compra");
                lblHistVenda = new Label("Venda");
                lblHistEvento = new Label("Evento");
                
                tf = new TextField();
                
                lblHistCompra.setStyle("-fx-font-weight: bold");
                lblHistVenda.setStyle("-fx-font-weight: bold");
                lblHistEvento.setStyle("-fx-font-weight: bold");
                
                campo1 = new TextField();
                tabela = new TableView<DadosProdutos>();
                tabelaHistCompra = new TableView<DadosHistoricoCompra>();
                tabelaHistVenda = new TableView<DadosHistoricoVenda>();
                tabelaHistEvento = new TableView<DadosHistoricoEvento>();
                coluna1 = new TableColumn<DadosProdutos, Integer>("ID");
                coluna1.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Integer>("ID"));
                coluna2 = new TableColumn<DadosProdutos, String>("Descrição");
                coluna2.setMinWidth(300);
                coluna2.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Descricao"));
                coluna3 = new TableColumn<DadosProdutos, String>("Fabricante");
                coluna3.setMinWidth(180);
                coluna3.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("fabricante"));
                coluna4 = new TableColumn<DadosProdutos, String>("Custo");
                coluna4.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Custo"));
                coluna5 = new TableColumn<DadosProdutos, Double>("Margem(%)");
                coluna5.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("Marckup"));
                coluna6 = new TableColumn<DadosProdutos, String>("Venda");
                coluna6.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Varejo"));
                coluna7 = new TableColumn<DadosProdutos, String>("Cadastrado");
                coluna7.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Inclusao"));
                coluna8 = new TableColumn<DadosProdutos, String>("Alterado");
                coluna8.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Alteracao"));
                coluna9 = new TableColumn<DadosProdutos, String>("Qtde. Estoque");
                coluna9.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Estoque"));
                
                colunaCompraNrNF = new TableColumn<DadosHistoricoCompra, Integer>("NF");
                colunaCompraNrNF.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, Integer>("NrNF"));
                colunaCompraFornecedor = new TableColumn<DadosHistoricoCompra, String>("Fornecedor");
                colunaCompraFornecedor.setPrefWidth(200);
                colunaCompraFornecedor.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, String>("fornecedor"));
                colunaCompraCusto = new TableColumn<DadosHistoricoCompra, String>("Custo");
                colunaCompraCusto.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, String>("custo"));
                colunaCompraQtde = new TableColumn<DadosHistoricoCompra, String>("Qtde");
                colunaCompraQtde.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, String>("qtde"));
                colunaCompraDataHora = new TableColumn<DadosHistoricoCompra, String>("Data/Hora");
                colunaCompraDataHora.setPrefWidth(130);
                colunaCompraDataHora.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, String>("dataEntrada"));
                colunaCompraUsuario = new TableColumn<DadosHistoricoCompra, String>("Usuário");
                colunaCompraUsuario.setCellValueFactory(new PropertyValueFactory<DadosHistoricoCompra, String>("usuario"));
                
                colunaVendaProtocolo = new TableColumn<DadosHistoricoVenda, String>("Protocolo");
                colunaVendaProtocolo.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, String>("protocolo"));
                colunaVenda = new TableColumn<DadosHistoricoVenda, Double>("Venda");
                colunaVenda.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, Double>("venda"));
                colunaVendaQtde = new TableColumn<DadosHistoricoVenda, Double>("Qtde");
                colunaVendaQtde.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, Double>("qtde"));
                colunaVendaDataHora = new TableColumn<DadosHistoricoVenda, String>("Data/Hora");
                colunaVendaDataHora.setPrefWidth(130);
                colunaVendaDataHora.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, String>("dataHora"));
                colunaVendaUsuario = new TableColumn<DadosHistoricoVenda, String>("Usuário");
                colunaVendaUsuario.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, String>("usuario"));
                colunaVendaCliente = new TableColumn<DadosHistoricoVenda, String>("Cliente");
                colunaVendaCliente.setPrefWidth(200);
                colunaVendaCliente.setCellValueFactory(new PropertyValueFactory<DadosHistoricoVenda, String>("cliente"));
                
                colunaEventoDescricao = new TableColumn<DadosHistoricoEvento, String>("Descrição");
                colunaEventoDescricao.setPrefWidth(550);
                colunaEventoDescricao.setCellValueFactory(new PropertyValueFactory<DadosHistoricoEvento, String>("descricao"));
                colunaEventoDataHora = new TableColumn<DadosHistoricoEvento, String>("Data/Hora");
                colunaEventoDataHora.setPrefWidth(130);
                colunaEventoDataHora.setCellValueFactory(new PropertyValueFactory<DadosHistoricoEvento, String>("dataEvento"));
                colunaEventoUsuario = new TableColumn<DadosHistoricoEvento, String>("Usuário");
                colunaEventoUsuario.setCellValueFactory(new PropertyValueFactory<DadosHistoricoEvento, String>("usuario"));
                
                campo2 = new ComboBox<DadosCat>();
                campo3 = new ComboBox<DadosFabr>();
                campo4 = new ComboBox<DadosForn>();
                //campo5 = new ComboBox<DadosBarras>();
                campo5 = new TextField();
                campo6 = new TextField();
                campo7 = new TextField();
                campo8 = new TextField();
                campo9 = new TextField();
                campo10 = new TextField();
                campo11 = new TextField();
                campo12 = new TextField();
                campo13 = new TextField();
                campo14 = new TextField();
                campo15 = new TextField();
                campo16 = new TextField();
                campo17 = new MaskedTextField("####.##.##");
                campo18 = new MaskedTextField("##.###.##");
                campo19 = new ComboBox<DadosMed>();
                campo20 = new TextField();
                campo21 = new TextField();
                campo22 = new TextField();
                campo23 = new TextField();
                campo24 = new TextField();
                campo25 = new TextField();
                campo26 = new TextField();
                campo27 = new TextField();
                campo28 = new TextField();
                campo29 = new TextField();
                campo30 = new TextField();                
                campo31 = new TextField();
                campo33 = new MaskedTextField("##/##/####");
                campo32 = new TextField();
                campo34 = new TextField();
                campo35 = new ComboBox();
                campo36 = new ComboBox();
                campo37 = new ComboBox();
                campo38 = new TextField();
                campo39 = new ComboBox();
                campo40 = new ComboBox();
                campo41 = new ComboBox();
                campo42 = new ComboBox();
                campo43 = new TextField();
                campo44 = new TextField();
                df = new DecimalFormat("#,##0.00");
                btnOk = new Button("_Salvar");
                btnEditar = new Button("_Editar");
                btnFechar = new Button("_Fechar");
                btnAdd = new Button("_Adicionar");
                btnExcluir = new Button("E_xcluir");
                btnCancel = new Button("_Cancelar");
                btnAlterar = new Button("A_lterar");
                btnBuscar = new Button("Buscar");
                Label arg1 = new Label("Descrição");
                Label arg2 = new Label("Categoria");
                Label arg3 = new Label("Fabricante");
                Label arg4 = new Label("Fornecedor");
                Label arg5 = new Label("Cód. Barras");
                Label arg6 = new Label("Custo");
                Label arg7 = new Label("Margem de lucro(%)");
                Label arg8 = new Label("Preço");
                Label arg9 = new Label("II(%)");
                Label arg10 = new Label("IPI(%)");
                Label arg11 = new Label("PIS(%)");
                Label arg12 = new Label("COFINS(%)");
                Label arg13 = new Label("ICMS(%)");
                Label arg14 = new Label("MVA(%)");
                Label arg15 = new Label("Red(%)");
                Label arg16 = new Label("Red. ST(%)");
                Label arg17 = new Label("NCM");
                Label arg18 = new Label("CEST");
                Label arg19 = new Label("Un. Medida");
                Label arg20 = new Label("Vlr. Seguro");
                Label arg21 = new Label("Vlr. Outros");
                Label arg22 = new Label("Vlr. pago");
                Label arg23 = new Label("Desc. Promocional(%)");
                Label arg24 = new Label("Qtde. Promocional");
                Label arg25 = new Label("Desconto");
                Label arg26 = new Label("     Buscar por ");
                Label arg27 = new Label("Est. Mínimo");
                Label arg28 = new Label("Est. Máximo");
                Label arg29 = new Label("Desconto");
                Label arg30 = new Label("Frete");
                Label arg31 = new Label("Validade");
                Label arg34 = new Label("FCP");
                Label arg35 = new Label("Origem");
                Label arg36 = new Label("CST");
                Label arg37 = new Label("CST IPI");
                Label arg38 = new Label("Cod. Enq");
                Label arg39 = new Label("CST PIS");
                Label arg40 = new Label("CST COFINS");
                Label arg41 = new Label("Tributação");
                arg42 = new Label("Qtde");

                dataAtual = LocalDate.now();
                
                tabela.getColumns().addAll(coluna1, coluna2, coluna3, coluna9, coluna4, coluna5, coluna6, coluna7, coluna8);
                tabelaHistCompra.getColumns().addAll(colunaCompraNrNF, colunaCompraFornecedor, colunaCompraCusto, colunaCompraQtde, colunaCompraDataHora, colunaCompraUsuario);
                tabelaHistVenda.getColumns().addAll(colunaVendaProtocolo, colunaVendaCliente, colunaVenda, colunaVendaQtde, colunaVendaDataHora, colunaVendaUsuario);
                tabelaHistEvento.getColumns().addAll(colunaEventoDescricao, colunaEventoDataHora, colunaEventoUsuario);
                
                String texto = mensagem;
                Label texto1 = new Label("Painel");
                Stage inicio = new Stage();
                TabPane painel = new TabPane();
                Tab tabProduto = new Tab(texto);
                Tab tabHistorico = new Tab("Hist. Produto");
                VBox painel1 = new VBox(5);
                VBox painelPrincipal = new VBox(5);
                GridPane painel2 = new GridPane();
                StackPane painel3 = new StackPane();
                HBox painel4 = new HBox(5);
                HBox painel5 = new HBox(5);
                HBox painel6 = new HBox(5);
                HBox painel7 = new HBox(5);
                HBox painel8 = new HBox(5);
                HBox valores = new HBox(5);
                HBox valores2 = new HBox(5);
                HBox estoque = new HBox(5);              
                btnBuscarID = new Button("Busca");
                
                Label FiscalTrib = new Label("Fiscal e Tributos");
                GridPane impostos = new GridPane();
                StackPane painelTrib = new StackPane();
                HBox painelPesquisa = new HBox(8);
                Scene cenario = new Scene(painelPrincipal, 1200, 610);
                HBox painelPesquisa2 = new HBox(8);
                VBox painelHistorico = new VBox(5);
        
                inicio.setScene(cenario);
                inicio.initModality(Modality.APPLICATION_MODAL);
                inicio.setTitle(titulo);

                tabProduto.setClosable(false);
                tabHistorico.setClosable(false);

                painel.getTabs().addAll(tabProduto, tabHistorico);
                tabProduto.setContent(painel1);
                tabHistorico.setContent(painelHistorico);

                tabela.setItems(ListaProdutos());
                campo1.setDisable(true);
                campo2.setDisable(true);
                campo3.setDisable(true);
                campo4.setDisable(true);
                campo5.setDisable(true);
                campo6.setDisable(true);
                campo7.setDisable(true);
                campo8.setDisable(true);
                campo9.setDisable(true);
                campo10.setDisable(true);
                campo11.setDisable(true);
                campo12.setDisable(true);
                campo13.setDisable(true);
                campo14.setDisable(true);
                campo15.setDisable(true);
                campo16.setDisable(true);
                campo17.setDisable(true);
                campo18.setDisable(true);
                campo19.setDisable(true);
                campo20.setDisable(true);
                campo21.setDisable(true);
                campo22.setDisable(true);
                campo23.setDisable(true);
                campo24.setDisable(true);
                campo25.setDisable(true);
                campo26.setDisable(false);
                campo27.setDisable(true);
                campo28.setDisable(true);
                campo29.setDisable(true);
                campo30.setDisable(true);
                campo33.setDisable(true);
                campo33.setDisable(true);
                campo34.setDisable(true);
                campo35.setDisable(true);
                campo36.setDisable(true);
                campo37.setDisable(true);
                campo38.setDisable(true);
                campo39.setDisable(true);
                campo40.setDisable(true);
                campo41.setDisable(true);
                                
                arg1.setStyle("-fx-font-weight: bold");
                arg2.setStyle("-fx-font-weight: bold");
                arg3.setStyle("-fx-font-weight: bold");
                arg4.setStyle("-fx-font-weight: bold");
                arg5.setStyle("-fx-font-weight: bold");
                arg6.setStyle("-fx-font-weight: bold");
                arg7.setStyle("-fx-font-weight: bold");
                arg8.setStyle("-fx-font-weight: bold");
                arg9.setStyle("-fx-font-weight: bold");
                arg10.setStyle("-fx-font-weight: bold");
                arg11.setStyle("-fx-font-weight: bold");
                arg12.setStyle("-fx-font-weight: bold");
                arg13.setStyle("-fx-font-weight: bold");
                arg14.setStyle("-fx-font-weight: bold");
                arg15.setStyle("-fx-font-weight: bold");
                arg16.setStyle("-fx-font-weight: bold");
                arg17.setStyle("-fx-font-weight: bold");
                arg18.setStyle("-fx-font-weight: bold");
                arg19.setStyle("-fx-font-weight: bold");
                arg20.setStyle("-fx-font-weight: bold");
                arg21.setStyle("-fx-font-weight: bold");
                arg22.setStyle("-fx-font-weight: bold");
                arg23.setStyle("-fx-font-weight: bold");
                arg24.setStyle("-fx-font-weight: bold");
                arg25.setStyle("-fx-font-weight: bold");
                arg26.setStyle("-fx-font-weight: bold");
                arg27.setStyle("-fx-font-weight: bold");
                arg28.setStyle("-fx-font-weight: bold");
                arg29.setStyle("-fx-font-weight: bold");
                arg30.setStyle("-fx-font-weight: bold");
                arg31.setStyle("-fx-font-weight: bold");
                arg34.setStyle("-fx-font-weight: bold");
                arg35.setStyle("-fx-font-weight: bold");
                arg36.setStyle("-fx-font-weight: bold");
                arg37.setStyle("-fx-font-weight: bold");
                arg38.setStyle("-fx-font-weight: bold");
                arg39.setStyle("-fx-font-weight: bold");
                arg40.setStyle("-fx-font-weight: bold");
                arg41.setStyle("-fx-font-weight: bold");
                arg42.setStyle("-fx-font-weight: bold");
                
                campo1.setMinWidth(270);
                campo17.setPlaceholder(" ");
                campo18.setPlaceholder(" ");
                campo2.setPrefWidth(100);
                campo3.setMinWidth(200);
                campo4.setMinWidth(200);
                                
                painel2.setVgap(5);
                painel2.setHgap(5);
                painel2.add(arg1, 0, 1);
                painel2.add(painel8, 1, 1);
                painel2.add(arg3, 0, 2);
                painel2.add(painel6, 1, 2);
                
                impostos.setVgap(2);
                impostos.setHgap(1);
                impostos.add(arg9, 0, 0);
                impostos.add(campo9, 1, 0);
                impostos.add(arg10, 2, 0);
                impostos.add(campo10, 3, 0);
                impostos.add(arg11, 4, 0);
                impostos.add(campo11, 5, 0);
                impostos.add(arg12, 6, 0);
                impostos.add(campo12, 7, 0);
                impostos.add(arg13, 8, 0);
                impostos.add(campo13, 9, 0);
                impostos.add(arg14, 0, 1);
                impostos.add(campo14, 1, 1);
                impostos.add(arg15, 2, 1);
                impostos.add(campo15, 3, 1);
                impostos.add(arg16, 4, 1);
                impostos.add(campo16, 5, 1);
                impostos.add(arg20, 6, 1);
                impostos.add(campo20, 7, 1);
                impostos.add(arg21, 8, 1);
                impostos.add(campo21, 9, 1);
                impostos.add(arg30, 0, 2);
                impostos.add(campo30, 1, 2);
                impostos.add(arg29, 2, 2);
                impostos.add(campo29, 3, 2);
                impostos.add(arg34, 4, 2);
                impostos.add(campo34, 5, 2);
                impostos.add(arg35, 6, 2);
                impostos.add(campo35, 7, 2);
                impostos.add(arg36, 8, 2);
                impostos.add(campo36, 9, 2);
                impostos.add(arg37, 0, 3);
                impostos.add(campo37, 1, 3);
                impostos.add(arg38, 2, 3);
                impostos.add(campo38, 3, 3);
                impostos.add(arg39, 4, 3);
                impostos.add(campo39, 5, 3);
                impostos.add(arg40, 6, 3);
                impostos.add(campo40, 7, 3);
                impostos.add(arg41, 8, 3);
                impostos.add(campo41, 9, 3);

                campo44.setDisable(true);
                
                DadosMed sigla = campo19.getSelectionModel().getSelectedItem();
                
                    campo19.setOnAction(e -> {
                        if(campo19.getValue() == QtdeUnitaria()){
                            campo44.setDisable(false);
                        }else{
                            campo44.setDisable(true);
                        }
                    });

                    if(campo19.getValue() == QtdeUnitaria()){
                        campo44.setDisable(false);
                    }else{
                        campo44.setDisable(true);
                    }
                
                campo4.getItems().addAll(ListaFornecedores());
                
                campo26.setOnKeyPressed(e -> {
		    if(Pesquisar().isEmpty()){
                        tabela.setItems(ListaProdutos());
                    }else{
                        tabela.setItems(Pesquisar());
                    }
                });
                
                campo43.setOnKeyPressed(e -> {
		    if(BuscarDescricao().isEmpty()){
                        tabela.setItems(ListaProdutos());
                    }else{
                        tabela.setItems(BuscarDescricao());
                    }
                });            
                campo35.getItems().addAll("0 - Nacional, exceto as indicadas nos códigos 3,4,5 e 8","1 - Estrangeira - Inportação Direta, exceto a indicada no código 6","2 - Estrangeira - Adquirida no Mercado Interno, exceto a indicada no codigo 7","3 - Nacional, mercadoria ou bem com conteúdo de importação superior a 40% e inferior ou igual a 70%","4 - Nacional, cuja produção tenha sido feita em conformidade com os processos produtivos básicos que tratam das legislações citadas nos ajustes","5 - Nacional, mercadoria ou bem com conteúdo de importação inferior ou igual a 40%","6 - Estrangeira - Importação direta, sem similar nacional, constante em lista da CAMEX e gás natural","7 - Estrangeira - Adquirida no mercado interno, sem similar nacional, constante em lista da CAMEX e gás natural","8 - Nacional, mercadoria ou bem com conteúdo de Importação superior a 70%");                
                campo36.getItems().addAll("00 - Tributada Integralmente","10 - Tributada com cobranca do ICMS por ST","10 - Tributada com cobranca do ICMS por ST(com partilha do ICMS entre a UF de origem e a UF de destino ou a UF definida na legislacao)","20 - Com reducao da base de calculo","30 - Isenta ou nao tributada e com cobranca do ICMS por ST","40 - Isenta","41 - Nao tributada","41 - Nao tributada(ICMSST devido para a UF de destino  nas operacoes interestaduais de produtos que tiveram retencao antecipada de ICMS por ST)","50 - Suspensao","51 - Diferimento","60 - Cobrado anteriormente por ST","70 - Com reducao de base de calculo e com cobranca do ICMS por ST","90 - Outras(com partilha do ICMS entre a UF de origem e a UF de destino ou a UF definida na legislacao)","90 - Outras","101 - Tributada com permissao de credito","102 - Tributada sem permissao de credito","103 - Isenção do ICMS para a faixa de receita bruta","201 - Tributada com permissão de crédito e com cobrança do ICMS por ST","202 - Tributada sem permissão de crédito e com cobrança do ICMS por ST","203 - Isenção do ICMS para a faixa de receita bruta e com cobrança do ICMS por ST","300 - Imune","400 - Não tributada","500 - ICMS cobrado anteriormente por ST ou por antecipação","900 - Outros");
                campo37.getItems().addAll("IPI 00 - Entrada com recuperacao de credito", "IPI 01 - Entrada tributada com aliquota zero", "IPI 02 - Entrada isenta","IPI 03 - Entrada nao-tributada", "IPI 04 - Entrada imune","IPI 05 - Entrada com suspensao","IPI 49 - Outras entradas","IPI 50 - Saida tributada","IPI 51 - Saida tributada com aliquota zero","IPI 52 - Saida isenta","IPI 53 - Saida nao-tributada","IPI 54 - Saida imune","IPI 55 - Saida com suspensao","IPI 99 - Outras saidas");
                campo39.getItems().addAll("PIS 01 - Operacao Tributavel - Base de Calculo = Valor da Operacao Aliquota Normal(Cumulativo/Nao Cumulativo)","PIS 02 - Operacao Tributavel - Base de Calculo = Valor da Operacao(Aliquota Diferenciada)","PIS 03 - Operacao Tributavel - Base de Calculo = Quantidade Vendida X Aliquota por Unidade de Produto","PIS 04 - Operacao Tributavel - Tributacao Monofasica - (Aliquota Zero)","PIS 05 - Operacao Tributavel(ST)","PIS 06 - Operacao Tributavel - Aliquota Zero","PIS 07 - Operacao Isenta da Contribuicao","PIS 08 - Operacao sem Incidencia da Contribuicao","PIS 09 - Operacao com Suspensao da Contribuicao","PIS 49 - Outras Operacoes de Saida","PIS 50 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno","PIS 51 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita Nao Tributada no Mercado Interno","PIS 52 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita de Exportacao","PIS 53 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno","PIS 54 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportacao","PIS 55 - Operacao com Direito a Credito - Vinculada a Receitas Nao-Tributadas no Mercado Interno e de Exportacao","PIS 56 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno, e de Exportacao","PIS 60 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita Tributada no Mercado Interno","PIS 61 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita Nao-Tributada no Mercado Interno","PIS 62 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita de Exportacao","PIS 63 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno","PIS 64 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas no Mercado Interno e de Exportacao","PIS 65 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Nao-Tributadas no Mercado Interno e de Exportacao","PIS 66 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno, e de Exportacao","PIS 67 - Credito Presumido - Outras Operacoes","PIS 70 - Operacao de Aquisicao sem Direito a Credito","PIS 71 - Operacao de Aquisicao com Isencao","PIS 72 - Operacao de Aquisicao com Suspencao","PIS 73 - Operacao de Aquisicao a Aliquota Zero","PIS 74 - Operacao de Aquisicao sem Incidencia da Contribuicao","PIS 75 - Operacao de Aquisicao por Substituicao Tributaria","PIS 98 - Outras Operacoes de Entrada","PIS 99 - Outras Operacoes");
                campo40.getItems().addAll("COFINS 01 - Operacao Tributavel - Base de Calculo = Valor da Operacao Aliquota Normal(Cumulativo/Nao Cumulativo)","COFINS 02 - Operacao Tributavel - Base de Calculo = Valor da Operacao(Aliquota Diferenciada)","COFINS 03 - Operacao Tributavel - Base de Calculo = Quantidade Vendida X Aliquota por Unidade de Produto","COFINS 04 - Operacao Tributavel - Tributacao Monofasica - (Aliquota Zero)","COFINS 05 - Operacao Tributavel(ST)","COFINS 06 - Operacao Tributavel - Aliquota Zero","COFINS 07 - Operacao Isenta da Contribuicao","COFINS 08 - Operacao sem Incidencia da Contribuicao","COFINS 09 - Operacao com Suspensao da Contribuicao","COFINS 49 - Outras Operacoes de Saida","COFINS 50 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita Tributada no Mercado Interno","COFINS 51 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita Nao Tributada no Mercado Interno","COFINS 52 - Operacao com Direito a Credito - Vinculada Exclusivamente a Receita de Exportacao","COFINS 53 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno","COFINS 54 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas no Mercado Interno e de Exportacao","COFINS 55 - Operacao com Direito a Credito - Vinculada a Receitas Nao-Tributadas no Mercado Interno e de Exportacao","COFINS 56 - Operacao com Direito a Credito - Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno, e de Exportacao","COFINS 60 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita Tributada no Mercado Interno","COFINS 61 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita Nao-Tributada no Mercado Interno","COFINS 62 - Credito Presumido - Operacao de Aquisicao Vinculada Exclusivamente a Receita de Exportacao","COFINS 63 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno","COFINS 64 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas no Mercado Interno e de Exportacao","COFINS 65 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Nao-Tributadas no Mercado Interno e de Exportacao","COFINS 66 - Credito Presumido - Operacao de Aquisicao Vinculada a Receitas Tributadas e Nao-Tributadas no Mercado Interno, e de Exportacao","COFINS 67 - Credito Presumido - Outras Operacoes","COFINS 70 - Operacao de Aquisicao sem Direito a Credito","COFINS 71 - Operacao de Aquisicao com Isencao","COFINS 72 - Operacao de Aquisicao com Suspencao","COFINS 73 - Operacao de Aquisicao a Aliquota Zero","COFINS 74 - Operacao de Aquisicao sem Incidencia da Contribuicao","COFINS 75 - Operacao de Aquisicao por Substituicao Tributaria","COFINS 98 - Outras Operacoes de Entrada","COFINS 99 - Outras Operacoes");
                campo41.getItems().addAll("F1 = Substituicao Tributaria","I1 = Isencao","N1 = Nao tributado","ICMS");
                
                campo2.getItems().addAll(ListaCategoria());
                campo3.getItems().addAll(ListaFabricantes());
                campo19.getItems().addAll(ListaMedida());
                
                campo9.setPrefWidth(50);
                campo10.setMinWidth(50);
                campo11.setMinWidth(50);
                campo12.setMinWidth(50);
                campo13.setMinWidth(50);
                campo14.setMinWidth(50);
                campo15.setMinWidth(50);
                campo16.setMinWidth(50);
                campo17.setMinWidth(50);
                campo18.setMinWidth(50);
                campo19.setMinWidth(115);
                campo35.setPrefWidth(150);
                campo36.setPrefWidth(150);
                campo37.setPrefWidth(150);
                campo38.setPrefWidth(150);
                campo39.setPrefWidth(150);
                campo40.setPrefWidth(150);
                campo41.setPrefWidth(150);

                impostos.setPadding(new Insets(1));
                
                painelTrib.setAlignment(FiscalTrib, Pos.TOP_LEFT);
                FiscalTrib.setStyle("-fx-background-color: #F4F4F4; -fx-padding: -10 5 5 5");
                
                painelTrib.setStyle("-fx-border-radius: 2; -fx-padding: -5 5 5 5; -fx-border-insets: -5 15 15 15; -fx-border-color: gray;");
                painelTrib.getChildren().addAll(FiscalTrib, impostos);
                
                estoque.getChildren().addAll(arg27, campo27, arg28, campo28, arg31, campo33, arg42, campo44);
                estoque.setStyle("-fx-padding: -15 15 15 15; -fx-border-insets: 0 15 15 15");
                
                btnOk.setGraphic(Login.imageViewSalvar);
                btnCancel.setGraphic(Login.imageViewCancelar);
                btnFechar.setGraphic(Login.imageViewFechar);
                btnAlterar.setGraphic(Login.imageViewOk);
                btnEditar.setGraphic(Login.imageViewEditar);
                btnExcluir.setGraphic(Login.imageViewExcluir);
                btnAdd.setGraphic(Login.imageViewAdicionar);
    
                campo4.setConverter(new StringConverter<DadosForn>() {
                @Override
                public String toString(DadosForn object) {
                    if(object!=null){
                        return object.getRazaoSocial();
                    }
                    return null;
                }
                @Override
                public DadosForn fromString(String string) {
                    return null;
                    }
                });
                
                campo2.setConverter(new StringConverter<DadosCat>() {
                @Override
                public String toString(DadosCat object) {
                    if(object!=null){
                        return object.getNome();
                    }
                    return null;
                }
                @Override
                public DadosCat fromString(String string) {
                    return null;
                    }
                });

                campo19.setConverter(new StringConverter<DadosMed>() {
                @Override
                public String toString(DadosMed object) {
                    if(object!=null){
                        return object.getNome();
                    }
                    return null;
                }
                @Override
                public DadosMed fromString(String string) {
                    return null;
                    }
                });
                
                campo3.setConverter(new StringConverter<DadosFabr>() {
                @Override
                public String toString(DadosFabr object) {
                    if(object!=null){
                        return object.getNome();
                    }
                    return null;
                }
                @Override
                public DadosFabr fromString(String string) {
                    return null;
                    }
                });
                
                
                valores.setStyle("-fx-padding: -15 17 17 17; -fx-border-insets: 0 15 15 15");
                valores.getChildren().addAll(arg23, campo23, arg24, campo24);
                valores2.setStyle("-fx-padding: -5 19 19 19");
                valores2.getChildren().addAll(arg22, campo22,arg6, campo6, arg7, campo7, arg8, campo8);
                painel8.getChildren().addAll(campo1,arg2,campo2,arg5, campo5, arg17, campo17);
                
                campo42.getItems().addAll("ID ou Cód. Barras", "Descrição");
                
                campo42.setOnAction(e -> {
                      if(campo42.getValue() == "ID ou Cód. Barras"){
                              painelPesquisa2.getChildren().clear();    
                              campo26.clear();
                              campo26.setDisable(false);
                              campo43.clear();
                              campo43.setDisable(true);
                              campo26.setVisible(true);
                              painelPesquisa2.getChildren().addAll(campo26);
                      }else if(campo42.getValue() == "Descrição"){
                              painelPesquisa2.getChildren().clear();
                              campo26.clear();
                              campo26.setDisable(true);
                              campo43.clear();
                              campo43.setDisable(false);
                              painelPesquisa2.getChildren().addAll(campo43);
                      }        
                 });

                campo44.setDisable(true);                

                tabela.setOnMouseClicked(e -> {
                    if(tabela.getSelectionModel().getSelectedItem() == null){
                                tabelaHistCompra.setItems(null);
                                tabelaHistVenda.setItems(null);
                                tabelaHistEvento.setItems(null);
                    }else{
                                tabelaHistCompra.setItems(ListaProdutoCompra());
                                tabelaHistVenda.setItems(ListaProdutoVenda());
                                tabelaHistEvento.setItems(ListaProdutoEvento());
                    }    
                });
                painelPrincipal.getChildren().addAll(painel, painel3);
                painelPesquisa.getChildren().addAll(arg26, campo42, painelPesquisa2);
                painel6.getChildren().addAll(campo3, arg4, campo4, arg19, campo19, arg18, campo18);
                painel2.setPadding(new Insets(15));
                painel3.getChildren().add(painel4);
                painel3.setAlignment(texto1, Pos.TOP_LEFT);
                texto1.setStyle("-fx-background-color: #F4F4F4");
                painel3.setStyle("-fx-border-radius: 2; -fx-border-insets: 20 15 15 15; -fx-padding: 8 11 11 11; -fx-border-color: gray;");
                painel1.setPadding(new Insets(25));
                painel1.getChildren().addAll(painel2, estoque, valores, painelTrib, valores2, painelPesquisa, tabela);
                painel5.setPadding(new Insets(15));
                btnFechar.setOnAction(e -> inicio.close());
                painel4.setAlignment(Pos.CENTER);
                Button teste = new Button("TESTE");
                painel4.getChildren().addAll(btnAdd, btnAlterar, btnCancel, btnOk, btnEditar, btnExcluir, btnFechar);
                painelHistorico.setPadding(new Insets(15));
                painelHistorico.getChildren().addAll(lblHistCompra, tabelaHistCompra, lblHistVenda, tabelaHistVenda, lblHistEvento, tabelaHistEvento);
                
                campo33.setPlaceholder(" ");
                
                btnAdd.setOnAction(e -> btnAdicionar());
                btnEditar.setOnAction(e -> btnEditar());
                btnCancel.setOnAction(e -> btnCancelar());
                btnAlterar.setOnAction(e -> {
                    try {
                        btnAlterar();
                    } catch (SQLException ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                btnCancel.setOnKeyPressed( (KeyEvent e) -> {
                    if(e.getCode() == KeyCode.ESCAPE){
                        btnCancelar();
                    }
                });
                btnExcluir.setOnAction(e -> 
                {
                    DadosProdutos dados = tabela.getSelectionModel().getSelectedItem();             
                    if(dados == null){
                        MessageBox.show("Selecione um item da lista", "Erro");
                    }else{
                        DeleteProdutos.show("Tem certeza que deseja excluir este item?", "Confirmação de Exclusão");
                    }
                });
                btnOk.setOnAction(e -> {
                    try {
                        btnOk();
                    } catch (SQLException ex) {
                        Logger.getLogger(Produto.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
                campo33.setDisable(true);
                campo32.setVisible(false);
                
                btnOk.setDisable(true);
                btnAlterar.setDisable(true);
                btnCancel.setDisable(true);
                inicio.showAndWait();
    }
    public static ObservableList<DadosProdutos> ListaProdutos(){
            ObservableList<DadosProdutos> dados = FXCollections.observableArrayList();
            ResultSet rs;
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT * FROM PRODUTOS";
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
                    String estoque = rs.getString("ESTOQUE");
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
                    coluna9.setStyle("-fx-text-fill: 'green';");
                    
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static ObservableList<DadosBarras> ListaBarras(){
            ObservableList<DadosBarras> dados = FXCollections.observableArrayList();
            ResultSet rs;
            try{
                DadosProdutos data = tabela.getSelectionModel().getSelectedItem();
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT BARRAS FROM CODIGO_BARRAS WHERE COD_PRODUTO = "+data.getID()+";";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                while(rs.next()){
                    String barras = rs.getString("BARRAS");
                    dados.add(new DadosBarras(barras));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static ObservableList<DadosBarras> setarBarras(){
            ObservableList<DadosBarras> dados = FXCollections.observableArrayList();
            ResultSet rs;
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT BARRAS FROM CODIGO_BARRAS WHERE DESCRICAO_PRODUTO = '"+campo1.getText()+"' LIMIT 1;";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                while(rs.next()){
                    String barras = rs.getString("BARRAS");
                    dados.add(new DadosBarras(barras));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static ObservableList<DadosBarras> consultaBarras(){
            ObservableList<DadosBarras> dados = FXCollections.observableArrayList();
            ResultSet rs;
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT BARRAS FROM CODIGO_BARRAS WHERE BARRAS = '"+campo5.getText()+"';";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                while(rs.next()){
                    String barras = rs.getString("BARRAS");
                    dados.add(new DadosBarras(barras));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
    public static void btnOk() throws SQLException{
        
        Connection conexao;
        data = tabela.getSelectionModel().getSelectedItem();             
        
        DadosFabr fabricante = campo3.getSelectionModel().getSelectedItem();
        DadosMed medida = campo19.getSelectionModel().getSelectedItem();
        DadosCat categoria = campo2.getSelectionModel().getSelectedItem();
        DadosForn fornecedor = campo4.getSelectionModel().getSelectedItem();
        
        try{
            conexao = Conexao.getConexao();
            
            Index index = new Index(); 
            String sql = "INSERT INTO PRODUTOS(DESCRICAO,CATEGORIA,FABRICANTE,FORNECEDOR,BARRAS,II,IPI,PIS,COFINS,ICMS,MVA,REDUTOR,REDUTOR_ST,NCM,CEST,UND_MEDIDA,SEGURO,OUTROS,VALOR_PAGO,DESC_PROMOCIONAL,QTDE_PROMOCIONAL,EST_MAXIMO,EST_MINIMO,FRETE,DESCONTO,VALIDADE,FCP,INCLUSAO,BASE_ICMS,VALOR_ICMS,BASE_ICMS_ST,VALOR_ICMS_ST,BASE_II,VALOR_II,BASE_IPI,VALOR_IPI,BASE_PIS,VALOR_PIS,BASE_COFINS,VALOR_COFINS,BASE_FCP,VALOR_FCP,VAREJO,CUSTO,MARCKUP,ORIGEM,CST_ICMS,CST_IPI,ENQUADRAMENTO,CST_PIS,CST_COFINS,TRIBUTACAO,QTDE_CX_PCT_SC_FD) VALUES('"+campo1.getText()+"','"+categoria.getNome()+"','"+fabricante.getNome()+"','"+fornecedor.getRazaoSocial()+"','"+campo5.getText()+"','"+campo9.getText().replace(",", ".")+"','"+campo10.getText().replace(",", ".")+"','"+campo11.getText().replace(",", ".")+"','"+campo12.getText().replace(",", ".")+"','"+campo13.getText().replace(",", ".")+"','"+campo14.getText().replace(",", ".")+"','"+campo15.getText().replace(",", ".")+"','"+campo16.getText().replace(",", ".")+"','"+campo17.getText().replace(".","")+"','"+campo18.getText().replace(".","")+"','"+medida.getNome()+"','"+campo20.getText().replace(",", ".")+"','"+campo21.getText().replace(",", ".")+"','"+campo22.getText().replace(",", ".")+"','"+campo23.getText().replace(",", ".")+"','"+campo24.getText().replace(",", ".")+"','"+campo27.getText().replace(",", ".")+"','"+campo28.getText().replace(",", ".")+"','"+campo30.getText().replace(",",".")+"','"+campo29.getText().replace(",",".")+"','"+campo33.getText()+"','"+campo34.getText().replace(",",".")+"','"+index.strData+"',"+campo22.getText().replace(",", ".")+" - ("+campo22.getText().replace(",", ".")+" * "+campo15.getText().replace(",", ".")+" / 100),BASE_ICMS * "+campo13.getText().replace(",", ".")+" / 100,BASE_ICMS * "+campo14.getText().replace(",", ".")+" / 100 + BASE_ICMS - ((BASE_ICMS * "+campo14.getText().replace(",", ".")+" / 100 + BASE_ICMS) * "+campo16.getText().replace(",", ".")+" / 100),BASE_ICMS_ST * "+campo13.getText().replace(",", ".")+" / 100 - VALOR_ICMS,"+campo22.getText().replace(",", ".")+",BASE_II * "+campo9.getText().replace(",", ".")+" / 100,"+campo22.getText().replace(",", ".")+",BASE_IPI * "+campo10.getText().replace(",", ".")+" / 100,"+campo22.getText().replace(",", ".")+",BASE_PIS * "+campo11.getText().replace(",", ".")+" / 100,"+campo22.getText().replace(",", ".")+",BASE_COFINS * "+campo12.getText().replace(",", ".")+" / 100,BASE_ICMS_ST,BASE_FCP * "+campo34.getText().replace(",", ".")+" / 100,'"+campo8.getText().replace(",", ".")+"',VALOR_PAGO + FRETE + OUTROS + SEGURO - DESCONTO + VALOR_II + VALOR_IPI + VALOR_ICMS_ST + VALOR_FCP,VAREJO * 100 / CUSTO - 100,'"+campo35.getValue()+"','"+campo36.getValue()+"','"+campo37.getValue()+"','"+campo38.getText()+"','"+campo39.getValue()+"','"+campo40.getValue()+"','"+campo41.getValue()+"','"+campo44.getText().replace(",",".")+"');";
            String insql = "INSERT INTO CODIGO_BARRAS(ID, BARRAS, DESCRICAO_PRODUTO) VALUES(default, '"+campo5.getText()+"', '"+campo1.getText()+"');";
            String usql = "UPDATE CODIGO_BARRAS INNER JOIN PRODUTOS SET CODIGO_BARRAS.COD_PRODUTO = PRODUTOS.ID WHERE PRODUTOS.DESCRICAO = CODIGO_BARRAS.DESCRICAO_PRODUTO;"; 
            String upsql = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Cadastro do produto "+campo1.getText()+"', NOW(),'"+Login.campo1.getText()+"')";
            PreparedStatement upstm = conexao.prepareStatement(upsql);
            PreparedStatement stm = conexao.prepareStatement(sql);
            PreparedStatement instm = conexao.prepareStatement(insql);
            PreparedStatement ustm = conexao.prepareStatement(usql);

            stm.execute(sql);
            upstm.execute(upsql);
            instm.execute(insql);
            ustm.execute(usql);
            
            tabela.getSelectionModel().selectLast();
            btnAdd.setDisable(false);
            btnEditar.setDisable(false);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnOk.setDisable(true);
            btnCancel.setDisable(true);
            btnAlterar.setDisable(true);
            btnBuscar.setDisable(false);
            tabela.setItems(ListaProdutos());
            campo1.clear();
            campo2.setValue(null);
            campo3.setValue(null);
            campo4.setValue(null);
            campo5.clear();
            campo6.clear();
            campo7.clear();
            campo8.clear();
            campo9.clear();
            campo10.clear();
            campo11.clear();
            campo12.clear();
            campo13.clear();
            campo14.clear();
            campo15.clear();
            campo16.clear();
            campo17.clear();
            campo18.clear();
            campo19.setValue(null);
            campo20.clear();
            campo21.clear();
            campo22.clear();
            campo23.clear();
            campo24.clear();
            campo25.clear();
            campo26.clear();
            campo27.clear();
            campo28.clear();
            campo29.clear();
            campo30.clear();
            campo33.clear();
            campo34.clear();
            campo35.setValue("");
            campo36.setValue("");
            campo37.setValue("");
            campo38.clear();
            campo39.setValue("");
            campo40.setValue("");
            campo41.setValue("");
            campo42.setValue("");
            campo43.clear();
            campo44.clear();
            campo1.setDisable(true);
            campo2.setDisable(true);
            campo3.setDisable(true);
            campo4.setDisable(true);
            campo5.setDisable(true);
            campo6.setDisable(true);
            campo7.setDisable(true);
            campo8.setDisable(true);
            campo9.setDisable(true);
            campo10.setDisable(true);
            campo11.setDisable(true);
            campo12.setDisable(true);
            campo13.setDisable(true);
            campo14.setDisable(true);
            campo15.setDisable(true);
            campo16.setDisable(true);
            campo17.setDisable(true);
            campo18.setDisable(true);
            campo19.setDisable(true);
            campo20.setDisable(true);
            campo21.setDisable(true);
            campo22.setDisable(true);
            campo23.setDisable(true);
            campo24.setDisable(true);
            campo25.setDisable(true);
            campo26.setDisable(false);
            campo27.setDisable(true);
            campo28.setDisable(true);
            campo29.setDisable(true);
            campo30.setDisable(true);
            campo33.setDisable(true);
            campo34.setDisable(true);
            campo35.setDisable(true);
            campo36.setDisable(true);
            campo37.setDisable(true);
            campo38.setDisable(true);
            campo39.setDisable(true);
            campo40.setDisable(true);
            campo41.setDisable(true);
            campo42.setDisable(false);
            campo43.setDisable(false);
            campo44.setDisable(true);
            tabela.setDisable(false);
            tabelaHistCompra.setItems(null);
            tabelaHistVenda.setItems(null);
            tabelaHistEvento.setItems(null);
            
            conexao.close();
            
        }catch(SQLException ex){
	    conexao = Conexao.getConexao();
            String erro = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Erro: "+ex+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"');";
            PreparedStatement stmerro = conexao.prepareStatement(erro);            
            MessageBox.show(""+ex, "Erro");
	    stmerro.execute(erro);            
            System.out.println(campo5.getText()+""+campo5.getText());
        }
    }
    public static void btnExcluir() throws SQLException{
        data = tabela.getSelectionModel().getSelectedItem();             
        Connection conexao;
        try{
            conexao = Conexao.getConexao();
            String sql = "DELETE FROM PRODUTOS WHERE ID = '"+data.getID()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            String upsql = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Remoção do produto: "+data.getDescricao()+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"')";
            PreparedStatement upstm = conexao.prepareStatement(upsql);
            
            if(data == null){
                MessageBox.show("Selecione um item da lista", "Erro");
            }else{
            upstm.execute(upsql);    
            stm.execute(sql);
            tabela.setItems(ListaProdutos());
            conexao.close();
            }
        }catch(Exception ex){
	    conexao = Conexao.getConexao();
            String erro = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Erro: "+ex+"', NOW(),'"+Login.campo1.getText()+"');";
            PreparedStatement stmerro = conexao.prepareStatement(erro);
            
            MessageBox.show(""+ex, "Erro");
            stmerro.execute(erro);
            
        }
    }
    public static void AdicionarBarras() throws SQLException{

        Connection conexao;
        try{
            conexao = Conexao.getConexao();
            String sql = "INSERT INTO CODIGO_BARRAS (ID, BARRAS, DESCRICAO_PRODUTO) VALUES(default, '"+campo5.getText()+"','"+campo1.getText()+"');";
            PreparedStatement stm = conexao.prepareStatement(sql);
            String upsql = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Adição de código de barras do produto: "+data.getDescricao()+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"')";
            PreparedStatement upstm = conexao.prepareStatement(upsql);
            upstm.execute(upsql);    
            stm.execute(sql);
            conexao.close();
        }catch(Exception ex){
	    conexao = Conexao.getConexao();
            String erro = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Erro: "+ex+"', NOW(),'"+Login.campo1.getText()+"');";
            PreparedStatement stmerro = conexao.prepareStatement(erro);
            
            MessageBox.show(""+ex, "Erro");
            stmerro.execute(erro);
            
        }
    }
    public static void ExcluirBarras() throws SQLException{

        Connection conexao;
        try{
            conexao = Conexao.getConexao();
            String sql = "DELETE FROM CODIGO_BARRAS WHERE DESCRICAO_PRODUTO = '"+campo1.getText()+"';";
            PreparedStatement stm = conexao.prepareStatement(sql);
            String upsql = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Remoção de código de barras do produto: "+data.getDescricao()+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"')";
            PreparedStatement upstm = conexao.prepareStatement(upsql);
            upstm.execute(upsql);    
            stm.execute(sql);
            conexao.close();
        }catch(Exception ex){
	    conexao = Conexao.getConexao();
            String erro = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Erro: "+ex+"', NOW(),'"+Login.campo1.getText()+"');";
            PreparedStatement stmerro = conexao.prepareStatement(erro);
            
            MessageBox.show(""+ex, "Erro");
            stmerro.execute(erro);
            
        }
    }
    public static void btnAdicionar(){
        campo1.setDisable(false);
        campo1.requestFocus();
        campo2.setDisable(false);
        campo3.setDisable(false);
        campo4.setDisable(false);
        campo5.setDisable(false);
        campo6.setDisable(true);
        campo7.setDisable(true);
        campo8.setDisable(false);
        campo9.setDisable(false);
        campo10.setDisable(false);
        campo11.setDisable(false);
        campo12.setDisable(false);
        campo13.setDisable(false);
        campo14.setDisable(false);
        campo15.setDisable(false);
        campo16.setDisable(false);
        campo17.setDisable(false);
        campo18.setDisable(false);
        campo19.setDisable(false);
        campo20.setDisable(false);
        campo21.setDisable(false);
        campo22.setDisable(false);
        campo23.setDisable(false);
        campo24.setDisable(false);
        campo25.setDisable(false);
        campo26.setDisable(true);
        campo27.setDisable(false);
        campo28.setDisable(false);
        campo29.setDisable(false);
        campo30.setDisable(false);
        campo33.setDisable(false);
        campo34.setDisable(false);
        campo35.setDisable(false);
        campo36.setDisable(false);
        campo37.setDisable(false);
        campo38.setDisable(false);
        campo39.setDisable(false);
        campo40.setDisable(false);
        campo41.setDisable(false);
        campo42.setDisable(true);
        campo43.setDisable(true);
        campo44.setDisable(false);
        tabela.setDisable(true);
        btnAdd.setDisable(true);
        btnEditar.setDisable(true);
        btnExcluir.setDisable(true);
        btnFechar.setDisable(true);
        btnOk.setDisable(false);
        btnCancel.setDisable(false);
        btnBuscar.setDisable(true);
        
        campo9.setText("0,00");
        campo10.setText("0,00");
        campo11.setText("0,00");
        campo12.setText("0,00");
        campo13.setText("0,00");
        campo14.setText("0,00");
        campo15.setText("0,00");
        campo16.setText("0,00");
        campo20.setText("0,00");
        campo21.setText("0,00");
        campo30.setText("0,00");
        campo29.setText("0,00");
        campo34.setText("0,00");
        campo27.setText("0,00");
        campo28.setText("0,00");
        campo44.setText("0,00");

        campo23.setText("0,00");
        campo24.setText("0,00");

        campo22.setText("0,00");
        campo8.setText("0,00");
    }
    public static ObservableList<DadosProdutos> Pesquisar(){
            ObservableList<DadosProdutos> dados = FXCollections.observableArrayList();
            ResultSet rs;

            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT * FROM PRODUTOS WHERE produtos.BARRAS LIKE '%"+campo26.getText()+"%' XOR produtos.ID = "+campo26.getText()+";";
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
        }catch(Exception ex){
            System.err.println(ex);
        }
        return dados;
    }
    public static void btnAlterar() throws SQLException{
        Connection conexao;
        data = tabela.getSelectionModel().getSelectedItem();             
        
        try{
            
            conexao = Conexao.getConexao();

            Index index = new Index();

            DadosForn fornecedor = campo4.getSelectionModel().getSelectedItem();  
            DadosFabr fabricante = campo3.getSelectionModel().getSelectedItem();
            DadosMed medida = campo19.getSelectionModel().getSelectedItem();
            DadosCat categoria = campo2.getSelectionModel().getSelectedItem();

            String sql = "UPDATE PRODUTOS SET DESCRICAO = '"+campo1.getText()+"', CATEGORIA = '"+categoria.getNome()+"', FABRICANTE = '"+fabricante.getNome()+"', FORNECEDOR = '"+fornecedor.getRazaoSocial()+"', BARRAS = '"+campo5.getText()+"', II = '"+campo9.getText().replace(",", ".")+"', IPI = '"+campo10.getText().replace(",", ".")+"', PIS = '"+campo11.getText().replace(",", ".")+"', COFINS = '"+campo12.getText().replace(",", ".")+"', ICMS = '"+campo13.getText().replace(",", ".")+"', MVA = '"+campo14.getText().replace(",", ".")+"', REDUTOR = '"+campo15.getText().replace(",", ".")+"', REDUTOR_ST = '"+campo16.getText().replace(",", ".")+"', NCM = '"+campo17.getText().replace(".","")+"', CEST = '"+campo18.getText().replace(".","")+"', UND_MEDIDA = '"+medida.getNome()+"', SEGURO = '"+campo20.getText().replace(",", ".")+"', OUTROS = '"+campo21.getText().replace(",", ".")+"', VALOR_PAGO = '"+campo22.getText().replace(",", ".")+"', DESC_PROMOCIONAL = '"+campo23.getText().replace(",", ".")+"', QTDE_PROMOCIONAL = '"+campo24.getText().replace(",", ".")+"', EST_MAXIMO = '"+campo27.getText().replace(",", ".")+"', EST_MINIMO = '"+campo28.getText().replace(",", ".")+"', FRETE = '"+campo30.getText().replace(",",".")+"', DESCONTO = '"+campo29.getText().replace(",",".")+"', VALIDADE = '"+campo33.getText()+"', FCP = '"+campo34.getText().replace(",",".")+"', ALTERACAO = '"+index.strData+"', BASE_ICMS = "+campo22.getText().replace(",", ".")+" - ("+campo22.getText().replace(",", ".")+" * "+campo15.getText().replace(",", ".")+" / 100), VALOR_ICMS = BASE_ICMS * "+campo13.getText().replace(",", ".")+" / 100, BASE_ICMS_ST = BASE_ICMS * "+campo14.getText().replace(",", ".")+" / 100 + BASE_ICMS - ((BASE_ICMS * "+campo14.getText().replace(",", ".")+" / 100 + BASE_ICMS) * "+campo16.getText().replace(",", ".")+" / 100), VALOR_ICMS_ST = BASE_ICMS_ST * "+campo13.getText().replace(",", ".")+" / 100 - VALOR_ICMS, BASE_II = "+campo22.getText().replace(",", ".")+", VALOR_II = BASE_II * "+campo9.getText().replace(",", ".")+" / 100, BASE_IPI = "+campo22.getText().replace(",", ".")+", VALOR_IPI = BASE_IPI * "+campo10.getText().replace(",", ".")+" / 100, BASE_PIS = "+campo22.getText().replace(",", ".")+", VALOR_PIS = BASE_PIS * "+campo11.getText().replace(",", ".")+" / 100, BASE_COFINS = "+campo22.getText().replace(",", ".")+", VALOR_COFINS = BASE_COFINS * "+campo12.getText().replace(",", ".")+" / 100, BASE_FCP = BASE_ICMS_ST, VALOR_FCP = BASE_FCP * "+campo34.getText().replace(",", ".")+" / 100, VAREJO = '"+campo8.getText().replace(",", ".")+"', CUSTO = VALOR_PAGO + FRETE + OUTROS + SEGURO - DESCONTO + VALOR_II + VALOR_IPI + VALOR_ICMS_ST + VALOR_FCP, MARCKUP = VAREJO * 100 / CUSTO - 100, ORIGEM = '"+campo35.getValue()+"', CST_ICMS = '"+campo36.getValue()+"', CST_IPI = '"+campo37.getValue()+"', ENQUADRAMENTO = '"+campo38.getText()+"', CST_PIS = '"+campo39.getValue()+"', CST_COFINS = '"+campo40.getValue()+"',TRIBUTACAO = '"+campo41.getValue()+"', QTDE_CX_PCT_SC_FD = '"+campo44.getText().replace(",", ".")+"' WHERE DESCRICAO = '"+data.getDescricao()+"';";
            String upsql = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Alteração do produto: "+data.getDescricao()+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"')";

            PreparedStatement stm = conexao.prepareStatement(sql);
            PreparedStatement upstm = conexao.prepareStatement(upsql);


            stm.execute(sql);
            upstm.execute(upsql);
            tabelaHistCompra.setItems(null);
            tabelaHistVenda.setItems(null);
            tabelaHistEvento.setItems(null);
            btnAdd.setDisable(false);
            btnEditar.setDisable(false);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnOk.setDisable(true);
            btnCancel.setDisable(true);
            btnAlterar.setDisable(true);
            tabela.setItems(ListaProdutos());
            campo1.clear();
            campo2.setValue(null);
            campo3.setValue(null);
            campo4.setValue(null);
            campo5.clear();
            campo6.clear();
            campo7.clear();
            campo8.clear();
            campo9.clear();
            campo10.clear();
            campo11.clear();
            campo12.clear();
            campo13.clear();
            campo14.clear();
            campo15.clear();
            campo16.clear();
            campo17.clear();
            campo18.clear();
            campo19.setValue(null);
            campo20.clear();
            campo21.clear();
            campo22.clear();
            campo23.clear();
            campo24.clear();
            campo25.clear();
            campo26.clear();
            campo27.clear();
            campo28.clear();
            campo29.clear();
            campo30.clear();
            campo33.clear();
            campo34.clear();
            campo35.setValue("");
            campo36.setValue("");
            campo37.setValue("");
            campo38.clear();
            campo39.setValue("");
            campo40.setValue("");
            campo41.setValue("");
            campo42.setValue("");
            campo43.clear();
            campo44.clear();
            campo1.setDisable(true);
            campo2.setDisable(true);
            campo3.setDisable(true);
            campo4.setDisable(true);
            campo5.setDisable(true);
            campo6.setDisable(true);
            campo7.setDisable(true);
            campo8.setDisable(true);
            campo9.setDisable(true);
            campo10.setDisable(true);
            campo11.setDisable(true);
            campo12.setDisable(true);
            campo13.setDisable(true);
            campo14.setDisable(true);
            campo15.setDisable(true);
            campo16.setDisable(true);
            campo17.setDisable(true);
            campo18.setDisable(true);
            campo19.setDisable(true);
            campo20.setDisable(true);
            campo21.setDisable(true);
            campo22.setDisable(true);
            campo23.setDisable(true);
            campo24.setDisable(true);
            campo25.setDisable(true);
            campo26.setDisable(false);
            campo27.setDisable(true);
            campo28.setDisable(true);
            campo29.setDisable(true);
            campo30.setDisable(true);
            campo33.setDisable(true);
            campo34.setDisable(true);
            campo35.setDisable(true);
            campo36.setDisable(true);
            campo37.setDisable(true);
            campo38.setDisable(true);
            campo39.setDisable(true);
            campo40.setDisable(true);
            campo41.setDisable(true);
            campo42.setDisable(false);
            campo43.setDisable(false);
            campo44.setDisable(true);
            btnBuscar.setDisable(false);
            tabela.setDisable(false);
            conexao.close();

            }catch(Exception ex){
                conexao = Conexao.getConexao();
                String erro = "INSERT INTO HISTORICO(ID, DESCRICAO, DATA_EVENTO, USUARIO) VALUES(default, 'Erro: "+ex+", Código: "+data.getID()+"', NOW(),'"+Login.campo1.getText()+"');";
                PreparedStatement stmerro = conexao.prepareStatement(erro);
                MessageBox.show(""+ex, "Erro");
                stmerro.execute(erro);
            }
    }
    public static void btnEditar(){
       
        DadosProdutos data = tabela.getSelectionModel().getSelectedItem();  
        DadosForn fornecedor = new DadosForn(String.valueOf(data.getFornecedor()));
        
        DadosFabr fabricante = new DadosFabr(String.valueOf(data.getFabricante()));
        DadosMed medida = new DadosMed(String.valueOf(data.getUnd_medida()));
        DadosCat categoria = new DadosCat(String.valueOf(data.getCategoria()));
        DadosBarras barras = new DadosBarras(String.valueOf(data.getBarras()));
        
        DadosMed undMedida = campo19.getSelectionModel().getSelectedItem();
        
        if(data == null){
                MessageBox.show("Selecione um item da lista", "Erro");
        }
        else{
            campo1.setDisable(false);
            campo2.setDisable(false);
            campo3.setDisable(false);
            campo4.setDisable(false);
            campo5.setDisable(false);
            campo6.setDisable(true);
            campo7.setDisable(true);
            campo8.setDisable(false);
            campo9.setDisable(false);
            campo10.setDisable(false);
            campo11.setDisable(false);
            campo12.setDisable(false);
            campo13.setDisable(false);
            campo14.setDisable(false);
            campo15.setDisable(false);
            campo16.setDisable(false);
            campo17.setDisable(false);
            campo18.setDisable(false);
            campo19.setDisable(false);
            campo20.setDisable(false);
            campo21.setDisable(false);
            campo22.setDisable(false);
            campo23.setDisable(false);
            campo24.setDisable(false);
            campo25.setDisable(false);
            campo26.setDisable(true);
            campo27.setDisable(false);
            campo28.setDisable(false);
            campo29.setDisable(false);
            campo30.setDisable(false);
            campo33.setDisable(false);
            campo34.setDisable(false);
            campo35.setDisable(false);
            campo36.setDisable(false);
            campo37.setDisable(false);
            campo38.setDisable(false);
            campo39.setDisable(false);
            campo40.setDisable(false);        
            campo41.setDisable(false);        
            campo43.setDisable(true);        
            campo44.setDisable(false);
            campo42.setDisable(true);        
            tabela.setDisable(true);
            btnAdd.setDisable(true);
            btnEditar.setDisable(true);
            btnExcluir.setDisable(true);
            btnFechar.setDisable(true);
            btnOk.setDisable(true);
            btnCancel.setDisable(false);
            btnAlterar.setDisable(false);
            btnBuscar.setDisable(true);
            campo1.setText(String.valueOf(data.getDescricao()));
            campo2.setValue(categoria);
            campo3.setValue(fabricante);
            campo4.setValue(fornecedor);
            campo5.setText(String.valueOf(barras));
            campo6.setText(data.getCusto().replace("R$", "").replace(".",","));
            campo7.setText(data.getMarckup().replace("%", "").replace(".",","));
            campo8.setText(data.getVarejo().replace("R$", "").replace(".",","));
            campo9.setText(String.valueOf(df.format(data.getII())));
            campo10.setText(String.valueOf(df.format(data.getIPI())));
            campo11.setText(String.valueOf(df.format(data.getPIS())));
            campo12.setText(String.valueOf(df.format(data.getCOFINS())));
            campo13.setText(String.valueOf(df.format(data.getICMS())));
            campo14.setText(String.valueOf(df.format(data.getMVA())));
            campo15.setText(String.valueOf(df.format(data.getRedutor())));
            campo16.setText(String.valueOf(df.format(data.getRedutor_ST())));
            campo17.setText(String.valueOf(data.getNcm()));
            campo18.setText(String.valueOf(data.getCest()));
            campo19.setValue(medida);
            campo20.setText(String.valueOf(df.format(data.getSeguro())));
            campo21.setText(String.valueOf(df.format(data.getOutros())));
            campo22.setText(String.valueOf(df.format(data.getValor_pago())));
            campo23.setText(String.valueOf(df.format(data.getDesc_promocional())));
            campo24.setText(String.valueOf(df.format(data.getQtde_promocional())));
            campo27.setText(String.valueOf(df.format(data.getEst_maximo())));
            campo28.setText(String.valueOf(df.format(data.getEst_minimo())));
            campo29.setText(String.valueOf(df.format(data.getDesconto())));
            campo30.setText(String.valueOf(df.format(data.getFrete())));
            campo33.setText(String.valueOf(data.getValidade()));
            campo34.setText(String.valueOf(data.getFCP()));
            campo36.setValue(String.valueOf(data.getCST_ICMS()));
            campo35.setValue(String.valueOf(data.getOrigem()));
            campo37.setValue(String.valueOf(data.getCST_IPI()));
            campo38.setText(String.valueOf(data.getCodEnquadramento()));
            campo39.setValue(String.valueOf(data.getCST_PIS()));
            campo40.setValue(String.valueOf(data.getCST_COFINS()));
            campo41.setValue(String.valueOf(data.getTributacao()));
            campo44.setText(String.valueOf(df.format(data.getQTDE_CX_PCT_SC_FD())));
            tabelaHistCompra.setItems(ListaProdutoCompra());
            tabelaHistVenda.setItems(ListaProdutoVenda());
            tabelaHistEvento.setItems(ListaProdutoEvento());
        }
    }
    public static void btnCancelar(){
       	campo1.clear();
        campo2.setValue(null);
        campo3.setValue(null);
        campo4.setValue(null);
        campo5.clear();
        campo6.clear();
        campo7.clear();
        campo8.clear();
        campo9.clear();
        campo10.clear();
        campo11.clear();
        campo12.clear();
        campo13.clear();
        campo14.clear();
        campo15.clear();
        campo16.clear();
        campo17.clear();
        campo18.clear();
        campo19.setValue(null);
        campo20.clear();
        campo21.clear();
        campo22.clear();
        campo23.clear();
        campo24.clear();
        campo25.clear();
        campo26.clear();
        campo27.clear();
        campo28.clear();
        campo29.clear();
        campo30.clear();
        campo33.clear();
        campo34.clear();
        campo35.setValue("");
        campo36.setValue("");
        campo37.setValue("");
        campo38.clear();
        campo39.setValue("");
        campo40.setValue("");
        campo41.setValue("");
        campo42.setValue("");
        campo43.clear();
        campo44.clear();
        campo1.setDisable(true);
        campo2.setDisable(true);
        campo3.setDisable(true);
        campo4.setDisable(true);
        campo5.setDisable(true);
        campo6.setDisable(true);
        campo7.setDisable(true);
        campo8.setDisable(true);
        campo9.setDisable(true);
        campo10.setDisable(true);
        campo11.setDisable(true);
        campo12.setDisable(true);
        campo13.setDisable(true);
        campo14.setDisable(true);
        campo15.setDisable(true);
        campo16.setDisable(true);
        campo17.setDisable(true);
        campo18.setDisable(true);
        campo19.setDisable(true);
        campo20.setDisable(true);
        campo21.setDisable(true);
        campo22.setDisable(true);
        campo23.setDisable(true);
        campo24.setDisable(true);
        campo25.setDisable(true);
        campo26.setDisable(false);
        campo27.setDisable(true);
        campo28.setDisable(true);
        campo29.setDisable(true);
        campo30.setDisable(true);
        campo33.setDisable(true);
        campo34.setDisable(true);
        campo35.setDisable(true);
        campo36.setDisable(true);
        campo37.setDisable(true);
        campo38.setDisable(true);
        campo39.setDisable(true);
        campo40.setDisable(true);
        campo41.setDisable(true);
        campo42.setDisable(false);
        campo43.setDisable(false);
        campo44.setDisable(true);
        tabela.setDisable(false);
        btnAdd.setDisable(false);
        btnEditar.setDisable(false);
        btnExcluir.setDisable(false);
        btnFechar.setDisable(false);
        btnOk.setDisable(true);
        btnCancel.setDisable(true);
        btnAlterar.setDisable(true);
        btnBuscar.setDisable(false);        
        tabelaHistCompra.setItems(null);
        tabelaHistVenda.setItems(null);
        tabelaHistEvento.setItems(null);
    }

    private static ObservableList<DadosProdutos> BuscarDescricao() {
        ObservableList<DadosProdutos> dadosDescr = FXCollections.observableArrayList();
            ResultSet rs;
            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT * FROM PRODUTOS WHERE produtos.DESCRICAO LIKE '%"+campo43.getText()+"%';";
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
                    
                    dadosDescr.add(new DadosProdutos(id, descricao, categoria, barras, ncm, cest, fabricante, fornecedor, und_medida, String.format("%.02f", estoque).replace(".",","), est_minimo, est_maximo, valor_pago, desc_promocional, qtde_promocional, ii, ipi, pis, cofins, icms, mva, redutor, redutor_st, seguro, outros, desconto, frete, validade, "R$"+String.format("%.02f", custo).replace(".",","), String.format("%.02f", marckup)+"%".replace(".",","), "R$"+String.format("%.02f", varejo).replace(".",","), inclusao, alteracao, FCP, CST_ICMS, Origem, CST_IPI, CodEnquadramento, CST_PIS, CST_COFINS, Tributacao, QTDE_CX_PCT_SC_FD));
                }
              
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dadosDescr;
    }
    public static ObservableList<DadosForn> ListaFornecedores(){
            ObservableList<DadosForn> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT RAZAOSOCIAL FROM FORNECEDOR ORDER BY RAZAOSOCIAL;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){
                    String razaoSocial = rs.getString("RAZAOSOCIAL");    
                    dados.add(new DadosForn(razaoSocial));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
    public static ObservableList<DadosFabr> ListaFabricantes(){
            ObservableList<DadosFabr> dados = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT NOME FROM FABRICANTE ORDER BY NOME;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){
                    String nome = rs.getString("NOME");    
                    dados.add(new DadosFabr(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dados;
        }
    
    public static ObservableList<DadosCat> ListaCategoria(){
            ObservableList<DadosCat> dado = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT NOME FROM CATEGORIA ORDER BY NOME;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){
                    String nome = rs.getString("NOME");
                    dado.add(new DadosCat(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dado;
        }
    
    public static ObservableList<DadosMed> ListaMedida(){
            ObservableList<DadosMed> dado = FXCollections.observableArrayList();
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String Consulta = "SELECT SIGLA FROM UNIDADE_MEDIDA ORDER BY SIGLA;";
                PreparedStatement st = conexao.prepareStatement(Consulta);
                rs = st.executeQuery(Consulta);
                
                while(rs.next()){
                    String nome = rs.getString("SIGLA");    
                    dado.add(new DadosMed(nome));
                }
            }catch(Exception err){
                System.err.println(err);
            }
            return dado;
        }
    
    public static ObservableList<DadosMed>QtdeUnitaria(){
            String sigla;
            ObservableList<DadosMed> dados = FXCollections.observableArrayList();
            try{
                DadosMed undMedida = campo19.getSelectionModel().getSelectedItem();
                Connection conn = Conexao.getConexao();
                String sql = "SELECT sigla as sigla FROM unidade_medida WHERE sigla = '"+undMedida.getNome()+"' AND QTDE_UNITARIA = 'true';";
                PreparedStatement st = conn.prepareStatement(sql);
                ResultSet rs = st.executeQuery(sql);
                while(rs.next()){
                    sigla = rs.getString("sigla");
                    dados.add(new DadosMed(sigla));
                }
            }catch(Exception ex){
                System.out.println(ex);
            }
            return dados;
    }
    
    public static ObservableList<DadosHistoricoCompra> ListaProdutoCompra(){
            ObservableList<DadosHistoricoCompra> dados = FXCollections.observableArrayList();
            ResultSet rs;
	    DadosProdutos data = tabela.getSelectionModel().getSelectedItem();  

            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT NR_NOTA AS NR_NF, FORNECEDOR AS DESCRICAO, CUSTO AS CUSTO, QTDE AS QTDE, date_format(DATA_ENTRADA, '%d/%m/%Y %H:%i:%s') AS DATA_ENTRADA, USUARIO AS USUARIO FROM ENTRADA WHERE CODIGO_ITEM = "+data.getID()+" ORDER BY DATA_ENTRADA;";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                
                while(rs.next()){
                    int NrNF = rs.getInt("NR_NF");
                    String descricao = rs.getString("DESCRICAO");
                    double custo = rs.getDouble("CUSTO");
                    double qtde = rs.getDouble("QTDE");
                    String dataEntrada = rs.getString("DATA_ENTRADA");
                    String usuario = rs.getString("USUARIO");
                    
                    dados.add(new DadosHistoricoCompra(NrNF, descricao, "R$"+String.format("%.02f", custo).replace(".",","), String.format("%.02f", qtde).replace(".",","), dataEntrada, usuario));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }

public static ObservableList<DadosHistoricoVenda> ListaProdutoVenda(){
            ObservableList<DadosHistoricoVenda> dados = FXCollections.observableArrayList();
            ResultSet rs;
	    DadosProdutos data = tabela.getSelectionModel().getSelectedItem();  

            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT PROTOCOLO AS PROTOCOLO, VAREJO AS VENDA, QTDE AS QTDE, date_format(DATA_HORA, '%d/%m/%Y %H:%i:%s') AS DATA_HORA, USUARIO AS USUARIO, CLIENTE AS CLIENTE FROM CAIXA WHERE CODIGO = "+data.getID()+" ORDER BY DATA_HORA;";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                while(rs.next()){
                    String protocolo = rs.getString("PROTOCOLO");
                    double venda = rs.getDouble("VENDA");
                    double qtde = rs.getDouble("QTDE");
                    String dataHora = rs.getString("DATA_HORA");
                    String usuario = rs.getString("USUARIO");
                    String cliente = rs.getString("CLIENTE");
                    
                    dados.add(new DadosHistoricoVenda(protocolo, "R$"+String.format("%.02f",venda).replace(".",","), "-"+String.format("%.02f",qtde).replace(".",","), dataHora, usuario, cliente));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }

public static ObservableList<DadosHistoricoEvento> ListaProdutoEvento(){
            ObservableList<DadosHistoricoEvento> dados = FXCollections.observableArrayList();
            ResultSet rs;
	    DadosProdutos data = tabela.getSelectionModel().getSelectedItem();  

            try{
                Connection conexao = Conexao.getConexao();
                String consulta = "SELECT DESCRICAO AS DESCRICAO, date_format(DATA_EVENTO, '%d/%m/%Y %H:%i:%s') AS DATA_EVENTO, USUARIO AS USUARIO FROM HISTORICO WHERE DESCRICAO LIKE '%"+data.getDescricao()+"%' ORDER BY DATA_EVENTO;";
                PreparedStatement stm = conexao.prepareStatement(consulta);
                rs = stm.executeQuery(consulta);
                while(rs.next()){
                    String descricao = rs.getString("DESCRICAO");
                    String dataEvento = rs.getString("DATA_EVENTO");
                    String usuario = rs.getString("USUARIO");
                    
                    dados.add(new DadosHistoricoEvento(descricao, dataEvento, usuario));
                }
            }catch(Exception ex){
                System.err.println(ex);
            }
            return dados;
    }
}
