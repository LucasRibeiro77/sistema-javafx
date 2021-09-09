package sistema;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.control.TableColumn.*;
import javafx.scene.control.TableCell.*;
import javafx.scene.control.TableView.*;
import javafx.event.*;
import javafx.geometry.*;
import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.cell.PropertyValueFactory;

public class cadastroUndMedida {
    
    public static Label lblDescricao = new Label("Descrição ");
    public static Label lblSigla = new Label("Sigla");
    public static Label lblFracao = new Label("Fracionado");
    public static Label lblQtdeUnitaria = new Label("Qtde Unitário");
    public static Label lblBuscar = new Label("Buscar");
    public static Label msg;
    public static TextField txtDescricao = new TextField();
    public static MaskedTextField txtSigla = new MaskedTextField("UU");
    public static TextField txtBuscarNome = new TextField();
    public static TextField txtBuscarSigla = new TextField();
    public static TableView<DadosUndMedida> tabela = new TableView<DadosUndMedida>();
    public static TableColumn<DadosUndMedida, Integer> colunaID;
    public static TableColumn<DadosUndMedida, String> colunaNome;
    public static TableColumn<DadosUndMedida, String> colunaSigla;
    public static TableColumn<DadosUndMedida, String> colunaFracao;
    public static ComboBox cbBuscar = new ComboBox();
    public static Button btnAdd = new Button("I_nserir");
    public static Button btnEditar = new Button("_Editar");
    public static Button btnOK = new Button("_Ok");
    public static Button btnCancelar = new Button("_Cancelar");
    public static Button btnExcluir = new Button("E_xcluir");
    public static Button btnFechar = new Button("_Fechar");
    public static Button btnAlterar = new Button("_Alterar");
    public static CheckBox cbFracao = new CheckBox();
    public static CheckBox cbQtdeUnitaria = new CheckBox();
    
    public static void show(String mensagem, String titulo){

        Stage inicio = new Stage();
        VBox painelTela = new VBox(5);        
        Scene cenario = new Scene(painelTela, 600, 400);
   
        GridPane painelDados = new GridPane();
        HBox painelBuscar = new HBox(5);
        HBox painelBotoes = new HBox(5);
        
        colunaID = new TableColumn<DadosUndMedida, Integer>("Código");
        colunaID.setCellValueFactory(new PropertyValueFactory<DadosUndMedida, Integer>("ID"));
        colunaNome = new TableColumn<DadosUndMedida, String>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<DadosUndMedida, String>("nome"));
        colunaSigla = new TableColumn<DadosUndMedida, String>("Sigla");
        colunaSigla.setCellValueFactory(new PropertyValueFactory<DadosUndMedida, String>("sigla"));
        colunaFracao = new TableColumn<DadosUndMedida, String>("Fracionado");
        colunaFracao.setCellValueFactory(new PropertyValueFactory<DadosUndMedida, String>("fracao"));
        
        lblDescricao.setStyle("-fx-font-weight: bold");
        lblSigla.setStyle("-fx-font-weight: bold");
        lblFracao.setStyle("-fx-font-weight: bold");
        lblQtdeUnitaria.setStyle("-fx-font-weight: bold");
        lblBuscar.setStyle("-fx-font-weight: bold");
    
        btnAdd.setGraphic(Login.imageViewAdicionar);
        btnEditar.setGraphic(Login.imageViewEditar);
        btnOK.setGraphic(Login.imageViewSalvar);
        btnCancelar.setGraphic(Login.imageViewCancelar);
        btnExcluir.setGraphic(Login.imageViewExcluir);
        btnFechar.setGraphic(Login.imageViewFechar);
        btnAlterar.setGraphic(Login.imageViewOk);        
                
        txtDescricao.setDisable(true);
        txtSigla.setDisable(true);
        cbFracao.setDisable(true);
        cbQtdeUnitaria.setDisable(true);
        
        painelDados.setVgap(5);
        painelDados.setHgap(5);
        painelDados.add(lblDescricao, 0, 0);
        painelDados.add(txtDescricao, 1, 0);
        painelDados.add(lblSigla, 2, 0);
        painelDados.add(txtSigla, 3, 0);
        painelDados.add(lblFracao,4, 0);
        painelDados.add(cbFracao,5, 0);
        painelDados.add(lblQtdeUnitaria,6, 0);
        painelDados.add(cbQtdeUnitaria,7, 0);

        btnAdd.setDisable(false);
        btnOK.setDisable(true);
        btnCancelar.setDisable(true);
        btnExcluir.setDisable(false);
        btnFechar.setDisable(false);
        btnEditar.setDisable(false);
        btnAlterar.setDisable(true);        
        
