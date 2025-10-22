using eficiencia_energetica.net.Services;
using Microsoft.AspNetCore.Mvc;
using AutoMapper;
using eficiencia_energetica.net.Models;
using eficiencia_energetica.net.Controllers;
using eficiencia_energetica.net.ViewModel;

namespace eficiencia_energetica.net.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class DispositivoController : ControllerBase
    {
        private readonly IDispositivoService _service;
        private readonly IMapper _mapper;

        public DispositivoController(IDispositivoService service, IMapper mapper)
        {
            _service = service;
            _mapper = mapper;
        }

        [HttpGet]
        public ActionResult<IEnumerable<DispositivoViewModel>> Get()
        {
            var dispositivos = _service.ListarDispositivos();
            var viewModelList = _mapper.Map<IEnumerable<DispositivoViewModel>>(dispositivos);
            return Ok(viewModelList);
        }
        [HttpGet("{id}")]
        public ActionResult<DispositivoViewModel> Get(int id)
        {
            var dispositivos = _service.ObterDispositivoPorId(id);
            if (dispositivos == null)
                return NotFound();
            var viewModel = _mapper.Map<DispositivoViewModel>(dispositivos);
            return Ok(viewModel);
        }

    }
}
