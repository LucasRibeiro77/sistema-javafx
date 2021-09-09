package sistema;

import java.util.Date;
import javafx.beans.property.SimpleObjectProperty;

public class DadosConcluirContasPagar {
    String dataBoleto;
    String dataVencimento;
    double valorCobrado;
    int parcela;
    String descricao;
    String nrDocumento;
    
    public DadosConcluirContasPagar(){
        this.dataBoleto = "";
        this.dataVencimento = "";
        this.valorCobrado = 0.00;
        this.parcela = 0;
        this.descricao = "";
        this.nrDocumento = "";
    }
    public DadosConcluirContasPagar(String dataBoleto, String dataVencimento, double valorCobrado, int parcela, String descricao, String nrDocumento){
        this.dataBoleto = dataBoleto;
        this.dataVencimento = dataVencimento;
        this.valorCobrado = valorCobrado;
        this.parcela = parcela;
        this.descricao = descricao;
        this.nrDocumento = nrDocumento;
    }
    public String getDataBoleto(){
        return this.dataBoleto;
    }
    public void setDataBoleto(String DataBoleto){
        this.dataBoleto = dataBoleto;
    }
    public String getDataVencimento(){
        return this.dataVencimento;
    }
    public void setDataVencimento(String dataVencimento){
        this.dataVencimento = dataVencimento;
    }
    public double getValorCobrado(){
        return this.valorCobrado;
    }
    public void setValorCobrado(double valorCobrado){
        this.valorCobrado = valorCobrado;
    }
    public int getParcela(){
        return this.parcela;
    }
    public void setParcela(int parcela){
        this.parcela = parcela;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getNrDocumento(){
        return this.descricao;
    }
    public void setNrDocumento(String nrDocumento){
        this.nrDocumento = nrDocumento;
    }
}
