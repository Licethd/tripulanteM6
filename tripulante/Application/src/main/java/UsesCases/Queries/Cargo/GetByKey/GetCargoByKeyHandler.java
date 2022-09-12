package UsesCases.Queries.Cargo.GetByKey;

import Dto.Cargo.CargoDto;
import Dto.Tripulante.TripulanteDto;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulanteRepository;
import fourteam.http.HttpStatus;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class GetCargoByKeyHandler implements RequestHandler<GetCargoByKeyQuery, CargoDto> {

    private ICargoRepository _cargoRepository;
    public GetCargoByKeyHandler(ICargoRepository cargoRepository) {
        this._cargoRepository = cargoRepository;
    }

    @Override
    public CargoDto handle(GetCargoByKeyQuery request) throws HttpException {
        Cargo cargo = _cargoRepository.FindByKey(request.key);
        if (cargo == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Cargo no encontradooo");
        }
        CargoDto cargoDto =  new CargoDto();
        cargoDto.key = cargo.getKeyCargo();
        cargoDto.Descripcion = cargo.getDescripcion();
        return cargoDto;
    }
}
