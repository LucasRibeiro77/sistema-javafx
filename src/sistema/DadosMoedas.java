package sistema;

public class DadosMoedas {
    String moeda;
    
    public DadosMoedas(){
        this.moeda = "";
    }
    public DadosMoedas(String moeda){
        this.moeda = moeda;
    }
    public String getMoeda(){
        return this.moeda;
    }
    public void setMoeda(String moeda){
        this.moeda = moeda;
    }
}
