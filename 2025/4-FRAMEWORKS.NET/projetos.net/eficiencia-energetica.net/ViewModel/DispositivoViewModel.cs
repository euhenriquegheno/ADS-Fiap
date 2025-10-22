namespace eficiencia_energetica.net.ViewModel
{
    public class DispositivoViewModel
    {

        public int DispositivoId { get; set; }
        public string? Nome { get; set; }
        public string? Localizacao { get; set; }
        public string? Tipo { get; set; } // Ex: "Medidor Inteligente", "Sensor de Presença"
        public DateTime DataCadastro { get; set; }
        public DateTime? DataAtualizacao { get; set; }
        public bool Ativo { get; set; } = true;


    }
}
