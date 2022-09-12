package UsesCases.Command.Cargo.Eliminar;

import Factories.ICargoFactory;
import Factories.ITripulanteFactory;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.HttpStatus;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class EliminarCargoHandler implements RequestHandler<EliminarCargoCommand, Cargo> {

    private ICargoFactory _cargoFactory;
    private ICargoRepository _cargoRepository;
    private IUnitOfWork _unitOfWork;

    public EliminarCargoHandler(ICargoFactory cargoFactory, ICargoRepository cargoRepository,
            IUnitOfWork _unitOfWork) {
        this._cargoFactory = cargoFactory;
        this._cargoRepository = cargoRepository;
        this._unitOfWork = _unitOfWork;
    }

    @Override
    public Cargo handle(EliminarCargoCommand request) throws HttpException {
        Cargo cargo = _cargoRepository.FindByKey(request.cargo.key);
        if (cargo == null) {
            throw new HttpException(HttpStatus.BAD_REQUEST, "Cargo no encontrado");
        }

        return _cargoRepository.Delete(cargo);

    }

}
