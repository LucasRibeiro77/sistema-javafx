package sistema;

public class DadosUndMedida {
    
    int id;
    String nome;
    String sigla;
    boolean fracao;
    boolean qtdeUnitaria;
    
    public DadosUndMedida(){
        this.id = 0;
        this.nome = "";
        this.sigla = "";
        this.fracao = false;
        this.qtdeUnitaria = false;
    }
    public DadosUndMedida(int id, String nome, String sigla, boolean fracao, boolean qtdeUnitaria){
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.fracao = fracao;
        this.qtdeUnitaria = qtdeUnitaria;
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
    public String getSigla(){
        return this.sigla;
    }
    public void setSigla(String sigla){
        this.sigla = sigla;
    }
    public boolean getFracao(){
        return this.fracao;
    }
    public void setFracao(boolean fracao){
        this.fracao = fracao;
    }
    public boolean getQtdeUnitaria(){
        return this.qtdeUnitaria;
    }
    public void setQtdeUnitaria(boolean qtdeUnitaria){
        this.qtdeUnitaria = qtdeUnitaria;
    }
}
