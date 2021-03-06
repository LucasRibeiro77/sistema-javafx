package sistema;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;

public class Impressao {

// variavel estatica porque será utilizada por inumeras threads
public static PrintService impressora;

public Impressao() {

	detectaImpressoras();

}

// O metodo verifica se existe impressora conectada e a
// define como padrao.
public void detectaImpressoras() {

	try {

		DocFlavor df = DocFlavor.SERVICE_FORMATTED.PRINTABLE;
		PrintService[] ps = PrintServiceLookup.lookupPrintServices(df, null);
		for (PrintService p : ps) {

			System.out.println("Impressora encontrada: " + p.getName());

			if (p.getName().contains("Primo")|| p.getName().contains("PDF")) {

				System.out.println("Impressora Selecionada: " + p.getName());
				impressora = p;
				break;

			}

		}

	} catch (Exception e) {

		e.printStackTrace();

	}

}

public synchronized boolean imprime(String texto) {
//public static boolean imprime(String texto) {

	// se nao existir impressora, entao avisa usuario
	// senao imprime texto
	if (impressora == null) {

		String msg = "Nennhuma impressora foi encontrada. Instale uma impressora padrão \r\n(Generic Text Only) e reinicie o programa.";
		//System.out.println(msg);
		MessageBox.show(msg, "Erro de impressão");

	} else {

		try {

			DocPrintJob dpj = impressora.createPrintJob();
			InputStream stream = new ByteArrayInputStream(texto.getBytes());

			DocFlavor flavor = DocFlavor.INPUT_STREAM.AUTOSENSE;
                        //DocFlavor flavor = DocFlavor.INPUT_STREAM.PDF;
                        //jasper = (JasperReport) JRLoader.loadObject("C:/Users/USER/JaspersoftWorkspace/MyReports/Cherry.jrxml");
                        //impressao = JasperFillManager.fillReport(jasper, parametros, jrds);
			Doc doc = new SimpleDoc(stream, flavor, null);
			dpj.print(doc, null);

			return true;

		} catch (PrintException e) {

			e.printStackTrace();

		}

	}

	return false;
    }
}