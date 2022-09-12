package UsesCases.Command.Tripulacion.Editar;

import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Factories.ITripulanteFactory;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.http.HttpStatus;
import fourteam.mediator.RequestHandler;

public class EditarTripulacionHandler
	implements RequestHandler<EditarTripulacionCommand, Tripulacion> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;
	private IUnitOfWork _unitOfWork;

	public EditarTripulacionHandler(
		ITripulacionFactory tripulacionFactory,
		ITripulacionRepository tripulacionRepository,
		IUnitOfWork _unitOfWork
	) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public Tripulacion handle(EditarTripulacionCommand request)
		throws HttpException {
			Tripulacion tripulacion = _tripulacionRepository.FindByKey(
			request.tripulacionDto.key
		);
		if (tripulacion == null) {
			throw new HttpException(
				HttpStatus.BAD_REQUEST,
				"Cargo no encontrado"
			);
		}
		// cargo.setSueldo(request.cargoDto.Sueldo);
		tripulacion.setDescripcion(request.tripulacionDto.Descripcion);
		_tripulacionRepository.Update(tripulacion);
		return tripulacion;
	}
}
