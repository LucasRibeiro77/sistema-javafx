package sistema;

public class DadosMed {
    String nome;
    public DadosMed(){
        this.nome = "";
    }
    public DadosMed(String nome){
        this.nome = nome;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
}
