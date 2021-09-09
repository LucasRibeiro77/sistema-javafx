package sistema;

import java.security.PrivateKey;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;

public class CertificadoA1 {
	
	private XMLSignatureFactory signatureFactory;
	private PrivateKey privateKey;
	private KeyInfo keyInfo;
	public XMLSignatureFactory getSignatureFactory() {
		return signatureFactory;
	}
	public void setSignatureFactory(XMLSignatureFactory signatureFactory) {
		this.signatureFactory = signatureFactory;
	}
	public PrivateKey getPrivateKey() {
		return privateKey;
	}
	public void setPrivateKey(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	public KeyInfo getKeyInfo() {
		return keyInfo;
	}
	public void setKeyInfo(KeyInfo keyInfo) {
		this.keyInfo = keyInfo;
	}
}