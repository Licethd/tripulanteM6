package UsesCases.Command.Tripulante.Crear;

import Factories.ITripulanteFactory;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import fourteam.http.Exception.HttpException;
import fourteam.mediator.RequestHandler;

public class CrearTripulanteHandler implements RequestHandler<CrearTripulanteCommand, Tripulante> {

	private ITripulanteFactory _tripulanteFactory;
	private ITripulanteRepository _tripulanteRepository;
	private IUnitOfWork _unitOfWork;

	public CrearTripulanteHandler(ITripulanteFactory tripulanteFactory, ITripulanteRepository tripulanteRepository,
			IUnitOfWork _unitOfWork) {
		this._tripulanteFactory = tripulanteFactory;
		this._tripulanteRepository = tripulanteRepository;
		this._unitOfWork = _unitOfWork;
	}

	@Override
	public Tripulante handle(CrearTripulanteCommand request) throws HttpException {

		// Tripulante tripulante =
		// _tripulanteFactory.Create(request.tripulanteDto.getNombre(),
		// request.tripulanteDto.getApellido(), request.tripulanteDto.getEmailAddress(),
		// request.tripulanteDto.getCargo());
		Tripulante tripulante = _tripulanteFactory.Create(request.tripulanteDto.Nombre, request.tripulanteDto.Apellido,
				request.tripulanteDto.EmailAddress, request.tripulanteDto.Estado, request.tripulanteDto.Tipo,
				request.tripulanteDto.HorasVuelo, request.tripulanteDto.NroMillas, request.tripulanteDto.Cargo);

		tripulante.eventCreado();

		_tripulanteRepository.Create(tripulante);
		_unitOfWork.commit();
		return tripulante;
	}

}
