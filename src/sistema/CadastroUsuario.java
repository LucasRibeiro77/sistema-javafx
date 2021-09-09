package sistema;

import javafx.application.*;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.cell.*;
import javafx.collections.*;
import javafx.geometry.*;
import javafx.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import static sistema.CadastroUsuario.btnEditar;

public class CadastroUsuario{
    
        public static TableView<DadosUsuario> tabela;
        public static TextField campo1;
        public static ComboBox campo2;
        public static PasswordField campo3;
        public static Button btnInserir; 
        public static Button btnEditar;
        public static Button btnAtualizar;
        public static Button btnFechar;
        public static Button btnExcluir;
        public static Button btnCancelar;
        public static CheckBox chkPermProdutos;
        public static CheckBox chkPermFornecedor;
        public static CheckBox chkPermFabricante;
        public static CheckBox chkPermCategoria;
        public static CheckBox chkPermUnidadeMedida;
        public static CheckBox chkPermEstabelecimento;
        public static CheckBox chkPermUsuario;
        public static CheckBox chkPermCadastro;
        public static CheckBox chkPermFiscal;
        public static CheckBox chkPermEstoque;
        public static CheckBox chkPermCarga;
        public static CheckBox chkPermManutencao;
        public static CheckBox chkPermNFe;
        public static CheckBox chkPermCFe;
        public static CheckBox chkPermSPED;
        public static CheckBox chkPermFinanceiro;
        public static CheckBox chkPermContasPagar;
        public static CheckBox chkPermContasReceber;
        public static CheckBox chkPermInvoices;
        public static CheckBox chkPermFluxoCaixa;
        public static CheckBox chkPermEnvioArquivo;
        public static CheckBox chkPermRelatorios;
        public static CheckBox chkPermVendaBalcao;
                
