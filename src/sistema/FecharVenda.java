package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import static sistema.Venda.lblValorTotal;

public class FecharVenda {
       
    public static TextField txtEspecie;
    public static TextField txtEspecieRestante;
    public static Label lblValorTotal;
    public static Label lblValorTotalDesconto;
    public static DatePicker txtVencimento;
    public static TextField txtParcelas;
    public static DatePicker txtVencimento2;
    public static TextField txtParcelas2;
    public static ComboBox cbBandeira2;
    public static TableView tabelaParcelas2;
    public static ComboBox cbBandeira;
    public static TableView tabelaParcelas;
    public static Label lblRestante;
    
    public static void show(String message, String title){
        
        Stage inicio = new Stage();
        VBox painel = new VBox(5);
        HBox painel1 = new HBox(5);
        HBox painel2 = new HBox(5);
        HBox painel3 = new HBox(5);
        HBox painel4 = new HBox(5);
        HBox painel5 = new HBox(5);
        HBox painel6 = new HBox(5);
        HBox painel7 = new HBox(5);
        HBox painel8 = new HBox(5);
        HBox painel9 = new HBox(5);
        HBox painel10 = new HBox(5);
        HBox painel11 = new HBox(5);
        HBox painel12 = new HBox(5);
        HBox painel13 = new HBox(5);
        HBox painel14 = new HBox(5);
        HBox painel15 = new HBox(5);
        HBox painel16 = new HBox(5);
        HBox painel17 = new HBox(5);
        Button btnSim = new Button("Ok");
        Button btnNao = new Button("_Cancelar");
        Scene cenario = new Scene(painel, 360, 350);
        tabelaParcelas = new TableView();
        tabelaParcelas2 = new TableView();
        TableColumn colunaParcela = new TableColumn("Parcela");
        TableColumn colunaValorParcela = new TableColumn("Valor");
        TableColumn colunaVencimento = new TableColumn("Vencimento");
        TableColumn colunaParcela2 = new TableColumn("Parcela");
        TableColumn colunaValorParcela2 = new TableColumn("Valor");
        TableColumn colunaVencimento2 = new TableColumn("Vencimento");
        Label arg = new Label(message);
        lblValorTotal = new Label();
        lblValorTotalDesconto = new Label();
        Label lblFormaPagamento = new Label();
        Label lblFormaPagamento2 = new Label("Modo de pagamento ");
        Label lblFormaPagamento3 = new Label();
        Label lblFormaPagamento4 = new Label("Modo de pagamento ");
        Label lblEspecie = new Label("Recebido                    ");
        Label lblEspecieRestante = new Label("Recebido                    ");
        Label lblBandeira = new Label("Bandeiras                   ");
        Label lblParcelas = new Label("Parcelas                      ");
        Label lblVencimento = new Label("Vencimento                ");
        Label lblBandeira2 = new Label("Bandeiras                   ");
        Label lblParcelas2 = new Label("Parcelas                      ");
        Label lblVencimento2 = new Label("Vencimento                ");
        lblRestante = new Label();
        txtParcelas = new TextField();
        txtVencimento = new DatePicker();
        txtParcelas2 = new TextField();
        txtVencimento2 = new DatePicker();
        ComboBox cbFormaPagamento = new ComboBox();
        ComboBox cbFormaPagamento2 = new ComboBox();
        ComboBox cbFormaPagamento3 = new ComboBox();
        ComboBox cbFormaPagamento4 = new ComboBox();
        ComboBox cbBandeira = new ComboBox();
        ComboBox cbBandeira2 = new ComboBox();
        lblFormaPagamento.setText("Forma de Pagamento");
        lblFormaPagamento3.setText("Forma de Pagamento");
        lblParcelas.setStyle("-fx-font-weight: bold");
        lblParcelas2.setStyle("-fx-font-weight: bold");
        arg.setFont(new Font(11));
        arg.setStyle("-fx-font-weight: bold");
        lblFormaPagamento.setStyle("-fx-font-weight: bold");
        lblFormaPagamento3.setStyle("-fx-font-weight: bold");
        lblFormaPagamento4.setStyle("-fx-font-weight: bold");
        lblVencimento.setStyle("-fx-font-weight: bold");
        lblVencimento2.setStyle("-fx-font-weight: bold");
        lblFormaPagamento2.setStyle("-fx-font-weight: bold");
        lblEspecie.setStyle("-fx-font-weight: bold");
        lblEspecieRestante.setStyle("-fx-font-weight: bold");
        lblRestante.setStyle("-fx-font-weight: bold");
        lblValorTotal.setStyle("-fx-font-weight: bold");
        lblValorTotalDesconto.setStyle("-fx-font-weight: bold");
        lblBandeira.setStyle("-fx-font-weight: bold");
        lblBandeira2.setStyle("-fx-font-weight: bold");
        
        txtParcelas.setPrefWidth(80);
        txtParcelas2.setPrefWidth(80);
        
        painel12.setVisible(false);
        painel13.setVisible(false);
        painel14.setVisible(false);
        painel15.setVisible(false);
        painel16.setVisible(false);
        painel17.setVisible(false);
        painel4.setVisible(false);
        painel6.setVisible(false);
        painel7.setVisible(false);
        painel8.setVisible(false);
        
        cbFormaPagamento.getItems().addAll("Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Voucher", "Cheque", "Outros");
        cbFormaPagamento3.getItems().addAll("Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Voucher", "Cheque", "Outros");
        cbFormaPagamento2.getItems().addAll("A Vista", "A Prazo");
        cbFormaPagamento4.getItems().addAll("A Vista", "A Prazo");
        cbBandeira.getItems().addAll("Visa", "MasterCard", "Diners", "AMEX", "Elo", "Outros");      
        cbBandeira2.getItems().addAll("Visa", "MasterCard", "Diners", "AMEX", "Elo", "Outros");      
        
        tabelaParcelas.setPrefWidth(340);
        colunaParcela.setCellValueFactory(new PropertyValueFactory<DadosParcelaVenda, Integer>("parcela"));
        colunaParcela.setPrefWidth(90);
        colunaValorParcela.setCellValueFactory(new PropertyValueFactory<DadosParcelaVenda, String>("valorParcela"));
        colunaValorParcela.setPrefWidth(120);
        colunaVencimento.setCellValueFactory(new PropertyValueFactory<DadosParcelaVenda, String>("vencimento"));
        colunaVencimento.setPrefWidth(130);
        
        txtEspecie = new TextField();
        txtEspecieRestante = new TextField();
        
        colunaParcela.setStyle("-fx-alignment: center-right; -fx-font-size: 12px; -fx-font-family: arial;");
        colunaValorParcela.setStyle("-fx-alignment: center-left; -fx-font-size: 12px; -fx-font-family: arial;");
        colunaVencimento.setStyle("-fx-alignment: center; -fx-font-size: 12px; -fx-font-family: arial;");
        colunaParcela2.setStyle("-fx-alignment: center-right; -fx-font-size: 12px; -fx-font-family: arial;");
        colunaValorParcela2.setStyle("-fx-alignment: center-left; -fx-font-size: 12px; -fx-font-family: arial;");
        colunaVencimento2.setStyle("-fx-alignment: center; -fx-font-size: 12px; -fx-font-family: arial;");
        
        tabelaParcelas.getColumns().addAll(colunaParcela, colunaValorParcela, colunaVencimento);
        tabelaParcelas2.getColumns().addAll(colunaParcela2, colunaValorParcela2, colunaVencimento2);

        cbFormaPagamento2.setOnAction(e -> {
            if(cbFormaPagamento2.getValue() == "A Prazo"){
                txtVencimento.setValue(LocalDate.now());
                    painel6.setVisible(true);
                    painel7.setVisible(true);
                    painel6.getChildren().clear();
                    painel7.getChildren().clear();
                    painel6.getChildren().addAll(lblParcelas, txtParcelas);
                    painel7.getChildren().addAll(lblVencimento, txtVencimento);
                }else {
                    painel6.setVisible(false);
                    painel7.setVisible(false);
                    painel6.getChildren().clear();
                    painel7.getChildren().clear();
                }
        });
        cbFormaPagamento4.setOnAction(e -> {
            if(cbFormaPagamento4.getValue() == "A Prazo"){
                txtVencimento2.setValue(LocalDate.now());
                    painel15.setVisible(true);
                    painel16.setVisible(true);
                    painel15.getChildren().clear();
                    painel16.getChildren().clear();
                    painel15.getChildren().addAll(lblParcelas2, txtParcelas2);
                    painel16.getChildren().addAll(lblVencimento2, txtVencimento2);
                }else {
                    painel15.setVisible(false);
                    painel16.setVisible(false);
                    painel15.getChildren().clear();
                    painel16.getChildren().clear();
                }
        });
        cbFormaPagamento.setOnAction(e -> {
            if(cbFormaPagamento.getValue() == "Cartão de Crédito"){
                painel4.setVisible(true);
                painel4.getChildren().clear();
                painel4.getChildren().addAll(lblFormaPagamento2, cbFormaPagamento2);
                painel5.getChildren().clear();
            }else if(cbFormaPagamento.getValue() == "Dinheiro"){
                txtEspecie.setText(String.valueOf(lblValorTotal.getText()).replace("R$",""));
                painel5.getChildren().addAll(lblBandeira, cbBandeira);
                painel4.setVisible(true);
                painel5.setVisible(false);
                painel4.getChildren().clear();
                painel5.getChildren().clear();
                painel4.getChildren().addAll(lblEspecie, txtEspecie);
            }else if(cbFormaPagamento.getValue() == "Cartão de Débito"){
                painel4.setVisible(true);
                painel5.setVisible(false);
                painel4.getChildren().clear();
                painel5.getChildren().clear();
                painel4.getChildren().addAll(lblEspecie, txtEspecie);
            }else if(cbFormaPagamento.getValue() == "Voucher"){
                painel4.setVisible(true);
                painel5.setVisible(false);
                painel4.getChildren().clear();
                painel5.getChildren().clear();
                painel4.getChildren().addAll(lblEspecie, txtEspecie);
            }else if(cbFormaPagamento.getValue() == "Outros"){
                painel4.setVisible(false);
                painel4.getChildren().clear();
            }
        });
        cbFormaPagamento3.setOnAction(e -> {
            if(cbFormaPagamento3.getValue() == "Cartão de Crédito"){
                painel13.setVisible(true);
                painel13.getChildren().clear();
                painel13.getChildren().addAll(lblFormaPagamento4, cbFormaPagamento4);
                painel14.getChildren().clear();
            }else if(cbFormaPagamento3.getValue() == "Dinheiro"){
                txtEspecieRestante.setText(String.valueOf(lblValorTotal.getText()).replace("R$",""));
                painel13.setVisible(true);
                painel14.setVisible(false);
                painel13.getChildren().clear();
                painel14.getChildren().clear();
                painel13.getChildren().addAll(lblEspecieRestante, txtEspecieRestante);
            }else if(cbFormaPagamento3.getValue() == "Cartão de Débito"){
                painel13.setVisible(true);
                painel14.setVisible(false);
                painel13.getChildren().clear();
                painel14.getChildren().clear();
                painel13.getChildren().addAll(lblEspecieRestante, txtEspecieRestante);
            }else if(cbFormaPagamento3.getValue() == "Voucher"){
                painel13.setVisible(true);
                painel14.setVisible(false);
                painel13.getChildren().clear();
                painel14.getChildren().clear();
                painel13.getChildren().addAll(lblEspecieRestante, txtEspecieRestante);
            }else if(cbFormaPagamento3.getValue() == "Outros"){
                painel13.setVisible(false);
                painel13.getChildren().clear();
            }
        });
        inicio.setScene(cenario);
        inicio.initModality(Modality.APPLICATION_MODAL);
        inicio.setTitle(title);  
        double total = Double.valueOf(String.valueOf(Venda.TotalizadoresNota()).replace("[", "").replace("]", ""));

        lblValorTotal.setText("R$"+String.format("%.02f", total).replace(".",","));
        
        double totalDesconto = Double.valueOf(String.valueOf(Venda.DescontoTotalizadoresNota()).replace("[", "").replace("]", ""));
        lblValorTotalDesconto.setText("R$"+String.format("%.02f", totalDesconto).replace(".",","));

        if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){
            painel1.getChildren().clear();
            painel1.getChildren().addAll(arg, lblValorTotal);
        }else{
            painel1.getChildren().clear();
            painel1.getChildren().addAll(arg, lblValorTotalDesconto);
        }
        txtVencimento.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                painel8.setVisible(true);
                painel8.getChildren().clear();
                painel8.getChildren().addAll(tabelaParcelas);
                tabelaParcelas.setItems(ListarParcelas());
                deletarParcelas();
                fecharVendaCredito();
            }else if(e.getCode() == KeyCode.TAB){
                painel8.setVisible(true);
                painel8.getChildren().clear();
                painel8.getChildren().addAll(tabelaParcelas);
                tabelaParcelas.setItems(ListarParcelas());
                deletarParcelas();
                fecharVendaCredito();
            }else{
                painel8.setVisible(false);
                painel8.getChildren().clear();
            }
        });
        txtVencimento2.setOnKeyPressed(e -> {
            if(e.getCode() == KeyCode.ENTER){
                painel17.setVisible(true);
                painel17.getChildren().clear();
                painel17.getChildren().addAll(tabelaParcelas2);
                tabelaParcelas2.setItems(ListarParcelas2());
                deletarParcelas();
                fecharVendaCredito2();
            }else if(e.getCode() == KeyCode.TAB){
                painel17.setVisible(true);
                painel17.getChildren().clear();
                painel17.getChildren().addAll(tabelaParcelas2);
                tabelaParcelas2.setItems(ListarParcelas2());
                deletarParcelas();
                fecharVendaCredito2();
            }else{
                painel17.setVisible(false);
                painel17.getChildren().clear();
            }
        });
        txtEspecie.setOnAction(e -> {
            
            boolean resultado = false;
            double especie = Double.valueOf(String.valueOf(txtEspecie.getText().replace(",",".")));
            double totalVenda = Double.valueOf(String.valueOf(Venda.TotalizadoresNota()).replace("[", "").replace("]", "").replace(",","."));
            
                if(especie < totalVenda){
                    resultado = true;
                }else{
                    resultado = false;
                }
                if(resultado == true){
                        double valorTotal = totalVenda - especie;
                        lblRestante.setText("Valor Restante: R$"+String.format("%.02f", valorTotal).replace(".",","));
                        painel12.setVisible(true);
                        painel4.setVisible(true);
                        painel6.setVisible(true);
                        
                        painel4.getChildren().clear();
                        painel12.getChildren().clear();
                        painel6.getChildren().clear();
                        
                        txtEspecie.setDisable(true);
                        cbFormaPagamento.setDisable(true);
                        painel4.getChildren().addAll(lblEspecie, txtEspecie);
                        painel12.getChildren().addAll(lblRestante);
                        painel6.getChildren().addAll(lblFormaPagamento3, cbFormaPagamento3);
                }else{
                        txtEspecie.setText(String.valueOf(lblValorTotal.getText()).replace("R$",""));
                            painel5.getChildren().addAll(lblBandeira, cbBandeira);
                            painel4.setVisible(true);
                            painel6.setVisible(false);
                            painel7.setVisible(false);
                            
                            lblRestante.setText(null);
                            txtEspecie.setDisable(false);
                            cbFormaPagamento.setDisable(false);
                            painel4.getChildren().clear();
                            painel12.getChildren().clear();
                            painel6.getChildren().clear();
                            painel7.getChildren().clear();
                            painel4.getChildren().addAll(lblEspecie, txtEspecie);
                }
        });
        txtEspecie.setOnKeyPressed( e -> {
            if(e.getCode() == KeyCode.TAB){
                    boolean resultado = false;
                    double especie = Double.valueOf(String.valueOf(txtEspecie.getText().replace(",",".")));
                    double totalVenda = Double.valueOf(String.valueOf(Venda.TotalizadoresNota()).replace("[", "").replace("]", "").replace(",","."));

                    if(especie < totalVenda){
                        resultado = true;
                    }else{
                        resultado = false;
                    }
                    if(resultado == true){
                            double valorTotal = totalVenda - especie;
                            lblRestante.setText("Valor Restante: R$"+String.format("%.02f", valorTotal).replace(".",","));
                            painel12.setVisible(true);
                            painel4.setVisible(true);
                            painel6.setVisible(true);
                            
                            painel4.getChildren().clear();
                            painel12.getChildren().clear();
                            painel6.getChildren().clear();

                            txtEspecie.setDisable(true);
                            cbFormaPagamento.setDisable(true);
                            painel4.getChildren().addAll(lblEspecie, txtEspecie);
                            painel12.getChildren().addAll(lblRestante);
                            painel6.getChildren().addAll(lblFormaPagamento3, cbFormaPagamento3);
                    }else{
                            txtEspecie.setText(String.valueOf(lblValorTotal.getText()).replace("R$",""));
                            painel12.getChildren().addAll(lblBandeira, cbBandeira);
                            painel4.setVisible(true);
                            painel5.setVisible(false);
                            painel6.setVisible(false);
                            painel7.setVisible(false);
                            
                            lblRestante.setText(null);
                            txtEspecie.setDisable(false);
                            cbFormaPagamento.setDisable(false);
                            painel4.getChildren().clear();
                            painel12.getChildren().clear();
                            painel6.getChildren().clear();
                            painel7.getChildren().clear();
                            painel4.getChildren().addAll(lblEspecie, txtEspecie);
                }
            }
        });
        
        btnSim.setOnAction(e -> 
        {
                double totalDesc = Double.valueOf(String.valueOf(Venda.DescontoTotalizadoresNota()).replace("[", "").replace("]", ""));
                double especie = Double.valueOf(String.valueOf(txtEspecie.getText().replace(",",".")));
                
                double troco = especie - total;
                double trocodesc = especie - totalDesc;
                double totalVenda = Double.valueOf(String.valueOf(Venda.TotalizadoresNota()).replace("[", "").replace("]", "").replace(",","."));
                
                atualiza();
                fechaVendaDinheiro();
                if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){ 
                        MessageBoxTroco.show("Troco: R$"+String.format("%.02f", troco).replace(".",","), "Troco");                   
                }else{
                        MessageBoxTroco.show("Troco: R$"+String.format("%.02f", trocodesc).replace(".",","), "Troco");   
                }
                inicio.close();
        });
        btnSim.setOnKeyPressed(evt -> 
        {
            if(btnSim.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                
                
                if(cbFormaPagamento.getValue() == "Dinheiro" || cbFormaPagamento.isDisabled() == false){
                    double totalDesc = Double.valueOf(String.valueOf(Venda.DescontoTotalizadoresNota()).replace("[", "").replace("]", ""));
                    double especie = Double.valueOf(String.valueOf(txtEspecie.getText().replace(",",".")));

                    double troco = especie - total;
                    double trocodesc = especie - totalDesc;
                    atualiza();
                    fechaVendaDinheiro();
                    if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){ 
                        MessageBoxTroco.show("Troco: R$"+String.format("%.02f", troco).replace(".",","), "Troco");
                    }else{
                        MessageBoxTroco.show("Troco: R$"+String.format("%.02f", trocodesc).replace(".",","), "Troco");
                    }
                }else if(cbFormaPagamento.getValue() == "Cartão de Débito"){
                    atualiza();
                    fechaVendaDebito();
                }else if(cbFormaPagamento.getValue() == "Cartão de Crédito"){
                    atualiza();
                    btnOkCredito();
                }else if(cbFormaPagamento3.getValue() == "Dinheiro"){
                    double especie = Double.valueOf(String.valueOf(txtEspecieRestante.getText().replace(",",".")));

                    double troco = especie - total;
                    atualiza();
                    fechaVendaDinheiro2();                    
                    MessageBoxTroco.show("Troco: R$"+String.format("%.02f", troco).replace(".",","), "Troco");
                }else if(cbFormaPagamento3.getValue() == "Cartão de Débito"){
                    atualiza();
                    fechaVendaDebito2();
                }else if(cbFormaPagamento3.getValue() == "Cartão de Crédito"){
                    atualiza();
                    btnOkCredito2();
                }
                
                inicio.close();
            }
        });
        btnNao.setOnKeyPressed(e -> 
        {
            if(btnNao.isFocused() == true && e.getCode() == KeyCode.ENTER){
                    Venda.txtBuscarProduto.requestFocus();
                    inicio.close();
            }
        });
        btnNao.setOnAction(e -> {
                Venda.txtBuscarProduto.requestFocus();
                inicio.close();
        });
        
        painel2.getChildren().addAll(btnSim, btnNao);
        painel2.setAlignment(Pos.BASELINE_CENTER);
        painel.setStyle("-fx-text-fill: -fx-text-inner-color; -fx-background-color: ghostwhite, gainsboro ; -fx-background-insets: 0, 31 0 0 0");
        painel.getChildren().addAll(painel1, painel3, painel4, painel12, painel5, painel6, painel7, painel8, painel13, painel14, painel15, painel16, painel17, painel2);
        painel3.getChildren().addAll(lblFormaPagamento, cbFormaPagamento);
        lblValorTotal.setFont(new Font(15));
        lblValorTotalDesconto.setFont(new Font(15));
        arg.setFont(new Font(15));
        
        painel.setPadding(new Insets(10));
        painel1.setAlignment(Pos.CENTER);
        painel2.setAlignment(Pos.BASELINE_RIGHT);
        
        inicio.showAndWait();
    }
    public static void fechaVendaDinheiro(){

                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set dinheiro = "+txtEspecie.getText().replace(",", ".")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);

                            atualiza.execute();

                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }   
    }
    public static void fechaVendaDebito(){
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement atualiza2;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set debito = "+lblValorTotal.getText().replace(",", ".").replace("R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
                            String atualizarQtde2 = "update caixa set debito = "+lblValorTotalDesconto.getText().replace(",", ".").replace("R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);
                            atualiza2 = conexao.prepareStatement(atualizarQtde2);
                            
                            if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){
                                atualiza.execute();
                            }else{
                                atualiza2.execute();
                            }
                            

                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }           
    }
    public static void fechaVendaCreditoDesconto(){
        try{    
            Connection conexao = Conexao.getConexao();
            
            int contador = 30;
            
            int cont = Integer.parseInt(txtParcelas.getText());
            
            double valorParcela = Double.parseDouble(lblValorTotalDesconto.getText().replace(",", ".").replace("R$", "")) / cont;
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String dt = String.valueOf(txtVencimento.getValue()).replace("[","").replace("]","");

            Date dataD = formato.parse(dt);

            String dataFormatada = formato.format(dataD);

            String sql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, 1, "+lblValorTotalDesconto.getText().replace(",", ".").replace("R$", "")+" / "+cont+",'"+String.valueOf(txtVencimento.getValue())+"', '1');";
            
            String delete = "DELETE a FROM parcelas_credito AS a, parcelas_credito AS b WHERE a.parcela=b.parcela AND a.id < b.id AND a.STATUS = 'ABERTO';";

            String update = "UPDATE PARCELAS_CREDITO SET STATUS = 'ABERTO' WHERE STATUS <> 'CONCLUIDO';";
            
            String protocolo = "UPDATE PARCELAS_CREDITO SET PROTOCOLO = (SELECT PROTOCOLO FROM CAIXA WHERE STATUS = 'ABERTO' ORDER BY ID LIMIT 1) WHERE STATUS = 'ABERTO';";

            PreparedStatement stm = conexao.prepareStatement(sql);
            
            PreparedStatement updatestm = conexao.prepareStatement(update);

            PreparedStatement delstm = conexao.prepareStatement(delete);
            
            PreparedStatement prot = conexao.prepareStatement(protocolo);
            
            stm.execute(sql);
            
            for(int i = 1; i < cont; ++i){
                
                int parcelas = i + 1;

                String mysql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, '"+parcelas+"', "+lblValorTotalDesconto.getText().replace(",", ".").replace("R$", "")+" / "+cont+", ADDDATE('"+dataFormatada+"', INTERVAL "+contador+" DAY), 'ABERTO');";

                PreparedStatement st = conexao.prepareStatement(mysql);

                st.execute(mysql);
            }
            delstm.execute(delete);
            for(int i = 0; i < cont; ++i){

                int count = i + 1;
                
                String datamysql = "UPDATE PARCELAS_CREDITO SET VENCIMENTO = ADDDATE(VENCIMENTO, INTERVAL "+contador+" DAY) WHERE PARCELA > "+count+";";

                PreparedStatement datastm = conexao.prepareStatement(datamysql);

                datastm.execute(datamysql);
            }
            updatestm.execute(update);
            prot.execute(protocolo);
            tabelaParcelas.setItems(ListarParcelas());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
            System.out.println(e);
        }
    }
    public static void fechaVendaCredito(){
        try{    
            Connection conexao = Conexao.getConexao();
            
            int contador = 30;
            
            int cont = Integer.parseInt(txtParcelas.getText());
            
            double valorParcela = Double.parseDouble(lblValorTotal.getText().replace(",", ".").replace("R$", "")) / cont;
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String dt = String.valueOf(txtVencimento.getValue()).replace("[","").replace("]","");

            Date dataD = formato.parse(dt);

            String dataFormatada = formato.format(dataD);

            String sql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, 1, "+lblValorTotal.getText().replace(",", ".").replace("R$", "")+" / "+cont+",'"+String.valueOf(txtVencimento.getValue())+"', '1');";
            
            String delete = "DELETE a FROM parcelas_credito AS a, parcelas_credito AS b WHERE a.parcela=b.parcela AND a.id < b.id AND a.STATUS = 'ABERTO';";

            String update = "UPDATE PARCELAS_CREDITO SET STATUS = 'ABERTO' WHERE STATUS <> 'CONCLUIDO';";
            
            String protocolo = "UPDATE PARCELAS_CREDITO SET PROTOCOLO = (SELECT PROTOCOLO FROM CAIXA WHERE STATUS = 'ABERTO' ORDER BY ID LIMIT 1) WHERE STATUS = 'ABERTO';";

            PreparedStatement stm = conexao.prepareStatement(sql);
            
            PreparedStatement updatestm = conexao.prepareStatement(update);

            PreparedStatement delstm = conexao.prepareStatement(delete);
            
            PreparedStatement prot = conexao.prepareStatement(protocolo);
            
            stm.execute(sql);
            
            for(int i = 1; i < cont; ++i){
                
                int parcelas = i + 1;

                String mysql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, '"+parcelas+"', "+lblValorTotal.getText().replace(",", ".").replace("R$", "")+" / "+cont+", ADDDATE('"+dataFormatada+"', INTERVAL "+contador+" DAY), 'ABERTO');";

                PreparedStatement st = conexao.prepareStatement(mysql);

                st.execute(mysql);
            }
            delstm.execute(delete);
            for(int i = 0; i < cont; ++i){

                int count = i + 1;
                
                String datamysql = "UPDATE PARCELAS_CREDITO SET VENCIMENTO = ADDDATE(VENCIMENTO, INTERVAL "+contador+" DAY) WHERE PARCELA > "+count+";";

                PreparedStatement datastm = conexao.prepareStatement(datamysql);

                datastm.execute(datamysql);
            }
            updatestm.execute(update);
            prot.execute(protocolo);
            tabelaParcelas.setItems(ListarParcelas());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
            System.out.println(e);
        }
    }

    public static void fecharVendaCredito() {
                if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){
                        fechaVendaCredito();
                }else{
                        fechaVendaCreditoDesconto();
                }
    }
    public static void btnOkCredito(){
        try{    
            Connection conexao = Conexao.getConexao();

        
            String atualizar = "update caixa set credito = "+lblValorTotal.getText().replace(",", ".").replace("R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
            String atualizar2 = "update caixa set credito = "+lblValorTotalDesconto.getText().replace(",", ".").replace("R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
            String atualizar3 = "update parcelas_credito set CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
            
            PreparedStatement atualiza = conexao.prepareStatement(atualizar);
            PreparedStatement atualiza2 = conexao.prepareStatement(atualizar2);
            PreparedStatement atualiza3 = conexao.prepareStatement(atualizar3);
                            
            if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){
                    atualiza.execute();
            }else{
                    atualiza2.execute();
            }
            atualiza3.execute();
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }

    }
    public void fechaVendaVoucher(){
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement atualiza2;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set voucher = "+lblValorTotal.getText().replace(",", ".")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
                            String atualizarQtde2 = "update caixa set voucher = "+lblValorTotalDesconto.getText().replace(",", ".")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);
                            atualiza2 = conexao.prepareStatement(atualizarQtde2);
                            
                            if(lblValorTotalDesconto.getText() == null || lblValorTotalDesconto.getText() == ""){
                                atualiza.execute();
                            }else{
                                atualiza2.execute();
                            }
                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }       
    }
    public static void deletarParcelas(){
                        PreparedStatement delete;
                        try{
                            Connection conexao = Conexao.getConexao();

                            String deletar = "delete from parcelas_credito where STATUS <> 'CONCLUIDO';";            

                            delete = conexao.prepareStatement(deletar);

                            delete.execute();
                            
                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }       
    }
    public static ObservableList<DadosParcelaVenda> dataVencimento(){
        
        ObservableList<DadosParcelaVenda> dados = FXCollections.observableArrayList();
        
        ResultSet rs;
        
        try{    
            
            Connection conexao = Conexao.getConexao();
    
            String sql = "SELECT VENCIMENTO FROM PARCELAS_CREDITO;";
            
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                int id = rs.getInt("ID");
                String valorParcela = rs.getString("VALOR_PARCELA");
                String vencimento = rs.getString("DATA_VENCIMENTO");
                
                dados.add(new DadosParcelaVenda(id, valorParcela, vencimento));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return dados;
    }
    public static ObservableList<DadosParcelaVenda> ListarParcelas(){
            
            ObservableList<DadosParcelaVenda> dados = FXCollections.observableArrayList();
            
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
        
                String sql = "SELECT PARCELA, VALOR_PARCELA, date_format(VENCIMENTO, '%d/%m/%Y') AS VENCIMENTO FROM PARCELAS_CREDITO WHERE STATUS = 'ABERTO';";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                
                rs = st.executeQuery(sql);

                while(rs.next()){
                    
                    int parcela = rs.getInt("PARCELA");
                    String valorParcela = rs.getString("VALOR_PARCELA");
                    String vencimento = rs.getString("VENCIMENTO");
                    
                    dados.add(new DadosParcelaVenda(parcela, "R$"+valorParcela.replace(".", ","), vencimento.replace("-","/")));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }
        public static ObservableList<DadosParcelaVenda> ListarParcelas2(){
            
            ObservableList<DadosParcelaVenda> dados = FXCollections.observableArrayList();
            
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
        
                String sql = "SELECT PARCELA, VALOR_PARCELA, date_format(VENCIMENTO, '%d/%m/%Y') AS VENCIMENTO FROM PARCELAS_CREDITO WHERE STATUS = 'ABERTO';";
                
                PreparedStatement st = conexao.prepareStatement(sql);
                
                rs = st.executeQuery(sql);

                while(rs.next()){
                    
                    int parcela = rs.getInt("PARCELA");
                    String valorParcela = rs.getString("VALOR_PARCELA");
                    String vencimento = rs.getString("VENCIMENTO");
                    
                    dados.add(new DadosParcelaVenda(parcela, "R$"+valorParcela.replace(".", ","), vencimento.replace("-","/")));
                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }
        public static void fechaVendaCredito2(){
        try{    
            Connection conexao = Conexao.getConexao();
            
            int contador = 30;
            
            int cont = Integer.parseInt(txtParcelas2.getText());
            
            double valorParcela = Double.parseDouble(lblRestante.getText().replace(",", ".").replace("Valor Restante: R$", "")) / cont;
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

            String dt = String.valueOf(txtVencimento2.getValue()).replace("[","").replace("]","");

            Date dataD = formato.parse(dt);

            String dataFormatada = formato.format(dataD);

            String sql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, 1, "+lblRestante.getText().replace(",", ".").replace("Valor Restante: R$", "")+" / "+cont+",'"+String.valueOf(txtVencimento2.getValue())+"', '1');";
            
            String delete = "DELETE a FROM parcelas_credito AS a, parcelas_credito AS b WHERE a.parcela=b.parcela AND a.id < b.id AND a.STATUS = 'ABERTO';";

            String update = "UPDATE PARCELAS_CREDITO SET STATUS = 'ABERTO' WHERE STATUS <> 'CONCLUIDO';";
            
            String protocolo = "UPDATE PARCELAS_CREDITO SET PROTOCOLO = (SELECT PROTOCOLO FROM CAIXA WHERE STATUS = 'ABERTO' ORDER BY ID LIMIT 1) WHERE STATUS = 'ABERTO';";

            PreparedStatement stm = conexao.prepareStatement(sql);
            
            PreparedStatement updatestm = conexao.prepareStatement(update);

            PreparedStatement delstm = conexao.prepareStatement(delete);
            
            PreparedStatement prot = conexao.prepareStatement(protocolo);
            
            stm.execute(sql);
            
            for(int i = 1; i < cont; ++i){
                
                int parcelas = i + 1;

                String mysql = "INSERT INTO PARCELAS_CREDITO(ID, PARCELA, VALOR_PARCELA, VENCIMENTO, STATUS) VALUES(default, '"+parcelas+"', "+lblRestante.getText().replace(",", ".").replace("Valor Restante: R$", "")+" / "+cont+", ADDDATE('"+dataFormatada+"', INTERVAL "+contador+" DAY), 'ABERTO');";

                PreparedStatement st = conexao.prepareStatement(mysql);

                st.execute(mysql);
            }
            delstm.execute(delete);
            for(int i = 0; i < cont; ++i){

                int count = i + 1;
                
                String datamysql = "UPDATE PARCELAS_CREDITO SET VENCIMENTO = ADDDATE(VENCIMENTO, INTERVAL "+contador+" DAY) WHERE PARCELA > "+count+";";

                PreparedStatement datastm = conexao.prepareStatement(datamysql);

                datastm.execute(datamysql);
            }
            updatestm.execute(update);
            prot.execute(protocolo);
            tabelaParcelas2.setItems(ListarParcelas2());
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
            System.out.println(e);
        }
    }

    public static void fecharVendaCredito2() {
                //if(Venda.lblValorTotalDesconto.getText() == null || Venda.lblValorTotalDesconto.getText() == ""){
                        fechaVendaCredito2();
                //}else{
                //        fechaVendaCreditoDesconto();
                //}
    }
    
    public static void fechaVendaDinheiro2(){
     //DadosProdutos data = (DadosProdutos) tabela.getSelectionModel().getSelectedItem();
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set dinheiro = "+txtEspecieRestante.getText().replace(",", ".")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);

                            atualiza.execute();

                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }   
    }
    public static void fechaVendaDebito2(){
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement atualiza2;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update caixa set debito = "+lblRestante.getText().replace(",", ".").replace("Valore Restante: R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            

                            atualiza = conexao.prepareStatement(atualizarQtde);
                            
                            atualiza.execute();
                            
                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }           
    }
    public static void btnOkCredito2(){
        try{    
            Connection conexao = Conexao.getConexao();

        
            String atualizar = "update caixa set credito = "+lblRestante.getText().replace(",", ".").replace("Valor Restante: R$", "")+", CLIENTE = 'EXTERNO', STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
            String atualizar3 = "update parcelas_credito set STATUS = 'CONCLUIDO' where STATUS = 'ABERTO';";            
            
            PreparedStatement atualiza = conexao.prepareStatement(atualizar);
            PreparedStatement atualiza3 = conexao.prepareStatement(atualizar3);
                            
            atualiza.execute();
            
            atualiza3.execute();
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }

    }
    public static void atualiza(){
                        ResultSet rs;
                        PreparedStatement stm;
                        PreparedStatement consulta;
                        PreparedStatement atualiza;
                        PreparedStatement atualiza2;
                        PreparedStatement totalstm;

                        try{
                            Connection conexao = Conexao.getConexao();

                            String atualizarQtde = "update produtos inner join caixa set produtos.estoque = produtos.estoque - caixa.qtde where caixa.STATUS = 'ABERTO' AND produtos.descricao = caixa.descricao;";            

                            atualiza = conexao.prepareStatement(atualizarQtde);
                            
                            atualiza.execute();
                            
                            conexao.close();
                        }catch(Exception e){
                            System.err.println(e);
                        }           
    }
}
