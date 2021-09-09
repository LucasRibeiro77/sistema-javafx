package sistema;

public class DadosNPDV {

    int count;
    
    @Override
    public String toString(){
        return String.valueOf(count);
    }
    public DadosNPDV() {
        this.count = 0;
    }
    
    public DadosNPDV(int count) {
        this.count = count;
    }
    public int getCount(){
        return this.count;
    }
    public void setCount(int count){
        this.count = count;
    }
}
