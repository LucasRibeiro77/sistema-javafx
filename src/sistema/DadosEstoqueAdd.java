package sistema;

public class DadosEstoqueAdd {
    int id;
    String descricao;
    String qtde;
    String barras;
    String custo;
    String subtotal;
    int nr_nota;
    
    public DadosEstoqueAdd(){
        this.id = 0;
        this.descricao = "";
        this.qtde = "";
        this.barras = "";
        this.custo = "";
        this.subtotal = "";
        this.nr_nota = 0;
    }
    public DadosEstoqueAdd(int id, String descricao, String qtde, String barras, String custo, String subtotal,int nr_nota){
        this.id = id;
        this.descricao = descricao;
        this.qtde = qtde;
        this.barras = barras;
        this.custo = custo;
        this.subtotal = subtotal;
        this.nr_nota = nr_nota;
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getQtde(){
        return this.qtde;
    }
    public void setQtde(String qtde){
        this.qtde = qtde;
    }
    public String getBarras(){
        return this.barras;
    }
    public void setBarras(String barras){
        this.barras = barras;
    }
    public String getCusto(){
        return this.custo;
    }
    public void setCusto(String custo){
        this.custo = custo;
    }
    public String getSubtotal(){
        return this.subtotal;
    }
    public void setSubtotal(String subtotal){
        this.subtotal = subtotal;
    }
    public int getNrNota(){
        return this.nr_nota;
    }
    public void setNrNota(int nr_nota){
        this.nr_nota = nr_nota;
    }
}
