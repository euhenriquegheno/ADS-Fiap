using System.Diagnostics;
using Fiap.Web.Alunos.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Alunos.Controllers
{
    /* Classe HomeController: A classe Microsoft.AspNetCore.Mvc.Controller é uma classe que lida com as requisições HTTP.
     * A herança em HomeController atribui funcionalidades para tratar requisições e retornar respostas, como views a nossa classe HomeController. */
    public class HomeController : Controller
    {
        /* ILogger<HomeController>: O logging é essencial para monitorar e diagnosticar comportamentos da aplicação. 
         * ILogger permite registrar logs de diferentes níveis de severidade (informação, erro etc.). */
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        /* Os métodos Index e Privacy representam ações que podem ser executadas pelo controlador. Cada método corresponde a uma rota ou caminho no navegador acessível por uma URL. 
         * Nesse caso, os métodos têm como retorno uma interface IActionResult, comumente utilizada para apresentar um componente do tipo View, o qual é renderizado ao usuário final em HTML. */

        /* Index(): Geralmente serve como a página inicial da aplicação. */
        public IActionResult Index()
        {
            return View();
        }

        /* Privacy(): Apenas uma exemplo montado pelo scaffold para exibir uma página de política de privacidade. */
        public IActionResult Privacy()
        {
            return View();
        }

        /* 
         * As ações dos controladores do ASP.NET Core MVC (Microsoft.AspNetCore.Mvc.Controller) possuem outros tipos de retorno além da interface IActionResult. 
         * Abaixo, segue a lista com suas respectivas funcionalidades:
         * IActionResult: Retorna uma resposta HTTP para o cliente. Pode ser usado para retornar uma View, um JSON, um arquivo, entre outros tipos de respostas.
         * ViewResult: Retorna uma View ao cliente, representando uma página HTML a ser exibida no navegador.
         * JsonResult: Retorna um objeto serializado em formato JSON ao cliente, comumente utilizado para requisições AJAX.
         * RedirectResult: Redireciona o cliente para outra URL especificada.
         * FileResult: Retorna um arquivo ao cliente para download.
         * ContentResult: Retorna um conteúdo específico ao cliente, geralmente usado para retornar texto ou XML.
         * PartialViewResult: Retorna uma parte de uma View ao cliente, útil para carregamento assíncrono de componentes.
         * StatusCodeResult: Retorna um código de status HTTP específico ao cliente, sem corpo de resposta.
         * EmptyResult: Retorna uma resposta vazia ao cliente, geralmente usado para ações que não têm conteúdo para retornar.
        */

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]

        /* 
         * Atributo [ResponseCache]: Usado para controlar como as respostas das ações são armazenadas em cache. No método Error, ele é configurado para não armazenar cache, garantindo que as mensagens de erro sejam sempre atualizadas.
         * Abaixo, seguem alguns exemplos de atributos de ação de uso mais comuns nos controllers:
         * [HttpGet] - Especifica que a ação responde apenas a requisições HTTP GET.
         * [HttpPost] - Indica que a ação responde apenas a requisições HTTP POST.
         * [Route] - Define a rota específica para a ação, substituindo a rota padrão gerada pelo roteamento.
         * [Authorize] - Restringe o acesso à ação apenas a usuários autenticados.
         * [ValidateAntiForgeryToken] - Protege ataques CSRF (Cross-Site Request Forgery) verificando se o token anti-falsificação foi fornecido.
         * [AllowAnonymous] - Permite acesso anônimo à ação, mesmo em uma aplicação que requer autenticação global.
         * Esses atributos oferecem controle granular sobre o comportamento das ações nos controllers, permitindo a personalização do roteamento, restrição de acesso, proteção de ataques, entre outros recursos.
         */

        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        /*
         * Quando uma exceção é lançada, o método Error é chamado automaticamente e uma instância da classe ErrorViewModel é passada para a View, contendo informações sobre o erro(ID da requisição e o identificador de rastreamento). 
         * Isso permite que a View de erro exiba informações úteis para o usuário, como mensagens de erro personalizadas, informações de rastreamento para diagnóstico e possíveis soluções para resolver o problema.
         */



    }
}
