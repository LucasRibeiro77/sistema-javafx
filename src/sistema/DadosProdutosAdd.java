package sistema;

public class DadosProdutosAdd {
    int id;
    String descricao;
    String barras;
    int ncm;
    int cest;
    String und_medida;
    double qtde;
    double valor_pago;
    double valor_total;
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
    double FCP;
    String CST_ICMS;
    String Origem;
    String CST_IPI;
    String CodEnquadramento;
    String CST_PIS;
    String CST_COFINS;
    double base_icms;
    double valorIcms;
    double base_icms_st;
    double valor_icms_st;
    double base_ipi;
    double valor_ipi;
    double base_pis;
    double valor_pis;
    double base_cofins;
    double valor_cofins;
    double valor_fcp;
    String codUf;
    String cnpjEmit;
    String razaoSocialEmit;
    String nomeFantasiaEmit;
    String IEemit;
    String IMemit;
    String IESTemit;
    String CNAEemit;
    String regimeEmit;
    String telefoneEmit;
    String logradouroEmit;
    String nrEmit;
    String cidadeEmit;
    String estadoEmit;
    String paisEmit;
    String cepEmit;
    String bairroEmit;
    String codPaisEmit;
    String codMunicipioEmit;
    String razaoSocialTransp;
    String cnpjTransp;
    String ieTransp;
    String ufTransp;
    String logradouroTransp;
    String nrTransp;
    String ufEndTransp;
    String municipioEndTransp;
    String placa;
    String ufVeicTransp;
    String antt;
    double qtdeVolumes;
    String codUfDest;
    String cnpjDest;
    String razaoSocialDest;
    String nomeFantasiaDest;
    String IEDest;
    String IMDest;
    String IESTDest;
    String CNAEDest;
    String regimeDest;
    String telefoneDest;
    String logradouroDest;
    String nrDest;
    String cidadeDest;
    String estadoDest;
    String paisDest;
    String cepDest;
    String bairroDest;
    String codPaisDest;
    String codMunicipioDest;    
    double total_bc_icms;
    double total_valor_icms;
    double total_bc_icms_st;
    double total_valor_icms_st;
    double total_valor_icms_desonerado;
    double total_valor_fcp;
    double total_bc_fcp_st;
    double total_valor_fcp_st;
    double total_valor_fcp_st_retido;
    double total_produtos;
    double total_frete;
    double total_seguro;
    double total_desconto;
    double total_ii;
    double total_ipi;
    double total_ipi_devolvido;
    double total_pis;
    double total_cofins;
    double total_outros;
    double total_nota;
    
    public void DadosProdutos(){
                this.id = 0;
                this.descricao = "";
                this.barras = "";
                this.ncm = 0;
                this.cest = 0;
                this.und_medida = "";
                this.qtde = 0.00;
                this.valor_pago = 0.00;
                this.valor_total = 0.00;
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
                this.FCP = 0.00;
                this.CST_ICMS = "";
                this.Origem = "";
                this.CST_IPI = "";
                this.CodEnquadramento = "";
                this.CST_PIS = "";
                this.CST_COFINS = "";
                this.base_icms = 0.00;
                this.valorIcms = 0.00;
                this.base_icms_st = 0.00;
                this.valor_icms_st = 0.00;
                this.base_ipi = 0.00;
                this.valor_ipi = 0.00;
                this.base_pis = 0.00;
                this.valor_pis = 0.00;
                this.base_cofins = 0.00;
                this.valor_cofins = 0.00;
                this.valor_fcp = 0.00;
                this.codUf = "";
                this.cnpjEmit = "";
                this.razaoSocialEmit = "";
                this.nomeFantasiaEmit = "";
                this.IEemit = "";
                this.IMemit = "";
                this.IESTemit = "";
                this.CNAEemit = "";
                this.regimeEmit = "";
                this.telefoneEmit = "";
                this.logradouroEmit = "";
                this.nrEmit = "";
                this.cidadeEmit = "";
                this.estadoEmit = "";
                this.paisEmit = "";
                this.cepEmit = "";
                this.bairroEmit = "";
                this.codPaisEmit = "";
                this.codMunicipioEmit = "";
                this.razaoSocialTransp = "";
                this.cnpjTransp = "";
                this.ieTransp = "";
                this.ufTransp = "";
                this.logradouroTransp = "";
                this.nrTransp = "";
                this.ufEndTransp = "";
                this.municipioEndTransp = "";
                this.placa = "";
                this.ufVeicTransp = "";
                this.antt = "";
                this.qtdeVolumes = 0.00;
                this.codUfDest = "";
                this.cnpjDest = "";
                this.razaoSocialDest = "";
                this.nomeFantasiaDest = "";
                this.IEDest = "";
                this.IMDest = "";
                this.IESTDest = "";
                this.CNAEDest = "";
                this.regimeDest = "";
                this.telefoneDest = "";
                this.logradouroDest = "";
                this.nrDest = "";
                this.cidadeDest = "";
                this.estadoDest = "";
                this.paisDest = "";
                this.cepDest = "";
                this.bairroDest = "";
                this.codPaisDest = "";
                this.codMunicipioDest = "";
                this.total_bc_icms = 0.00;
                this.total_valor_icms = 0.00;
                this.total_bc_icms_st = 0.00;
                this.total_valor_icms_st = 0.00;
                this.total_valor_icms_desonerado = 0.00;
                this.total_valor_fcp = 0.00;
                this.total_bc_fcp_st = 0.00;
                this.total_valor_fcp_st = 0.00;
                this.total_valor_fcp_st_retido = 0.00;
                this.total_produtos = 0.00;
                this.total_frete = 0.00;
                this.total_seguro = 0.00;
                this.total_desconto = 0.00;
                this.total_ii = 0.00;
                this.total_ipi = 0.00;
                this.total_ipi_devolvido = 0.00;
                this.total_pis = 0.00;
                this.total_cofins = 0.00;
                this.total_outros = 0.00;
                this.total_nota = 0.00;
    }
    
