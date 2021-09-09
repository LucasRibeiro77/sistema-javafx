package sistema;


public class protocolo{

	public String protocolo;
        
        @Override
        public String toString(){
            return String.valueOf(protocolo);
        }

	public protocolo(){
		this.protocolo = "";
	}
	public protocolo(String protocolo){
		this.protocolo = protocolo;
	}
	public String getProtocolo(){
		return this.protocolo;
	}
	public void setProtocolo(String protocolo){
		this.protocolo = protocolo;
	}
}
