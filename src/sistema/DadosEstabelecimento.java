package sistema;

public class DadosEstabelecimento {
    
    int id;
    String razaoSocial;
    String nomeFantasia;
    String cnpj;
    String IE;
    String IM;
    String IEST;
    String CNAE;
    String regime;
    String telefone;
    String logradouro;
    String nr;
    String cidade;
    String estado;
    String pais;
    String cep;
    String bairro;
    String estab;
    String cpf;
    String transportador;
    String placa;
    String UFTransportador;
    String ANTT;
    
    public DadosEstabelecimento(){
            this.id = 0;
            this.razaoSocial = "";
            this.nomeFantasia = "";
            this.cnpj = "";
            this.IE = "";
            this.IM = "";
            this.IEST = "";
            this.CNAE = "";
            this.regime = "";
            this.telefone = "";
            this.logradouro = "";
            this.nr = "";
            this.cidade = "";
            this.estado = "";
            this.pais = "";
            this.cep = "";
            this.bairro = "";
            this.estab = "";
            this.cpf = "";
            this.transportador = "";
            this.placa = "";
            this.UFTransportador = "";
            this.ANTT = "";
    }
    public DadosEstabelecimento(int id, String razaoSocial, String nomeFantasia, String cnpj, String IE, String IM, String IEST, String CNAE, String regime, String telefone, String logradouro, String nr, String cidade, String estado, String pais, String cep, String bairro, String estab, String cpf, String transportador, String placa, String UFTransportador, String ANTT){
            this.id = id;
            this.razaoSocial = razaoSocial;
            this.nomeFantasia = nomeFantasia;
            this.cnpj = cnpj;
            this.IE = IE;
            this.IM = IM;
            this.IEST = IEST;
            this.CNAE = CNAE;
            this.regime = regime;
            this.telefone = telefone;
            this.logradouro = logradouro;
            this.nr = nr;
            this.cidade = cidade;
            this.estado = estado;
            this.pais = pais;
            this.cep = cep;
            this.bairro = bairro;
            this.estab = estab;
            this.cpf = cpf;
            this.transportador = transportador;
            this.placa = placa;
            this.UFTransportador = UFTransportador;
            this.ANTT = ANTT;
    }
    public int getId(){
        return this.id;
    } 
    public void setID(int id){
        this.id = id;
    }
    public String getRazaoSocial(){
        return this.razaoSocial;
    }
    public void setRazaoSocial(String razaoSocial){
        this.razaoSocial = razaoSocial;
    }
    public String getNomeFantasia(){
        return this.nomeFantasia;
    }
    public void setNomeFantasia(String nomeFantasia){
        this.nomeFantasia = nomeFantasia;
    }
    public String getCNPJ(){
        return this.cnpj;
    }
    public void setCNPJ(String cnpj){
        this.cnpj = cnpj;
    }
    public String getIE(){
        return this.IE;
    }
    public void setIE(String IE){
        this.IE = IE;
    }
    public String getIM(){
        return this.IM;
    }
    public void setIM(String IM){
        this.IM = IM;
    }
    public String getIEST(){
        return this.IEST;
    }
    public void setIEST(String IEST){
        this.IEST = IEST;
    }
    public String getCNAE(){
        return this.CNAE;
    }
    public void setCNAE(String CNAE){
        this.CNAE = CNAE;
    }
    public String getRegime(){
        return this.regime;
    }
    public void setRegime(String regime){
        this.regime = regime;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }
    public String getLogradouro(){
        return this.logradouro;
    }
    public void setLogradouro(String logradouro){
        this.logradouro = logradouro;
    }
    public String getNr(){
        return this.nr;
    }
    public void setNr(String nr){
        this.nr = nr;
    }
    public String getCidade(){
        return this.cidade;
    }
    public void setCidade(String cidade){
        this.cidade = cidade;
    }
    public String getEstado(){
        return this.estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
    public String getPais(){
        return this.pais;
    }
    public void setPais(String pais){
        this.pais = pais;
    }
    public String getCEP(){
        return this.cep;
    }
    public void setCEP(String cep){
        this.cep = cep;
    }
    public String getBairro(){
        return this.bairro;
    }
    public void setBairro(String bairro){
        this.bairro = bairro;
    }
    public String getEstab(){
        return this.estab;
    }
    public void setEstab(String estab){
        this.estab = estab;
    }
    public String getCPF(){
        return this.cpf;
    }
    public void setCPF(String cpf){
        this.cpf = cpf;
    }
    public String getTransportador(){
        return this.transportador;
    }
    public void setTransportador(String transportador){
        this.transportador = transportador;
    }
    public String getPlaca(){
        return this.placa;
    }
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public String getUFTransportador(){
        return this.UFTransportador;
    }
    public void setUFTransportador(String UFTransportador){
        this.UFTransportador = UFTransportador;
    }
    public String getANTT(){
        return this.ANTT;
    }
    public void setANTT(String ANTT){
        this.ANTT = ANTT;
    }
}
