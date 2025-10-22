using eficiencia_energetica.net.Models;

namespace eficiencia_energetica.net.Services
{
    public interface IDispositivoService
    {
        IEnumerable<DispositivoModel> ListarDispositivos();
        DispositivoModel ObterDispositivoPorId(int id);
        void CriarDispositivo(DispositivoModel cliente);
        void AtualizarDispositivo(DispositivoModel cliente);
        void DeletarDispositivo(int id);

    }
}
