using eficiencia_energetica.net.Models;

namespace eficiencia_energetica.net.Data.Repository
{
    public interface IDispositivoRepository
    {
        IEnumerable<DispositivoModel> GetAll();
        DispositivoModel GetById(int id);
        void Add(DispositivoModel dispositivo);
        void Update(DispositivoModel dispositivo);
        void Delete(DispositivoModel dispositivo);

    }
}
