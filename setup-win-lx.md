# Projeto Qmagico
Projeto referente ao processo seletivo da Qmagico

## Setup e preparação do ambiente
- Java
  - Ubuntu: 
        ```sudo add-apt-repository ppa:webupd8team/java 
           sudo apt-get update
           sudo apt-get install oracle-java9-installer```
  - Windows: http://www.oracle.com/technetwork/pt/java/javase/downloads/index.html
- Tomcat:
  - Ubuntu & Windows:http://tomcat.apache.org/ (Estou utilizando a versão 9 e baixem o arquivo zip e descompacte, para facilitar rs)
  
- Mysql:
  - Windows: https://dev.mysql.com/downloads/windows/installer/5.7.html
  - Ubuntu: ```sudo apt-get update
                sudo apt-get install mysql-server```
- Node:
     - Windows: https://nodejs.org/en/download/
     - Ubuntu: ```sudo apt-get update
              sudo apt-get install nodejs``` 
      - Lista do que utilizei/tentativa de utilizar no node
            -bootstrap;
            -jquery;
            -http-server (npm install http-server -g);
            -Material design(Versão normal e lite *falhei aqui e fui para o bootstrap 3 <3 );
- Eclipse:
  - Windows: http://www.eclipse.org/downloads/eclipse-packages/
  - Ubuntu: http://ubuntuhandbook.org/index.php/2016/01/how-to-install-the-latest-eclipse-in-ubuntu-16-04-15-10/ (mesmo arquivo do windows, mas com configurações adicionais, como adicionar o executável ao desktop)
  (recomendo baixar a versão Neon, pois já vem o plugin do maven e do git por default)
  
  Bem, com tudo instalado é hora de execu..... rodar script de criação de banco
    - Windows: Duplo clique no arquivo qmagico.sql (vai abrir o workbench)  e clique em executar (o icone de um raio, isso se você já instalou o mysql e agregados ~sussurros Link acima)
    - Ubuntu: mysql --host=localhost --user=seu_usuario --password=sua_senha  -e "qmagico.sql" (na pasta onde esta o arquivo)
    após executado e conferido,hora de execut.... abrir eclipse e configurar (O projeto precisa estar na pasta do workspace)
    tem duas opções git clone(terminal) e import project ou apenas importar no eclipse(vou escolher a segunda, mais simples)
    Para importar no eclipse no project explorer clique com o botao direito e selecione import e import novamente, 
    na tela seguinte selecione git>clone uri e insira as informações>next, 
    selecione a branch "master">next e selecione o local de salvamento>next, 
    na tela de projetos selecione "Import existing projects" e marque o projeto disponivel>next.
    A seguir vá em Window>show view> e selecione navigator (ele surgirá como uma aba ao lado de "project explorer")
    selecione ele procure pelo arquivo pom.xml> botão direito >run as> maven install, após concluir,
    procure o arquivo resources>applicationContext.xml e webapp>WEB-INF>applicationContext.xml e altere as informações de conexão de acordo com o banco de dados (usuario e senha)
    feito tudo isso hora de criar o servidor, abaixo selecione Servers e clique na mensagem exibida (ou botão direito> new) selecione a pasta de download do tomcat (aquela que eu falei que era para baixar, pois facilitava)
    após criado, volte ao navigator, abra a pasta  Servers e selecione Tomcatblablablab ou o nome dado>web.xml e cole as seguintes informações após a primeiro bloco de comentários
    ```<filter>
       <filter-name>CorsFilter</filter-name>
       <filter-class>org.apache.catalina.filters.CorsFilter</filter-class>
     </filter>
     <init-param>
	    <param-name>cors.allowed.origins</param-name>
	    <param-value>*</param-value>
	  </init-param>
	  <init-param>
	    <param-name>cors.allowed.methods</param-name>
	    <param-value>GET,POST,HEAD,OPTIONS,PUT</param-value>
	  </init-param>
	  <init-param>
	    <param-name>cors.allowed.headers</param-name>
	    <param-value>Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers</param-value>
	  </init-param>
	  <init-param>
	    <param-name>cors.exposed.headers</param-name>
	    <param-value>Access-Control-Allow-Origin,Access-Control-Allow-Credentials</param-value>
	  </init-param>
	  <init-param>
	    <param-name>cors.support.credentials</param-name>
	    <param-value>true</param-value>
	  </init-param>
     <filter-mapping>
       <filter-name>CorsFilter</filter-name>
       <url-pattern>/*</url-pattern>
     </filter-mapping>```
     
     
     
     
     
     (CORS, segurança para todos, desespero para mim)
     após isso botão direito no projeto > run as > run on server > selecione o servidor e clique em run...
     Caso haja algum erro de timeout apenas rode novamente, ele carrega os arquivos restantes...
     assim que terminado, vá ao seu explorador de arquivos, ache o projeto e abra a pasta pages no terminal, no terminal digite ```npm install e após isso, 
     http-server -p9000
     ele irá retornar endereco e a porta para acessar no navegador... e após todo esse trabalho, está rodando o projeto!(ou não ~medo)
     
    
    

