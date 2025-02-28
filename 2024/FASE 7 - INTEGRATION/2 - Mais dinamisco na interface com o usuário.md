# MAIS DINAMISMO NA INTERFACE COM O USUÁRIO

## SERVLETS

São classes Java que realizam o direcionamento de requisição HTTP feitas por clientes, como os navegadores, eles são responsáveis por receber os dados para serem processados e devolver uma resposta a esses clientes. 

Essas classes são instaladas em um Servlet Container ou Web Container (Servidor), o que permite á *servlet* tratar as requisições.

![Requisição e Resposta](https://raw.githubusercontent.com/euhenriquegheno/ADS-Fiap/642c7f0e2c2c287d522fbb5fd5735d06da280d01/FASE%207%20-%20INTEGRATION/img/on-image-sistema-realizando-request-response.svg)

Uma *servlet* tem a função de recuperar as informações enviadas pelo usuário (por meio de uma requisição) e passar essas informações para outros componentes da aplicação para que sejam processadas. 
Depois, esses componentes devem retornar algum valor para que a *servlet* possa enviar uma resposta para o usuário.

## REQUISIÇÃO A UMA *SERVLET*

![Requisição a uma servlet](https://raw.githubusercontent.com/euhenriquegheno/ADS-Fiap/dfa3fd0dedf8decf493f6d77ae252bbdb2113185/FASE%207%20-%20INTEGRATION/img/on-image-exemplo-requisicao-servlet.svg)

- Cada requisição a uma *servlet* é executada em um *thread*
- O objeto *servlet* é único na aplicação.


## CLICO DE VIDA DE UMA *SERVLET*

- As *servelts* são instanciadas pelo *container*, na primeira vez que são acessadas.
- Após iniciadas, as *servlets* podem atender a requisições.
- O *container* decide a hora de destruir as *servlets* (chama o método `destroy();`).

![](https://raw.githubusercontent.com/euhenriquegheno/ADS-Fiap/f2ddeac32f9a9bccf62367e77a9b16d77844501a/FASE%207%20-%20INTEGRATION/img/on-image-ciclo-vida-servlet.svg)