        btnAdd.setOnAction(e -> btnAdicionar());
        btnEditar.setOnAction(e -> btnEditar());
        btnAlterar.setOnAction(e -> btnAlterar());
        btnOK.setOnAction(e -> btnOK());
        btnCancelar.setOnAction(e -> btnCancelar());
        btnExcluir.setOnAction(e -> DeleteUnidadeMedida.show("Tem certeza que deseja excluir este item?", "Excluir unidade de medida"));
        btnFechar.setOnAction(e -> inicio.close());
        
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.getChildren().addAll(btnAdd, btnEditar, btnOK, btnAlterar, btnCancelar, btnExcluir, btnFechar);
        
        cbBuscar.getItems().addAll("Nome","Sigla");
        
        cbBuscar.setOnAction(e -> {
            if(cbBuscar.getValue() == "Nome"){
                painelBuscar.getChildren().clear();
                painelBuscar.getChildren().addAll(lblBuscar, cbBuscar, txtBuscarNome);
            }else{
                painelBuscar.getChildren().clear();
                painelBuscar.getChildren().addAll(lblBuscar, cbBuscar, txtBuscarSigla);
            }
        });
        txtBuscarNome.setOnKeyPressed(e -> {
                if(BuscarNome().isEmpty()){
                    tabela.setItems(ListaUndMedida());
                }else{
                    tabela.setItems(BuscarNome());
                }
            }
        );
        txtBuscarSigla.setOnKeyPressed(e -> {
                if(BuscarSigla().isEmpty()){
                    tabela.setItems(ListaUndMedida());
                }else{
                    tabela.setItems(BuscarSigla());
                }
            }
        );
        painelBuscar.setPadding(new Insets(5));
        painelBuscar.getChildren().addAll(lblBuscar, cbBuscar);
        
        tabela.getColumns().addAll(colunaID,colunaNome, colunaSigla, colunaFracao);
        tabela.setItems(ListaUndMedida());
        painelTela.setPadding(new Insets(15));
        painelTela.getChildren().addAll(painelDados, painelBuscar, tabela, painelBotoes);
        
        inicio.setScene(cenario);
        inicio.setTitle(titulo);
        inicio.initModality(Modality.APPLICATION_MODAL);
        
