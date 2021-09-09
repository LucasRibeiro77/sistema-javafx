package sistema;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import javax.xml.crypto.dsig.XMLSignatureFactory;
import javax.xml.crypto.dsig.keyinfo.KeyInfo;
import javax.xml.crypto.dsig.keyinfo.KeyInfoFactory;
import javax.xml.crypto.dsig.keyinfo.X509Data;
import sistema.CertificadoA1;

public class CarregaCertificadoA1 {

	private XMLSignatureFactory signatureFactory;
	private PrivateKey privateKey;
	private KeyInfo keyInfo;

	public CertificadoA1 certificadoWindows(String certificado, String senha) throws KeyStoreException, NoSuchProviderException,
			NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableEntryException {

		signatureFactory = XMLSignatureFactory.getInstance("DOM");

		KeyStore ks = null;

		ks = KeyStore.getInstance("Windows-MY", "SunMSCAPI");

		ks.load(null, null);

		KeyStore.PrivateKeyEntry pkEntry = null;
		Enumeration<String> aliasesEnum = null;

		aliasesEnum = ks.aliases();

		while (aliasesEnum.hasMoreElements()) {
			String alias = certificado;

			if (ks.isKeyEntry(alias)) {
				pkEntry = (KeyStore.PrivateKeyEntry) ks.getEntry(alias,
						new KeyStore.PasswordProtection(senha.toCharArray()));
				privateKey = pkEntry.getPrivateKey();
				break;
			}

		}
		X509Certificate cert = (X509Certificate) pkEntry.getCertificate();
		KeyInfoFactory keyInfoFactory = signatureFactory.getKeyInfoFactory();
		List<X509Certificate> x509Content = new ArrayList<X509Certificate>();

		x509Content.add(cert);
		X509Data x509Data = keyInfoFactory.newX509Data(x509Content);
		keyInfo = keyInfoFactory.newKeyInfo(Collections.singletonList(x509Data));
		
		CertificadoA1 certificadoA1 = new CertificadoA1();
		certificadoA1.setKeyInfo(keyInfo);
		certificadoA1.setPrivateKey(privateKey);
		certificadoA1.setSignatureFactory(signatureFactory);
		
		return certificadoA1;

	}


}
