package sistema;

public class DadosBancos {
    String nomeBanco;
    
    public DadosBancos(){
        this.nomeBanco = "";
    }
    public DadosBancos(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }
    public String getNomeBanco(){
        return this.nomeBanco;
    }
    public void setNomeBanco(String nomeBanco){
        this.nomeBanco = nomeBanco;
    }
}
