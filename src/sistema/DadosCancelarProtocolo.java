package sistema;

public class DadosCancelarProtocolo {
    
    String protocolo;
    String chaveNfe;
    String data;
    
    public DadosCancelarProtocolo(){
        this.protocolo = "";
        this.chaveNfe = "";
        this.data = "";
    }
    public DadosCancelarProtocolo(String protocolo, String chaveNfe, String data){
        this.protocolo = protocolo;
        this.chaveNfe = chaveNfe;
        this.data = data;
    }
    public String getProtocolo(){
        return this.protocolo;
    }
    public void setProtocolo(String protocolo){
        this.protocolo = protocolo;
    }
    public String getChaveNfe(){
        return this.chaveNfe;
    }
    public void setChaveNfe(String chaveNfe){
        this.chaveNfe = chaveNfe;
    }
    public String getdata(){
        return this.data;
    }
    public void setdata(String data){
        this.data = data;
    }
}
