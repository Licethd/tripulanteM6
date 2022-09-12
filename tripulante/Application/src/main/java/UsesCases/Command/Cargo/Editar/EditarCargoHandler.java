package UsesCases.Command.Cargo.Editar;

import Factories.ICargoFactory;
import Factories.ITripulanteFactory;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarCargoHandler
	implements RequestHandler<EditarCargoCommand, Cargo> {

	private ICargoFactory _cargoFactory;
	private ICargoRepository _cargoRepository;
	private IUnitOfWork _unitOfWork;

	public EditarCargoHandler(
		ICargoFactory cargoFactory,
		ICargoRepository cargoRepository,
		IUnitOfWork _unitOfWork
	) {
		this._cargoFactory = cargoFactory;
		this._cargoRepository = cargoRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public Cargo handle(EditarCargoCommand request)
		throws HttpException {
			Cargo cargo = _cargoRepository.FindByKey(
			request.cargoDto.key
		);
		if (cargo == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}
		// cargo.setSueldo(request.cargoDto.Sueldo);
		cargo.setDescripcion(request.cargoDto.Descripcion);
		_cargoRepository.Update(cargo);
		return cargo;
	}
}
