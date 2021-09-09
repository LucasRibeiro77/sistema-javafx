package sistema;

public class DadosDescrContasPagar {
    String descricao;
    
    public DadosDescrContasPagar(){
        this.descricao = "";
    }
    public DadosDescrContasPagar(String descricao){
        this.descricao = descricao;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
}