	public static void show(String mensagem, String titulo){
            
		Stage inicio = new Stage();
		Label arg1 = new Label("Usuário");
		Label arg2 = new Label("Cargo");
		Label arg3 = new Label("senha");
		campo1 = new TextField();
		campo2 = new ComboBox();
		campo3 = new PasswordField();
		GridPane painel2 = new GridPane();
		VBox painel = new VBox(15);
		StackPane painel3 = new StackPane();
                HBox painel4 = new HBox(5);
                VBox chkPainel = new VBox(5);
                VBox chkPainel2 = new VBox(7);
                VBox chkPainel3 = new VBox(5);
                VBox chkPainel4 = new VBox(7);
                VBox chkPainel5 = new VBox(7);
                VBox chkPainel6 = new VBox(5);
                VBox chkPainel7 = new VBox(7);
                VBox chkPainel8 = new VBox(5);
                HBox painel5 = new HBox(5);
		Scene cenario = new Scene(painel, 700, 500);
		Label texto1 = new Label();
		chkPermProdutos = new CheckBox();
		chkPermFornecedor = new CheckBox();
                chkPermFabricante = new CheckBox();
                chkPermUnidadeMedida = new CheckBox();
                chkPermCategoria = new CheckBox();
		chkPermEstabelecimento = new CheckBox();
		chkPermUsuario = new CheckBox();
                chkPermCadastro = new CheckBox();    
                chkPermEstoque = new CheckBox();
                chkPermCarga = new CheckBox();
                chkPermManutencao = new CheckBox();
                chkPermFiscal = new CheckBox();
                chkPermNFe = new CheckBox();
                chkPermCFe = new CheckBox();
                chkPermSPED = new CheckBox();
                chkPermFinanceiro = new CheckBox();
                chkPermContasPagar = new CheckBox();
                chkPermContasReceber = new CheckBox();
                chkPermInvoices = new CheckBox();
                chkPermFluxoCaixa = new CheckBox();
                chkPermEnvioArquivo = new CheckBox();
                chkPermRelatorios = new CheckBox();
                chkPermVendaBalcao = new CheckBox();
                btnInserir = new Button("I_nsere");
		btnEditar = new Button("_Editar");
		btnExcluir = new Button("E_xcluir");
		btnFechar = new Button("_Fechar");
                btnAtualizar = new Button("A_lterar");
                btnCancelar = new Button("_Cancelar");
		Label texto3 = new Label("Painel");
                Label argPermCadastro = new Label("Cadastro");                
                Label argPermProdutos = new Label("Produtos");
                Label argPermFornecedor = new Label("Fornecedores");
                Label argPermFabricante = new Label("Fabricantes");
                Label argPermCategoria = new Label("Categoria");
                Label argPermUnidadeMedida = new Label("Unidade de Medida");
                Label argPermEstabelecimento = new Label("Estabelecimento");
                Label argPermUsuario = new Label("Usuarios");
                Label argPermEstoque = new Label("Estoque");
                Label argPermCarga = new Label("Carga");
                Label argPermManutencao = new Label("Manutenção");
                Label argPermFiscal = new Label("Fiscal");
                Label argPermNFe = new Label("NF-e");
                Label argPermCFe = new Label("CF-e");
                Label argPermSPED = new Label("SPED Fiscal");
                Label argPermFinanceiro = new Label("Financeiro");
                Label argPermContasPagar = new Label("Contas a Pagar");
                Label argPermContasReceber = new Label("Contas a Receber");
                Label argPermInvoices = new Label("Invoices");
                Label argPermFluxoCaixa = new Label("Fluxo de caixa");
                Label argPermEnvioArquivo = new Label("Envio de arquivo");
                Label argPermRelatorios = new Label("Relatórios");
                Label argPermVendaBalcao = new Label("Venda Balcão");
                
                tabela = new TableView<DadosUsuario>();    
                TableColumn<DadosUsuario, Integer> coluna = new TableColumn<DadosUsuario, Integer>("ID");
		coluna.setMinWidth(100);
		coluna.setCellValueFactory(new PropertyValueFactory<DadosUsuario, Integer>("ID"));
		TableColumn<DadosUsuario, String> coluna1 = new TableColumn<DadosUsuario, String>("Usuario");
		coluna1.setMinWidth(300);
		coluna1.setCellValueFactory(new PropertyValueFactory<DadosUsuario, String>("Usuario"));
		TableColumn<DadosUsuario, String> coluna2 = new TableColumn<DadosUsuario, String>("Cargo");
		coluna2.setMinWidth(280);
		coluna2.setCellValueFactory(new PropertyValueFactory<DadosUsuario, String>("Cargo"));
                tabela.setMinWidth(200);
                tabela.setPrefHeight(180);

		inicio.setScene(cenario);
		inicio.setTitle(titulo);
		inicio.initModality(Modality.APPLICATION_MODAL);
		campo2.getItems().addAll("Administrador", "Caixa", "Gerente");
		texto1.setText(mensagem);
                
		tabela.getColumns().addAll(coluna, coluna1, coluna2);
		tabela.setItems(ListaUsuarios());
                
		painel.setPadding(new Insets(10));
		painel.setStyle("-fx-border-color: gray; -fx-border-radius: 2; -fx-border-insets: 20 15 15 15; -fx-padding: -8 5 5 5;");
		texto1.setStyle("-fx-background-color: #F4F4F4;");
                arg1.setStyle("-fx-font-weight: bold");
                arg2.setStyle("-fx-font-weight: bold");
                arg3.setStyle("-fx-font-weight: bold");

                btnAtualizar.setDisable(true);
                btnCancelar.setDisable(true);
                tabela.getSelectionModel().selectFirst();

                if(chkPermCadastro.isSelected() == false){
                    
                    chkPermProdutos.setSelected(false);
                    chkPermFornecedor.setSelected(false);
                    chkPermFabricante.setSelected(false);
                    chkPermCategoria.setSelected(false);
                    chkPermUnidadeMedida.setSelected(false);
                    chkPermEstabelecimento.setSelected(false);
                    chkPermUsuario.setSelected(false);

                    chkPermProdutos.setDisable(true);
                    chkPermFornecedor.setDisable(true);
                    chkPermFabricante.setDisable(true);
                    chkPermCategoria.setDisable(true);
                    chkPermUnidadeMedida.setDisable(true);
                    chkPermEstabelecimento.setDisable(true);
                    chkPermUsuario.setDisable(true);
                    }else{
                        chkPermProdutos.setSelected(true);
                        chkPermFornecedor.setSelected(true);
                        chkPermFabricante.setSelected(true);
                        chkPermCategoria.setSelected(true);
                        chkPermUnidadeMedida.setSelected(true);
                        chkPermEstabelecimento.setSelected(true);
                        chkPermUsuario.setSelected(true);

                        chkPermProdutos.setDisable(false);
                        chkPermFornecedor.setDisable(false);
                        chkPermFabricante.setDisable(false);
                        chkPermCategoria.setDisable(false);
                        chkPermUnidadeMedida.setDisable(false);
                        chkPermEstabelecimento.setDisable(false);
                        chkPermUsuario.setDisable(false);
                    }
                
                if(chkPermEstoque.isSelected() == false){
                    
                    chkPermCarga.setSelected(false);
                    chkPermManutencao.setSelected(false);

                    chkPermCarga.setDisable(true);
                    chkPermManutencao.setDisable(true);
                        
                    }else{
                    
                        chkPermCarga.setSelected(true);
                        chkPermManutencao.setSelected(true);

                        chkPermCarga.setDisable(false);
                        chkPermManutencao.setDisable(false);
                    }
                
                chkPermEstoque.setOnAction(e -> 
                {
                    if(chkPermEstoque.isSelected() == false){
                            chkPermCarga.setSelected(false);
                            chkPermManutencao.setSelected(false);

                            chkPermCarga.setDisable(true);
                            chkPermManutencao.setDisable(true);
                        }else{
                            chkPermCarga.setSelected(true);
                            chkPermManutencao.setSelected(true);

                            chkPermCarga.setDisable(false);
                            chkPermManutencao.setDisable(false);
                        }
                }
                );
                
                if(chkPermFiscal.isSelected() == false){
                    
                    chkPermNFe.setSelected(false);
                    chkPermCFe.setSelected(false);
                    chkPermSPED.setSelected(false);
                            
                    chkPermNFe.setDisable(true);
                    chkPermCFe.setDisable(true);
                    chkPermSPED.setDisable(true);
                    } else {
                    
                        chkPermNFe.setSelected(true);
                        chkPermCFe.setSelected(true);
                        chkPermSPED.setSelected(true);
                            
                        chkPermNFe.setDisable(false);
                        chkPermCFe.setDisable(false);
                        chkPermSPED.setDisable(false);
                    }
                
                    chkPermFiscal.setOnAction(e -> {
                    if(chkPermFiscal.isSelected() == false){
                        chkPermNFe.setSelected(false);
                        chkPermCFe.setSelected(false);
                        chkPermSPED.setSelected(false);
                            
                        chkPermNFe.setDisable(true);
                        chkPermCFe.setDisable(true);
                        chkPermSPED.setDisable(true);
                        } else {
                            chkPermNFe.setSelected(true);
                            chkPermCFe.setSelected(true);
                            chkPermSPED.setSelected(true);
                            
                            chkPermNFe.setDisable(false);
                            chkPermCFe.setDisable(false);
                            chkPermSPED.setDisable(false);
                        }
                });
                
                if(chkPermFinanceiro.isSelected() == false){
                    
                        chkPermContasPagar.setSelected(false);
                        chkPermContasReceber.setSelected(false);
                        chkPermInvoices.setSelected(false);
                        chkPermFluxoCaixa.setSelected(false);
                        chkPermEnvioArquivo.setSelected(false);

                        chkPermContasPagar.setDisable(true);
                        chkPermContasReceber.setDisable(true);
                        chkPermInvoices.setDisable(true);
                        chkPermFluxoCaixa.setDisable(true);
                        chkPermEnvioArquivo.setDisable(true);
                        
                        }else{
                            chkPermContasPagar.setSelected(true);
                            chkPermContasReceber.setSelected(true);
                            chkPermInvoices.setSelected(true);
                            chkPermFluxoCaixa.setSelected(true);
                            chkPermEnvioArquivo.setSelected(true);

                            chkPermContasPagar.setDisable(false);
                            chkPermContasReceber.setDisable(false);
                            chkPermInvoices.setDisable(false);
                            chkPermFluxoCaixa.setDisable(false);
                            chkPermEnvioArquivo.setDisable(false);
                        }
                
                    chkPermFinanceiro.setOnAction(e -> {
                    if(chkPermFinanceiro.isSelected() == false){
                        
                            chkPermContasPagar.setSelected(false);
                            chkPermContasReceber.setSelected(false);
                            chkPermInvoices.setSelected(false);
                            chkPermFluxoCaixa.setSelected(false);
                            chkPermEnvioArquivo.setSelected(false);

                            chkPermContasPagar.setDisable(true);
                            chkPermContasReceber.setDisable(true);
                            chkPermInvoices.setDisable(true);
                            chkPermFluxoCaixa.setDisable(true);
                            chkPermEnvioArquivo.setDisable(true);
                            
                            }else{
                                chkPermContasPagar.setSelected(true);
                                chkPermContasReceber.setSelected(true);
                                chkPermInvoices.setSelected(true);
                                chkPermFluxoCaixa.setSelected(true);
                                chkPermEnvioArquivo.setSelected(true);

                                chkPermContasPagar.setDisable(false);
                                chkPermContasReceber.setDisable(false);
                                chkPermInvoices.setDisable(false);
                                chkPermFluxoCaixa.setDisable(false);
                                chkPermEnvioArquivo.setDisable(false);
                            }
                    });
                    chkPermCadastro.setOnAction(e -> {
                        
                    if(chkPermCadastro.isSelected() == false){
                        
                        chkPermProdutos.setSelected(false);
                        chkPermFornecedor.setSelected(false);
                        chkPermFabricante.setSelected(false);
                        chkPermCategoria.setSelected(false);
                        chkPermUnidadeMedida.setSelected(false);
                        chkPermEstabelecimento.setSelected(false);
                        chkPermUsuario.setSelected(false);
                        
                        chkPermProdutos.setDisable(true);
                        chkPermFornecedor.setDisable(true);
                        chkPermFabricante.setDisable(true);
                        chkPermCategoria.setDisable(true);
                        chkPermUnidadeMedida.setDisable(true);
                        chkPermEstabelecimento.setDisable(true);
                        chkPermUsuario.setDisable(true);
                        }else{
                            chkPermProdutos.setSelected(true);
                            chkPermFornecedor.setSelected(true);
                            chkPermFabricante.setSelected(true);
                            chkPermCategoria.setSelected(true);
                            chkPermUnidadeMedida.setSelected(true);
                            chkPermEstabelecimento.setSelected(true);
                            chkPermUsuario.setSelected(true);

                            chkPermProdutos.setDisable(false);
                            chkPermFornecedor.setDisable(false);
                            chkPermFabricante.setDisable(false);
                            chkPermCategoria.setDisable(false);
                            chkPermUnidadeMedida.setDisable(false);
                            chkPermEstabelecimento.setDisable(false);
                            chkPermUsuario.setDisable(false);
                        }
                });
                
                btnInserir.setOnAction(e -> Inserir());
		btnEditar.setOnAction(e -> 
		{
                        tabela.setDisable(true);
                        btnEditar.setDisable(true);
                        btnExcluir.setDisable(true);
                        btnInserir.setDisable(true);
                        btnFechar.setDisable(true);
                        btnCancelar.setDisable(false);
                        btnAtualizar.setDisable(false);
			DadosUsuario data = new DadosUsuario();
			data = tabela.getSelectionModel().getSelectedItem();
			campo1.setText(data.getUsuario());
			campo2.setValue(data.getCargo());
                        campo3.setText(data.getPass());
                        chkPermCadastro.setSelected(Boolean.valueOf(data.getPermCadastro()));
                        chkPermProdutos.setSelected(Boolean.valueOf(data.getPermCadastroProduto()));
                        chkPermFornecedor.setSelected(Boolean.valueOf(data.getPermCadastroFornecedor()));
                        chkPermFabricante.setSelected(Boolean.valueOf(data.getPermCadastroFabricante()));
                        chkPermCategoria.setSelected(Boolean.valueOf(data.getPermCadastroCategoria()));
                        chkPermUnidadeMedida.setSelected(Boolean.valueOf(data.getPermCadastroUnidadeMedida()));
                        chkPermEstabelecimento.setSelected(Boolean.valueOf(data.getPermCadastroEstabelecimento()));
                        chkPermUsuario.setSelected(Boolean.valueOf(data.getPermCadastroUsuario()));
                        chkPermEstoque.setSelected(Boolean.valueOf(data.getPermEstoque()));
                        chkPermCarga.setSelected(Boolean.valueOf(data.getPermCarga()));
                        chkPermManutencao.setSelected(Boolean.valueOf(data.getPermManutencao()));
                        chkPermFinanceiro.setSelected(Boolean.valueOf(data.getPermFinanceiro()));
                        chkPermContasPagar.setSelected(Boolean.valueOf(data.getPermContasPagar()));
                        chkPermContasReceber.setSelected(Boolean.valueOf(data.getPermContasReceber()));
                        chkPermInvoices.setSelected(Boolean.valueOf(data.getPermInvoices()));
                        chkPermFluxoCaixa.setSelected(Boolean.valueOf(data.getPermFluxoCaixa()));
                        chkPermEnvioArquivo.setSelected(Boolean.valueOf(data.getPermEnvioArquivo()));
                        chkPermRelatorios.setSelected(Boolean.valueOf(data.getPermRelatorios()));
                        chkPermVendaBalcao.setSelected(Boolean.valueOf(data.getPermVendaBalcao()));
                        
                        if(chkPermCadastro.isSelected() == false){
                            chkPermProdutos.setSelected(false);
                            chkPermFornecedor.setSelected(false);
                            chkPermFabricante.setSelected(false);
                            chkPermCategoria.setSelected(false);
                            chkPermUnidadeMedida.setSelected(false);
                            chkPermEstabelecimento.setSelected(false);
                            chkPermUsuario.setSelected(false);

                            chkPermProdutos.setDisable(true);
                            chkPermFornecedor.setDisable(true);
                            chkPermFabricante.setDisable(true);
                            chkPermCategoria.setDisable(true);
                            chkPermUnidadeMedida.setDisable(true);
                            chkPermEstabelecimento.setDisable(true);
                            chkPermUsuario.setDisable(true);
                            
                            }else{
                                chkPermProdutos.setSelected(true);
                                chkPermFornecedor.setSelected(true);
                                chkPermFabricante.setSelected(true);
                                chkPermCategoria.setSelected(true);
                                chkPermUnidadeMedida.setSelected(true);
                                chkPermEstabelecimento.setSelected(true);
                                chkPermUsuario.setSelected(true);

                                chkPermProdutos.setDisable(false);
                                chkPermFornecedor.setDisable(false);
                                chkPermFabricante.setDisable(false);
                                chkPermCategoria.setDisable(false);
                                chkPermUnidadeMedida.setDisable(false);
                                chkPermEstabelecimento.setDisable(false);
                                chkPermUsuario.setDisable(false);
                            }
		});
                btnExcluir.setOnAction(e -> Delete.show("Tem certeza que deseja excluir este item?", "Confirmação de ação necessária"));
                btnCancelar.setOnAction(e -> Cancelar());
                btnAtualizar.setOnAction(e -> 
                {
                    Atualizar();
                    tabela.setDisable(false);
                    btnEditar.setDisable(false);
                    btnAtualizar.setDisable(true);
                    btnCancelar.setDisable(true);
                    btnInserir.setDisable(false);
                    btnExcluir.setDisable(false);
                    btnFechar.setDisable(false);
                });
		btnFechar.setOnAction(e -> inicio.close());
                
                painel2.setVgap(5);
		painel2.setHgap(5);
		painel2.add(arg1, 0, 0);
		painel2.add(campo1, 1, 0);
		painel2.add(arg2, 2, 0);
		painel2.add(campo2, 3, 0);
		painel2.add(arg3, 4, 0);
		painel2.add(campo3, 5, 0);
		painel2.add(btnInserir, 6, 0);
                painel3.setStyle("-fx-background-color: #F4F4F4; -fx-border-color: gray; -fx-border-radius: 2; -fx-border-insets: 20 15 15 15; -fx-padding: -4 8 8 8;");
                painel4.setStyle("-fx-padding: 12;");
                painel3.setAlignment(texto3, Pos.TOP_LEFT);
                painel4.setAlignment(Pos.CENTER);
                texto3.setStyle("-fx-background-color: #F4F4F4; -fx-padding:-5");
                painel3.setPadding(new Insets(5));
                
                btnInserir.setGraphic(Login.imageViewAdicionar);
                btnAtualizar.setGraphic(Login.imageViewOk);
                btnEditar.setGraphic(Login.imageViewEditar);
                btnCancelar.setGraphic(Login.imageViewCancelar);
                btnExcluir.setGraphic(Login.imageViewExcluir);
                btnFechar.setGraphic(Login.imageViewFechar);
                
                chkPainel2.getChildren().addAll(argPermCadastro, argPermProdutos, argPermFornecedor, argPermFabricante, argPermCategoria, argPermUnidadeMedida, argPermEstabelecimento, argPermUsuario);
                chkPainel.getChildren().addAll(chkPermCadastro, chkPermProdutos, chkPermFornecedor, chkPermFabricante, chkPermCategoria, chkPermUnidadeMedida, chkPermEstabelecimento, chkPermUsuario);
                chkPainel3.getChildren().addAll(argPermEstoque, argPermCarga, argPermManutencao);
                chkPainel4.getChildren().addAll(chkPermEstoque, chkPermCarga, chkPermManutencao);
                chkPainel5.getChildren().addAll(argPermFiscal, argPermNFe, argPermCFe, argPermSPED);
                chkPainel6.getChildren().addAll(chkPermFiscal, chkPermNFe, chkPermCFe, chkPermSPED);
                chkPainel7.getChildren().addAll(argPermFinanceiro, argPermContasPagar, argPermContasReceber, argPermInvoices, argPermFluxoCaixa, argPermEnvioArquivo);
                chkPainel8.getChildren().addAll(chkPermFinanceiro, chkPermContasPagar, chkPermContasReceber, chkPermInvoices, chkPermFluxoCaixa, chkPermEnvioArquivo);
		painel3.getChildren().addAll(texto3, painel4);
                painel5.getChildren().addAll(chkPainel, chkPainel2, chkPainel4, chkPainel3, chkPainel6, chkPainel5, chkPainel8, chkPainel7, chkPermRelatorios, argPermRelatorios, chkPermVendaBalcao, argPermVendaBalcao);
                painel4.getChildren().addAll(btnAtualizar, btnCancelar, btnEditar, btnExcluir, btnFechar);
		painel.getChildren().addAll(texto1, painel2, painel5, tabela, painel3);
		inicio.showAndWait();
	}

        
        public static ObservableList<DadosUsuario> ListaUsuarios()
	{
		
            ObservableList<DadosUsuario> lista = FXCollections.observableArrayList();
        
            try{
                    Connection connection = Conexao.getConexao();
                    String sql = "SELECT * FROM USUARIO";
                    ResultSet rs = null;
                    PreparedStatement statement = connection.prepareStatement(sql);
                    rs = statement.executeQuery();
                    
                    while(rs.next()){
                        
                        int id = rs.getInt("ID");
                        String nome = rs.getString("NOME");
                        String cargo = rs.getString("CARGO");
                        String pass = rs.getString("PASS");
                        String permCadastro = rs.getString("PERM_CADASTRO");
                        String permCadastroProduto = rs.getString("PERM_CADASTRO_PRODUTOS");
                        String permCadastroFornecedor = rs.getString("PERM_CADASTRO_FORNECEDOR");
                        String permCadastroFabricante = rs.getString("PERM_CADASTRO_FABRICANTE");
                        String permCadastroCategoria = rs.getString("PERM_CADASTRO_CATEGORIA");
                        String permCadastroUnidadeMedida = rs.getString("PERM_CADASTRO_UNIDADE_MEDIDA");
                        String permCadastroEstabelecimento = rs.getString("PERM_CADASTRO_ESTABELECIMENTO");
                        String permCadastroUsuario = rs.getString("PERM_CADASTRO_USUARIO");
                        String permEstoque = rs.getString("PERM_ESTOQUE");
                        String permCarga = rs.getString("PERM_ESTOQUE_CARGA");
                        String permManutencao = rs.getString("PERM_ESTOQUE_MANUTENCAO");
                        String permFinanceiro = rs.getString("PERM_FINANCEIRO");
                        String permContasPagar = rs.getString("PERM_FINANCEIRO_CONTAS_PAGAR");
                        String permContasReceber = rs.getString("PERM_FINANCEIRO_CONTAS_RECEBER");
                        String permInvoices = rs.getString("PERM_FINANCEIRO_INVOICES");
                        String permFluxoCaixa = rs.getString("PERM_FINANCEIRO_FLUXO_CAIXA");
                        String permEnvioArquivo = rs.getString("PERM_FINANCEIRO_ENVIO_ARQUIVO");
                        String permRelatorios = rs.getString("PERM_RELATORIOS");
                        String permVendaBalcao = rs.getString("PERM_VENDA_BALCAO");
                        
                        lista.add(new DadosUsuario(id, nome, cargo, pass, permCadastro, permCadastroProduto, permCadastroFornecedor, permCadastroFabricante, permCadastroCategoria, permCadastroUnidadeMedida, permCadastroEstabelecimento, permCadastroUsuario, permEstoque, permCarga, permManutencao, permFinanceiro, permContasPagar, permContasReceber, permInvoices, permFluxoCaixa, permEnvioArquivo, permRelatorios, permVendaBalcao));
                    }
                    connection.close();
                    
                    } catch(Exception ex) {
                        System.err.println("Dados não carregados");
                    }

                    return lista;        
	}
        public static void Excluir() {
            
                try{
                    Connection conexao = Conexao.getConexao();
                    DadosUsuario dados = tabela.getSelectionModel().getSelectedItem();
                    String delete = "DELETE FROM USUARIO WHERE NOME = '"+dados.getUsuario()+"' AND CARGO = '"+dados.getCargo()+"'";
                    PreparedStatement st = conexao.prepareStatement(delete);
                    st.execute(delete);
                    tabela.setItems(ListaUsuarios());
                    tabela.getSelectionModel().selectLast();
                    conexao.close();
                    
                }catch(Exception ex){
                    MessageBox.show("Não foi possível excluir o usuário", "Erro");
                }
    }
    public static void Inserir(){
        
        try{
            Connection conexao = Conexao.getConexao();
            String insert = "INSERT INTO USUARIO(NOME, CARGO, PASS, PERM_CADASTRO, PERM_CADASTRO_PRODUTO, PERM_CADASTRO_FORNECEDOR, PERM_CADASTRO_FABRICANTE, PERM_CADASTRO_CATEGORIA, PERM_CADASTRO_UNIDADE_MEDIDA, PERM_CADASTRO_ESTABELECIMENTO, PERM_CADASTRO_USUARIO, PERM_ESTOQUE, PERM_ESTOQUE_CARGA, PERM_ESTOQUE_MANUTENCAO, PERM_FINANCEIRO, PERM_FINANCEIRO_CONTAS_PAGAR, PERM_FINANCEIRO_CONTAS_RECEBER, PERM_FINANCEIRO_INVOICES, PERM_FINANCEIRO_FLUXO_CAIXA, PERM_FINANCEIRO_ENVIO_ARQUIVO, PERM_RELATORIOS, PERM_VENDA_BALCAO) VALUES('"+campo1.getText()+"','"+campo2.getValue()+"','"+campo3.getText()+"','"+chkPermCadastro.isSelected()+"','"+chkPermProdutos.isSelected()+"','"+chkPermFornecedor.isSelected()+"','"+chkPermFabricante.isSelected()+"','"+chkPermCategoria.isSelected()+"','"+chkPermUnidadeMedida.isSelected()+"','"+chkPermEstabelecimento.isSelected()+"','"+chkPermUsuario.isSelected()+"','"+chkPermEstoque.isSelected()+"','"+chkPermCarga.isSelected()+"','"+chkPermManutencao.isSelected()+"','"+chkPermFinanceiro.isSelected()+"','"+chkPermContasPagar.isSelected()+"','"+chkPermContasReceber.isSelected()+"','"+chkPermInvoices.isSelected()+"','"+chkPermFluxoCaixa.isSelected()+"','"+chkPermEnvioArquivo.isSelected()+"','"+chkPermRelatorios.isSelected()+"','"+chkPermVendaBalcao.isSelected()+"')";
            PreparedStatement stm = conexao.prepareStatement(insert);
            stm.execute(insert);
            tabela.setItems(ListaUsuarios());
            campo1.clear();
            campo2.setValue("");
            campo3.clear();

            chkPermCadastro.setSelected(false);
            chkPermProdutos.setSelected(false);
            chkPermFornecedor.setSelected(false);
            chkPermFabricante.setSelected(false);
            chkPermCategoria.setSelected(false);
            chkPermUnidadeMedida.setSelected(false);
            chkPermEstabelecimento.setSelected(false);
            chkPermUsuario.setSelected(false);
            
            if(chkPermCadastro.isSelected() == false){
                
                    chkPermProdutos.setSelected(false);
                    chkPermFornecedor.setSelected(false);
                    chkPermFabricante.setSelected(false);
                    chkPermCategoria.setSelected(false);
                    chkPermUnidadeMedida.setSelected(false);
                    chkPermEstabelecimento.setSelected(false);
                    chkPermUsuario.setSelected(false);

                    chkPermProdutos.setDisable(true);
                    chkPermFornecedor.setDisable(true);
                    chkPermFabricante.setDisable(true);
                    chkPermCategoria.setDisable(true);
                    chkPermUnidadeMedida.setDisable(true);
                    chkPermEstabelecimento.setDisable(true);
                    chkPermUsuario.setDisable(true);
                    
                    }else{
                        chkPermProdutos.setSelected(true);
                        chkPermFornecedor.setSelected(true);
                        chkPermFabricante.setSelected(true);
                        chkPermCategoria.setSelected(true);
                        chkPermUnidadeMedida.setSelected(true);
                        chkPermEstabelecimento.setSelected(true);
                        chkPermUsuario.setSelected(true);

                        chkPermProdutos.setDisable(false);
                        chkPermFornecedor.setDisable(false);
                        chkPermFabricante.setDisable(false);
                        chkPermCategoria.setDisable(false);
                        chkPermUnidadeMedida.setDisable(false);
                        chkPermEstabelecimento.setDisable(false);
                        chkPermUsuario.setDisable(false);
                    }

                    tabela.getSelectionModel().selectLast();
                    conexao.close();
        } catch(Exception ex){
            MessageBox.show(""+ex, "Erro");
        }
        
    }
    
