using AutoMapper;
using eficiencia_energetica.net.Data.Contexts;
using eficiencia_energetica.net.Data.Repository;
using eficiencia_energetica.net.Models;
using eficiencia_energetica.net.Services;
using eficiencia_energetica.net.ViewModel;
using Microsoft.EntityFrameworkCore;

var builder = WebApplication.CreateBuilder(args);

// Add services to the container.
#region INICIALIZANDO O BANCO DE DADOS
var connectionString = builder.Configuration.GetConnectionString("DatabaseConnection");
builder.Services.AddDbContext<DatabaseContext>(
    opt => opt.UseOracle(connectionString).EnableSensitiveDataLogging(true)
);
#endregion

#region Repositorios
builder.Services.AddScoped<IDispositivoRepository, DispositivoRepository>();
//builder.Services.AddScoped<IRepresentanteRepository, RepresentanteRepository>();
//builder.Services.AddScoped<IPedidoRepository, PedidoRepository>();
#endregion

#region Services
builder.Services.AddScoped<IDispositivoService, DispositivoService>();
//builder.Services.AddScoped<IRepresentanteService, RepresentanteService>();
//builder.Services.AddScoped<IPedidoService, PedidoService>();
#endregion

#region AutoMapper

// Configuração do AutoMapper
var mapperConfig = new AutoMapper.MapperConfiguration(c => {
    // Permite que coleções nulas sejam mapeadas
    c.AllowNullCollections = true;
    // Permite que valores de destino nulos sejam mapeados
    c.AllowNullDestinationValues = true;

    c.CreateMap<DispositivoModel, DispositivoViewModel>();

});

// Cria o mapper com base na configuração definida
IMapper mapper = mapperConfig.CreateMapper();

// Registra o IMapper como um serviço singleton no container de DI do ASP.NET Core
builder.Services.AddSingleton(mapper);

#endregion


builder.Services.AddControllers();
// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();

app.UseAuthorization();

app.MapControllers();

app.Run();
