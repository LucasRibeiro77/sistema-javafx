package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.collections.*;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import javafx.util.*;
import javafx.util.converter.*;
import javafx.event.*;
import javafx.beans.property.*;
import static sistema.carga.Totalizadores;

public class concluirEstoque extends DateStringConverter {
    
    public static Stage inicio;
    public static VBox painelPrincipal;
    public static VBox painelBotoesVertical;
    public static Scene cenario;
    public static HBox linha1;
    public static HBox linha2;
    public static HBox linha3;
    public static HBox linha4;
    public static HBox linha5;
    public static HBox linha6;
    public static HBox linhaParcela;
    public static TableView<DadosContasPagar> tabela;
    public static TableColumn<DadosContasPagar, String> colunaDataEmissao;
    public static TableColumn<DadosContasPagar, Integer> colunaParcela;
    public static TableColumn<DadosContasPagar, Double> colunaValorBoleto;
    public static TableColumn<DadosContasPagar, String> colunaDataVencimento;
    public static CheckBox chkPago;
    public static ComboBox cbFavorecido;
    public static DatePicker txtDataEmissao;
    public static DatePicker txtDataVencimento;
    public static DatePicker txtDataPagamento;
    public static TextField txtDescAbatimento;
    public static TextField txtJurosMulta;
    public static TextField txtValorBoleto;
    public static TextField txtParcelas;
    public static TextField txtIntervalo;
    public static TextField txtValorCobradoTabela;
    public static DatePicker txtVencimentoTabela;
    public static ComboBox cbFormaPagamento;
    public static TextField txtLocalPagamento;
    public static Label lblDataEmissao;
    public static Label lblDataVencimento;
    public static Label lblDataPagamento;
    public static Label lblPago;
    public static Label lblDescAbatimento;
    public static Label lblJurosMulta;
    public static Label lblValorBoleto;
    public static Label lblFormaPagamento;
    public static Label lblLocalPagamento;
    public static Label lblFavorecido;
    public static Label lblParcelas;
    public static Label lblIntervalo;
    public static Button btnOK;
    public static Button btnCancelar;
    public static Button btnEditar;
    public static Button btnAlterar;
    public static Button btnCancel;
    public static String dataEmUmFormato;
    public static SimpleDateFormat formato;
    public static Date dataD;
    public static String dataFormatadaVencimento;
    
