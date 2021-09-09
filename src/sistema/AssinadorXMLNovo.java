package sistema;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import java.io.*;  
import java.security.*;  
import java.util.Collections;  
import javax.xml.crypto.MarshalException;  
import javax.xml.crypto.dsig.*;  
import javax.xml.crypto.dsig.dom.DOMSignContext;  
import javax.xml.crypto.dsig.keyinfo.KeyInfo;  
import javax.xml.crypto.dsig.spec.C14NMethodParameterSpec;  
import javax.xml.crypto.dsig.spec.TransformParameterSpec;  
import javax.xml.transform.Transformer;  
import javax.xml.transform.TransformerException;  
import javax.xml.transform.TransformerFactory;  
import javax.xml.transform.dom.DOMSource;  
import javax.xml.transform.stream.StreamResult;  
import org.w3c.dom.NodeList;  
import org.xml.sax.SAXException;
import sistema.CertificadoA1;  
import static sistema.ConcluirNFe.arq;
import static sistema.ConcluirNFe.fileEnviNFe;
import static sistema.ConcluirNFe.gravarArq;
import static sistema.ConcluirNFe.nfe;


public class AssinadorXMLNovo {
	
    private static final String RPS = "nfeProc";  
    private ArrayList<Transform> transformList;  
    private Document document; 
    private NodeList elements;  
    private org.w3c.dom.Element el;
    private Reference ref;  
    private SignedInfo si; 
    private XMLSignature signature;  
    private DOMSignContext dsc;  
    
	private Document documentFactory(String xml) throws SAXException, IOException, ParserConfigurationException {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		Document document = factory.newDocumentBuilder().parse(new ByteArrayInputStream(xml.getBytes()));
		return document;
	}
	
	 private ArrayList<Transform> signatureFactory(  
	            XMLSignatureFactory signatureFactory)  
	            throws NoSuchAlgorithmException, InvalidAlgorithmParameterException {  
	        ArrayList<Transform> transformList = new ArrayList<Transform>();  
	        TransformParameterSpec tps = null;  
	        Transform envelopedTransform = signatureFactory.newTransform(  
	                        Transform.ENVELOPED, tps);  
	  Transform c14NTransform = signatureFactory.newTransform(  
	                        "http://www.w3.org/TR/2001/REC-xml-c14n-20010315", tps);  
	        transformList.add(envelopedTransform);  
	        transformList.add(c14NTransform);  
	        return transformList;  
	    }
	 
	 private void assinaLoteRpsNFSe(String tipo, XMLSignatureFactory fac,  
	            ArrayList<Transform> transformList, PrivateKey privateKey,  
	            KeyInfo ki, Document document, int indexNFe) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, javax.xml.crypto.MarshalException  
	    {  
	        if(tipo.equals(RPS))  
	        {  
	            this.elements = this.document.getElementsByTagName("infNFe");  
	        }    
	          
	        this.el = (org.w3c.dom.Element) this.elements.item(indexNFe);  
	        String id = el.getAttribute("Id");
	        el.setIdAttribute("Id", true);

	        this.ref = fac.newReference("#" + id,  
	                fac.newDigestMethod(DigestMethod.SHA1, null), transformList,  
	                null, null);  
	        this.si = fac.newSignedInfo(fac.newCanonicalizationMethod(  
	                CanonicalizationMethod.INCLUSIVE,  
	                (C14NMethodParameterSpec) null), fac  
	                .newSignatureMethod(SignatureMethod.RSA_SHA1, null),  
	                Collections.singletonList(ref));  
	        this.signature = fac.newXMLSignature(si, ki);  
	        this.dsc = new DOMSignContext(privateKey, document.getFirstChild());  
	        this.signature.sign(this.dsc);  
	    }  
	 
	 private void assinaInfRpsNFSe(String tipo, XMLSignatureFactory fac,  
	            ArrayList<Transform> transformList, PrivateKey privateKey,  
	            KeyInfo ki, Document document, int indexNFe) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, MarshalException, XMLSignatureException, javax.xml.crypto.MarshalException  
	    {  

	        if(tipo.equals(RPS))  
	        {  
	            this.elements = this.document.getElementsByTagName("infNFe");  
	        }    
	          
	        this.el = (org.w3c.dom.Element) this.elements.item(indexNFe);  
	        String id = el.getAttribute("Id");  
	        el.setIdAttribute("Id", true);
	        this.ref = fac.newReference("#" + id,  
	                fac.newDigestMethod(DigestMethod.SHA1, null), transformList,  
	                null, null);  
	        this.si = fac.newSignedInfo(fac.newCanonicalizationMethod(  
	                CanonicalizationMethod.INCLUSIVE,  
	                (C14NMethodParameterSpec) null), fac  
	                .newSignatureMethod(SignatureMethod.RSA_SHA1, null),  
	                Collections.singletonList(ref));  
	        this.signature = fac.newXMLSignature(si, ki);  
	        this.dsc = new DOMSignContext(privateKey,   
	                document.getDocumentElement().getElementsByTagName(tipo).item(indexNFe));  
	        this.signature.sign(this.dsc);  
	    }  
	 
	 private String outputXML(Document doc) throws TransformerException, FileNotFoundException {  
	        ByteArrayOutputStream os = new ByteArrayOutputStream();  
	        TransformerFactory tf = TransformerFactory.newInstance();  
	        Transformer trans = tf.newTransformer();  
	        trans.transform(new DOMSource(doc), new StreamResult(os));  
	        String xml = os.toString();  
	        if ((xml != null) && (!"".equals(xml))) {  
	                xml = xml.replaceAll("\\r\\n", "");  
	                xml = xml.replaceAll(" standalone=\"no\"", "");  
	        }  
	        return xml;  
	    } 
	 
	 public static String lerXML(String fileXML) throws IOException   
	    {  
	        String linha = "";  
	        StringBuilder xml = new StringBuilder();  
	  
	        BufferedReader in = new BufferedReader(new InputStreamReader(  
	                        new FileInputStream(fileXML), "ISO8859-1"));  
	        while ((linha = in.readLine()) != null) {  
	                xml.append(linha);  
	        }  
	        in.close();  
	  
	        return xml.toString();  
	    }  
	
	public String assinaNFe(String caminhoXML, CertificadoA1 certificadoA1) throws Exception  
    {  
		
        String arquivoXML = lerXML(caminhoXML);
        this.document = documentFactory(arquivoXML);  
        this.transformList = signatureFactory(certificadoA1.getSignatureFactory());  
  
        for (int i = 0; i < this.document.getDocumentElement().getElementsByTagName(RPS).getLength(); i++)  
        {  
            assinaInfRpsNFSe(RPS, certificadoA1.getSignatureFactory(), this.transformList, certificadoA1.getPrivateKey(), certificadoA1.getKeyInfo(), this.document, i);

        }
        return outputXML(this.document);  
    }  

}