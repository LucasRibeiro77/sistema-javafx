<html>
	<head>
		<link rel="stylesheet" type="text/css" href="ESTILO.css">
	</head>
<body>
	<label>Sistema JavaFX</label>
		<div></div>
			<p><br><label id="label-2">&nbsp Projeto de sistema desenvolvido em javafx com mysql voltado para pequenos comercios como mercados, padarias, farmácias, auto-peças ente outros comércios de varejo. O objetivo deste projeto é facilitar o lado de quem trabalha com o comércio varejista, sendo um sistema multi-plataformas.</label><br><br><br><br><br>
			<br><label id="label-3">Executando o projeto</label>
		<div></div>
			<p><br>
			<label id="label-2">&nbsp Para executar o projeto é necessário realizar os seguintes procedimentos:</label><br>
			 &nbsp <li><a href="#clonar-repositorio"><label id="label-4">Clonar o repositório do GitHub na máquina</label></a></li>
			 &nbsp <li><a href="#mariadb"><label id="label-4">Instalação e configuração do MariaDB</label></a></li>
			 &nbsp <li><a href="#netbeans"><label id="label-4">Instalação da IDE NetBeans + JDK</label></a></li>
			 &nbsp <li><a href="#habilitar-javafx"><label id="label-4">Habilitar o JavaFX na IDE</label></a></li> 
			 &nbsp <li><a href="#executar-projeto"><label id="label-4">Abrir o repositório na IDE e executar o projeto</label></a></li><br><br><br><br><br>
			<p><br><label id="label-3">Clonar o repositório do GitHub na máquina</label>
		<div id="clonar-repositorio"></div><br><br>
			<label id="label-4">1 - Acesse o prompt de comando: iniciar > digite "cmd" na caixa de pesquisa do menu iniciar > Prompt de comando</label><br><br>
			<label id="label-4">2 - Com o prompt  aberto, acesse a pasta no qual deseja clonar o repositorio github através do comando "cd"</label><br><br>
			<label id="label-4">3 - Digite o comando "git clone https://github.com/LucasRibeiro77/sistema-javafx.git"</label><br><br>
			<p><br><label id="label-3">Instalação e configuração do MariaDB</label>
		<div id="mariadb"></div><br><br>
			<label id="label-4">1 - Faça o download do MariaDB 10.3.31 pelo link: <a href="https://downloads.mariadb.org/interstitial/mariadb-10.3.31/winx64-packages/mariadb-10.3.31-winx64.msi/from/https%3A//mirror.ihost.md/mariadb/">https://downloads.mariadb.org/interstitial/mariadb-10.3.31/winx64-packages/mariadb-10.3.31-winx64.msi/from/https%3A//mirror.ihost.md/mariadb/ </a></label><br><br>
			<label id="label-4">2 - execute o instalador do MariaDB 10.3.31</label><br><br>
			<label id="label-4">3 - Concorde com os termos e avance as etapas</label><br><br>
			<label id="label-4">4 - Deixe com fleg na primeira caixa de seleção e deixe sem senha e avance para a próxima etapa</label><br><br>
			<label id="label-4">5 - Defina um nome para o serviço MySQL (pode utilizar o nome padrão), deixe com a porta 3306(porta padrão) e mantém os flegs selecionados</label><br><br>
			<label id="label-4">6 - Avance a finalize a instalação clicando no botão "Instalar" </label><br><br>
			<label id="label-4">7 - Após concluir a instalação, abra o HeidiSQL</label><br><br>
			<label id="label-4">8 - Clique no botão "nova"</label><br><br>
			<label id="label-4">9 - Mantenha as propriedades alterando o campo usuário inserindo o usuário root e o campo Banco de Dados inserindo o nome "sistema" e clique em "Abrir"</label><br><br>
			<label id="label-4">10 - Salve as modificações e siga para a próxima etapa </label><br><br>
			<label id="label-4">11 - Na próxima tela, clique na guia "Consulta" </label><br><br>
			<label id="label-4">12 - Acesse o repositório clonado </label><br><br>
			<label id="label-4">13 - Abra o arquivo QUERY_BD_SISTEMA.txt e copie todo o conteúdo do arquivo </label><br><br>
			<label id="label-4">14 - Por fim, acesseo HeidiSQL novamente e na guia "Consulta" cole o conteúdo copiado e execute clicando no botão "Executar SQL" localizado na barra superior acima da guia "Consulta" ou precionando F9 do teclado e o banco de dados já estará pronto para uso </label><br><br>
			<p><br><label id="label-3">Instalação da IDE NetBeans + JDK</label>
		<div id="netbeans"></div><br><br>
			<label id="label-4">1 - Faça o download da IDE Netbeans no endereço: <a href="https://dlcdn.apache.org/netbeans/netbeans/12.4/Apache-NetBeans-12.4-bin-windows-x64.exe">https://dlcdn.apache.org/netbeans/netbeans/12.4/Apache-NetBeans-12.4-bin-windows-x64.exe</a></label><br><br>
			<label id="label-4">2 - Execute o instalador, avence as etapas e instale a IDE para executar o projeto</label><br><br>
			<p><br><label id="label-3">Habilitar o JavaFX na IDE</label>
		<div id="habilitar-javafx"></div><br><br>
			<label id="label-4">1 - Abra a IDE Netbeans</label><br><br>
			<label id="label-4">2 - Acesse o menu: Ferramentas > Opções</label><br><br>
			<label id="label-4">3 - Na caixa que abrir acesse: Java > JavaFX</label><br><br>
			<label id="label-4">4 - Clique na caixa para habilitar o JavaFX na IDE</label><br><br>
			<p><br><label id="label-3">Abrir o repositório na IDE e executar o projeto</label>
		<div id="executar-projeto"></div><br><br>
			<label id="label-4">1 - Abra a IDE netbeans</label><br><br>
			<label id="label-4">2 - Acesse: Arquivo > Abrir projeto</label><br><br>
			<label id="label-4">3 - Na caixa exibida, acesse a pasta do repositorio e clique em "Abrir projeto"</label><br><br>
			<label id="label-4">4 - Por fim, clique em "Executar projeto"(botão de seta localizado na barra superior proximo ao menu Equipe) ou aperte a tecla F6 do teclado para executar o projeto</label><br><br>

</body>
</html>