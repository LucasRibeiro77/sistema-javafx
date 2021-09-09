package sistema;

public class DadosParcelas {
    
    public String dataVencimento;
    //int parcela;

    @Override
    public String toString(){
        return String.valueOf(dataVencimento);
    }
    
    public DadosParcelas(){
        this.dataVencimento = "";
    //    this.parcela = 0;
    }
    public DadosParcelas(String dataVencimento){
        this.dataVencimento = dataVencimento;
    //    this.parcela = parcela;
    }
    public String getDataVencimento(){
        return this.dataVencimento;
    }
    public void setDataVencimento(String dataVencimento){
        this.dataVencimento = dataVencimento;
    }/*
    public int getParcela(){
        return this.parcela;
    }
    public void setParcela(int parcela){
        this.parcela = parcela;
    }*/
}
