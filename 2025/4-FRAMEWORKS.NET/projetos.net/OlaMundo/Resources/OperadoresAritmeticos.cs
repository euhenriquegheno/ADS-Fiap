using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class OperadoresAritmeticos
    {

        public static void ExibirOperadoresAritmeticos()
        {
            Console.WriteLine("Exemplo de Operadores aritméticos:");

            Console.WriteLine("Incremento e decremento");
            int i = 3;
            Console.WriteLine(i);   // output: 3
            Console.WriteLine(i++); // output: 3
            Console.WriteLine(i);   // output: 4

            int x = 3;
            Console.WriteLine(x);   // output: 3
            Console.WriteLine(x--); // output: 3
            Console.WriteLine(x);   // output: 2

            //Adicao e subtracao
            Console.WriteLine("Adição e subtração");
            Console.WriteLine(+4);     // output: 4
            Console.WriteLine(-4);     // output: -4
            Console.WriteLine(-(-4));  // output: 4
            uint a = 5;
            var b = -a;
            Console.WriteLine(b);            // output: -5
            Console.WriteLine(b.GetType());  // output: System.Int64
            Console.WriteLine(-double.NaN);  // output: NaN

            //Multiplicacao 
            Console.WriteLine("Multiplicação");
            Console.WriteLine(5 * 2);         // output: 10
            Console.WriteLine(0.5 * 2.5);     // output: 1.25
            Console.WriteLine(0.1m * 23.4m);  // output: 2.34

            //Divisao
            Console.WriteLine("Divisão");
            Console.WriteLine(13 / 5);    // output: 2
            Console.WriteLine(-13 / 5);   // output: -2
            Console.WriteLine(13 / -5);   // output: -2
            Console.WriteLine(-13 / -5);  // output: 2

            Console.WriteLine(13 / 5.0);       // output: 2.6
            int c = 13;
            int d = 5;
            Console.WriteLine((double)c / d);  // output: 2.6

            //Resto
            Console.WriteLine("Resto");
            Console.WriteLine(5 % 4);   // output: 1
            Console.WriteLine(5 % -4);  // output: 1
            Console.WriteLine(-5 % 4);  // output: -1
            Console.WriteLine(-5 % -4); // output: -1

            //Atribuição composta
            Console.WriteLine("Atribuição composta");
            int e = 5;
            e += 9;
            Console.WriteLine(e);  // output: 14
            e -= 4;
            Console.WriteLine(e);  // output: 10
            e *= 2;
            Console.WriteLine(e);  // output: 20
            e /= 4;
            Console.WriteLine(e);  // output: 5
            e %= 3;
            Console.WriteLine(e);  // output: 2
        }
    }
}
