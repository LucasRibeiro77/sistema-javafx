package sistema;

public class DadosConfigNFe {
    
    String FormaEmissao;
    String TipoImpressao;
    String DestinoOperacao;
    String UF;
    String municipio;
    String Certificado;
    String Ambiente;
    String Host;
    String Porta;
    String Usuario;
    String Senha;
    
    public DadosConfigNFe(){
    
        this.FormaEmissao = "";
        this.TipoImpressao = "";
        this.DestinoOperacao = "";
        this.UF = "";
        this.municipio = "";
        this.Certificado = "";
        this.Ambiente = "";
        this.Host = "";
        this.Porta = "";
        this.Usuario = "";
        this.Senha = "";    
    }
    public DadosConfigNFe(String FormaEmissao, String TipoImpressao,String DestinoOperacao,String UF,String municipio,String Certificado,String Ambiente,String Host,String Porta,String Usuario, String Senha){
        
        this.FormaEmissao = FormaEmissao;
        this.TipoImpressao = TipoImpressao;
        this.DestinoOperacao = DestinoOperacao;
        this.UF = UF;
        this.municipio = municipio;
        this.Certificado = Certificado;
        this.Ambiente = Ambiente;
        this.Host = Host;
        this.Porta = Porta;
        this.Usuario = Usuario;
        this.Senha = Senha;            
    }
    public String getFormaEmissao(){
        return this.FormaEmissao;
    }
    public void setFormaEmissao(String FormaEmissao){
        this.FormaEmissao = FormaEmissao;
    }
        public String getTipoImpressao(){
        return this.TipoImpressao;
    }
    public void setTipoImpressao(String TipoImpressao){
        this.TipoImpressao = TipoImpressao;
    }
    public String getDestinoOperacao(){
        return this.DestinoOperacao;
    }
    public void setDestinoOperacao(String DestinoOperacao){
        this.DestinoOperacao = DestinoOperacao;
    }
    public String getUF(){
        return this.UF;
    }
    public void setUF(String UF){
        this.UF = UF;
    }
    public String getMunicipio(){
        return this.municipio;
    }
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }
    public String getCertificado(){
        return this.Certificado;
    }
    public void setCertificado(String Certificado){
        this.Certificado = Certificado;
    }
    public String getAmbiente(){
        return this.Ambiente;
    }
    public void setAmbiente(String Ambiente){
        this.Ambiente = Ambiente;
    }
    public String getHost(){
        return this.Host;
    }
    public void setHost(String Host){
        this.Host = Host;
    }
    public String getPorta(){
        return this.Porta;
    }
    public void setPorta(String Porta){
        this.Porta = Porta;
    }
    public String getUsuario(){
        return this.Usuario;
    }
    public void setUsuario(String Usuario){
        this.Usuario = Usuario;
    }
    public String getSenha(){
        return this.Senha;
    }
    public void setSenha(String Senha){
        this.Senha = Senha;
    }
}
