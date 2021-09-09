package sistema;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import static java.nio.file.Files.list;
import static java.rmi.Naming.list;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.*;
import java.sql.*;
import static java.util.Collections.list;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.*;
import net.sf.*;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import static sistema.Login.*;

public class Index{
    
        public static String url;
	public static String driver;
	public static String login;
	public static String pwd;
        public static Connection conn;
        Stage palco2 = new Stage();
        DateFormat data = new SimpleDateFormat("dd/MM/yyyy");
        Date d = new Date();
        String strData = data.format(d);
        Label dataD = new Label(strData);
        Label dataH = new Label(); 
	BorderPane painel = new BorderPane();
        //BorderPane painel2 = new BorderPane();
        GridPane barra = new GridPane();
	Scene cenario = new Scene(painel, 1010,525);
        Stage inicio = new Stage();
        public static Label mensagem;
        public static MenuBar barraMenu = new MenuBar();
	Menu Registro = new Menu("_Registro	");
        Menu Cliente = new Menu("_Cliente");
	Menu Sistema = new Menu("_Sistema  ");
        Menu financeiro = new Menu("_Financeiro");
        Menu fiscal = new Menu("_Fiscal");
        Menu cfe = new Menu("_CFe");
        Menu EnvioArquivo = new Menu("_Envio de arquivo");
        public static Menu Relatorios = new Menu("_Relatórios");
        MenuItem VendaCaixa = new MenuItem("_Venda Caixa");
        MenuItem invoices = new MenuItem("_Invoices");
        MenuItem pessoaFisica = new MenuItem("_Pessoa Física");
        MenuItem pessoaJuridica = new MenuItem("_Pessoa Juridica");
        MenuItem relatorioVendas = new MenuItem("_Acompanhamento de vendas");
        MenuItem relatorioBalanco = new MenuItem("_Balanço");
        MenuItem relatorioComissionamento = new MenuItem("_Comissionamento");
        MenuItem relatorioMovimentacao = new MenuItem("_Movimentação");
        MenuItem relatorioLucratividade = new MenuItem("_Lucratividade");
        MenuItem relatorioOrcamentos = new MenuItem("_Orçamentos emitidos");
        MenuItem relatorioFisico_Financeiro = new MenuItem("_Fisico X Financeiro");
        MenuItem relatorioProtocolos = new MenuItem("_Protocolos");
        MenuItem relatorioEntrada = new MenuItem("_Entradas");
        MenuItem relatorioBalancoEstoque = new MenuItem("_Balanço Estoque");
        MenuItem relatorioProdutos = new MenuItem("_Acompanhamento de produtos");
        MenuItem relatorioCancelamentos = new MenuItem("_Cancelamentos");
        public static Menu VendaBalcao = new Menu("_Venda Balcão");
        Menu estoque = new Menu("_Estoque");
        public static Menu Cadastro = new Menu("_Cadastro");
        public static Menu nfe = new Menu("_NFe");
	public static MenuItem Usuario = new MenuItem("_Usuario  ");
        public static MenuItem EnvItensNFe = new MenuItem("_Montar NFe  ");
        public static MenuItem carga = new MenuItem("Ca_rga de estoque");
        public static MenuItem manutencao = new MenuItem("_Manutenção de estoque");
	public static MenuItem Novo = new MenuItem("_Novo  ");
	public static MenuItem Sair = new MenuItem("_Sair  ");
        public static MenuItem conexao = new MenuItem("_Teste de Conexão ao BD");
        public MenuItem contasPagar = new MenuItem("_Contas a pagar");
        public static MenuItem contasReceber = new MenuItem("Contas a _Receber");
        public static MenuItem sped = new MenuItem("Arquivo _SPED contábil");
        public static MenuItem unidadeMedida = new MenuItem("Unidade de _Medida");
        public static MenuItem fornecedores = new MenuItem("_Fornecedores");
        public static MenuItem fabricante = new MenuItem("Fabrica_nte");
        public static MenuItem categoria = new MenuItem("Cate_goria");
        public static MenuItem estabelecimento = new MenuItem("Es_tabelecimento");
        public static MenuItem fluxoCaixa = new MenuItem("Fluxo de Caixa");
        public static MenuItem trocaUsuario = new MenuItem("Trocar Usuário");
        public static MenuItem consultarNfe = new MenuItem("Consultar NFe");
        public static MenuItem cancelarNfe = new MenuItem("Cancelar NFe");
        public static MenuItem cancelarCfe = new MenuItem("Cancelar CFe");
        public static MenuItem consultarCfe = new MenuItem("Consultar CFe");
        public static MenuItem emitirNfe = new MenuItem("Assinar/Transmitir NFe");    
        public static MenuItem spedFiscal = new MenuItem("Arquivo SPED Fiscal");
        public static MenuItem Configuracao = new MenuItem("Confi_gurações");
        public static MenuItem produtos;
        public static Menu relatorioFisico = new Menu("Físico");
        public static Menu relatorioFinanceiro = new Menu("Financeiro");
        public static String dados;
        //public static Login login;
        
