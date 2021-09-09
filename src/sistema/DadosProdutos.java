package sistema;

public class DadosProdutos {
    int id;
    String descricao;
    String categoria;
    String barras;
    int ncm;
    int cest;
    String fabricante;
    String fornecedor;
    String und_medida;
    String estoque;
    double est_minimo;
    double est_maximo;
    double valor_pago;
    double desc_promocional;
    double qtde_promocional;
    double ii;
    double ipi;
    double pis;
    double cofins;
    double icms;
    double mva;
    double redutor;
    double redutor_st;
    double seguro;
    double outros;
    double desconto;
    double frete;
    String validade;
    String custo;
    String marckup;
    String varejo;
    String inclusao;
    String alteracao;
    double FCP;
    String CST_ICMS;
    String Origem;
    String CST_IPI;
    String CodEnquadramento;
    String CST_PIS;
    String CST_COFINS;
    String Tributacao;
    double QTDE_CX_PCT_SC_FD;
    
    public void DadosProdutos(){
                this.id = 0;
                this.descricao = "";
                this.categoria = "";
                this.barras = "";
                this.ncm = 0;
                this.cest = 0;
                this.fabricante = "";
                this.fornecedor = "";
                this.und_medida = "";
                this.estoque = "";
                this.est_minimo = 0.00;
                this.est_maximo = 0.00;
                this.valor_pago = 0.00;
                this.desc_promocional = 0.00;
                this.qtde_promocional = 0.00;
                this.ii = 0.00;
                this.ipi = 0.00;
                this.pis = 0.00;
                this.cofins = 0.00;
                this.icms = 0.00;
                this.mva = 0.00;
                this.redutor = 0.00;
                this.redutor_st = 0.00;
                this.seguro = 0.00;
                this.outros = 0.00;
                this.desconto = 0.00;
                this.frete = 0.00;
                this.validade = "";
                this.custo = "";
                this.marckup = "";
                this.varejo = "";
                this.inclusao = "";
                this.alteracao = "";
                this.FCP = 0.00;
                this.CST_ICMS = "";
                this.Origem = "";
                this.CST_IPI = "";
                this.CodEnquadramento = "";
                this.CST_PIS = "";
                this.CST_COFINS = "";
                this.Tributacao = "";
                this.QTDE_CX_PCT_SC_FD = 0.00;
    }
    
