package sistema;

public class Conteudo{

	private String tipo;
	private String descricao;
	private double valor;

	public Conteudo(){
		this.tipo = "";
		this.descricao = "";
		this.valor = 0.00;
	}

	public Conteudo(String tipo, String descricao, double valor){
		this.tipo = tipo;
		this.descricao = descricao;
		this.valor = valor;		
	}
	public String getTipo(){
		return this.tipo; 
	}
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	public String getDescricao(){
		return this.descricao;
	}
	public void setDescricao(String descricao){
		this.descricao = descricao;
	}
	public double getValor(){
		return this.valor;
	}
	public void setValor(double valor){
		this.valor = valor;
	}
}