        inicio.showAndWait();
    }
    public static ObservableList<DadosUndMedida> ListaUndMedida(){
            
            ObservableList<DadosUndMedida> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM unidade_medida ORDER BY ID;";
            
            try{
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("DESCRICAO");
                    String sigla = rs.getString("SIGLA");
                    boolean fracao = rs.getBoolean("FRACAO");
                    boolean qtdeUnitaria = rs.getBoolean("QTDE_UNITARIA");
                    
                    dados.add(new DadosUndMedida(id, nome, sigla, fracao, qtdeUnitaria));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    
    public static ObservableList<DadosUndMedida> BuscarNome(){
            
            ObservableList<DadosUndMedida> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sqlNome = "SELECT * FROM unidade_medida WHERE descricao LIKE '%"+txtBuscarNome.getText()+"%';";
            
            try{
                Statement stm = conexao.prepareStatement(sqlNome);
                rs = stm.executeQuery(sqlNome);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("DESCRICAO");
                    String sigla = rs.getString("SIGLA");
                    boolean fracao = rs.getBoolean("FRACAO");
                    boolean qtdeUnitaria = rs.getBoolean("QTDE_UNITARIA");
                    
                    dados.add(new DadosUndMedida(id, nome, sigla, fracao, qtdeUnitaria));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    
    public static ObservableList<DadosUndMedida> BuscarSigla(){
            
            ObservableList<DadosUndMedida> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM unidade_medida WHERE sigla LIKE '%"+txtBuscarSigla.getText()+"%';";
            
            try{
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("DESCRICAO");
                    String sigla = rs.getString("SIGLA");
                    boolean fracao = rs.getBoolean("FRACAO");
                    boolean qtdeUnitaria = rs.getBoolean("QTDE_UNITARIA");        
                    
                    dados.add(new DadosUndMedida(id, nome, sigla, fracao, qtdeUnitaria));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    public static void btnOK(){

        Connection conexao = Conexao.getConexao();
        String sql = "insert into unidade_medida(DESCRICAO, SIGLA, FRACAO, QTDE_UNITARIA) values('"+txtDescricao.getText()+"','"+txtSigla.getText().replace(".","").replace("/","").replace("-","")+"','"+cbFracao.isSelected()+"','"+cbQtdeUnitaria.isSelected()+"')";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
            
            txtDescricao.setDisable(true);
            txtSigla.setDisable(true);
            cbFracao.setDisable(true);
            cbQtdeUnitaria.setDisable(true);
            
            btnAdd.setDisable(false);
            btnOK.setDisable(true);
            btnCancelar.setDisable(true);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);
            
            txtDescricao.clear();
            txtSigla.clear();
            cbFracao.setSelected(false);
            cbQtdeUnitaria.setSelected(false);
            
            txtBuscarNome.clear();
            txtBuscarSigla.clear();
            txtBuscarNome.setDisable(false);
            txtBuscarSigla.setDisable(false);
            cbBuscar.setValue("");
            cbBuscar.setDisable(false);
            
            tabela.setItems(ListaUndMedida());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    
    public static void btnAlterar(){
        
        DadosUndMedida dados = tabela.getSelectionModel().getSelectedItem();
        
        Connection conexao = Conexao.getConexao();
        String sql = "update unidade_medida set DESCRICAO = '"+txtDescricao.getText()+"', SIGLA = '"+txtSigla.getText().replace(".","").replace("/","").replace("-","")+"', FRACAO = '"+cbFracao.isSelected()+"', QTDE_UNITARIA = '"+cbQtdeUnitaria.isSelected()+"' where id = "+dados.getID()+";";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
            
            txtDescricao.setDisable(true);
            txtSigla.setDisable(true);
            cbFracao.setDisable(true);
            cbQtdeUnitaria.setDisable(true);
            
            btnAdd.setDisable(false);
            btnOK.setDisable(true);
            btnCancelar.setDisable(true);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);

            txtDescricao.clear();
            txtSigla.clear();
            cbFracao.setSelected(false);
            cbQtdeUnitaria.setSelected(false);
            
            txtBuscarNome.clear();
            txtBuscarSigla.clear();
            txtBuscarNome.setDisable(false);
            txtBuscarSigla.setDisable(false);
            cbBuscar.setValue("");
            cbBuscar.setDisable(false);
            
            
            tabela.setItems(ListaUndMedida());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnExcluir(){
        
        DadosUndMedida dados = tabela.getSelectionModel().getSelectedItem();
        
        Connection conexao = Conexao.getConexao();
        String sql = "delete from unidade_medida where id = "+dados.getID()+";";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
                
            tabela.setItems(ListaUndMedida());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnEditar(){
        DadosUndMedida data = tabela.getSelectionModel().getSelectedItem();
        txtDescricao.setText(data.getNome());
        txtSigla.setText(data.getSigla());
        txtDescricao.setDisable(false);
        cbFracao.setDisable(false);
        cbQtdeUnitaria.setDisable(false);
        cbFracao.setSelected(data.getFracao());
        cbQtdeUnitaria.setSelected(data.getQtdeUnitaria());
        txtSigla.setDisable(false);
        
        btnAdd.setDisable(true);
        btnOK.setDisable(true);
        btnCancelar.setDisable(false);
        btnExcluir.setDisable(true);
        btnFechar.setDisable(true);
        btnEditar.setDisable(true);
        btnAlterar.setDisable(false);
        
        txtBuscarNome.clear();
        txtBuscarSigla.clear();
        
        cbBuscar.setValue("");
        cbBuscar.setDisable(true);
        txtBuscarNome.setDisable(true);
        txtBuscarSigla.setDisable(true);
    }
    public static void btnAdicionar(){
        txtDescricao.clear();
        txtSigla.clear();

        txtDescricao.setDisable(false);
        txtSigla.setDisable(false);
        cbFracao.setDisable(false);
        cbQtdeUnitaria.setDisable(false);
        
        btnAdd.setDisable(true);
        btnOK.setDisable(false);
        btnCancelar.setDisable(false);
        btnExcluir.setDisable(true);
        btnFechar.setDisable(true);
        btnEditar.setDisable(true);
        btnAlterar.setDisable(true);
        
        txtBuscarNome.clear();
        cbFracao.setSelected(false);
        cbQtdeUnitaria.setSelected(false);
        txtBuscarSigla.clear();
        cbBuscar.setValue("");
        cbBuscar.setDisable(true);
        txtBuscarNome.setDisable(true);
        txtBuscarSigla.setDisable(true);
    }
    public static void btnCancelar(){
        txtDescricao.clear();
        txtSigla.clear();
        txtDescricao.setDisable(true);
        txtSigla.setDisable(true);
                    
        btnAdd.setDisable(false);
        btnOK.setDisable(true);
        btnCancelar.setDisable(true);
        btnExcluir.setDisable(false);
        btnFechar.setDisable(false);
        btnEditar.setDisable(false);
        btnAlterar.setDisable(true);
        cbFracao.setDisable(true);
        cbQtdeUnitaria.setDisable(true);
        
        txtBuscarNome.clear();
        txtBuscarSigla.clear();
        cbFracao.setSelected(false);
        cbQtdeUnitaria.setSelected(false);
        cbBuscar.setValue("");
        cbBuscar.setDisable(false);
        
        txtBuscarNome.setDisable(false);
        txtBuscarSigla.setDisable(false);
    }
    
}
