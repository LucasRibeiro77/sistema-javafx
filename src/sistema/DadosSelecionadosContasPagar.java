package sistema;

public class DadosSelecionadosContasPagar {
    double valor_selecionados;
    
    @Override
    public String toString(){
        return String.valueOf(valor_selecionados);
    }
    
    public DadosSelecionadosContasPagar(){
        this.valor_selecionados = 0.00;
    }
    public DadosSelecionadosContasPagar(double valor_selecionados){
        this.valor_selecionados = valor_selecionados;
    }
    public double getValorCobrado(){
        return this.valor_selecionados;
    }
    public void setValorCobrado(double valor_selecionados){
        this.valor_selecionados = valor_selecionados;
    }
}
