package sistema;

public class DadosTotalizadoresContasPagar {
    
    double valor_cobrado;
    
    @Override
    public String toString(){
        return String.valueOf(valor_cobrado);
    }
    
    public DadosTotalizadoresContasPagar(){
        this.valor_cobrado = 0.00;
    }
    public DadosTotalizadoresContasPagar(double valor_cobrado){
        this.valor_cobrado = valor_cobrado;
    }
    public double getValorCobrado(){
        return this.valor_cobrado;
    }
    public void setValorCobrado(double valor_cobrado){
        this.valor_cobrado = valor_cobrado;
    }
}
