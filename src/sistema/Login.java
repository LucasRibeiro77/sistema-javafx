package sistema;


import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.*;
import javafx.geometry.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import java.io.*;
import java.net.URL;
import java.util.Locale;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.apache.derby.impl.drda.NetworkServerControlImpl;

public class Login extends Application{
    
    public static void main(String[] args){
        launch(args);
    }
    
    public static Connection conexao = Conexao.getConexao();
    public static StackPane painel = new StackPane();
    public static Scene cenario = new Scene(painel, 280, 170);
    public static GridPane painel2 = new GridPane();
    public static MaskedTextField campo1 = new MaskedTextField("U");
    public static PasswordField campo2 = new PasswordField();
    public static Label texto = new Label("Login");
    public static Label arg1 = new Label("Usuário: ");
    public static Label arg2 = new Label("Senha: ");
    public static Button btnOk = new Button("Acessar");
    public static Button btnCancel = new Button("Cancelar");
    public static Index User = new Index();
    public static Stage tela2 = new Stage();
    public static ImageView imageView;
    public static ImageView imageViewAlerta;
    public static ImageView imageViewAviso;
    public static ImageView imageViewOk;
    public static ImageView imageViewOkConexaoBd;
    public static ImageView imageViewOkEstoque;
    public static ImageView imageViewOkCargaEstoque;
    public static ImageView imageViewCancelar;
    public static ImageView imageViewCancelarEstoque;
    public static ImageView imageViewCancelarCargaEstoque;
    public static ImageView imageViewEditar;
    public static ImageView imageViewExcluir;
    public static ImageView imageViewFechar;
    public static ImageView imageViewAdicionar;
    public static ImageView imageViewSalvar;
    public static ImageView imageViewBaixar;
    public static ImageView imageViewFiltrar;
    public static ImageView imageViewImprimir;
    public static ImageView imageViewCaixa;
    public static ImageView imageViewCarga;
    public static ImageView imageViewSangria;
    public static ImageView imageViewDesconto;
    public static ImageView imageViewTroco;
    public static ImageView imageViewTesteBd;
    public static ImageView imageViewConexaoOkBd;
    public static ImageView imageViewFalhaConexaoBd;

