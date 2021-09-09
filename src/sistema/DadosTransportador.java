package sistema;

public class DadosTransportador {
    String razaosocial;
    
    public DadosTransportador(){
        this.razaosocial = "";
    }
    public DadosTransportador(String razaosocial){
        this.razaosocial = razaosocial;
    }
    public String getRazaoSocial(){
        return this.razaosocial;
    }
    public void setRazaoSocial(String razaosocial){
        this.razaosocial = razaosocial;
    }
}
