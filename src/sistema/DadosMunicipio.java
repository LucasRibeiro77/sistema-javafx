package sistema;

public class DadosMunicipio{
    //int id;
    public String municipio;
    
    /*@Override
    public String toString(){
        return String.valueOf(municipio);
    }*/
    
    public DadosMunicipio(){
        //this.id = 0;
        this.municipio = "";
    }
    //public DadosCidade(int id, String nome){
    public DadosMunicipio(String municipio){
        //this.id = id;
        this.municipio = municipio;
    }/*
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        this.id = id;
    }*/
    public String getMunicipio(){
        return this.municipio;
    }
    public void setMunicipio(String municipio){
        this.municipio = municipio;
    }
}
