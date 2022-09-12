package UseCases.Command;

import Factories.ITripulanteFactory;
import Model.Tripulante.Cargo;
import Model.Tripulante.Tripulante;
import Repositories.ITripulanteRepository;
import Repositories.IUnitOfWork;
import UsesCases.Queries.Tripulante.GetAll.GetAllTripulanteHandler;
import UsesCases.Queries.Tripulante.GetAll.GetAllTripulanteQuery;
import fourteam.http.Exception.HttpException;
import java.util.List;
import java.util.UUID;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GetAllTripulanteHandler_Test {

	ITripulanteFactory tripulanteFactory = Mockito.mock(
		ITripulanteFactory.class
	);
	ITripulanteRepository tripulanteRepository = Mockito.mock(
		ITripulanteRepository.class
	);
	IUnitOfWork unitOfWork = Mockito.mock(IUnitOfWork.class);

	@Before
	public void setup() {}

	@Test
	public void HandleGetAll_Ok() throws HttpException {
		// creando tripulante

		Cargo cargoTest = new Cargo("asistente");

		GetAllTripulanteQuery query = new GetAllTripulanteQuery();

		GetAllTripulanteHandler handler = new GetAllTripulanteHandler(
			tripulanteRepository
		);

		List<Tripulante> listaTripulantes = handler.handle(query);
	}
}
