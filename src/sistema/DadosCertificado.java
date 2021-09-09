package sistema;

public class DadosCertificado {
    
    String certificado;
    
    @Override
    public String toString(){
        return String.valueOf(certificado);
    }
    
    public DadosCertificado(){
        this.certificado = "";
    }
    public DadosCertificado(String certificado){
        this.certificado = certificado;
    }
    public String getCertificado(){
        return this.certificado;
    }
    public void setCertificado(String certificado){
        this.certificado = certificado;
    }
}
