package sistema;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.swing.JFrame;
import org.joda.time.LocalDate;

public class RelatorioBalanco {
    
    public static ComboBox cbTipoRelatorio;
    public static ComboBox cbPeriodoMes;
    public static TextField txtPeriodoAno;
    public static String resultado;
    public static String resultado2;
    public static String resultadoMes;
    public static String resultadoValor;
    
    public static void show(String message, String title){
                cbTipoRelatorio = new ComboBox();
                txtPeriodoAno = new TextField();
                cbPeriodoMes = new ComboBox();
                Label lblPeriodoMes = new Label("Mês: ");
                Label lblPeriodoAno = new Label("Ano");
		Stage st = new Stage();
		st.initModality(Modality.APPLICATION_MODAL);
		VBox pane = new VBox(10);
                HBox painelLinha1 = new HBox(5);
                HBox painelLinha2 = new HBox(5);
                HBox painelBotao = new HBox(5);
		Scene cena = new Scene(pane, 400, 110);
		Label lbl = new Label(message);
		Button btn = new Button("Cancelar");
                Button btnOK = new Button("Confirmar");
                txtPeriodoAno.setText(String.valueOf(LocalDate.now().getYear()));
                resultadoMes = String.valueOf(LocalDate.now().getMonthOfYear()).replaceAll("1", "Janeiro").replaceAll("2", "Fevereiro").replaceAll("3", "Março").replaceAll("4", "Abril").replace("5", "Maio").replaceAll("6", "Junho").replaceAll("7", "Julho").replaceAll("8", "Agosto").replaceAll("9", "Setembro").replaceAll("10", "Outubro").replaceAll("11", "Novembro").replaceAll("12", "Dezembro");
                
                cbTipoRelatorio.getItems().addAll("Contábil","Cruzado","Fabricante");
                cbTipoRelatorio.setPrefWidth(260);
                cbPeriodoMes.getItems().addAll("Janeiro","Fevereiro","Março","Abril","Maio","Junho","Julho","Agosto","Setembro","Outubro","Novembro","Dezembro");
               
                cbPeriodoMes.setValue(resultadoMes);

                cbTipoRelatorio.setValue("Contábil");
                
                btnOK.setOnAction(e->{
                    
                    resultado = String.valueOf(cbPeriodoMes.getValue());

                    if(resultado == "Janeiro"){
                        resultado = "01";
                    }else if(resultado == "Fevereiro"){
                        resultado = "02";
                    }else if(resultado == "Março"){
                        resultado = "03";
                    }else if(resultado == "Abril"){
                        resultado = "04";
                    }else if(resultado == "Maio"){
                        resultado = "05";
                    }else if(resultado == "Junho"){
                        resultado = "06";
                    }else if(resultado == "Julho"){
                        resultado = "07";
                    }else if(resultado == "Agosto"){
                        resultado = "08";
                    }else if(resultado == "Setembro"){
                        resultado = "09";
                    }else if(resultado == "Outubro"){
                        resultado = "10";
                    }else if(resultado == "Novembro"){
                        resultado = "11";
                    }else if(resultado == "Dezembro"){
                        resultado = "12";
                    }
                    PrintReport viewReport = new PrintReport();
                    viewReport.setLocation(250, 10);
                    viewReport.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 700);
                });
		st.initModality(Modality.APPLICATION_MODAL);
		st.setTitle(title);
		st.setMinWidth(250);
		st.setMinHeight(100);
		st.setScene(cena);
		pane.setAlignment(Pos.CENTER);
                lbl.setFont(new Font(11));
                lbl.setStyle("-fx-font-weight: bold");
                lblPeriodoMes.setFont(new Font(11));
                lblPeriodoMes.setStyle("-fx-font-weight: bold");
                lblPeriodoAno.setFont(new Font(11));
                lblPeriodoAno.setStyle("-fx-font-weight: bold");
		pane.setPadding(new Insets(20));
                btnOK.setGraphic(Login.imageViewOk);
                btnOK.setPrefWidth(100);
                btn.setGraphic(Login.imageViewCancelar);
                btn.setPrefWidth(100);
                painelLinha1.getChildren().addAll(lbl, cbTipoRelatorio);
                painelLinha2.getChildren().addAll(lblPeriodoMes, cbPeriodoMes, lblPeriodoAno, txtPeriodoAno);
                painelBotao.setAlignment(Pos.BASELINE_RIGHT);
                painelBotao.setMaxWidth(650);
                painelBotao.getChildren().addAll(btnOK, btn);
		pane.getChildren().addAll(painelLinha1, painelLinha2, painelBotao);
                
		btn.setOnAction(e -> st.close());
                cbTipoRelatorio.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                            resultado = String.valueOf(cbPeriodoMes.getValue());

