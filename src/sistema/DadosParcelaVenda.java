package sistema;

public class DadosParcelaVenda {
    
    int parcela;
    String valorParcela;
    String vencimento;
    
    public DadosParcelaVenda(){
        this.parcela = 0;
        this.valorParcela = "";
        this.vencimento = "";        
    }
    public DadosParcelaVenda(int parcela, String valorParcela, String vencimento){
        this.parcela = parcela;
        this.valorParcela = valorParcela;
        this.vencimento = vencimento;
    }
    public int getParcela(){
        return this.parcela;
    }
    public void getParcela(int parcela){
        this.parcela = parcela;
    }
    public String getValorParcela(){
        return this.valorParcela;
    }
    public void getValorParcela(String valorParcela){
        this.valorParcela = valorParcela;
    }
    public String getVencimento(){
        return this.vencimento;
    }
    public void getVencimento(String vencimento){
        this.vencimento = vencimento;
    }
}
