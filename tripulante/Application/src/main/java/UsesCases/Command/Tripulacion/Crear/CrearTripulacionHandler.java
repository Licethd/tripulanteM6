package UsesCases.Command.Tripulacion.Crear;

import Factories.ICargoFactory;
import Factories.ITripulacionFactory;
import Model.Tripulacion.Tripulacion;
import Model.Tripulante.Cargo;
import Repositories.ICargoRepository;
import Repositories.ITripulacionRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class CrearTripulacionHandler implements RequestHandler<CrearTripulacionCommand, Tripulacion> {

	private ITripulacionFactory _tripulacionFactory;
	private ITripulacionRepository _tripulacionRepository;
	private IUnitOfWork _unitOfWork;

	public CrearTripulacionHandler(ITripulacionFactory tripulacionFactory, ITripulacionRepository tripulacionRepository,
			IUnitOfWork _unitOfWork) {
		this._tripulacionFactory = tripulacionFactory;
		this._tripulacionRepository = tripulacionRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public Tripulacion handle(CrearTripulacionCommand request) throws HttpException {


		// Tripulacion tripulacion = _tripulacionFactory.Create(request.tripulacionDto.Descripcion,
		// 		request.tripulacionDto.Tripulantes);

		Tripulacion tripulacion = _tripulacionFactory.Create(request.tripulacionDto.Descripcion);

		tripulacion.eventCreado();

		_tripulacionRepository.Create(tripulacion);
		_unitOfWork.commit();
		return tripulacion;
	}

}