    public DadosProdutos(int id, String descricao, String categoria, String barras, int ncm, int cest, String fabricante, String fornecedor, String und_medida, String estoque, double est_minimo, double est_maximo, double valor_pago, double desc_promocional, double qtde_promocional, double ii, double ipi, double pis, double cofins, double icms, double mva, double redutor, double redutor_st, double seguro, double outros, double desconto, double frete, String validade, String custo, String marckup, String varejo, String inclusao, String alteracao, double FCP, String CST_ICMS, String Origem, String CST_IPI, String CodEnquadramento, String CST_PIS, String CST_COFINS, String Tributacao, double QTDE_CX_PCT_SC_FD) {
                this.id = id;
                this.descricao = descricao;
                this.categoria = categoria;
                this.barras = barras;
                this.ncm = ncm;
                this.cest = cest;
                this.fabricante = fabricante;
                this.fornecedor = fornecedor;
                this.und_medida = und_medida;
                this.estoque = estoque;
                this.est_minimo = est_minimo;
                this.est_maximo = est_maximo;
                this.valor_pago = valor_pago;
                this.desc_promocional = desc_promocional;
                this.qtde_promocional = qtde_promocional;
                this.ii = ii;
                this.ipi = ipi;
                this.pis = pis;
                this.cofins = cofins;
                this.icms = icms;
                this.mva = mva;
                this.redutor = redutor;
                this.redutor_st = redutor_st;
                this.seguro = seguro;
                this.outros = outros;
                this.desconto = desconto;
                this.frete = frete;
                this.validade = validade;
                this.custo = custo;
                this.marckup = marckup;
                this.varejo = varejo;
                this.inclusao = inclusao;
                this.alteracao = alteracao;
                this.FCP = FCP;
                this.CST_ICMS = CST_ICMS;
                this.Origem = Origem;
                this.CST_IPI = CST_IPI;
                this.CodEnquadramento = CodEnquadramento;
                this.CST_PIS = CST_PIS;
                this.CST_COFINS = CST_COFINS;
                this.Tributacao = Tributacao;
                this.QTDE_CX_PCT_SC_FD = QTDE_CX_PCT_SC_FD;
        }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public String getCategoria(){
        return this.categoria;
    }
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    public String getBarras(){
        return this.barras;
    }
    public void setBarras(String barras){
        this.barras = barras;
    }
    public int getNcm(){
        return this.ncm;
    }
    public void setNcm(int ncm){
        this.ncm = ncm;
    }
    public int getCest(){
        return this.cest;
    }
    public void setCest(int cest){
        this.cest = cest;
    }
    public String getFabricante(){
        return this.fabricante;
    }
    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }
    public String getFornecedor(){
        return this.fornecedor;
    }
    public void setFornecedor(String fornecedor){
        this.fornecedor = fornecedor;
    }
    public String getUnd_medida(){
        return this.und_medida;
    }
    public void setUnd_medida(String und_medida){
        this.und_medida = und_medida;
    }
    public String getEstoque(){
        return this.estoque;
    }
    public void setEstoque(String estoque){
        this.estoque = estoque;
    }
    public double getEst_minimo(){
        return this.est_minimo;
    }
    public void setEst_minimo(double est_minimo){
        this.est_minimo = est_minimo;
    }
    public double getEst_maximo(){
        return this.est_maximo;
    }
    public void setEst_maximo(double est_maximo){
        this.est_maximo = est_maximo;
    }
    public double getValor_pago(){
        return this.valor_pago;
    }
    public void setValor_pago(double valor_pago){
        this.valor_pago = valor_pago;
    }
    public double getDesc_promocional(){
        return this.desc_promocional;
    }
    public void setDesc_promocional(double desc_promocional){
        this.desc_promocional = desc_promocional;
    }
    public double getQtde_promocional(){
        return this.qtde_promocional;
    }
    public void setQtde_promocional(double qtde_promocional){
        this.qtde_promocional = qtde_promocional;
    }
    public double getII(){
        return this.ii;
    }
    public void setII(double ii){
        this.ii = ii;
    }
    public double getIPI(){
        return this.ipi;
    }
    public void setIPI(double ipi){
        this.ipi = ipi;
    }
    public double getPIS(){
        return this.pis;
    }
    public void setPIS(double pis){
        this.pis = pis;
    }
    public double getCOFINS(){
        return this.cofins;
    }
    public void setCOFINS(double cofins){
        this.cofins = cofins;
    }
    public double getICMS(){
        return this.icms;
    }
    public void setICMS(double icms){
        this.icms = icms;
    }
    public double getMVA(){
        return this.mva;
    }
    public void setMVA(double mva){
        this.mva = mva;
    }
    public double getRedutor(){
        return this.redutor;
    }
    public void setRedutor(double redutor){
        this.redutor = redutor;
    }
    public double getRedutor_ST(){
        return this.redutor_st;
    }
    public void setRedutor_ST(double redutor_st){
        this.redutor_st = redutor_st;
    }
    public double getSeguro(){
        return this.seguro;
    }
    public void setSeguro(double seguro){
        this.seguro = seguro;
    }
    public double getOutros(){
        return this.outros;
    }
    public void setOutros(double outros){
        this.outros = outros;
    }
    public double getDesconto(){
        return this.desconto;
    }
    public void setDesconto(double desconto){
        this.desconto = desconto;
    }
    public double getFrete(){
        return this.frete;
    }
    public void setFrete(double frete){
        this.frete = frete;
    }
    public String getValidade(){
        return this.validade;
    }
    public void setValidade(String validade){
        this.validade = validade;
    }
    public String getCusto(){
        return this.custo;
    }
    public void setCusto(String custo){
        this.custo = custo;
    }
    public String getMarckup(){
        return this.marckup;
    }
    public void setMarckup(String marckup){
        this.marckup = marckup;
    }
    public String getVarejo(){
        return this.varejo;
    }
    public void setVarejo(String varejo){
        this.varejo = varejo;
    }
    public String getInclusao(){
        return this.inclusao;
    }
    public void setInclusao(String inclusao){
        this.inclusao = inclusao;
    }
    public String getAlteracao(){
        return this.alteracao;
    }
    public void setAlteracao(String alteracao){
        this.alteracao = alteracao;
    }
    public double getFCP(){
        return this.FCP;
    }
    public void setFCP(double FCP){
        this.FCP = FCP;
    }
    public String getCST_ICMS(){
        return this.CST_ICMS;
    }
    public void setCST_ICMS(String CST_ICMS){
        this.CST_ICMS = CST_ICMS;
    }
    public String getOrigem(){
        return this.Origem;
    }
    public void setOrigem(String Origem){
        this.Origem = Origem;
    }
    public String getCST_IPI(){
        return this.CST_IPI;
    }
    public void setCST_IPI(String CST_IPI){
        this.CST_IPI = CST_IPI;
    }
    public String getCodEnquadramento(){
        return this.CodEnquadramento;
    }
    public void setCodEnquadramento(String CodEnquadramento){
        this.CodEnquadramento = CodEnquadramento;
    }
    public String getCST_PIS(){
        return this.CST_PIS;
    }
    public void setCST_PIS(String CST_PIS){
        this.CST_PIS = CST_PIS;
    }
    public String getCST_COFINS(){
        return this.CST_COFINS;
    }
    public void setCST_COFINS(String CST_COFINS){
        this.CST_COFINS = CST_COFINS;
    }
    public String getTributacao(){
	return this.Tributacao;
    }
    public void setTributacao(String Tributacao){
	this.Tributacao = Tributacao;
    }
    public double getQTDE_CX_PCT_SC_FD(){
        return this.QTDE_CX_PCT_SC_FD;
    }
    public void setQTDE_CX_PCT_SC_FD(double QTDE_CX_PCT_SC_FD){
        this.QTDE_CX_PCT_SC_FD = QTDE_CX_PCT_SC_FD;
    }
}