    public static void show(String mensagem, String titulo){
        
            inicio = new Stage();
            painelPrincipal = new VBox(5);
            painelBotoesVertical = new VBox(5);
            cenario = new Scene(painelPrincipal, 950, 510);
            linha1 = new HBox(2);
            linha2 = new HBox(2);
            linha3 = new HBox(2);
            linha4 = new HBox(5);
            linha5 = new HBox(5);
            linha6 = new HBox(5);
            linhaParcela = new HBox(5);
            tabela = new TableView<DadosContasPagar>();
            txtDataEmissao = new DatePicker();
            txtDataVencimento = new DatePicker();
            txtDataPagamento = new DatePicker();
            colunaDataEmissao = new TableColumn<DadosContasPagar, String>("Emissão");
            colunaDataEmissao.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("dataBoleto"));
            colunaParcela = new TableColumn<DadosContasPagar, Integer>("Parcela");
            colunaParcela.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, Integer>("parcela"));
            colunaValorBoleto = new TableColumn<DadosContasPagar, Double>("Valor");
            colunaValorBoleto.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, Double>("valorCobrado"));
            colunaDataVencimento = new TableColumn<DadosContasPagar, String>("Vencimento");
            colunaDataVencimento.setCellValueFactory(new PropertyValueFactory<DadosContasPagar, String>("dataVencimento"));
            cbFavorecido = new ComboBox();
            chkPago = new CheckBox();
            txtDescAbatimento = new TextField();
            txtJurosMulta = new TextField();
            txtParcelas = new TextField();
            txtIntervalo = new TextField();
            txtValorBoleto = new TextField();
            txtValorCobradoTabela = new TextField();
            txtVencimentoTabela = new DatePicker();
            cbFormaPagamento = new ComboBox();
            txtLocalPagamento = new TextField();
            lblDataEmissao = new Label("Emissão                 ");
            lblDataVencimento = new Label("      Vencimento ");
            lblDataPagamento = new Label("Pagamento           ");
            lblPago = new Label("Pago");
            lblDescAbatimento = new Label("Desc/Abatimento");
            lblJurosMulta = new Label("Juros/Multa  ");
            lblValorBoleto = new Label("Valor Boleto");
            lblFormaPagamento = new Label("Forma Pagamento  ");
            lblLocalPagamento = new Label("Local Pagamento  ");
            lblFavorecido = new Label("Favorecido            ");
            lblParcelas = new Label("Parcelas");
            lblIntervalo = new Label("Interv.");
            Label msg = new Label(mensagem);
            btnOK = new Button("Concluir");
            btnCancelar = new Button("Cancelar");
            btnAlterar = new Button("Alterar");
            btnEditar = new Button("Editar");
            btnCancel = new Button("Cancelar");
            cbFavorecido.setItems(ContasPagar.ListarBancos());
            lblDataEmissao.setStyle("-fx-font-weight: bold");
            lblFavorecido.setStyle("-fx-font-weight: bold");
            lblDescAbatimento.setStyle("-fx-font-weight: bold");
            lblJurosMulta.setStyle("-fx-font-weight: bold");
            lblValorBoleto.setStyle("-fx-font-weight: bold");
            lblPago.setStyle("-fx-font-weight: bold");
            lblParcelas.setStyle("-fx-font-weight: bold");
            lblIntervalo.setStyle("-fx-font-weight: bold");
            lblDataPagamento.setStyle("-fx-font-weight: bold");            
            lblFormaPagamento.setStyle("-fx-font-weight: bold");
            lblLocalPagamento.setStyle("-fx-font-weight: bold");            
            lblDataVencimento.setStyle("-fx-font-weight: bold");            
            txtValorCobradoTabela.setPrefWidth(100);
            btnEditar.setPrefWidth(80);
            btnCancel.setPrefWidth(80);
            
            inicio.setScene(cenario);
            inicio.setTitle(titulo);
            inicio.initModality(Modality.APPLICATION_MODAL);
            
            cbFormaPagamento.getItems().addAll("DINHEIRO", "DEBITO", "DEPOSITO", "CHEQUE", "INTERNET BANK", "CREDITO", "OUTROS");
            
            cbFavorecido.setConverter(new StringConverter<DadosBancos>() {
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
            linhaParcela.setVisible(false);
            btnOK.setGraphic(Login.imageViewOk);
            btnCancelar.setGraphic(Login.imageViewCancelar);
            txtDataEmissao.setValue(LocalDate.now());
            txtDataVencimento.setValue(LocalDate.now());
            txtDataPagamento.setValue(LocalDate.now());
            txtDescAbatimento.setText("0,00");
            txtJurosMulta.setText("0,00");
            txtValorBoleto.setText(String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(".",","));
            txtJurosMulta.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.TAB){
                    double resultado = Double.parseDouble(String.valueOf(Totalizadores()).replace("[", "").replace("]", "").replace(",",".")) - Double.parseDouble(txtDescAbatimento.getText().replace(",",".")) + Double.parseDouble(txtJurosMulta.getText().replace(",","."));
                    txtValorBoleto.setText(String.valueOf(resultado).replace(".",","));
                }
            });
            txtDataPagamento.setPrefWidth(100);
            txtDataVencimento.setPrefWidth(100);
            cbFormaPagamento.setPrefWidth(100);
            txtParcelas.setPrefWidth(50);
            txtIntervalo.setPrefWidth(50);
            linha3.setVisible(false);            
            linha4.setVisible(false);            
            txtParcelas.setText("1");
            chkPago.setOnAction(e -> {
                if(chkPago.isSelected() == true){
                    linha3.setVisible(true);
                    txtParcelas.setText("1");
                    txtIntervalo.setText("0");
                    linha4.setVisible(false);
                    deleteParcelas();
                }else{
                    linha3.setVisible(false);
                    txtParcelas.clear();
                    txtIntervalo.clear();
                    linha4.setVisible(false);
                    deleteParcelas();
                }
            });
            chkPago.setOnKeyPressed(e -> {
                if(e.getCode() == KeyCode.TAB){
                    int cont = Integer.parseInt(txtParcelas.getText());
                    if( cont > 1){
                        linhaParcela.setVisible(true);
                        linha4.setVisible(true);
                        try {
                            inserirParcelas();
                        } catch (ParseException ex) {
                            Logger.getLogger(concluirEstoque.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        deleteLinha();
                        tabela.setItems(ListarParcelas());
                    }
                }
            });
            btnOK.setOnAction(e -> {
                if(chkPago.isSelected() == false && Integer.parseInt(txtParcelas.getText()) == 1){
                    ConcluirEntrada();
                    System.out.println("Resultado: "+String.valueOf(txtDataVencimento.getValue())+" "+String.valueOf(cargaEstoque.dataEmissao.getValue())+" "+String.valueOf(txtVencimentoTabela.getValue()));
                }else if(chkPago.isSelected() == false && Integer.parseInt(txtParcelas.getText()) > 1){
                    ConcluirEntrada3();
                    deleteLinha();
                }else if(Integer.parseInt(txtParcelas.getText()) == 1){
                    ConcluirEntrada2();
                }
                carga.cbFornecedor.setValue(null);
                carga.txtNumeroNota.clear();
                carga.dataEmissao.setValue(LocalDate.now());
                carga.cbTipoEntrada.setValue(null);
                carga.init.close();
                inicio.close();
            });
            btnEditar.setOnAction(e -> {
                DadosContasPagar dados = tabela.getSelectionModel().getSelectedItem();
                
                btnEditar.setDisable(true);
                btnCancel.setDisable(false);
                btnAlterar.setDisable(false);
    
                tabela.setDisable(true);
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                
                txtValorCobradoTabela.setDisable(false);
                txtVencimentoTabela.setDisable(false);
                
                txtValorCobradoTabela.setText(String.valueOf(dados.getValorCobrado()).replace(".",","));
                txtVencimentoTabela.setValue(LocalDate.parse(dados.getDataVencimento(), formatter));
            });
            btnCancel.setOnAction(e -> CancelarTabela());
            
            btnEditar.setDisable(false);
            btnCancel.setDisable(true);
            btnAlterar.setDisable(true);
            
            btnCancelar.setOnAction(e -> inicio.close());
            btnAlterar.setOnAction(e -> btnAlterar());
            txtValorCobradoTabela.setDisable(true);
            txtVencimentoTabela.setDisable(true);
            tabela.getColumns().addAll(colunaDataEmissao, colunaParcela, colunaValorBoleto, colunaDataVencimento);
            
            linha1.setPadding(new Insets(15));
            linha1.getChildren().addAll(lblFavorecido, cbFavorecido, lblDataVencimento, txtDataVencimento);
            linha2.setPadding(new Insets(15));
            linha2.getChildren().addAll(lblDescAbatimento, txtDescAbatimento, lblJurosMulta, txtJurosMulta, lblValorBoleto, txtValorBoleto, lblParcelas, txtParcelas, lblIntervalo, txtIntervalo, lblPago, chkPago);
            linha3.setPadding(new Insets(15));
            linha3.getChildren().addAll(lblDataPagamento, txtDataPagamento, lblFormaPagamento, cbFormaPagamento, lblLocalPagamento, txtLocalPagamento);
            linhaParcela.setPadding(new Insets(15));
            linhaParcela.getChildren().addAll(txtValorCobradoTabela, txtVencimentoTabela, btnAlterar);
            painelBotoesVertical.getChildren().addAll(btnEditar, btnCancel);
            linha4.setPadding(new Insets(15));
            linha4.getChildren().addAll(tabela, painelBotoesVertical);
            linha5.setPadding(new Insets(15));
            linha5.setAlignment(Pos.CENTER);
            linha5.getChildren().addAll(btnOK, btnCancelar);
            painelPrincipal.getChildren().addAll(linha1, linha2, linha3, linhaParcela,linha4, linha5);
            inicio.showAndWait();
    }

    public static ObservableList<DadosParcelas> dataVencimento(){
        
        ObservableList<DadosParcelas> dados = FXCollections.observableArrayList();
        
        ResultSet rs;
        
        try{    
            DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
            
            Connection conexao = Conexao.getConexao();
    
            String sql = "SELECT DATA_VENCIMENTO FROM CONTASPAGAR WHERE NR_DOCUMENTO = "+cargaEstoque.txtNumeroNota.getText()+" AND DESCRICAO = '"+fornecedor.getRazaoSocial()+"' ORDER BY ID DESC limit 1;";
            
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                String vencimento = rs.getString("DATA_VENCIMENTO");
                
                dados.add(new DadosParcelas(vencimento));
            }
            
        }catch(Exception e){
            System.out.println(e);
        }
        return dados;
    }
    public static void inserirParcelas() throws ParseException{

    try{    
        Connection conexao = Conexao.getConexao();
        
        DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
        DadosForn forn = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
        DadosBancos favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();
        
        int cont = Integer.parseInt(txtParcelas.getText());
        
        int contador = Integer.parseInt(txtIntervalo.getText());
        
        String sql = "INSERT INTO CONTASPAGAR(ID, NR_DOCUMENTO, DESCRICAO, ESPECIE_DOCUMENTO, MOEDA, DATA_BOLETO, DATA_VENCIMENTO, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, STATUS, BENEFICIARIO, USUARIO, PARCELA) VALUES(default, '"+cargaEstoque.txtNumeroNota.getText()+"', '"+fornecedor.getRazaoSocial()+"','Boleto','REAL','"+cargaEstoque.dataEmissao.getValue()+"','"+txtDataVencimento.getValue()+"',"+txtJurosMulta.getText().replace(",",".")+","+txtDescAbatimento.getText().replace(",",".")+","+String.valueOf(carga.Totalizadores()).replace("[","").replace("]","").replace(",",".")+","+txtValorBoleto.getText().replace(",",".")+" / "+txtParcelas.getText()+",'Em aberto','"+favorecido.getNomeBanco()+"','"+Login.campo1.getText()+"',1);";
        
        String delete = "DELETE FROM CONTASPAGAR WHERE NR_DOCUMENTO = "+cargaEstoque.txtNumeroNota.getText()+" AND DESCRICAO = '"+fornecedor.getRazaoSocial()+"';";
        String deletar = "DELETE FROM CONTASPAGAR WHERE NR_DOCUMENTO = "+cargaEstoque.txtNumeroNota.getText()+" AND DESCRICAO = '"+forn.getRazaoSocial()+"' AND VALOR_COBRADO = "+txtValorBoleto.getText()+";";

        PreparedStatement del = conexao.prepareStatement(deletar);                                    
        PreparedStatement stm = conexao.prepareStatement(sql);
        
        PreparedStatement delstm = conexao.prepareStatement(delete);
        
        delstm.execute(delete);
        
        stm.execute(sql);
        
        for(int i = 1; i < cont; i++){
            
            int parcelas = i + 1;
            
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
        
            String dt = String.valueOf(dataVencimento()).replace("[","").replace("]","");

            Date dataD = formato.parse(dt);

            String dataFormatada = formato.format(dataD);

            String mysql = "INSERT INTO CONTASPAGAR(ID, NR_DOCUMENTO, DESCRICAO, ESPECIE_DOCUMENTO, MOEDA, DATA_BOLETO, DATA_VENCIMENTO, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, STATUS, BENEFICIARIO, USUARIO, PARCELA) VALUES(default, '"+cargaEstoque.txtNumeroNota.getText()+"', '"+fornecedor.getRazaoSocial()+"','Boleto','REAL','"+String.valueOf(cargaEstoque.dataEmissao.getValue())+"', ADDDATE('"+String.valueOf(dataVencimento()).replace("[","").replace("]","")+"', INTERVAL "+contador+" DAY),"+txtJurosMulta.getText().replace(",",".")+","+txtDescAbatimento.getText().replace(",",".")+","+String.valueOf(carga.Totalizadores()).replace("[","").replace("]","").replace(",",".")+","+txtValorBoleto.getText().replace(",",".")+" / "+txtParcelas.getText()+",'Em aberto','"+favorecido.getNomeBanco()+"','"+Login.campo1.getText()+"',"+parcelas+");";

            PreparedStatement st = conexao.prepareStatement(mysql);

            st.execute(mysql);
        }
        deleteLinha();
    }catch(SQLException e){
        MessageBox.show(""+e, "Erro");
        System.out.println(e);
    }
    }
    public static ObservableList<DadosContasPagar> ListarParcelas(){
            
            ObservableList<DadosContasPagar> dados = FXCollections.observableArrayList();
            
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();

                String sql = "SELECT ID, NR_DOCUMENTO, DESCRICAO, BENEFICIARIO, date_format(DATA_BOLETO, '%d/%m/%Y') AS DATA_BOLETO, date_format(DATA_VENCIMENTO, '%d/%m/%Y') AS DATA_VENCIMENTO, FORMA_PAGAMENTO, date_format(DATA_PAGAMENTO, '%d/%m/%Y') AS DATA_PAGAMENTO, ESPECIE_DOCUMENTO, MOEDA, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, LOCAL_PAGAMENTO, COD_BARRAS, STATUS, USUARIO, PARCELA FROM CONTASPAGAR WHERE NR_DOCUMENTO = "+cargaEstoque.txtNumeroNota.getText()+" AND DESCRICAO = '"+fornecedor.getRazaoSocial()+"';";

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
                    
                    dados.add(new DadosContasPagar(id, nrDocumento, descricao, especieDocumento, moeda, dataBoleto, dataVencimento, dataPagamento,  formaPagamento, jurosMulta, descontoAbatimento, valorBoleto, "R$"+String.format("%.02f", valorCobrado).replace(".",","), localPagamento, codBarras, status, beneficiario, usuario, parcela));

                }
            }catch(Exception e){
                System.out.println(e);
            }
            return dados;
        }
    public static void deleteParcelas(){
        
        try{    
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
                DadosBancos favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();

                String delete = "DELETE FROM CONTASPAGAR WHERE NR_DOCUMENTO = "+cargaEstoque.txtNumeroNota.getText()+" AND DESCRICAO = '"+fornecedor.getRazaoSocial()+"';";

                PreparedStatement delstm = conexao.prepareStatement(delete);

                delstm.execute(delete);

        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }    
    }
    public static void deleteLinha(){
        
        try{    
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();

                String delete = "DELETE FROM CONTASPAGAR WHERE NR_DOCUMENTO = '"+cargaEstoque.txtNumeroNota.getText()+"' AND DESCRICAO = '"+fornecedor.getRazaoSocial()+"' AND VALOR_COBRADO = "+txtValorBoleto.getText().replace(",",".")+";";

                PreparedStatement delstm = conexao.prepareStatement(delete);

                delstm.execute(delete);

        }catch(Exception e){
            System.err.println(e);
        }    
    }
    
    public static void deletarQtde(){
        
        try{    
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
                DadosBancos favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();

                String sql = "UPDATE PRODUTOS INNER JOIN ENTRADA SET PRODUTOS.ESTOQUE = PRODUTOS.ESTOQUE - ENTRADA.QTDE WHERE PRODUTOS.DESCRICAO = ENTRADA.DESCRICAO AND PRODUTOS.ID = ENTRADA.CODIGO_ITEM;";

                PreparedStatement stm = conexao.prepareStatement(sql);

                stm.execute(sql);

        }catch(Exception e){
            System.err.println(e);
        }    
    }
    
    public static void ConcluirEntrada(){
        
        DadosForn fornecedor;
        DadosBancos favorecido;
        
        try{    
                Connection conexao = Conexao.getConexao();

                fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
                favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();

                String sql = "INSERT INTO CONTASPAGAR(ID, NR_DOCUMENTO, DESCRICAO, ESPECIE_DOCUMENTO, MOEDA, DATA_BOLETO, DATA_VENCIMENTO, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, STATUS, BENEFICIARIO, USUARIO, PARCELA) VALUES(default, '"+cargaEstoque.txtNumeroNota.getText()+"', '"+fornecedor.getRazaoSocial()+"','Boleto','REAL','"+String.valueOf(cargaEstoque.dataEmissao.getValue())+"','"+String.valueOf(txtDataVencimento.getValue())+"',"+txtJurosMulta.getText().replace(",",".")+","+txtDescAbatimento.getText().replace(",",".")+","+String.valueOf(carga.Totalizadores()).replace("[","").replace("]","").replace(",",".")+","+txtValorBoleto.getText().replace(",",".")+",'Em aberto','"+favorecido.getNomeBanco()+"','"+Login.campo1.getText()+"', 1);";
                String sqlentrada = "UPDATE PRODUTOS INNER JOIN ENTRADA SET PRODUTOS.ESTOQUE = PRODUTOS.ESTOQUE + ENTRADA.QTDE WHERE PRODUTOS.DESCRICAO = ENTRADA.DESCRICAO AND PRODUTOS.ID = ENTRADA.CODIGO_ITEM AND NR_NOTA = '"+cargaEstoque.txtNumeroNota.getText()+"';";
                
                PreparedStatement stm = conexao.prepareStatement(sql);
                PreparedStatement stmentrada = conexao.prepareStatement(sqlentrada);

                stmentrada.execute(sqlentrada);
                stm.execute(sql);
                

        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
        fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
                favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();
        System.out.println("default, '"+cargaEstoque.txtNumeroNota.getText()+"', '"+fornecedor.getRazaoSocial()+"','Boleto','REAL','"+String.valueOf(cargaEstoque.dataEmissao.getValue())+"','"+String.valueOf(txtDataVencimento.getValue())+"',"+txtJurosMulta.getText().replace(",",".")+","+txtDescAbatimento.getText().replace(",",".")+","+String.valueOf(carga.Totalizadores()).replace("[","").replace("]","")+","+txtValorBoleto.getText().replace(",",".")+",'Em aberto','"+favorecido.getNomeBanco()+"','"+Login.campo1.getText()+"', 1);");
    }
    public static void ConcluirEntrada2(){
        
        try{    
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();
                DadosBancos favorecido = (DadosBancos) cbFavorecido.getSelectionModel().getSelectedItem();

                String mysql = "INSERT INTO CONTASPAGAR(ID, NR_DOCUMENTO, DESCRICAO, ESPECIE_DOCUMENTO, MOEDA, DATA_BOLETO, DATA_VENCIMENTO, JUROS_MULTA, DESCONTO_ABATIMENTO, VALOR_BOLETO, VALOR_COBRADO, STATUS, BENEFICIARIO, USUARIO, PARCELA, DATA_PAGAMENTO, FORMA_PAGAMENTO, LOCAL_PAGAMENTO) VALUES(default, '"+cargaEstoque.txtNumeroNota.getText()+"', '"+fornecedor.getRazaoSocial()+"','Boleto','REAL','"+String.valueOf(cargaEstoque.dataEmissao.getValue())+"','"+String.valueOf(txtDataVencimento.getValue())+"',"+txtJurosMulta.getText().replace(",",".")+","+txtDescAbatimento.getText().replace(",",".")+","+String.valueOf(carga.Totalizadores()).replace("[","").replace("]","").replace(",",".")+","+txtValorBoleto.getText().replace(",",".")+",'Pago','"+favorecido.getNomeBanco()+"','"+Login.campo1.getText()+"',1,'"+String.valueOf(txtDataPagamento.getValue())+"', '"+String.valueOf(cbFormaPagamento.getValue())+"','"+txtLocalPagamento.getText()+"');";
                String sqli = "UPDATE PRODUTOS INNER JOIN ENTRADA SET PRODUTOS.ESTOQUE = PRODUTOS.ESTOQUE + ENTRADA.QTDE WHERE PRODUTOS.DESCRICAO = ENTRADA.DESCRICAO AND PRODUTOS.ID = ENTRADA.CODIGO_ITEM AND NR_NOTA = '"+cargaEstoque.txtNumeroNota.getText()+"';";
                
                PreparedStatement stmi = conexao.prepareStatement(sqli);
                PreparedStatement st = conexao.prepareStatement(mysql);

                stmi.execute(sqli);
                st.execute(mysql);

        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }
    }
    
    public static void ConcluirEntrada3(){
        
        try{    
                Connection conexao = Conexao.getConexao();

                DadosForn fornecedor = cargaEstoque.cbFornecedor.getSelectionModel().getSelectedItem();

                String sqlentr = "UPDATE PRODUTOS INNER JOIN ENTRADA SET PRODUTOS.ESTOQUE = PRODUTOS.ESTOQUE + ENTRADA.QTDE WHERE PRODUTOS.DESCRICAO = ENTRADA.DESCRICAO AND PRODUTOS.ID = ENTRADA.CODIGO_ITEM AND NR_NOTA = '"+cargaEstoque.txtNumeroNota.getText()+"';";
             
                PreparedStatement stmentr = conexao.prepareStatement(sqlentr);
                stmentr.execute(sqlentr);
        
        }catch(Exception e){
            MessageBox.show(""+e, "Erro");
        }

    }
    public static void btnAlterar() {

            DadosContasPagar data = tabela.getSelectionModel().getSelectedItem();

            try{
                Connection conexao = Conexao.getConexao();
                String sql = "UPDATE CONTASPAGAR SET DATA_VENCIMENTO = '"+String.valueOf(txtVencimentoTabela.getValue())+"', VALOR_COBRADO = "+txtValorCobradoTabela.getText().replace(",",".")+" WHERE PARCELA = "+data.getParcela()+" AND DESCRICAO = '"+data.getDescricao()+"' AND NR_DOCUMENTO = '"+data.getNrDocumento()+"';";
                PreparedStatement stm = conexao.prepareStatement(sql);
                stm.execute(sql);
                
                txtValorCobradoTabela.setDisable(true);
                txtVencimentoTabela.setDisable(true);
                
                txtValorCobradoTabela.clear();
                
                tabela.setItems(ListarParcelas());
                tabela.setDisable(false);
                
                btnEditar.setDisable(false);
                btnCancel.setDisable(true);
                btnAlterar.setDisable(true);
                
            }catch(Exception ex){
                System.err.println(ex);
            }

    }
    public static void CancelarTabela() {
        
                btnEditar.setDisable(false);
                btnCancel.setDisable(true);
                btnAlterar.setDisable(true);

                tabela.setDisable(false);
                
                txtValorCobradoTabela.setDisable(true);
                txtVencimentoTabela.setDisable(true);
                
                txtValorCobradoTabela.clear();
                txtVencimentoTabela.setValue(null);
    }
    
}
