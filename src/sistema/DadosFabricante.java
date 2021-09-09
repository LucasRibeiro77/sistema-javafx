package sistema;

public class DadosFabricante {
    int id;
    String nome;
    String cnpj;
    
    public DadosFabricante(){
        this.id = 0;
        this.nome = "";
        this.cnpj = "";
    }
    public DadosFabricante(int id, String nome, String cnpj){
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public String getCNPJ(){
        return this.cnpj;
    }
    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }
}
