package sistema;

public class DadosPais{
    String nome;
    
    public void DadosPais(){
        this.nome = "";
    }
    public DadosPais(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
