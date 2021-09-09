package sistema;

public class DadosChave {
    String chave;
    
    @Override
    public String toString(){
        return String.valueOf(chave);
    }
    public DadosChave(){
        this.chave = "";
    }
    public DadosChave(String chave){
        this.chave = chave;
    }
    public String getChave(){
        return this.chave;
    }
    public void setChave(String chave){
        this.chave = chave;
    }
}
