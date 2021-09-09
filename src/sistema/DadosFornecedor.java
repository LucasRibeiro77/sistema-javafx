package sistema;

public class DadosFornecedor{
    int id;
    String razaoSocial;
    String nomeFantasia;
    String Contribuinte;
    String CNPJ;
    String IE;
    String Logradouro;
    String NrEndereco;
    String Bairro;
    String Municipio;
    String UF;
    String CEP;
    String Tel;
    String Tel2;
    String Tel3;
    String Email;
    String Pais;
    String IM;
    
    public void DadosFornecedor(){
                this.id = 0;
                this.razaoSocial = "";
                this.nomeFantasia = "";
                this.Contribuinte = "";
                this.CNPJ = "";
                this.IE = "";
                this.Logradouro = "";
                this.NrEndereco = "";
                this.Bairro = "";
		this.Municipio = "";
		this.UF = "";
		this.CEP = "";
		this.Tel = "";
		this.Tel2 = "";
		this.Tel3 = "";
		this.Email = "";
		this.Pais = "";
		this.IM = "";
    }
    
    public DadosFornecedor(int id, String razaoSocial, String nomeFantasia, String Contribuinte, String CNPJ, String IE, String Logradouro, String NrEndereco, String Bairro, String Municipio, String UF, String CEP, String Tel, String Tel2, String Tel3, String Email, String Pais, String IM) {
                this.id = id;
                this.razaoSocial = razaoSocial;
                this.nomeFantasia = nomeFantasia;
                this.Contribuinte = Contribuinte;
                this.CNPJ = CNPJ;
                this.IE = IE;
                this.Logradouro = Logradouro;
                this.NrEndereco = NrEndereco;
                this.Bairro = Bairro;
		this.Municipio = Municipio;
		this.UF = UF;
		this.CEP = CEP;
		this.Tel = Tel;
		this.Tel2 = Tel2;
		this.Tel3 = Tel3;
		this.Email = Email;
		this.Pais = Pais;
		this.IM = IM;
        }
    public int getID(){
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
    public String getContribuinte(){
        return this.Contribuinte;
    }
    public void setContribuinte(String Contribuinte){
        this.Contribuinte = Contribuinte;
    }
    public String getCNPJ(){
        return this.CNPJ;
    }
    public void setCNPJ(String CNPJ){
        this.CNPJ = CNPJ;
    }
    public String getIE(){
        return this.IE;
    }
    public void setIE(String IE){
        this.IE = IE;
    }
    public String getLogradouro(){
        return this.Logradouro;
    }
    public void setLogradouro(String Logradouro){
        this.Logradouro = Logradouro;
    }
    public String getNrEndereco(){
        return this.NrEndereco;
    }
    public void setNrEndereco(String NrEndereco){
        this.NrEndereco = NrEndereco;
    }
    public String getBairro(){
        return this.Bairro;
    }
    public void setBairro(String Bairro){
        this.Bairro = Bairro;
    }
    public String getMunicipio(){
        return this.Municipio;
    }
    public void setMunicipio(String Municipio){
        this.Municipio = Municipio;
    }
    public String getUF(){
        return this.UF;
    }
    public void setUF(String UF){
        this.UF = UF;
    }
    public String getCEP(){
        return this.CEP;
    }
    public void setCEP(String CEP){
        this.CEP = CEP;
    }
    public String getTel(){
        return this.Tel;
    }
    public void setTel(String Tel){
        this.Tel = Tel;
    }

    public String getTel2(){
        return this.Tel2;
    }
    public void setTel2(String Tel2){
        this.Tel2 = Tel2;
    }

    public String getTel3(){
        return this.Tel3;
    }
    public void setTel3(String Tel3){
        this.Tel3 = Tel3;
    }

    public String getEmail(){
        return this.Email;
    }
    public void setEmail(String Email){
        this.Email = Email;
    }
    public String getPais(){
        return this.Pais;
    }
    public void setPais(String Pais){
        this.Pais = Pais;
    }
    public String getIM(){
        return this.IM;
    }
    public void setIM(String IM){
        this.IM = IM;
    }
}
