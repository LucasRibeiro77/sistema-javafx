package sistema;

public class DadosEstado{
    String nome;
    
    @Override
    public String toString(){
        return String.valueOf(nome);
    }
    
    public void DadosEstado(){
        this.nome = "";
    }
    public DadosEstado(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
