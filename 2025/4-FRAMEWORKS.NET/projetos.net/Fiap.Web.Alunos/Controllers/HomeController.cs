using System.Diagnostics;
using Fiap.Web.Alunos.Models;
using Microsoft.AspNetCore.Mvc;

namespace Fiap.Web.Alunos.Controllers
{
    /* Classe HomeController: A classe Microsoft.AspNetCore.Mvc.Controller � uma classe que lida com as requisi��es HTTP.
     * A heran�a em HomeController atribui funcionalidades para tratar requisi��es e retornar respostas, como views a nossa classe HomeController. */
    public class HomeController : Controller
    {
        /* ILogger<HomeController>: O logging � essencial para monitorar e diagnosticar comportamentos da aplica��o. 
         * ILogger permite registrar logs de diferentes n�veis de severidade (informa��o, erro etc.). */
        private readonly ILogger<HomeController> _logger;

        public HomeController(ILogger<HomeController> logger)
        {
            _logger = logger;
        }

        /* Os m�todos Index e Privacy representam a��es que podem ser executadas pelo controlador. Cada m�todo corresponde a uma rota ou caminho no navegador acess�vel por uma URL. 
         * Nesse caso, os m�todos t�m como retorno uma interface IActionResult, comumente utilizada para apresentar um componente do tipo View, o qual � renderizado ao usu�rio final em HTML. */

        /* Index(): Geralmente serve como a p�gina inicial da aplica��o. */
        public IActionResult Index()
        {
            return View();
        }

        /* Privacy(): Apenas uma exemplo montado pelo scaffold para exibir uma p�gina de pol�tica de privacidade. */
        public IActionResult Privacy()
        {
            return View();
        }

        /* 
         * As a��es dos controladores do ASP.NET Core MVC (Microsoft.AspNetCore.Mvc.Controller) possuem outros tipos de retorno al�m da interface IActionResult. 
         * Abaixo, segue a lista com suas respectivas funcionalidades:
         * IActionResult: Retorna uma resposta HTTP para o cliente. Pode ser usado para retornar uma View, um JSON, um arquivo, entre outros tipos de respostas.
         * ViewResult: Retorna uma View ao cliente, representando uma p�gina HTML a ser exibida no navegador.
         * JsonResult: Retorna um objeto serializado em formato JSON ao cliente, comumente utilizado para requisi��es AJAX.
         * RedirectResult: Redireciona o cliente para outra URL especificada.
         * FileResult: Retorna um arquivo ao cliente para download.
         * ContentResult: Retorna um conte�do espec�fico ao cliente, geralmente usado para retornar texto ou XML.
         * PartialViewResult: Retorna uma parte de uma View ao cliente, �til para carregamento ass�ncrono de componentes.
         * StatusCodeResult: Retorna um c�digo de status HTTP espec�fico ao cliente, sem corpo de resposta.
         * EmptyResult: Retorna uma resposta vazia ao cliente, geralmente usado para a��es que n�o t�m conte�do para retornar.
        */

        [ResponseCache(Duration = 0, Location = ResponseCacheLocation.None, NoStore = true)]

        /* 
         * Atributo [ResponseCache]: Usado para controlar como as respostas das a��es s�o armazenadas em cache. No m�todo Error, ele � configurado para n�o armazenar cache, garantindo que as mensagens de erro sejam sempre atualizadas.
         * Abaixo, seguem alguns exemplos de atributos de a��o de uso mais comuns nos controllers:
         * [HttpGet] - Especifica que a a��o responde apenas a requisi��es HTTP GET.
         * [HttpPost] - Indica que a a��o responde apenas a requisi��es HTTP POST.
         * [Route] - Define a rota espec�fica para a a��o, substituindo a rota padr�o gerada pelo roteamento.
         * [Authorize] - Restringe o acesso � a��o apenas a usu�rios autenticados.
         * [ValidateAntiForgeryToken] - Protege ataques CSRF (Cross-Site Request Forgery) verificando se o token anti-falsifica��o foi fornecido.
         * [AllowAnonymous] - Permite acesso an�nimo � a��o, mesmo em uma aplica��o que requer autentica��o global.
         * Esses atributos oferecem controle granular sobre o comportamento das a��es nos controllers, permitindo a personaliza��o do roteamento, restri��o de acesso, prote��o de ataques, entre outros recursos.
         */

        public IActionResult Error()
        {
            return View(new ErrorViewModel { RequestId = Activity.Current?.Id ?? HttpContext.TraceIdentifier });
        }

        /*
         * Quando uma exce��o � lan�ada, o m�todo Error � chamado automaticamente e uma inst�ncia da classe ErrorViewModel � passada para a View, contendo informa��es sobre o erro(ID da requisi��o e o identificador de rastreamento). 
         * Isso permite que a View de erro exiba informa��es �teis para o usu�rio, como mensagens de erro personalizadas, informa��es de rastreamento para diagn�stico e poss�veis solu��es para resolver o problema.
         */



    }
}
