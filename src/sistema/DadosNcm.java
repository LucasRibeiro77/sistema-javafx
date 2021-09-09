package sistema;

public class DadosNcm{
    String NCM;
    
    public void DadosNcm(){
        this.NCM = "";
    }
    public DadosNcm(String NCM){
        this.NCM = NCM;
    }
    public String getNCM(){
        return this.NCM;
    }
    public void setNCM(String NCM){
        this.NCM = NCM;
    }
}