        @Override 
        public void start(Stage inicio) throws Exception{
            
                tela2 = inicio;
                tela2.initStyle(StageStyle.UTILITY);
                tela2.setScene(cenario);
                tela2.setTitle("Login Sistema");
                Hyperlink url = new Hyperlink("Config. servidor");

                InputStream input = getClass().getResourceAsStream("icons8-erro-480.png");
                InputStream inputAlerta = getClass().getResourceAsStream("icons8-alta-prioridade-480.png");
                InputStream inputAviso = getClass().getResourceAsStream("icons8-prioridade-média-480.png");
                InputStream inputOk = getClass().getResourceAsStream("icons8-ok-48.png");
                InputStream inputOkConexaoBd = getClass().getResourceAsStream("icons8-ok-48.png");
                InputStream inputOkEstoque = getClass().getResourceAsStream("icons8-ok-48.png");
                InputStream inputOkCargaEstoque = getClass().getResourceAsStream("icons8-ok-48.png");
                InputStream inputCancelar = getClass().getResourceAsStream("icons8-cancelar-2-48.png");
                InputStream inputCancelarEstoque = getClass().getResourceAsStream("icons8-cancelar-2-48.png");
                InputStream inputCancelarCargaEstoque = getClass().getResourceAsStream("icons8-cancelar-2-48.png");
                InputStream inputEditar = getClass().getResourceAsStream("icons8-editar-48.png");
                InputStream inputExcluir = getClass().getResourceAsStream("icons8-excluir-48.png");
                InputStream inputAdicionar = getClass().getResourceAsStream("icons8-mais-48.png");
                InputStream inputFechar = getClass().getResourceAsStream("icons8-cancelar-48.png");
                InputStream inputSalvar = getClass().getResourceAsStream("icons8-salvar-48.png");
                InputStream inputBaixar = getClass().getResourceAsStream("icons8-receber-dinheiro-48.png");        
                InputStream inputFiltrar = getClass().getResourceAsStream("icons8-filtro-48.png");
                InputStream inputImprimir = getClass().getResourceAsStream("icons8-impressão-48.png");
                InputStream inputCaixa = getClass().getResourceAsStream("icons8-fluxo-de-caixa-48.png");
                InputStream inputCarga = getClass().getResourceAsStream("icons8-depósito-48.png");
                InputStream inputSangria = getClass().getResourceAsStream("icons8-retirada-48.png");
                InputStream inputDesconto = getClass().getResourceAsStream("icons8-desconto-48.png");
                InputStream inputTroco = getClass().getResourceAsStream("icons8-dinheiro-na-mão-48.png");
                InputStream inputTesteBd = getClass().getResourceAsStream("icons8-banco-de-dados-48.png");
                InputStream inputConexaoOkBd = getClass().getResourceAsStream("icons8-conectado-48.png");
                InputStream inputFalhaConexaoBd = getClass().getResourceAsStream("icons8-desconectado-48.png");

                Image imagem = new Image(input, 60, 70, true, true);
                Image imagemAlerta = new Image(inputAlerta, 60, 70, true, true);
                Image imagemTroco = new Image(inputTroco, 60, 70, true, true);
                Image imagemAviso = new Image(inputAviso, 60, 70, true, true);
                Image imagemOk = new Image(inputOk, 20, 20, true, true);
                Image imagemOkConexaoBd = new Image(inputOkConexaoBd, 20, 20, true, true);
                Image imagemOkEstoque = new Image(inputOkEstoque, 20, 20, true, true);
                Image imagemOkCargaEstoque = new Image(inputOkCargaEstoque, 20, 20, true, true);
                Image imagemCancelar = new Image(inputCancelar, 20, 20, true, true);
                Image imagemCancelarEstoque = new Image(inputCancelarEstoque, 20, 20, true, true);
                Image imagemCancelarCargaEstoque = new Image(inputCancelarCargaEstoque, 20, 20, true, true);
                Image imagemEditar = new Image(inputEditar, 20, 20, true, true);
                Image imagemExcluir = new Image(inputExcluir, 20, 20, true, true);
                Image imagemAdicionar = new Image(inputAdicionar, 20, 20, true, true);
                Image imagemFechar = new Image(inputFechar, 20, 20, true, true);
                Image imagemSalvar = new Image(inputSalvar, 20, 20, true, true);
                Image imagemBaixar = new Image(inputBaixar, 20, 20, true, true);        
                Image imagemImprimir = new Image(inputImprimir, 20, 20, true, true);
                Image imagemTesteBd = new Image(inputTesteBd, 20, 20, true, true);
                Image imagemFiltrar = new Image(inputFiltrar, 20, 20, true, true);
                Image imagemCaixa = new Image(inputCaixa, 50, 60, true, true);
                Image imagemCarga = new Image(inputCarga, 50, 60, true, true);
                Image imagemSangria = new Image(inputSangria, 50, 60, true, true);
                Image imagemDesconto = new Image(inputDesconto, 50, 60, true, true);
                Image imagemConexaoOkBd = new Image(inputConexaoOkBd, 55, 65, true, true);
                Image imagemFalhaConexaoBd = new Image(inputFalhaConexaoBd, 55, 65, true, true);

                imageView = new ImageView(imagem);            
                imageViewAlerta = new ImageView(imagemAlerta);            
                imageViewAviso = new ImageView(imagemAviso);            
                imageViewOk = new ImageView(imagemOk);            
                imageViewOkConexaoBd = new ImageView(imagemOkConexaoBd);            
                imageViewOkEstoque = new ImageView(imagemOkEstoque);            
                imageViewOkCargaEstoque = new ImageView(imagemOkCargaEstoque);            
                imageViewCancelar = new ImageView(imagemCancelar);            
                imageViewCancelarEstoque = new ImageView(imagemCancelarEstoque);            
                imageViewCancelarCargaEstoque = new ImageView(imagemCancelarCargaEstoque);            
                imageViewEditar = new ImageView(imagemEditar);            
                imageViewExcluir = new ImageView(imagemExcluir);            
                imageViewAdicionar = new ImageView(imagemAdicionar);
                imageViewFechar = new ImageView(imagemFechar);
                imageViewSalvar = new ImageView(imagemSalvar);
                imageViewBaixar = new ImageView(imagemBaixar);
                imageViewFiltrar = new ImageView(imagemFiltrar);
                imageViewImprimir = new ImageView(imagemImprimir);
                imageViewCaixa = new ImageView(imagemCaixa);            
                imageViewCarga = new ImageView(imagemCarga);            
                imageViewSangria = new ImageView(imagemSangria);            
                imageViewDesconto = new ImageView(imagemDesconto);            
                imageViewTroco = new ImageView(imagemTroco);            
                imageViewTesteBd = new ImageView(imagemTesteBd);            
                imageViewConexaoOkBd = new ImageView(imagemConexaoOkBd);
                imageViewFalhaConexaoBd = new ImageView(imagemFalhaConexaoBd);



                btnOk.setGraphic(imageViewOk);
                btnCancel.setGraphic(imageViewCancelar);

                btnCancel.setOnAction(e -> inicio.close());
                btnOk.setOnKeyPressed(evt -> {
                    if(btnOk.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        Acessar();
                    }
                });
                campo1.setOnKeyPressed(evt -> {
                    if(campo1.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        Acessar();
                    }
                });
                campo2.setOnKeyPressed(evt -> {
                    if(campo2.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        Acessar();
                    }
                });
                btnCancel.setOnKeyPressed(evt -> {
                    if(btnCancel.isFocused() == true && evt.getCode() == KeyCode.ENTER){
                        inicio.close();
                    }
                });
                btnOk.setOnAction(e -> {
                   Acessar();
                });

                painel2.setVgap(5);
                painel2.setHgap(5);
                painel2.add(arg1, 0, 0);
                painel2.add(campo1, 1, 0);
                painel2.add(arg2, 0, 1);
                painel2.add(campo2, 1, 1);
                painel2.add(btnOk, 0, 2);
                painel2.add(btnCancel, 1, 2);
                painel2.add(url, 0, 3);

                url.setOnAction(e -> {
                    try {
                        ConfigConexaoBd.show("","");
                    } catch (IOException ex) {
                        Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                campo1.setPlaceholder(" ");
                campo1.setMask("UUUUUUUUUU");

                painel2.setAlignment(Pos.CENTER);
                painel.setPadding(new Insets(15));
                painel.setStyle("-fx-border-color: gray; -fx-border-insets: 20 8 8 8; -fx-padding: -10 5 5 5; -fx-border-radius: 2");
                texto.setStyle("-fx-background-color: #F4F4F4;");
                arg1.setStyle("-fx-font-weight: bold");
                arg2.setStyle("-fx-font-weight: bold");
                painel.setAlignment(texto, Pos.TOP_LEFT);
                painel.getChildren().addAll(texto, painel2);
                tela2.show();
            }
            public static boolean Acessar(){
                int cont = 0;
                boolean verificador = false;
                horas horario = new horas();
                Timer timer = new Timer(1000, horario);
                Label horas = new Label(String.format("horas:"+timer));
                try {
                    String sql = "SELECT COUNT(*) AS cont FROM USUARIO WHERE NOME = '"+campo1.getText()+"' AND PASS = '"+campo2.getText()+"'";
                    String consulta = "SELECT * FROM USUARIO WHERE USUARIO.NOME = '"+campo1.getText()+"'";
                    String query = "SELECT * FROM ESTABELECIMENTO WHERE TRANSPORTADOR = 'true'";
                    String queryupdate = "UPDATE USUARIO SET STATUS = 'OPERANDO' WHERE NOME = '"+campo1.getText()+"' AND PASS = '"+campo2.getText()+"'";
                    PreparedStatement stm = conexao.prepareStatement(sql);
                    PreparedStatement state = conexao.prepareStatement(consulta);
                    PreparedStatement statement = conexao.prepareStatement(query);
                    PreparedStatement updatestatement = conexao.prepareStatement(queryupdate);
                    ResultSet rs = stm.executeQuery(sql);
                    ResultSet resultado = state.executeQuery(consulta);
                    ResultSet result = statement.executeQuery(query);

                    while(rs.next()){
                        cont = rs.getInt("cont");
                    }
                    if(cont == 1){
                        verificador = true;
                            while(resultado.next()){                  

                            updatestatement.execute(queryupdate);
                            User.show(""+resultado.getString("NOME")+"  |   CARGO: "+resultado.getString("CARGO"), "Sistema");
                            tela2.close();
                        }
                    } else{
                        MessageBox.show("Usuário ou senha inválidos", "Erro");
                    }
                } catch (Exception ex) {
                    MessageBox.show(""+ex,"Erro");
                }
                return verificador;
            }
            public static boolean AcessoMenus(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoProdutos(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_PRODUTOS = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoFornecedores(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_FORNECEDOR = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoFabricante(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_FABRICANTE = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoUnidadeMedida(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_UNIDADE_MEDIDA = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoCategoria(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_CATEGORIA = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoEstabelecimento(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_ESTABELECIMENTO = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoUsuarios(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_CADASTRO_USUARIO = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoEstoque(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_ESTOQUE = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoCarga(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_ESTOQUE_CARGA = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }    
            public static boolean AcessoManutencao(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_ESTOQUE_MANUTENCAO = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoFinanceiro(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_FINANCEIRO = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
            public static boolean AcessoContasPagar(){
                    Login lg = new Login();
                    boolean verificador = false;
                try{
                    Connection conn = Conexao.getConexao();
                    String sql = "SELECT COUNT(*) as COUNT FROM USUARIO WHERE NOME = '"+Login.campo1.getText()+"' AND PERM_FINANCEIRO_CONTAS_PAGAR = 'false';";
                    PreparedStatement st = conn.prepareStatement(sql);
                    ResultSet rs = st.executeQuery(sql);
                    int count = 0;

                    while(rs.next()){
                        count = rs.getInt("COUNT");
                    }
                    if(count == 1){
                        verificador = true;
                        while(rs.next()){
                        }
                    }
                    conn.close();
                }catch(Exception ex){
                    System.out.println(ex);
                }
                return verificador;
            }
}