        public Index() {
	}
	public void show(String message, String Title){
         
                
            
                dados = message;
                
                inicio.setScene(cenario);
                inicio.initModality(Modality.APPLICATION_MODAL);
                inicio.setMaximized(true);
                
                //login = new Login();
                
    		inicio.setTitle(Title);
                
                produtos = new MenuItem("_Produtos");
                //conn = new Connection();
 
                if(AcessoMenus() == true){
                    Cadastro.setVisible(false);
                }
                if(AcessoProdutos() == true){
                    produtos.setVisible(false);
                    produtos.setDisable(true);
                } 
                if(AcessoFornecedores() == true){
                    fornecedores.setVisible(false);
                    fornecedores.setDisable(true);
                }
                if(AcessoFabricante() == true){
                    fabricante.setVisible(false);
                    fabricante.setDisable(true);
                } 
                if(AcessoUnidadeMedida() == true){
                    unidadeMedida.setVisible(false);
                    unidadeMedida.setDisable(true);
                } 
                if(AcessoCategoria() == true){
                    categoria.setVisible(false);
                    categoria.setDisable(true);
                } 
                if(AcessoEstabelecimento() == true){
                    estabelecimento.setVisible(false);
                    estabelecimento.setDisable(true);
                } 
                if(AcessoUsuarios() == true){
                    Usuario.setVisible(false);
                    Usuario.setDisable(true);
                }
                if(AcessoEstoque() == true){
                    estoque.setVisible(false);
                    estoque.setDisable(true);
                }
                if(AcessoCarga() == true){
                    carga.setVisible(false);
                    carga.setDisable(true);
                }
                if(AcessoManutencao() == true){
                    manutencao.setVisible(false);
                    manutencao.setDisable(true);
                }
                if(AcessoFinanceiro() == true){
                    financeiro.setVisible(false);
                    financeiro.setDisable(true);
                }
                if(AcessoContasPagar() == true){
                    contasPagar.setVisible(false);
                    contasPagar.setDisable(true);
                }/*
                if(AcessoContasReceber() == true){
                    contasReceber.setVisible(false);
                    contasReceber.setDisable(true);
                }
                if(AcessoInvoices() == true){
                    invoices.setVisible(false);
                    invoices.setDisable(true);
                }*/
                mensagem = new Label(message);
		barraMenu.getMenus().addAll(Cadastro, estoque, fiscal, financeiro, Relatorios, VendaBalcao, Sistema);
                Relatorios.getItems().addAll(relatorioFisico, relatorioFinanceiro);
                relatorioFinanceiro.getItems().addAll(relatorioVendas, relatorioBalanco, relatorioFisico_Financeiro, relatorioComissionamento, relatorioLucratividade, relatorioMovimentacao, relatorioOrcamentos, relatorioProtocolos);
                relatorioFisico.getItems().addAll(relatorioEntrada, relatorioBalancoEstoque, relatorioProdutos, relatorioCancelamentos);
                fiscal.getItems().addAll(nfe, cfe, spedFiscal);
                financeiro.getItems().addAll(contasPagar, contasReceber, invoices, EnvioArquivo);
                estoque.getItems().addAll(carga, manutencao);
                Cadastro.getItems().addAll(produtos, fornecedores, fabricante, Cliente, unidadeMedida, categoria, estabelecimento, Usuario);
                Cliente.getItems().addAll(pessoaFisica, pessoaJuridica);
                EnvioArquivo.getItems().add(sped);
		//Sistema.getItems().addAll(conexao, VendaCaixa, Configuracao, trocaUsuario, Sair);
                Sistema.getItems().addAll(conexao, VendaCaixa, Configuracao, Sair);
                nfe.getItems().addAll(EnvItensNFe, emitirNfe, consultarNfe, cancelarNfe);
                cfe.getItems().addAll(consultarCfe, cancelarCfe);
		Registro.getItems().addAll(Novo);
                relatorioBalanco.setOnAction(e -> RelatorioBalanco.show("Tipo: ","Relatório de Balanço"));   
                /*relatorioFisico.setOnAction(e -> {
                        PrintReport viewReport = new PrintReport();
                        viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '2020-05-01 00:00:00' AND '2020-05-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '2020-05-01 00:00:00' AND '2020-05-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 500);
                    
                });*/
                
                EnvItensNFe.setOnAction(e -> ItensNfe.show("Itens NFe","Enviar Itens para NFe"));
                Configuracao.setOnAction(e -> {
                    try {
                        Configuracoes.show("Configurações", "Configurações");
                    } catch (KeyStoreException ex) {
                        Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (NoSuchAlgorithmException ex) {
                        Logger.getLogger(Index.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                trocaUsuario.setOnAction(e-> inicio.close());
                //estoque.setOnAction(e -> EstoqueAdd.show("Itens NFe","Enviar Itens para NFe"));
                carga.setOnAction(e -> cargaEstoque.show("Carga estoque", "Dados carga"));
                emitirNfe.setOnAction(e -> EmitirNFe.show("","Emitir NFe"));
                conexao.setOnAction(e -> testeConexao.show("Teste de Conexão ao BD", "Teste de Conexão"));
		Novo.setOnAction(e -> NovoRegistro.show("Novo Registro", "Novo Registro"));
		Usuario.setOnAction(e -> CadastroUsuario.show("Novo Usuário", "Cadastro de Usuário"));
                produtos.setOnAction(e -> {
                    Produto.show("Produtos","Cadastro de Produtos");
                });
                unidadeMedida.setOnAction(e -> cadastroUndMedida.show("","Cadastro Unidade de Medida"));
                fabricante.setOnAction(e -> cadastroFabricante.show("Fabricante", "Cadastro de Fabricante"));
                VendaCaixa.setOnAction(e -> {
                    //String numero = String.valueOf(GerarProtocolo());
                    //int num = Integer.parseInt(numero) + 1;
                    VerificarCaixa();
                    //Venda.show("", "Console de Vendas");
                });
                fornecedores.setOnAction(e -> cadastroFornecedores.show("Cadastro de Fornecedores", "Cadastro de Fornecedores"));
		Sair.setOnAction(e -> {
                    try{
                        Connection conexao = Conexao.getConexao();

                        String sql = "UPDATE USUARIO SET STATUS = 'NAO OPERANDO' WHERE NOME = '"+Login.campo1.getText()+"' AND PASS = '"+Login.campo2.getText()+"'";

                        PreparedStatement stm = conexao.prepareStatement(sql);

                        stm.execute(sql);

                        inicio.close();
                    }catch(Exception ex){
                        System.out.println(e);
                    }
                });
                estabelecimento.setOnAction(e -> cadastroEstabelecimento.show("Estabelecimento","Cadastro de Estabelecimento"));
                
                contasPagar.setOnAction(e -> ContasPagar.show("Contas a Pagar", "Contas a Pagar"));
                
                Label infoUser = new Label("USUÁRIO: ");
                Label infoData = new Label("   |   DATA: ");
                
                barra.setVgap(5);
                barra.setHgap(5);
                barra.setStyle("-fx-border-color: #D3D3D3; -fx-border-solid: 1; -fx-border-padding: -2 5 5 5;");
                barra.add(infoUser, 0, 0);
                barra.add(mensagem, 1, 0);
                barra.add(infoData, 2, 0);
                barra.add(dataD, 3, 0);
                barra.setPadding(new Insets(5));
		painel.setTop(barraMenu);
                painel.setBottom(barra);
                
                inicio.showAndWait();
        }
        public void Empresa(){
            ResultSet rs;
            
            try{
                Connection conexao = Conexao.getConexao();
                String sql = "SELECT * FROM ESTABELECIMENTO WHERE ESTAB = 'true'";
                Statement stm = conexao.prepareStatement(sql);
                rs = stm.executeQuery(sql);
                
                while(rs.next()){
                    String empresa = rs.getString("RAZAOSOCIAL");
                }
            }catch(Exception e){
                System.err.println(e);
            }
        }

    public ObservableList<protocolo> GerarProtocolo() {
        ResultSet rs;
                    PreparedStatement stm;
                    ObservableList<protocolo> dados = FXCollections.observableArrayList();
                    try{
                        Connection conexao = Conexao.getConexao();
                        String consulta = "SELECT protocolo FROM caixa ORDER BY id DESC limit 1;";
                        stm = conexao.prepareStatement(consulta);
                        rs = stm.executeQuery(consulta);

                        while(rs.next()){
                            String protocolo = rs.getString("PROTOCOLO");    
                            dados.add(new protocolo(protocolo));
                        }
                   }catch(Exception ex){
                        System.err.println(ex);
                   }
                   return dados;
    }
    
    public static boolean VerificarCaixa(){
                
                        int cont = 0;
                        int count = 0;
                        boolean verificador = false;
                        boolean verify = false;
                        Connection conexao = Conexao.getConexao();

                        try {
                            //String sql = "SELECT COUNT(*) AS cont FROM saldo_total WHERE STATUS = 'FECHADO'";
                            String sql = "SELECT COUNT(*) AS cont FROM saldo_total WHERE STATUS = 'FECHADO' AND USUARIO = '"+Login.campo1.getText()+"';";

                            //String mysql = "SELECT COUNT(*) AS cont FROM saldo_total WHERE STATUS = 'ABERTO'";
                            String mysql = "SELECT COUNT(*) AS cont FROM saldo_total WHERE STATUS = 'ABERTO' AND USUARIO = '"+Login.campo1.getText()+"';";
                            
                            PreparedStatement stm = conexao.prepareStatement(sql);
                            
                            PreparedStatement stmsql = conexao.prepareStatement(mysql);

                            ResultSet rs = stm.executeQuery(sql);
                            
                            ResultSet rslt = stmsql.executeQuery(mysql);

                            while(rs.next()){
                                cont = rs.getInt("cont");
                            }
                            while(rslt.next()){
                                count = rslt.getInt("cont");
                            }/*
                            if(cont == 1){
                                verificador = true;
                                AbrirCaixa.show("Valor Abertura","Abertura de caixa");
                            }*/
                            if(count == 1){
                                verificador = true;
                                Venda.show("", "Ponto de Venda");
                            }else{
                                verificador = false;
                                AbrirCaixa.show("Valor Abertura","Abertura de caixa");
                            }
                        } catch (Exception ex) {
                            MessageBox.show(""+ex,"Erro");
                        }
                        return verificador;
            }		
        public void gerar() throws JRException{
                Connection conn = Conexao.getConexao();
                InputStream jasperFile = Thread.currentThread().getClass().getResourceAsStream("/relatorio/relatorioProdutos.jasper");
                
                JasperPrint relatorio;
                JasperReport jasperReport;
                Map parametros = new HashMap();//C:\SistemaSmartSoft\build\classes\SistemaSmartSoft\impressao
                try {
                    jasperReport = (JasperReport) JRLoader.loadObject(jasperFile);

                    parametros.put("ID",(15));
                    parametros.put("DESCRICAO", ("SOVADINHO BAUNILHA 350G                           "));

                    relatorio = JasperFillManager.fillReport(jasperReport, parametros, conn);
                    JasperViewer viewer = new JasperViewer(relatorio, false);
                    viewer.setTitle("Relatório");
                    viewer.setVisible(true);
                } catch (JRException jRException) {
                    jRException.printStackTrace();
                }
	}

}