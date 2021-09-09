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

public class cadastroFabricante {
    
    public static Label lblNomeFabricante = new Label("Nome ");
    public static Label lblCNPJ = new Label("CNPJ");
    public static Label lblBuscar = new Label("Buscar");
    public static Label msg;
    public static TextField txtNomeFabricante = new TextField();
    public static MaskedTextField txtCNPJ = new MaskedTextField("##.###.###/####-##");
    public static TextField txtBuscarNome = new TextField();
    public static TextField txtBuscarCNPJ = new TextField();
    public static TableView<DadosFabricante> tabela = new TableView<DadosFabricante>();
    public static TableColumn<DadosFabricante, Integer> colunaID;
    public static TableColumn<DadosFabricante, String> colunaNome;
    public static TableColumn<DadosFabricante, String> colunaCNPJ;
    public static ComboBox cbBuscar = new ComboBox();
    public static Button btnAdd = new Button("_Inserir");
    public static Button btnEditar = new Button("_Editar");
    public static Button btnOK = new Button("_Ok");
    public static Button btnCancelar = new Button("_Cancelar");
    public static Button btnExcluir = new Button("E_xcluir");
    public static Button btnFechar = new Button("_Fechar");
    public static Button btnAlterar = new Button("_Alterar");
    
    public static void show(String mensagem, String titulo){

        Stage inicio = new Stage();
        VBox painelTela = new VBox(5);        
        Scene cenario = new Scene(painelTela, 600, 400);
   
        GridPane painelDados = new GridPane();
        HBox painelBuscar = new HBox(5);
        HBox painelBotoes = new HBox(5);
        
        colunaID = new TableColumn<DadosFabricante, Integer>("Código");
        colunaID.setCellValueFactory(new PropertyValueFactory<DadosFabricante, Integer>("ID"));
        colunaNome = new TableColumn<DadosFabricante, String>("Nome");
        colunaNome.setCellValueFactory(new PropertyValueFactory<DadosFabricante, String>("nome"));
        colunaCNPJ = new TableColumn<DadosFabricante, String>("CNPJ");
        colunaCNPJ.setCellValueFactory(new PropertyValueFactory<DadosFabricante, String>("CNPJ"));
    
        btnAdd.setGraphic(Login.imageViewAdicionar);
        btnEditar.setGraphic(Login.imageViewEditar);
        btnOK.setGraphic(Login.imageViewSalvar);
        btnCancelar.setGraphic(Login.imageViewCancelar);
        btnExcluir.setGraphic(Login.imageViewExcluir);
        btnFechar.setGraphic(Login.imageViewFechar);
        btnAlterar.setGraphic(Login.imageViewOk);
        
        lblNomeFabricante.setStyle("-fx-font-weight: bold");
        lblCNPJ.setStyle("-fx-font-weight: bold");
        lblBuscar.setStyle("-fx-font-weight: bold");

        txtNomeFabricante.setDisable(true);
        txtCNPJ.setDisable(true);
        
        painelDados.setVgap(5);
        painelDados.setHgap(5);
        painelDados.add(lblNomeFabricante, 0, 0);
        painelDados.add(txtNomeFabricante, 1, 0);
        painelDados.add(lblCNPJ, 2, 0);
        painelDados.add(txtCNPJ, 3, 0);

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
        btnExcluir.setOnAction(e -> DeleteFabricante.show("Tem certeza que deseja excluir este fabricante?", "Excluir fabricante"));
        btnFechar.setOnAction(e -> inicio.close());
        
        painelBotoes.setAlignment(Pos.CENTER);
        painelBotoes.getChildren().addAll(btnAdd, btnEditar, btnOK, btnAlterar, btnCancelar, btnExcluir, btnFechar);
        
        cbBuscar.getItems().addAll("Nome","CNPJ");
        
        cbBuscar.setOnAction(e -> {
            if(cbBuscar.getValue() == "Nome"){
                painelBuscar.getChildren().clear();
                painelBuscar.getChildren().addAll(lblBuscar, cbBuscar, txtBuscarNome);
            }else{
                painelBuscar.getChildren().clear();
                painelBuscar.getChildren().addAll(lblBuscar, cbBuscar, txtBuscarCNPJ);
            }
        });
        txtBuscarNome.setOnKeyPressed(e -> {
                if(BuscarNome().isEmpty()){
                    tabela.setItems(ListaFabricante());
                }else{
                    tabela.setItems(BuscarNome());
                }
            }
        );
        txtBuscarCNPJ.setOnKeyPressed(e -> {
                if(BuscarCNPJ().isEmpty()){
                    tabela.setItems(ListaFabricante());
                }else{
                    tabela.setItems(BuscarCNPJ());
                }
            }
        );
        painelBuscar.setPadding(new Insets(5));
        painelBuscar.getChildren().addAll(lblBuscar, cbBuscar);
        
        tabela.getColumns().addAll(colunaID,colunaNome, colunaCNPJ);
        tabela.setItems(ListaFabricante());
        painelTela.setPadding(new Insets(15));
        painelTela.getChildren().addAll(painelDados, painelBuscar, tabela, painelBotoes);
        
        inicio.setScene(cenario);
        inicio.setTitle(titulo);
        inicio.initModality(Modality.APPLICATION_MODAL);
        
        inicio.showAndWait();
    }
    public static ObservableList<DadosFabricante> ListaFabricante(){
            
            ObservableList<DadosFabricante> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sql = "SELECT * FROM fabricante ORDER BY ID;";
            
            try{
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("NOME");
                    String cnpj = rs.getString("CNPJ");
                    
                    dados.add(new DadosFabricante(id, nome, cnpj));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    public static ObservableList<DadosFabricante> BuscarNome(){
            
            ObservableList<DadosFabricante> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sqlNome = "SELECT * FROM fabricante WHERE NOME LIKE '%"+txtBuscarNome.getText()+"%';";
            
            try{
                Statement stm = conexao.prepareStatement(sqlNome);
                rs = stm.executeQuery(sqlNome);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("NOME");
                    String cnpj = rs.getString("CNPJ");
                    
                    dados.add(new DadosFabricante(id, nome, cnpj));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    public static ObservableList<DadosFabricante> BuscarCNPJ(){
            
            ObservableList<DadosFabricante> dados = FXCollections.observableArrayList();
        
            ResultSet rs;
            Connection conexao = Conexao.getConexao();
            String sqlCnpj = "SELECT * FROM fabricante WHERE CNPJ LIKE '%"+txtBuscarCNPJ.getText()+"%';";
            
            try{
                Statement stm = conexao.prepareStatement(sqlCnpj);
                rs = stm.executeQuery(sqlCnpj);
                
                while(rs.next()){
                    int id = rs.getInt("ID");
                    String nome = rs.getString("NOME");
                    String cnpj = rs.getString("CNPJ");
                    
                    dados.add(new DadosFabricante(id, nome, cnpj));
                }
            }catch(Exception e){
                System.err.println(e);
            }
            return dados;
    }
    public static void btnOK(){

        Connection conexao = Conexao.getConexao();
        String sql = "insert into fabricante(NOME, CNPJ) values('"+txtNomeFabricante.getText()+"','"+txtCNPJ.getText().replace(".","").replace("/","").replace("-","")+"')";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
            
            txtNomeFabricante.setDisable(true);
            txtCNPJ.setDisable(true);
            
            btnAdd.setDisable(false);
            btnOK.setDisable(true);
            btnCancelar.setDisable(true);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);
            
            txtNomeFabricante.clear();
            txtCNPJ.clear();
            
            tabela.setItems(ListaFabricante());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnAlterar(){
        
        DadosFabricante dados = tabela.getSelectionModel().getSelectedItem();
        
        Connection conexao = Conexao.getConexao();
        String sql = "update fabricante set NOME = '"+txtNomeFabricante.getText()+"', CNPJ = '"+txtCNPJ.getText().replace(".","").replace("/","").replace("-","")+"' where id = "+dados.getID()+";";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
            
            txtNomeFabricante.setDisable(true);
            txtCNPJ.setDisable(true);
            
            btnAdd.setDisable(false);
            btnOK.setDisable(true);
            btnCancelar.setDisable(true);
            btnExcluir.setDisable(false);
            btnFechar.setDisable(false);
            btnEditar.setDisable(false);
            btnAlterar.setDisable(true);

            txtNomeFabricante.clear();
            txtCNPJ.clear();
            
            tabela.setItems(ListaFabricante());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnExcluir(){
        
        DadosFabricante dados = tabela.getSelectionModel().getSelectedItem();
        
        Connection conexao = Conexao.getConexao();
        String sql = "delete from fabricante where id = "+dados.getID()+";";
        
        try{
            Statement stm = conexao.prepareStatement(sql);
            stm.execute(sql);
                
            tabela.setItems(ListaFabricante());
            
        }catch(Exception e){
            System.err.println(e);
        }
    }
    public static void btnEditar(){
        
        DadosFabricante data = tabela.getSelectionModel().getSelectedItem();
        txtNomeFabricante.setText(data.getNome());
        txtCNPJ.setText(data.getCNPJ());
        txtNomeFabricante.setDisable(false);
        txtCNPJ.setDisable(false);
        
        btnAdd.setDisable(true);
        btnOK.setDisable(true);
        btnCancelar.setDisable(false);
        btnExcluir.setDisable(true);
        btnFechar.setDisable(true);
        btnEditar.setDisable(true);
        btnAlterar.setDisable(false);
        
        txtBuscarNome.clear();
        txtBuscarCNPJ.clear();
        cbBuscar.setValue("");
        cbBuscar.setDisable(true);
        txtBuscarNome.setDisable(true);
        txtBuscarCNPJ.setDisable(true);
    }
    public static void btnAdicionar(){
        
        txtNomeFabricante.clear();
        txtCNPJ.clear();

        txtNomeFabricante.setDisable(false);
        txtCNPJ.setDisable(false);
        
        btnAdd.setDisable(true);
        btnOK.setDisable(false);
        btnCancelar.setDisable(false);
        btnExcluir.setDisable(true);
        btnFechar.setDisable(true);
        btnEditar.setDisable(true);
        btnAlterar.setDisable(true);
        
        txtBuscarNome.clear();
        txtBuscarCNPJ.clear();
        cbBuscar.setValue("");
        cbBuscar.setDisable(true);
        txtBuscarNome.setDisable(true);
        txtBuscarCNPJ.setDisable(true);
    }
    public static void btnCancelar(){
        
        txtNomeFabricante.clear();
        txtCNPJ.clear();
        txtNomeFabricante.setDisable(true);
        txtCNPJ.setDisable(true);
                    
        btnAdd.setDisable(false);
        btnOK.setDisable(true);
        btnCancelar.setDisable(true);
        btnExcluir.setDisable(false);
        btnFechar.setDisable(false);
        btnEditar.setDisable(false);
        btnAlterar.setDisable(true);
        
        txtBuscarNome.clear();
        txtBuscarCNPJ.clear();
        cbBuscar.setValue("");
        cbBuscar.setDisable(false);
        txtBuscarNome.setDisable(false);
        txtBuscarCNPJ.setDisable(false);
    }
    
}