                           if(resultado == "Janeiro"){
                               resultado = "01";
                           }else if(resultado == "Fevereiro"){
                               resultado = "02";
                           }else if(resultado == "Março"){
                               resultado = "03";
                           }else if(resultado == "Abril"){
                               resultado = "04";
                           }else if(resultado == "Maio"){
                               resultado = "05";
                           }else if(resultado == "Junho"){
                               resultado = "06";
                           }else if(resultado == "Julho"){
                               resultado = "07";
                           }else if(resultado == "Agosto"){
                               resultado = "08";
                           }else if(resultado == "Setembro"){
                               resultado = "09";
                           }else if(resultado == "Outubro"){
                               resultado = "10";
                           }else if(resultado == "Novembro"){
                               resultado = "11";
                           }else if(resultado == "Dezembro"){
                               resultado = "12";
                           }
                           PrintReport viewReport = new PrintReport();
                           viewReport.setLocation(250, 10);
                           viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 700);
                    }    
                });
                cbPeriodoMes.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                            resultado = String.valueOf(cbPeriodoMes.getValue());

                           if(resultado == "Janeiro"){
                               resultado = "01";
                           }else if(resultado == "Fevereiro"){
                               resultado = "02";
                           }else if(resultado == "Março"){
                               resultado = "03";
                           }else if(resultado == "Abril"){
                               resultado = "04";
                           }else if(resultado == "Maio"){
                               resultado = "05";
                           }else if(resultado == "Junho"){
                               resultado = "06";
                           }else if(resultado == "Julho"){
                               resultado = "07";
                           }else if(resultado == "Agosto"){
                               resultado = "08";
                           }else if(resultado == "Setembro"){
                               resultado = "09";
                           }else if(resultado == "Outubro"){
                               resultado = "10";
                           }else if(resultado == "Novembro"){
                               resultado = "11";
                           }else if(resultado == "Dezembro"){
                               resultado = "12";
                           }
                           PrintReport viewReport = new PrintReport();
                           viewReport.setLocation(250, 10);
                           viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 700);
                    }    
                });
                txtPeriodoAno.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                            resultado = String.valueOf(cbPeriodoMes.getValue());

                           if(resultado == "Janeiro"){
                               resultado = "01";
                           }else if(resultado == "Fevereiro"){
                               resultado = "02";
                           }else if(resultado == "Março"){
                               resultado = "03";
                           }else if(resultado == "Abril"){
                               resultado = "04";
                           }else if(resultado == "Maio"){
                               resultado = "05";
                           }else if(resultado == "Junho"){
                               resultado = "06";
                           }else if(resultado == "Julho"){
                               resultado = "07";
                           }else if(resultado == "Agosto"){
                               resultado = "08";
                           }else if(resultado == "Setembro"){
                               resultado = "09";
                           }else if(resultado == "Outubro"){
                               resultado = "10";
                           }else if(resultado == "Novembro"){
                               resultado = "11";
                           }else if(resultado == "Dezembro"){
                               resultado = "12";
                           }
                           PrintReport viewReport = new PrintReport();
                           viewReport.setLocation(250, 10);
                           viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 700);
                    }    
                });                
                btnOK.setOnKeyPressed(e -> {
                    if(e.getCode() == KeyCode.ENTER){
                            resultado = String.valueOf(cbPeriodoMes.getValue());

                           if(resultado == "Janeiro"){
                               resultado = "01";
                           }else if(resultado == "Fevereiro"){
                               resultado = "02";
                           }else if(resultado == "Março"){
                               resultado = "03";
                           }else if(resultado == "Abril"){
                               resultado = "04";
                           }else if(resultado == "Maio"){
                               resultado = "05";
                           }else if(resultado == "Junho"){
                               resultado = "06";
                           }else if(resultado == "Julho"){
                               resultado = "07";
                           }else if(resultado == "Agosto"){
                               resultado = "08";
                           }else if(resultado == "Setembro"){
                               resultado = "09";
                           }else if(resultado == "Outubro"){
                               resultado = "10";
                           }else if(resultado == "Novembro"){
                               resultado = "11";
                           }else if(resultado == "Dezembro"){
                               resultado = "12";
                           }
                           PrintReport viewReport = new PrintReport();
                           viewReport.setLocation(250, 10);
                           viewReport.showReport("SELECT PRODUTOS.ID AS ID, (SELECT ESTABELECIMENTO.RAZAOSOCIAL AS RAZAO_SOCIAL FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS RAZAO_SOCIAL, (SELECT ESTABELECIMENTO.IE AS IE FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS IE, (SELECT ESTABELECIMENTO.CNPJ AS CNPJ FROM ESTABELECIMENTO WHERE ESTAB = 'TRUE') AS CNPJ, PRODUTOS.DESCRICAO AS DESCRICAO, PRODUTOS.FABRICANTE AS FABRICANTE, replace(PRODUTOS.CUSTO, \".\",\",\") AS CUSTO, replace(PRODUTOS.ESTOQUE, \".\",\",\") AS QTDE, DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%M %Y') AS DATA, MAX(DATE_FORMAT(ENTRADA.DATA_ENTRADA, '%d/%m/%Y')) AS DATA_ULTIMA_COMPRA, MAX(DATE_FORMAT(CAIXA.DATA_HORA, '%d/%m/%Y')) AS DATA_ULTIMA_VENDA, replace(PRODUTOS.CUSTO * PRODUTOS.ESTOQUE, \".\",\",\") AS VALOR, (SELECT SUM(replace(CUSTO * ESTOQUE, \".\",\",\")) AS TOTAL FROM PRODUTOS) AS TOTAL FROM PRODUTOS INNER JOIN ENTRADA, CAIXA WHERE ENTRADA.DATA_ENTRADA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' AND CAIXA.DATA_HORA BETWEEN '"+txtPeriodoAno.getText()+"-"+resultado+"-01 00:00:00' AND '"+txtPeriodoAno.getText()+"-"+resultado+"-31 23:59:59' GROUP BY PRODUTOS.DESCRICAO;", "C:\\Users\\USER\\Documents\\Sistema\\src\\sistema\\relatorio\\relatorioBalancoContabil.jrxml", 900, 700);
                    }    
                });
		st.showAndWait();
        }
}