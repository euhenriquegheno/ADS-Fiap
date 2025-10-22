using eficiencia_energetica.net.Data.Repository;
using eficiencia_energetica.net.Models;

namespace eficiencia_energetica.net.Services
{
    public class DispositivoService : IDispositivoService
    {
        private readonly IDispositivoRepository _repository;

        public DispositivoService(IDispositivoRepository repository)
        {
            _repository = repository;
        }

        public IEnumerable<DispositivoModel> ListarDispositivos() => _repository.GetAll();

        public DispositivoModel ObterDispositivoPorId(int id) => _repository.GetById(id);

        public void CriarDispositivo(DispositivoModel dispositivo) => _repository.Add(dispositivo);

        public void AtualizarDispositivo(DispositivoModel dispositivo) => _repository.Update(dispositivo);

        public void DeletarDispositivo(int id)
        {
            var dispositivo = _repository.GetById(id);
            if (dispositivo != null)
            {
                _repository.Delete(dispositivo);
            }
        }

    }
}
