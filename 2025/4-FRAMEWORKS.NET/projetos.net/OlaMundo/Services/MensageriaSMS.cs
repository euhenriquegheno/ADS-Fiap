using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace OlaMundo.Services
{
    public class MensageriaSMS
    {

        //Nome de metodos com inicial maiúsculo
        public bool EnviarMensagem(string texto)
        {
            Console.WriteLine("Enviando o SMS: " + texto);
            return true;
        }

    }
}
