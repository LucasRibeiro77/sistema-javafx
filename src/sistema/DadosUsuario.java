package sistema;

public class DadosUsuario{
        private int id;
	private String usuario;
	private String cargo;
        private String pass;
        private String permCadastro;
        private String permCadastroProduto;
        private String permCadastroFornecedor;
        private String permCadastroFabricante;
        private String permCadastroCategoria;
        private String permCadastroUnidadeMedida;
        private String permCadastroEstabelecimento;
        private String permCadastroUsuario;
        private String permEstoque;
        private String permCarga;
        private String permManutencao;
        private String permFinanceiro;
        private String permContasPagar;
        private String permContasReceber;
        private String permInvoices;
        private String permFluxoCaixa;
        private String permEnvioArquivo;
        private String permRelatorios;
        private String permVendaBalcao;
	
	public DadosUsuario(){
                this.id = 0;
		this.usuario = "";
		this.cargo = "";
                this.pass = "";
                this.permCadastro = "";
                this.permCadastroProduto = "";
                this.permCadastroFornecedor = "";
                this.permCadastroFabricante = "";
                this.permCadastroCategoria = "";
                this.permCadastroUnidadeMedida = "";
                this.permCadastroEstabelecimento = "";
                this.permCadastroUsuario = "";
                this.permEstoque = "";
                this.permCarga = "";
                this.permManutencao = "";
                this.permFinanceiro = "";
                this.permContasPagar = "";
                this.permContasReceber = "";
                this.permInvoices = "";
                this.permFluxoCaixa = "";
                this.permEnvioArquivo = "";
                
	}
	public DadosUsuario(int id, String usuario, String cargo, String pass, String permCadastro, String permCadastroProduto, String permCadastroFornecedor, String permCadastroFabricante, String permCadastroCategoria, String permCadastroUnidadeMedida, String permCadastroEstabelecimento, String permCadastroUsuario, String permEstoque, String permCarga, String permManutencao, String permFinanceiro, String permContasPagar, String permContasReceber, String permInvoices, String permFluxoCaixa, String EnvioArquivo, String permRelatorios, String permVendaBalcao){
                this.id = id;
		this.usuario = usuario;
		this.cargo = cargo;
                this.pass = pass;
                this.permCadastro = permCadastro;
                this.permCadastroProduto = permCadastroProduto;
                this.permCadastroFornecedor = permCadastroFornecedor;
                this.permCadastroFabricante = permCadastroFabricante;
                this.permCadastroCategoria = permCadastroCategoria;
                this.permCadastroUnidadeMedida = permCadastroUnidadeMedida;
                this.permCadastroEstabelecimento = permCadastroEstabelecimento;
                this.permCadastroUsuario = permCadastroUsuario;
                this.permEstoque = permEstoque;
                this.permCarga = permCarga;
                this.permManutencao = permManutencao;
                this.permFinanceiro = permFinanceiro;
                this.permContasPagar = permContasPagar;
                this.permContasReceber = permContasReceber;
                this.permInvoices = permInvoices;
                this.permFluxoCaixa = permFluxoCaixa;
                this.permEnvioArquivo = permEnvioArquivo;
                this.permRelatorios = permRelatorios;
                this.permVendaBalcao = permVendaBalcao;
	}
        public int getID(){
            return this.id;
        }
        public void setID(int id){
            this.id = id;
        }
	public String getUsuario(){
		return this.usuario;
	}
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	public String getCargo(){
		return this.cargo;
	}
	public void setCargo(String cargo){
		this.cargo = cargo;
	}
        public String getPass(){
            return this.pass;
        }
        public void setPass(String pass){
            this.pass = pass;
        }
        public String getPermCadastro(){
            return this.permCadastro;
        }
        public void setPermCadastro(String permCadastro){
            this.permCadastro = permCadastro;
        }
        public String getPermCadastroProduto(){
            return this.permCadastroProduto;
        }
        public void setPermCadastroProduto(String permCadastroProduto){
            this.permCadastroProduto = permCadastroProduto;
        }
        public String getPermCadastroFornecedor(){
            return this.permCadastroFornecedor;
        }
        public void setPermCadastroFornecedor(String permCadastroFornecedor){
            this.permCadastroFornecedor = permCadastroFornecedor;
        } 
       public String getPermCadastroFabricante(){
            return this.permCadastroFabricante;
        }
        public void setPermCadastroFabricante(String permCadastroFabricante){
            this.permCadastroFabricante = permCadastroFabricante;
        }        
       public String getPermCadastroCategoria(){
            return this.permCadastroCategoria;
        }
        public void setPermCadastroCategoria(String permCadastroCategoria){
            this.permCadastroCategoria = permCadastroCategoria;
        }        
       public String getPermCadastroUnidadeMedida(){
            return this.permCadastroUnidadeMedida;
        }
        public void setPermCadastroUnidadeMedida(String permCadastroUnidadeMedida){
            this.permCadastroUnidadeMedida = permCadastroUnidadeMedida;
        }        
       public String getPermCadastroEstabelecimento(){
            return this.permCadastroEstabelecimento;
        }
        public void setPermCadastroEstabelecimento(String permCadastroEstabelecimento){
            this.permCadastroEstabelecimento = permCadastroEstabelecimento;
        }
       public String getPermCadastroUsuario(){
            return this.permCadastroUsuario;
        }
        public void setPermCadastroUsuario(String permCadastroUsuario){
            this.permCadastroUsuario = permCadastroUsuario;
        }        
        public String getPermEstoque(){
            return this.permEstoque;
        }
        public void setPermEstoque(String permEstoque){
            this.permEstoque = permEstoque;
        }        
        public String getPermCarga(){
            return this.permCarga;
        }
        public void setPermCarga(String permCarga){
            this.permCarga = permCarga;
        }        
        public String getPermManutencao(){
            return this.permManutencao;
        }
        public void setPermManutencao(String permManutencao){
            this.permManutencao = permManutencao;
        }                
        public String getPermFinanceiro(){
            return this.permFinanceiro;
        }
        public void setPermFinanceiro(String permFinanceiro){
            this.permFinanceiro = permFinanceiro;
        }        
        public String getPermContasPagar(){
            return this.permContasPagar;
        }
        public void setPermContasPagar(String permContasPagar){
            this.permContasPagar = permContasPagar;
        }        
        public String getPermContasReceber(){
            return this.permContasReceber;
        }
        public void setPermContasReceber(String permContasReceber){
            this.permContasReceber = permContasReceber;
        }        
        public String getPermInvoices(){
            return this.permInvoices;
        }
        public void setPermInvoices(String permInvoices){
            this.permInvoices = permInvoices;
        }        
        public String getPermFluxoCaixa(){
            return this.permFluxoCaixa;
        }
        public void setPermFluxoCaixa(String permFluxoCaixa){
            this.permFluxoCaixa = permFluxoCaixa;
        }
        public String getPermEnvioArquivo(){
            return this.permEnvioArquivo;
        }
        public void setPermEnvioArquivo(String permEnvioArquivo){
            this.permEnvioArquivo = permEnvioArquivo;
        }
        public String getPermRelatorios(){
            return this.permRelatorios;
        }
        public void setPermRelatorios(String permRelatorios){
            this.permRelatorios = permRelatorios;
        }
        public String getPermVendaBalcao(){
            return this.permVendaBalcao;
        }
        public void setPermVendaBalcao(String permVendaBalcao){
            this.permVendaBalcao = permVendaBalcao;
        }                
}