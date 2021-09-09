package sistema;

import javafx.collections.ObservableList;

public class DadosHistoricoCompra {

    public int NrNF;
    public String fornecedor;
    public String custo;
    public String qtde;
    public String dataEntrada;
    public String usuario;
    
    public DadosHistoricoCompra(){
        this.NrNF = 0;
        this.fornecedor = "";
        this.custo = "";
        this.qtde = "";
        this.dataEntrada = "";
        this.usuario = "";
    }
    public DadosHistoricoCompra(int NrNF, String fornecedor, String custo, String qtde, String dataEntrada, String usuario){
        this.NrNF = NrNF;
        this.fornecedor = fornecedor;
        this.custo = custo;
        this.qtde = qtde;
        this.dataEntrada = dataEntrada;
        this.usuario = usuario;    
    }        
    DadosHistoricoCompra(ObservableList dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public int getNrNF(){
        return this.NrNF;
    }
    public void setNrNF(int NrNF){
        this.NrNF = NrNF;
    }
    public String getFornecedor(){
        return this.fornecedor;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public String getCusto(){
        return this.custo;
    }
    public void setCusto(String custo){
        this.custo = custo;
    }
    public String getQtde(){
        return this.qtde;
    }
    public void setQtde(String qtde){
        this.qtde = qtde;
    }
    public String getDataEntrada(){
        return this.dataEntrada;
    }
    public void setDataEntrada(String dataEntrada){
        this.dataEntrada = dataEntrada;
    }
    public String getUsuario(){
        return this.usuario;
    }
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
}
