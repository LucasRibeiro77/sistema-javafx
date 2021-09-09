package sistema;

public class DadosProdutosNFeAdd {
    String id;
    String descricao;
    String barras;
    String ncm;
    String cest;
    String und_medida;
    String qtde;
    String valor_pago;
    String valor_total;
    String ii;
    String ipi;
    String pis;
    String cofins;
    String icms;
    String mva;
    String redutor;
    String redutor_st;
    String seguro;
    String outros;
    String desconto;
    String frete;
    String FCP;
    String CST_ICMS;
    String Origem;
    String CST_IPI;
    String CodEnquadramento;
    String CST_PIS;
    String CST_COFINS;
    String base_icms;
    String valorIcms;
    String base_icms_st;
    String valor_icms_st;
    String base_ipi;
    String valor_ipi;
    String base_pis;
    String valor_pis;
    String base_cofins;
    String valor_cofins;
    String valor_fcp;
    
    public void DadosProdutos(){
                this.id = "";
                this.descricao = "";
                this.barras = "";
                this.ncm = "";
                this.cest = "";
                this.und_medida = "";
                this.qtde = "";
                this.valor_pago = "";
                this.valor_total = "";
                this.ii = "";
                this.ipi = "";
                this.pis = "";
                this.cofins = "";
                this.icms = "";
                this.mva = "";
                this.redutor = "";
                this.redutor_st = "";
                this.seguro = "";
                this.outros = "";
                this.desconto = "";
                this.frete = "";
                this.FCP = "";
                this.CST_ICMS = "";
                this.Origem = "";
                this.CST_IPI = "";
                this.CodEnquadramento = "";
                this.CST_PIS = "";
                this.CST_COFINS = "";
                this.base_icms = "";
                this.valorIcms = "";
                this.base_icms_st = "";
                this.valor_icms_st = "";
                this.base_ipi = "";
                this.valor_ipi = "";
                this.base_pis = "";
                this.valor_pis = "";
                this.base_cofins = "";
                this.valor_cofins = "";
                this.valor_fcp = "";
    }
    
