package sistema;

public class DadosTotalizadores {
    private double valor_Produtos;
    //private String valor_Total;
    
    
    @Override
    public String toString(){
        return String.format("%.02f", valor_Produtos);
    }
    
    public DadosTotalizadores(){
        this.valor_Produtos = 0.00;
    }
    
    public DadosTotalizadores(double valor_produtos){
        this.valor_Produtos = valor_produtos;
    }
    public double getValorProdutos(){
        return this.valor_Produtos;
    }
    public void setValorProdutos(double valor_produtos){
        this.valor_Produtos = valor_produtos;
    }
}
