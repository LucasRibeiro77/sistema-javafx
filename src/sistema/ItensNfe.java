package sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import javafx.util.StringConverter;

public class ItensNfe {
    
    public static ComboBox<DadosForn> cbFornecedor;
    public static Label lblFornecedor;
    public static Button btnOk;
    public static Button btnCancelar;
    public static Connection conexao = Conexao.getConexao();
    
    public static VBox painelTela;
    public static HBox linha1;
    public static HBox linha2;
    public static HBox linha3;
    public static HBox linha4;
    public static HBox linha5;
    
    public static StackPane bordaPaineis;
    public static Scene cenario;
    public static Stage inicio;
    
    public static Label msg;
    public static Label lblTipoNFe;
    public static Label lblFinalidadeNFe;
    public static Label lblSerie;
    public static ComboBox cbTipoNFe;
    public static ComboBox cbFinalidadeNFe;
    public static TextField txtSerie;
    
    public static void show(String mensagem, String titulo){
                        
                cbTipoNFe = new ComboBox();
                cbFinalidadeNFe = new ComboBox();
                txtSerie = new TextField();
                lblSerie = new Label();
                cbFornecedor = new ComboBox<DadosForn>();
                lblFornecedor = new Label("Destinatário:    ");
                lblTipoNFe = new Label("Nota Fiscal de: ");
                lblFinalidadeNFe = new Label("Finalidade:     ");
                btnOk = new Button("Ok");
                btnCancelar = new Button("Cancelar");
                bordaPaineis = new StackPane();
                painelTela = new VBox(5);
                cenario = new Scene(bordaPaineis, 370, 200);
                inicio = new Stage();
                linha1 = new HBox(5);
                linha2 = new HBox(5);
                linha3 = new HBox(5);
                linha4 = new HBox(5);
                linha5 = new HBox(5);
                
                inicio.setScene(cenario);
                inicio.setTitle(titulo);
                inicio.initModality(Modality.APPLICATION_MODAL);
                msg = new Label(mensagem);
                
                lblFornecedor.setStyle("-fx-font-weight: bold");
                lblTipoNFe.setStyle("-fx-font-weight: bold");
                lblFinalidadeNFe.setStyle("-fx-font-weight: bold");
                lblSerie.setStyle("-fx-font-weight: bold");
                cbFinalidadeNFe.getItems().addAll("Normal", "Complementar", "Ajuste", "Devolução");
                cbTipoNFe.getItems().addAll("Entrada", "Saida");
                txtSerie.setPrefWidth(80);
               // btnOk.setOnAction(e -> ItensNFeAdd.show("", "Adicionar Itens"));
                btnOk.setOnAction(e -> {
                    if(AcessarPagina().isEmpty() == true){
                        AddProtocolo();
                        ItensNFeAdd.show("", "Adicionar Itens");
                    }else{
                        confirmacaoAcesso.show("Protocolo já existente, deseja acessá-lo?", "Confirmação de acesso");
                        ItensNFeAdd.show("", "Adicionar Itens");
                    }        
                });
               /* btnOk.setOnKeyPressed(evt -> {
                    if(btnOk.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        ItensNFeAdd.show("", "Adicionar Itens");
                    }
                });*/
                btnOk.setOnKeyPressed(evt -> {
                    if(btnOk.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        if(AcessarPagina().isEmpty() == true){
                            AddProtocolo();
                            ItensNFeAdd.show("", "Adicionar Itens");
                        }else{
                            confirmacaoAcesso.show("Protocolo já existente, deseja acessá-lo?", "Confirmação de acesso");
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
                
                lblSerie.setText("Série:                ");
                
                bordaPaineis.setPadding(new Insets(5));
                bordaPaineis.setStyle("-fx-border-radius: 2; -fx-padding: -8 5 5 5; -fx-border-insets: 8 15 15 15; -fx-border-color: gray;");
                bordaPaineis.setAlignment(msg, Pos.TOP_LEFT);
                
                msg.setStyle("-fx-background-color: #F4F4F4");
                
                bordaPaineis.getChildren().addAll(msg,painelTela);
                linha1.getChildren().addAll(lblFornecedor, cbFornecedor);
                linha1.setPadding(new Insets(5));
                linha2.setPadding(new Insets(5));
                linha2.setAlignment(Pos.BASELINE_LEFT);
                linha2.getChildren().addAll(btnOk, btnCancelar);
                linha3.setPadding(new Insets(5));
                linha3.setAlignment(Pos.BASELINE_LEFT);
                linha3.getChildren().addAll(lblTipoNFe,cbTipoNFe);
                linha4.setPadding(new Insets(5));
                linha4.setAlignment(Pos.BASELINE_LEFT);
                linha4.getChildren().addAll(lblSerie,txtSerie);
                linha5.setAlignment(Pos.BASELINE_LEFT);
                linha5.getChildren().addAll(lblFinalidadeNFe,cbFinalidadeNFe);
                painelTela.setPadding(new Insets(15));
                painelTela.getChildren().addAll(linha1, linha3, linha4, linha5, linha2);
                
                inicio.showAndWait();
    }
/*    public static boolean AcessarPagina(){
            int cont = 0;
            boolean verificador = false;
    
        try {
            String sql = "SELECT COUNT(*) AS cont FROM nfe WHERE RAZAO_SOCIAL_EMIT = '"+cbFornecedor.getValue()+"';";
            String consulta = "SELECT * FROM nfe WHERE RAZAO_SOCIAL_EMIT = '"+cbFornecedor.getValue()+"';";
            String add = "insert into nfe(id) value('default');";
            PreparedStatement stm = conexao.prepareStatement(sql);
            PreparedStatement state = conexao.prepareStatement(consulta);
            PreparedStatement statement = conexao.prepareStatement(add);
            ResultSet rs = stm.executeQuery(sql);
            ResultSet resultado = state.executeQuery(consulta);
            
            while(rs.next()){
                cont = rs.getInt("cont");
            }
            if(cont == 1){
                verificador = true;
                while(resultado.next()){                  
                            ItensNFeAdd.show("", "Adicionar Itens");
                }
                inicio.close();
                } else{
                            statement.executeQuery(add);
                            ItensNFeAdd.show("", "Adicionar Itens");
            }
        } catch(Exception ex) {
            MessageBox.show(""+ex,"Erro");
        }
        return verificador;
    
    }
*/

    public static ObservableList<DadosDestNFe> AcessarPagina(){
            
            ObservableList<DadosDestNFe> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM nfe WHERE RAZAO_SOCIAL_EMIT = '"+cbFornecedor.getValue()+"' OR id >= 1;";
            
            try{
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                                        
                    dados.add(new DadosDestNFe(id));
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
                String add = "insert into nfe(id, RAZAO_SOCIAL_DEST) value(default, '"+fornecedor.getRazaoSocial()+"');";
                PreparedStatement statement = conexao.prepareStatement(add);
                statement.execute(add);
        }catch(Exception e){
                MessageBox.show(""+e,"Erro");
        }
    }
}
