package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import static sistema.ItensNfe.bordaPaineis;
import static sistema.ItensNfe.btnCancelar;
import static sistema.ItensNfe.btnOk;
import static sistema.ItensNfe.cbFornecedor;
import static sistema.ItensNfe.cenario;
import static sistema.ItensNfe.inicio;
import static sistema.ItensNfe.lblFornecedor;
import static sistema.ItensNfe.linha1;
import static sistema.ItensNfe.linha2;
import static sistema.ItensNfe.msg;
import static sistema.ItensNfe.painelTela;

public class cargaEstoque {
    
        public static ComboBox<DadosForn> cbFornecedor;
        public static ComboBox cbTipoEntrada;
        public static Label lblFornecedor;
        public static Label lblDataEmissao;
        public static Label lblNumeroNota;
        public static Label lblTipoEntrada;
        public static Button btnOk;
        public static Button btnCancelar;
        public static Connection conexao = Conexao.getConexao();
        public static Label lblDataEntrada;
        public static VBox painelTela;
        public static HBox linha1;
        public static HBox linha2;
        public static HBox linha3;
        public static HBox linha4;
        public static HBox linha5;
        public static HBox linha6;
        public static StackPane bordaPaineis;
        public static Scene cenario;
        public static Stage inicio;
        public static DatePicker dataEmissao;
        public static TextField txtNumeroNota;
        public static Label msg;

        
        public static void show(String mensagem, String titulo){
        
                cbFornecedor = new ComboBox<DadosForn>();
                lblFornecedor = new Label("Fornecedor:   ");
                lblDataEmissao = new Label("Emissão:        ");
                lblNumeroNota = new Label("Nrº Nota:       ");
                lblTipoEntrada = new Label("Tipo Entrada: ");
                btnOk = new Button("Avançar");
                btnCancelar = new Button("Cancelar");
                bordaPaineis = new StackPane();
                painelTela = new VBox(5);
                cbTipoEntrada = new ComboBox();
                txtNumeroNota = new TextField();
                cenario = new Scene(bordaPaineis, 400, 230);
                dataEmissao = new DatePicker(LocalDate.now());
                lblDataEntrada = new Label("Data Entrada: "+String.valueOf(LocalDate.now()));
                inicio = new Stage();
                linha1 = new HBox(5);
                linha2 = new HBox(5);
                linha3 = new HBox(5);
                linha4 = new HBox(5);
                linha5 = new HBox(5);
                linha6 = new HBox(5);
                
                inicio.setScene(cenario);
                inicio.setTitle(titulo);
                inicio.initModality(Modality.APPLICATION_MODAL);
                msg = new Label(mensagem);
                
                lblFornecedor.setStyle("-fx-font-weight: bold");
                lblNumeroNota.setStyle("-fx-font-weight: bold");
                lblDataEmissao.setStyle("-fx-font-weight: bold");
                lblTipoEntrada.setStyle("-fx-font-weight: bold");
                btnOk.setGraphic(Login.imageViewOkEstoque);
                btnCancelar.setGraphic(Login.imageViewCancelarEstoque);
                
                btnOk.setOnAction(e -> {
                    if(AcessarPagina().isEmpty() == true){
                        carga.show("", "Adicionar Itens");
                    }else{
                        confirmacaoAcessoEntrada.show("nota já existente, deseja acessá-lo?", "Confirmação de acesso");
                    }        
                });
                btnOk.setOnKeyPressed(evt -> {
                    if(btnOk.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        if(AcessarPagina().isEmpty() == true){
                            carga.show("", "Adicionar Itens");
                        }else{
                            confirmacaoAcessoEntrada.show("nota já existente, deseja acessá-lo?", "Confirmação de acesso");
                        }        
                    }
                });
                btnCancelar.setOnAction(e -> inicio.close());
                btnCancelar.setOnKeyPressed(evt -> {
                    if(btnCancelar.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        inicio.close();
                    }
                });
                cbFornecedor.setConverter(new StringConverter<DadosForn>() {
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
                cbFornecedor.setPrefWidth(186);
                cbFornecedor.getItems().addAll(Produto.ListaFornecedores());
                
                bordaPaineis.setPadding(new Insets(5));
                bordaPaineis.setStyle("-fx-border-radius: 2; -fx-padding: -8 5 5 5; -fx-border-insets: 8 15 15 15; -fx-border-color: gray;");
                bordaPaineis.setAlignment(msg, Pos.TOP_LEFT);
                
                cbTipoEntrada.getItems().addAll("Compra", "Acerto", "Bonificação", "Outros");
                
                msg.setStyle("-fx-background-color: #F4F4F4");
                   
                txtNumeroNota.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.TAB){
                        int numero = Integer.parseInt(txtNumeroNota.getText());
                        txtNumeroNota.setText(String.format("%011d", numero));
                    }
                    if(txtNumeroNota.getText().length() > 11){
                            MessageBox.show("Quantidade de caracteres maior que 11 dígitos" ,"Erro");
                    }
                });
       
                bordaPaineis.getChildren().addAll(msg, painelTela);
                linha1.getChildren().addAll(lblFornecedor, cbFornecedor);
                linha1.setPadding(new Insets(5));
                linha2.setPadding(new Insets(5));
                linha2.getChildren().addAll(lblNumeroNota, txtNumeroNota);
                linha3.setPadding(new Insets(5));
                linha3.getChildren().addAll(lblDataEmissao,dataEmissao);
                linha4.setPadding(new Insets(5));
                linha4.getChildren().addAll(lblTipoEntrada,cbTipoEntrada);
                linha6.setPadding(new Insets(5));
                linha6.setAlignment(Pos.BASELINE_RIGHT);
                linha6.getChildren().addAll(btnOk, btnCancelar);
                painelTela.setPadding(new Insets(15));
                painelTela.getChildren().addAll(linha1,linha2,linha3,linha4,linha5,linha6);
                inicio.showAndWait();
    }

    public static ObservableList<DadosEstoqueAdd> AcessarPagina(){
        
            DadosForn fornecedor = cbFornecedor.getSelectionModel().getSelectedItem();
            ObservableList<DadosEstoqueAdd> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM ENTRADA WHERE FORNECEDOR = '"+fornecedor.getRazaoSocial()+"' AND NR_NOTA = "+Integer.parseInt(txtNumeroNota.getText())+";";
            
            try{
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                            int id = rs.getInt("ID");
                            String descricao = rs.getString("DESCRICAO");
                            String qtde = rs.getString("QTDE");
                            String barras = rs.getString("COD_BARRAS");
                            String custo = rs.getString("CUSTO");
                            String subtotal = rs.getString("SUBTOTAL");
                            int nr_nota = rs.getInt("NR_NOTA");
                            
                            dados.add(new DadosEstoqueAdd(id, descricao, qtde, barras, custo, subtotal, nr_nota));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }

    
    public static void AddProtocolo(){
    
        try{    
                DadosForn fornecedor = cbFornecedor.getSelectionModel().getSelectedItem();
                Connection conexao = Conexao.getConexao();
                String add = "insert into entrada_estoque(id, RAZAO_SOCIAL_DEST) value(default, '"+fornecedor.getRazaoSocial()+"');";
                PreparedStatement statement = conexao.prepareStatement(add);
                statement.execute(add);
        }catch(Exception e){
                MessageBox.show(""+e,"Erro");
        }
    }
}
    
