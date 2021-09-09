package sistema;

public class DadosHistoricoEvento {
    
    public String descricao;
    public String dataEvento;
    public String usuario;
    
    public DadosHistoricoEvento(){
        this.descricao = "";
        this.dataEvento = "";
        this.usuario = "";
    }
    public DadosHistoricoEvento(String descricao, String dataEvento, String usuario){
        this.descricao = descricao;
        this.dataEvento = dataEvento;
        this.usuario = usuario;    
    }        
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getDataEvento(){
        return this.dataEvento;
    }
    public void setDataEvento(String dataEvento){
        this.dataEvento = dataEvento;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
}
