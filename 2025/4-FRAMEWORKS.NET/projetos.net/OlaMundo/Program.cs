using OlaMundo.Resources;
using OlaMundo.Services;

public class Program
{     
    public static void Main(string[] args)
    {
        MensageriaSMS sms = new MensageriaSMS();

        Mensageria msg = new Mensageria();

        OperadoresAritmeticos.ExibirOperadoresAritmeticos();
        OperadoresComparacao.ExibirOperadoresComparacao();
        OperadoresLogicos.ExibirOperadoresLogicos();

        IfElse.ExibirIfElse();
        SwitchCase.ExibirSwitchCase();

        LoopFor.ExibirLoopFor();
        LoopWhile.ExibirLoopWhile();
        LoopDoWhile.ExibirLoopDoWhile();
        LoopForEach.ExibirLoopForEach();

        CapturaSimplesExcecao.ExecutarCapturaSimplesExcecao();
        TratamentoExcecaoEspecifica.ExecutarTratamentoExcecaoEspecifica();
        BlocoFinally.ExecutarBlocoFinally();
    }
}