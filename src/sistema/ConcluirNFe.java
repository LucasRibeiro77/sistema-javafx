package sistema;

import java.security.KeyStore;  
import java.security.cert.X509Certificate;  
import java.text.SimpleDateFormat;  
import java.util.Enumeration;  
import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import java.io.BufferedReader;  
import java.io.ByteArrayInputStream;  
import java.io.ByteArrayOutputStream;  
import java.io.File;
import java.io.FileInputStream;  
import java.io.IOException;  
import java.io.InputStream;  
import java.io.InputStreamReader;  
import java.security.InvalidAlgorithmParameterException;  
import java.security.KeyStore;  
import java.security.NoSuchAlgorithmException;  
import java.security.PrivateKey;  
import java.security.PublicKey;
import java.security.cert.X509Certificate;  
import java.sql.PreparedStatement;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Enumeration;  
import java.util.List;  
import javax.xml.crypto.dsig.CanonicalizationMethod;  
import javax.xml.crypto.dsig.DigestMethod;  
import javax.xml.crypto.dsig.Reference;  
import javax.xml.crypto.dsig.SignatureMethod;  
import javax.xml.crypto.dsig.SignedInfo;  
import javax.xml.crypto.dsig.Transform;  
import javax.xml.crypto.dsig.XMLSignature;  
import javax.xml.crypto.dsig.XMLSignatureFactory;  
import javax.xml.crypto.dsig.dom.DOMSignContext;  
import javax.xml.crypto.dsig.keyinfo.KeyInfo;  
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;  
import javax.xml.crypto.dsig.keyinfo.X509Data;  
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;  
import javax.xml.crypto.dsig.spec.TransformParameterSpec;  
import javax.xml.parsers.DocumentBuilderFactory;  
import javax.xml.parsers.ParserConfigurationException;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;  
import static sistema.Configuracoes.DadosCertificadoRepositorioWindows;
import static sistema.Configuracoes.DadosConfigNFe;
import static sistema.Configuracoes.cbCertificados;

public class ConcluirNFe {

    public static String C14N = "http://www.w3.org/TR/xml-c14n11/";
    public static TextArea txtInfoComplementares;
    public static TextArea txtInfoContribuinte;
    public static TextField txtValorPagamento;
    public static ComboBox cbMeioPagamento;
    public static ComboBox cbFormaPagamento;
    public static String dataFormatada;
    public static String dataFormatadaD;
    public static String txtDataEmissao;
    public static ByteArrayOutputStream outputStream;
    public static Writer writer;
    public static String xml;
    public static VBox painelPrincipal;
    public static HBox linha1;
    public static HBox linha2;
    public static HBox linha3;
    public static HBox linha4;
    public static StackPane painelBotoes;
    public static Label lblInfoComplementares;
    public static Label lblInfoContribuinte;
    public static Label lblValorPagamento;
    public static Label lblMeioPagamento;
    public static Label lblFormaPagamento;
    public static Label lblChavesRef;
    public static Button btnOK;
    public static Button btnCancelar;
    public static Stage inicio;
    public static Scene cenario;
    public static PrintWriter gravarArq;
    public static OutputStreamWriter arq;
    public static final String INFINUT = "infInut";  
    public static final String INFCANC = "infCanc";  
    public static String NFE = "infNfe";  
    public PrivateKey privateKey;  
    public KeyInfo keyInfo; 
    public static DadosProdutosAdd data;
    public static LocalDate dataEmissao;
    public static Format format;
    public static Date dataE;
    public static Calendar c;
    public static String dataAno;
    public static String dataMes;
    public static String dataDia;
    public static DadosCFOP cfop;
    public static String chave;
    public static String versao;
    public static String UF;
    public static String digitoVerificador;
    public static Random gerador = new Random();
    public static String protocolo;
    public static ConcluirNFe nfe;
    public static String chaveNFe;
    public static String fileEnviNFe;
    
