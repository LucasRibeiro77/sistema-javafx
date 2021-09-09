package sistema;

public class DadosCaixa {
    
    public String id;
    public String descricao;
    public String fabricante;
    public String qtde;
    public String varejo;
    public String subtotal;
    
    public DadosCaixa(){
        
        this.id = "";
        this.descricao = "";
        this.fabricante = "";
        this.qtde = "";
        this.varejo = "";
        this.subtotal = "";
    }
    public DadosCaixa(String id, String descricao, String fabricante, String qtde, String varejo, String subtotal){
        
            this.id = id;
            this.descricao = descricao;
            this.fabricante = fabricante;
            this.qtde = qtde;
            this.varejo = varejo;
            this.subtotal = subtotal;
        }
    public String getID(){
        return this.id;
    }
    public void setID(String id){
        this.id = id;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getFabricante(){
        return this.fabricante;
    }
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public String getQtde(){
        return this.qtde;
    }
    public void setQtde(String qtde){
        this.qtde = qtde;
    }
    public String getVarejo(){
        return this.varejo;
    }
    public void setVarejo(String varejo){
        this.varejo = varejo;
    }
    public String getSubtotal(){
        return this.subtotal;
    }
    public void setSubtotal(String subtotal){
        this.subtotal = subtotal;
    }
}
