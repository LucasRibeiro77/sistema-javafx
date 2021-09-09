package sistema;

public class DadosCFOP {

    String cfop;
    String natureza_operacao;
    
    public DadosCFOP(){
        this.cfop = "";
        this.natureza_operacao = "";
    }
    
    public DadosCFOP(String cfop, String natureza_operacao) {
        this.cfop = cfop;
        this.natureza_operacao = natureza_operacao;
    }
    
    public String getCFOP(){
        return this.cfop;
    }
    public void setCFOP(String cfop){
        this.cfop = cfop;
    }
    public String getNaturezaOperacao(){
        return this.natureza_operacao;
    }
    public void setNaturezaOperacao(String natureza_operacao){
        this.natureza_operacao = natureza_operacao;
    }
}
