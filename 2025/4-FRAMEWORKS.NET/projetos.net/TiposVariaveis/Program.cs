public class Program
{
    public static void Main(string[] args)
    {
        //Numero inteiro
        int idade = 12;

        //Numero inteiro que aceita numeração bem extensa
        long populacao = 1000000000L;

        //Numero com apenas duas casas decimais
        float salario = 1500.50f;

        //Numero com bastante casas decimais
        double valorCotaFundo = 1000.751252;

        //Numero com bastante casas decimais e separador de milhar
        decimal valorFundo = 1000.751252m;

        //Texto
        string nome = "Henrique Gheno";

        //Caractere
        char letra = 'H';

        //Booleano
        bool existe = true;

        string texto1 = "A"; //Tipo primitivo
        String texto2 = "B"; //Tipo referência

        var aleatorio1 = 'A'; // O tipo é inferido como char
        var aleatorio2 = 0; // O tipo é inferido como int


        var a = 3;
        Console.WriteLine(a); // Saída: 3
        Console.WriteLine(a++); // Saída: 3 (pós-incremento, a ainda é 3)
        Console.WriteLine(a); // Saída: 4 (agora a é incrementado para 4)

        int b = 3;
        Console.WriteLine(b); // Saída: 3
        Console.WriteLine(b--); // Saída: 3 (pós-decremento, b ainda é 3)
        Console.WriteLine(b); // Saída: 4 (b permanece 4 após o pré-incremento)

        int a1 = 1 + 2 + 3; // a1 é 6
        int b1 = 6;
        Console.WriteLine(a1 == b1); // Saída: True (a1 é igual a b1)
        Console.WriteLine(a1 != b1); // Saída: False (a1 não é diferente de b1)

        Console.WriteLine(a.GetType()); // Saída: System.Int32
    }
}