    public DadosProdutosNFeAdd(String id, String descricao, String barras, String ncm, String cest, String und_medida, String qtde, String valor_pago,  String valor_total, String ii, String ipi, String pis, String cofins, String icms, String mva, String redutor, String redutor_st, String seguro, String outros, String desconto, String frete, String FCP, String CST_ICMS, String Origem, String CST_IPI, String CodEnquadramento, String CST_PIS, String CST_COFINS, String base_icms, String valor_icms, String base_icms_st, String valor_icms_st, String base_ipi, String valor_ipi, String base_pis, String valor_pis, String base_cofins, String valor_cofins, String valor_fcp) {
                this.id = id;
                this.descricao = descricao;
                this.barras = barras;
                this.ncm = ncm;
                this.cest = cest;
                this.und_medida = und_medida;
                this.qtde = qtde;
                this.valor_pago = valor_pago;
                this.valor_total = valor_total;
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
                this.FCP = FCP;
                this.CST_ICMS = CST_ICMS;
                this.Origem = Origem;
                this.CST_IPI = CST_IPI;
                this.CodEnquadramento = CodEnquadramento;
                this.CST_PIS = CST_PIS;
                this.CST_COFINS = CST_COFINS;
                this.base_icms = base_icms;
                this.valorIcms = valor_icms;
                this.base_icms_st = base_icms_st;
                this.valor_icms_st = valor_icms_st;
                this.base_ipi = base_ipi;
                this.valor_ipi = valor_ipi;
                this.base_pis = base_pis;
                this.valor_pis = valor_pis;
                this.base_cofins = base_cofins;
                this.valor_cofins = valor_cofins;
                this.valor_fcp = valor_fcp;
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
    public String getBarras(){
        return this.barras;
    }
    public void setBarras(String barras){
        this.barras = barras;
    }
    public String getNcm(){
        return this.ncm;
    }
    public void setNcm(String ncm){
        this.ncm = ncm;
    }
    public String getCest(){
        return this.cest;
    }
    public void setCest(String cest){
        this.cest = cest;
    }
    public String getUnd_medida(){
        return this.und_medida;
    }
    public void setUnd_medida(String und_medida){
        this.und_medida = und_medida;
    }
    public String getQtde(){
        return this.qtde;
    }
    public void setQtde(String qtde){
        this.qtde = qtde;
    }
    public String getValor_pago(){
        return this.valor_pago;
    }
    public void setValor_pago(String valor_pago){
        this.valor_pago = valor_pago;
    }
    public String getValor_total(){
        return this.valor_total;
    }
    public void setValor_total(String valor_total){
        this.valor_total = valor_total;
    }
    public String getII(){
        return this.ii;
    }
    public void setII(String ii){
        this.ii = ii;
    }
    public String getIPI(){
        return this.ipi;
    }
    public void setIPI(String ipi){
        this.ipi = ipi;
    }
    public String getPIS(){
        return this.pis;
    }
    public void setPIS(String pis){
        this.pis = pis;
    }
    public String getCOFINS(){
        return this.cofins;
    }
    public void setCOFINS(String cofins){
        this.cofins = cofins;
    }
    public String getICMS(){
        return this.icms;
    }
    public void setICMS(String icms){
        this.icms = icms;
    }
    public String getMVA(){
        return this.mva;
    }
    public void setMVA(String mva){
        this.mva = mva;
    }
    public String getRedutor(){
        return this.redutor;
    }
    public void setRedutor(String redutor){
        this.redutor = redutor;
    }
    public String getRedutor_ST(){
        return this.redutor_st;
    }
    public void setRedutor_ST(String redutor_st){
        this.redutor_st = redutor_st;
    }
    public String getSeguro(){
        return this.seguro;
    }
    public void setSeguro(String seguro){
        this.seguro = seguro;
    }
    public String getOutros(){
        return this.outros;
    }
    public void setOutros(String outros){
        this.outros = outros;
    }
    public String getDesconto(){
        return this.desconto;
    }
    public void setDesconto(String desconto){
        this.desconto = desconto;
    }
    public String getFrete(){
        return this.frete;
    }
    public void setFrete(String frete){
        this.frete = frete;
    }
    public String getFCP(){
        return this.FCP;
    }
    public void setFCP(String FCP){
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
    public String getBaseICMS(){
        return this.base_icms;
    }
    public void setBaseICMS(String base_icms){
        this.base_icms = base_icms;
    }
    public String getValorICMS(){
        return this.valorIcms;
    }
    public void setValorICMS(String valor_icms){
        this.valorIcms = valor_icms;
    }
    public String getBaseICMS_ST(){
        return this.base_icms_st;
    }
    public void setBaseICMS_ST(String base_icms_st){
        this.base_icms_st = base_icms_st;
    }
    public String getValorICMS_ST(){
        return this.valor_icms_st;
    }
    public void setValorICMS_ST(String valor_icms_st){
        this.valor_icms_st = valor_icms_st;
    }
    public String getBaseIPI(){
        return this.base_ipi;
    }
    public void setBaseIPI(String base_ipi){
        this.base_ipi = base_ipi;
    }
    public String getValorIPI(){
        return this.valor_ipi;
    }
    public void setValorIPI(String valor_ipi){
        this.valor_ipi = valor_ipi;
    }
    public String getBasePIS(){
        return this.base_pis;
    }
    public void setBasePIS(String base_pis){
        this.base_pis = base_pis;
    }
    public String getValorPIS(){
        return this.valor_pis;
    }
    public void setValorPIS(String valor_pis){
        this.valor_pis = valor_pis;
    }
    public String getBaseCOFINS(){
        return this.base_cofins;
    }
    public void setBaseCOFINS(String base_cofins){
        this.base_cofins = base_cofins;
    }
    public String getValorCOFINS(){
        return this.valor_cofins;
    }
    public void setValorCOFINS(String valor_cofins){
        this.valor_cofins = valor_cofins;
    }    
}

