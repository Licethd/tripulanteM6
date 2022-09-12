package Controllers;

import java.util.List;

import Dto.Cargo.CargoDto;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Editar.EditarCargoCommand;
import UsesCases.Command.Cargo.Eliminar.EliminarCargoCommand;
import UsesCases.Queries.Cargo.GetAll.GetAllCargoQuery;
import UsesCases.Queries.Cargo.GetByKey.GetCargoByKeyQuery;
import Model.Tripulante.*;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.*;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    private Mediator _mediator;

    public CargoController(Mediator mediator) {
        this._mediator = mediator;
    }



    @GetMapping("/")
    public Response<List<Cargo>> getAll() throws HttpException {
        return _mediator.send(new GetAllCargoQuery());
    }

    @GetMapping("/{key}")
    public Response<CargoDto> getByKey(@PathVariable GetCargoByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }


    @PostMapping("/registro")
    public Response<Cargo> register(@RequestBody CrearCargoCommand cargo) throws HttpException {


       return _mediator.send(cargo);
    }

    @PutMapping("/{key}")
    public Response<Cargo> edit(@RequestBody CargoDto cargo, @PathVariable EditarCargoCommand request) throws HttpException {
        // request.cargoDto.Sueldo = cargo.getSueldo();
        request.cargoDto.Descripcion = cargo.getDescripcion();
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<Cargo> delete(@PathVariable EliminarCargoCommand request) throws HttpException {
        return _mediator.send(request);
    }
}
