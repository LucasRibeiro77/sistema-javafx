package sistema;

public class DadosHistoricoVenda {
    
    public String protocolo;
    public String venda;
    public String qtde;
    public String dataHora;
    public String usuario;
    public String cliente;
    
    public DadosHistoricoVenda(){
        this.protocolo = "";
        this.venda = "";
        this.qtde = "";
        this.dataHora = "";
        this.usuario = "";
        this.cliente = "";
    }
    public DadosHistoricoVenda(String protocolo, String venda, String qtde, String dataHora, String usuario, String cliente){
        this.protocolo = protocolo;
        this.venda = venda;
        this.qtde = qtde;
        this.dataHora = dataHora;
        this.usuario = usuario;    
        this.cliente = cliente;
    }        
    public String getProtocolo(){
        return this.protocolo;
    }
    public void setProtocolo(String protocolo){
        this.protocolo = protocolo;
    }
    public String getVenda(){
        return this.venda;
    }
    public void setVenda(String venda){
        this.venda = venda;
    }
    public String getQtde(){
        return this.qtde;
    }
    public void setQtde(String qtde){
        this.qtde = qtde;
    }
    public String getDataHora(){
        return this.dataHora;
    }
    public void setDataHora(String dataHora){
        this.dataHora = dataHora;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }    
    public String getCliente(){
        return this.cliente;
    }
    public void setCliente(String cliente){
        this.cliente = cliente;
    }
}
