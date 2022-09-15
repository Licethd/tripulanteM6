package Controllers;

import java.util.List;

import Dto.Cargo.CargoDto;
import Dto.Tripulacion.TripulacionDto;
import UsesCases.Command.Cargo.Crear.CrearCargoCommand;
import UsesCases.Command.Cargo.Editar.EditarCargoCommand;
import UsesCases.Command.Cargo.Eliminar.EliminarCargoCommand;
import UsesCases.Command.Tripulacion.Crear.CrearTripulacionCommand;
import UsesCases.Command.Tripulacion.Editar.EditarTripulacionCommand;
import UsesCases.Command.Tripulacion.Eliminar.EliminarTripulacionCommand;
import UsesCases.Queries.Cargo.GetAll.GetAllCargoQuery;
import UsesCases.Queries.Cargo.GetByKey.GetCargoByKeyQuery;
import UsesCases.Queries.Tripulacion.GetAll.GetAllTripulacionQuery;
import UsesCases.Queries.Tripulacion.GetByKey.GetTripulacionByKeyQuery;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.*;
import fourteam.http.Exception.HttpException;
import fourteam.http.annotation.*;
import fourteam.mediator.Mediator;
import fourteam.mediator.Response;

@RestController
@RequestMapping("/tripulacion")
public class TripulacionController {

    private Mediator _mediator;

    public TripulacionController(Mediator mediator) {
        this._mediator = mediator;
    }



    @GetMapping("/")
    public Response<List<Tripulacion>> getAll() throws HttpException {
        return _mediator.send(new GetAllTripulacionQuery());
    }

    @GetMapping("/{key}")
    public Response<TripulacionDto> getByKey(@PathVariable GetTripulacionByKeyQuery request) throws HttpException {
        return _mediator.send(request);
    }


    @PostMapping("/registro")
    public Response<Tripulacion> register(@RequestBody CrearTripulacionCommand tripulacion) throws HttpException {


       return _mediator.send(tripulacion);
    }

    @PutMapping("/{key}")
    public Response<Tripulacion> edit(@RequestBody TripulacionDto tripulacion, @PathVariable EditarTripulacionCommand request) throws HttpException {
        // request.cargoDto.Sueldo = cargo.getSueldo();
        request.tripulacionDto.Descripcion = tripulacion.getDescripcion();
        return _mediator.send(request);
    }

    @DeleteMapping("/{key}")
    public Response<Tripulacion> delete(@PathVariable EliminarTripulacionCommand request) throws HttpException {
        return _mediator.send(request);
    }
}
