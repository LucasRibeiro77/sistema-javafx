package sistema;

public class DadosBarras {
    
    public String barras;

    @Override
    public String toString(){
        return String.valueOf(barras);
    }
    
    public DadosBarras(){

        this.barras = "";

    }
    
    public DadosBarras(String barras){
    
        this.barras = barras;
    
    }
    public String getBarras(){
        return this.barras;
    }
    public void setBarras(String barras){
        this.barras = barras;
    }
}