    public static void show(String message, String title){
        
                lblInfoComplementares = new Label("   Informações complementares de interesse do Fisco");
                lblInfoContribuinte = new Label("   Informações complementares de interesse do Contribuinte");
                lblValorPagamento = new Label("Valor Pagamento");
                lblMeioPagamento = new Label("Meio Pagamento");
                lblFormaPagamento = new Label("Forma Pagamento");
                lblChavesRef = new Label();

                painelPrincipal = new VBox(5);
                linha1 = new HBox(5);
                linha2 = new HBox(5);
                linha3 = new HBox(5);
                linha4 = new HBox(5);
                painelBotoes = new StackPane();

                txtInfoComplementares = new TextArea();
                txtInfoContribuinte = new TextArea();
                cbMeioPagamento = new ComboBox();
                cbFormaPagamento = new ComboBox();
                txtValorPagamento = new TextField();

                btnOK = new Button("Concluir");
                btnCancelar = new Button("Cancelar");

                inicio = new Stage();
                inicio.initModality(Modality.APPLICATION_MODAL);
                cenario = new Scene(painelPrincipal, 1002, 502);

                cbMeioPagamento.getItems().addAll("1 - Dinheiro", "2 - Cheque", "3 - Cartao de Credito", "4 - Cartao de Debito", "5 - Credito Loja", "10 - Vale Alimentacao", "11 - Vale Refeicao", "12 - Vale Presente", "13 - Vale Combustivel", "15 - Boleto Bancario", "90 - Sem Pagamento", "99 - Outros");
                cbFormaPagamento.getItems().addAll("Pagamento a Vista", "Pagamento a Prazo", "Outros");

                inicio.setScene(cenario);
                inicio.initModality(Modality.APPLICATION_MODAL);

                btnOK.setOnAction(e -> {
                    try {
                        btnOK();
                    } catch (IOException ex) {
                        System.err.println(ex);
                    } catch (Exception ex) {
                        Logger.getLogger(ConcluirNFe.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });

                txtInfoComplementares.setPrefWidth(990);
                txtInfoComplementares.setPrefHeight(170);
                txtInfoContribuinte.setPrefWidth(990);

                btnCancelar.setOnAction(e -> inicio.close());
                txtInfoComplementares.setText("NFe Ref.: "+String.valueOf(EmitirNFe.listaChave()).replace("[", "(").replace("]",")\n"));

                painelBotoes.getChildren().addAll(linha4);
                linha1.setPadding(new Insets(10));
                linha1.getChildren().addAll(lblMeioPagamento, cbMeioPagamento, lblValorPagamento, txtValorPagamento, lblFormaPagamento, cbFormaPagamento);
                linha2.setPadding(new Insets(10));
                linha2.getChildren().addAll(txtInfoComplementares);
                linha3.setPadding(new Insets(10));
                linha3.getChildren().addAll(txtInfoContribuinte);
                linha4.setPadding(new Insets(10));
                linha4.getChildren().addAll(btnOK, btnCancelar);
                painelPrincipal.getChildren().addAll(linha1, lblInfoComplementares, linha2, lblInfoContribuinte, linha3, painelBotoes);

                inicio.showAndWait();
        }
    
        public static ObservableList<DadosProdutosNFeAdd> ListaNFeAdd(){
        
        ObservableList<DadosProdutosNFeAdd> dados = FXCollections.observableArrayList();
        
        Connection conexao = Conexao.getConexao();
        ResultSet rs;
        
        try{
            String sql = "SELECT * FROM ITEMSNFE;";
            Statement stm = conexao.prepareStatement(sql);
            rs = stm.executeQuery(sql);
            
            while(rs.next()){
                    String id = rs.getString("ID_PRODUTO");
                    String descricao = rs.getString("DESCRICAO");
                    String barras = rs.getString("BARRAS");
                    String ncm = rs.getString("NCM");
                    String cest = rs.getString("CEST");
                    String und_medida = rs.getString("UND_MEDIDA");
                    String qtde = rs.getString("QTDE");
                    String valor_pago = rs.getString("VALOR_UNITARIO");
                    String valor_total = rs.getString("VALOR_TOTAL_UNITARIO");
                    String ii = rs.getString("ALIQ_II");
                    String ipi = rs.getString("ALIQ_IPI");
                    String pis = rs.getString("ALIQ_PIS");
                    String cofins = rs.getString("ALIQ_COFINS");
                    String icms = rs.getString("ALIQ_ICMS");
                    String mva = rs.getString("MVA");
                    String redutor = rs.getString("REDUTOR_ICMS");
                    String redutor_st = rs.getString("REDUTOR_ICMS_ST");
                    String seguro = rs.getString("VALOR_SEGURO");
                    String outros = rs.getString("OUTRAS_DESPESAS");
                    String desconto = rs.getString("VALOR_DESCONTO");
                    String frete = rs.getString("VALOR_FRETE");
                    String FCP = rs.getString("ALIQ_FCP");
                    String CST_ICMS = rs.getString("CST_ICMS");
                    String Origem = rs.getString("ORIGEM_ICMS");
                    String CST_IPI = rs.getString("CST_IPI");
                    String CodEnquadramento = rs.getString("ENQUADRAMENTO");
                    String CST_PIS = rs.getString("CST_PIS");
                    String CST_COFINS = rs.getString("CST_COFINS");
                    String base_calc_icms = rs.getString("BASE_ICMS");
                    String valorIcms = rs.getString("VALORICMS");
                    String base_icms_st = rs.getString("BASE_ICMS_ST");
                    String valor_icms_st = rs.getString("VALOR_ICMS_ST");
                    String base_ipi = rs.getString("BASE_IPI");
                    String valor_ipi = rs.getString("VALOR_IPI");
                    String base_pis = rs.getString("BASE_PIS");
                    String valor_pis = rs.getString("VALOR_PIS");
                    String base_cofins = rs.getString("BASE_COFINS");
                    String valor_cofins = rs.getString("VALOR_COFINS");
                    String valor_fcp = rs.getString("VALOR_FCP");
                    
                    dados.add(new DadosProdutosNFeAdd("<id>"+id+"</id>\n",  descricao,  barras,  ncm,  cest,  und_medida,  qtde,  valor_pago,   valor_total,  ii,  ipi,  pis,  cofins,  icms,  mva,  redutor,  redutor_st,  seguro,  outros,  desconto,  frete,  FCP,  CST_ICMS,  Origem,  CST_IPI,  CodEnquadramento,  CST_PIS,  CST_COFINS,  base_calc_icms,  valorIcms,  base_icms_st,  valor_icms_st,  base_ipi,  valor_ipi,  base_pis,  valor_pis,  base_cofins,  valor_cofins,  valor_fcp));
            }
        }catch(Exception ex){
            System.err.println(ex);
        }
        return dados;
    }
    public static Integer modulo11(String codigo) {
        try {
            int total = 0;
            int peso = 2;

            for (int i = 0; i < codigo.length(); i++) {
                total += (codigo.charAt((codigo.length() - 1) - i) - '0') * peso;
                peso++;
                if (peso == 10) {
                    peso = 2;
                }
            }
            int resto = total % 11;
            return (resto == 0 || resto == 1) ? 0 : (11 - resto);
        } catch (Exception e) {
            return 0;
        }
    }    
        
    public static void btnOK() throws IOException, Exception{

            outputStream = new ByteArrayOutputStream();
            writer = new OutputStreamWriter(outputStream, "UTF-8");
            xml = outputStream.toString("UTF-8");
            String MeioPagamento = String.valueOf(cbMeioPagamento.getValue());
            DadosProdutosAdd data = ItensNFeAdd.tabela.getSelectionModel().getSelectedItem();
            
            int i;
            String resultadoForma;

                if(cbFormaPagamento.getValue() == "Pagamento a Vista"){
                    resultadoForma = "1";
                }else{
                    resultadoForma = "2";
                }

            ObservableList<DadosProdutosAdd> produtos = ItensNFeAdd.tabela.getSelectionModel().getSelectedItems();
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");
            Date dataD;
            Date dataDa;
            try {
                dataDa = formato.parse(String.valueOf(LocalDate.now()));
                formato.applyPattern("dd/MM/yy");
                dataFormatadaD = formato.format(dataDa);
            } catch (ParseException ex) {
                Logger.getLogger(carga.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            dataEmissao = LocalDate.now();
            format = new SimpleDateFormat("MM");
            dataE = new Date();
	    c = Calendar.getInstance();
	    c.setTime(dataE);
            dataAno = String.valueOf(dataEmissao.getYear());
            dataMes = String.valueOf(format.format(c.getTime()));
            dataDia = String.valueOf(dataEmissao.getDayOfMonth());
            cfop = (DadosCFOP) EmitirNFe.cbCFOP.getSelectionModel().getSelectedItem();
            String frete = String.valueOf(EmitirNFe.cbModalidadeFrete.getValue());
            gerador = new Random();
            protocolo = String.format("%08d",gerador.nextInt()).replace("-","").substring(0, 8);
            chave = ""+data.getCodUf()+dataAno.substring(2)+dataMes+data.getCNPJEmit()+"55001"+EmitirNFe.txtNrNota.getText().replace(" ","")+"1"+String.format("%08d",gerador.nextInt()).replace("-","")+"";
            versao = "4.0";
            UF = data.getEstadoEmit();       
            digitoVerificador = String.valueOf(modulo11(chave));
            
            chaveNFe = ""+data.getCodUf()+dataAno.substring(2)+dataMes+data.getCNPJEmit()+"55001"+EmitirNFe.txtNrNota.getText().replace(" ","")+"1"+protocolo+digitoVerificador+"";
            
            Date dataHoraAtual = new Date();
            String dataAtual = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
            String horaAtual = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
            String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);
            String XmlNovo = "C:\\Users\\USER\\Documents\\Sistema\\dist\\notaassinado.xml";
            String tipo = "1";
            String senha = "xt5ged5q";
            fileEnviNFe = "C:\\Users\\USER\\Documents\\Sistema\\dist\\";
            
            try{
                
                criaArquivoXml.criar(fileEnviNFe);
                
            }catch(Exception e){
                
                System.out.println(e);
                
            }
            
            try {

                DadosCertificado certificado = new DadosCertificado(DadosConfigNFe().getCertificado());        

                CarregaCertificadoA1 carregaCertificadoWindows = new CarregaCertificadoA1();
                CertificadoA1 certificadoA1Windows = new CertificadoA1();
                certificadoA1Windows = carregaCertificadoWindows.certificadoWindows(String.valueOf(certificado), "");

                AssinadorXMLNovo assinaWindows = new AssinadorXMLNovo();

                System.out.println(assinaWindows.assinaNFe("c:/Users/USER/Documents/Sistema/dist/NFe.xml", certificadoA1Windows));

                System.out.println("Arquivo xml assinado com sucesso" + fileEnviNFe + "!");
                
                } catch (Exception e) {
                        System.out.println("Erro ao tentar assinar arquivo xml! \n\n" + e.toString()+"\n\n");
                }
        }      

    public static DadosConfigNFe DadosConfigNFe(){
                ResultSet rs;
                DadosConfigNFe d = new DadosConfigNFe();

                try{
                    Connection conexao = ConnectConfiguracao.getConexao();
                    String consulta = "SELECT * FROM CONFIG_NFE;";
                    PreparedStatement stm = conexao.prepareStatement(consulta);
                    rs = stm.executeQuery();

                    while(rs.next()){

                        d.setFormaEmissao(rs.getString("FORMA_EMISSAO"));
                        d.setTipoImpressao(rs.getString("TIPO_IMPRESSAO"));
                        d.setDestinoOperacao(rs.getString("DESTINO_OPERACAO"));
                        d.setUF(rs.getString("UF"));
                        d.setMunicipio(rs.getString("MUNICIPIO"));
                        d.setCertificado(rs.getString("CERTIFICADO_DIGITAL"));
                        d.setAmbiente(rs.getString("AMBIENTE"));
                        d.setHost(rs.getString("HOST"));
                        d.setPorta(rs.getString("PORTA"));
                        d.setUsuario(rs.getString("USUARIO"));
                        d.setSenha(rs.getString("SENHA"));
                    }
                }catch(Exception ex){
                    System.err.println(ex);
                }
                return d;
        }        
    } 

