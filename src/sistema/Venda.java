package sistema;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.web.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.util.Duration;
import javax.swing.Timer;

public class Venda{
    
		public static DadosProdutos dados;
		public static VBox painelPrincipal;
                public static HBox painelTela;
		public static VBox painelBotoesCaixa;
                public static HBox painelBuscar;
                public static HBox painelTotalizadores;
                public static HBox barra;
                public static HBox barraStatusCaixa;
		public static Scene cenario;
		public static BorderPane tela;                
                public static Label lblBuscarProduto;
                public static Label lblQtdeProduto;
                public static Label lblValorTotal;
                public static Label lblValorDesconto;
                public static Label lblValorTotalDesconto;
                public static Label lblPorcentagemDesconto;
                public static Label lblTotal;
                public static Label lblOperador;
                public static DateFormat data;
                public static Date d;
                public static String strData;
                public static Label dataD;
                public static Label lblNomeOperador;
                public static Label lblDataVenda;
		public static Label mensagem;
                public static SimpleDateFormat formatador = new SimpleDateFormat("hh:mm:ss");
                public static TextField txtBuscarProduto;
                public static TextField txtQtdeProduto;
		public static TextField txtCFOP;
		public static TextField txtChaveNFeAdd;
		public static TextField txtPagtoFatura;
		public static TextField txtQtdeTotal;
		public static TextField txtEspecie;
		public static TextField txtMarca;
		public static TextField txtNumeracao;
		public static TextField txtPesoBruto;
		public static TextField txtPesoLiquido;
                public static TextField txtOperador;
		public static TextField txtInfoComplementar;
                public static ComboBox txtModalFrete;
                public static Button btnFecharVenda;
                public static Button btnCliente;
                public static Button btnCarga;
                public static Button btnSangria;
                public static Button btnFecharCaixa;
                public static Button btnBuscarVenda;
                public static Button btnCancelarVenda;
                public static Button btnCancelarItem;
                public static Button btnAbrirCaixa;
                public static Button btnDesconto;
                public static Button btnReimpressao;
                public static Button btnCancelarProtocolo;
                public static Button btnCancelarProtocoloAnterior;
                public static Button btnFechar;
                public static Label lblHorario;
                public static Label lblTempo;
                public static Label lblStatusCaixa;
                public static int hh,mm,ss; 
                public static Calendar hora;
                public static DecimalFormat formato; 
                public static TableView tabelaCaixa;
                public static TableView tabela;                
                public static TableColumn<DadosProdutos, Integer> colunaID;
                public static TableColumn<DadosProdutos, String> colunaDescricao;
                public static TableColumn<DadosProdutos, String> colunaBarras;
                public static TableColumn<DadosProdutos, Double> colunaVarejo;
                public static TableColumn<DadosCaixa, Integer> colunaIDCaixa;
                public static TableColumn<DadosCaixa, String> colunaDescricaoCaixa;
                public static TableColumn<DadosCaixa, String> colunaFabricanteCaixa;
                public static TableColumn<DadosCaixa, String> colunaQtdeCaixa;
                public static TableColumn<DadosCaixa, String> colunaVarejoCaixa;
                public static TableColumn<DadosCaixa, String> colunaSubtotalCaixa;
                public static Stage inicio;
                
