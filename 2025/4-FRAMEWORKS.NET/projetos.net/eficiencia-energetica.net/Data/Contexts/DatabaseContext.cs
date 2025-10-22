using eficiencia_energetica.net.Models;
using Microsoft.EntityFrameworkCore;
using Microsoft.EntityFrameworkCore.Infrastructure;

namespace eficiencia_energetica.net.Data.Contexts
{
    public class DatabaseContext : DbContext
    {

        public virtual DbSet<DispositivoModel> Dispositivos { get; set; }

        protected override void OnModelCreating(ModelBuilder modelBuilder)
        {
            modelBuilder.Entity<DispositivoModel>(entity => 
            {                 
                entity.ToTable("DISPOSITIVOS");
                entity.HasKey(d => d.Id);
                entity.Property(d => d.Id).HasColumnName("ID");
                entity.Property(d => d.Nome).IsRequired().HasMaxLength(100).HasColumnName("NOME");
                entity.Property(d => d.Localizacao).IsRequired().HasMaxLength(200).HasColumnName("LOCALIZACAO");
                entity.Property(d => d.Tipo).IsRequired().HasMaxLength(50).HasColumnName("TIPO");
                entity.Property(d => d.DataCadastro).IsRequired().HasColumnName("DATA_CADASTRO");
                entity.Property(d => d.DataAtualizacao).IsRequired(false).HasColumnName("DATA_ATUALIZACAO");
                entity.Property(d => d.Ativo).IsRequired().HasColumnName("ATIVO");
            });

        }

        public DatabaseContext(DbContextOptions options) : base(options)
        {
        }
        protected DatabaseContext()
        {
        }
    }

}
