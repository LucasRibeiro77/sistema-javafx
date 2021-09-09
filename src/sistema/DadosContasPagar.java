package sistema;

import javafx.collections.ObservableList;

public class DadosContasPagar {
    
    int id;
    String nrDocumento;
    String descricao;
    String especieDocumento;
    String moeda;
    String dataBoleto;
    String dataVencimento;
    String dataPagamento;
    String formaPagamento;
    double jurosMulta;
    double descontoAbatimento;
    double valorBoleto;
    String valorCobrado;
    String localPagamento;
    String codBarras;
    String status;
    String beneficiario;
    String usuario;
    int parcela;
    
    public DadosContasPagar(){
            this.id = 0;
            this.nrDocumento = "";
            this.descricao = "";
            this.especieDocumento = "";
            this.moeda = "";
            this.dataBoleto = "";
            this.dataVencimento = "";
            this.dataPagamento = "";
            this.formaPagamento = "";
            this.jurosMulta = 0.00;
            this.descontoAbatimento = 0.00;
            this.valorBoleto = 0.00;
            this.valorCobrado = "";
            this.localPagamento = "";
            this.codBarras = "";
            this.status = "";
            this.beneficiario = "";
            this.usuario = "";
            this.parcela = 0;
    } 
    public DadosContasPagar(int id, String nrDocumento, String descricao, String especieDocumento, String moeda, String dataBoleto,  String dataVencimento, String dataPagamento, String formaPagamento, double jurosMulta, double descontoAbatimento, double valorBoleto, String valorCobrado, String localPagamento, String codBarras, String status, String beneficiario, String usuario, int parcela){
            this.id = id;
            this.nrDocumento = nrDocumento;
            this.descricao = descricao;
            this.especieDocumento = especieDocumento;
            this.moeda = moeda;
            this.dataBoleto = dataBoleto;
            this.dataVencimento = dataVencimento;
            this.dataPagamento = dataPagamento;
            this.formaPagamento = formaPagamento;
            this.jurosMulta = jurosMulta;
            this.descontoAbatimento = descontoAbatimento;
            this.valorBoleto = valorBoleto;
            this.valorCobrado = valorCobrado;
            this.localPagamento = localPagamento;        
            this.codBarras = codBarras;
            this.status = status;
            this.beneficiario = beneficiario;
            this.usuario = usuario;
            this.parcela = parcela;
    }

    DadosContasPagar(ObservableList dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getNrDocumento(){
	return this.nrDocumento;
    }
    public void setNrDocumento(String nrDocumento){
            this.nrDocumento = nrDocumento;
    }
    public String getDescricao(){
            return this.descricao;
    }
    public void setDescricao(String descricao){
            this.descricao = descricao;
    }
    public String getEspecieDocumento(){
            return this.especieDocumento;
    }
    public void setEspecieDocumento(String especieDocumento){
            this.especieDocumento = especieDocumento;
    }
    public String getMoeda(){
            return this.moeda;
    }
    public void setMoeda(String moeda){
            this.moeda = moeda;
    }
    public String getDataBoleto(){
            return this.dataBoleto;
    }
    public void setDataBoleto(String dataBoleto){
            this.dataBoleto = dataBoleto;
    }
    public String getDataVencimento(){
            return this.dataVencimento;
    }
    public void setDataVencimento(String dataVencimento){
            this.dataVencimento = dataVencimento;
    }
    public String getDataPagamento(){
            return this.dataPagamento;
    }
    public void setDataPagamento(String dataPagamento){
            this.dataPagamento = dataPagamento;
    }
    public String getFormaPagamento(){
            return this.formaPagamento;
    }
    public void setFormaPagamento(String formaPagamento){
            this.formaPagamento = formaPagamento;
    }
    public double getJurosMulta(){
            return this.jurosMulta;
    }
    public void setJurosMulta(double jurosMulta){
            this.jurosMulta = jurosMulta;
    }
    public double getDescontoAbatimento(){
            return this.descontoAbatimento;
    }
    public void setDescontoAbatimento(double descontoAbatimento){
            this.descontoAbatimento = descontoAbatimento;
    }
    public double getValorBoleto(){
            return this.valorBoleto;
    }
    public void setValorBoleto(double valorBoleto){
            this.valorBoleto = valorBoleto;
    }
    public String getValorCobrado(){
            return this.valorCobrado;
    }
    public void setValorCobrado(String valorCobrado){
            this.valorCobrado = valorCobrado;
    }
    public String getLocalPagamento(){
            return this.localPagamento;
    }
    public void setLocalPagamento(String localPagamento){
            this.localPagamento = localPagamento;
    }
    public String getCodBarras(){
            return this.codBarras;
    }
    public void setCodBarras(String codBarras){
            this.codBarras = codBarras;
    }
    public String getStatus(){
            return this.status;
    }
    public void setStatus(String status){
            this.status = status;
    }
    public String getBeneficiario(){
        return this.beneficiario;
    }
    public void setBeneficiario(String beneficiario){
        this.beneficiario = beneficiario;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(){
        this.usuario = usuario;
    }
    public int getParcela(){
        return this.parcela;
    }
    public void setParcela(int parcela){
        this.parcela = parcela;
    }
}
