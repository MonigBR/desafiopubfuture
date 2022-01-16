## GESTÃO DE CONTROLE DE FINANÇAS PESSOAIS
Programa desenvolvido em linguagem Java para a gestão de controle de finanças pessoais. Desta forma, o programa é responsável pelo cadastro, edição, remoção e consulta de contas, bem como, as receitas e despesas existentes nas mesmas.

#### INSTALAÇÃO E EXECUÇÃO
Para execução do código, é necessário a instalação do [JDK 11.0.13](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html) e as dependências do projeto pelo [Maven](https://maven.apache.org/install.html) conforme descrito na sua documentação oficial.


Para a execução do programa 
- Descompacte o arquivo `desafiopubfuture-main.zip` localmente
- No Prompt de Comando aberto nesse diretório, execute o comando para executar a aplicação:
	```
	mvnw spring-boot:run
	```
	ou
	```
	mvn spring-boot:run
	```
- Com o serviço rodando, um arquivo de banco de dados `h2database.mv` será gerado. Para acessá-lo (http://localhost:8080/h2-console), utilize as informações:
	- Driver Class: org.h2.Driver
	- JDBC URL: jdbc:h2:file:./h2database
	- Username: desafio
	- Password: 1234
	
- Para realizar as chamadas das API no formato HTTP (GET, POST, PUT, DELETE), utilize alguma ferramenta auxiliar tal como [Postman](https://www.postman.com).

#### TECNOLOGIAS
As seguintes ferramentas foram usadas na construção do projeto:
- Java
- Maven
- [SpringBoot](https://spring.io/projects/spring-boot)
- [Hibernate](https://hibernate.org)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Git/GitHub](https://github.com)
- Banco de dados H2

#### DOCUMENTAÇÃO DO SISTEMA

_Abaixo são listadas as entidades que compõem o projeto_

##### Conta
	* id: identificador único (autogerado);
	* saldo: considerado como saldo inicial da conta no momento de seu cadastro (ou seja, valor fixo);
	* tipoConta: classificação da conta, podendo ser: Carteira, Conta Corrente ou Poupança;
	* instituicaoFinanceira: nome da instituição de vínculo da conta. 
	
##### Despesas
	* id: identificador único (autogerado);
	* valorDespesa: valor referente a despesa;
	* dataPagamento: data do pagamento;
	* dataPagamentoEsperado: data a qual é esperado o pagamento;
	* tipoDespesa: classificação da despesa, podendo ser: Alimentação, Educação, Lazer, Moradia, Roupa, Saúde, Transporte ou Outros;
	* conta: conta a qual a despesa está registrada, vinculada no banco de dados pelo ID. 
				
##### Receitas
	* id: identificador único (autogerado);
	* valorReceita: valor referente a receita;
	* descricao: pequena descrição da receita;
	* dataRecebimento: data do recebimento;
	* dataRecebimentoEsperado: data a qual é esperado o recebimento;
	* tipoReceita: classificação da receita, podendo ser: Salário, Presente, Prêmio ou Outros;
	* conta: conta a qual a receita está registrada, vinculada no banco de dados pelo ID. 	

#### _Chamadas da Rest API_

##### Entidade Conta
~~~
* POST - Cadastrar uma conta
	- Caminho: "/conta"
	- Body: objeto do tipo Conta (sem id)
	- Retorno: conta criada
	
 * GET - Procurar por uma conta cadastrada por id
	- Caminho: "/conta/{id}"
	- PathVariable: id do tipo Long
	- Retorno: conta criada
		
* GET - Procurar por todas conta cadastrada por id
	- Caminho: "/conta"
	- Retorno: lista de contas criadas
		
* DELETE - Deletar uma conta
	- Caminho: "/conta/{id}"
	- PathVariable: id no tipo Long
		
* PUT - Atualizar as informações de uma conta
	- Caminho: "/conta/{id}"
	- PathVariable: id do tipo Long
	- Body: objeto do tipo Conta (sem id)
	- Retorno: conta atualizada	
		
* GET - Buscar total de uma conta
	- Caminho: "/conta/buscarTotalSaldoDeUmaConta"
	- Param: ("id_conta") id da conta do tipo Long 
	- Retorno: total da conta
~~~
		
##### Entidade Receitas
~~~
* POST - Cadastrar uma receita
	- Caminho: "/conta/{id}/receitas"
	- PathVariable: id da conta do tipo Long
	- Body: objeto do tipo Receita (sem id)
	- Retorno: receita criada
		
* GET - Procurar por uma receita cadastrada por id
	- Caminho: "/receitas/{id}"
	- PathVariable: id do tipo Long
	- Retorno: receita criada
		
* GET - Procurar por todas receitas cadastrada por id
	- Caminho: "/receitas"
	- Retorno: lista de receitas criadas
		
* DELETE - Deletar uma receita
	- Caminho: "/receita/{id}"
	- PathVariable: id do tipo Long
		
* PUT - Atualizar as informações de uma receita
	- Caminho: "/receita/{id}"
	- PathVariable: id do tipo Long
	- Body: objeto do tipo Receitas (sem id)
	- Retorno: receitas atualizadas	

* GET - Buscar receitas pelo Tipo de Receita
	- Caminho: "/receitas/buscarPorTipoReceita"
	- Param: ("tipoReceita") filtro de busca no tipo TipoReceita 
	- Retorno: lista o total da receitas pelo tipo dela

* GET - Buscar pelas datas de recebimento das receitas de uma conta
	- Caminho: "/receitas/buscarDataRecebimentoPorPeriodo"
	- Param: ("dataInicial") filtro de busca no formato da data "dd-MM-yyyy"
	- Param: ("dataFinal") filtro de busca no formato da data "dd-MM-yyyy" 
	- Retorno: lista de recebimento de receitas dentro do período informado
		
* GET - Buscar pelas datas de recebimento esperado das receitas de uma conta
	- Caminho: "/receitas/buscarDataRecebimentoEsperadoPorPeriodo"
	- Param: ("dataInicial") filtro de busca no formato da data "dd-MM-yyyy"
	- Param: ("dataFinal") filtro de busca no formato da data "dd-MM-yyyy"
	- Retorno: lista de recebimento de receitas esperadas dentro do período informado
					
* GET - Buscar total de receitas de uma conta
	- Caminho: "/receitas/buscarTotalReceitasDeUmaConta"
	- Param: ("id_conta") id da conta no tipo Long 
	- Retorno: total das receitas de uma conta
~~~
	
#####  Entidade Despesas
~~~
* POST - Cadastrar uma despesa
	- Caminho: "/conta/{id}/despesas"
	- PathVariable: id da conta do tipo Long
	- Body: objeto do tipo Despesa (sem id)
	- Retorno: despesa criada
		
* GET - Procurar por uma despesa cadastrada por id
	- Caminho: "/despesas/{id}"
	- PathVariable: id do tipo Long
	- Retorno: despesa criada
		
* GET - Procurar por todas despesas cadastrada por id
	- Caminho: "/despesas"
	- Retorno: lista de despesas criadas
		
* DELETE - Deletar uma despesa
	- Caminho: "/despesas/{id}"
	- PathVariable: id do tipo Long
		
* PUT - Atualizar as informações de uma despesa
	- Caminho: "/despesas/{id}"
	- PathVariable: id do tipo Long
	- Body: objeto do tipo Despesas (sem id)
	- Retorno: despesas atualizadas	

* GET - Buscar despesas pelo Tipo de Despesa
	- Caminho: "/despesas/buscarPorTipoDespesa"
	- Param: ("tipoDespesa") filtro de busca no tipo TipoDespesa 
	- Retorno: lista o total da despesas pelo tipo dela

* GET - Buscar pelas datas de pagamento das despesas de uma conta
	- Caminho: "/despesas/buscarDataPagamentoPorPeriodo"
	- Param: ("dataInicial") filtro de busca no formato da data "dd-MM-yyyy"
	- Param: ("dataFinal") filtro de busca no formato da data "dd-MM-yyyy" 
	- Retorno: lista de despesas dentro do período informado
		
* GET - Buscar pelas datas de pagamento esperado das despesas de uma conta
	- Caminho: "/despesas/buscarDataPagamentoEsperadoPorPeriodo"
	- Param: ("dataInicial") filtro de busca no formato da data "dd-MM-yyyy"
	- Param: ("dataFinal") filtro de busca no formato da data "dd-MM-yyyy"
	- Retorno: lista de despesas dentro do período informado
				
* GET - Buscar total de despesas de uma conta
	- Caminho: "/despesas/buscarTotalDespesasDeUmaConta"
	- Param: ("id_conta") id da conta no tipo Long 
	- Retorno: total das despesas de uma conta
~~~
		
#### **OUTRAS** **INFORMAÇÕES**		
As tratativas de erros não foram implementadas;

Uma API de Transferência de Saldo entre contas não foi implementada;

Os testes unitários não foram realizados, pois ainda não possuo conhecimentos a respeito.
	
##### **SOBRE** **O** **DESAFIO**
O projeto foi desenvolvido com base em video-aulas e curso em plataforma de Ensino Online realizados/assistidos desde o início do processo seletivo.
Como a estrutura de projeto baseado em REST API era desejável, os materiais de estudo utilizados foram focados principalmente nesse tópico. 
Apesar do uso de frameworks avançados, tais como SpringBoot, destaco aqui meu início nos estudos da linguagem Java e, como consequência, observa-se minhas limitações ainda existentes refletidas no projeto, conforme mencionadas no tópico anterior.
