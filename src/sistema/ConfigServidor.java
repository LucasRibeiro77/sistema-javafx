package sistema;

public class ConfigServidor {
    
    String nomeServidor;
    String bancoDados;
    String porta;
    String driver;
    String usuario;
    String senha;
    String url;
 
    public ConfigServidor(){
        this.nomeServidor = "";
        this.bancoDados = "";
        this.porta = "";
        this.driver = "";
        this.usuario = "";
        this.senha = "";
        this.url = "";
    }
    public ConfigServidor(String nomeServidor, String bancoDados, String porta, String driver, String usuario, String senha, String url){
        
        this.nomeServidor = nomeServidor;
        this.bancoDados = bancoDados;
        this.porta = porta;
        this.driver = driver;
        this.usuario = usuario;
        this.senha = senha;
        this.url = url;
    }
    public String getNomeServidor(){
        return this.nomeServidor;
    }
    public void setNomeServidor(String nomeServidor){
        this.nomeServidor = nomeServidor;
    }
    public String getBancoDados(){
        return this.bancoDados;
    }
    public void setBancoDados(String bancoDados){
        this.bancoDados = bancoDados;
    }
    public String getPorta(){
        return this.porta;
    }
    public void setPorta(String porta){
        this.porta = porta;
    }
    public String getDriver(){
        return this.driver;
    }
    public void setDriver(String driver){
        this.driver = driver;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    public String getSenha(){
        return this.senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public String getURL(){
        return this.url;
    }
    public void setURL(String url){
        this.url = url;
    }
}
