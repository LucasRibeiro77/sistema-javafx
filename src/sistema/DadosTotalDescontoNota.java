package sistema;

public class DadosTotalDescontoNota {
    private double valor_nota;
    //private String valor_Total;
    
    
    @Override
    public String toString(){
        return String.valueOf(valor_nota);
    }
    
    public DadosTotalDescontoNota(){
        this.valor_nota = 0.00;
    }
    
    public DadosTotalDescontoNota(double valor_nota){
        this.valor_nota = valor_nota;
    }
    public double getValorNota(){
        return this.valor_nota;
    }
    public void setValorNota(double valor_nota){
        this.valor_nota = valor_nota;
    }
}
