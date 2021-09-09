package sistema;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import org.w3c.dom.Document;
import java.io.OutputStream;
import java.util.Enumeration;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.w3c.dom.*;
import static sistema.ConcluirNFe.DadosConfigNFe;
import static sistema.ConcluirNFe.cfop;
import static sistema.ConcluirNFe.gerador;
import static sistema.ConcluirNFe.protocolo;


public class criaArquivoXml {

    public static void criar(String savePath) throws IOException, Exception, UnsupportedOperationException{
        
            try {

                        Date dataHoraAtual = new Date();
                        String dataAtual = new SimpleDateFormat("yyyy-MM-dd").format(dataHoraAtual);
                        String horaAtual = new SimpleDateFormat("HH:mm:ss").format(dataHoraAtual);
                        String hora = new SimpleDateFormat("HH:mm").format(dataHoraAtual);

                        Random gerador = new Random();   
                        String protocolo = String.format("%08d",gerador.nextInt()).replace("-","").substring(0, 8);

                        String xmlHeader;
                        xmlHeader = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>";
                        xmlHeader += "\n<nfeProc xmlns=\"http://www.portalfiscal.inf.br/nfe\" versao=\"4.00\">";			
                        xmlHeader += "\n</nfeProc>\n";	

                        ByteArrayInputStream xml = new ByteArrayInputStream(new String(xmlHeader.getBytes(), "UTF-8").getBytes()); 
                        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                        Document doc = dBuilder.parse(xml);

                        Element rootElement = doc.getDocumentElement();

                        Element nfe = doc.createElement("NFe");
                        Attr attr3 = doc.createAttribute("xmlns");
                        attr3.setValue("http://www.portalfiscal.inf.br/nfe");
                        rootElement.appendChild(nfe);
                        nfe.setAttributeNode(attr3);

                        Element infNFe = doc.createElement("infNFe");
                        nfe.appendChild(infNFe);

                        Attr attr4 = doc.createAttribute("versao");
                        Attr attr5 = doc.createAttribute("Id");
                        attr4.setValue("4.00");
                        attr5.setValue("NFe35210441378298000155550010000000021030007006");
                        infNFe.setAttributeNode(attr4);
                        infNFe.setAttributeNode(attr5);

                        Element ide = doc.createElement("ide");
                        infNFe.appendChild(ide);

                               Element cUF = doc.createElement("cUF");
                               cUF.appendChild(doc.createTextNode("35"));
                               ide.appendChild(cUF);

                               Element cNF = doc.createElement("cNF");
                               cNF.appendChild(doc.createTextNode(String.valueOf(protocolo)));
                               ide.appendChild(cNF);

                               Element natOp = doc.createElement("natOp");
                               natOp.appendChild(doc.createTextNode(String.valueOf(cfop.getNaturezaOperacao())));
                               ide.appendChild(natOp);

                               Element mod = doc.createElement("mod");
                               mod.appendChild(doc.createTextNode("55"));
                               ide.appendChild(mod);

                               Element serie = doc.createElement("serie");
                               serie.appendChild(doc.createTextNode(String.valueOf(ItensNfe.txtSerie.getText())));
                               ide.appendChild(serie);

                               Element nNF = doc.createElement("nNF");
                               nNF.appendChild(doc.createTextNode(String.valueOf(EmitirNFe.txtNrNota.getText().replace(" ",""))));
                               ide.appendChild(nNF);

                               Element dhEmi = doc.createElement("dhEmi");
                               dhEmi.appendChild(doc.createTextNode(""+dataAtual+"T"+horaAtual+"-"+hora+""));
                               ide.appendChild(dhEmi);

                               Element dhSaiEnt = doc.createElement("dhSaiEnt");
                               dhSaiEnt.appendChild(doc.createTextNode(""+dataAtual+"T"+horaAtual+"-"+hora+""));
                               ide.appendChild(dhSaiEnt);

                               Element tpNF = doc.createElement("tpNF");
                               tpNF.appendChild(doc.createTextNode(String.valueOf(ItensNfe.cbTipoNFe.getValue()).replace("Entrada","0").replace("Saida","1")));
                               ide.appendChild(tpNF);

                               Element idDest = doc.createElement("idDest");
                               idDest.appendChild(doc.createTextNode(String.valueOf(DadosConfigNFe().getDestinoOperacao()).replace("Operacao interna","1").replace("Operacao interestadual","2").replace("Operacao com exterior","3")));
                               ide.appendChild(idDest);

                               Element cMunFG = doc.createElement("cMunFG");
                               cMunFG.appendChild(doc.createTextNode("3550308"));
                               ide.appendChild(cMunFG);

                               Element tpImp = doc.createElement("tpImp");
                               tpImp.appendChild(doc.createTextNode(String.valueOf(DadosConfigNFe().getTipoImpressao()).replace("Retrato","1").replace("Paisagem","2")));
                               ide.appendChild(tpImp);

                               Element tpEmis = doc.createElement("tpEmis");
                               tpEmis.appendChild(doc.createTextNode(String.valueOf(DadosConfigNFe().getFormaEmissao()).replace("Normal","1").replace("Contingencia FS-IA","2").replace("Contingencia via EPEC","4").replace("Contingencia FS-DA","5").replace("Contingencia SVC-AN","6").replace("Contingencia SVC-RS","7")));
                               ide.appendChild(tpEmis);

                               Element cDV = doc.createElement("cDV");
                               cDV.appendChild(doc.createTextNode(String.valueOf(ConcluirNFe.digitoVerificador)));
                               ide.appendChild(cDV);

                               Element tpAmb = doc.createElement("tpAmb");
                               tpAmb.appendChild(doc.createTextNode(String.valueOf(DadosConfigNFe().getAmbiente()).replace("Homologacao","2").replace("Producao","1")));
                               ide.appendChild(tpAmb);

                               Element finNFe = doc.createElement("finNFe");
                               finNFe.appendChild(doc.createTextNode(String.valueOf(ItensNfe.cbFinalidadeNFe.getValue()).replace("Normal","1").replace("Complementar","2").replace("Ajuste","3").replace("Devolucao","4")));
                               ide.appendChild(finNFe);

                               Element indFinal = doc.createElement("indFinal");
                               indFinal.appendChild(doc.createTextNode("0"));
                               ide.appendChild(indFinal);

                               Element indPres = doc.createElement("indPres");
                               indPres.appendChild(doc.createTextNode("0"));
                               ide.appendChild(indPres);

                               Element procEmi = doc.createElement("procEmi");
                               procEmi.appendChild(doc.createTextNode("0"));
                               ide.appendChild(procEmi);

                               Element verProc = doc.createElement("verProc");
                               verProc.appendChild(doc.createTextNode("4.00"));
                               ide.appendChild(verProc);

                        Element emit = doc.createElement("emit");
                        infNFe.appendChild(emit);

                        Element CNPJ = doc.createElement("CNPJ");
                        CNPJ.appendChild(doc.createTextNode(String.valueOf(ConcluirNFe.data.getCNPJEmit())));
                        ide.appendChild(CNPJ);

                        TransformerFactory transformerFactory = TransformerFactory.newInstance();
                        Transformer transformer = transformerFactory.newTransformer();
                        DOMSource source = new DOMSource(doc);
                        StreamResult result = new StreamResult(new FileOutputStream("C:\\Users\\USER\\Documents\\Sistema\\dist\\NFe.xml"));
                        transformer.transform(source, result);

                        StreamResult consoleResult = new StreamResult(System.out);
                        transformer.transform(source, consoleResult);
                        
                } catch (Exception e) {
                   e.printStackTrace();
                }
        }
}

