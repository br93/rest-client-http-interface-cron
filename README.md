

<h2 align="center">RestClient, HTTP interfaces and CRON</h2>

<div align="center">



</div>

---

<p align="center"> Projeto para praticar os conceitos de RestClient, HTTP Interfaces and CRON
    <br> 
</p>



## 🧐 Sobre <a name = "sobre"></a>

Projeto que utiliza RestClient do Spring Framework 6.1 em conjunto com HTTP Interfaces. Dois serviços implementados: [articles](https://github.com/br93/rest-client-http-interface-cron/tree/main/articles-service) e [blog](https://github.com/br93/rest-client-http-interface-cron/tree/main/blog-service). Articles é um CRUD simples, onde se pode criar, remover, atualizar e deletar artigos. Para popular a lista de artigos, uma consulta à API [Loripsum](https://loripsum.net/api/) é feita a cada 10 segundos com uso de @Scheduled. O serviço de Blog irá então consultar API de artigos por meio de RestClient e o uso de HTTP Interface.

## 🧐 About <a name = "about"></a>

Project using Spring Framework 6.1's RestClient and HTTP Interfaces. Two services were implemented: [articles](https://github.com/br93/rest-client-http-interface-cron/tree/main/articles-service) e [blog](https://github.com/br93/rest-client-http-interface-cron/tree/main/blog-service). Articles is a simple CRUD, where you can create, remove, update and delete articles. To populate the list of articles, a request to [Loripsum](https://loripsum.net/api/) API is made every 10 seconds using @Scheduled annotation. The Blog service will make requests to the article API usign RestClient and HTTP Interface.