    public static void Atualizar(){
        try{
            Connection conexao = Conexao.getConexao();
            DadosUsuario dados = tabela.getSelectionModel().getSelectedItem();
            String update = "UPDATE USUARIO SET NOME = '"+campo1.getText()+"', CARGO = '"+campo2.getValue()+"', PASS = '"+campo3.getText()+"', PERM_CADASTRO = '"+chkPermCadastro.isSelected()+"', PERM_CADASTRO_PRODUTOS = '"+chkPermProdutos.isSelected()+"', PERM_CADASTRO_FORNECEDOR = '"+chkPermFornecedor.isSelected()+"', PERM_CADASTRO_FABRICANTE = '"+chkPermFabricante.isSelected()+"', PERM_CADASTRO_CATEGORIA = '"+chkPermCategoria.isSelected()+"', PERM_CADASTRO_UNIDADE_MEDIDA = '"+chkPermUnidadeMedida.isSelected()+"', PERM_CADASTRO_ESTABELECIMENTO = '"+chkPermEstabelecimento.isSelected()+"', PERM_CADASTRO_USUARIO = '"+chkPermUsuario.isSelected()+"', PERM_ESTOQUE = '"+chkPermEstoque.isSelected()+"', PERM_ESTOQUE_CARGA = '"+chkPermCarga.isSelected()+"', PERM_ESTOQUE_MANUTENCAO = '"+chkPermManutencao.isSelected()+"', PERM_FINANCEIRO = '"+chkPermFinanceiro.isSelected()+"', PERM_FINANCEIRO_CONTAS_PAGAR = '"+chkPermContasPagar.isSelected()+"', PERM_FINANCEIRO_CONTAS_RECEBER = '"+chkPermContasReceber.isSelected()+"', PERM_FINANCEIRO_INVOICES = '"+chkPermInvoices.isSelected()+"', PERM_FINANCEIRO_FLUXO_CAIXA = '"+chkPermFluxoCaixa.isSelected()+"', PERM_FINANCEIRO_ENVIO_ARQUIVO = '"+chkPermEnvioArquivo.isSelected()+"', PERM_RELATORIOS = '"+chkPermRelatorios.isSelected()+"', PERM_VENDA_BALCAO = '"+chkPermVendaBalcao.isSelected()+"' WHERE NOME = '"+dados.getUsuario()+"'";
            PreparedStatement stm = conexao.prepareStatement(update);
            stm.execute(update);
            tabela.setItems(ListaUsuarios());
            campo1.clear();
            campo2.setValue("");
            campo3.clear();
            
            chkPermCadastro.setSelected(false);
            chkPermProdutos.setSelected(false);
            chkPermFornecedor.setSelected(false);
            chkPermFabricante.setSelected(false);
            chkPermCategoria.setSelected(false);
            chkPermUnidadeMedida.setSelected(false);
            chkPermEstabelecimento.setSelected(false);
            chkPermUsuario.setSelected(false);
            chkPermEstoque.setSelected(false);
            chkPermCarga.setSelected(false);
            chkPermManutencao.setSelected(false);
            chkPermFinanceiro.setSelected(false);
            chkPermContasPagar.setSelected(false);
            chkPermContasReceber.setSelected(false);
            chkPermInvoices.setSelected(false);
            chkPermFluxoCaixa.setSelected(false);
            chkPermEnvioArquivo.setSelected(false);
            chkPermRelatorios.setSelected(false);
            chkPermVendaBalcao.setSelected(false);
            
            if(chkPermCadastro.isSelected() == false){
                
                    chkPermProdutos.setSelected(false);
                    chkPermFornecedor.setSelected(false);
                    chkPermFabricante.setSelected(false);
                    chkPermCategoria.setSelected(false);
                    chkPermUnidadeMedida.setSelected(false);
                    chkPermEstabelecimento.setSelected(false);
                    chkPermUsuario.setSelected(false);

                    chkPermProdutos.setDisable(true);
                    chkPermFornecedor.setDisable(true);
                    chkPermFabricante.setDisable(true);
                    chkPermCategoria.setDisable(true);
                    chkPermUnidadeMedida.setDisable(true);
                    chkPermEstabelecimento.setDisable(true);
                    chkPermUsuario.setDisable(true);
                    
                    }else{
                
                        chkPermProdutos.setSelected(true);
                        chkPermFornecedor.setSelected(true);
                        chkPermFabricante.setSelected(true);
                        chkPermCategoria.setSelected(true);
                        chkPermUnidadeMedida.setSelected(true);
                        chkPermEstabelecimento.setSelected(true);
                        chkPermUsuario.setSelected(true);

                        chkPermProdutos.setDisable(false);
                        chkPermFornecedor.setDisable(false);
                        chkPermFabricante.setDisable(false);
                        chkPermCategoria.setDisable(false);
                        chkPermUnidadeMedida.setDisable(false);
                        chkPermEstabelecimento.setDisable(false);
                        chkPermUsuario.setDisable(false);
                    }

                    tabela.getSelectionModel().selectFirst();
                    conexao.close();
        } catch(Exception ex){
            MessageBox.show(""+ex, "Erro");
        }
    }
    public static void Cancelar(){
        
            campo1.clear();
            campo2.setValue("");
            campo3.clear();
            tabela.setDisable(false);
            btnEditar.setDisable(false);
            btnInserir.setDisable(false);
            btnAtualizar.setDisable(true);
            btnFechar.setDisable(false);
            btnExcluir.setDisable(false);
            btnCancelar.setDisable(true);

            chkPermCadastro.setSelected(false);
            chkPermProdutos.setSelected(false);
            chkPermFornecedor.setSelected(false);
            chkPermFabricante.setSelected(false);
            chkPermCategoria.setSelected(false);
            chkPermUnidadeMedida.setSelected(false);
            chkPermEstabelecimento.setSelected(false);
            chkPermUsuario.setSelected(false);
            chkPermEstoque.setSelected(false);
            chkPermCarga.setSelected(false);
            chkPermManutencao.setSelected(false);
            chkPermFinanceiro.setSelected(false);
            chkPermContasPagar.setSelected(false);
            chkPermContasReceber.setSelected(false);
            chkPermInvoices.setSelected(false);
            chkPermFluxoCaixa.setSelected(false);
            chkPermEnvioArquivo.setSelected(false);
            chkPermRelatorios.setSelected(false);
            chkPermVendaBalcao.setSelected(false);
        
            chkPermCadastro.setDisable(false);
            chkPermProdutos.setDisable(false);
            chkPermFornecedor.setDisable(false);
            chkPermFabricante.setDisable(false);
            chkPermCategoria.setDisable(false);
            chkPermUnidadeMedida.setDisable(false);
            chkPermEstabelecimento.setDisable(false);
            chkPermUsuario.setDisable(false);
        }
}