package sistema;

public class DadosProtocolo {
    private int id;
    
    @Override
    public String toString(){
        return String.valueOf(id);
    }
    public DadosProtocolo(){
        this.id = 0;
    }
    public DadosProtocolo(int id){
        this.id = id;
    }
    public int getID(){
        return this.id;
    }
    public void setID(int id){
        this.id = id;
    }
}
