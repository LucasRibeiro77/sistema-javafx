package sistema;

public class DadosForn{
    String razaoSocial;
    
    public void DadosForn(){
        this.razaoSocial = "";
    }
    public DadosForn(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public String getRazaoSocial(){
        return this.razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
}