    public DadosProdutosAdd(int id, String descricao, String barras, int ncm, int cest, String und_medida, double qtde, double valor_pago,  double valor_total, double ii, double ipi, double pis, double cofins, double icms, double mva, double redutor, double redutor_st, double seguro, double outros, double desconto, double frete, double FCP, String CST_ICMS, String Origem, String CST_IPI, String CodEnquadramento, String CST_PIS, String CST_COFINS, double base_icms, double valor_icms, double base_icms_st, double valor_icms_st, double base_ipi, double valor_ipi, double base_pis, double valor_pis, double base_cofins, double valor_cofins, double valor_fcp, String codUf, String cnpjEmit, String razaoSocialEmit, String nomeFantasiaEmit, String IEemit, String IMemit, String IESTemit, String CNAEemit, String regimeEmit, String telefoneEmit, String logradouroEmit, String nrEmit, String cidadeEmit, String estadoEmit, String paisEmit, String cepEmit, String bairroEmit, String codPaisEmit, String codMunicipioEmit, String razaoSocialTransp, String cnpjTransp, String ieTransp, String ufTransp, String logradouroTransp, String nrTransp, String ufEndTransp, String municipioEndTransp, String placa, String ufVeicTransp, String antt, double qtdeVolumes, String codUfDest, String cnpjDest, String razaoSocialDest, String nomeFantasiaDest, String IEDest, String IMDest, String IESTDest, String CNAEDest, String regimeDest, String telefoneDest, String logradouroDest, String nrDest, String cidadeDest, String estadoDest, String paisDest, String cepDest, String bairroDest, String codPaisDest, String codMunicipioDest, double total_bc_icms, double total_valor_icms, double total_bc_icms_st, double total_valor_icms_st, double total_valor_icms_desonerado, double total_valor_fcp, double total_bc_fcp_st, double total_valor_fcp_st, double total_valor_fcp_st_retido, double total_produtos, double total_frete, double total_seguro, double total_desconto, double total_ii, double total_ipi, double total_ipi_devolvido, double total_pis, double total_cofins, double total_outros, double total_nota){
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
                this.codUf = codUf;
                this.cnpjEmit = cnpjEmit;
                this.razaoSocialEmit = razaoSocialEmit;
                this.nomeFantasiaEmit = nomeFantasiaEmit;
                this.IEemit = IEemit;
                this.IMemit = IMemit;
                this.IESTemit = IESTemit;
                this.CNAEemit = CNAEemit;
                this.regimeEmit = regimeEmit;
                this.telefoneEmit = telefoneEmit;
                this.logradouroEmit = logradouroEmit;
                this.nrEmit = nrEmit;
                this.cidadeEmit = cidadeEmit;
                this.estadoEmit = estadoEmit;
                this.paisEmit = paisEmit;
                this.cepEmit = cepEmit;
                this.bairroEmit = bairroEmit;
                this.codPaisEmit = codPaisEmit;        
                this.codMunicipioEmit = codMunicipioEmit;
                this.razaoSocialTransp = razaoSocialTransp;
                this.cnpjTransp = cnpjTransp;
                this.ieTransp = ieTransp;
                this.ufTransp = ufTransp;
                this.logradouroTransp = logradouroTransp;
                this.nrTransp = nrTransp;
                this.ufEndTransp = ufEndTransp;
                this.municipioEndTransp = municipioEndTransp;
                this.placa = placa;
                this.ufVeicTransp = ufVeicTransp;
                this.antt = antt;
                this.qtdeVolumes = qtdeVolumes;
                this.codUfDest = codUfDest;
                this.cnpjDest = cnpjDest;
                this.razaoSocialDest = razaoSocialDest;
                this.nomeFantasiaDest = nomeFantasiaDest;
                this.IEDest = IEDest;
                this.IMDest = IMDest;
                this.IESTDest = IESTDest;
                this.CNAEDest = CNAEDest;
                this.regimeDest = regimeDest;
                this.telefoneDest = telefoneDest;
                this.logradouroDest = logradouroDest;
                this.nrDest = nrDest;
                this.cidadeDest = cidadeDest;
                this.estadoDest = estadoDest;
                this.paisDest = paisDest;
                this.cepDest = cepDest;
                this.bairroDest = bairroDest;
                this.codPaisDest = codPaisDest;        
                this.codMunicipioDest = codMunicipioDest;
                this.total_bc_icms = total_bc_icms;
                this.total_valor_icms = total_valor_icms;
                this.total_bc_icms_st = total_bc_icms_st;
                this.total_valor_icms_st = total_valor_icms_st;
                this.total_valor_icms_desonerado = total_valor_icms_desonerado;
                this.total_valor_fcp = total_valor_fcp;
                this.total_bc_fcp_st = total_bc_fcp_st;
                this.total_valor_fcp_st = total_valor_fcp_st;
                this.total_valor_fcp_st_retido = total_valor_fcp_st_retido;
                this.total_produtos = total_produtos;
                this.total_frete = total_frete;
                this.total_seguro = total_seguro;
                this.total_desconto = total_desconto;
                this.total_ii = total_ii;
                this.total_ipi = total_ipi;
                this.total_ipi_devolvido = total_ipi_devolvido;
                this.total_pis = total_pis;
                this.total_cofins = total_cofins;
                this.total_outros = total_outros;
                this.total_nota = total_nota;
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
    public String getUnd_medida(){
        return this.und_medida;
    }
    public void setUnd_medida(String und_medida){
        this.und_medida = und_medida;
    }
    public double getQtde(){
        return this.qtde;
    }
    public void setQtde(double qtde){
        this.qtde = qtde;
    }
    public double getValor_pago(){
        return this.valor_pago;
    }
    public void setValor_pago(double valor_pago){
        this.valor_pago = valor_pago;
    }
    public double getValor_total(){
        return this.valor_total;
    }
    public void setValor_total(double valor_total){
        this.valor_total = valor_total;
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
    public double getBaseICMS(){
        return this.base_icms;
    }
    public void setBaseICMS(double base_icms){
        this.base_icms = base_icms;
    }
    public double getValorICMS(){
        return this.valorIcms;
    }
    public void setValorICMS(double valor_icms){
        this.valorIcms = valor_icms;
    }
    public double getBaseICMS_ST(){
        return this.base_icms_st;
    }
    public void setBaseICMS_ST(double base_icms_st){
        this.base_icms_st = base_icms_st;
    }
    public double getValorICMS_ST(){
        return this.valor_icms_st;
    }
    public void setValorICMS_ST(double valor_icms_st){
        this.valor_icms_st = valor_icms_st;
    }
    public double getBaseIPI(){
        return this.base_ipi;
    }
    public void setBaseIPI(double base_ipi){
        this.base_ipi = base_ipi;
    }
    public double getValorIPI(){
        return this.valor_ipi;
    }
    public void setValorIPI(double valor_ipi){
        this.valor_ipi = valor_ipi;
    }
    public double getBasePIS(){
        return this.base_pis;
    }
    public void setBasePIS(double base_pis){
        this.base_pis = base_pis;
    }
    public double getValorPIS(){
        return this.valor_pis;
    }
    public void setValorPIS(double valor_pis){
        this.valor_pis = valor_pis;
    }
    public double getBaseCOFINS(){
        return this.base_cofins;
    }
    public void setBaseCOFINS(double base_cofins){
        this.base_cofins = base_cofins;
    }
    public double getValorCOFINS(){
        return this.valor_cofins;
    }
    public void setValorCOFINS(double valor_cofins){
        this.valor_cofins = valor_cofins;
    }    
    public String getCodUf(){
        return this.codUf;
    }
    public void setCodUf(String codUf){
        this.codUf = codUf;
    }
    public String getCNPJEmit(){
        return this.cnpjEmit;
    }
    public void setCNPJEmit(String cnpjEmit){
        this.codUf = cnpjEmit;
    }
    public String getRazaoSocialEmit(){
        return this.razaoSocialEmit;
    }
    public void setRazaoSocial(String razaoSocialEmit){
        this.razaoSocialEmit = razaoSocialEmit;
    }
    public String getNomeFantasiaEmit(){
        return this.nomeFantasiaEmit;
    }
    public void setNomeFantasia(String nomeFantasiaEmit){
        this.nomeFantasiaEmit = nomeFantasiaEmit;
    }
    public String getIE_Emit(){
        return this.IEemit;
    }
    public void setIE_Emit(String IEemit){
        this.IEemit = IEemit;
    }
    public String getIM_Emit(){
        return this.IMemit;
    }
    public void setIM_Emit(String IMemit){
        this.IMemit = IMemit;
    }
    public String getIEST_Emit(){
        return this.IESTemit;
    }
    public void setIEST_Emit(String IESTemit){
        this.IESTemit = IESTemit;
    }
    public String getCNAE_Emit(){
        return this.CNAEemit;
    }
    public void setCNAE_Emit(String CNAEemit){
        this.CNAEemit = CNAEemit;
    }
    public String getRegimeEmit(){
        return this.regimeEmit;
    }
    public void setRegimeEmit(String regimeEmit){
        this.regimeEmit = regimeEmit;
    }
    public String getTelefoneEmit(){
        return this.telefoneEmit;
    }
    public void setTelefoneEmit(String telefoneEmit){
        this.telefoneEmit = telefoneEmit;
    }
    public String getLogradouroEmit(){
        return this.logradouroEmit;
    }
    public void setLogradouro(String logradouroEmit){
        this.logradouroEmit = logradouroEmit;
    }
    public String getNrEmit(){
        return this.nrEmit;
    }
    public void setNrEmit(String nrEmit){
        this.nrEmit = nrEmit;
    }
    public String getCidadeEmit(){
        return this.cidadeEmit;
    }
    public void setCidadeEmit(String cidadeEmit){
        this.cidadeEmit = cidadeEmit;
    }
    public String getEstadoEmit(){
        return this.estadoEmit;
    }
    public void setEstadoEmit(String estadoEmit){
        this.estadoEmit = estadoEmit;
    }
    public String getPaisEmit(){
        return this.paisEmit;
    }
    public void setPaisEmit(String paisEmit){
        this.paisEmit = paisEmit;
    }
    public String getCEP_Emit(){
        return this.cepEmit;
    }
    public void setCEP_Emit(String cepEmit){
        this.cepEmit = cepEmit;
    }
    public String getBairroEmit(){
        return this.bairroEmit;
    }
    public void setBairroEmit(String bairroEmit){
        this.bairroEmit = bairroEmit;
    }
    public String getCodPaisEmit(){
        return this.codPaisEmit;
    }
    public void setCodPaisEmit(String codPaisEmit){
        this.codPaisEmit = codPaisEmit;
    }
    public String getCodMunicipioEmit(){
        return this.codMunicipioEmit;
    }
    public void setCodMunicipioEmit(String codMunicipioEmit){
        this.codMunicipioEmit = codMunicipioEmit;
    }
    public String getRazaoSocialTransp(){
                return this.razaoSocialTransp;	
    }
    public void setRazaoSocialTransp(String razaoSocialTransp){
                this.razaoSocialTransp = razaoSocialTransp;	
    }
    public String getCnpjTransp(){
                return this.cnpjTransp;
    }
    public void setCnpjTransp(String cnpjTransp){
                this.cnpjTransp = cnpjTransp;
    }
    public String getIeTransp(){
                return this.ieTransp;
    }
    public void setIeTransp(String ieTransp){
                this.ieTransp = ieTransp;
    }
    public String getUfTransp(){
                return this.ufTransp;
    }
    public void setUfTransp(String ufTransp){
                this.ufTransp = ufTransp;
    }
    public String getLogradouroTransp(){
                return this.logradouroTransp;
    }
    public void setLogradouroTransp(String logradouroTransp){
                this.logradouroTransp = logradouroTransp;
    }
    public String getNrTransp(){
                return this.nrTransp;
    }
    public void setNrTransp(String nrTransp){
                this.nrTransp = nrTransp;
    }
    public String getUfEndTransp(){
                return this.ufEndTransp;
    }
    public void setUfEndTransp(String ufEndTransp){
                this.ufEndTransp = ufEndTransp;
    }
    public String getMunicipioEndTransp(){
                return this.municipioEndTransp;
    }
    public void setMunicipioEndTransp(String municipioEndTransp){
                this.municipioEndTransp = municipioEndTransp;
    }
    public String getPlaca(){
                return this.placa;
    }
    public void setPlaca(String placa){
                this.placa = placa;
    }
    public String getUfVeicTransp(){
                return this.ufVeicTransp;
    }
    public void setUfVeicTransp(String ufVeicTransp){
                this.ufVeicTransp = ufVeicTransp;
    }
    public String getAntt(){
                return this.antt;
    }
    public void setAntt(String antt){
                this.antt = antt;
    }
    public double getQtdeVolumes(){
                return this.qtdeVolumes;
    }
    public void setQtdeVolumes(double qtdeVolumes){
                this.qtdeVolumes = qtdeVolumes;
    }
    public String getCodUfDest(){
        return this.codUfDest;
    }
    public void setCodUfDest(String codUf){
        this.codUfDest = codUfDest;
    }
    public String getCNPJDest(){
        return this.cnpjDest;
    }
    public void setCNPJDest(String cnpjDest){
        this.codUf = cnpjDest;
    }
    public String getRazaoSocialDest(){
        return this.razaoSocialDest;
    }
    public void setRazaoSocialDest(String razaoSocialDest){
        this.razaoSocialDest = razaoSocialDest;
    }
    public String getNomeFantasiaDest(){
        return this.nomeFantasiaDest;
    }
    public void setNomeFantasiaDest(String nomeFantasiaDest){
        this.nomeFantasiaDest = nomeFantasiaDest;
    }
    public String getIE_Dest(){
        return this.IEDest;
    }
    public void setIE_Dest(String IEDest){
        this.IEDest = IEDest;
    }
    public String getIM_Dest(){
        return this.IMDest;
    }
    public void setIM_Dest(String IMDest){
        this.IMDest = IMDest;
    }
    public String getIEST_Dest(){
        return this.IESTDest;
    }
    public void setIEST_Dest(String IESTDest){
        this.IESTDest = IESTDest;
    }
    public String getCNAE_Dest(){
        return this.CNAEDest;
    }
    public void setCNAE_Dest(String CNAEDest){
        this.CNAEDest = CNAEDest;
    }
    public String getRegimeDest(){
        return this.regimeDest;
    }
    public void setRegimeDest(String regimeDest){
        this.regimeDest = regimeDest;
    }
    public String getTelefoneDest(){
        return this.telefoneDest;
    }
    public void setTelefoneDest(String telefoneDest){
        this.telefoneDest = telefoneDest;
    }
    public String getLogradouroDest(){
        return this.logradouroDest;
    }
    public void setLogradouroDest(String logradouroDest){
        this.logradouroDest = logradouroDest;
    }
    public String getNrDest(){
        return this.nrDest;
    }
    public void setNrDest(String nrDest){
        this.nrDest = nrDest;
    }
    public String getCidadeDest(){
        return this.cidadeDest;
    }
    public void setCidadeDest(String cidadeDest){
        this.cidadeDest = cidadeDest;
    }
    public String getEstadoDest(){
        return this.estadoDest;
    }
    public void setEstadoDest(String estadoDest){
        this.estadoDest = estadoDest;
    }
    public String getPaisDest(){
        return this.paisDest;
    }
    public void setPaisDest(String paisDest){
        this.paisDest = paisDest;
    }
    public String getCEP_Dest(){
        return this.cepDest;
    }
    public void setCEP_Dest(String cepDest){
        this.cepDest = cepDest;
    }
    public String getBairroDest(){
        return this.bairroDest;
    }
    public void setBairroDest(String bairroDest){
        this.bairroDest = bairroDest;
    }
    public String getCodPaisDest(){
        return this.codPaisDest;
    }
    public void setCodPaisDest(String codPaisDest){
        this.codPaisDest = codPaisDest;
    }
    public String getCodMunicipioDest(){
        return this.codMunicipioDest;
    }
    public void setCodMunicipioDest(String codMunicipioDest){
        this.codMunicipioDest = codMunicipioDest;
    }
        public double getTotalBCIcms(){
        return this.total_bc_icms;
    }
    public void setTotalBCIcms(double total_bc_icms){
        this.total_bc_icms = total_bc_icms;
    }
    public double getTotalIcms(){
        return this.total_valor_icms;
    }
    public void setTotalICMS(double total_valor_icms){
        this.total_valor_icms = total_valor_icms;
    }
    public double getTotalBCIcmsST(){
        return this.total_bc_icms_st;
    }
    public void setTotalBCIcmsST(double total_bc_icms_st){
        this.total_bc_icms_st = total_bc_icms_st;
    }
    public double getTotalIcmsST(){
        return this.total_valor_icms_st;
    }
    public void setTotalIcmsST(double total_valor_icms_st){
        this.total_valor_icms_st = total_valor_icms_st;
    }
    public double getTotalIcmsDesonerado(){
        return this.total_valor_icms_desonerado;
    }
    public void setTotalIcmsDesonerado(double total_valor_icms_desonerado){
        this.total_valor_icms_desonerado = total_valor_icms_desonerado;
    }
    public double getTotalFcp(){
        return this.total_valor_fcp;
    }
    public void setTotalFcp(double total_valor_fcp){
        this.total_valor_fcp = total_valor_fcp;
    }
    public double getTotalBCFcpST(){
        return this.total_bc_fcp_st;
    }
    public void setTotalBCFcpST(double total_bc_fcp_st){
        this.total_bc_fcp_st = total_bc_fcp_st;
    }
    public double getTotalFcpST(){
        return this.total_valor_fcp_st;
    }
    public void setTotalFcpST(double total_valor_fcp_st){
        this.total_valor_fcp_st = total_valor_fcp_st;
    }
    public double getTotalFcpSTRetido(){
        return this.total_valor_fcp_st_retido;
    }
    public void setTotalFcpSTRetido(double total_valor_fcp_st_retido){
        this.total_valor_fcp_st_retido = total_valor_fcp_st_retido;
    }
    public double getTotalProdutos(){
        return this.total_produtos;
    }
    public void setTotalProdutos(double total_produtos){
        this.total_produtos = total_produtos;
    }
    public double getTotalFrete(){
        return this.total_frete;
    }
    public void setTotalFrete(double total_frete){
        this.total_frete = total_frete;
    }
    public double getTotalSeguro(){
        return this.total_seguro;
    }
    public void setTotalSeguro(double total_seguro){
        this.total_seguro = total_seguro;
    }
    public double getTotalDesconto(){
        return this.total_desconto;
    }
    public void setTotalDesconto(double total_desconto){
        this.total_desconto = total_desconto;
    }
    public double getTotalII(){
        return this.total_ii;
    }
    public void setTotalII(double total_ii){
        this.total_ii = total_ii;
    }
    public double getTotalIPI(){
        return this.total_ipi;
    }
    public void setTotalIPI(double total_ipi){
        this.total_ipi = total_ipi;
    }
    public double getTotalIPIDevolvido(){
        return this.total_ipi_devolvido;
    }
    public void setTotalIPIDevolvido(double total_ipi_devolvido){
        this.total_ipi_devolvido = total_ipi_devolvido;
    }
    public double getTotalPIS(){
        return this.total_pis;
    }
    public void setTotalPIS(double total_pis){
        this.total_pis = total_pis;
    }
    public double getTotalCOFINS(){
        return this.total_cofins;
    }
    public void setTotalCOFINS(double total_cofins){
        this.total_cofins = total_cofins;
    }
    public double getTotalOutros(){
        return this.total_outros;
    }
    public void setTotalOutros(double total_outros){
        this.total_outros = total_outros;
    }
    public double getTotalNota(){
        return this.total_nota;
    }
    public void setTotalNota(double total_nota){
        this.total_nota = total_nota;
    }
}
