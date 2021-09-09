package sistema;

public class DadosCat {
    String nome;
    public DadosCat(){
        this.nome = "";
    }
    public DadosCat(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