		public static void show(String msg, String titulo){
                    
                                painelPrincipal = new VBox(15);
                                painelTela = new HBox(5);
                                painelBotoesCaixa = new VBox(5);
                                painelBuscar = new HBox(5);
                                painelTotalizadores = new HBox(5);
                                barra = new HBox(5);
                                barraStatusCaixa = new HBox(5);
                                lblStatusCaixa = new Label();
                                tela = new BorderPane();
                                cenario = new Scene(tela, 1030, 650);
                                                                
                                lblBuscarProduto = new Label("Buscar: ");
                                lblQtdeProduto = new Label("Qtde: ");
                                lblValorTotal = new Label();
                                lblValorTotalDesconto = new Label();
                                lblValorDesconto = new Label();
                                lblPorcentagemDesconto = new Label();
                                lblTotal = new Label("Total: ");
                                lblHorario = new Label();
                                lblOperador = new Label("   Operador: ");
                                lblTempo = new Label("   Tempo: ");
                                data = new SimpleDateFormat("dd/MM/yyyy");
                                d = new Date();
                                strData = data.format(d);
                                dataD = new Label(strData);
                                lblNomeOperador = new Label(String.valueOf(Login.campo1.getText()));
                                lblDataVenda = new Label("Data PDV: ");
                                mensagem = new Label();

                                txtBuscarProduto = new TextField();
                                txtQtdeProduto = new TextField();

                                txtCFOP = new TextField();
                                txtChaveNFeAdd = new TextField();
                                txtPagtoFatura = new TextField();
                                txtQtdeTotal = new TextField();
                                txtEspecie = new TextField();
                                txtMarca = new TextField();
                                txtNumeracao = new TextField();
                                txtPesoBruto = new TextField();
                                txtPesoLiquido = new TextField();
                                txtOperador = new TextField();
                                txtInfoComplementar = new TextField();

                                txtModalFrete = new ComboBox();

                                btnFecharVenda = new Button("Fechar Venda - F1");
                                btnCliente = new Button("Clientes - F2");
                                btnCarga = new Button("Carga - F3");
                                btnSangria = new Button("Sangria - F4");
                                btnFecharCaixa = new Button("Fechar Caixa - F5");
                                btnBuscarVenda = new Button("Buscar Pedido - F6");
                                btnCancelarVenda = new Button("Cancelar Venda - F7");
                                btnCancelarItem = new Button("Cancelar Item - F11");
                                btnAbrirCaixa = new Button("Abrir Caixa - F12");
                                btnDesconto = new Button("Desconto - F8");
                                btnReimpressao = new Button("Reinpressão - F9");
                                btnCancelarProtocolo = new Button("Canc_elar Protocolo");
                                btnCancelarProtocoloAnterior = new Button("Cance_lar Anteriores");
                                btnFechar = new Button("Sair - F10");
                                tabelaCaixa = new TableView();
                                tabela = new TableView();                
                                inicio = new Stage();
                                
                                inicio.setMaximized(true);
				inicio.setScene(cenario);
                                txtBuscarProduto.requestFocus();
                                inicio.initModality(Modality.WINDOW_MODAL);
                                inicio.setTitle(titulo);
                                mensagem.setText(msg);
                                lblStatusCaixa.setFont(new Font(25));
                                lblStatusCaixa.setTextFill(Color.WHITE);
                                lblStatusCaixa.setStyle("-fx-font-weight: bold");
                                int numero = Integer.parseInt(String.valueOf(acessoPDV()).replace("[","").replace("]",""));
                                lblStatusCaixa.setText("PDV nº "+String.format("%05d", numero)+" - CAIXA ABERTO");
                                barraStatusCaixa.setAlignment(Pos.CENTER);
                                colunaID = new TableColumn<DadosProdutos, Integer>("ID");
                                colunaID.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Integer>("ID"));
                                colunaDescricao = new TableColumn<DadosProdutos, String>("Descrição");
                                colunaDescricao.setMinWidth(300);
                                colunaDescricao.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Descricao"));
                                colunaBarras = new TableColumn<DadosProdutos, String>("Cód. Barras");
                                colunaBarras.setMinWidth(180);
                                colunaBarras.setCellValueFactory(new PropertyValueFactory<DadosProdutos, String>("Barras"));
                                colunaVarejo = new TableColumn<DadosProdutos, Double>("varejo");
                                colunaVarejo.setCellValueFactory(new PropertyValueFactory<DadosProdutos, Double>("Varejo"));
                                colunaIDCaixa = new TableColumn<DadosCaixa, Integer>("ID");
                                colunaIDCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, Integer>("ID"));
                                colunaDescricaoCaixa = new TableColumn<DadosCaixa, String>("Descrição");
                                colunaDescricaoCaixa.setMinWidth(300);
                                colunaDescricaoCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, String>("Descricao"));
                                colunaFabricanteCaixa = new TableColumn<DadosCaixa, String>("Fabricante");
                                colunaFabricanteCaixa.setMinWidth(110);
                                colunaFabricanteCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, String>("fabricante"));
                                colunaQtdeCaixa = new TableColumn<DadosCaixa, String>("Qtde");
                                colunaQtdeCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, String>("Qtde"));
                                colunaVarejoCaixa = new TableColumn<DadosCaixa, String>("Varejo");
                                colunaVarejoCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, String>("Varejo"));
                                colunaVarejoCaixa.setMinWidth(120);
                                colunaSubtotalCaixa = new TableColumn<DadosCaixa, String>("SubTotal");
                                colunaSubtotalCaixa.setCellValueFactory(new PropertyValueFactory<DadosCaixa, String>("Subtotal"));
                                colunaSubtotalCaixa.setMinWidth(146);
                                
                                txtQtdeProduto.setDisable(true);
                                
                                tela.setCenter(painelPrincipal);
                                tela.setBottom(barra);
                                tela.setTop(barraStatusCaixa);
                                
                                btnFechar.setOnAction(e -> btnFechar());
                                
                                btnCancelarVenda.setOnAction(e -> {
                                    DeleteVendaCaixa.show("Tem certeza que deseja Cancelar a venda?","Confirmação de evento");
                                        
                                });
                                barra.setStyle("-fx-border-color: #D3D3D3; -fx-border-solid: 1; -fx-border-padding: -20 5 5 5;");
                                barraStatusCaixa.setStyle("-fx-border-color: #D3D3D3; -fx-border-solid: 1; -fx-border-padding: -20 5 5 5;-fx-background-color: green;");
                                barra.setAlignment(Pos.BOTTOM_LEFT);
                                tabelaCaixa.setStyle(".label-header{ -fx-alignment: center-right; }");
                                colunaIDCaixa.setStyle("-fx-alignment: center-right; -fx-font-size: 15px; -fx-font-family: arial;");
                                colunaDescricaoCaixa.setStyle("-fx-alignment: center-left; -fx-font-size: 15px; -fx-font-family: arial;");
                                colunaQtdeCaixa.setStyle("-fx-alignment: center-right; -fx-font-size: 15px; -fx-font-family: arial;");
                                colunaFabricanteCaixa.setStyle("-fx-alignment: center-left; -fx-font-size: 15px; -fx-font-family: arial;");
                                colunaVarejoCaixa.setStyle("-fx-alignment: center-right; -fx-font-size: 15px; -fx-font-family: arial;");
                                colunaSubtotalCaixa.setStyle("-fx-alignment: center-right; -fx-font-size: 15px; -fx-font-family: arial;");
                                lblValorTotal.setStyle("-fx-font-family: arial;");
                                lblValorTotalDesconto.setStyle("-fx-font-family: arial;");
                                lblHorario.setStyle("-fx-font-weight: bold;");
                                lblTempo.setFont(new Font(15));
                                
                                btnAbrirCaixa.setDisable(true);
                                
                                btnCancelarItem.setOnAction(e -> {
                                    
                                        DadosCaixa data = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();

                                        if(data == null){
                                            MessageBox.show("Selecione um item da lista", "Erro");
                                        }else{
                                            DeleteCaixa.show("Tem certeza que deseja Cancelar este item?","Confirmação de evento");
                                        }
                                        
                                });
                                btnCancelarProtocoloAnterior.setOnAction(e -> {
                                    try {
                                        CancelarProtocoloAnterior.show("Buscar protocolo", "Selecione um protocolo para Cancelar");
                                    } catch (Exception ex) {
                                        Logger.getLogger(Venda.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                });
                                txtBuscarProduto.setOnKeyPressed(e -> {
                                    if(e.getCode() == KeyCode.ENTER){
                                            
                                            if(BuscarCodBarras().isEmpty() == false){
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabela, painelBotoesCaixa);
                                                tabela.setItems(BuscarCodBarras());
                                                tabela.getSelectionModel().selectFirst();
                                                txtQtdeProduto.setText("1");
                                     
                                                consultarQtde();
                                                txtQtdeProduto.setDisable(false);
                                                txtQtdeProduto.requestFocus();
                                                txtBuscarProduto.clear();
                                                txtQtdeProduto.clear();
                                                txtBuscarProduto.requestFocus();
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                                tabelaCaixa.setItems(ListaCaixa());
                                                
                                            }else if(BuscarID().isEmpty() == false){
                                                txtQtdeProduto.setDisable(false);
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabela, painelBotoesCaixa);
                                                tabela.setItems(BuscarID());
                                                tabela.getSelectionModel().selectFirst();
                                                txtQtdeProduto.setText("1");
                                                
                                                consultarQtde();
                                                txtQtdeProduto.requestFocus();
                                                txtBuscarProduto.clear();
                                                txtQtdeProduto.clear();
                                                txtBuscarProduto.requestFocus();
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                                tabelaCaixa.setItems(ListaCaixa());
                                                
                                            }else if(BuscarDescricao().isEmpty() == false){
                                                txtQtdeProduto.setDisable(false);
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabela, painelBotoesCaixa);
                                                tabela.setItems(BuscarDescricao());
                                                txtQtdeProduto.setText("1");
                                                txtQtdeProduto.requestFocus();
                                                tabela.getSelectionModel().selectFirst();
                                                
                                            }else if(BuscarDescricao().isEmpty() == true && BuscarCodBarras().isEmpty() == true && BuscarID().isEmpty() == true){
                                                MessageBox.show("Item não encontrado", "Erro");
                                            }else{
                                                txtQtdeProduto.setDisable(true);
                                                painelTela.getChildren().clear();
                                                painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                                tabelaCaixa.setItems(ListaCaixa());
                                                
                                            }
                                        }else if(e.getCode() == KeyCode.ESCAPE){
                                        
                                            txtBuscarProduto.clear();
                                            txtBuscarProduto.requestFocus();
                                            painelTela.getChildren().clear();
                                            painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                            tabelaCaixa.setItems(ListaCaixa());
                                            
                                        }else if(e.getCode() == KeyCode.F1){
                                            double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                                            lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));

                                            if(total == 0.00){
                                                MessageBox.show("Não há vendas a serem fechadas", "Alerta");
                                            }else{
                                                FecharVenda.show("Total a Pagar: ","Fechar Venda");
                                                lblValorTotalDesconto.setVisible(false);
                                                lblPorcentagemDesconto.setVisible(false);
                                                lblValorTotalDesconto.setText(null);
                                                lblPorcentagemDesconto.setText(null);
                                                tabelaCaixa.setItems(ListaCaixa());
                                            }
                                        }else if(e.getCode() == KeyCode.F10){
                                            btnFechar.requestFocus();
                                            FecharJanelaCaixa.show("Existe um protocolo em aberto\n\nDeseja cancelar a venda?","Confirmação de evento");
                                        
                                        }else if(e.getCode() == KeyCode.F5){
                                        
                                            FecharCaixa.show("Valor em caixa","Fechamento de caixa");
                                            
                                        }else if(e.getCode() == KeyCode.F9){
                                            Impressao impressao = new Impressao();
                                            impressao.imprime("Teste");
                                            
                                        }else if(e.getCode() == KeyCode.F11){
                                        
                                            DadosCaixa data = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();

                                            if(data == null){
                                                MessageBox.show("Selecione um item da lista", "Erro");
                                            }else{
                                                DeleteCaixa.show("Tem certeza que deseja Cancelar este item?","Confirmação de evento");
                                            }
                                        }else if(e.getCode() == KeyCode.F7){
                                            DeleteVendaCaixa.show("Tem certeza que deseja Cancelar a venda?","Confirmação de evento");
                                        }else if(e.getCode() == KeyCode.F8){
                                            if(tabelaCaixa.getSelectionModel().getSelectedItem() == null){
                                                Desconto.show("Desconto(%)","Desconto Nota");
                                            }else{
                                                DescontoItem.show("Desconto(%)","Desconto sobre item");
                                            }
                                        }
                                    });
                                    txtQtdeProduto.setOnKeyPressed(e ->{
                                    if(e.getCode() == KeyCode.ENTER){
                                        if(txtQtdeProduto.getText() == ""){
                                            MessageBox.show("Favor preencher a quantidade", "Erro");
                                        }else{
                                        
                                            consultarQtde();
                                            txtBuscarProduto.clear();
                                            txtQtdeProduto.clear();
                                            txtBuscarProduto.requestFocus();
                                            painelTela.getChildren().clear();
                                            painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                            tabelaCaixa.setItems(ListaCaixa());
                                            
                                        }
                                    }else if(e.getCode() == KeyCode.ESCAPE){
                                            txtQtdeProduto.setDisable(true);
                                            txtQtdeProduto.setText("");
                                            txtBuscarProduto.clear();
                                            txtBuscarProduto.requestFocus();
                                            painelTela.getChildren().clear();
                                            painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);
                                            tabelaCaixa.setItems(ListaCaixa());
                                            
                                    }else if(e.getCode() == KeyCode.F10){
                                            btnFechar.requestFocus();
                                            FecharJanelaCaixa.show("Existe um protocolo em aberto\n\nDeseja cancelar a venda?","Confirmação de evento");
                                        
                                    }else if(e.getCode() == KeyCode.F5){
                                        
                                            FecharCaixa.show("Valor em caixa","Fechamento de caixa");
                                            
                                    }else if(e.getCode() == KeyCode.F11){
                                        DadosCaixa data = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();
                                        
                                        if(data == null){
                                            MessageBox.show("Selecione um item da lista", "Erro");
                                        }else{
                                            DeleteCaixa.show("Tem certeza que deseja Cancelar este item?","Confirmação de evento");
                                        }
                                    }else if(e.getCode() == KeyCode.F7){
                                        DeleteVendaCaixa.show("Tem certeza que deseja Cancelar a venda?","Confirmação de evento");
                                    }
                                });
                                lblValorTotalDesconto.setVisible(false);
                                lblPorcentagemDesconto.setVisible(false);
                                tabelaCaixa.setOnKeyPressed(ex -> {
                                    if(ex.getCode() == KeyCode.F10){
                                        btnFechar.requestFocus();
                                        FecharJanelaCaixa.show("Existe um protocolo em aberto\n\nDeseja cancelar a venda?","Confirmação de evento");
                                    }else if(ex.getCode() == KeyCode.F3){
                                        
                                            CargaCaixa.show("Valor entrada","Carga de caixa");
                                            
                                    }else if(ex.getCode() == KeyCode.F4){
                                        
                                            SangriaCaixa.show("Valor saída","Sangria de caixa");
       
                                    }else if(ex.getCode() == KeyCode.F8){
                                        if(tabelaCaixa.getSelectionModel().getSelectedItem() == ""){
                                            Desconto.show("Desconto(%)","Desconto Nota");
                                        }else{
                                            DescontoItem.show("Desconto(%)","Desconto sobre item");
                                        }
                                    }else if(ex.getCode() == KeyCode.F1){
                                        double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                                        lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                                            
                                        if(total == 0.00){
                                            MessageBox.show("Não há vendas a serem fechadas", "Alerta");
                                        }else{
                                            FecharVenda.show("Total a Pagar: ","Fechar Venda");
                                            lblValorTotalDesconto.setVisible(false);
                                            lblPorcentagemDesconto.setVisible(false);
                                            lblValorTotalDesconto.setText(null);
                                            lblPorcentagemDesconto.setText(null);
                                            tabelaCaixa.setItems(ListaCaixa());
                                        }
                                    }else if(ex.getCode() == KeyCode.F11){
                                        DadosCaixa data = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();
                                        
                                        if(data == null){
                                            MessageBox.show("Selecione um item da lista", "Erro");
                                        }else{
                                            DeleteCaixa.show("Tem certeza que deseja Cancelar este item?","Confirmação de evento");
                                        }
                                    }else if(ex.getCode() == KeyCode.F7){
                                        DeleteVendaCaixa.show("Tem certeza que deseja Cancelar a venda?","Confirmação de evento");
                                    }
                                });
                                                                
                                double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                                lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                                
                                lblValorTotal.setFont(new Font(23));
                                lblValorDesconto.setFont(new Font(23));
                                lblValorTotalDesconto.setFont(new Font(23));
                                lblPorcentagemDesconto.setFont(new Font(23));
                                lblPorcentagemDesconto.setTextFill(Color.RED);
                                lblTotal.setFont(new Font(23));
                                lblValorTotalDesconto.setTextFill(Color.DARKBLUE);
                                tabelaCaixa.setPrefWidth(875);
                                tabelaCaixa.setPrefHeight(350);
                                tabela.setPrefWidth(850);
                                tabela.setPrefHeight(350);
                                txtQtdeProduto.setPrefWidth(100);
                                txtBuscarProduto.setPrefWidth(650);
                                btnCliente.setPrefWidth(115);
                                btnFechar.setPrefWidth(115);
                                btnFecharVenda.setPrefWidth(115);
                                btnCarga.setPrefWidth(115);
                                btnSangria.setPrefWidth(115);
                                btnFecharCaixa.setPrefWidth(115);
                                btnBuscarVenda.setPrefWidth(115);
                                btnCancelarVenda.setPrefWidth(115);
                                btnDesconto.setPrefWidth(115);
                                btnReimpressao.setPrefWidth(115);
                                btnAbrirCaixa.setPrefWidth(115);                                
                                btnCancelarItem.setPrefWidth(115);
                                btnCancelarProtocolo.setPrefWidth(115);
                                btnCancelarProtocoloAnterior.setPrefWidth(115);
                                
                                tabela.getColumns().addAll(colunaID, colunaDescricao, colunaBarras, colunaVarejo);
                                tabelaCaixa.getColumns().addAll(colunaIDCaixa, colunaDescricaoCaixa, colunaFabricanteCaixa, colunaQtdeCaixa, colunaVarejoCaixa, colunaSubtotalCaixa);
                                
                                tabelaCaixa.setId("tabela-caixa");
                                colunaSubtotalCaixa.getStyleClass().add("coluna-valor");

                                lblBuscarProduto.setStyle("-fx-font-weight: bold");
                                lblValorTotal.setStyle("-fx-font-weight: bold");
                                lblValorTotalDesconto.setStyle("-fx-font-weight: bold");
                                lblPorcentagemDesconto.setStyle("-fx-font-weight: bold");
                                lblValorDesconto.setStyle("-fx-font-weight: bold");
                                lblTotal.setStyle("-fx-font-weight: bold");
                                lblQtdeProduto.setStyle("-fx-font-weight: bold");
                                dataD.setStyle("-fx-font-weight: bold");
                                lblNomeOperador.setStyle("-fx-font-weight: bold");
                                
                                painelPrincipal.setPadding(new Insets(15));
                                painelTela.getChildren().addAll(tabelaCaixa, painelBotoesCaixa);                                
                                painelBotoesCaixa.getChildren().addAll(btnAbrirCaixa, btnFecharVenda, btnCliente, btnCarga, btnSangria, btnFecharCaixa, btnBuscarVenda, btnCancelarVenda, btnDesconto, btnReimpressao, btnFechar, btnCancelarItem, btnCancelarProtocoloAnterior);
                                painelBuscar.getChildren().addAll(lblBuscarProduto, txtBuscarProduto, lblQtdeProduto, txtQtdeProduto);

                                lblOperador.setFont(new Font(15));
                                lblHorario.setFont(new Font(15));
                                lblNomeOperador.setFont(new Font(15));
                                lblDataVenda.setFont(new Font(15));
                                dataD.setFont(new Font(15));

                                KeyFrame frame = new KeyFrame(Duration.millis(1000), e -> atualizaHoras());
                		Timeline timeline = new Timeline(frame);
                                timeline.setCycleCount(Timeline.INDEFINITE);
                                timeline.play();
                                
                                barraStatusCaixa.getChildren().addAll(lblStatusCaixa);
                                barra.getChildren().addAll(lblOperador, lblNomeOperador, lblDataVenda, dataD, lblTempo, lblHorario);                                
                                painelTotalizadores.getChildren().addAll(lblTotal, lblValorTotal, lblPorcentagemDesconto, lblValorTotalDesconto);
                                painelPrincipal.getChildren().addAll(painelBuscar, painelTela, painelTotalizadores);
				inicio.showAndWait();
		}
                public static void btnFechar(){
                        inicio.close();
                }
                public static ObservableList<DadosCaixa> ListaCaixa() {
                    
                        ObservableList<DadosCaixa> dados = FXCollections.observableArrayList();
                        ResultSet rs;

                        try{
                            Connection conexao = Conexao.getConexao();
                            String consulta = "SELECT * FROM CAIXA WHERE STATUS = 'ABERTO' ORDER BY ID;";

                            PreparedStatement stm = conexao.prepareStatement(consulta);

                            rs = stm.executeQuery(consulta);



                            while(rs.next()){

                                Locale l = new Locale("pt","BR");

                                NumberFormat nf = NumberFormat.getInstance(l);

                                String id = rs.getString("CODIGO");
                                String descricao = rs.getString("DESCRICAO");
                                String fabricante = rs.getString("FABRICANTE");
                                String qtde = rs.getString("QTDE");
                                String varejo = rs.getString("VAREJO"); 
                                String subtotal = rs.getString("SUBTOTAL");

                                dados.add(new DadosCaixa(id, descricao, fabricante, qtde, "R$"+String.valueOf(varejo).replace(".",","), "R$"+String.valueOf(subtotal).replace(".",",")));
                            }               
                        }catch(Exception ex){
                            System.err.println(ex);
                        }
                        return dados;
            }
            public static ObservableList<DadosProdutos> BuscarDescricao() {
                    
                        ObservableList<DadosProdutos> dadosDescr = FXCollections.observableArrayList();
                        ResultSet rs;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String consulta = "SELECT * FROM PRODUTOS WHERE DESCRICAO LIKE '%"+txtBuscarProduto.getText()+"%';";

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

                        }catch(Exception ex){
                            System.err.println(ex);
                        }
                        return dadosDescr;
            }
            public static ObservableList<DadosProdutos> BuscarID() {
                    
                        ObservableList<DadosProdutos> dadosDescr = FXCollections.observableArrayList();
                        ResultSet rs;

                        try{
                            Connection conexao = Conexao.getConexao();
                            String consulta = "SELECT * FROM PRODUTOS WHERE produtos.ID = "+txtBuscarProduto.getText()+";";

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
                        }catch(Exception ex){
                            System.err.println(ex);
                        }
                        return dadosDescr;
            }
            public static ObservableList<DadosProdutos> BuscarCodBarras() {
                    
                        ObservableList<DadosProdutos> dadosDescr = FXCollections.observableArrayList();
                        ResultSet rs;

                        try{
                            Connection conexao = Conexao.getConexao();
                            String consulta = "SELECT * FROM PRODUTOS WHERE BARRAS LIKE '%"+txtBuscarProduto.getText()+"%';";

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
    
                        }catch(Exception ex){
                            System.err.println(ex);
                        }
                        return dadosDescr;
            }
            public static void InserirCaixa() {

                        dados = (DadosProdutos) tabela.getSelectionModel().getSelectedItem();             
                        
                        try{

                                Connection conexao = Conexao.getConexao();

                                Index index = new Index();

                                String sql = "INSERT INTO CAIXA(ID, CODIGO, DESCRICAO, FABRICANTE, VAREJO, QTDE, SUBTOTAL, USUARIO, DATA_HORA, STATUS, PROTOCOLO) VALUES(default, '"+dados.getID()+"', '"+dados.getDescricao()+"', '"+dados.getFabricante()+"', '"+dados.getVarejo().replace("R$","").replaceAll(",",".")+"',"+txtQtdeProduto.getText().replaceAll(",",".")+","+dados.getVarejo().replace("R$","").replace(",",".")+" * "+txtQtdeProduto.getText().replaceAll(",",".")+", '"+Login.campo1.getText()+"', NOW(), 'ABERTO', default);";
                                
                                String upsql = "UPDATE CAIXA SET PROTOCOLO = (SELECT PROTOCOLO FROM CAIXA WHERE STATUS = 'CONCLUIDO' ORDER BY ID DESC LIMIT 1) + 1 WHERE STATUS = 'ABERTO';";
                                
                                PreparedStatement stm = conexao.prepareStatement(sql);

                                PreparedStatement upstm = conexao.prepareStatement(upsql);
                                
                                stm.execute(sql);
                                
                                upstm.execute(upsql);

                                double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                                lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));

                            }catch(Exception e){
                                MessageBox.show(""+e, "Erro");
                            }
                        
            }
            public static void btnAdicionarQtde(){
        
                        DadosProdutos data = (DadosProdutos) tabela.getSelectionModel().getSelectedItem();
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set qtde = qtde + "+txtQtdeProduto.getText().replaceAll(",",".")+", subtotal = varejo * qtde where codigo = '"+data.getID()+"' and descricao = '"+data.getDescricao()+"';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);

                            atualiza.execute();

                            double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                            lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));

                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }
            }
            public static ObservableList<DadosProdutosAdd> consultarQtde(){
                
                        ResultSet rs;
                        ResultSet res;
                        PreparedStatement stm;
                        PreparedStatement stmt;
                        ObservableList<DadosProdutosAdd> dados = FXCollections.observableArrayList();
                        DadosProdutos data = (DadosProdutos) tabela.getSelectionModel().getSelectedItem();

                        try{
                             Connection conexao = Conexao.getConexao();
                             String consulta = "SELECT COUNT(*) as count FROM caixa WHERE status = 'ABERTO' and codigo = '"+data.getID()+"';";
                             stm = conexao.prepareStatement(consulta);
                             rs = stm.executeQuery(consulta);
                             
                             int count = 0;

                             while(rs.next()){
                                 count = rs.getInt("count");    
                             }
                             if(count == 1){
                                 btnAdicionarQtde();
                             }else{
                                 InserirCaixa();
                             }
                        }catch(Exception ex){
                             System.err.println(ex);
                        }
                        return dados;
            }
            public static void btnExcluir(){

                        DadosCaixa data = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();

                        try{
                            Connection conexao = Conexao.getConexao();
                            String sql = "DELETE FROM CAIXA WHERE DESCRICAO = '"+data.getDescricao()+"' AND STATUS = 'ABERTO';";
                            PreparedStatement stm = conexao.prepareStatement(sql);
                            if(data == null){
                                MessageBox.show("Selecione um item da lista", "Erro");
                            }else{
                                stm.execute(sql);
                                tabelaCaixa.setItems(ListaCaixa());
                                double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                                lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                                conexao.close();
                                
                            }
                        }catch(Exception e){
                            MessageBox.show(""+e, "Erro");
                        }
            }
            public static void btnExcluirTudo(){

                        try{
                            Connection conexao = Conexao.getConexao();
                            String sql = "DELETE FROM CAIXA where STATUS = 'ABERTO';";
                            PreparedStatement stm = conexao.prepareStatement(sql);
                            if(data == null){
                                MessageBox.show("Selecione um item da lista", "Erro");
                            }else{
                                stm.execute(sql);
                                tabelaCaixa.setItems(ListaCaixa());
                                conexao.close();
                            }
                        }catch(Exception e){
                            MessageBox.show(""+e, "Erro");
                        }
            }
            public static void btnDesconto(){

                        try{
                            Connection conexao = Conexao.getConexao();
                            double desc = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                            Desconto pDesc =  new Desconto();
                            String sql = "UPDATE CAIXA SET DESCONTO = '"+Desconto.txtSaldoCaixa.getText().replace(",", ".")+"', DESCONTO_SUBTOTAL = "+Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""))+" - ("+Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""))+" * "+Desconto.txtSaldoCaixa.getText().replace("[", "").replace("]", "")+" / 100) where STATUS = 'ABERTO';";
                            String delsql = "UPDATE CAIXA SET DESCONTO = 0.00, DESCONTO_SUBTOTAL = 0.00 where STATUS = 'ABERTO';";
                            PreparedStatement delstm = conexao.prepareStatement(delsql);
                            PreparedStatement stm = conexao.prepareStatement(sql);
                            if(data == null){
                                MessageBox.show("Selecione um item da lista", "Erro");
                            }else{
                                delstm.execute(delsql);
                                stm.execute(sql);
                                tabelaCaixa.setItems(ListaCaixa());
                                lblValorTotalDesconto.setVisible(true);
                                lblPorcentagemDesconto.setVisible(true);
                                double Desconto_total = Double.valueOf(String.valueOf(DescontoTotalizadoresNota()).replace("[", "").replace("]", ""));
                                lblValorTotalDesconto.setText("       Valor Nota: R$"+String.format("%.02f", Desconto_total).replace(".",","));
                                double pDesconto = Double.valueOf(String.valueOf(Desconto.txtSaldoCaixa.getText()).replace("[", "").replace("]", ""));
                                lblPorcentagemDesconto.setText("     Desconto: "+String.format("%.02f", pDesconto).replace(".",",")+"%");
                                conexao.close();
                            }
                        }catch(Exception e){
                            MessageBox.show(""+e, "Erro");
                        }
            }
            public static boolean VerificarPermissao(){
                
                        int cont = 0;
                        boolean verificador = false;
                        Connection conexao = Conexao.getConexao();

                        try {
                            String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND CARGO = 'Administrador'";

                            PreparedStatement stm = conexao.prepareStatement(sql);

                            ResultSet rs = stm.executeQuery(sql);

                            while(rs.next()){
                                cont = rs.getInt("cont");
                            }
                            if(cont == 1){
                                verificador = true;
                                btnExcluir();
                            } else{
                                AcessoAdmin.show("","Permissão do Administrador");
                            }
                        } catch (Exception ex) {
                            MessageBox.show(""+ex,"Erro");
                        }
                        return verificador;
            }
            public static boolean VerificarPermissao2(){
                int cont = 0;
                boolean verificador = false;
                Connection conexao = Conexao.getConexao();

                try {
                        String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND CARGO = 'Administrador'";

                        PreparedStatement stm = conexao.prepareStatement(sql);

                        ResultSet rs = stm.executeQuery(sql);

                        while(rs.next()){
                            cont = rs.getInt("cont");
                        }
                        if(cont == 1){
                            verificador = true;
                            btnExcluirTudo();
                            lblValorTotalDesconto.setText(null);
                            lblPorcentagemDesconto.setText(null);
                            double total = Double.valueOf(String.valueOf(TotalizadoresNota()).replace("[", "").replace("]", ""));
                            lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
                        } else{
                            AcessoAdmin2.show("","Permissão do Administrador");
                        }
                    } catch (Exception ex) {
                        MessageBox.show(""+ex,"Erro");
                    }
                    return verificador;
            }
            public static boolean VerificarPermissao3(){
                int cont = 0;
                boolean verificador = false;
                Connection conexao = Conexao.getConexao();

                try {
                        String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND CARGO = 'Administrador'";

                        PreparedStatement stm = conexao.prepareStatement(sql);

                        ResultSet rs = stm.executeQuery(sql);

                        while(rs.next()){
                            cont = rs.getInt("cont");
                        }
                        if(cont == 1){
                            verificador = true;
                            btnDesconto();
                        } else{
                            AcessoAdmin3.show("","Permissão do Administrador");
                            
                        }
                    } catch (Exception ex) {
                        MessageBox.show(""+ex,"Erro");
                    }
                    return verificador;
            }
            public static boolean VerificarPermissao4(){
                int cont = 0;
                boolean verificador = false;
                Connection conexao = Conexao.getConexao();

                try {
                        String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND CARGO = 'Administrador'";

                        PreparedStatement stm = conexao.prepareStatement(sql);

                        ResultSet rs = stm.executeQuery(sql);

                        while(rs.next()){
                            cont = rs.getInt("cont");
                        }
                        if(cont == 1){
                            verificador = true;
                            btnDescontoItem();
                        } else{
                            AcessoAdmin4.show("","Permissão do Administrador");
                            
                        }
                    } catch (Exception ex) {
                        MessageBox.show(""+ex,"Erro");
                        System.err.println(ex);
                    }
                    return verificador;
            }
            public static boolean statusCaixa2(){
                int cont = 0;
                boolean verificador = false;
                Connection conexao = Conexao.getConexao();

                try {
                        String sql = "SELECT COUNT(STATUS) AS cont FROM CAIXA WHERE STATUS = 'CONCLUIDO'";

                        PreparedStatement stm = conexao.prepareStatement(sql);

                        ResultSet rs = stm.executeQuery(sql);

                        while(rs.next()){
                            cont = rs.getInt("cont");
                        }
                        if(cont >= 1){
                            verificador = true;
                        } else{
                            AcessoAdmin4.show("","Permissão do Administrador");
                            
                        }
                    } catch (Exception ex) {
                        MessageBox.show(""+ex,"Erro");
                        System.err.println(ex);
                    }
                    return verificador;
            }
            public static ObservableList<DadosTotalNota> TotalizadoresNota(){
                    ResultSet rs;
                    PreparedStatement stm;
                    ObservableList<DadosTotalNota> dados = FXCollections.observableArrayList();
                    DadosProdutos data = (DadosProdutos) tabelaCaixa.getSelectionModel().getSelectedItem();

                    try{
                        Connection conexao = Conexao.getConexao();
                        String consulta = "SELECT SUM(subtotal) as subtotal FROM caixa where STATUS = 'ABERTO'";
                        stm = conexao.prepareStatement(consulta);
                        rs = stm.executeQuery(consulta);

                        while(rs.next()){
                            double valor_total = rs.getDouble("subtotal");    
                            dados.add(new DadosTotalNota(valor_total));
                        }
                   }catch(Exception ex){
                        System.err.println(ex);
                   }
                   return dados;
            }
            public static ObservableList<DadosTotalDescontoNota> DescontoTotalizadoresNota(){
                    ResultSet rs;
                    PreparedStatement stm;
                    ObservableList<DadosTotalDescontoNota> dados = FXCollections.observableArrayList();
                    DadosProdutos data = (DadosProdutos) tabelaCaixa.getSelectionModel().getSelectedItem();

                    try{
                        Connection conexao = Conexao.getConexao();
                        String consulta = "SELECT desconto_subtotal FROM caixa where STATUS = 'ABERTO' LIMIT 1;";
                        stm = conexao.prepareStatement(consulta);
                        rs = stm.executeQuery(consulta);

                        while(rs.next()){
                            double valor_total = rs.getDouble("desconto_subtotal");    
                            dados.add(new DadosTotalDescontoNota(valor_total));
                        }
                        
                   }catch(Exception ex){
                        System.err.println(ex);
                   }
                   return dados;
            }
            public static void atualizaHoras() {
		Date agora = new Date();
		lblHorario.setText(formatador.format(agora)); 
	}               
        public static boolean VerificarCaixa(){
                        
                        int cont = 0;
                        boolean verificador = false;
                        Connection conexao = Conexao.getConexao();

                        try {
                            String sql = "SELECT COUNT(*) AS cont FROM saldo_total WHERE STATUS = 'FECHADO'";

                            PreparedStatement stm = conexao.prepareStatement(sql);

                            ResultSet rs = stm.executeQuery(sql);

                            while(rs.next()){
                                cont = rs.getInt("cont");
                            }
                            if(cont == 1){
                                verificador = true;
                            }else{
                                verificador = false;
                            }
                        } catch (Exception ex) {
                            MessageBox.show(""+ex,"Erro");
                        }
                        return verificador;
        }    
        public static ObservableList<DadosNPDV> acessoPDV(){
                ResultSet rs;
                PreparedStatement stm;
                ObservableList<DadosNPDV> dado = FXCollections.observableArrayList();
                    
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM saldo_total WHERE STATUS = 'ABERTO';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    rs = st.executeQuery(sql);

                    while(rs.next()){
                        int count = rs.getInt("COUNT");
                        dado.add(new DadosNPDV(count));
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return dado;
        }
        public static void btnDescontoItem(){
                        
                        DadosCaixa dados = (DadosCaixa) tabelaCaixa.getSelectionModel().getSelectedItem();
                        
                        double valor_desconto_item = Double.valueOf(String.valueOf(dados.getSubtotal()).replace("[", "").replace("]", "").replace(",",".").replace("R$",""));
                        
                        try{
                            Connection conexao = Conexao.getConexao();
                            String sql = "UPDATE CAIXA SET DESCONTO_ITEM = '"+DescontoItem.txtDescontoItem.getText().replace(",", ".")+"', DESCONTO_SUBTOTAL = 0.00, SUBTOTAL = "+Double.valueOf(String.valueOf(dados.getSubtotal()).replace("[", "").replace("]", "").replace(",",".").replace("R$",""))+" - ("+Double.valueOf(String.valueOf(dados.getSubtotal()).replace("[", "").replace("]", "").replace(",",".").replace("R$",""))+" * "+DescontoItem.txtDescontoItem.getText().replace("[", "").replace("]", "").replace(",",".")+" / 100) where Descricao = '"+dados.getDescricao()+"' AND STATUS = 'ABERTO';";
                            String delsql = "UPDATE CAIXA SET DESCONTO = 0.00, DESCONTO_SUBTOTAL = 0.00 where Descricao = '"+dados.getDescricao()+"' AND STATUS = 'ABERTO';";
                            PreparedStatement delstm = conexao.prepareStatement(delsql);
                            PreparedStatement stm = conexao.prepareStatement(sql);
                            if(data == null){
                                MessageBox.show("Selecione um item da lista", "Erro");
                            }else{
                                delstm.execute(delsql);
                                stm.execute(sql);
                                tabelaCaixa.setItems(ListaCaixa());
                                lblValorTotal.setVisible(true);
                                double Desconto_total = Double.valueOf(String.valueOf(DescontoTotalizadoresItem()).replace("[", "").replace("]", ""));
                                lblValorTotal.setText("R$"+String.format("%.02f", Desconto_total).replace(".",","));
                                tabelaCaixa.setItems(ListaCaixa());
                                conexao.close();
                            }
                        }catch(Exception e){
                            MessageBox.show(""+e, "Erro");
                            System.err.println(e);
                        }
        }
        public static ObservableList<DadosTotalDescontoNota> DescontoTotalizadoresItem(){
            
                    ResultSet rs;
                    PreparedStatement stm;
                    ObservableList<DadosTotalDescontoNota> dados = FXCollections.observableArrayList();
                    DadosProdutos data = (DadosProdutos) tabelaCaixa.getSelectionModel().getSelectedItem();

                    try{
                        Connection conexao = Conexao.getConexao();
                        String consulta = "SELECT sum(subtotal) as desconto_item FROM caixa where STATUS = 'ABERTO';";
                        stm = conexao.prepareStatement(consulta);
                        rs = stm.executeQuery(consulta);

                        while(rs.next()){
                            double valor_total = rs.getDouble("desconto_item");    
                            dados.add(new DadosTotalDescontoNota(valor_total));
                        }
                        
                   }catch(Exception ex){
                        System.err.println(ex);
                   }
                   return dados;
            }
}