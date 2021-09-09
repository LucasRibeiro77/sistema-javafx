package sistema;

public class DadosTotalNota {
    private double valor_nota;
    //private String valor_Total;
    
    
    @Override
    public String toString(){
        return String.valueOf(valor_nota);
    }
    
    public DadosTotalNota(){
        this.valor_nota = 0.00;
    }
    
    public DadosTotalNota(double valor_nota){
        this.valor_nota = valor_nota;
    }
    public double getValorNota(){
        return this.valor_nota;
    }
    public void setValorNota(double valor_nota){
        this.valor_nota = valor_nota;
    }
}
