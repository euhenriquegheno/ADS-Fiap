using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Resources
{
    internal class OperadoresComparacao
    {
        public static void ExibirOperadoresComparacao()
        {
            Console.WriteLine("Exemplo de Operadores de comparação:");

            void Igualdade()
            {
                Console.WriteLine("Igualdade");
                int a = 1 + 2 + 3;
                int b = 6;
                Console.WriteLine(a == b);  // output: True
                char c1 = 'a';
                char c2 = 'A';
                Console.WriteLine(c1 == c2);  // output: False
                Console.WriteLine(c1 == char.ToLower(c2));  // output: True
            }

            Igualdade();

            void Desigualdade()
            {
                int a = 1 + 1 + 2 + 3;
                int b = 6;
                Console.WriteLine(a != b);  // output: True
                string s1 = "Hello";
                string s2 = "Hello";
                Console.WriteLine(s1 != s2);  // output: False
            }

            Desigualdade();

            void MenorQue()
            {
                Console.WriteLine(7.0 < 5.1);   // output: False
                Console.WriteLine(5.1 < 5.1);   // output: False
                Console.WriteLine(0.0 < 5.1);   // output: True
                Console.WriteLine(double.NaN < 5.1);   // output: False
                Console.WriteLine(double.NaN >= 5.1);  // output: False
            }

            MenorQue();

            void MaiorQue()
            {
                Console.WriteLine(7.0 > 5.1);   // output: True
                Console.WriteLine(5.1 > 5.1);   // output: False
                Console.WriteLine(0.0 > 5.1);   // output: False
                Console.WriteLine(double.NaN > 5.1);   // output: False
                Console.WriteLine(double.NaN <= 5.1);  // output: False
            }

            MaiorQue();

            void MenorOuIgual()
            {
                Console.WriteLine(7.0 <= 5.1);   // output: False
                Console.WriteLine(5.1 <= 5.1);   // output: True
                Console.WriteLine(0.0 <= 5.1);   // output: True
                Console.WriteLine(double.NaN > 5.1);   // output: False
                Console.WriteLine(double.NaN <= 5.1);  // output: False
            }

            MenorOuIgual();

            void MaiorOuIgual()
            {
                Console.WriteLine(7.0 >= 5.1);   // output: True
                Console.WriteLine(5.1 >= 5.1);   // output: True
                Console.WriteLine(0.0 >= 5.1);   // output: False
                Console.WriteLine(double.NaN < 5.1);   // output: False
                Console.WriteLine(double.NaN >= 5.1);  // output: False
            }

            MaiorOuIgual();

        }

    }
}
