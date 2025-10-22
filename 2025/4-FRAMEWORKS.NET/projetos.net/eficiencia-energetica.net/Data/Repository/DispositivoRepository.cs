using eficiencia_energetica.net.Models;
using Microsoft.EntityFrameworkCore;
using eficiencia_energetica.net.Data.Contexts;
 using eficiencia_energetica.net.Data.Repository;

namespace eficiencia_energetica.net.Data.Repository
{
    public class DispositivoRepository : IDispositivoRepository
    {
        private readonly DatabaseContext _context;

        public DispositivoRepository(DatabaseContext context)
        {
            _context = context;
        }

        public IEnumerable<DispositivoModel> GetAll()
        {
            return _context.Dispositivos.ToList();
        }

        public DispositivoModel GetById(int id) => _context.Dispositivos.Find(id);

        public void Add(DispositivoModel dispositivo)
        {
            _context.Dispositivos.Add(dispositivo);
            _context.SaveChanges();
        }

        public void Update(DispositivoModel dispositivo)
        {
            _context.Update(dispositivo);
            _context.SaveChanges();
        }

        public void Delete(DispositivoModel dispositivo)
        {
            _context.Dispositivos.Remove(dispositivo);
            _context.SaveChanges();
        }

    }
}
