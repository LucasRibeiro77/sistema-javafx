package sistema;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.swing.JRViewer;

public class PrintReport extends JFrame{    

    Connection conn = Conexao.getConexao();
    PreparedStatement pst = null;
    ResultSet rs = null;   

    public PrintReport() throws HeadlessException {
    }

    public void showReport(String query, String jd, int nRow, int nCol){
         try {

             JasperDesign jasperDesign = JRXmlLoader.load(jd);
             JRDesignQuery jrquery = new JRDesignQuery();
             jrquery.setText(query);
             jasperDesign.setQuery(jrquery);

             JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
             JasperPrint JasperPrint = JasperFillManager.fillReport(jasperReport, null, conn);
             JRViewer viewer = new JRViewer(JasperPrint);

             viewer.setOpaque(true);
             viewer.setVisible(true);

             this.add(viewer);
             this.setExtendedState(JFrame.MAXIMIZED_BOTH);
             this.setSize(nRow, nCol);
             this.setVisible(true);

         } catch (Exception e) {
             JOptionPane.showMessageDialog(rootPane, e.getMessage());
         }
    }
}