using Microsoft.EntityFrameworkCore;

namespace Fiap.Web.Alunos.Data
{
    public class DatabaseContext : DbContext
    {
        public DatabaseContext(DbContextOptions options) : base(options)
        {
        }

        protected DatabaseContext()
        {
        }
    }
}
